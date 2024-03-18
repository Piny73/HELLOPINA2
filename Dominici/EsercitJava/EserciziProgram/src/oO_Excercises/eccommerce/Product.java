package oO_Excercises.eccommerce;

import java.util.UUID;

public class Product {

    private String cod;
    private String name;
    private float price;

    public Product(String name, float price) {
        this.cod = UUID.randomUUID().toString(); // codice univoco
        // validazione dellìoggetto creato
        setName(name);
        setPrice(price);
        this.name = name;
        this.price = price;
    }

    public String getCod() {
        return cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name is empty");
        }
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price<= 0) {
            throw new IllegalArgumentException("price not value");
        }
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cod == null) ? 0 : cod.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (cod == null) {
            if (other.cod != null)
                return false;
        } else if (!cod.equals(other.cod))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [cod=" + cod + ", name=" + name + ", price=" + price + "]";
    }

    
    
}
