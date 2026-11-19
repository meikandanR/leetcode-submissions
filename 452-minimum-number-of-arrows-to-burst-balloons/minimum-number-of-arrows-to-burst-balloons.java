
import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {

        // 1. Sort by X-start in descending order
        Arrays.sort(points, (a, b) -> Integer.compare(b[0], a[0]));

        int arrows = 0;

        // 2. Maintain the common intersection
        int commonStart = points[0][0];
        int commonEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {

            int start = points[i][0];
            int end = points[i][1];

            // 3. Check whether intervals overlap
            int newStart = Math.max(commonStart, start);
            int newEnd = Math.min(commonEnd, end);

            if (newStart <= newEnd) {

                // Overlapping: update common intersection
                commonStart = newStart;
                commonEnd = newEnd;

            } else {

                // No common intersection: need another arrow
                arrows++;

                // Start a new group
                commonStart = start;
                commonEnd = end;
            }
        }

        // Count the final group
        return arrows + 1;
    }
}
