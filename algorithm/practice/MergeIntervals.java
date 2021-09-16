package algorithm.practice;

import java.util.PriorityQueue;

public class MergeIntervals {
    public static void main(String[] args) {
        PriorityQueue<Interval> list = new PriorityQueue<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(2, 3));
        list.add(new Interval(6, 9));
        list.add(new Interval(1, 15));
        list.add(new Interval(3, 14));
        list.add(new Interval(4, 20));
        list.add(new Interval(3, 27));
        list.add(new Interval(7, 28));
        list.add(new Interval(0, 39));

        PriorityQueue<Interval> mergedList = mergeIntervals(list);

        System.out.println("---------- Original Intervals ----------");
        printIntervals(list);
        System.out.println("---------- Merged Intervals ----------");
        printIntervals(mergedList);
    }

    private static void printIntervals(PriorityQueue<Interval> mergedList) {
        for (Interval each : mergedList) {
            System.out.println(each.from + " - " + each.to);
        }
    }

    private static PriorityQueue<Interval> mergeIntervals(PriorityQueue<Interval> list) {
        PriorityQueue<Interval> mergedList = new PriorityQueue<>();

        PriorityQueue<Interval> tempList = new PriorityQueue<>();
        tempList.addAll(list);

        while (tempList.size() > 0) {
            if (tempList.size() == 1) {
                // Nothing to do just return
                mergedList.add(tempList.poll());
            } else {
                // Take top 2
                Interval top1 = tempList.poll();
                Interval top2 = tempList.poll();

                if (top1.to >= top2.from ) { // Overlap found
                    Interval mergedInterval = new Interval(top1.from, top2.to > top1.to ? top2.to : top1.to);
                    tempList.add(mergedInterval);
                } else {
                    mergedList.add(top1);
                    tempList.add(top2);
                }
            }
        }
        return mergedList;
    }
}

class Interval implements Comparable<Interval> {

    int from;
    int to;

    Interval(int f, int t) {
        this.from = f;
        this.to = t;
    }

    @Override
    public int compareTo(Interval o) {
        return this.from - o.from;
    }

}

