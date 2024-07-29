package businesslogic.templates;

public class Scholarship {
	final private String scholarshipId;
	final private int studentId;
	final private String scholarshipType;
	final private double scholarshipAmount;
	private String scholarshipStatus;

	{
		System.out.println("Scholarship Details are successfully added!");
	}
	
	public String getScholarshipId() {
		return scholarshipId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public String getScholarshipType() {
		return scholarshipType;
	}
	
	public double getScholarshipAmount() {
		return scholarshipAmount;
	}
	
	public String getScholarshipStatus() {
		return scholarshipStatus;
	}
	
	public void setScholarshipStatus(String scholarshipStatus) {
		this.scholarshipStatus = scholarshipStatus;
	}

	public Scholarship(String scholarshipId, int studentId, String scholarshipType, double scholarshipAmount, String scholarshipStatus) {
		
		this.scholarshipId     = scholarshipId;
		this.studentId         = studentId;
		this.scholarshipType   = scholarshipType;
		this.scholarshipAmount = scholarshipAmount;
		this.scholarshipStatus = scholarshipStatus;
	}
}