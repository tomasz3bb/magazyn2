package pl.edu.wszib.magazyn.database.impl;

import org.springframework.stereotype.Component;
import pl.edu.wszib.magazyn.database.IUsersRepository;
import pl.edu.wszib.magazyn.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersRepositoryImpl implements IUsersRepository {
    private final List<User> users = new ArrayList<>();

    public UsersRepositoryImpl() {
        this.users.add(new User("admin", "admin"));
    }

    @Override
    public User authenticate(User user) {
        for(User userFormDatabase : this.users) {
            if(userFormDatabase.getLogin().equals(user.getLogin())
                    && userFormDatabase.getPass().equals(user.getPass())) {
                return userFormDatabase;
            }
        }

        return null;
    }
}
