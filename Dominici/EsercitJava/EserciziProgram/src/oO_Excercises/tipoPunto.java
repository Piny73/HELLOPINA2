/* Creare un tipo che rappresenti un punto su un piano x,y (cartesiano).
 * Gli oggetti. devono essere immodificabili
 * Scrivere toString e equals 
 * Fare un metodo Move (deltax,deltay) che ritorni : punto
 * Scrivere un main che utilizzi come esempio degli oggetti di tipo punto (.) 
 */

package oO_Excercises;

public class tipoPunto {
    public static void main(String[] args) {
        Punto p1 = new Punto(15, 100);

        Punto p2 = new Punto(15, 100);

        Punto[] linea = { new Punto(0, 5) };
        new Punto(10, 20);
        new Punto(30, 80);
        System.out.println(p1.toString());
        System.out.println(p1.equals(p2));
        p1 = p1.move(4,6); 
        System.out.println(p1.toString());
        System.out.println(p1.equals(p2));

    }
}

class Punto {

    private final int x; // final per renderli immutabili
    private final int y; // final per renderli immutabili

    // tasto dx> Source Acton> Generate Constructor
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // per modificare l'oggetto punto - ma x ed y diventano modificabili
    public Punto move(int deltax, int deltay) {
        // se fossero mutabili x += deltax;
        // se fossero mutabili y += deltay;
        return new Punto(x + deltax, y + deltay);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Punto [x=" + x + ", y=" + y + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
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
        Punto other = (Punto) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

}
