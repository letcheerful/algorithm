package letcheerful.algorithm.odk;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddNumbers {


    // Complete the oddNumbers function below.
    static List<Integer> oddNumbers(int l, int r) {

        ArrayList<Integer> oddNumbers = new ArrayList<>();

        if (l % 2 == 0) l = l + 1;

        for (Integer oddNumber = l; oddNumber <= r; oddNumber += 2) {
            oddNumbers.add(oddNumber);
        }

        return oddNumbers;
    }

    @Test
    public void test() {
        Assert.assertEquals(Arrays.asList(3, 5), oddNumbers(2, 5));
    }
}
