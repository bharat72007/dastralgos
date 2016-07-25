package org.ps.arrays;

/**
 * Created by jaibh01 on 7/25/2016.
 * Given an sorted array where two numbers are swapped, need to find those numbers.
 * Example: Input {1,2,6,4,5,3,7}, Output = {6,3}
 */
public class MisplacedNumbers {
    private int[] arr;
    public MisplacedNumbers(int[] input){
        arr = input;
    }

    /**
     * Scan from left to right to find, if there is broken sequence (ai > ai+1) break
     * Now Scan from right to left to find if there is broken sequence (ai-1 > ai) break
     * @return
     */
    public int[] getNumbers(){
        int [] missingIndex = new int[2];
        int len = arr.length;
        for(int i=0; i<len; i++){
            if(arr[i] > arr[i+1]) {
                missingIndex[0] = i;
                break;
            }
        }
        for(int i = len -1 ; i >=0; i--){
            if(arr[i] < arr[i-1]) {
                missingIndex[1] = i;
                break;
            }
        }
        return missingIndex;
    }
}
