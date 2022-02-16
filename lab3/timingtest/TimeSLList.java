package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCount = new AList<>();

        int lastMaxValue;
        int maxValue = 0;
        SLList<Integer> list = new SLList<>();
        for (int i = 0; i < 8; i++) {
            lastMaxValue = maxValue;
            maxValue = VALUES[i] * 1000;
            for (int j = lastMaxValue; j < maxValue; j++) {
                list.addLast(j);
            }

            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < MAX_OPS; j++) {
                list.getLast();
            }
            double timeInSeconds = sw.elapsedTime();

            Ns.addLast(maxValue);
            times.addLast(timeInSeconds);
            opCount.addLast(MAX_OPS);
        }

        // print
        printTimingTable(Ns, times, opCount);
    }

    private static final int MAX_OPS = 10000;
    private static final int[] VALUES = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
}
