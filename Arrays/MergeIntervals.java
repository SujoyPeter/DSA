package Arrays;

import java.util.*;


public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {

            // No overlap
            if (merged.isEmpty() ||
                merged.get(merged.size() - 1)[1] < interval[0]) {

                merged.add(new int[]{interval[0], interval[1]});

            } else {
                // Overlap → merge
                merged.get(merged.size() - 1)[1] =
                    Math.max(
                        merged.get(merged.size() - 1)[1],
                        interval[1]
                    );
            }
        }

        // Convert List<int[]> to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {

        MergeIntervals sol = new MergeIntervals();

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] result = sol.merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}
