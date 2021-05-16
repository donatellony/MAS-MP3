import exceptions.InvalidPersonDataException;

public class Veterinarian extends Person {

    private int animalsTreated;


    public Veterinarian(String name, String surname, String town) throws InvalidPersonDataException {
        super(name, surname, town);
    }

    public Veterinarian(Person oldPerson) throws InvalidPersonDataException {
        super(oldPerson.getName(), oldPerson.getSurname(), oldPerson.getTown());
        try {
            setAnimalsTreated(0);
        } catch (InvalidPersonDataException e) {
            e.printStackTrace();
        }
        removePerson(this);
        changePersonType(oldPerson, this);
    }

    public Veterinarian(Person oldPerson, int animalsTreated) throws InvalidPersonDataException {
        this(oldPerson);
        try {
            setAnimalsTreated(animalsTreated);
        } catch (InvalidPersonDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFullInfo() {
        return getName() + " " + getSurname() + " is a " + this.getClass().getSimpleName() +
                " from " + getTown() + ",\nHe has treated " + getAnimalsTreated() + " animals this far!";
    }

    public int getAnimalsTreated() {
        return animalsTreated;
    }

    public void setAnimalsTreated(int animalsTreated) throws InvalidPersonDataException {
        if (animalsTreated < 0)
            throw new InvalidPersonDataException();
        this.animalsTreated = animalsTreated;
    }

    public void incrementAnimalsTreated() {
        this.animalsTreated++;
    }
}
