import exceptions.ChatTypeException;
import exceptions.InvalidChatDataException;

import java.util.ArrayList;
import java.util.EnumSet;

enum ChatType {WORK_CHAT, ANIMAL_CHAT, OTHER_CHAT}

public class Chat {
    private static ArrayList<Chat> chats = new ArrayList<>();
    private String name;
    private String description;
    private int membersNumber;
    private OtherRelatedChat otherRelatedChat;
    private WorkRelatedChat workRelatedChat;
    private AnimalRelatedChat animalRelatedChat;

    Chat(String name, EnumSet<ChatType> chatTypes) throws InvalidChatDataException {
        setName(name);
        setMembersNumber(1);
        setDescription("This chat doesn't posses a description");
        setChatTypes(chatTypes);
        addChat(this);
    }

    Chat(String name, String description, EnumSet<ChatType> chatTypes) throws InvalidChatDataException {
        this(name, chatTypes);
        setDescription(description);
    }

    Chat(String name, String description, int membersNumber, EnumSet<ChatType> chatTypes) throws InvalidChatDataException {
        this(name, description, chatTypes);
        setMembersNumber(membersNumber);
    }

    private static void addChat(Chat chat) {
        if (!chats.contains(chat))
            chats.add(chat);
    }

    public static void removeChat(Chat chat) {
        chats.remove(chat);
    }

    public static void showChats() {
        for (Chat chat : chats)
            System.out.println(chat + "\n");
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

    private void setChatTypes(EnumSet<ChatType> chatTypes) throws InvalidChatDataException {
        if (chatTypes == null || chatTypes.size() == 0)
            throw new InvalidChatDataException("The chat has invalid chat types");
        if (chatTypes.contains(ChatType.WORK_CHAT))
            workRelatedChat = new WorkRelatedChat("Work Name is waiting to be set up");
        if (chatTypes.contains(ChatType.ANIMAL_CHAT))
            animalRelatedChat = new AnimalRelatedChat("Favorite Animal Type is waiting to be set up");
        if (chatTypes.contains(ChatType.OTHER_CHAT))
            otherRelatedChat = new OtherRelatedChat("Main Theme of the chat is waiting to be set up");
    }

    private boolean isWorkChat() {
        return workRelatedChat != null;
    }

    private boolean isAnimalChat() {
        return animalRelatedChat != null;
    }

    private boolean isOtherChat() {
        return otherRelatedChat != null;
    }

    public String getMainTheme() throws ChatTypeException {
        if (isOtherChat())
            return otherRelatedChat.getMainTheme();
        throw new ChatTypeException();
    }

    public void setMainTheme(String mainTheme) throws ChatTypeException {
        if (isOtherChat())
            otherRelatedChat.setMainTheme(mainTheme);
        else
            throw new ChatTypeException();
    }

    public String getWorkName() throws ChatTypeException {
        if (isWorkChat())
            return workRelatedChat.getWorkName();
        throw new ChatTypeException();
    }

    public void setWorkName(String workName) throws ChatTypeException {
        if (isWorkChat())
            workRelatedChat.setWorkName(workName);
        else
            throw new ChatTypeException();
    }

    public String getFavoriteAnimalType() throws ChatTypeException {
        if (isAnimalChat())
            return animalRelatedChat.getFavoriteAnimalType();
        throw new ChatTypeException();
    }

    public void setFavoriteAnimalType(String animalType) throws ChatTypeException {
        if (isAnimalChat())
            animalRelatedChat.setFavoriteAnimalType(animalType);
        else
            throw new ChatTypeException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chat name: ")
                .append(getName())
                .append("\nDescription: ")
                .append(getDescription());
        try {
            if (isAnimalChat()) {
                sb.append("\nChat's favorite animal type: ").append(getFavoriteAnimalType());
            }
            if (isWorkChat()) {
                sb.append("\nChat's work is based around: ").append(getWorkName());
            }
            if (isOtherChat()) {
                sb.append("\nChat's main theme is: ").append(getMainTheme());
            }
        } catch (ChatTypeException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
