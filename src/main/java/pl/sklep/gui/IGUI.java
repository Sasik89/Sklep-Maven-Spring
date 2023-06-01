package pl.sklep.gui;

import pl.sklep.item.Product;
import pl.sklep.users.Users;

import java.util.Collection;
import java.util.List;

public interface IGUI {
    String showMenu();

    String showUserMenu();

    String showAdminMenu();

    String addName();

    int addNumberOfItem();

    int addCost();

    boolean internetAcces();

    boolean isBig();

    void listUserItems(List<Product> productList);

    void listAdminItems(List<Product> productList);

    String addLogin();

    String addPassword();

    String Login();

    String Password();

    String addRole();

    String askForProductName();

    int askForProductQuantity();

    public void listUsers(Collection<Users> usersList);

    public String askForLoginToChangeTheRoleOf();

    public String askForRoleToChange(String currentUserRole);

    public void usernameAlreadyTaken();

}
