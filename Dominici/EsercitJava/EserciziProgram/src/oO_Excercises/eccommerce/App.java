package oO_Excercises.eccommerce;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        System.out.println("Start ecommerce test.....");

        Product p = new Product("caffè", 12);

        Storage storage = new Storage();

        storage.load(new Product("caffè", 2), 100);
        storage.load(new Product("zucchero", 3), 200);
        storage.load(new Product("latte", 2.5f), 12);
        storage.load(new Product("fette biscottate", 4.5f), 50);

        storage.logStatus();
        Set<Product> foundProducts = storage.findByName("caffè");
        System.out.println(foundProducts);

        //p.setName("zucchero");
        //p.setPrice (2);
        //System.out.println(p);

        //p.setName(null); - genera errore!
        //System.out.println(p);
    }







}
