package greedy;

import util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Utility {

    public static void activitySelection(List<Pair<Integer, Integer>> activities) {
        Collections.sort(activities,
                Comparator.comparingInt(Pair::getSecond));
        System.out.println(activities.get(0));
        for(int i=1;i<activities.size();i++) {

            Pair<Integer, Integer> previous = activities.get(i-1);
            Pair<Integer, Integer> current = activities.get(i);
            if(previous.getSecond() <= current.getFirst()) {
                System.out.println(current);
            }
        }
    }
    public static int ropeCuttingProblem(List<Integer> ropes) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.addAll(ropes);
        int cost = 0;
        while (queue.size() != 1) {
            int first = queue.poll();
            int second = queue.poll();
            int resultant = first + second;
            cost = cost + resultant;
            queue.add(resultant);
        }
        return cost;
    }
}
