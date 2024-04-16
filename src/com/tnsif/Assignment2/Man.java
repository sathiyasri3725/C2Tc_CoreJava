package com.tnsif.Assignment2;
import java.util.Scanner;

public class Man {

	public static void main(String[] args)
	{
		Scanner input =new Scanner (System.in);
	    System.out.println("enter your Fullname_with_initial:");
	    String FullName_with_initial=input.nextLine();
	    System.out.println("enter your RollNo:");
	    String RollNo=input.nextLine();
	    System.out.println("enter your Grade:");
	    String Grade=input.nextLine();
	    System.out.println("enter your Percentage:");
	    int Percentage=input.nextInt();
	    System.out.println(FullName_with_initial);
	    System.out.println(RollNo);
	    System.out.println(Grade);
	    System.out.println(Percentage);

	    
	    }
	}


