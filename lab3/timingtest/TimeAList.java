package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();

        for (int i = 0; i < 8; i++) {
            int maxValue = VALUES[i] * 1000;
            AList<Integer> list = new AList<>();

            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < maxValue; j++) {
                list.addLast(i);
            }
            double timeInSeconds = sw.elapsedTime();

            Ns.addLast(maxValue);
            times.addLast(timeInSeconds);
        }

        // print
        printTimingTable(Ns, times, Ns);
    }
    private static final int[] VALUES = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
}
