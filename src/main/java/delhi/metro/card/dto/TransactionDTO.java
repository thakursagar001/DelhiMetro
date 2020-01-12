package delhi.metro.card.dto;

import delhi.metro.card.models.StationEnum;

import java.time.LocalDateTime;

public class TransactionDTO {

    private long id;
    private StationEnum source;
    private StationEnum destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double balance;
    private double fare;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StationEnum getSource() {
        return source;
    }

    public void setSource(StationEnum source) {
        this.source = source;
    }

    public StationEnum getDestination() {
        return destination;
    }

    public void setDestination(StationEnum destination) {
        this.destination = destination;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
