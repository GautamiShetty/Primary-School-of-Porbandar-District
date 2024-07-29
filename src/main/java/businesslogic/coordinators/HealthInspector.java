package businesslogic.coordinators;

import businesslogic.templates.HealthCheckup;

public class HealthInspector extends Coordinator  implements GeneralReport{
	private HealthCheckup[] healthCheckup = new HealthCheckup[totalIntake];
	public int capacity = 0;	
	
	private static final HealthInspector healthInspector = new HealthInspector();
	
    private HealthInspector(){}

    public static HealthInspector getInstance() {
        return healthInspector;
    }
    
    public HealthInspector controlPanel() {
    	Boolean check = true;    	
    	while(check) {
    		System.out.println("\n---------------------------------------------");
    		System.out.println("Health Inspector Control Panel : ");
    		System.out.println("---------------------------------------------");

    		System.out.println("1. Add Medical Details");
    		System.out.println("2. Update Medical Status");
    		System.out.println("3. Get Medical Details");
    		System.out.println("4. Generate Student Medical Report");
//    		System.out.println("5. Delete Medical Details");
    		System.out.println("0. Log out");
    		System.out.println("---------------------------------------------");
    		System.out.println("Enter your choice : ");
    		int choice = sc.nextInt();
    		
    		switch(choice) 
    		{
	    		case 1: 
	    			addStudentDetails();
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
	
	public void addStudentDetails() {		
		if(capacity < totalIntake) {			
			System.out.println("---------------------------------------------");
			System.out.println("Enter Medical Details :");
			System.out.println("---------------------------------------------");
			
			System.out.println("Enter the Student Id :");
			int studentId = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter Inspection Id :");
			String inspectionId = sc.nextLine();
			
			sc.nextLine();
			System.out.println("Enter the Inspection Type: ");
			String inspectionType = sc.nextLine();
			
			sc.nextLine();
			System.out.println("Enter the Inspection date (DD/MM/YY): ");
			String inspectionDate = sc.nextLine();
			
			sc.nextLine();
			System.out.println("Enter Inspection Result: ");
			String inspectionResult = sc.nextLine();
			
			healthCheckup[capacity++] = new HealthCheckup (studentId, inspectionId, inspectionType, inspectionDate, inspectionResult);
		}
		else {
			System.out.println("No more students are allowed!!!");
		}
		
	}
	
		
	public void getStudentDetails(int studentId) {		
		
		if(studentIdValidation(studentId)) {
			System.out.println("---------------------------------------------");	
			System.out.println("Health details ");
			System.out.println("---------------------------------------------");	
			System.out.println("Inspection Id              : " + healthCheckup[studentId].getInspectionId());
			System.out.println("Student Id                 : " + healthCheckup[studentId].getStudentId());
			System.out.println("Inspection date (DD/MM/YY) : " + healthCheckup[studentId].getInspectionDate());
			System.out.println("Inspection Result          : " + healthCheckup[studentId].getInspectionResult());			
			System.out.println("---------------------------------------------");
		}
		else {
			System.out.println("Student Id is incorrect");
		}
	}
	
	public boolean studentIdValidation (int studentId) {
		
		if(studentId > totalIntake ||studentId < 0) {
			
			return false;
		}
		else {
			if(healthCheckup[studentId] == null) {
				return false;
			}
			return true;
		}
	}
	
	public void updateStudentDetails() {
		System.out.println("Enter student id : ");
		int studentId = sc.nextInt();
		if(studentIdValidation(studentId)) {
			
			boolean check = true;
			int choice = 1;
			
			while(check) {
				
				System.out.println("Which data do you want to update?");
				System.out.println("1. Inspection ID");
				System.out.println("2. Student ID");
				System.out.println("3. Inspection type");
				System.out.println("0. Exit");
				System.out.println("Enter the choice : ");
				choice = sc.nextInt();
				
				if(choice == 1) {
					sc.nextLine();
					System.out.println("Enter the new Inspection Id : ");
					String inspectionId = sc.nextLine();
					healthCheckup[studentId].setInspectorId(inspectionId);
					
				}
				else if(choice == 2) {
					healthCheckup[studentId].setStudentId(studentId);
				}
				else if(choice == 3) {
					sc.nextLine();
					System.out.println("Enter the Inspection type : ");
					String inspectionType = sc.nextLine();
					healthCheckup[studentId].setInspectionType(inspectionType);
				}
				else if(choice == 0) {
					System.out.println("You have not changed anything");
					check = false;
				}
				else {
					System.out.println("Invalid choice");
				}
			}
			if(choice != 0) {
				getStudentDetails(studentId);
			}
		}
		else {
			System.out.println("Invalid student Id!!!");
		}		
	}

	public void generateStudentReport() {
		System.out.println("Student health details report : ");
		System.out.println("------------------------------------------------------------------------------------------");		
		System.out.println(" Student Id | Inspection Id |  Inspection Date   |  Inspection Type  | Inspection Result |");
		System.out.println("------------------------------------------------------------------------------------------");					
		for(HealthCheckup h : healthCheckup) {
			if(h != null)
				System.out.printf(" %10d | %13s | %18s | %17s | %17s|\n",h.getStudentId(), h.getInspectionId(), h.getInspectionDate(), h.getInspectionType(), h.getInspectionResult());
			else
				break;
		}
		System.out.println("------------------------------------------------------------------------------------------");		

	}
//
//	public void deleteStudentDetails(int studentId) {
//		if(studentIdValidation(studentId)) {
//			healthCheckup[studentId] = null;
//			System.out.println("Health related data of " + studentId+ " is successfully deleted");	
//		}
//		else {
//			System.out.println("Student Id is incorrect");
//		}
//	}
	
	public void viewStudentDetails() {
		boolean check = true;
		while(check) 
		{
			System.out.println("1. View Individual Student's Medical data");
			System.out.println("2. View all Student's Medical data");
			System.out.println("0. Exit");
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				GeneralReport report = HealthInspector.getInstance();
				System.out.println("Enter student id: ");
    			int studentId = sc.nextInt();
    					    			
    			if(studentIdValidation(studentId)) {
					report.getStudentDetails(studentId);					
				}
				else {
		    		System.out.println("Student Id is incorrect");
				}
			}
			else if(choice == 2) {
				GeneralReport report = HealthInspector.getInstance();
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