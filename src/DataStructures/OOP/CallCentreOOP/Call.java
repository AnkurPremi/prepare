package DataStructures.OOP.CallCentreOOP;

public class Call {
    private int number;
    private Employee employee;
    private boolean picked;

    public void assignEmployee(Employee employee) {
        picked = true;
        this.employee = employee;
    }

    public boolean disconnectCall() {
        picked = false;
        if (employee != null) {
            employee.setFree();
            employee = null;
        }
        return true;
    }
}
