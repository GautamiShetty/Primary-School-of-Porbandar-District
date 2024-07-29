package businesslogic.templates;

public class Student 
{
	final private int studentId;
	final private String studentName;
	final private long studentAdhaarNumber;
	private String studentDOB;
	private String studentAddress;
	
	{
		System.out.println("Student has been added successfully!!!");
	}
	
	public Student(int studentId, String studentName, long studentAdhaarNumber, String studentDOB,
			String studentAddress) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAdhaarNumber = studentAdhaarNumber;
		this.studentDOB = studentDOB;
		this.studentAddress = studentAddress;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public long getStudentAdhaarNumber() {
		return studentAdhaarNumber;
	}
	
	public String getStudentDOB() {
		return studentDOB;
	}
	
	public String getStudentAddress() {
		return studentAddress;
	}
	
	public void setStudentDOB(String dOB) {
		studentDOB = dOB;
	}
	
	public void setStudentAddress(String address) {
		this.studentAddress = address;
	}
}