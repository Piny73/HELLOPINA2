package CrowdGraderRoom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Room {

    private List<Reservation> reservations = new ArrayList <>();

    public Reservation reserve (String nome, LocalDate from, LocalDate to){
        if(isReserved (from,to)){
            throw new RuntimeException ("camera riservata");
        }
        Reservation r = new Reservation (name, from, to);
        reservations.add(r);
        return r;  
    }

    private boolean isReserved(LocalDate from, LocalDate to) {
        for (Reservation r : reservations){
            if (r.isOverlapped(from,to)){
               return true;
            }
        }
        return false;
    }

    public List<Reservation> reservations(){
        throw new UnsupportedOperationException ("wip");
    }
}
