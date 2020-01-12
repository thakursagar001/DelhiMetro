package delhi.metro.card.service;

import delhi.metro.card.models.SmartCardModel;
import delhi.metro.card.models.TransactionModel;

public interface SmartCardService {

    SmartCardModel getSmartCard(String cardId);

    void setTransaction(SmartCardModel smartCardModel, TransactionModel transactionModel);

    void deductbalance(SmartCardModel smartCardModel, Double fare);

    void rechargeCard(String cardId, String balance);

    void registerCard(String userId, SmartCardModel smartCardModel);
}
