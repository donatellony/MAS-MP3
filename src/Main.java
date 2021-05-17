import java.time.LocalDate;
import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {
        try {
            Person p = new Client("Yehor", "Voiko", "Warszawa");
            Person.showPersons();
            p = new AnimalSeller(p);
            System.out.println("\n===Showing Persons extension after the <<dynamic>> change of class===");
            Person.showPersons();
            p = new Veterinarian(p);
            System.out.println("\n===Showing Persons extension after <<dynamic>> the change of class once more===");
            Person.showPersons();

            System.out.println("\n===Showing Workers' simple abstract inheritance===");

            Worker w1 = new Programmer("Jan", "Kowalski", "jank@piesikot.com", 15.0f, 6);
            Worker w2 = new Verifier("Jana", "Kowalska", "janak@piesikot.com", 18.0f, 40);
            System.out.println(w1.toString() + ", gets " + w1.getSalary() + " a month");
            System.out.println(w2.toString() + ", gets " + w2.getSalary() + " a month");

            System.out.println("\n===Showing Verified Chat Admin Wiktor as an example of multi-inheritance (Worker(mainly) and Person)===");
            System.out.println("==Wiktor is the part of Workers extension==");
            VerifiedChatAdmin admin = new VerifiedChatAdmin("Wiktor", "Janowski", "Krakow", "wikjan@piesikot.com", 20f);
            Worker.showWorkers();
            System.out.println("==He also has getFullInfo method and Town attribute of Person class==");
            System.out.println(admin.getFullInfo());

            System.out.println("\n===Showing the overlapping implementation in creation of various Chat-Type Chats===");
            Chat animalChat = new Chat("Cat lovers", EnumSet.of(ChatType.ANIMAL_CHAT));
            animalChat.setFavoriteAnimalType("Cat");
            Chat workOtherChat = new Chat("Football enjoyers", EnumSet.of(ChatType.WORK_CHAT, ChatType.OTHER_CHAT));
            workOtherChat.setDescription("We love playing and watching football with our pets!");
            workOtherChat.setMainTheme("Football");
            workOtherChat.setWorkName("Football");
            Chat.showChats();

            System.out.println("===Showing the multi-aspect inheritance implementation using the Animal class===");
            Dog goodBoy = new Dog("Max", "Shiba-inu", LocalDate.parse("2020-04-05"), AnimalGender.MALE, AnimalSize.MEDIUM, AnimalSize.MEDIUM);
            Cat sweetGirl = new Cat("Ajwi", "Scottish Fold", LocalDate.parse("2019-06-07"), AnimalGender.FEMALE ,"British Shorthair");
            System.out.println("Good boy " + goodBoy.getName() + " says " + goodBoy.getVoice());
            System.out.println("Sweet girl " + sweetGirl.getName() + " says " + sweetGirl.getVoice());
            System.out.println("==Let's see who are they searching for?==");
            goodBoy.search();
            sweetGirl.search();
            System.out.println("==Animals extension is telling us that==");
            Animal.showAnimals();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
