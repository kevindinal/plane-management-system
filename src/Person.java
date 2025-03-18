public class Person {
    // Declaring Private fields for person's
    private String name;
    private String surname;
    private String email;

    // Constructor to initialize name, surname, and email
    Person(String name, String surname, String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    // Getter method for retrieving the name
    public String Name(){
        return name;
    }

    // Getter method for retrieving the surname
    public String Surname(){
        return surname;
    }

    // Getter method for retrieving the email
    public String Email(){
        return email;
    }

}
