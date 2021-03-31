package greedy;

import util.Pair;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       Utility.activitySelection(Arrays.asList(new Pair(10, 20), new Pair<>(5, 40) ,new Pair<>(20, 30)));
        System.out.println(Utility.ropeCuttingProblem(Arrays.asList(2, 3, 6, 8)));
    }
}
