package StringII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Problem Description
 * Given an array A of N strings, return all groups of strings that are anagrams.
 * Represent a group by a list of integers representing the index(1-based) in the original list. Look at the sample case for clarification.
 * NOTE: Anagram is a word, phrase, or name formed by rearranging the letters, such as 'spar', formed from 'rasp'.
 * <p>
 * Problem Constraints
 * 1 <= N <= 104
 * 1 <= |A[i]| <= 104
 * Each string consists only of lowercase characters.
 * The sum of the length of all the strings doesn't exceed 107
 * <p>
 * Input Format
 * The first and only argument is an integer array A.
 * <p>
 * Output Format
 * Return a two-dimensional array where each row describes a group.
 * <p>
 * Note:
 * Ordering of the result :
 * You should not change the relative ordering of the strings within the group suppose within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
 */
public class Anagrams {
    public static void main(String[] args) {
        List<String> A = List.of("cat", "dog", "god", "tca");
        System.out.println(anagrams(A));
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> anagramGroups = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        // Build a map of sorted string as key and indices as value
        for (int i = 0; i < A.size(); i++) {
            char[] chars = (A.get(i)).toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(i + 1);
        }

        // Add all groups with more than one element to the result
        for (ArrayList<Integer> group : map.values()) {
            if (!group.isEmpty()) {
                anagramGroups.add(group);
            }
        }

        return anagramGroups;
    }
}
