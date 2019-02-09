//Temple A. Corson IV
//NID: te789951
//Assignment 3: SneakyKnights
//DUE: 01/12/2017
//COP3503CSRPING 0001

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;


public class SneakyKnights
{


public static boolean allTheKnightsAreSafe(ArrayList<String> coordinateStrings, int boardSize)
{
	int i, row, col;
	int numKnights = coordinateStrings.size();
	boolean test;
        
	//if there is only one space or only one knight, they must be safe
	if((numKnights < 2) || (boardSize < 2))
		return true;
        

	//max space complexity, hashset of size n
	//holding at most n objects, is 2n, which is O(n)
	HashSet<Point> bagOfKnights = new HashSet<Point>(numKnights);

        
	//the average case for this is O(n) where n is the number of Knights
	//assuming that the hashing operations have average O(1) runtimes.
	for(i=0;i<numKnights;i++)
	{
		//get coordinates
		row = SneakyKnights.parseRow((coordinateStrings.get(i)));
		col = SneakyKnights.parseCol((coordinateStrings.get(i)));
                
                //point object to temporarily hold a knighted board space
                Point knightSpot = new Point(col, row);
               
		test = bagOfKnights.add(knightSpot);	//put the knight in the hashset
                
		if(!test)
			return false;
		
		//now check all 8 target spaces, but...
		//even if target space is not on the board, it wont matter
		//because a knight will never have been hashed at that spot
                
                Point temp = new Point(knightSpot);
                
		//(x+1, y+2)
		temp.setLocation(col + 1, row + 2);
                
			if((bagOfKnights.contains(temp)))
				return false;
		
                        
		//(x+1, y-2)
		temp.setLocation(col + 1, row - 2);
			
			if((bagOfKnights.contains(temp)))
				return false;


		//(x-1, y+2)
		temp.setLocation(col - 1, row + 2);
	
			if((bagOfKnights.contains(temp)))
				return false;

                        
		//(x-1, y-2)
		temp.setLocation(col - 1, row - 2);
                
			if((bagOfKnights.contains(temp)))
				return false;


		//(x+2, y+1)
		temp.setLocation(col + 2, row + 1);

			if((bagOfKnights.contains(temp)))
				return false;

                        
		//(x+2, y-1)
		temp.setLocation(col + 2, row - 1);

			if((bagOfKnights.contains(temp)))
				return false;


		//(x-2, y+1)
		temp.setLocation(col - 2, row + 1);
			
			if((bagOfKnights.contains(temp)))
				return false;

                        
		//(x-2, y-1)
		temp.setLocation(col - 2, row - 1);
			
			if((bagOfKnights.contains(temp)))
				return false;

                        
	}

	//each knight has been checked, success!
	return true;
}

	//ancillary methods, from those in SneakyQueens.java

	//the following is an O(k) method where k is the number of characters in a coordinate string

	public static int parseCol(String str)		
	{
		int i;
		double j = 0.0;
		int temp = 0;
		int col = 0;
		char ch;


		for(i=0;i<(str.length());i++)
		{
			ch = str.charAt(((str.length() - 1) - i));				//fetch one character at a time

			if(Character.isLetter(ch))							//if a number has been fetched, skip to next
			{
				temp = (ch - 'a') + 1;							//convert letter to digit

				col += (temp * ((int)Math.pow(26.0, j)));		//add weight

				j = j + 1.0;									//increment weight
			}
		}

		return col;
	}

	//the following is an O(i) method where i < k

	public static int parseRow(String str)
	{
		int i;
		double j = 0;
		int temp = 0;
		int row = 0;
		char ch;

		for(i=0;i<(str.length());i++)
		{
			ch = str.charAt(((str.length() - 1) - i));		//fetch char starting at end

			if(Character.isDigit(ch))
			{

				temp = (ch - '1') + 1;							//convert char to digit

				row += (temp * ((int)Math.pow(10.0, j)));
                                
				j = j + 1.0;

			}
			else
				break;
		}

		return row;
	}


//difficulty rating and hoursspent

	public static double difficultyRating()
	{
		return 4.1;
	}

	public static double hoursSpent()
	{
		return 14.0;
	}


}

















































































