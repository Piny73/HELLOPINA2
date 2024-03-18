package Library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> libri = new ArrayList<>();
    List<Book> inPrestito = new ArrayList<>();


    public boolean addBook(Book b) {
        if (libri.contains(b)) {
            return false;
        }
        return libri.add(b);
    }

    public boolean loanBook(Book b) {
        if (!libri.contains(b)) { 
            throw new RuntimeException("libro non presente in libreria!");
        }
        if (inPrestito.contains(b)) {
            return false;
        }
        inPrestito.add(b);
        return true;
    }

    public void returnBook(Book b) {
        if (!inPrestito.contains(b)) {
            throw new RuntimeException("il libro non è stato prestato!");
        } 
        inPrestito.remove(b);
    }

    public void printLoans() {        
        for (Book l : inPrestito){
            System.out.println(l);
        }
    }
}
