package PersonAndDate;
import java.util.Scanner;

public class Date
{
    private String month;
    private int day;
    private int year; //a four digit number.

    public Date( )
    {//this parentheses can be put in the above line.
        month = "January";
        day = 1;
        year = 1000;
    }

	public Date(String strDate) {
		
	   // Split string into 3 separate integers i.e strDate = "12/25/1971" month = 12;
	   // day = 25; year = 1971;
		// Split the string with the "/" operator
		String parts[] = strDate.split("/");
		// Set Months to equal the first part of the split string array, and initialize a string verision of month 
		String monthString  = monthString(Integer.parseInt(parts[0])); 
		// Set month to equal second part of string array, and year to the third part of
		// the string array. Changing the type from string to integer using parseInt();
		int dayIn = Integer.parseInt(parts[1]);
		int yearIn = Integer.parseInt(parts[2]);
		//Calling the setDate method
		setDate(monthString, dayIn, yearIn);
		
	}

	
   //Date constructor 
	public Date(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

	//Date constructor 
    public Date(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    //Date constructor 
    public Date(int year)
    {
        setDate(1, 1, year);
    }

    //copy constructor
    public Date(Date aDate)
    {
        if (aDate == null)//Not a real date.
        {
             System.out.println("Fatal Error.");
             System.exit(0);
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }
 
  //Date mutator 
    public void setDate(int monthInt, int day, int year)
    {
        if (dateOK(monthInt, day, year))
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Error with Month");
            System.exit(0);
           //return false;
        }
    }

    //Date mutator 
    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    //Date Mutator 
    public void setDate(int year)
    {
        setDate(1, 1, year);
    }
    
    //Year Mutator 
    public void setYear(int year)
    {
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.year = year;
    }
    
    //Month Mutators 
    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    //Day Mutator 
    public void setDay(int day)
    {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Error In Day");
            //System.exit(0);
        }
        else
            this.day = day;
    }

    //Month Accsessor 
    public int getMonth( )
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            //System.out.println("Fatal Error");
            //System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

    //Day Accessor 
    public int getDay( )
    {
    	int newDay = day; 
        return day;
    }
   
    //Year Accessor
    public int getYear( )
    {
        return year;
    }
 
    //Converting date to string 
    public String toString( )
    {
        return (month + " " + day + ", " + year);
        //value will be shown when debugging
        //a very useful feature for dubugging
        //also useful in println(), which
        //automatically call toString();
    }

    //Check if dates equal eachother 
    public boolean equals(Date otherDate)
    {
        return ( (month.equals(otherDate.month))
                  && (day == otherDate.day) && (year == otherDate.year) );
    }

    //Check if one date precedes another 
    public boolean precedes(Date otherDate)
    {
        return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                         && day < otherDate.day) );
    }

    //Read input 
    public void readInput( )
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year. in the formal mm/dd/yyyy");
            System.out.println("Do not use a comma.");
            String input = keyboard.nextLine();
        }
   
    }

    //Did not user this function, given with the date class 
    public static String getInput() { 

		 boolean tryAgain = true;
	     Scanner keyboard = new Scanner(System.in);
	     String input = null; 

	     System.out.println("Enter month, day, and year. in the formal mm/dd/yyyy");
	     System.out.println("Do not use a comma.");
	     input = keyboard.nextLine( );
	     
	     return input;
		
	}
    
    //Method that checks if date is ok 
    boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    
    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    //Checking if month is ok 
    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    //Converting month number into name ie 1 to "January"
    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
            System.out.println("Error With Month");
            //System.exit(0);
            return "Error"; //to keep the compiler happy
        }
    }


}

