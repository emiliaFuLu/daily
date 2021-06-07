package why_jvm;

/**
 * @author fl
 * @date 2021年04月22日 22:34
 * @Description
 */

/**
 * PossibleReordering
 * <p/>
 * Insufficiently synchronized program that can have surprising results
 *
 * @author Brian Goetz and Tim Peierls
 */
public class PossibleReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                x = b;
            }
        });
        Thread other = new Thread(new Runnable() {
            public void run() {
                b = 1;
                y = a;
            }
        });
        one.start();
        other.start();
        other.join();
        one.join();
        System.out.println("( " + x + "," + y + ")");
    }
}
    