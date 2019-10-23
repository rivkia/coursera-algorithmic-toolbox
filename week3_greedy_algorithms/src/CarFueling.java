import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, ArrayList<Integer> stops) {
        if (stops.size() == 0) return -1;
        int i = 0;
        int refills = 0;
        int previousStop = 0;
        stops.add(dist);
        while (i < stops.size()) {
            int distance = 0;
            do {
                if (stops.get(i) - previousStop > tank)
                    return -1;
                distance += stops.get(i) - previousStop;
                previousStop = stops.get(i);
                i++;
            } while (i < stops.size() && distance + stops.get(i) - previousStop < tank);


            if (i < stops.size()) {
                boolean isNextStop = i < stops.size() - 1;
                //only if it is not end of the way and we didn't left tunk we will refill
                if (isNextStop && distance + stops.get(i) - previousStop >= tank)
                    refills++;
                if (!isNextStop && distance + stops.get(i) - previousStop > tank)
                    refills++;
            }
        }
        return refills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<Integer> stops = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            stops.add(scanner.nextInt());
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
