package Repository;

import Model.User;

public interface UserRepository {
    void saveUser(User user);
    void deleteUser();
    User findUser(String login);
}
