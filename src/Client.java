import exceptions.InvalidPersonDataException;

public class Client extends Person {

    public Client(String name, String surname, String town) throws InvalidPersonDataException {
        super(name, surname, town);
    }

    public Client(Person oldPerson) throws InvalidPersonDataException {
        super(oldPerson.getName(), oldPerson.getSurname(), oldPerson.getTown());
        removePerson(this);
        changePersonType(oldPerson, this);
    }

    @Override
    public String getFullInfo() {
        return getName() + " " + getSurname() + " is a " + this.getClass().getSimpleName() + " from " + getTown();
    }
}
