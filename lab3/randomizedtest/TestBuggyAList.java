package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        for (int i = 0; i < 3; i++) {
            correct.addLast(i);
            broken.addLast(i);
        }

        for (int i = 0; i < 3; i++) {
            assertEquals(correct.size(), broken.size());
            assertEquals(correct.removeLast(), broken.removeLast());
        }
        assertEquals(correct.size(), broken.size());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                assertEquals(correct.size(), broken.size());
            } else if (operationNumber == 1) {
                // size
                int correctSize = correct.size();
                int brokenSize = broken.size();
                assertEquals(correctSize, brokenSize);
            } else if (correct.size() == 0) {

            } else if(operationNumber == 2) {
                // getLast
                assertEquals(correct.getLast(), broken.getLast());
            } else if (operationNumber == 3) {
                assertEquals(correct.removeLast(), broken.removeLast());
                assertEquals(correct.size(), broken.size());
            }

        }
    }
}
