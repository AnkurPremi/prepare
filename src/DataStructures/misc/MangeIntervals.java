package DataStructures.misc;

import java.util.*;

public class MangeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5, 20));
        intervals.add(new Interval(3, 6, 15));
        intervals.add(new Interval(2, 8, 25));
        intervals.add(new Interval(7, 12, 18));
        intervals.add(new Interval(1, 31, 22));
        new MangeIntervals().sortIntervals(intervals);
    }

    public List<Interval> sortIntervals(List<Interval> intervals) {

        LinkedList<Interval> result = new LinkedList<>();

        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> {
            return a.start != b.start ? a.start - b.start : a.end != b.end ? a.end - b.end : a.cost - b.cost;
        });

        for (Interval interval : intervals) {
            pq.offer(interval);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq);
            Interval interval = pq.poll();
            System.out.println(pq);
            if (result.isEmpty()) {
                result.addLast(interval);
                continue;
            }

            if (interval.start == result.peekLast().start) {
                if (interval.cost > result.peekLast().cost && interval.end > result.peekLast().end) {
                    pq.offer(new Interval(result.peekLast().end + 1, interval.end, interval.cost));
                } else if (interval.cost < result.peekLast().cost) {
                    if (interval.end > result.peekLast().end) {
                        result.pollLast();
                        result.addLast(interval);
                    } else {
                        Interval interval1 = result.pollLast();
                        result.addLast(interval);
                        pq.offer(new Interval(interval.end + 1, interval1.end, interval1.cost));
                    }
                }
            } else if (interval.start > result.peekLast().start && interval.start < result.peekLast().end) {
                if (interval.cost < result.peekLast().cost) {
                    result.peekLast().end = interval.start - 1;
                    result.addLast(interval);
                } else if (interval.cost > result.peekLast().cost) {
                    if (interval.end > result.peekLast().end) {
                        pq.offer(new Interval(result.peekLast().end + 1, interval.end, interval.cost));
                    }
                }
            } else if (interval.start > result.peekLast().end) {
                result.addLast(interval);
            }else if(interval.start == result.peekLast().end){
                interval.start = result.peekLast().end+1;
                pq.offer(interval);
            }

        }
        System.out.println(result);
        return result;
    }

    static class Interval {
        int start;
        int end;
        int cost;

        Interval(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public String toString() {
            String s = "start: " + start;
            s += " end: " + end;
            s += " cost: " + cost;
            s += " || ";
            return s;
        }
    }
}
