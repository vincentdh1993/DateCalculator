// Vincent Lee
// vincelee@brandeis.edu
// COSI 11A, Fall 2015, Section 2
// Programming Assignment #4, 10/29/15

import java.util.*;

public class Problem1
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please type the date: YYYY MM DD"); //ask user to put the date
		int year = input.nextInt(); //ask for the year
		int month = input.nextInt(); //ask for the month
		int day = input.nextInt(); // ask for the day

		int numberDays = calculate(year,month,day); //define the numberDays as the total days different from the user input date and 1601,1,1.
		numberDays = numberDays%7; //divide the date differences to 7.

		switch (numberDays) { //turning the modifiers to the weekdays
			case 0: 
				System.out.println("It's Sunday!");
				break;
							
			case 1:
				System.out.println("It's Monday!");
				break;

			case 2:
				System.out.println("It's Tuesday!") ;
				break;

			case 3:
				System.out.println("It's Wednesday!");
				break;

			case 4:
				System.out.println("It's Thursday!");
				break;

			case 5:
				System.out.println("It's Friday!");
				break;

			case 6:
				System.out.println("It's Saturday!");
				break;
		}
	}

	public static int calculate(int year, int month, int day)
	{
		int yeargap = year-1601; // define yeargap between the userinput and the 1601.
		int leapyear = year/4-400; //define the leapyear for every 100 year.
		
		for(int i = 1; i<=(yeargap/100) ; i++){ //every 100 year, the leap year decreases by 1. So, by using for loop, the leapyear decreases by 1 every 100 year.
			if(i%4!=0){
				leapyear--;
			}
		}

		int days = 365*yeargap; // variable 'days' is the total days difference from the user input date and 1601/1/1.

		if (month <= 2) { // if the month is 1 or 2, 
		
			if(month == 2) { // if the month is february, 
				days=days+31; //add the day 31, which is from january.
				days=days+day; //add the rest day from the days. (January 31 + february day)
			} else { // if the month is january,
				days=days+day; //add the day for the january.
			} if (leapyear>0&&day<29){ //if the leapyear is greater than 0 and the day is less than 29
				leapyear--; //leap year decreseas.
			} 

			days=days+leapyear; //in conclusion, the total days difference is days so far plus the leapyear
		
		} else if (month <=7) { //if the month is less or equal to 7,
			days=days+59; // the 59 is for the 28, from february, and 31, from the january.
			for (int x= 3; x<month ; x++) { //since now the months dealing is between march and july, the int x becomes 3.
		
				if (x%2!=0) { //if the number is odd, the month has 31 days and "30 ,31" keep repeats
					days=days+31; //if the month is odd number, it ends with 31.
				} else {
					days=days+30; // else, the month is even number, the ending month ends with 30.
				}
			} 

			days=days+day; //thus, the days becomes days and the day of the user input

			days = days + leapyear; // in conclusion, the days becomes the days so far plus the leapyear.
		}

		else if (month <= 12) { // if the month is less or equal to 12 

			days=days+212; //the 212 is days combined from january to july.
			for (int y = 8; y< month ; y++) { //since now the months dealing is between august to december, the int y becomes 8.

					if (y%2!=0){ // if the month is odd number, 
						days=days+30; // if the month is odd number, the month ends with 30 days.
					} else { //if the month is even number, the month ends with 31 days.
						days=days+31; //if the month is even number, the month ends with 31 days.
					}
			} 
			days=days+day; // thus the total days is days so far plus the user input day.

			days = days + leapyear; //from the days, the program has to add leapyear.

		}
			return days; //returning the days.

	}

}