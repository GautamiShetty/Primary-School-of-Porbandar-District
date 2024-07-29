package businesslogic.templates;

public class HealthCheckup {
	
	private String inspectorId;
	private int studentId;
	private String inspectionType;
	final private String inspectionDate;
	final private String inspectionResult;
	
	public HealthCheckup(int studentId,String inspectorId, String inspectionType, String inspectionDate, String inspectionResult) {
		super();
		this.studentId = studentId;
		this.inspectorId = inspectorId;
		this.inspectionType = inspectionType;
		this.inspectionDate = inspectionDate;
		this.inspectionResult = inspectionResult;
	}

	{
		System.out.println("Health data is successfully updated !!!");
	}

	public String getInspectorId() {
		return inspectorId;
	}

	public void setInspectorId(String inspectorId) {
		this.inspectorId = inspectorId;
	}
	
	public String getInspectionId() {
		return inspectorId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getInspectionDate() {
		return inspectionDate;
	}
	
	public String getInspectionResult() {
		return inspectionResult;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}	
}