package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author: fl
 * @data: 2021-01-13 11:55
 * @description:
 **/
public class VolatileTest {

    private static boolean flag = false;
    private static int i = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                flag = true;
                System.out.println("flag 被修改成 true");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        while (!flag) {
            i++;
        }
        System.out.println("程序结束,i=" + i);
    }
}
