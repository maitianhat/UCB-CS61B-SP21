/** Class that prints the Collatz sequence starting from a given number.
 *  @author Gatsby Huang
 */
public class Collatz {

    /**
     * Implementation of nextNumber. The nextNumber function returns the next Collatz number.
     * @param n number greater than 0
     * @return the next Collatz number
     */
    public static int nextNumber(int n) {
        if (n % 2 == 0)
            return n / 2;
        else
            return 3 * n + 1;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

