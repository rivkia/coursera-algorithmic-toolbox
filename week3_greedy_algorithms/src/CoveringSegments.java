import java.lang.reflect.Array;
import java.util.*;

public class CoveringSegments {
    private static ArrayList<Integer> optimalPoints(Segment[] segments) {
        ArrayList<Integer> points = new ArrayList<>();
        if (segments.length == 0)
            return points;
        //sort segments by start, end, n log n
        Arrays.sort(segments, (a, b) -> {
            if (a.start == b.start) {
                return Integer.compare(a.end, b.end);
            } else {
                return Integer.compare(a.start, b.start);
            }
        });

        //find max shared number of two nearby numbers
        points.add(segments[0].end);
        for (int i = 1; i < segments.length; i++) {
            if (points.get(points.size() - 1) >= segments[i].start) {
                if (segments[i].end < points.get(points.size() - 1))
                    points.set(points.size() - 1, segments[i].end);
            } else
                points.add(segments[i].end);
        }
        return points;
    }


    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        ArrayList<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
