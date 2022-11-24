//this program is a text based alarm clock which uses dynamic looping and clock
//to alert the user when the appropriate time is reached

package covclock;
import java.util.Scanner;

//creating the main alarm class with methods
public class alarm_cov{
	
	//creating time object from our previous real-time time class
	covclock.presentTime present = new covclock.presentTime();
	int h = present.hour;
	
	//creating the alarm method
	public void checkTime(final int a, final int b) {

		if(present.am_pm.equals("PM"))
				h = present.hour+12;
		System.out.println("You have "+(a-h)+" hours and "+(b-present.min)+" minutes left!\n");
		//using threads
		Thread t = new Thread() {
			public void run() {
				int w1=0;
				while(w1==0) {

					if(a==h&&b==present.min) {
						System.out.println("Wake up! it's time now");
						break; //exiting loop when time matches
					}
				}
			}
		};
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
	}
	public static void main(String[] args) {
		
		//taking the time input from the user
		Scanner scan = new Scanner(System.in);
		System.out.println("enter hours: ");
		int hr = scan.nextInt();
		System.out.println("enter minutes: ");
		int mi  = scan.nextInt();
		
		//calling the alarm method by creating a new object
		alarm_cov ar = new alarm_cov();
		ar.checkTime(hr, mi);
		
	}
}