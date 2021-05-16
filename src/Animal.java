import exceptions.AnimalSearchTypeException;
import exceptions.InvalidAnimalDataException;

import java.time.LocalDate;
import java.util.ArrayList;

enum AnimalRelationshipStatus {LOOKING_FOR_LOVE, LOOKING_FOR_FRIEND}

enum AnimalSize {EXTRA_SMALL, SMALL, MEDIUM, BIG, EXTRA_BIG}

public abstract class Animal {
    private static ArrayList<Animal> animals = new ArrayList<>();

    private AnimalRelationshipStatus status;

    private String preferredLoverBreed;

    private AnimalSize size;
    private AnimalSize friendSize;

    private String name;
    private LocalDate birthDate;
    private String breed;

    private Animal(String name, String breed, LocalDate birthDate) throws InvalidAnimalDataException {
        setName(name);
        setBreed(breed);
        setBirthDate(birthDate);
        addAnimal(this);
    }

    public Animal(String name, String breed, LocalDate birthDate, String preferredLoverBreed) throws AnimalSearchTypeException, InvalidAnimalDataException {
        this(name, breed, birthDate);
        setStatus(AnimalRelationshipStatus.LOOKING_FOR_LOVE);
        setPreferredLoverBreed(preferredLoverBreed);
    }

    public Animal(String name, String breed, LocalDate birthDate, AnimalSize size, AnimalSize friendSize) throws InvalidAnimalDataException, AnimalSearchTypeException {
        this(name, breed, birthDate);
        setStatus(AnimalRelationshipStatus.LOOKING_FOR_FRIEND);
        setSize(size);
        setFriendSize(friendSize);
    }

    private static void addAnimal(Animal animal) {
        if (!animals.contains(animal))
            animals.add(animal);
    }

    public static void removeAnimal(Animal chat) {
        animals.remove(chat);
    }

    public static void showAnimals() {
        for (Animal animal : animals)
            System.out.println(animal + "\n");
    }

    public void search() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName())
                .append(", the ")
                .append(getClass().getSimpleName())
                .append(" is looking for ");
        if (isLookingForFriend())
            sb.append("friends!");
        if (isLookingForLove())
            sb.append("love!");
        System.out.println(sb.toString());
    }

    public abstract String getVoice();

    private boolean isLookingForLove() {
        return status.equals(AnimalRelationshipStatus.LOOKING_FOR_LOVE);
    }

    private boolean isLookingForFriend() {
        return status.equals(AnimalRelationshipStatus.LOOKING_FOR_FRIEND);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidAnimalDataException {
        if (name == null)
            throw new InvalidAnimalDataException();
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) throws InvalidAnimalDataException {
        if (name == null)
            throw new InvalidAnimalDataException();
        this.birthDate = birthDate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) throws InvalidAnimalDataException {
        if (name == null)
            throw new InvalidAnimalDataException();
        this.breed = breed;
    }

    public AnimalRelationshipStatus getStatus() {
        return status;
    }

    private void setStatus(AnimalRelationshipStatus status) {
        this.status = status;
    }

    public String getPreferredLoverBreed() throws AnimalSearchTypeException {
        if (isLookingForLove())
            return preferredLoverBreed;
        throw new AnimalSearchTypeException();
    }

    public void setPreferredLoverBreed(String preferredLoverBreed) throws AnimalSearchTypeException {
        if (isLookingForLove())
            this.preferredLoverBreed = preferredLoverBreed;
        else
            throw new AnimalSearchTypeException();
    }

    public AnimalSize getSize() throws AnimalSearchTypeException {
        if (isLookingForFriend())
            return size;
        throw new AnimalSearchTypeException();
    }

    public void setSize(AnimalSize size) throws AnimalSearchTypeException {
        if (isLookingForFriend())
            this.size = size;
        else
            throw new AnimalSearchTypeException();
    }

    public AnimalSize getFriendSize() throws AnimalSearchTypeException {
        if (isLookingForFriend())
            return friendSize;
        throw new AnimalSearchTypeException();
    }

    public void setFriendSize(AnimalSize friendSize) throws AnimalSearchTypeException {
        if (isLookingForFriend())
            this.friendSize = friendSize;
        else
            throw new AnimalSearchTypeException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName())
                .append(", the ")
                .append(getClass().getSimpleName())
                .append(" (")
                .append(getBreed())
                .append(")")
                .append(", was born in ")
                .append(getBirthDate().toString())
                .append("\n");
        try {
            if (isLookingForLove())
                sb.append("Is looking for love with ").append(getPreferredLoverBreed());
            if (isLookingForFriend())
                sb.append("Has ")
                        .append(getSize().name())
                        .append(" size and is looking for ")
                        .append(getFriendSize().name())
                        .append(" friends!");
        } catch (AnimalSearchTypeException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
