package businesslogic.coordinators;
import businesslogic.templates.Student;

public class StudentManager extends Coordinator implements GeneralReport{
	public static int capacity = 0;	
	
	private Student student[] = new Student[totalIntake];
		
	private static final StudentManager Administrator = new StudentManager();
	
    private StudentManager(){}
    
    public static StudentManager getInstance() {
        return Administrator;
    }
    
    public StudentManager controlPanel() {
    	Boolean check = true;    	
    	while(check) {
			System.out.println("\n---------------------------------------------");
    		System.out.println("Student Manager Control Panel : ");
			System.out.println("---------------------------------------------");
    		System.out.println("1. Add Student Details");
    		System.out.println("2. Update Student Address");
    		System.out.println("3. Get Student Details");
    		System.out.println("4. Generate Student Report");
//    		System.out.println("5. Delete Student Details");
    		System.out.println("5. View General Reports");
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
		    				System.out.println("Student Id is incorrect!");
		    			}
		    		}
					break;
	    		case 4:
		    		{
		    			generateStudentReport();
		    		}
					break;
//	    		case 5:
//		    		{		    			
//		    			System.out.println("Enter student id: ");
//		    			int studentId = sc.nextInt();
//		    			if(studentIdValidation(studentId)) {
//		    				deleteStudentDetails(studentId);	    		
//		    			}
//		    			else {
//		    				System.out.println("Student Id is incorrect!");
//		    			}
//		    		}
//					break;
	    		case 5:
		    		{
		    			viewStudentDetails();
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
	
    public void addStudentDetails() {
		if(capacity < totalIntake) {
			System.out.println("--------------------------");
			System.out.println("Enter Student Details :");
			System.out.println("--------------------------");			
			int studentId = capacity;
			
			sc.nextLine();
			System.out.println("Enter Student Name : ");
			String studentName = sc.nextLine();	
			
			long studentAdhaarNumber = 0;
			do {
				System.out.println("Enter Adhaar Number : ");
				studentAdhaarNumber = sc.nextLong();
				if(studentAdhaarNumber <= 111111111111l || studentAdhaarNumber >= 999999999999l) {
					System.out.println("Enter valid Adhaar Number!!");
				}
				
			}while(studentAdhaarNumber <= 111111111111l || studentAdhaarNumber >= 999999999999l);
			
			sc.nextLine();
			System.out.println("Enter Date of Birth (DD/MM/YY): ");
			String studentDOB = sc.nextLine();
			
			System.out.println("Enter the address : ");
			String studentAddress = sc.nextLine();
			
			student[capacity++] = new Student(studentId, studentName, studentAdhaarNumber, studentDOB, studentAddress);		
			getStudentDetails(studentId);
		}
		else {
			System.out.println("Only " + totalIntake + " students intake is allowed!!!");
		}
	}

    public void getStudentDetails(int studentId) {
    	if(studentIdValidation(studentId)) {
    		System.out.println("---------------------------------------------");
    		System.out.println("Student Profile : ");
    		System.out.println("---------------------------------------------");
    		System.out.println("Student Id        : " + student[studentId].getStudentId());
    		System.out.println("Student Name      : " + student[studentId].getStudentName());
    		System.out.println("Adhaar Number     : " + student[studentId].getStudentAdhaarNumber());
    		System.out.println("Date of Birth     : " + student[studentId].getStudentDOB());
    		System.out.println("Address           : " + student[studentId].getStudentAddress());	
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
			if(student[studentId] == null) {
				return false;
			}
			return true;
		}
	}

		
    public void updateStudentDetails() {
		System.out.println("Enter student id: ");
		int studentId = sc.nextInt();
		
		if(studentIdValidation(studentId)) {
			sc.nextLine();
			System.out.println("Enter the New Address : ");
			String address = sc.nextLine();
			
			student[studentId].setStudentAddress(address);
			
			System.out.println("Updated Successfully");
			
			System.out.println("Student data after making changes : ");			
			getStudentDetails(studentId);	
		}
		else {
			System.out.println("Student Id is incorrect !");			
		}			
	}
		
	public void generateStudentReport() {
		if(capacity != 0) {
			System.out.println("General Student details report : ");
			System.out.println("----------------------------------------------------------------------------------------------------------------------");		
			System.out.println(" Student Id |         Student Name         | Student Adhaar Number | Student DOB |          Student Address          |");// 3 12 30 23 13 31
			System.out.println("----------------------------------------------------------------------------------------------------------------------");					
			for(Student s : student) {
				if(s != null)
					System.out.printf(" %10d | %28s | %21d | %11s | %34s|\n",s.getStudentId(),s.getStudentName(), s.getStudentAdhaarNumber(), s.getStudentDOB(), s.getStudentAddress());
				else
					break;
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------------");					
		}
		else {
			System.out.println("No student is inserted yet");
		}

	}

//	public void deleteStudentDetails(int studentId) {
//		if(studentIdValidation(studentId)) {
//			student[studentId] = null;
//			System.out.println("Student data is successfully deleted");
//		}
//		else {
//			System.out.println("Student Id is incorrect");
//		}
//	}
	
	public void viewStudentDetails() {
		GovernmentOfficials governmentOfficial = GovernmentOfficials.getInstance();
		governmentOfficial.generateReport();
	}
}