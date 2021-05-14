import exceptions.InvalidWorkerDataException;

import java.util.HashSet;
import java.util.regex.Pattern;

public abstract class Worker {
    private static HashSet<Worker> workers = new HashSet<>();
    
    private int id;
    private static int ID = 0;
    private String email;
    private float paymentPerHour;
    private String name;
    private String surname;

    public Worker(String name, String surname, String workEmail, float paymentPerHour) {
        try {
            setEmail(workEmail);
            setPaymentPerHour(paymentPerHour);
            setName(name);
            setSurname(surname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        id = ++ID;
    }

    public abstract float getSalary(); //Per month

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidWorkerDataException {
        if(name == null)
            throw new InvalidWorkerDataException();
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws InvalidWorkerDataException {
        if(surname == null)
            throw new InvalidWorkerDataException();
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (validateEmail(email))
            this.email = email;
        else
            throw new Exception("Email is not valid!");
    }

    public float getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(float paymentPerHour) throws Exception {
        if (paymentPerHour < 0)
            throw new InvalidWorkerDataException();
        this.paymentPerHour = paymentPerHour;
    }

    private boolean validateEmail(String email) {
        if (email == null)
            return false;
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return emailPattern.matcher(email).find();
    }

    public int getId() {
        return id;
    }

    public static void addWorker(Worker worker) {
        workers.add(worker);
    }

    public static void removeWorker(Worker worker) {
        workers.remove(worker);
    }

    public static void showWorkers() {
        for (Worker p : workers)
            System.out.println(p.toString());
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + ", id: " + getId() + ", worker type: " + getClass().getSimpleName();
    }

}
