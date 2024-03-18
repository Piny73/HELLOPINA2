/* Ospite dell'albergo
 * 
 */

package Hotel_oO;

public class Guest {
    public static enum Tipo {
        PASSAPORTO, CARTAID, PATENTE
    }

    private String firstName;
    private String lastName;
    //private String idNumber;
    //private String docTipe;
    //private String email;
    //private String phone;

     public Guest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //this.idNumber = idNumber;
        //this.docTipe = docTipe;
        //this.email = email;
        //this.phone = phone;
    }

    

    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getInfoGuests(){
        String ris= "";
        ris += "Cognome: " + lastName + " - ";
        ris += "Nome: " + firstName;
        return ris;
    }
}
