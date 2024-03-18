package Hotel_oO;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AlbergoO {

    static ArrayList<Room> listRooms = new ArrayList<Room>();

    public static void main(String[] args) throws Exception {

        createRooms();
        menuAlbergo();

    }

    public static void createRooms(){
        //apro il file delle stanze
        try {
            File myObj = new File("roomoO.csv");
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                String []items=data.split(";");
                Room newRoom;
                String nr = items [0];
                int cap = Integer.parseInt(items[1]);
                String desc = items[2];             
                String tipo = items [4];
                if (tipo.equals("open")){
                    newRoom = new RoomOpen(nr, cap, desc);

                } else {
                    newRoom = new Room(nr, cap, desc);
                } 
                // devo scorrere guestoO.csv e trovare ad es.: la 111
                // nel caso, creare un gest ed aggiungerlo alla lista
                File fileg = new File ("guestoO.csv");
                Scanner scg = new Scanner (fileg);
                scg.nextLine();
                while (scg.hasNextLine()){
                    String datag = scg.nextLine();
                    String [] itemsg = datag.split (";");
                    if (itemsg[0].equals(nr)){
                        Guest newg = new Guest(itemsg[1],itemsg[2]);
                        newRoom.addGuest(newg);
                    }
                }
                
                scg.close();
                System.out.println(newRoom.getClass().getName());            
                listRooms.add(newRoom); // aggiungerla alla lista stanzel


            }
            myReader.close();
            }
            catch (Exception e){
                System.out.println("File ot found!");
            }
    }

    public static Guest creaGuest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Creazione Anagrafica Guests---");
        System.out.println("ins firstname: ");
        String firstname = sc.nextLine();
        System.out.println("ins lastname: ");
        String lastname = sc.nextLine();
        // System.out.println("ins Tipo di Documento: ");
        // String docTipe = sc.nextLine();
        // System.out.println("ins l'ID del Documento: ");
        // String idNumber = sc.nextLine();
        // System.out.println("ins l'email: ");
        // String email = sc.nextLine();
        // System.out.println("ins il phone number: ");
        // String phone = sc.nextLine();
        Guest newg = new Guest(firstname, lastname);
        return newg;
    }

    public static void checkIN() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---CHECKIN---");
        System.out.println("\nInserire il numero degli ospiti: ");
        int numGuests = sc.nextInt();
        int key = -1;
        for (int i = 0; i < listRooms.size(); i++) {
            Room r = listRooms.get(i);
            boolean avail = r.isavailableFor(numGuests);
            if (avail) {
                key = i;
                break;
            }
        }
        if (key == -1) {
            System.out.println("No Vacancy");
            return;
        }
        // ciclo per tutti dove creo l'anagrafica di ogni guest e li assegno alla stanza
        for (int i = 0; i < numGuests; i++) {
            Guest newguest = creaGuest();
            listRooms.get(key).addGuest(newguest);
        }
        saveGuests();

    }

    private static void saveGuests() {
        String txfile = "roomnumber;cognome;nome\n";
        // scorrere le rooms
        for (Room r : listRooms){
           //vado al prossimo se non c'è nessuno
           if (r.isFree()) continue; 
           // scorro tutti i guests
           txfile+= r.getCSVguests();
        }
        try {
        FileWriter file = new FileWriter("guestoO.csv");
        file.write (txfile);
        file.close();
        }
        catch (Exception e){
            System.out.println("file not found!");
        }
        
    }

    public static void checkOUT() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-----------------CHECKOUT----------------");
        System.out.println("Buongiorno, vuoi lasciare la room? Dammi il numero della chiave: ");
        String key = sc.nextLine();
        int indexRoom = getIndexByRoomNumber(key); // chiedo la stanza e recupero l'index
        if (indexRoom == -1) {// se non trova la camera!
            System.out.println("\nATTENZIONE: camera inesistente!");
            return;
        }
        // listRooms.get(indexRoom).freeGuests();
        Room room = listRooms.get(indexRoom); // La stanza da liberare
        room.freeGuests(); // Libero la stanza senza sapere quanti ne ho cancellati
        System.out.println("---La Room " + key + " è stata LIBERATA!");
        saveGuests();
    }

    /**
     * funzione per avere il numero di stanze libere
     * 
     * @return int numero di stanze libere
     */
    static int getnumberFreeRooms() {
        int freeRoom = 0;
        // vado davanti a ogni stanza e se libera la conto
        // lista stanze in arraylist di dimensione size ()
        for (int i = 0; i < listRooms.size(); i++) {
            if (listRooms.get(i).isFree()) {
                freeRoom++;
            }
        }
        return freeRoom;
    }

    /**
     * funzione per avere il totale dei guest dell'albergo
     * 
     * @return tot dei Guests
     */
    public int getTotGuests() {
        int tot = 0;
        for (Room r : listRooms) {
            tot += r.getNumGuests();
        }
        return tot;
    }

    public static int getIndexByRoomNumber(String roomNumber) {
        int index = -1;
        roomNumber = roomNumber.trim().toUpperCase();
        for (int i = 0; i < listRooms.size(); i++)
            if (listRooms.get(i).getRoomNumber().equalsIgnoreCase(roomNumber)) {
                index = i;
            }

        return index;
    }

    private static String printReport() {
        System.out.println("\nREPORT ALBERGO:");
        String report = "";
        String riga = "";
        int totguests = 0;
        int totfree = 0;
        int totfull = 0;
        int totcapacity = 0;
        String listafree = "";
        for (Room r : listRooms) {
            totguests += r.getNumGuests();
            if (r.isFree()) {
                totfree++;
                listafree += "(" + r.getCapacity() + ")" + r.getRoomNumber() + " ";
            }
            totcapacity += r.getCapacity();
        }
        totfull = listRooms.size() - totfree;
        riga = "Stanze libere: " + totfree + " - occupate: " + totfull;
        report += riga + "\n";
        riga = "Ospiti totali: " + totguests + " - tot capacità: " + totcapacity;
        report += riga + "\n";
        float perc = (float) totguests / (float) totcapacity;
        riga = "Occupazione in %: " + Math.round(perc * 100) + "%";
        report += riga + "\n";
        riga = "Lista stanze libere: " + listafree;
        report += riga + "\n";
        System.out.println(report);
        return report;
    }

    public static void infoRooms() {
        System.out.println("Benvenuto nella infoROOMS");
        for (Room r : listRooms) {
            System.out.println(r.getInfoRoom());
        }
    }

    static void menuAlbergo() {
        System.out.println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
        System.out.println("><><><><><><><><><><><><><><>< BENVENUTI NELL' AlbergoO! ><><><><><><><><><><><><><><>");
        while (true) {
            System.out
                    .println("><><><><><><><><><><><><><><><><><>< MENU AlbergoO ><><><><><><><><><><><><><><><><><>");
            System.out
                    .println("><  [I] chekIN - [O] checkOUT - [L] - List Room - [R] - Report Albergo - [E] EXIT  ><>");
            System.out
                    .println("><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><");
            Scanner sc = new Scanner(System.in);
            System.out.println("Fai la tua scelta: ");
            String v = sc.nextLine();
            v = v.trim().toLowerCase();
            if (v.equals("i")) {
                checkIN();
            }
            if (v.equals("o")) {
                checkOUT();
            }
            if (v.equals("l")) {
                infoRooms();
            }
            if (v.equals("r")) {
                printReport();
            }
            if (v.equals("e")) {
                break;
            }
        }
    }
}
