package com.tnsif.Assignment2;

public class Main {

	public static void main(String[] args)
	{
		Student student =new Student();
		Commision commission =new Commision();
		commission.AcceptDetails_Employee("Sathiya","48, Alaguapuripattanam",956644386,70000);
		double commisionAmount =commission.CalculateCommission();
		System.out.println("Commission amount:$"+commisionAmount);
	}

}
