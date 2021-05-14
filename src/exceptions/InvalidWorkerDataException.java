package exceptions;

public class InvalidWorkerDataException extends Exception{
    @Override
    public String toString() {
        return "Worker's information is invalid!";
    }
}
