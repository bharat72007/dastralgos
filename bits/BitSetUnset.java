package org.ps.bits;

/**
 * Created by jaibh01 on 7/25/2016.
 */
public class BitSetUnset {
    private int pos;
    private int num;
    private static final int INT_SIZE_IN_BITS = Integer.SIZE;
    public BitSetUnset(int position, int number){
        this.pos = position;
        num = number;
    }

    /**
     * Set Bit Position.
     */
    public int setBit(){
        num = num | (1 << pos);
        return num;
    }

    public int unsetBit(){
        num = num & ~(1 << pos);
        return num;
    }
}
