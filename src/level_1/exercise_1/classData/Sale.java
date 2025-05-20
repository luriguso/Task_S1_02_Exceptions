package level_1.exercise_1.classData;


import level_1.exercise_1.exceptions.Empty_sale_exception;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> products;
    private double total_price;

    public Sale() {
        this.products = new ArrayList<Product>();
        this.total_price = 0.0;
    }

    public void add_product(Product product) {
        this.products.add(product);
    }

    public double calculate_total() throws Empty_sale_exception {
        if(products.isEmpty()){
            throw new Empty_sale_exception("To make a sale you must first add products");
        }
        double total = 0;

        for(Product product : products){
            total += product.getPrice();
        }
        this.total_price = total;
        return this.total_price;
    }
}
