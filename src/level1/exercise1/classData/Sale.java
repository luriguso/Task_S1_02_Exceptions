package level1.exercise1.classData;


import level1.exercise1.exceptions.EmptySaleException;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> products;
    private double total_price;

    public Sale() {
        this.products = new ArrayList<Product>();
        this.total_price = 0.0;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public double calculateTotal() throws EmptySaleException {
        if(products.isEmpty()){
            throw new EmptySaleException("To make a sale you must first add products");
        }
        double total = 0;

        for(Product product : products){
            total += product.getPrice();
        }
        this.total_price = total;
        return this.total_price;
    }
}
