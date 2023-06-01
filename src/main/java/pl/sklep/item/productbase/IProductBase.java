package pl.sklep.item.productbase;

import pl.sklep.item.Product;

import java.util.List;

public interface IProductBase {
    public void addNewRTVorAGD();
    public void buySth();
    public List<Product> getProducts();
    public void varsAddNewRTV(String[] vars);
    public void varsAddNewAGD(String[] vars);
    public void increaseProductQuantity();

}
