package exceptions;

public class InvalidPersonDataException extends Exception{
    @Override
    public String toString() {
        return "The person's data is invalid!";
    }
}
