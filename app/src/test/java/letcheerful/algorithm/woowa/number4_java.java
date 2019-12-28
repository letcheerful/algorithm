package letcheerful.algorithm.woowa;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class number4_java {

    class Solution {
        int solution(int[] A, int[] B) {
            int n = A.length;
            int m = B.length;
            Arrays.sort(A);
            Arrays.sort(B);
            int i = 0;
            for (int k = 0; k < n; k++) {
                System.out.println("K = " + k + " " + "I = " + i);
                System.out.println("A(k) = " + A[k] + " " + "B(i) = " + B[i]);

                while (i < m - 1 && B[i] < A[k])
                    i += 1;
                if (A[k] == B[i])
                    return A[k];

                System.out.println("K = " + k + " " + "I = " + i);
                System.out.println("A(k) = " + A[k] + " " + "B(i) = " + B[i]);
                System.out.println("\n");
            }
            return -1;
        }
    }


    @Test
    public void test1() {
        Solution solution = new Solution();

        int[] A = {6, 8, 12, 22, 25, 77};
        int[] B = {1, 7, 11, 33, 44 , 77};

        Assert.assertEquals(77, solution.solution(A, B));
    }
}
