import exceptions.InvalidPersonDataException;

public class VerifiedChatAdmin extends Worker implements IPerson {

    private String town;
    private int chatPopularityLevel;

    public VerifiedChatAdmin(String name, String surname, String town, String workEmail, float paymentPerHour) throws Exception {
        super(name, surname, workEmail, paymentPerHour);
        try {
            setTown(town);
            setChatPopularityLevel(1);
        } catch (InvalidPersonDataException e) {
            e.printStackTrace();
        }
    }

    public VerifiedChatAdmin(String name, String surname, String town, String workEmail, float paymentPerHour, int chatPopularityLevel) throws Exception {
        super(name, surname, workEmail, paymentPerHour);
        try {
            setTown(town);
            setChatPopularityLevel(chatPopularityLevel);
        } catch (InvalidPersonDataException e) {
            e.printStackTrace();
        }
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) throws InvalidPersonDataException {
        if (town == null)
            throw new InvalidPersonDataException();
        this.town = town;
    }

    public void setChatPopularityLevel(int chatPopularityLevel) throws Exception {
        if (chatPopularityLevel > 10 || chatPopularityLevel < 1)
            throw new Exception("Invalid chat popularity level set!");
        this.chatPopularityLevel = chatPopularityLevel;
    }

    public int getChatPopularityLevel() {
        return chatPopularityLevel;
    }

    @Override
    public float getSalary() {
        float result = getPaymentPerHour() * 40 * 4;
        if (getChatPopularityLevel() >= 9)
            result += 5500;
        else if (getChatPopularityLevel() >= 5)
            result += 2000;
        else if (getChatPopularityLevel() >= 3)
            result += 500;
        return result;
    }

    @Override
    public String getFullInfo() {
        return getName() + " " + getSurname() + " is a Verified Chat Admin" +
                " from " + getTown() + ",\nHis chat has " + getChatPopularityLevel() + " popularity level this far!";
    }
}
