import exceptions.AnimalSearchTypeException;
import exceptions.InvalidAnimalDataException;

import java.time.LocalDate;

public class Cat extends Animal {

    public Cat(String name, String breed, LocalDate birthDate, String preferredLoverBreed) throws AnimalSearchTypeException, InvalidAnimalDataException {
        super(name, breed, birthDate, preferredLoverBreed);
    }

    public Cat(String name, String breed, LocalDate birthDate, AnimalSize size, AnimalSize friendSize) throws InvalidAnimalDataException, AnimalSearchTypeException {
        super(name, breed, birthDate, size, friendSize);
    }

    @Override
    public String getVoice() {
        return "Meow!";
    }
}
