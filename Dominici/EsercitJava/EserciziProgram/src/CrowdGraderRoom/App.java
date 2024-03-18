package CrowdGraderRoom;

public class App {
    public static void main(String[] args) {
        
        Reservation r = new Reservation();
Room p1 = r.reserve("Pasquale Caero", 105, 120);
Room p2 = r.reserve("Carlo Martello", 5, 20);
Room p3 = r.reserve("Piero", 20, 22);
Room p4 = r.reserve("Marinella", 200, 222);
for (Room p: r. reservations ())
System.out.println(p.getName());
    }
}
