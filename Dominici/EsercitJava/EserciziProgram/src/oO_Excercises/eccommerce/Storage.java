package oO_Excercises.eccommerce;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Optional;
import java.util.Objects;


public class Storage {

    private Set<StorageItem> items = new HashSet<>();

    public void load(Product product, int quantity){
        // carica un prodotto a magazzino o aggiornarlo aggiungendo la quantità
        StorageItem item = find (product)
                    .orElse(new StorageItem(product, 0));
        item.setQuantity(item.getQuantity() + quantity);
        items.add(item);
    }

    public void unload(Product product, int quantity){
        StorageItem item = isavailable(product, quantity);
        item.setQuantity((item.getQuantity() - quantity));
    }

    public void discontinue(Product p){
       StorageItem found =  find(p).orElseThrow(() -> new StorageException("product not exsist"));
        found.discontinue();
    }

    public Set<Product> findByName(String name){
        return items.stream()
            .filter(v ->v.getProduct().getName().contains(name))
            .map (v -> v.getProduct())
            .collect(Collectors.toSet());
    }

    public void logStatus(){
        System.out.println("---Storage STATUS start---");
        items.forEach(v -> System.out.println(v));
        System.out.println("---Storage STATUS end---");
    }

    private Optional <StorageItem> find(Product p){ 
        return items.stream()
        .filter(v-> v.getProduct().equals(p))
        .findFirst();
    }
    private StorageItem isavailable(Product product, int quantity){ // ritorna la disponibilità di un item o un msg di "prodotto non disponibile"
        StorageItem found = find(product).orElseThrow(() ->  new StorageException("product not exist"));
        if (found.getQuantity()<quantity){
            throw new StorageException("quantity is not sufficient");
        }
        return found;
    }

    //private Optional <StorageItem> findOldJava(Product p){ // cerca prodotto in storage
       // Optional <StorageItem> result = Optional.empty();
       // for(StorageItem item : items){
         //   if(item.getProduct().equals(p)) {
              //  result = Optional.of(item);
              //  break;
           // }
        //}
       //return result; 
   // }
}
private class StorageItem {
    public static enum State{IN_STOCK, OUT_OF_STOCK, DISCONTINUED}
    
        private Product product;
        private int quantity;
        private State state;
        
        public StorageItem(Product product, int quantity) {
            Objects.requireNonNull("product is empty");
            this.product = product;
            this.quantity = quantity;
        }
    
        public Product getProduct() {
            return product;
        }
    
        public State getState() {
            return state;
        }
    
        public int getQuantity() {
            return quantity;
        }
    
        public void setQuantity(int quantity) {
            if (quantity<0) {
                throw new IllegalArgumentException ("negative quantity not allow");
            }
            this.quantity = quantity;
            this.state = this.quantity > 0 ? State.IN_STOCK : State.OUT_OF_STOCK;
        }
    
        public void discontinue (){
        this.state = State.DISCONTINUED;
      }
    
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((product == null) ? 0 : product.hashCode());
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
            StorageItem other = (StorageItem) obj;
            if (product == null) {
                if (other.product != null)
                    return false;
            } else if (!product.equals(other.product))
                return false;
            return true;
        }
    
        @Override
        public String toString() {
            return "StorageItem [product=" + product + ", quantity=" + quantity + ", state=" + state + "]";
        } 
    
        
    }
    
