package pl.sklep.users;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sklep.gui.IGUI;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class UsersBase implements IUsersBase {

    private final String SEED = "Ba7gPOCX3l4Kjd6PlgbT8^%XZGRia8LI";

    Map<String,Users> users = new HashMap<>();
    @Autowired
    private IGUI gui;

    public void addLoginAndPassword(){
        String userLogin = gui.addLogin();
        boolean usernameAlreadyTaken = false;
        for(Users user : users.values()){
            if(user.getLogin().equals(userLogin)){
                gui.usernameAlreadyTaken();
                usernameAlreadyTaken = true;
                break;
            }
        }
        if(!usernameAlreadyTaken) {
            users.put(userLogin, new Users(userLogin, DigestUtils.md5Hex(gui.addPassword() + SEED),"USER"));
        }
    }

    public void addUser(String[] vars){
        users.put(vars[0] ,new Users(vars[0],vars[1],vars[2]));
    }

    public Collection<Users> getUsers() {
        return users.values();
    }

    public void setUsers(Map<String,Users> users) {
        this.users = users;
    }

    public void setUserRole() {
        gui.listUsers(users.values());
        String userLoginToChangeRoleOf = gui.askForLoginToChangeTheRoleOf();
        try {
            users.get(userLoginToChangeRoleOf).setUserRole(
                    gui.askForRoleToChange(users.get(userLoginToChangeRoleOf).getUserRole())
            );
        }catch (NullPointerException e){
            System.out.println("Nie ma użytkownika o takim loginie");
        }

    }

}
