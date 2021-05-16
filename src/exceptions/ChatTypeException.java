package exceptions;

public class ChatTypeException extends Exception{
    @Override
    public String toString() {
        return "Chat types does not match this method!";
    }
}
