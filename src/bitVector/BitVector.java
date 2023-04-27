package bitVector;

public class BitVector {
    private int VECTOR_SIZE;

    private int[] bitVector;

    public BitVector(int bitsCount) throws Exception {
        initBitVector(bitsCount);
    }

    private void initBitVector(int bitsCount) throws Exception {
        if(bitsCount < 0) throw new Exception("bitsCount must be >= 0");
        VECTOR_SIZE = bitsCount;
        if(bitsCount == 0) this.bitVector = new int[0];

        int bucketsCount = ((bitsCount - 1) >> 5) + 1;
        this.bitVector = new int[bucketsCount];
    }

    private void validateRange(int bitOrdinalIndex) throws Exception {
        if(bitOrdinalIndex < 0 || bitOrdinalIndex >= VECTOR_SIZE){
            throw new Exception("bitOrdinalIndex must be in a range from 0 to " + (VECTOR_SIZE - 1));
        }
    }

    public void setBit(int bitOrdinalIndex) throws Exception {
        validateRange(bitOrdinalIndex);
        int bucketIndex = bitOrdinalIndex >> 5;
        /*int bitIndexInBucket = bitOrdinalIndex % 32;
        this.bitVector[bucketIndex] |= 1 << bitIndexInBucket;
        optimization: (1 << bitIndexInBucket) equal (1 << bitOrdinalIndex), but delete divide %
        */
        this.bitVector[bucketIndex] |= 1 << bitOrdinalIndex;
    }

    public void unsetBit(int bitOrdinalIndex) throws Exception {
        validateRange(bitOrdinalIndex);
        int bucketIndex = bitOrdinalIndex >> 5;
        /*int bitIndexInBucket = bitOrdinalIndex % 32;
        this.bitVector[bucketIndex] &= ~(1 << bitIndexInBucket);
        optimization: ~(1 << bitIndexInBucket) equal ~(1 << bitOrdinalIndex), but delete divide %
        */
        this.bitVector[bucketIndex] &= ~(1 << bitOrdinalIndex);
    }

    public boolean getBit(int bitOrdinalIndex) throws Exception {
        validateRange(bitOrdinalIndex);
        int bucketIndex = bitOrdinalIndex >> 5;
        /*int bitIndexInBucket = bitOrdinalIndex % 32;
        return ((1 << bitIndexInBucket) & this.bitVector[bucketIndex]) != 0;
        optimization: (1 << bitIndexInBucket) equal (1 << bitOrdinalIndex), but delete divide %
        */
        return ((1 << bitOrdinalIndex) & this.bitVector[bucketIndex]) != 0;
    }
}
