

public class IntBitManipulation {

	/**
	 * library for bit manipulation in java (Integer focused)
	 * */
	

	/**
	 * This method swaps 16 least significant bits with 16 most significant bits
	 * 
	 * @param num	The number that the method will swap it's bits
	 * @return		result of swapping
	 * */
	public static int swap(int num){
		
		int temp = num <<16;
		num>>=16;
		return num|temp;
	}
	
	
	
	/**
	 * A method that will set a given bit in a number to 1
	 * if given bit equals less than 0 or more than 32 the method will return number unchanged
	 * if bit within range of 1-32 then the bit will changed if original value is zero
	 * if bit original value 1 then function will return number unchanged
	 * 
	 * @param num	The number which is bit going to be set
	 * @param bit	The bit index which its value going to be set to 1
	 * @return		will return either original number unchanged or new number with given bit changed from 0 to 1
	 */
	public static int setBit(int num,int bit){
		
		if(bit<=0 || bit >32)
			return num;
		else 
			return num|(1<<(bit-1));
	}
	
	
	/**
	 * A method that will set a given bit in a number to 0
	 * if given bit equals less than 0 or more than 32 the method will return number unchanged
	 * if bit within range of 1-32 then the bit will changed if original value is 1
	 * if bit original value 0 then function will return number unchanged
	 * 
	 * @param num	The number which is bit going to be set
	 * @param bit	The bit index which its value going to be set to 0
	 * @return		will return either original number unchanged or new number with given bit changed from 1 to 0
	 */
	public static int clearBit(int num,int bit){
		
		if(bit<=0 || bit >32)
			return num;
		else {
			int temp = 1<<(bit-1);
			return num&flipAll(temp);
		}
			
	}
	
	/**
	 * A method that will flip all zero bits to ones and ones to zeros (complement of bits)
	 * @param 	num	number to be flipped
	 * @return	result of flipping number
	 */
	public static int flipAll(int num) {
		
		return num^0xffffffff;
	}
	
	/**
	 * A method will check if a given bit in number is 1
	 * @param num	number that its bit going to be checked
	 * @param bit	index of bit to be checked
	 * @return		if bit value is not in range of 1-32 the method will return false
	 * 				otherwise the method will check bit and return true if value of bit is 1
	 */
	public static boolean isBitSet(int num, int bit){
		
		if( bit<=0 || bit >32)
			return false;
		else
		{
			bit= 1<<(bit-1);
			if((bit & num) != 0)
				return true;
			else
				return false;
		}
		
	}
	
	/**
	 * A method will check if a given bit in number is 0
	 * @param num	number that its bit going to be checked
	 * @param bit	index of bit to be checked
	 * @return		if bit value is not in range of 1-32 the method will return false
	 * 				otherwise the method will check bit and return true if value of bit is 0
	 */
	public static boolean isBitClear(int num, int bit){
		
		if( bit<=0 || bit >32)
			return false;
		else
		{
			bit= 1<<(bit-1);
			if((bit & num) == 0)
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
	public static int nor (int num1,int num2) {
		
		return flipAll(num1|num2);
	}
	
	/**
	 * A method that will do NAND operation on two numbers
	 * @param num1	first number in NAND
	 * @param num2	second number in NAND
	 * @return		result of (num1 NAND num2)
	 */
	public static int nand (int num1,int num2) {
		return flipAll(num1&num2);
	}
	
	/**
	 * A method that will do XNOR operation on two numbers
	 * @param num1	first number in XNOR
	 * @param num2	second number in XNOR
	 * @return		result of (num1 XNOR num2)
	 */
	public static int xnor (int num1,int num2) {
		return flipAll(num1^num2);
	}
	
	
	/**
	 * A method that will do 1 rotation on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	public static int rotateLeft(int num){
		
		int firstBit = num>>31;
		return (num<<1)|firstBit;
	}
	
	/**
	 * A method that will do n rotation on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	
	public static int rotateLeft(int num,int rotations){
		
		rotations=rotations%32;
		for (int i =0; i < rotations;i++)
			num = rotateLeft(num);
		
		return num;
	}
	
	/**
	 * A method that will do 1 rotation on a number to the right
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	public static int rotateRight(int num){
		
		int lastBit = num&1;
		return ((num>>1)&0x7fffffff)|(lastBit<<31);
	}
	
	/**
	 * A method that will do n rotation on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	
	public static int rotateRight(int num,int rotations){
		
		rotations=rotations%32;
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
	public static int arrayXor(int[] arr){
		
		int result=0;
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
	public static int arrayOr(int[] arr){
		int result=0;
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
	public static int arrayAnd(int[] arr){
		int result= 0xffffffff;
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
	public static int ArrayNor(int[] arr){
		return flipAll(arrayOr(arr));
	}
	
	/**
	 * A method that will perform NAND on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform NAND on it
	 * @return		result of NANDing numbers in the array
	 */
	public static int arrayNand(int[] arr){
		return flipAll(arrayAnd(arr));
	}
	
	/**
	 * A method that will perform XNOR on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform XNOR on it
	 * @return		result of XNORing numbers in the array
	 */
	public static int arrayXnor(int[] arr){
		return flipAll(arrayXor(arr));
	}
	
	/**
	 * A method that will count number of bits in a number that set to 1
	 * @param num	number than its bits going to be counted
	 * @return		number of bits that its value is 1
	 */
	public static int numberOfOnes(int num){
		int result = num&1;
		for(int i=0;i<31;i++)
		{
			num=num>>1;
			result+=num&1;
		}
		return result;
		
	}


	/**
	 * A method that will count number of bits in a number that set to 0
	 * @param num	number than its bits going to be counted
	 * @return		number of bits that its value is 0
	 */
	public static int numberOfZeros(int num){
		
		return 32-numberOfOnes(num);
	}

	
	/**
	 * a method will convert an integer to short array [(index0)LSB(0-15)/  (index1)MSB (16-32)]
	 * @param num number to be converted
	 * @return	short array that contain result
	 */
	public static short[] intToShort(int num) {
		short[] arr = new short[2];
		arr[0] = (short) num;
		arr[1] = (short) (num >>> 16);
	
		return arr;
	}
	
	/**
	 * a method will convert an integer to byte array [[0](0-7)/--/[1](8-15)/--/[2](16-23)/--/[3](24-31)]
	 * @param num number to be converted
	 * @return	byte array that contain result
	 */
	public static byte[] intToByte(int num) {
		byte[] arr = new byte[4];
		
		arr[0] = (byte) num;
		arr[1] = (byte) (num >>> 8);
		arr[2] = (byte) (num >>> 16);
		arr[3] = (byte) (num >>> 24);
		
		return arr;
	}
	
	/**
	 * a method will convert an integer to char array [(index0)LSB(0-15)/  (index1)MSB (16-32)]
	 * @param num number to be converted
	 * @return	char array that contain result
	 */
	public static char[] intToChar(int num) {
		char[] arr = new char[2];
		
		arr[0] = (char) num;
		arr[1] = (char) (num >>> 16);
		
		return arr;
	}
	
	
	/**
	 * function that will return parity of a given number
	 * 
	 * @param num	number to find its parity
	 * @return	result is 0 if bits even and  1 if odd
	 */
	public static int parity(int num) {
		
		int clear= 0x0000ffff;
		int parity=(num >>16)&clear;
		num= (num&clear)^parity;
		
		for(int i=8;i>=1;i/=2)
		{
			
			parity = num >>i;
			clear = clear>>i;
			num= (num&clear)^parity;
		
		}

		return num;
	}
	
	
	/**
	 * A method that will check if integer number contains a continuous sequence which bits in it equal 8 bits in a given byte
	 * the compare is between signed values
	 * @param num	integer that will have its bits sequences checked
	 * @param word	byte to be matched with sub sequence
	 * @return return true if match found else return false
	 */
	public static boolean containEqualByte(int num, byte word) {
		boolean result=false;
		for(int i=0;i<=24;i++)
		{
			if((byte)num == word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
	
	/**
	 * A method that will check if integer number contains a continuous sequence which bits in it 
	 * equal 16 bits in a given short number
	 * the compare is between signed values
	 * @param num 	integer that will have its bits sequences checked
	 * @param word	short value to be matched with sub sequence
	 * @return return true if match found else return false
	 */
	public static boolean containEqualShort(int num, short word) {
		boolean result=false;
		for(int i=0;i<=16;i++)
		{
			if((short)num == word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
	
	/**
	 * A method that will check if integer number contains a continuous sequence which value of its bits 
	 * is greater than value of 8 bits in a given byte
	 * the compare is between signed values
	 * @param num 	integer that will have its bits sequences checked
	 * @param word	byte value to be matched with sub sequence
	 * @return return true if such sequence found else return false
	 */
	public static boolean containGreaterByte(int num, byte word) {
		boolean result=false;
		for(int i=0;i<=24;i++)
		{
			if((byte)num > word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
	
	/**
	 * A method that will check if integer number contains a continuous sequence which value of its bits is greater than
	 * value of 16 bits in a given short word
	 * the compare is between signed values
	 * @param num 	integer that will have its bits sequences checked
	 * @param word	short value to be matched with sub sequence
	 * @return return true if such sequence found else return false
	 */
	public static boolean containGreaterShort(int num, short word) {
		boolean result=false;
		for(int i=0;i<=16;i++)
		{
			if((short)num > word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
	
	/**
	 * A method that will check if integer number contains a continuous sequence which value of its bits is less than
	 * value of 8 bits in given byte
	 * the compare is between signed values
	 * @param num 	integer that will have its bits sequences checked
	 * @param word	byte value to be matched with sub sequence
	 * @return return true if such sequence found else return false
	 */
	public static boolean containLesserByte(int num, byte word) {
		boolean result=false;
		for(int i=0;i<=24;i++)
		{
			if((byte)num < word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
	
	/**
	 * A method that will check if integer number contains a continuous sequence which value of its bits is less than
	 * value of 16 bits in given short word
	 * the compare is between signed values
	 * @param num 	integer that will have its bits sequences checked
	 * @param word	short value to be matched with sub sequence
	 * @return return true if such sequence found else return false
	 */
	public static boolean containLesserShort(int num, short word) {
		boolean result=false;
		for(int i=0;i<=16;i++)
		{
			if((short)num < word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
	
}
