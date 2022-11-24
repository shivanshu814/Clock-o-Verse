//this code if knowing about the present time and date
//this involves the use of interfaces, packages, polymorphism, abstraction, etc to help us know and understand current dates and times


package covclock;
import java.util.*;
import java.text.SimpleDateFormat;

interface current{
	String today();
	String date();
}
//creating a class to get the present time
class presentTime implements current{
	
    //initializing current time terms
	private int phour;
	private int pmin;
	private int psec;
	protected String am_pm = "";
	
	
    // Creating an object of Calendar class
    Calendar cal = Calendar.getInstance();
    
    
    //initializing current date terms
    private int dd = cal.get(Calendar.DAY_OF_MONTH);
    private int yyyy = cal.get(Calendar.YEAR);
    
    Date date=new Date();
    
    //get today's day
    private String tod = new SimpleDateFormat("EEEE").format(date);
    private String tom = new SimpleDateFormat("MMMM").format(date);
    private String mm = new SimpleDateFormat("MM").format(date);
    
    //to get the AM or PM value
    private int x =cal.get(Calendar.AM_PM);
    {
     
    if(x==1)
    	am_pm = "PM";
    else
    	am_pm = "AM";
    	

    phour = cal.get(Calendar.HOUR);

    pmin = cal.get(Calendar.MINUTE);

    psec = cal.get(Calendar.SECOND);
    }
    
    //overriding toString method to print the present time
    public String toString(){
    	return phour+":"+pmin+":"+psec+" "+am_pm;
    }
    
    
    public String today() {
    	return tod+" "+dd+", "+ tom+" "+yyyy+" "+this.toString();
    }
    public String date() {
    	return dd+"/"+mm+"/"+yyyy;
    }
    
    //for printing all individual terms
    public byte hour = (byte) phour;
    public byte min = (byte) pmin;
    public byte sec = (byte) psec;
    public String day  = "Today is "+tod;
    public String month = "This month is "+tom;
    public String year = "this is year "+yyyy;
    
}

public class CovClock {
    public static void main(String[] args)
    {
    	presentTime now = new presentTime();
    	System.out.println(now);
    	System.out.println(now.date());
    	System.out.println(now.today());
    	System.out.println(now.day);
    	System.out.println(now.month);
    	System.out.println(now.year);
    	System.out.println(now.hour);
    	System.out.println(now.min);
    	System.out.println(now.sec);

    }
}


