package Sorting3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given two integer arrays A and B of size N.
 *
 * There are N activities where A[i] denotes the start time of the ith activity and B[i] denotes the finish time of the ith activity.
 * Your task is to select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * Output Format
 *
 * Return the maximum number of activities that can be performed by a single person.
 */
public class ActivitySelection {
    public static void main(String[] args) {
        int[] A = {17, 8, 14, 24, 10, 8, 1, 30};
        int[] B = {18, 45, 24, 27, 18, 10, 38, 35};
        System.out.println(solve(A,B));
    }
    public static int solve(int[] A, int[] B) {
        int n = A.length;

        // create a list of activities with their start and end times
        List<int[]> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new int[]{A[i], B[i]});
        }

        // sort the activities by their end times in ascending order
        activities.sort(Comparator.comparingInt(a -> a[1]));

        // select the activities that can be performed by a single person
        List<int[]> selectedActivities = new ArrayList<>();
        int prevFinishTime = 0;
        for (int[] activity : activities) {
            int startTime = activity[0];
            int finishTime = activity[1];
            if (startTime >= prevFinishTime) {
                selectedActivities.add(activity);
                prevFinishTime = finishTime;
            }
        }

        return selectedActivities.size();
    }
}
