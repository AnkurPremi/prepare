package DataStructures.OOP.CallCentreOOP;

import java.util.LinkedList;
import java.util.Queue;

public class CallHandler {

    private Queue<Call> callQ;
    private CallCenter callCenter;

    public CallHandler(){
        callQ = new LinkedList<>();
    }

    //This is should be randomly assign the call to
    //respondent if free or manager or director
    public void addToQ(Call call) {
        callQ.add(call);
    }

    public void receiveCall(Call call) throws Exception {
        callCenter.dispatchCall(call);
    }

}

