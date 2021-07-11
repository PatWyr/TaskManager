package Repository;

import Model.User;

public interface UserRepository {
    void saveUser();
    void deleteUser();
    User findUser(String login);
}
