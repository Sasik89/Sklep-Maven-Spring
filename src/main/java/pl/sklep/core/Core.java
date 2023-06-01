package pl.sklep.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sklep.authenticator.IAuthenticator;
import pl.sklep.file.IFileLoader;
import pl.sklep.gui.IGUI;
import pl.sklep.item.productbase.IProductBase;
import pl.sklep.users.IUsersBase;

import java.io.IOException;

@Component
public class Core implements ICore {
    @Autowired
    private IGUI gui;
    @Autowired
    private IProductBase productBase;
    @Autowired
    private IAuthenticator authenticator;
    @Autowired
    private IFileLoader fileLoader;
    @Autowired
    private IUsersBase userBase;
    boolean runAll = true;
    boolean run = true;

    public void start() {
        try {
            fileLoader.readDataFromFile();
        } catch (IOException e) {
            System.out.println("Baza danych jest źle sformatowana !!");
            return;
        }
        do {
            menuLoop:
            switch (gui.showMenu()) {
                case "1":
                    userBase.addLoginAndPassword();
                    break;
                case "2":
                    run = authenticator.authenticator(userBase.getUsers());
                    while (run) {
                        if (authenticator.getLoggedInUserRole().equalsIgnoreCase("user")) {
                            switch (gui.showUserMenu()) {
                                case "1":
                                    gui.listUserItems(productBase.getProducts());
                                    break;
                                case "2":
                                    productBase.buySth();
                                    break;
                                case "3":
                                    try {
                                        fileLoader.saveDataToFile();
                                        run = false;
                                    } catch (IOException e) {
                                        System.out.println("Błąd bazy danych !!");
                                    }
                                    break menuLoop;
                                default:
                                    System.out.println("Podałeś zły numer");
                                    break;
                        }
                    }
                        else if(authenticator.getLoggedInUserRole().equalsIgnoreCase("admin")) {
                            switch (gui.showAdminMenu()) {
                                case "1":
                                    gui.listAdminItems(productBase.getProducts());
                                    break;
                                case "2":
                                    productBase.buySth();
                                    break;
                                case "3":
                                    productBase.addNewRTVorAGD();
                                    break;
                                case "4":
                                    productBase.increaseProductQuantity();
                                    break;
                                case "5":
                                    userBase.setUserRole();
                                    break;
                                case "6":
                                    try {
                                        fileLoader.saveDataToFile();
                                        run = false;
                                    } catch (IOException e) {
                                        System.out.println("Błąd bazy danych !!");
                                    }
                                    break menuLoop;
                                default:
                                    System.out.println("Podałeś zły numer");
                                    break;
                            }
                        }
                    }
                    break;

                case "3":
                    runAll = false;
                    break;
                default:
                    System.out.println("Podałeś zły numer");

            }

        }
        while (runAll);
    }

}
