package datamanagement;
public class StudentProxy implements IStudent {
private Integer I_;
private String l_;
private String Il_;
private StudentManager lI;

	public StudentProxy( Integer id, String fn, String Il) {
		this.I_ = id;
	    this.l_ = fn;    
	    this.Il_ = Il_;
	    this.lI = StudentManager.get();
	}
	public Integer getID() { 
		return I_; 
	}
	public String getFirstName() { 
        return l_; 
    }
    public String getLastName() { 
    	return Il_; 
    }
    public void setFirstName(String firstName) {
    	lI.getStudent(I).setFirstName(firstName);
	}
    public void setLastName(String lastName) {
    	lI.getStudent(I).setLastName(lastName);
    }
    public void addUnitRecord(IStudentUnitRecord record) {
        lI.getStudent(I).addUnitRecord(record);
    }
    public IStudentUnitRecord getUnitRecord(String unitCode) {
        return lI.getStudent(I).getUnitRecord(unitCode);}
    	public StudentUnitRecordList getUnitRecords() { 
    		return lI.getStudent(I).getUnitRecords();
    	}
}
