public class Programmer extends Worker {

    private int knowledgeLevel;

    public Programmer(String name, String surname, String workEmail, float paymentPerHour) {
        super(name, surname, workEmail, paymentPerHour);
        try {
            setKnowledgeLevel(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Programmer(String name, String surname, String workEmail, float paymentPerHour, int knowledgeLevel){
        this(name, surname, workEmail, paymentPerHour);
        try {
            setKnowledgeLevel(knowledgeLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public float getSalary() {
        float result = getPaymentPerHour() * 40 * 4;
        if (getKnowledgeLevel() >= 9)
            result += 7000;
        else if (getKnowledgeLevel() >= 5)
            result += 4000;
        else if (getKnowledgeLevel() >= 3)
            result += 1000;
        return result;
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(int knowledgeLevel) throws Exception {
        if (knowledgeLevel > 10 || knowledgeLevel < 1)
            throw new Exception("Invalid knowledge level set!");
        this.knowledgeLevel = knowledgeLevel;
    }
}
