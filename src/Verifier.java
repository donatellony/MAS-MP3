public class Verifier extends Worker {

    private int verificationsNumber;

    public Verifier(String name, String surname, String workEmail, float paymentPerHour) {
        super(name, surname, workEmail, paymentPerHour);
        try {
            setVerificationsNumber(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Verifier(String name, String surname, String workEmail, float paymentPerHour, int verificationsNumber) {
        this(name, surname, workEmail, paymentPerHour);
        try {
            setVerificationsNumber(verificationsNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public float getSalary() {
        float salary = getPaymentPerHour() * 40 * 4;
        if (getVerificationsNumber() >= 100)
            salary += 1500;
        else if (getVerificationsNumber() >= 40)
            salary += 1000;
        else if (getVerificationsNumber() >= 20)
            salary += 500;
        return salary;
    }

    public int getVerificationsNumber() {
        return verificationsNumber;
    }

    public void setVerificationsNumber(int verificationsNumber) throws Exception {
        if (verificationsNumber < 0)
            throw new Exception("Worker's verifications number is invalid!");
        this.verificationsNumber = verificationsNumber;
    }
}
