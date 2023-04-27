# bitVectorImpl
Bit vector implementation

## Example use
```BitVector bitVector = new BitVector(50);

bitVector.setBit(3); //set true on index = 3

bitVector.unsetBit(4); //set false on index = 4

System.out.println(bitVector.getBit(3)); //true

System.out.println(bitVector.getBit(4)); //false

System.out.println(bitVector.getBit(17)); //false

System.out.println(bitVector.getBit(-5)); //error

System.out.println(bitVector.getBit(55)); //error
```
