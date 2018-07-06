
public class ShortBitManipuation {

	/**
	 * library for bit manipulation in java (short focused)
	 * */
	
	
	/**
	 * This method swap 8 least significant bits with 8 most significant bits
	 * 
	 * @param num	The number that the method will swap it's bits
	 * @return		result of swapping
	 * */
	public static short swap(short num){
		short temp =(short)(num<<8);
		num>>=8;
		return (short) (num|temp);
	}
	
	
	/**
	 * A method that will set a given bit in a number to 1
	 * if given bit equals or less than 0 or more than 16 the method will return number unchanged
	 * if bit within range of 1-16 then the bit will changed if original value is zero
	 * if bit original value 1 then function will return number unchanged
	 * 
	 * @param num	The number which is bit going to be set
	 * @param bit	The bit index which its value going to be set to 1
	 * @return		will return either original number unchanged or new number with given bit changed from 0 to 1
	 */
	public static short setBit(short num, int bit){
		
		if(bit<=0 || bit >16)
			return num;
		else 
			return (short) (num|(1<<(bit-1)));
	}
	
	
	/**
	 * A method that will set a given bit in a number to 0
	 * if given bit equals or less than 0 or more than 16 the method will return number unchanged
	 * if bit within range of 1-16 then the bit will changed if original value is 1
	 * if bit original value 0 then function will return number unchanged
	 * 
	 * @param num	The number which is bit going to be set
	 * @param bit	The bit index which its value going to be set to 0
	 * @return		will return either original number unchanged or new number with given bit changed from 1 to 0
	 */

	public static short clearBit(short num, int bit){
		
		if(bit<=0 || bit >16)
			return num;
		else {
			short temp = (short) (1<<(bit-1));
			return (short) (num&flipAll(temp));
		}
	}
	
	
	/**
	 * A method that will flip all zero bits to ones and ones to zeros (complement of bits)
	 * @param 	num number to be flipped
	 * @return	result of flipping number
	 */
	public static short flipAll(short num) {
		return (short) (num^0xffff);
	}
	
	/**
	 * A method will check if a given bit in number is 1
	 * @param num	number that its bit going to be checked
	 * @param bit	index of bit to be checked
	 * @return		if bit value is not in range of 1-16 the method will return false
	 * 				otherwise the method will check bit and return true if value of bit is 1
	 */
	public static boolean isBitSet(short num, int bit){
		
		if( bit<=0 || bit >16)
			return false;
		else
		{
			short checkBit= (short) (1<<(bit-1));
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
	 * @return		if bit value is not in range of 1-16 the method will return false
	 * 				otherwise the method will check bit and return true if value of bit is 0
	 */
	public static boolean isBitClear(short num, int bit){
		
		if( bit<=0 || bit >16)
			return false;
		else
		{
			short checkBit= (short) (1<<(bit-1));
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
	public static short nor (short num1,short num2) {
		
		return flipAll((short) (num1|num2));
	}
	
	/**
	 * A method that will do NAND operation on two numbers
	 * @param num1	first number in NAND
	 * @param num2	second number in NAND
	 * @return		result of (num1 NAND num2)
	 */
	public static short nand (short num1,short num2) {
		return flipAll((short) (num1&num2));
	}
	
	/**
	 * A method that will do XNOR operation on two numbers
	 * @param num1	first number in XNOR
	 * @param num2	second number in XNOR
	 * @return		result of (num1 XNOR num2)
	 */
	public static short xnor (short num1,short num2) {
		return flipAll((short) (num1^num2));
	}
	
	
	/**
	 * A method that will do 1 rotation on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	public static short rotateLeft(short num){
		
		short firstBit = (short) (num>>15);
		return (short) ((num<<1)|firstBit);
	}
	
	/**
	 * A method that will do n rotations on a number to the left
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	
	public static short rotateLeft(short num,int rotations){
		
		rotations=rotations%16;
		for (int i =0; i < rotations;i++)
			num = rotateLeft(num);
		
		return num;
	}
	
	/**
	 * A method that will do 1 rotation on a number to the right
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	public static short rotateRight(short num){
		
		short lastBit = (short) (num&1);
		short temp = 0x7fff;
		return (short) (((num>>1)&temp)|(lastBit<<15));
	}
	
	/**
	 * A method that will do n rotations on a number to the right
	 * @param num	number to be rotated to the left
	 * @return		result of rotation
	 */
	
	public static short rotateRight(short num,int rotations){
		
		rotations=rotations%16;
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
	public static short arrayXor(short[] arr){
		
		short result=0;
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
	public static short arrayOr(short[] arr){
		short result=0;
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
	public static short arrayAnd(short[] arr){
		short result= (short) 0xffff;
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
	public static short ArrayNor(short[] arr){
		return flipAll(arrayOr(arr));
	}
	
	/**
	 * A method that will perform NAND on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform NAND on it
	 * @return		result of NANDing numbers in the array
	 */
	public static short arrayNand(short[] arr){
		return flipAll(arrayAnd(arr));
	}
	
	/**
	 * A method that will perform XNOR on all numbers in a given array
	 * 
	 * @param arr	array of numbers to perform XNOR on it
	 * @return		result of XNORing numbers in the array
	 */
	public static short arrayXnor(short[] arr){
		return flipAll(arrayXor(arr));
	}
	
	/**
	 * A method that will count number of bits in a number that set to 1
	 * @param num	number than its bits going to be counted
	 * @return		number of bits that its value is 1
	 */
	public static short numberOfOnes(short num){
		short result = (short) (num&1);
		for(int i=0;i<15;i++)
		{
			num=(short) (num>>1);
			result+=num&1;
		}
		return result;
		
	}


	/**
	 * A method that will count number of bits in a number that set to 0
	 * @param num	number than its bits going to be counted
	 * @return		number of bits that its value is 0
	 */
	public static short numberOfZeros(short num){
		
		return (short) (16-numberOfOnes(num));
	}

	
	
	/**
	 * a method will convert a shot to byte array {bits[0-7],bits[8-15]}
	 * @param num number to be converted
	 * @return	byte array that contain result
	 */
	public static byte[] shortToByte(short num) {
		byte[] arr = new byte[2];
		
		arr[0] = (byte) num;
		arr[1] = (byte) (num >>> 8);
		
		return arr;
	}
	
		
	public static int parity(short num) {
		
		short clear= 0x00ff;
		short parity=(short) ((num >>8)&clear);
		num= (short) ((num&clear)^parity);
		
		for(int i=4;i>=1;i/=2)
		{
			
			parity = (short) (num >>i);
			clear = (short) (clear>>i);
			num= (short) ((num&clear)^parity);
		}

		return num;
	}
	
	/**
	 * A method that will check if short number contains a continuous sequence which bits in it
	 * equal 8 bits in a given byte
	 * the compare is between signed values
	 * @param num 	short value that will have its bits sequences checked
	 * @param word 	byte to be matched with sub sequence
	 * @return return true if match found else return false
	 */
	public static boolean containEqualByte(short num, byte word) {
		boolean result=false;
		for(int i=0;i<=8;i++)
		{
			if((byte)num == word)
				return true;
			else {
				num=(short) (num>>1);
			}
		}
		
		return result;
	}
	
	
	
	
	/**
	 * A method that will check if short number contains a continuous sequence which value of its bits is greater than
	 * value of 8 bits in a given byte
	 * the compare is between signed values
	 * @param num 	short that will have its bits sequences checked
	 * @param word	byte value to be matched with sub sequence
	 * @return return true if such sequence found else return false
	 */
	public static boolean containGreaterByte(short num, byte word) {
		boolean result=false;
		for(int i=0;i<=8;i++)
		{
			if((byte)num > word)
				return true;
			else {
				num=(short) (num>>1);
			}
		}
		
		return result;
	}
	
	
	
	
	
	/**
	 * A method that will check if short number contains a continuous sequence which value of its bits is less than
	 * value of 8 bits in given byte
	 * the compare is between signed values
	 * @param num	short that will have its bits sequences checked
	 * @param word	byte value to be matched with sub sequence
	 * @return return	true if such sequence found else return false
	 */
	public static boolean containLesserByte(short num, byte word) {
		boolean result=false;
		for(int i=0;i<=8;i++)
		{
			if((byte)num < word)
				return true;
			else {
				num=(short) (num>>1);
			}
		}
		
		return result;
	}
	

	
}
