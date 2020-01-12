package delhi.metro.card.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="source")
    private StationEnum source;
    @Column(name="destination")
    private StationEnum destination;
    @Column(name="startTime")
    private LocalDateTime startTime;
    @Column(name="endTime")
    private LocalDateTime endTime;
    @Column(name="balance")
    private double balance;
    @Column(name="fare")
    private double fare;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "smartCard_id", nullable = false)
    private SmartCardModel smartCard;

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

    public SmartCardModel getSmartCard() {
        return smartCard;
    }

    public void setSmartCard(SmartCardModel smartCard) {
        this.smartCard = smartCard;
    }
}
