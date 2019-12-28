package letcheerful.algorithm.odk;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class javatest {


    static String findNumber(List<Integer> arr, int k) {
        for (Integer integer : arr) {
            if (integer == k) {
                return "YES";
            }
        }
        return "NO";
    }

    @Test
    public void test() {

    }
}
