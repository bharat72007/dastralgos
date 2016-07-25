package org.ps.bits;

/**
 * Created by jaibh01 on 7/25/2016.
 * Integer array is given where all numbers are repeated twice except two numbers, find those
 * two numbers.
 * Example: Input: {2,3,4,4,3,7} Output: {2,7}
 */


public class OddNumberOutPart2 {
    private int[] arr;
    public OddNumberOutPart2(int[] input){
        this.arr = input;
    }

    /**
     * Get two numbers which are not repeated. Find XOR with resultant XOR whose one bit is set.
     * @return
     */
    public int[] getNumbers(){
        int tempXOR = 0;
        int [] output = new int[2];
        int setBitPos = 0;
        for(int num : arr)
            tempXOR = tempXOR ^ num;

        //Find first bit position which is set in tempXOR, then perform XOR's of all numbers whose pos bit is set.
        //This is always true, because two numbers which we need to find are non repetitive
        while(0 ==(tempXOR & (1 << setBitPos)))
            setBitPos ++;

        //Perform XOR of all numbers bit set at pos
        for(int num : arr)
            output[0] = (0 != (num & (1<<setBitPos))) ?  output[0] ^ num : output[0];
        output[1] = output[0] ^ tempXOR;

        return output;
    }
}
