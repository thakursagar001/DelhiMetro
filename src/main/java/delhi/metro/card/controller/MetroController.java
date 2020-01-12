package delhi.metro.card.controller;

import delhi.metro.card.dto.SmartCardDTO;
import delhi.metro.card.dto.StationDTO;
import delhi.metro.card.dto.UserDTO;
import delhi.metro.card.models.SmartCardModel;
import delhi.metro.card.models.UserModel;
import delhi.metro.card.service.MetroService;
import delhi.metro.card.service.SmartCardService;
import delhi.metro.card.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metro")
public class MetroController {

    @Autowired
    MetroService metroService;

    @Autowired
    UserService userService;

    @Autowired
    SmartCardService smartCardService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/swipein/{cardId}/{station}")
    @ResponseStatus(HttpStatus.CREATED)
    public void swipeIn(@PathVariable String cardId, @PathVariable String station) throws Exception {
        metroService.swipeIn(cardId, station);
    }

    @PostMapping("/swipeout/{cardId}/{station}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void swipeOut(@PathVariable String cardId, @PathVariable String station) throws Exception {
        metroService.swipeOut(cardId, station);
    }

    @PostMapping("/registeruser")
    public void registerUser(@RequestBody UserDTO user){
        userService.createUser(modelMapper.map(user,UserModel.class));
    }

    @PostMapping("/registerCard/{userId}")
    public void registerSmartCard(@PathVariable String userId, @RequestBody SmartCardDTO smartCardDTO){
        smartCardService.registerCard(userId, modelMapper.map(smartCardDTO, SmartCardModel.class));
    }

    @PostMapping("/carddetail/{cardId}")
    public SmartCardDTO getCardDetail(@PathVariable String cardId){
        SmartCardModel smartCard =  smartCardService.getSmartCard(cardId);
        return modelMapper.map(smartCard, SmartCardDTO.class);
    }

    @PostMapping("/stationdetail/{station}")
    public StationDTO getStationDetails(@PathVariable String station){
        return metroService.getStationDetails(station);
    }

    @PostMapping("/recharge/{cardId}/{balance}")
    public void rechargeCard(@PathVariable String cardId, @PathVariable String balance){
        smartCardService.rechargeCard(cardId, balance);
    }
}
