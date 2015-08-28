package datamanagement;



public class StudentProxy implements IStudent {
  private Integer I_;
  private String l_;
  private String Il_;
  private StudentManager lI_;



    public StudentProxy( Integer id, String fn, String Il) {
          this.I_ = id;
          this.l_ = fn;    
          this.Il_ = Il_;
          this.lI_ = StudentManager.get();
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
    	lI_.getStudent(I_).setFirstName(firstName);
	}
    
    
    
    public void setLastName(String lastName) {
    	lI_.getStudent(I_).setLastName(lastName);
    }
    
    
    
    public void addUnitRecord(IStudentUnitRecord record) {
        lI_.getStudent(I_).addUnitRecord(record);
    }
    
    
    /**
     * Obtain unit code from student unit record
     * @param unitCode
     * @return lI_
     */
    public IStudentUnitRecord getUnitRecord(String unitCode) {
        return lI_.getStudent(I_).getUnitRecord(unitCode);}
    	public StudentUnitRecordList getUnitRecords() { 
    		return lI_.getStudent(I_).getUnitRecords();
    	}
}
