
public class LongBitManipulation {

	/**
	 * library for bit manipulation in java (long focused)
	 * */
	

	/**
	 * This method swap 32 least significant bits with 32 most significant bits
	 * 
	 * @param num	The number that the method will swap it's bits
	 * @return		result of swapping
	 * */
	public static long swap(long num){
		long temp = num <<32;
		num>>=32;
		return num|temp;
	}
	
	
	/**
	 * A method that will set a given bit in a number to 1
	 * if given bit equals or less than 0 or more than 64 the method will return number unchanged
	 * if bit within range of 1-64 then the bit will changed if original value is zero
	 * if bit original value 1 then function will return number unchanged
	 * 
	 * @param num	The number which is bit going to be set
	 * @param bit	The bit index which its value going to be set to 1
	 * @return		will return either original number unchanged or new number with given bit changed from 0 to 1
	 */
	public static long setBit(long num, int bit){
		
		if(bit<=0 || bit >64)
			return num;
		else 
			return num|(1<<(bit-1));
	}
	
	
	/**
	 * A method that will set a given bit in a number to 0
	 * if given bit equals or less than 0 or more than 64 the method will return number unchanged
	 * if bit within range of 1-64 then the bit will changed if original value is 1
	 * if bit original value 0 then function will return number unchanged
	 * 
	 * @param num	The number which is bit going to be set
	 * @param bit	The bit index which its value going to be set to 0
	 * @return		will return either original number unchanged or new number with given bit changed from 1 to 0
	 */

	public static long clearBit(long num, int bit){
		
		if(bit<=0 || bit >64)
			return num;
		else {
			long temp = 1<<(bit-1);
			return num&flipAll(temp);
		}
	}
	
	
	/**
	 * A method that will flip all zero bits to ones and ones to zeros (complement of bits)
	 * @param 	num number to be flipped
	 * @return	result of flipping number
	 */
	public static long flipAll(long num) {
		long temp = 4294967295l;
		temp = (temp<<32)|4294967295l;
		return num^temp;
	}
	
	/**
	 * A method will check if a given bit in number is 1
	 * @param num	number that its bit going to be checked
	 * @param bit	index of bit to be checked
	 * @return		if bit value is not in range of 1-64 the method will return false
	 * 				otherwise the method will check bit and return true if value of bit is 1
	 */
	public static boolean isBitSet(long num, int bit){
		
		if( bit<=0 || bit >64)
			return false;
		else
		{
			long checkBit= 1<<(bit-1);
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
	 * @return		if bit value is not in range of 1-64 the method will return false
	 * 				otherwise the method will check bit and return true if value of bit is 0
	 */
	public static boolean isBitClear(long num, int bit){
		
		if( bit<=0 || bit >64)
			return false;
		else
		{
			long checkBit= 1<<(bit-1);
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
	public static long nor (long num1,long num2) {
		
		return flipAll(num1|num2);
	}
	
	/**
	 * A method that will do NAND operation on two numbers
	 * @param num1	first number in NAND
	 * @param num2	second number in NAND
	 * @return		result of (num1 NAND num2)
	 */
	public static long nand (long num1,long num2) {
		return flipAll(num1&num2);
	}
	
	/**
	 * A method that will do XNOR operation on two numbers
	 * @param num1	first number in XNOR
	 * @param num2	second number in XNOR
	 * @return		result of (num1 XNOR num2)
	 */
	public static long xnor (long num1,long num2) {
		return flipAll(num1^num2);
	}
	
	
	/**
	 * A method that will do 1 rotation on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	public static long rotateLeft(long num){
		
		long firstBit = num>>63;
		return (num<<1)|firstBit;
	}
	
	/**
	 * A method that will do n rotations on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	
	public static long rotateLeft(long num,int rotations){
		
		rotations=rotations%64;
		for (int i =0; i < rotations;i++)
			num = rotateLeft(num);
		
		return num;
	}
	
	/**
	 * A method that will do 1 rotation on a number to the right
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	public static long rotateRight(long num){
		
		long lastBit = num&1;
		long temp = (((long)0x7fffffff) <<32) | 4294967295l;
		return ((num>>1)&temp)|(lastBit<<63);
	}
	
	/**
	 * A method that will do n rotations on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	
	public static long rotateRight(long num,int rotations){
		
		rotations=rotations%64;
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
	public static long arrayXor(long[] arr){
		
		long result=0;
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
	public static long arrayOr(long[] arr){
		long result=0;
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
	public static long arrayAnd(long[] arr){
		long result= 4294967295l;
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
	public static long ArrayNor(long[] arr){
		return flipAll(arrayOr(arr));
	}
	
	/**
	 * A method that will perform NAND on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform NAND on it
	 * @return		result of NANDing numbers in the array
	 */
	public static long arrayNand(long[] arr){
		return flipAll(arrayAnd(arr));
	}
	
	/**
	 * A method that will perform XNOR on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform XNOR on it
	 * @return		result of XNORing numbers in the array
	 */
	public static long arrayXnor(long[] arr){
		return flipAll(arrayXor(arr));
	}
	
	/**
	 * A method that will count number of bits in a number that set to 1
	 * @param num	number than its bits going to be counted
	 * @return		number of bits that its value is 1
	 */
	public static long numberOfOnes(long num){
		long result = num&1;
		for(int i=0;i<63;i++)
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
	public static long numberOfZeros(long num){
		
		return 64-numberOfOnes(num);
	}

	
	
	/**
	 * a method will convert a long to short array={bits[0-15],bits[16-31],bits[32-47],bits[48-63]}
	 * @param num number to be converted
	 * @return	short array that contain result
	 */
	public static short[] longToShort(long num) {
		short[] arr = new short[4];
		arr[0] = (short) num;
		arr[1] = (short) (num >>> 16);
		arr[2] = (short) (num >>> 32);
		arr[3] = (short) (num >>> 48);
	
		return arr;
	}
	
	/**
	 * a method will convert a long to byte array {bits[0-7],bits[8-15],bits[16-23]......Bits[56-63]}
	 * @param num number to be converted
	 * @return	byte array that contain result
	 */
	public static byte[] longToByte(long num) {
		byte[] arr = new byte[8];
		
		arr[0] = (byte) num;
		arr[1] = (byte) (num >>> 8);
		arr[2] = (byte) (num >>> 16);
		arr[3] = (byte) (num >>> 24);
		arr[4] = (byte) (num >>> 32);
		arr[5] = (byte) (num >>> 40);
		arr[6] = (byte) (num >>> 48);
		arr[7] = (byte) (num >>> 56);
		
		return arr;
	}
	
	/**
	 * a method will convert a long to char array={bits[0-15],bits[16-31],bits[32-47],bits[48-63]}
	 * @param num number to be converted
	 * @return	char array that contain result
	 */
	public static char[] longToChar(long num) {
		char[] arr = new char[4];
		
		arr[0] = (char) num;
		arr[1] = (char) (num >>> 16);
		arr[2] = (char) (num >>> 32);
		arr[3] = (char) (num >>> 48);
		
		return arr;
	}
	
	/**
	 * a method will convert a long to int array[(index0)LSB(0-31)/  (index1)MSB (32-63)]
	 * @param num number to be converted
	 * @return	char array that contain result
	 */
	public static int[] longToInt(long num) {
		int[] arr = new int[2];
		
		arr[0] = (int) num;
		arr[1] = (int) (num >>> 32);
		
		return arr;
	}
	
	public static int parity(long num) {
		
		long clear= 4294967295l;
		long parity=(num >>32)&clear;
		num= (num&clear)^parity;
		
		for(int i=16;i>=1;i/=2)
		{
			
			parity = num >>i;
			clear = clear>>i;
			num= (num&clear)^parity;
		}

		return (int)num;
	}
	
	/**
	 * A method that will check if long number contains a continuous sequence which bits in it
	 * equal 8 bits in a given byte
	 * the compare is between signed values
	 * @param num 	long value that will have its bits sequences checked
	 * @param word 	byte to be matched with sub sequence
	 * @return return true if match found else return false
	 */
	public static boolean containEqualByte(long num, byte word) {
		boolean result=false;
		for(int i=0;i<=56;i++)
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
	 * A method that will check if long number contains a continuous sequence which bits in it 
	 * equal 16 bits in a given short number
	 * the compare is between signed values
	 * @param num	long that will have its bits sequences checked
	 * @param word	short value to be matched with sub sequence
	 * @return return true if match found else return false
	 */
	public static boolean containEqualShort(long num, short word) {
		boolean result=false;
		for(int i=0;i<=48;i++)
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
	 * A method that will check if long number contains a continuous sequence which bits in it equals 32 
	 * bits in a given integer number
	 * the compare is between signed values
	 * @param num 	long that will have its bits sequences checked
	 * @param word	integer value to be matched with sub sequence
	 * @return return true if match found else return false
	 */
	public static boolean containEqualInteger(long num, int word) {
		boolean result=false;
		for(int i=0;i<=32;i++)
		{
			if((int)num == word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
	
	/**
	 * A method that will check if long number contains a continuous sequence which value of its bits is greater than
	 * value of 8 bits in a given byte
	 * the compare is between signed values
	 * @param num 	long that will have its bits sequences checked
	 * @param word	byte value to be matched with sub sequence
	 * @return return true if such sequence found else return false
	 */
	public static boolean containGreaterByte(long num, byte word) {
		boolean result=false;
		for(int i=0;i<=56;i++)
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
	 * A method that will check if long number contains a continuous sequence which value of its bits is greater than
	 * value of 16 bits in a given short word
	 * the compare is between signed values
	 * @param num 	long that will have its bits sequences checked
	 * @param word 	short value to be matched with sub sequence
	 * @return return true if such sequence found else return false
	 */
	public static boolean containGreaterShort(long num, short word) {
		boolean result=false;
		for(int i=0;i<=48;i++)
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
	 * A method that will check if long number contains a continuous sequence which value of its bits is greater than
	 * value of 32 bits in a given integer word
	 * the compare is between signed values
	 * @param num 	long that will have its bits sequences checked
	 * @param word 	integer value to be matched with sub sequence
	 * @return return true if such sequence found else return false
	 */
	public static boolean containGreaterInteger(long num, int word) {
		boolean result=false;
		for(int i=0;i<=32;i++)
		{
			if((int)num > word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
	
	/**
	 * A method that will check if long number contains a continuous sequence which value of its bits is less than
	 * value of 8 bits in given byte
	 * the compare is between signed values
	 * @param num	long that will have its bits sequences checked
	 * @param word	byte value to be matched with sub sequence
	 * @return return	true if such sequence found else return false
	 */
	public static boolean containLesserByte(long num, byte word) {
		boolean result=false;
		for(int i=0;i<=56;i++)
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
	 * A method that will check if long number contains a continuous sequence which value of its bits is less than
	 * value of 16 bits in given short word
	 * the compare is between signed values
	 * @param num	long that will have its bits sequences checked
	 * @param word	short value to be matched with sub sequence
	 * @return return	true if such sequence found else return false
	 */
	public static boolean containLesserShort(long num, short word) {
		boolean result=false;
		for(int i=0;i<=48;i++)
		{
			if((short)num < word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
	
	/**
	 * A method that will check if long number contains a continuous sequence which value of its bits is less than
	 * value of 32 bits in given integer word
	 * the compare is between signed values
	 * @param num	long that will have its bits sequences checked
	 * @param word	short value to be matched with sub sequence
	 * @return return	true if such sequence found else return false
	 */
	public static boolean containLesserInteger(long num, int word) {
		boolean result=false;
		for(int i=0;i<=32;i++)
		{
			if((int)num < word)
				return true;
			else {
				num=num>>1;
			}
		}
		
		return result;
	}
}
