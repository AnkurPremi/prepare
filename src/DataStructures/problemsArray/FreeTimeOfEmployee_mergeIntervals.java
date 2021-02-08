package DataStructures.problemsArray;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FreeTimeOfEmployee_mergeIntervals {
    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        List<Interval> list = new ArrayList<>();

    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // return a.start == b.start ? a.end - b.end : a.start - b.start;
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> {
            return a.start - b.start;
        });

        List<Interval> list = mergeIntervals(schedule, pq);
        return list;
    }

    private List<Interval> mergeIntervals(List<List<Interval>> schedule,  PriorityQueue<Interval> pq){
        List<Interval> list = new ArrayList();

        for(List<Interval> iList : schedule){
            for(Interval interval : iList){
                pq.offer(interval);
            }
        }

        Interval temp = pq.poll();

        while(!pq.isEmpty()){
            Interval interval = pq.poll();
            if(temp.end >= interval.start){
                temp.start = Math.min(interval.start, temp.start);
                temp.end =  Math.max(interval.end, temp.end);
            } else{
                list.add(new Interval(temp.end, interval.start));
                temp = interval;
            }
        }
        return list;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
