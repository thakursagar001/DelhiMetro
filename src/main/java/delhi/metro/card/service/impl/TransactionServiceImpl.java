package delhi.metro.card.service.impl;

import delhi.metro.card.dao.TransactionRepository;
import delhi.metro.card.factory.FareCalculationFactory;
import delhi.metro.card.models.SmartCardModel;
import delhi.metro.card.models.StationEnum;
import delhi.metro.card.models.TransactionModel;
import delhi.metro.card.service.SmartCardService;
import delhi.metro.card.service.TransactionService;
import delhi.metro.card.strategy.FareCalculationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    SmartCardService smartCardService;

    @Override
    public TransactionModel createSwipeInTransaction(String station, SmartCardModel smartCardModel) {
        StationEnum stationEnum= null;
        try{
            stationEnum = StationEnum.valueOf(station);
        }catch(IllegalArgumentException e){
            logger.error("Incorrect station name passed");
        }
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setSource(stationEnum);
        LocalDateTime startTime = LocalDateTime.now();
        transactionModel.setStartTime(startTime);
        transactionModel.setSmartCard(smartCardModel);
        transactionModel.setBalance(smartCardModel.getBalance());
        transactionRepository.save(transactionModel);
        return transactionModel;
    }

    @Override
    public void createSwipeOutTransaction(String station, SmartCardModel smartCard) throws Exception {
        StationEnum stationEnum= null;
        try{
            stationEnum = StationEnum.valueOf(station);
        }catch(IllegalArgumentException e){
            logger.error("Incorrect station name passed");
        }
        if(smartCard.getTransactions().size()>0){
            TransactionModel transactionModel = smartCard.getTransactions().get(smartCard.getTransactions().size()-1);
            if(null != transactionModel.getDestination()){
                throw  new Exception("Illegal Swipeout");
            }
            else{
                transactionModel.setDestination(stationEnum);
                Integer distance = Math.abs(transactionModel.getDestination().ordinal() - transactionModel.getSource().ordinal());
                FareCalculationStrategy fareCalculationStrategy = FareCalculationFactory.getStrategy(LocalDateTime.now());
                Double farePerStation = fareCalculationStrategy.getFare();
                Double fare = farePerStation * distance;
                transactionModel.setFare(fare);
                transactionModel.setEndTime(LocalDateTime.now());
                transactionRepository.save(transactionModel);
                smartCardService.deductbalance(smartCard,fare);
            }
        }else{
            throw  new Exception("Card has not been used yet");
        }

    }

    @Override
    public List<TransactionModel> swipeInTransactions(String station) {
        return transactionRepository.findBySource(StationEnum.valueOf(station));
    }

    @Override
    public List<TransactionModel> swipeOutTransactions(String station) {
        return transactionRepository.findByDestination(StationEnum.valueOf(station));
    }
}
