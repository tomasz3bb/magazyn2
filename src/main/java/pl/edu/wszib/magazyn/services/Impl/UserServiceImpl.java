package pl.edu.wszib.magazyn.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.magazyn.DAO.IUserDAO;
import pl.edu.wszib.magazyn.model.User;
import pl.edu.wszib.magazyn.model.view.RegistrationModel;
import pl.edu.wszib.magazyn.services.IUserService;
import pl.edu.wszib.magazyn.session.SessionObject;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(User user) {
        User userFromDatabase = this.userDAO.getUserByLogin(user.getLogin());
        if (userFromDatabase == null){
            return;
        }
        if (user.getPass().equals(userFromDatabase.getPass())){
            this.sessionObject.setLoggedUser(userFromDatabase);
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setLoggedUser(null);
    }

    @Override
    public boolean register(RegistrationModel registrationModel) {
        if(this.userDAO.getUserByLogin(registrationModel.getLogin()) != null) {
            return false;
        }
        User newUser = new User(0, registrationModel.getLogin(), registrationModel.getPass(), User.Role.USER);
        return this.userDAO.persistUser(newUser);
    }
}
