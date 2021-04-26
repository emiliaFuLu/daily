package hash;

import org.junit.Test;

import java.util.HashMap;

public class hashMapTest {


    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>(20,1);

        for (int i = 0; i < 33333; i++) {
            if (i==32){
                System.out.println("asdasd");
            }
            map.put(""+i,i);
        }
        map.get("30");
        System.out.println(map);
    }

    @Test
    public void test() {
        int n = 3;
        int[][] matrix = new int[n][n];
        int num = 1, t = 0, d = n - 1, l = 0, r = n - 1;
        while (num <= n * n) {
            //从左到右
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num++;
            }
            t++;
            //从上到下
            for (int i = t; i <= d; i++) {
                matrix[i][r] = num++;
            }
            r--;

            //从右到左
            for (int i = r; i >= l; i--) {
                matrix[d][i] = num++;
            }
            d--;

            //从下到上
            for (int i = d; i >= t; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        System.out.println(matrix);
    }
}
