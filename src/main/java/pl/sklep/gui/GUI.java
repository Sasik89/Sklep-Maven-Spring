package pl.sklep.gui;

import org.springframework.stereotype.Component;
import pl.sklep.item.Product;
import pl.sklep.item.product.AGD;
import pl.sklep.item.product.RTV;
import pl.sklep.users.Users;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

@Component
public class GUI implements IGUI {
    Scanner scanner = new Scanner(System.in);

    public String showMenu() {
        System.out.println("1. Zarejestruj");
        System.out.println("2. Zaloguj");
        System.out.println("3. Wyjdź");
        return scanner.nextLine();
    }

    public String showUserMenu() {
        System.out.println("1. Wyświetl listę zakupów");
        System.out.println("2. Kup");
        System.out.println("3. Wyloguj i zapisz");
        return scanner.nextLine();
    }

    public String showAdminMenu() {
        System.out.println("1. Wyświetl listę zakupów");
        System.out.println("2. Kup");
        System.out.println("3. Dodaj produkt");
        System.out.println("4. Uzupełnij produkt");
        System.out.println("5. Zmień rolę");
        System.out.println("6. Wyloguj i zapisz");
        return scanner.nextLine();
    }

    public String addName() {
        System.out.println("Podaj nazwę przedmiotu");
        return scanner.nextLine();
    }

    public int addNumberOfItem() {
        System.out.println("Podaj liczbę przedmiotu");
        return  Integer.parseInt(scanner.nextLine());
    }

    public int addCost() {
        System.out.println("Podaj cene przedmiotu");
        return Integer.parseInt(scanner.nextLine());
    }

    public boolean internetAcces() {
        System.out.println("Czy posiada dostęp do internetu, tak/nie");
        String have = scanner.nextLine();
        if (have.equals("tak")) {
            return true;
        }
        return false;
    }

    public boolean isBig() {
        System.out.println("Czy jest to produkt ponadgabarytowy, tak/nie");
        String isBig = scanner.nextLine();
        if (isBig.equals("tak")) {
            return true;
        }
        return false;
    }

    public String askForProductName(){
        System.out.println("Podaj nazwę produktu którego ilość chcesz zwiększyć:");
        return scanner.nextLine();
    }

    public int askForProductQuantity(){
        System.out.println("Podaj liczbę o której wartość chcesz zwiększyć ilość wybranego produktu:");
        return Integer.parseInt(scanner.nextLine());
    }

    public void listUserItems(List<Product> productList) {
        for (Product product : productList) {
            if (product.getClass().getName().equals(RTV.class.getName()) && product.getNumber()>0) {  //instrukcja sprawdza między innymi czy produktów jest więcej niż 0, jeśli nie to ich nie wyświetla
                RTV rtv = (RTV) product;   //rzutowanie, przypisanie obiektu rtv do product
                System.out.println(new StringBuilder()
                        .append("Nazwa produktu: ")
                        .append(product.getName())
                        .append(" Liczba sztuk: ")
                        .append(product.getNumber())
                        .append(" Cena jednostkowa: ")
                        .append(product.getCost())
                        .append(" Czy ma dostęp do Wi-fi: ")
                        .append(rtv.ishasWiFIacces()));
            } else if (product.getClass().getName().equals(AGD.class.getName()) && product.getNumber()>0) {
                AGD agd = (AGD) product; //rzutowanie, przypisanie obiektu agd do product
                System.out.println(new StringBuilder()
                        .append("Nazwa produktu: ")
                        .append(product.getName())
                        .append(" Liczba sztuk: ")
                        .append(product.getNumber())
                        .append(" Cena jednostkowa: ")
                        .append(product.getCost())
                        .append(" Czy produkt jest wielkogabarytowy: ")
                        .append(agd.isBig()));
            }
        }
    }
    public void listAdminItems(List<Product> productList) {
        for (Product product : productList) {
            if (product.getClass().getName().equals(RTV.class.getName())) {
                RTV rtv = (RTV) product;   //rzutowanie, przypisanie obiektu rtv do product
                System.out.println(new StringBuilder()
                        .append("Nazwa produktu: ")
                        .append(product.getName())
                        .append(" Liczba sztuk: ")
                        .append(product.getNumber())
                        .append(" Cena jednostkowa: ")
                        .append(product.getCost())
                        .append(" Czy ma dostęp do Wi-fi: ")
                        .append(rtv.ishasWiFIacces()));
            } else if (product.getClass().getName().equals(AGD.class.getName())) {
                AGD agd = (AGD) product; //rzutowanie, przypisanie obiektu agd do product
                System.out.println(new StringBuilder()
                        .append("Nazwa produktu: ")
                        .append(product.getName())
                        .append(" Liczba sztuk: ")
                        .append(product.getNumber())
                        .append(" Cena jednostkowa: ")
                        .append(product.getCost())
                        .append(" Czy produkt jest wielkogabarytowy: ")
                        .append(agd.isBig()));
            }
        }
    }

    public void listUsers(Collection<Users> usersList){
        System.out.println("Lista zarejestrowanych użytkowników:");
        for(Users user: usersList){
            System.out.println(
                    "Login: " +
                    user.getLogin() +
                    " Role: " +
                    user.getUserRole()
            );
        }
        System.out.println();
    }

    public String askForLoginToChangeTheRoleOf(){
        System.out.println("Podaj login użytkownika którego rolę chcesz zmienić:");
        return scanner.nextLine();
    }

    public String askForRoleToChange(String currentUserRole){
        String userChoice;
        if (currentUserRole.equalsIgnoreCase("user")){
            System.out.println("Zmienić rolę użytkownika z " + "USER na ADMIN?, tak/nie:" );
            userChoice = scanner.nextLine();
            if(userChoice.equals("tak")) return "ADMIN";
            else if(userChoice.equals("nie")) return "USER";
            else {
                System.out.println("Wybrano błędną opcję");
                return "USER";
            }
        }
        else {
            System.out.println("Zmienić rolę użytkownika z " + "ADMIN na USER?, tak/nie:" );
            userChoice = scanner.nextLine();
            if(userChoice.equals("tak")) return "USER";
            else if(userChoice.equals("nie")) return "ADMIN";
            else {
                System.out.println("Wybrano błędną opcję");
                return "ADMIN";
            }
        }
        }

    public void usernameAlreadyTaken(){
        System.out.println("Użytkownik o takim loginie jest już zarejrestrowany!");
    }

    public String addLogin() {
        System.out.println("Podaj login który chcesz zarejestrować");
        return scanner.nextLine();
    }

    public String addPassword() {
        System.out.println("Podaj hasło które wprowadzić");
        return scanner.nextLine();
    }

    public String addRole() {
        System.out.println("Podaj role którą wprowadzić");
        return scanner.nextLine();
    }

    public String Login() {
        System.out.println("Podaj login: ");
        return scanner.nextLine();
    }

    public String Password() {
        System.out.println("Podaj hasło: ");
        return scanner.nextLine();
    }
    
}
