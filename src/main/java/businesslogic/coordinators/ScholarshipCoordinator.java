package businesslogic.coordinators;

import businesslogic.templates.Scholarship;

public class ScholarshipCoordinator extends Coordinator  implements GeneralReport {
	public int capacity = 0;	
	
	private Scholarship[] scholarship = new Scholarship[totalIntake];
		
	private static final ScholarshipCoordinator scholarshipCoordinator = new ScholarshipCoordinator();
	
    private ScholarshipCoordinator(){}

    public static ScholarshipCoordinator getInstance() {
        return scholarshipCoordinator;
    }    

    public ScholarshipCoordinator controlPanel() {
    	Boolean check = true;    	
    	while(check) {
    		System.out.println("\n---------------------------------------------");
    		System.out.println("Scholarship Coordinator Control Panel : ");
    		System.out.println("---------------------------------------------");
    		System.out.println("1. Add Scholarship Details");
    		System.out.println("2. Update Scholarship Status");
    		System.out.println("3. Get Scholarship Details");
    		System.out.println("4. Generate Student Scholarship Report");
//    		System.out.println("5. Delete Scholarship Details");
    		System.out.println("5. Track Student Scholarship Status");
    		System.out.println("0. Log out");
    		System.out.println("---------------------------------------------");
    		System.out.println("Enter your choice : ");
    		int choice = sc.nextInt();
    		
    		switch(choice) 
    		{
	    		case 1:
					{
						addStudentDetails();	
					}     		
				break;
	    		case 2:
		    		{		    			
		    			updateStudentDetails();	    			
		    		}
					break;
	    		case 3:
		    		{
		    			System.out.println("Enter student id: ");
		    			int studentId = sc.nextInt();
		    					    			
		    			if(studentIdValidation(studentId)) {
		    				getStudentDetails(studentId);		    				
		    			}
		    			else {
		    				System.out.println("Invalid student Id!");
		    			}
		    		}
					break;
	    		case 4:
		    		{
		    			viewStudentDetails();
		    		}
					break;
//	    		case 5:
//		    		{
//		    			System.out.println("Enter student id: ");
//		    			int studentId = sc.nextInt();
//		    			deleteStudentDetails(studentId);
//		    		}
//					break;
	    		case 5:
		    		{
		    			System.out.println("Enter student id: ");
		    			int studentId = sc.nextInt();
		    			trackStudentStatus(studentId);
		    		}
					break;
	    		case 0:
		    		{
		    			System.out.println("Are you sure you want to exit?(Y/N)");
		    			char ch = sc.next().charAt(0);
		    			if(ch == 'Y' || ch == 'y')
		    			{
		    				System.out.println("Logged Out Successfully");
		    				check = false;
		    			}
		    			
		    		}
	    		break;
	    		default:
		    		{
		    			System.out.println("Invalid Choice!");
		    		}
    			}
    	}
    	return null;    	
    }
	
	public void addStudentDetails(){
		if(capacity < totalIntake) {			
			System.out.println("---------------------------------------------");
			System.out.println("Enter Scholarship Details :");
			System.out.println("---------------------------------------------");
			
			sc.nextLine();
			System.out.println("Enter Scholarship Id :");
			String scholarshipId = sc.nextLine();
			
			System.out.println("Enter the Student Id :");			
			int studentId = sc.nextInt();		
			
			if(studentId >= StudentManager.capacity) {
				System.out.println("Entered Student Id does not exist!");
				return;
			}
			
			sc.nextLine();
			System.out.println("Enter the Scholarship type :");
			String scholarshipType = sc.nextLine();
			
			System.out.println("Enter Scholarship Amount :");
			double scholarshipAmount = sc.nextDouble();			
			
			sc.nextLine();
			System.out.println("Enter Scholarship Status :");
			String scholarshipStatus = sc.nextLine();
			
			scholarship[capacity++] = new Scholarship(scholarshipId, studentId, scholarshipType, scholarshipAmount, scholarshipStatus);
			System.out.println();
			getStudentDetails(studentId);
		}
		else {
			System.out.println("No more students are allowed!!!");
		}
	}
	
	public void getStudentDetails(int studentId) {		
		
		if(studentIdValidation(studentId)) {
			System.out.println("---------------------------------------------");		
			System.out.println("Scholarship Details : ");		
			System.out.println("---------------------------------------------");			
			System.out.println("Scholarship Id         : " + scholarship[studentId].getScholarshipId());		
			System.out.println("Student Id             : " + studentId);			
			System.out.println("Scholarship type       : " +  scholarship[studentId].getScholarshipType());			
			System.out.println("Scholarship Amount     : " +  scholarship[studentId].getScholarshipAmount());			
			System.out.println("Scholarship Type       : " +  scholarship[studentId].getScholarshipType());
			System.out.println("---------------------------------------------");
		}
		else{			
			System.out.println("Student Id is incorrect");			
		}		
	}
	
	public boolean studentIdValidation (int studentId) {
		
		if(studentId > totalIntake ||studentId < 0) {
			
			return false;
		}
		else {
			if(scholarship[studentId] == null) {
				return false;
			}
			return true;
		}
	}
	
	public void updateStudentDetails() {
		System.out.println("Enter student id: ");
		int studentId = sc.nextInt();
		
		if(studentIdValidation(studentId)) {			
			System.out.println("Enter the status(pending/receieved) :");
			String scholarshipStatus = sc.nextLine();
			
			scholarship[studentId].setScholarshipStatus(scholarshipStatus);
			
			System.out.println("Status changed Successfully");			
			getStudentDetails(studentId);
    	}
		else {
			System.out.println("Student Id is incorrect");
		}
	}
		
	public void generateStudentReport() {
		System.out.println("Student Scholarship details report : ");
			System.out.println("----------------------------------------------------------------------------------------------------------------------");		
			System.out.println(" Student Id | Scholarship Id |            Scholarship Type                  | Scholarship Amount | Scholarship Status |  ");// 3 12 30 23 13 31
			System.out.println("----------------------------------------------------------------------------------------------------------------------");					
			for(Scholarship s : scholarship) {
				if(s != null)
					System.out.printf(" %10d | %14s | %44s | %18f | %18s|\n",s.getStudentId(), s.getScholarshipId(), s.getScholarshipType(), s.getScholarshipAmount(), s.getScholarshipStatus());
				else
					break;
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------------");		
	}
	
//	public void deleteStudentDetails(int studentId) {
//		if(studentIdValidation(studentId)) {
//			scholarship[studentId] = null;
//			System.out.println("Scholarship data of " + studentId+ " is successfully deleted");
//    	}
//		else {
//			System.out.println("Student Id is incorrect");
//		}
//	}

	public void trackStudentStatus(int studentId) {
		scholarship[studentId].getScholarshipStatus();
	}
	
	public void viewStudentDetails() {
		boolean check = true;
		while(check) 
		{
			System.out.println("1. View Individual Student's Scholarship data");
			System.out.println("2. View all Student's Scholarship data");
			System.out.println("0. Exit");
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				GeneralReport report = ScholarshipCoordinator.getInstance();
				System.out.println("Enter student Id : ");
				int studentId = sc.nextInt();
				if(studentIdValidation(studentId)) {
					report.getStudentDetails(studentId);					
				}
				else {
		    		System.out.println("Student Id is incorrect");
				}
			}
			else if(choice == 2) {
				GeneralReport report = ScholarshipCoordinator.getInstance();
				report.generateStudentReport();;
			}
			else if(choice == 0) {
				check = false;
			}
			else {
				System.out.println("Invalid choice");
			}
		}
	}
}