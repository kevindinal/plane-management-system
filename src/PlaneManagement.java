// Input relevant modules
import java.util.InputMismatchException;
import java.util.Scanner;
public class PlaneManagement {  // Main class

    // Arrays for represent seat row A, B, C, D
    public static int[] Row_A = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] Row_B = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] Row_C = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] Row_D = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int[][] allseat = new int[][]{Row_A,Row_B,Row_C,Row_D};  // 2D Array for represent all seats
    private static Ticket[] ticketinfo = new Ticket[52];  // Array for store ticket information
    // Main method for execute the program
    public static void main(String[]args) {

        Scanner input = new Scanner(System.in);  // Scanner object for user input

        // Display the menu option
        System.out.println(" ");
        System.out.println("----- Welcome to the Plane Management Application -----");
        int choice;
        do {
            System.out.println(" ");
            System.out.println("****************************************************");
            System.out.println("*                 MENU OPTIONS                     *");
            System.out.println("****************************************************");
            System.out.println("      1) Buy a seat                              ");
            System.out.println("      2) Cancel a seat                           ");
            System.out.println("      3) Find first available seat               ");
            System.out.println("      4) Show seating plan                       ");
            System.out.println("      5) Print ticket information and total sales");
            System.out.println("      6) Search ticket                           ");
            System.out.println("      0) Quit                                    ");
            System.out.println("****************************************************");

            // validate user input for menu choices
            while(true){
                try {
                    System.out.print("Enter your choice : ");
                    choice = input.nextInt();
                    System.out.println(" ");
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Invalid Option "); // Handling invalid input
                    input.nextLine();
                }
            }
            // Switch statement to execute different actions based on user's choice
            switch (choice) {
                case 0: // Loop continues until user chooses 0 to exit
                    System.out.println("Thank you for using Plane Management application. Goodbye!");
                    break;
                case 1:
                    buy_Seat(input); // Calling buy seat method
                    break;
                case 2:
                    cancel_Seat(input); // Calling buy seat method
                    break;
                case 3:
                    find_First_Available(); // Finding first available seat
                    break;
                case 4:
                    show_Seating_Plan(); // Showing seating plan
                    break;
                case 5:
                    print_Tickets_Info(); // Print ticket information and total sales
                    break;
                case 6:
                    search_Ticket(input); // Search a ticket
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // Handling invalid option

            }
        } while (choice != 0);
    }
    // Buy seat method
    private static void buy_Seat(Scanner input){  // Method for buy seat
        input.nextLine();
        String rowLatter; // Declaring a variable for Row Latter
        do{
            System.out.print("Enter a Row letter :"); // Prompting user to enter row data
            rowLatter = input.nextLine().toUpperCase(); // Converting to uppercase
        }while (!(rowLatter.equals("A")|| rowLatter.equals("B") || rowLatter.equals("C") || rowLatter.equals("D")));

        while(true) { // until user enter valid seat number loop will continue
            try {
                System.out.print("Enter your seat number :"); //Prompting user to enter seat number
                int snum = input.nextInt();

                boolean seatAvailable = false;

                // Checking seat availability and booking if available
                if (rowLatter.equals("A")) { // Check if selected row is A
                    if (Row_A[snum - 1] == 1) {
                        System.out.println("Seat is already booked");
                        return;
                    } else {
                        Row_A[snum - 1] = 1;
                        seatAvailable = true;
                    }
                } else if (rowLatter.equals("B")) { // Check if the selected row is B
                    if (Row_B[snum - 1] == 1) {
                        System.out.println("Seat is already booked");
                        return;
                    } else {
                        Row_B[snum - 1] = 1;
                        seatAvailable = true;
                    }
                } else if (rowLatter.equals("C")) { // Check if the selected row is C
                    if (Row_C[snum - 1] == 1) {
                        System.out.println("Seat is already booked");
                        return;
                    } else {
                        Row_C[snum - 1] = 1;
                        seatAvailable = true;
                    }
                } else if (rowLatter.equals("D")) { // Check if the selected row is D
                    if (Row_D[snum - 1] == 1) {
                        System.out.println("Seat is already booked");
                        return;
                    } else {
                        Row_D[snum - 1] = 1;
                        seatAvailable = true;
                    }
                }

                if (seatAvailable = true){
                    // Determining seat price based on seat number
                    int seatprice = 0; // seat price variable
                    if(snum >= 1 && snum <= 5){
                        seatprice = 200;
                    } else if (snum >= 6 && snum <= 9) {
                        seatprice = 150;
                    }
                    else{
                        seatprice = 180;
                    }
                    // Prompting user for personal details
                    input.nextLine();
                    System.out.print("Enter your Name: ");
                    String username = input.nextLine();

                    System.out.print("Enter your Surname: ");
                    String usersurname = input.nextLine();

                    System.out.print("Enter your Email: ");
                    String useremail = input.nextLine();

                    System.out.println("Seat book successfully");

                    Person personclass = new Person(username, usersurname, useremail); // Creating a Person object with user's details
                    // through ticketinfo array find the next available and save the ticket information
                    for (int i = 0; i < ticketinfo.length; i++){
                        if(ticketinfo[i] == null){
                            ticketinfo[i] = new Ticket(rowLatter, snum, seatprice, personclass);
                            ticketinfo[i].save();
                            break;
                        }
                    }
                    break; // Exiting a loop
                }
            }catch (Exception e){ // exceptions that occur during seat number input
                input.nextLine();
                System.out.println("Invalid Seat number"); // Showing user to its invalid seat number
            }
        }
    }

    private static void cancel_Seat(Scanner input){  // Method for cancel seat
        input.nextLine();
        String rowLatter; // Declaring variable for row latter
        do{
            System.out.print("Enter a Row letter :"); //Prompting user to enter row latter
            rowLatter = input.nextLine().toUpperCase();
            // Asking row latter until user enter A, B, C, D
        }while (!(rowLatter.equals("A")|| rowLatter.equals("B") || rowLatter.equals("C") || rowLatter.equals("D")));

        while (true){
            try{ // until user enter valid seat number loop will continue
                System.out.print("Enter your seat number :");
                int snum = input.nextInt();

                switch (rowLatter){
                    case "A":
                        if(Row_A[snum-1] == 1){ // Check whether if seat is book
                            Row_A[snum-1] = 0;
                            System.out.println("Seat Cancel successfully");
                        } else {
                            System.out.println("Seat is already available");
                        }
                        break;

                    case "B":
                        if(Row_B[snum-1] == 1){ // Check whether if seat is book
                            Row_B[snum-1] = 0;
                            System.out.println("Seat Cancel successfully");
                        } else {
                            System.out.println("Seat is already available");
                        }
                        break;

                    case "C":
                        if(Row_C[snum-1] == 1){ // Check whether if seat is book
                            Row_C[snum-1] = 0;
                            System.out.println("Seat Cancel successfully");
                        } else {
                            System.out.println("Seat is already available");
                        }
                        break;

                    case "D":
                        if(Row_D[snum-1] == 1){ // Check whether if seat is book
                            Row_D[snum-1] = 0;
                            System.out.println("Seat Cancel successfully");
                        } else {
                            System.out.println("Seat is already available");
                        }
                        break;
                } // Loop to find and cancel correct ticket
                for (int i = 0; i < ticketinfo.length; i++) {
                    if (ticketinfo[i] != null  && ticketinfo[i].Row().equals(rowLatter) && ticketinfo[i].Seat() == snum){
                        ticketinfo[i] = null;
                        break;
                    }
                }
                break; // Exception handling for invalid seat number
            }catch (Exception e){
                input.nextLine();
                System.out.println("Invalid seat number");
            }
        }
    }

    private static void find_First_Available(){  // Method for find first available seat
        boolean seatavailble = false;
        // Loop through allseat array to find first available seat
        for (int i =0; i < allseat.length; i++ ){
            for (int j = 0; j < allseat[i].length; j++){
                if(allseat[i][j] == 0){
                    System.out.println("********* First Available Seat Information *********\n");
                    System.out.println("Seat Row: "  + (char) ('A' + i) + "\n"
                            + "Seat Number: " + (j + 1));
                    return;
                }
            }
        }
    }
    // Method for display seating plan
    private static void show_Seating_Plan(){
        System.out.println("********* Seating Plan ************\n");
        // Display seating plan using 'O' for not reserved seats and 'x' for reserved seats
        for(int j = 0; j< allseat.length; j++){
            System.out.print((char) ('A' + j) + "  ");
            for (int i = 0; i < allseat[j].length; i++){
                if (allseat[j][i] == 0) {
                    System.out.print("0 "); // If seat is not reserved then the element is 0
                } else {
                    System.out.print("X "); // If seat reserved the element is 1
                }
            }System.out.println();
        }
    }
    // Method for print ticket information and total sales
    private static void print_Tickets_Info(){
        int total = 0;
        System.out.println("********** Ticket Information **********\n");
       // loop through ticketinfo array to print information
        for (int i = 0; i < ticketinfo.length; i++){
            if(ticketinfo[i] != null){
                ticketinfo[i].wholeinfo();
                total += ticketinfo[i].Price();
                System.out.println("  ");
            }
        }
        System.out.println("Total Sale is: £" + total);
    }
     // Method to search ticket information
    private static void search_Ticket(Scanner input){
        input.nextLine();
        String rowLatter; // Declaring variable for row latter
        int snum;
        do{
            System.out.print("Enter a Row letter :"); //Prompting user to enter row latter
            rowLatter = input.nextLine().toUpperCase();
            // Asking row latter until user enter A, B, C, D
        }while (!(rowLatter.equals("A")|| rowLatter.equals("B") || rowLatter.equals("C") || rowLatter.equals("D")));

        do {
            try { // until user enter valid seat number loop will continue
                System.out.print("Enter your seat number :");
                snum = input.nextInt();
                if ((rowLatter.equals("A") || rowLatter.equals("D")) && snum <= 14){
                    break;
                } else if ((rowLatter.equals("B") || rowLatter.equals("C")) && snum <= 12) {
                    break;
                }
                System.out.println("Invalid seat number\n");
            }catch (Exception e){ // Exception handling for invalid seat number
                System.out.println("Invalid seat number\n");
                input.nextLine();
            }
        }while (true);
        // Check whether if seat is booked or not booked
        boolean ticketInfo = true;
        for (int i = 0; i < ticketinfo.length; i++) {
            if (ticketinfo[i] != null  && ticketinfo[i].Row().equals(rowLatter) && ticketinfo[i].Seat() == snum) {
                ticketinfo[i].wholeinfo(); // Printing the ticket information
                ticketInfo = false;
                break;
            }
        }
        if (ticketInfo){
            System.out.println("Seat is available");
        }
    }
}


