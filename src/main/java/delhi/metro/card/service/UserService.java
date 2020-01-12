package delhi.metro.card.service;

import delhi.metro.card.models.UserModel;

public interface UserService {

    UserModel getUser(String userId);

    void setActive(UserModel user, Boolean flag);

    void createUser(UserModel userModel);
}
