package Hotel_oO;

import java.util.ArrayList;

public class Room {

    private String roomNumber;
    private int capacity;
    private String description;
    private int prezzo;
    private ArrayList<Guest> listGuests;

    public Room(String roomNumber, int capacity, String description) {
        this.roomNumber = roomNumber.trim().toUpperCase();
        this.capacity = capacity;
        this.description = description;
        this.prezzo = 100;
        listGuests = new ArrayList<Guest>();
    }

    /**
     * 
     * @return ritorna true se la stanza è libera, false se è occupata
     */
    public boolean isFree() {
        boolean ris = false;
        if (listGuests.size() == 0) {
            ris = true;
        }
        return ris;
    }

    /**
     * 
     * @param num intero che definisce quante persone devono essere ospiti
     * @return boolean true o false per un determinato numero di persone
     */
    public boolean isavailableFor(int num) {
        boolean ris = false;
        int available = getCapacity() - getNumGuests();
        if (num <= available) {
            ris = true;
        }
        return ris;
    }

    public boolean addGuest(Guest newGuest) {// aggiunge alla stanza un Guest @param newGuest nuovo guest @return true o
                                             // false */
        boolean ris = false;
        if (listGuests.size() < capacity) { // c'è posto
            listGuests.add(newGuest);
            ris = true;
        }
        return ris;
    }

    public int freeGuests() {
        int numfree = listGuests.size();
        listGuests.clear();
        return numfree;
    }

    public String getInfoRoom() {
        String ris = "";
        String status = "";
        if (isFree()) {
            status += "-";
        } else {
            status += getNumGuests();
        }
        String tipo = this.getClass().getSimpleName();
        if (tipo.equals("RoomOpen")) {
            tipo = "OPEN";
        } else {
            tipo = "STD";
        }
        ris += tipo + " [" + status + "] - ";
        ris += "Numero: " + roomNumber;
        ris += " - max persone: " + capacity;
        String mydescr = description;
        int maxl = 40; // se troppo lunga la descrizione, la taglio
        if (mydescr.length() > maxl) {
            mydescr = mydescr.substring(0, maxl - 3) + "...";
        }
        ris += " - descrizione; " + mydescr; // max 40 caratteri, altrimenti lo taglio
        if (!isFree()) { // aggiungo i guest a ris
            int conta = 1;
            for (Guest g : listGuests) { // scorro tutti i Guests
                String rigaGuest = conta + ") " + g.getInfoGuests();
                ris += "\n" + rigaGuest;
                conta++;
            }
        }
        return ris + "\n";
    }

    /**
     * fornisce numero Guest della stanza
     * 
     * @return numero ospiti
     */
    public int getNumGuests() {
        int ris = 0;
        ris = listGuests.size();
        return ris;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCSVguests() { //es.: 111; qw;qw - 111; qw;qw - 111; qw;qw - 111; qw;qw \n
        String ris = "";
        for (Guest g : listGuests){
            ris += roomNumber + ";" + g.getLastName() + ";" + g.getFirstName() + "\n";
        }
        return ris;
       

    }

}
