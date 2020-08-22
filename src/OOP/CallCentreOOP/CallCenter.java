package OOP.CallCentreOOP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CallCenter<T extends Employee> {
    private PriorityQueue<T> pQ;
    private ArrayList<T> employees;
    private CallHandler callHandler;
    private Queue<Call> callQueue;

    public CallCenter(ArrayList<T> employees, Queue<Call> queue) {
        this.employees = employees;
        this.callQueue = queue;
        pQ = new PriorityQueue<T>(employees.size(), new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });
        pQ.addAll(employees);
    }

    public void dispatchCall(Call call) throws Exception {
        if (pQ.size() != 0) {
            synchronized (this) {
                if (pQ.size() != 0) {
                    T t = pQ.poll();
                    t.assignCall(call);
                    call.assignEmployee(t);
                }
            }
        }
    }

    public void addEmployee(T t) {
        employees.add(t);
    }

    public void addEmployeeBack(T t) {
        pQ.add(t);
    }


}
