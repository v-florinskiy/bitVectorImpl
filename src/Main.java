import bitVector.BitVector;

public class Main {
    public static void main(String[] args) {
        try {
            BitVector bitVector = new BitVector(50);
            bitVector.setBit(3);
            bitVector.unsetBit(4);
            System.out.println(bitVector.getBit(3));
            System.out.println(bitVector.getBit(4));
            System.out.println(bitVector.getBit(17));
            System.out.println(bitVector.getBit(-5));
            System.out.println(bitVector.getBit(55));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}