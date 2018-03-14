package bhuvi;


import java.io.*;

public class LowerNeatNumber
{
	/**
	 * Find NEAT number less than n - 788 -> 779 (both NEAT)
	 * NEAT number is any number where the digits are in increasing order. 
	 * Digit n should be greater than or equal to digit n-1
	 * Given any number, find the next lower NEAT number in O(log n) time
	 * @param args
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println( "Lesser NEAT number => " +getLowerNeatNumber(br.readLine().trim()));
		}
		
	}
	
	public static String getLowerNeatNumber(String str)
	{
		int i=str.length()-1;
		int second = Character.getNumericValue(str.charAt(i));
		if(i-1>=0)
		{
			int first = Character.getNumericValue(str.charAt(i-1));
			//for last char
			if(second-1<first)
			{
				str = getLowerNeatNumber(str.substring(0,i))+"9";//there can't be anything greater than 9
			}
			else{
				String temp = (Integer.parseInt(str)-1)+"";
				if(isNeat(temp))//currDigit-1 will be greater than/= previous
				{
					return temp;
				}
				else
				{
					str = getLowerNeatNumber(str.substring(0,i))+"9"; //1328 ->132   9  ->13  9  9 ->12  9  9 ->129  9 ->1299
				}
			}
			return str;
		 }
		else{
			return (second-1)+"";
		}
	}
	
	public static boolean isNeat(String s)
	{
		int second,first;
		for(int i=s.length()-1;i>0;i--)
		{
			second = Character.getNumericValue(s.charAt(i));
			first = Character.getNumericValue(s.charAt(i-1));
			if(second<first)
			{
				return false;
			}
		}
		return true;
	}
}
