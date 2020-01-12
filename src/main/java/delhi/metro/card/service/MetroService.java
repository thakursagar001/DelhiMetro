package delhi.metro.card.service;


import delhi.metro.card.dto.StationDTO;

public interface MetroService {

    void swipeIn(String cardId, String station) throws Exception;

    void swipeOut(String userId, String station) throws Exception;

    StationDTO getStationDetails(String station);
}
