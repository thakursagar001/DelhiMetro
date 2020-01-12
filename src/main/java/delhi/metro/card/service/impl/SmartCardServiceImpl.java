package delhi.metro.card.service.impl;

import delhi.metro.card.dao.SmartCardRepository;
import delhi.metro.card.models.SmartCardModel;
import delhi.metro.card.models.TransactionModel;
import delhi.metro.card.models.UserModel;
import delhi.metro.card.service.SmartCardService;
import delhi.metro.card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartCardServiceImpl implements SmartCardService {

    @Autowired
    SmartCardRepository smartCardRepository;

    @Autowired
    UserService userService;


    @Override
    public SmartCardModel getSmartCard(String cardId) {
        return smartCardRepository.getOne(Long.parseLong(cardId));
    }

    @Override
    public void setTransaction(SmartCardModel smartCardModel, TransactionModel transactionModel) {
        List<TransactionModel> transactionModelList = smartCardModel.getTransactions();
        transactionModelList.add(transactionModel);
        smartCardModel.setTransactions(transactionModelList);
        smartCardRepository.save(smartCardModel);
    }

    @Override
    public void deductbalance(SmartCardModel smartCardModel, Double fare) {
        smartCardModel.setBalance(smartCardModel.getBalance()-fare);
        smartCardRepository.save(smartCardModel);
    }

    @Override
    public void rechargeCard(String cardId, String balance) {
        SmartCardModel smartCard = smartCardRepository.getOne(Long.parseLong(cardId));
        smartCard.setBalance(smartCard.getBalance() + Double.parseDouble(balance));
        smartCardRepository.save(smartCard);
    }

    @Override
    public void registerCard(String userId, SmartCardModel smartCardModel) {
        UserModel userModel = userService.getUser(userId);
        smartCardModel.setUser(userModel);
        smartCardRepository.save(smartCardModel);
    }


}
