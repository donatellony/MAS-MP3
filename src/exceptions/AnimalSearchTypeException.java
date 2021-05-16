package exceptions;

public class AnimalSearchTypeException extends Exception{
    @Override
    public String toString() {
        return "Animal search preferences does not match this method!";
    }
}
