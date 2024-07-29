package businesslogic.coordinators;

import java.util.Scanner;
public abstract class Coordinator {
	final public int totalIntake = 5; 
	
	
	Scanner sc = new Scanner(System.in);
		
	public abstract Coordinator controlPanel();
	public abstract void addStudentDetails();
	public abstract void getStudentDetails(int studentId);
	public abstract boolean studentIdValidation (int id);
	public abstract void updateStudentDetails();
	public abstract void generateStudentReport();
//	public abstract void deleteStudentDetails(String studentId);
	public abstract void viewStudentDetails();
	
}