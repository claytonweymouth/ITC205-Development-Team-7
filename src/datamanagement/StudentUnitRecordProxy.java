package datamanagement;

/**
 * Proxy class for StudentUnitRecordManager objects.
 */
public class StudentUnitRecordProxy
  implements IStudentUnitRecord
{
  private Integer studentId_;
  private String unitCode_;
  private StudentUnitRecordManager manager_;



  /**
   * Constructor
   *
   * @param studentId Integer of the student's ID number
   * @param unitCode String of the relevent unit code
   */
  public StudentUnitRecordProxy( Integer studentId, String unitCode )
  {
    this.studentId_ = studentId;
    this.unitCode_ = unitCode;
    this.manager_ = StudentUnitRecordManager.getInstance();
  }



  /**
   *  Getter for studentId_
   *
   * @return Integer of the current student's ID.
   */
   public Integer getStudentID()
   {
     return studentId_;
   }



  /**
   *  Getter for unitCode_
   *
   * @return String of the current Unit Code
   */
   public String getUnitCode()
   {
     return unitCode_;
   }



  /**
   * Setter (by proxy) for the grade of the first assignment
   *
   * @param float of the mark awarded for the first assingment
   */
  public void setAssignmentGrade1( float mark )
  {
    manager_.getStudentUnitRecord( studentId_, unitCode_ ).setAssignmentGrade1( mark );
  }



  /**
   * Getter (by proxy) for the grade of the first assignment
   *
   * @return float of the mark awarded for the first assingment
   */
  public float getAssignmentGrade1()
  {
    return manager_.getStudentUnitRecord( studentId_, unitCode_ ).getAssignmentGrade1();
  }



  /**
   * Setter (by proxy) for the grade of the second assignment
   *
   * @param float of the mark awarded for the second assingment
   */
  public void setAssignmentGrade2(  float mark)
  {
    manager_.getStudentUnitRecord( studentId_, unitCode_ ).setAssignmentGrade2( mark );
  }



  /**
   * Getter (by proxy) for the grade of the second assignment
   *
   * @return float of the mark awarded for the second assingment
   */
  public float getAssignmentGrade2()
  {
    return manager_.getStudentUnitRecord( studentId_, unitCode_ ).getAssignmentGrade2();
  }



  /**
   * Setter (by proxy) for the grade of the exam
   *
   * @param float of the mark awarded for the exam
   */
  public void setExamGrade( float mark )
  {
    manager_.getStudentUnitRecord( studentId_, unitCode_ ).setExamGrade( mark );
  }



  /**
   * Getter (by proxy) for the grade of the exam
   *
   * @return float of the mark awarded for the exam
   */
  public float getExamGrade()
  {
    return manager_.getStudentUnitRecord( studentId_, unitCode_ ).getExamGrade();
  }



  /**
   * Getter (by proxy) for the total grade
   *
   * @return float of the total mark awarded
   */
  public float getTotalGrade()
  {
    return manager_.getStudentUnitRecord( studentId_, unitCode_ ).getTotalGrade();
  }

}
