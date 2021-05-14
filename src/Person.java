import exceptions.InvalidPersonDataException;

import java.util.ArrayList;

public abstract class Person {
    private static ArrayList<Person> persons = new ArrayList<>();

    String name;
    String surname;
    String town;

    public Person(String name, String surname, String town) {
        try {
            setName(name);
            setSurname(surname);
            setTown(town);
            addPerson(this);
        } catch (InvalidPersonDataException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidPersonDataException {
        if (name == null)
            throw new InvalidPersonDataException();
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws InvalidPersonDataException {
        if (surname == null)
            throw new InvalidPersonDataException();
        this.surname = surname;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) throws InvalidPersonDataException {
        if (town == null)
            throw new InvalidPersonDataException();
        this.town = town;
    }

    public static void addPerson(Person person) {
        if (!persons.contains(person))
            persons.add(person);
    }

    public static void changePersonType(Person oldPerson, Person newPerson) {
        if (persons.contains(oldPerson) && !oldPerson.getClass().equals(newPerson.getClass()))
            persons.set(persons.indexOf(oldPerson), newPerson);
    }

    public static void removePerson(Person person) {
        persons.remove(person);
    }

    public static void showPersons() {
        for (Person p : persons)
            System.out.println(p.toString());
    }

    public abstract String getFullInfo();

    @Override
    public String toString() {
        return getName() + " " + getSurname() + ", " + this.getClass().getSimpleName();
    }
}

