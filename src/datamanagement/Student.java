package datamanagement;

/**
 * Class for the Student entity
 */
public class Student implements IStudent {
  private Integer studentId_;
  private String studentFirstName_;
  private String studentLastName_;
  private StudentUnitRecordList studentUnitRecords_;



  /**
   * Constructor - instantiates the class with class properties.
   * 
   * @param studentId
   * @param studentFirstName
   * @param studentLastName
   * @param studentUnitRecords
   * @return Student
   */
  public Student(Integer studentId, String studentFirstName, String studentLastName,
                 StudentUnitRecordList studentUnitRecords) {
    this.studentId_ = studentId;
    this.studentFirstName_ = studentFirstName;
    this.studentLastName_ = studentLastName;

    if (studentUnitRecords == null) {
      this.studentUnitRecords_ = new StudentUnitRecordList();
    }
    else {
      this.studentUnitRecords_ = studentUnitRecords;
    }
    
  }



  public Integer getID() {
    return this.studentId_; 
  }



  public String getFirstName() { 
    return this.studentFirstName_;
  }



  public void setFirstName(String studentFirstName) { 
    this.studentFirstName_ = studentFirstName;
  }



  public String getLastName() { 
    return this.studentLastName_;
  }



  public void setLastName(String studentLastName) {
    this.studentLastName_ = studentLastName;
  }



  public void addUnitRecord(IStudentUnitRecord studentUnitRecord) {
    this.studentUnitRecords_.add(studentUnitRecord);
  }



  public IStudentUnitRecord getUnitRecord(String unitCode) {
    for (IStudentUnitRecord studentUnitRecord : this.studentUnitRecords_) {
      if (studentUnitRecord.getUnitCode().equals(unitCode)) {
        return studentUnitRecord;
      }
    }
    return null;       
  }



  public StudentUnitRecordList getUnitRecords() {
    return this.studentUnitRecords_;
  }


  
}
