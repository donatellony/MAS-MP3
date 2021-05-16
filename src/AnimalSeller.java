import exceptions.InvalidPersonDataException;

public class AnimalSeller extends Person {

    private int animalsSold;

    public AnimalSeller(String name, String surname, String town) throws InvalidPersonDataException {
        super(name, surname, town);
    }

    public AnimalSeller(Person oldPerson) throws InvalidPersonDataException {
        super(oldPerson.getName(), oldPerson.getSurname(), oldPerson.getTown());
        try {
            setAnimalsSold(0);
        } catch (InvalidPersonDataException e) {
            e.printStackTrace();
        }
        removePerson(this);
        changePersonType(oldPerson, this);
    }

    public AnimalSeller(Person oldPerson, int animalsSold) throws InvalidPersonDataException {
        this(oldPerson);
        try {
            setAnimalsSold(animalsSold);
        } catch (InvalidPersonDataException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFullInfo() {
        return getName() + " " + getSurname() + " is a " + this.getClass().getSimpleName() +
                " from " + getTown() + ",\nHe has sold " + getAnimalsSold() + " animals this far!";
    }

    public int getAnimalsSold() {
        return animalsSold;
    }

    public void setAnimalsSold(int animalsSold) throws InvalidPersonDataException {
        if (animalsSold < 0)
            throw new InvalidPersonDataException();
        this.animalsSold = animalsSold;
    }

    public void incrementAnimalsSold() {
        this.animalsSold++;
    }
}
