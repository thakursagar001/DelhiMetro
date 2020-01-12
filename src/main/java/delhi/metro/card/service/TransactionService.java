package delhi.metro.card.service;

import delhi.metro.card.models.SmartCardModel;
import delhi.metro.card.models.TransactionModel;
import delhi.metro.card.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {

    TransactionModel createSwipeInTransaction(String station, SmartCardModel smartCardModel);
    void createSwipeOutTransaction(String station, SmartCardModel smartCardModel) throws Exception;
    List<TransactionModel> swipeInTransactions(String station);
    List<TransactionModel> swipeOutTransactions(String station);
}
