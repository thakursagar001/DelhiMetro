package delhi.metro.card.service.impl;

import delhi.metro.card.dto.StationDTO;
import delhi.metro.card.dto.TransactionDTO;
import delhi.metro.card.models.SmartCardModel;
import delhi.metro.card.models.StationEnum;
import delhi.metro.card.models.TransactionModel;
import delhi.metro.card.models.UserModel;
import delhi.metro.card.service.MetroService;
import delhi.metro.card.service.SmartCardService;
import delhi.metro.card.service.TransactionService;
import delhi.metro.card.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class MetroserviceImpl implements MetroService {

    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    SmartCardService smartCardService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void swipeIn(String cardId, String station) throws Exception {
        SmartCardModel smartCardModel = smartCardService.getSmartCard(cardId);
        if(null == smartCardModel){
            throw new Exception("Incorrect Smart Card Id");
        }
        UserModel userModel = smartCardModel.getUser();
        if(null != userModel && userModel.getActive()){
            throw new Exception("User has already Swipe in");
        }
        if(smartCardModel.getBalance()<50){
            throw new Exception("Insufficient Balance");
        }
        userService.setActive(userModel,true);
        TransactionModel transactionModel = transactionService.createSwipeInTransaction(station, smartCardModel);
        smartCardService.setTransaction(smartCardModel,transactionModel);
    }

    @Override
    public void swipeOut(String cardId, String station) throws Exception {
        SmartCardModel smartCardModel = smartCardService.getSmartCard(cardId);
        if(null == smartCardModel){
            throw new Exception("Incorrect Smart Card Id");
        }
        UserModel userModel = smartCardModel.getUser();
        if(null != userModel && !userModel.getActive()){
            throw new Exception("User has not Swiped in");
        }
        userService.setActive(userModel, false);
        transactionService.createSwipeOutTransaction(station, smartCardModel);

    }

    @Override
    public StationDTO getStationDetails(String station) {
        List<TransactionModel> swipeIns = transactionService.swipeInTransactions(station);

        List<TransactionModel> swipeOuts = transactionService.swipeOutTransactions(station);

        StationDTO stationDTO = new StationDTO();
        stationDTO.setStationName(StationEnum.valueOf(station));
        Type swipeInType = new TypeToken<List<TransactionDTO>>() {}.getType();
        Type swipeOutType = new TypeToken<List<TransactionDTO>>() {}.getType();
        stationDTO.setSwipeIn(modelMapper.map(swipeIns, swipeInType));
        stationDTO.setSwipeOut(modelMapper.map(swipeOuts, swipeOutType));
        return stationDTO;
    }
}
