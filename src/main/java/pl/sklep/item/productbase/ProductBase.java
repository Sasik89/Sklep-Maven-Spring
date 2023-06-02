package pl.sklep.item.productbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sklep.gui.IGUI;
import pl.sklep.item.Product;
import pl.sklep.item.product.AGD;
import pl.sklep.item.product.RTV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ProductBase implements IProductBase {

    List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    @Autowired
    private IGUI gui;

    public void addNewRTVorAGD() {
        System.out.println("Chcesz dodać RTV czy AGD?");
        String choice = scanner.next();
        if (choice.equals("RTV"))
            products.add(new RTV(gui.addName(), gui.addNumberOfItem(), gui.addCost(), gui.internetAcces()));
        else {
            products.add(new AGD(gui.addName(), gui.addNumberOfItem(), gui.addCost(), gui.isBig()));
        }
    }

    public void varsAddNewRTV(String[] vars) {
        products.add(new RTV(vars));
    }

    public void varsAddNewAGD(String[] vars) {
        products.add(new AGD(vars));
    }

    public void increaseProductQuantity() {
        String productName = gui.askForProductName();
        boolean changedQuantity = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.setNumber(product.getNumber() + gui.askForProductQuantity());
                changedQuantity = true;
                System.out.println("\nPomyślne zmieniono ilość wybranego produktu");

            }
            if (!changedQuantity) {
                System.out.println("Nie udało się znaleźć produktu o podanej nazwie");
            }
        }
    }

    public void buySth() {
        System.out.println("Podaj nazwę produktu: ");
        String name = scanner.next();
        System.out.println("Podaj liczbę produktów: ");
        int liczba = scanner.nextInt();
        boolean buy = false;
        for (Product item : products) {
            if (item.getName().equals(name) && item.getNumber() >= liczba) {
                item.setNumber(item.getNumber() - liczba); //ustawiłem by zmniejszył liczbę produktów o wartość kupionych produktów
                System.out.println("Masz do zapłaty " + liczba * item.getCost());
                buy = true; //zmienna powoduje ze jeśli jest false to poza pętlą wyświetla się komunikac iż nie udało sie kupic produktu
                break;
            }
        }
        if (!buy) {
            System.out.println("Nie udało się kupić produktu");
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
