import java.util.ArrayList;
import java.util.Scanner;

//Jabid Methun
//Telephone Number Checker

//Problem:
//For this example, assume a valid telephone number is 10 digits long. 
//However, it cannot have the number 911 in any part of the phone number. 
//In your program, have the user enter a phone number and tell them if it
//is a valid phone number or not WITHOUT USING REGEX. See below for what counts 
//as valid inputs. Remember to check for inputs with correctly formatted parenthesis and dashes.
//
//Valid:
//0123456789
//(012) 345-6789
//012-345-6789
//
//Not valid:
//000911000
//(111) 911-2084
//911-911-0000
//009-110-0000

public class Telephone {
 
	//without Regex
	public static boolean validTelephoneNumber(String s) {
		boolean isValid = false;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		if(s.length()<10 || s.length()>14) {
			//returns false since provided telephone number is either too short or too long
			return isValid;
		}
		else if(s.length() == 10) {
			for(int i =0;i<s.length();i++) {
				//checking if the value provided is an ascii value corresponding to a number from 0-9
				if(((int)s.charAt(i))>= 48 && ((int)s.charAt(i))<=57 ){
					nums.add(Character.getNumericValue(s.charAt(i)));
				}
				else {//if ascii value is not a number, we know that its not a valid phone number since there would be at most 9 digits
					return isValid;
				}
			}
			
			for(int i =0; i<nums.size()-2;i++) {
				//checking if 911 is in the telephone number provided
				if(nums.get(i)==9 && nums.get(i+1)==1 && nums.get(i+2)==1) {
					return isValid;
				}
			}
			
			isValid = true;
			return isValid;
		}
		else {//evaluate telephone numbers that possess parenthesis, spaces and dashes
			for(int i =0;i<s.length();i++) {
				//checking if the value provided is an ascii value corresponding to a number from 0-9
				if(((int)s.charAt(i))>= 48 && ((int)s.charAt(i))<=57 ){
					nums.add(Character.getNumericValue(s.charAt(i)));
				}
				else if(((int)s.charAt(i))== 32 || ((int)s.charAt(i))==45 ||  ((int)s.charAt(i))==40 || ((int)s.charAt(i))==41) {
					//this is checking if the character is a ' ', '-', '(', and ')'
					continue;
				}
				else {
					//if character is neither a number nor the specific characters listed in the else if, 
					//we return false since telephone numbers don't possess other characters
 					return isValid;
				}
			}
			
			if(nums.size()<10) {
				return isValid;
			}
			
			for(int i =0; i<nums.size()-2;i++) {
				//checking if 911 is in the telephone number provided
				if(nums.get(i)==9 && nums.get(i+1)==1 && nums.get(i+2)==1) {
					return isValid;
				}
			}
			
			isValid = true;
			return isValid;
		}	
	}
	
	//with regex
	public static boolean validTelephoneNumberRegex(String s) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
	
		if(s.matches("^\\(?\\d{3}(\\)?|\\-?)\\s?\\d{3}\\-?\\d{4}$")){
			for(int i =0;i<s.length();i++) {
				if(((int)s.charAt(i))>= 48 && ((int)s.charAt(i))<=57 ){
					nums.add(Character.getNumericValue(s.charAt(i)));
				}
			}
			
			for(int i =0; i<nums.size()-2;i++) {
				//checking if 911 is in the telephone number provided
				if(nums.get(i)==9 && nums.get(i+1)==1 && nums.get(i+2)==1) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println( "Please enter a phone number:");
		String teleNum = scan.nextLine();
		//System.out.println(validTelephoneNumber(teleNum));
		if(validTelephoneNumberRegex(teleNum) && validTelephoneNumber(teleNum)) {
			System.out.println("You have entered " +teleNum+ " which is a valid telephone number!");
		}
		else {
			System.out.println("You have entered " +teleNum+ " which is NOT a valid telephone number!");
		}
		scan.close();
	}

}
