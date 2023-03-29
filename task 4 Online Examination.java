import java.util.*;
import java.lang.*;
 class Exam {

Scanner sc = new Scanner(System.in);
HashMap<String,Integer> details = new HashMap<String,Integer>();

	public void userlogin() {
		details.put("saiteja",2604);
		System.out.println("\n!!! WELCOME TO ONLINE EXAM PORTAL!!!");
		String user;
		int pwd;
		System.out.print("Enter your username : ");
		user = sc.next();
		System.out.print("Enter your password : ");
		pwd= sc.nextInt();
		if(details.containsKey(user)) 
        {
			if(details.get(user)==pwd)
            {
				System.out.println("\nWelcome");
				option_menu();
			}
			else 
            {
				System.out.println("Enter valid Password"+user);
				userlogin();
			}
        }
		else
        {
			System.out.println("Please Enter valid User Name");
		}
    
	}
	public void option_menu() 
    {
		int choice;
		System.out.println("!!!MENU!!!");
		System.out.println("1.Update  Profile\n2.Start  Exam\n3.Exit ");
		System.out.println("Enter Your Choice: ");
		choice = sc.nextInt();
		switch(choice) 
        {
		case 1:
			details=updateDetails();
			option_menu();
			break;
		case 2:
			exam();
			option_menu();
			break;
		case 3:
            System.out.println("Thank You");
			System.exit(0);
			break;
		default:
			System.out.println("Enter valid choice");
		}
	}
	public HashMap<String,Integer> updateDetails()
    {
		String username;
		int userpwd;
		System.out.println("Update Your Profile");
		System.out.println("Enter Username: ");
		username = sc.next();
		if(details.containsKey(username)) 
        {
		System.out.println("Enter New Password ");
		userpwd = sc.nextInt();
		details.replace(username, userpwd);
        System.out.println("Your Details are  Updated Successfully!!!");
		}
		else 
        {
			System.out.println("Enter Valid User Name");
		}
		return details;
	}
public void exam() 
{
    Calendar c = Calendar.getInstance();
	long startTime=System.currentTimeMillis();
	long finishTime=startTime+30;
	int answeredQues=0;
	int userAns,score;
	System.out.println("Let's Start the Exam");
	System.out.println("!!!Instructions to be followed!!!");
	System.out.println("You Have To Answer 5 Questions in 30 Seconds");
	System.out.println("For correct ANswer you will get 10 marks and for wrong answer you will loss 5 marks");
	HashMap<String,ArrayList<String>> ques=new HashMap<String,ArrayList<String>>();
	ArrayList<String> ar1=new ArrayList<String>();
	ar1.add("6");
	ar1.add("7");
	ar1.add("8");
	ar1.add("9");
	ar1.add("3");
	ques.put("Number of primitive data types in Java are?",ar1);
	ArrayList<String> ar2=new ArrayList<String>();
	ar2.add("Dynamic");
	ar2.add("Architecture Neutral");
	ar2.add("Use of pointers");
	ar2.add("Object-oriented");
	ar2.add("3");
	ques.put("Which of the following is not a Java features?",ar2);
	ArrayList<String> ar3=new ArrayList<String>();
	ar3.add("JVM");
	ar3.add("JRE");
	ar3.add("JDK");
	ar3.add("JDB");
	ar3.add("4");
	ques.put("Which of these is used to find and fix bugs in the Java programs.",ar3);
	ArrayList<String> ar4=new ArrayList<String>();
	ar4.add("A final method cannot be overridden in its subclasses.");
	ar4.add("A final class cannot be extended.");
	ar4.add("A final class cannot extend other classes.");
	ar4.add("A final method can be inherited.");
	ar4.add("3");
	ques.put("Which option is false about the final keyword?",ar4);
    ArrayList<String> ar5=new ArrayList<String>();
	ar5.add("Stack");
	ar5.add("Heap memory");
	ar5.add("String memory");
	ar5.add("Random storage space");
	ar5.add("2");
	ques.put("In which memory a String is stored, when we create a string using new operator?",ar5);
	int as=0;
    Set<String> set=ques.keySet(); 
    ArrayList<String> ar6=new ArrayList<>(set);
    int x=ar6.size();
	while(System.currentTimeMillis()<finishTime || as<x) {
        String i=ar6.get(as);
		System.out.println("\n\nQ"+(as+1)+") "+i);
		System.out.println("\n(1) "+ques.get(i).get(0)+"\t"+"(2) "+ques.get(i).get(1)+"\t"+"(3) "+ques.get(i).get(2)+"\t"+"(4) "+ques.get(i).get(3)+" ");
		System.out.println("Enter Your Option");
		userAns=sc.nextInt();
		System.out.println("Answer is Locked");
		if(userAns==Integer.parseInt(ques.get(i).get(4))) {
			answeredQues++;
		}
        as++;
	}
	System.out.println("Your Exam is completed....");
	score=answeredQues*10-((5-answeredQues)*5); 
	System.out.println("Your score is   "+" "+score+"/50");	
}

public static void main (String[] args)
{
	Exam on =new Exam();
		on.userlogin(); 
}
}