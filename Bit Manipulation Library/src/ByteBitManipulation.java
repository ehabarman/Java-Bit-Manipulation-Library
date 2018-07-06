
public class ByteBitManipulation {

	/**
	 * library for bit manipulation in java (byte focused)
	 * list of method in class
	 * 
	 * 1-	byte swap(byte num)
	 * 2-	byte setBit(byte num,int bit)
	 * 3-	byte clearBit(byte num,int bit)
	 * 4-	byte flipAll(byte num)
	 * 5-	boolean isBitClear(byte num, int bit)
	 * 6-	boolean isBitSet(byte num, int bit)
	 * 7-	byte nor (byte num1,byte num2)
	 * 8-	byte nand (byte num1,byte num2)
	 * 9-	byte xnor (byte num1,byte num2)
	 * 10-	byte rotateLeft(byte num)
	 * 11-	byte rotateLeft(byte num,int rotations)
	 * 12-	byte rotateRight(byte num)
	 * 13-	byte rotateRight(byte num,int rotations)
	 * 14-	byte arrayXor(byte[] arr)
	 * 15-	byte arrayOr(short[] arr)
	 * 16-	byte arrayXnor(byte[] arr)
	 * 17-	byte arrayAnd(byte[] arr)
	 * 18-	byte arrayNand(byte[] arr)
	 * 19-	byte arrayNor(byte[] arr)
	 * 20-	int numberOfOnes(byte num)
	 * 21-	int numberOfZeros(byte num)
	 * 22-	int parity(byte num)


	 * */
	
	
	/**
	 * This method swap 4 least significant bits with 4 most significant bits
	 * 
	 * @param num	The number that the method will swap it's bits
	 * @return		result of swapping
	 * */
	public static byte swap(byte num){
		byte temp =(byte)(num<<4);
		num>>=4;
		return (byte) (num|temp);
	}
	
	
	/**
	 * A method that will set a given bit in a number to 1
	 * if given bit equals or less than 0 or more than 8 the method will return number unchanged
	 * if bit within range of 1-8 then the bit will changed if original value is zero
	 * if bit original value 1 then function will return number unchanged
	 * 
	 * @param num	The number which is bit going to be set
	 * @param bit	The bit index which its value going to be set to 1
	 * @return		will return either original number unchanged or new number with given bit changed from 0 to 1
	 */
	public static byte setBit(byte num, int bit){
		
		if(bit<=0 || bit >8)
			return num;
		else 
			return (byte) (num|(1<<(bit-1)));
	}
	
	
	/**
	 * A method that will set a given bit in a number to 0
	 * if given bit equals or less than 0 or more than 8 the method will return number unchanged
	 * if bit within range of 1-8 then the bit will changed if original value is 1
	 * if bit original value 0 then function will return number unchanged
	 * 
	 * @param num	The number which is bit going to be set
	 * @param bit	The bit index which its value going to be set to 0
	 * @return		will return either original number unchanged or new number with given bit changed from 1 to 0
	 */

	public static byte clearBit(byte num, int bit){
		
		if(bit<=0 || bit >8)
			return num;
		else {
			byte temp = (byte) (1<<(bit-1));
			return (byte) (num&flipAll(temp));
		}
	}
	
	
	/**
	 * A method that will flip all zero bits to ones and ones to zeros (complement of bits)
	 * @param 	num number to be flipped
	 * @return	result of flipping number
	 */
	public static byte flipAll(byte num) {
		return (byte) (num^0xff);
	}
	
	/**
	 * A method will check if a given bit in number is 1
	 * @param num	number that its bit going to be checked
	 * @param bit	index of bit to be checked
	 * @return		if bit value is not in range of 1-8 the method will return false
	 * 				otherwise the method will check bit and return true if value of bit is 1
	 */
	public static boolean isBitSet(byte num, int bit){
		
		if( bit<=0 || bit >8)
			return false;
		else
		{
			byte checkBit= (byte) (1<<(bit-1));
			if((bit & checkBit) != 0)
				return true;
			else
				return false;
		}
		
	}
	
	/**
	 * A method will check if a given bit in number is 0
	 * @param num	number that its bit going to be checked
	 * @param bit	index of bit to be checked
	 * @return		if bit value is not in range of 1-8 the method will return false
	 * 				otherwise the method will check bit and return true if value of bit is 0
	 */
	public static boolean isBitClear(byte num, int bit){
		
		if( bit<=0 || bit >8)
			return false;
		else
		{
			byte checkBit= (byte) (1<<(bit-1));
			if((bit & checkBit) == 0)
				return true;
			else
				return false;
		}
		
	}
	
	/**
	 * A method that will do NOR operation on two numbers
	 * @param num1	first number in NOR
	 * @param num2	second number in NOR
	 * @return		result of (num1 NOR num2)
	 */
	public static short nor (byte num1,byte num2) {
		
		return flipAll((byte) (num1|num2));
	}
	
	/**
	 * A method that will do NAND operation on two numbers
	 * @param num1	first number in NAND
	 * @param num2	second number in NAND
	 * @return		result of (num1 NAND num2)
	 */
	public static short nand (byte num1,byte num2) {
		return flipAll((byte) (num1&num2));
	}
	
	/**
	 * A method that will do XNOR operation on two numbers
	 * @param num1	first number in XNOR
	 * @param num2	second number in XNOR
	 * @return		result of (num1 XNOR num2)
	 */
	public static short xnor (byte num1,byte num2) {
		return flipAll((byte) (num1^num2));
	}
	
	
	/**
	 * A method that will do 1 rotation on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	public static byte rotateLeft(byte num){
		
		short firstBit = (byte) (num>>7);
		return (byte) ((num<<1)|firstBit);
	}
	
	/**
	 * A method that will do n rotations on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	
	public static byte rotateLeft(byte num,int rotations){
		
		rotations=rotations%8;
		for (int i =0; i < rotations;i++)
			num = rotateLeft(num);
		
		return num;
	}
	
	/**
	 * A method that will do 1 rotation on a number to the right
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	public static byte rotateRight(byte num){
		
		short lastBit = (byte) (num&1);
		short temp = 0x7f;
		return (byte) (((num>>1)&temp)|(lastBit<<7));
	}
	
	/**
	 * A method that will do n rotations on a number to the right
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	
	public static byte rotateRight(byte num,int rotations){
		
		rotations=rotations%8;
		for (int i =0; i < rotations;i++)
			num = rotateRight(num);
		
		return num;
	}
	
	/**
	 * A method that will perform XOR on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform XOR on it
	 * @return		result of XORing numbers in the array
	 */
	public static byte arrayXor(byte[] arr){
		
		byte result=0;
		for (int i =0 ; i<arr.length;i++)
			result^=arr[i];
		return result;
	}

	/**
	 * A method that will perform OR on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform OR on it
	 * @return		result of ORing numbers in the array
	 */
	public static byte arrayOr(byte[] arr){
		byte result=0;
		for (int i =0 ; i<arr.length;i++)
			result|=arr[i];
		return result;
	}
	
	/**
	 * A method that will perform AND on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform AND on it
	 * @return		result of ANDing numbers in the array
	 */
	public static byte arrayAnd(byte[] arr){
		byte result= (short) 0xffff;
		for (int i =0 ; i<arr.length;i++)
			result&=arr[i];
		return result;
	}

	/**
	 * A method that will perform NOR on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform NOR on it
	 * @return		result of NORing numbers in the array
	 */
	public static byte ArrayNor(byte[] arr){
		return flipAll(arrayOr(arr));
	}
	
	/**
	 * A method that will perform NAND on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform NAND on it
	 * @return		result of NANDing numbers in the array
	 */
	public static byte arrayNand(byte[] arr){
		return flipAll(arrayAnd(arr));
	}
	
	/**
	 * A method that will perform XNOR on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform XNOR on it
	 * @return		result of XNORing numbers in the array
	 */
	public static byte arrayXnor(byte[] arr){
		return flipAll(arrayXor(arr));
	}
	
	/**
	 * A method that will count number of bits in a number that set to 1
	 * @param num	number than its bits going to be counted
	 * @return		number of bits that its value is 1
	 */
	public static byte numberOfOnes(byte num){
		byte result = (byte) (num&1);
		for(int i=0;i<7;i++)
		{
			num=(byte) (num>>1);
			result+=num&1;
		}
		return result;
		
	}


	/**
	 * A method that will count number of bits in a number that set to 0
	 * @param num	number than its bits going to be counted
	 * @return		number of bits that its value is 0
	 */
	public static byte numberOfZeros(byte num){
		
		return (byte) (16-numberOfOnes(num));
	}
		
	public static int parity(byte num) {
		
		byte clear= 0x0f;
		byte parity=(byte) ((num >>4)&clear);
		num= (byte) ((num&clear)^parity);
		
		for(int i=2;i>=1;i/=2)
		{
			
			parity = (byte) (num >>i);
			clear = (byte) (clear>>i);
			num= (byte) ((num&clear)^parity);
		}

		return num;
	}
}