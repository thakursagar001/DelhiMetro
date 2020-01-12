package delhi.metro.card.dto;

import delhi.metro.card.models.StationEnum;

import java.util.List;

public class StationDTO {

    StationEnum stationName;

    List<TransactionDTO> swipeIn;

    List<TransactionDTO> swipeOut;

    public StationEnum getStationName() {
        return stationName;
    }

    public void setStationName(StationEnum stationName) {
        this.stationName = stationName;
    }

    public List<TransactionDTO> getSwipeIn() {
        return swipeIn;
    }

    public void setSwipeIn(List<TransactionDTO> swipeIn) {
        this.swipeIn = swipeIn;
    }

    public List<TransactionDTO> getSwipeOut() {
        return swipeOut;
    }

    public void setSwipeOut(List<TransactionDTO> swipeOut) {
        this.swipeOut = swipeOut;
    }
}
