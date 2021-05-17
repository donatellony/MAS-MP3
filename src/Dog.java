import exceptions.AnimalSearchTypeException;
import exceptions.InvalidAnimalDataException;

import java.time.LocalDate;

public class Dog extends Animal {

    public Dog(String name, String breed, LocalDate birthDate, AnimalGender gender, String preferredLoverBreed) throws AnimalSearchTypeException, InvalidAnimalDataException {
        super(name, breed, birthDate, gender, preferredLoverBreed);
    }

    public Dog(String name, String breed, LocalDate birthDate, AnimalGender gender, AnimalSize size, AnimalSize friendSize) throws InvalidAnimalDataException, AnimalSearchTypeException {
        super(name, breed, birthDate, gender, size, friendSize);
    }

    @Override
    public String getVoice() {
        return "Woof!";
    }
}
