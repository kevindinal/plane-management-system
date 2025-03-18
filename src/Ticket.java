// Input relevant modules
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {

    private String row;          // Row
    private int seat;            // Seat number
    private int ticketprice;     // Ticket Price
    private Person personclass;  // Reference person class for passenger details


    // Constructor to initialize Ticket information
    Ticket(String row, int seat, int ticketprice, Person personclass){
        this.row = row;
        this.seat = seat;
        this.ticketprice = ticketprice;
        this.personclass = personclass;
    }

    // Getter method for row
    public String Row(){
        return row;
    }

    // Getter method for Seat
    public int Seat(){
        return seat;
    }

    public void wholeinfo(){   // Method to display all ticket information
        System.out.println(" ");
        System.out.println("Seat Row is :" + row);
        System.out.println("Seat Number is :" + seat);
        System.out.println("Ticket Price is :£" + ticketprice);
        System.out.println("Passenger First Name is :" + personclass.Name());
        System.out.println("Passenger Last Name is :" + personclass.Surname());
        System.out.println("Passenger Email is :" + personclass.Email());

    }

    // Getter method for ticket price
    public int Price(){
        return ticketprice;
    }

    // Method to save ticket information to a file
    public void save(){
        try{
            // Create a FileWriter object to write to a file
            FileWriter planeticket = new FileWriter(this.row.toUpperCase() + this.seat + ".txt");

            // Write ticket information to the file
            planeticket.write("*******  Ticket Information  *******" + "\n");
            planeticket.write("Row Letter :"+this.row.toUpperCase()+ "\n");
            planeticket.write("Seat Number :"+this.seat + "\n");
            planeticket.write("Ticket Price :£"+this.ticketprice + "\n");
            planeticket.write("Passenger First Name is:"+this.personclass.Name() + "\n");
            planeticket.write("Passenger Last Name is:"+this.personclass.Surname() + "\n");
            planeticket.write("Passenger Email is :" +this.personclass.Email() + "\n");
            planeticket.close();  // Close the FileWriter object
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
