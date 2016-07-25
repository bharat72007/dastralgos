package org.ps.bits;

/**
 * Created by jaibh01 on 7/25/2016.
 * A number is sparse, if there is no consecutive set bits.
 * Example: 3 ==> Not Sparse 011, 5 ==>Sparse 101
 */
public class SparseNumber {
    private int number;
    private static final int INT_SIZE_IN_BITS  = Integer.SIZE;
    public SparseNumber(int num){
        number = num;
    }

    public boolean check(){

        number = number < 0 ? -number : number;
        for(int i = 0;  i < INT_SIZE_IN_BITS - 1; i++){
            if(0 != (number & (1<<i)) && 0 != (number & (1 << i+1)))
                return false;
        }

        return true;
    }

    public boolean checkV2(){
        //num & num << 1, if it gives 0 means no present of two consecutive 1's
        //Set the MSB as 0, if it is 1, in case of negative numbers.
        number = number < 0 ? -number : number;
        return 0 == (number & (number << 1));
    }

}
