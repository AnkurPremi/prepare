package OOP.CallCentreOOP;

public abstract class Employee {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private int priority;
    private boolean free = true;
    private Call call;

    public Employee(int id, int priority){
        this.id = id;
        this.priority = priority;
    }

    public void setFree() {
        free = true;
        call = null;
    }

    public boolean isFree() {
        return this.free;
    }

    public boolean assignCall(Call call) {
        synchronized (Employee.class) {
            if (isFree()) {
                this.call = call;
                this.free = false;
                return true;
            }
        }
        return false;
    }
}
