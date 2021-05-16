import exceptions.InvalidChatDataException;

public class Chat {
    private String name;
    private String description;
    private int membersNumber;

    Chat(String name) throws InvalidChatDataException {
        setName(name);
        setMembersNumber(1);
        setDescription("This chat doesn't posses a description");
    }

    Chat(String name, String description) throws InvalidChatDataException {
        this(name);
        setDescription(description);
    }

    Chat(String name, String description, int membersNumber) throws InvalidChatDataException {
        this(name, description);
        setMembersNumber(membersNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidChatDataException {
        if (name == null)
            throw new InvalidChatDataException("Chat name is invalid!");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMembersNumber() {
        return membersNumber;
    }

    public void setMembersNumber(int membersNumber) throws InvalidChatDataException {
        if (membersNumber < 1)
            throw new InvalidChatDataException("Chat members number cannot be lower than 1!");
        this.membersNumber = membersNumber;
    }
}
