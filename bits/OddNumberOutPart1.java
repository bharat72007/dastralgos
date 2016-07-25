package org.ps.bits;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jaibh01 on 7/24/2016.
 * Array of Integers where all numbers are repeated thrice, except one number find that number.
 * Example: Input : {2,4,2,2,8,4,4} Output: 8
 *
 */
public class OddNumberOutPart1 {
    private List<Integer> inputArr;
    private static final Integer INT_SIZE_IN_BITS = Integer.SIZE;

    public OddNumberOutPart1(Integer[] input) {
        this.inputArr = Arrays.asList(input);
    }

    /**
     * Compute the arithmetic sum at all bit positions and find Mod 3.
     * @return
     */
    public int compute() {
        int posSum = 0;
        int num = 0;
        for(int bitPos = 0; bitPos < INT_SIZE_IN_BITS; bitPos++) {
            for (int currNum : inputArr)
                posSum = posSum + ((currNum & (1 << bitPos)) == 0 ? 0 : 1);
            if (0 != posSum % 3) num = num | (1 << bitPos);
            posSum = 0;
        }
        return num;
    }
}
