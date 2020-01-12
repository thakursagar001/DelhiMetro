package delhi.metro.card.dto;

import java.util.ArrayList;
import java.util.List;

public class SmartCardDTO {

    private UserDTO user;
    private List<TransactionDTO> transactions = new ArrayList<>();
    private double balance;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
