import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Person p = new Client("Yehor", "Voiko", "Warszawa");
        Person.showPersons();
        p = new AnimalSeller(p);
        System.out.println("\n Showing persons extension after the dynamic change of class");
        Person.showPersons();
        p = new Veterinarian(p);
        System.out.println("\n Showing persons extension after dynamic the change of class once more");
        Person.showPersons();
        Worker w1 = new Programmer("Jan", "Kowalski", "jank@piesikot.com", 15.0f, 6);
        Worker w2 = new Verifier("Jana", "Kowalska", "janak@piesikot.com", 18.0f, 40);
        System.out.println(w1.toString() + ", gets " + w1.getSalary() + " a month");
        System.out.println(w2.toString() + ", gets " + w2.getSalary() + " a month");
    }
}
