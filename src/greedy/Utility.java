package greedy;

import util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
}
