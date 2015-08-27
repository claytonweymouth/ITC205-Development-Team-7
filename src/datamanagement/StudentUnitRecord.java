package datamanagement;

/**
 * An entity for holding information about a students marks
 * for a given unit.
 */
public class StudentUnitRecord implements IStudentUnitRecord {
  private Integer studentId_;
  private String unitCode_;
  private float assessmentOneMark_, assessmentTwoMark_, examMark_;



  /**
   * Constructor - instantiates the class with class properties.
   * 
   * @param studentId
   * @param unitCode
   * @param assessmentOneMark
   * @param assessmentTwoMark
   * @param examMark
   * @return StudentUnitRecord
   */
  public StudentUnitRecord(Integer studentId, String unitCode, float assessmentOneMark, 
                           float assessmentTwoMark, float examMark) {
    this.studentId_ = studentId;
    this.unitCode_ = unitCode;
    this.setAsg1(assessmentOneMark);
    this.setAsg2(assessmentTwoMark);
    this.setExam(examMark);
  }



  public Integer getStudentID() {
    return this.studentId_;
  }



  public String getUnitCode() {
    return this.unitCode_;
  }



  /**
   * Sets the assessment one mark to the passed value.
   * 
   * @param assessmentOneMark
   * @return void
   * @throws RuntimeException
   */
  public void setAsg1(float assessmentOneMark) {
    if (assessmentOneMark >= 0 &&
        assessmentOneMark <= UnitManager.UM().getUnit(this.unitCode_).getAsg1Weight()) {
      this.assessmentOneMark_ = assessmentOneMark;  
    }
    else {
      throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
    }
  }



  public float getAsg1() {
    return this.assessmentOneMark_;
  }



  /**
   * Sets the assessment two mark to the passed value.
   * 
   * @param assessmentTwoMark
   * @return void
   * @throws RuntimeException
   */
  public void setAsg2(float assessmentTwoMark) {
    if (assessmentTwoMark >= 0 &&
        assessmentTwoMark <= UnitManager.UM().getUnit(this.unitCode_).getAsg2Weight()) {
      this.assessmentTwoMark_ = assessmentTwoMark;  
    }
    else {
      throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
    }
  }



  public float getAsg2() {
    return this.assessmentTwoMark_;
  }



  /**
   * Sets the exam mark to the passed value.
   * 
   * @param examMark
   * @return void
   * @throws RuntimeException
   */
  public void setExam(float examMark) {
    if (examMark >= 0 &&
        examMark <= UnitManager.UM().getUnit(this.unitCode_).getExamWeight()) {
      this.examMark_ = examMark;
    }
    else {
      throw new RuntimeException("Mark cannot be less than zero or greater than assessment weight");
    }
  }



  public float getExam() {
    return this.examMark_;
  }



  public float getTotal() {
    return this.assessmentOneMark_ + this.assessmentTwoMark_ + this.examMark_;
  }



}
