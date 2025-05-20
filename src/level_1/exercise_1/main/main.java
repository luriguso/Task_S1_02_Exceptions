package level_1.exercise_1.main;

import level_1.exercise_1.classData.Product;
import level_1.exercise_1.classData.Sale;

public class main {
    public static void main(String[] args) {
        Product product = new Product("Orange", 1.05);
        Product product2 = new Product("Apple", 2.50);
        Product product3 = new Product("Water", 3.40);

        Sale newSale = new Sale();
        newSale.add_product(product);
        try{
            System.out.println("calculating the total sale price");

            double price_total = newSale.calculate_total();
            System.out.println("Total sale price: " + price_total);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            System.out.println("Total sale price calculated");
        }
    }

}
