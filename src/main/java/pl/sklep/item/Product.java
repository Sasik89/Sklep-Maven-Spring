package pl.sklep.item;

import pl.sklep.item.product.Writable;

public class Product implements Writable {

    private String name;
    private int number;
    private int cost;

    public Product(String name, int cost, int number) {
        this.name = name;
        this.number = number;
        this.cost = cost;
    }

    public Product(String[] vars){
        this(vars[0],Integer.parseInt(vars[1]), Integer.parseInt(vars[2]));
    }

//
//    public Product(String[] vars) {
//        this(vars[0], vars[1], vars[2]);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String toCSV(){
        return new StringBuilder().append(getClass().getSimpleName())
                .append(";")
                .append(this.name)
                .append(";")
                .append(this.cost)
                .append(";")
                .append(this.number).toString();
    }
}