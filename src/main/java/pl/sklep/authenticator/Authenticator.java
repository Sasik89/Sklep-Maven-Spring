package pl.sklep.authenticator;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sklep.gui.IGUI;
import pl.sklep.users.Users;

import java.util.Collection;

;

@Component
public class Authenticator implements IAuthenticator {

    @Autowired
    private IGUI gui;
    private final String SEED = "Ba7gPOCX3l4Kjd6PlgbT8^%XZGRia8LI";
    private String loggedInUserRole;

        public boolean authenticator(Collection<Users> users) {
            int counter = 0;
            while (counter < 3) {
                String userLogin = gui.Login();
                String hashedUserPassword = DigestUtils.md5Hex(gui.Password() + SEED);
                for (Users user : users) {
                    if (userLogin.equals(user.getLogin()) && hashedUserPassword.equals(user.getPassword())) {
                        System.out.println("\nZalogowano.\n");
                        loggedInUserRole = user.getUserRole();
                        return true;
                    }
                }
                System.out.println("\nNiepoprawny login lub hasło\n");
                counter++;
            }
            System.out.println("Osiągnąłeś maksymalną liczbę prób logowania.\n");
            return false;
        }

        public void check(boolean result) {
            if (result) {
                System.out.println("Wprowadziłeś poprawny login i hasło");
            } else {
                System.out.println("Wprowadziłeś zły login lub hasło");
            }
        }

    public String getLoggedInUserRole() {
        return loggedInUserRole;
    }
}

