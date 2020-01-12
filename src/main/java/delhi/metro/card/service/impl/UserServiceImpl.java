package delhi.metro.card.service.impl;

import delhi.metro.card.dao.UserRepository;
import delhi.metro.card.models.SmartCardModel;
import delhi.metro.card.models.UserModel;
import delhi.metro.card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserModel getUser(String userId) {
        return userRepository.getOne(Long.parseLong(userId));
    }

    @Override
    public void setActive(UserModel user, Boolean flag) {
        user.setActive(flag);
        userRepository.save(user);
    }

    @Override
    public void createUser(UserModel userModel) {
        userRepository.save(userModel);
    }

}