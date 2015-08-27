package datamanagement;

/**
 * An entity representing a unit.
 */
public class Unit implements IUnit {
  private String unitCode_;
  private String unitName_;
  private float cutOffPass_;
  private float cutOffCredit_;
  private float cutOffDistinction_;
  private float cutOffHighDistinction_;
  private float cutOffAdditionalExam_;
  private int assessmentOneWeight_;
  private int assessmentTwoWeight_;
  private int examWeight_;
  private StudentUnitRecordList studentUnitRecordList_;



  /**
   * Constructor - instantiates the class with class properties.
   * 
   * @param unitCode
   * @param unitName
   * @param cutOffPass
   * @param cutOffCredit
   * @param cutOffDistinction
   * @param cutOffHighDistinction
   * @param cutOffAdditionalExam
   * @param assessmentOneWeight
   * @param assessmentTwoWeight
   * @param examWeight
   * @param studentUnitRecordList
   * @return Unit
   */
  public Unit(String unitCode, String unitName, float cutOffPass, float cutOffCredit,
              float cutOffDistinction, float cutOffHighDistinction, float cutOffAdditionalExam,
              int assessmentOneWeight, int assessmentTwoWeight, int examWeight, StudentUnitRecordList studentUnitRecordList) {
    this.unitCode_ = unitCode;
    this.unitName_ = unitName;
    this.cutOffPass_ = cutOffPass;
    this.cutOffCredit_ = cutOffCredit;
    this.cutOffDistinction_ = cutOffDistinction;
    this.cutOffHighDistinction_ = cutOffHighDistinction;
    this.cutOffAdditionalExam_ = cutOffAdditionalExam;
    this.setAssessmentWeights(assessmentOneWeight, assessmentTwoWeight, examWeight);

    if (studentUnitRecordList == null) {
      this.studentUnitRecordList_ = new StudentUnitRecordList();
    }
    else {
      this.studentUnitRecordList_ = studentUnitRecordList;    
    }
    
  }



  public String getUnitCode() {
    return this.unitCode_;
  }



  public String getUnitName() {
    return this.unitName_;
  }



  /**
   * Sets the pass cut-off mark for the unit.
   * 
   * @param cutOffPass
   * @return void
   */
  public void setPsCutoff(float cutOffPass) {
    this.cutOffPass_ = cutOffPass;
  }



  public float getPsCutoff() {
    return this.cutOffPass_;
  }



  /**
   * Sets the credit cut-off mark for the unit.
   * 
   * @param cutOffCredit
   * @return void
   */
  public void setCrCutoff(float cutOffCredit) {
    this.cutOffCredit_ = cutOffCredit;
  }



  public float getCrCutoff() {
    return this.cutOffCredit_;
  }



  /**
   * Sets the distinction cut-off mark for the unit.
   * 
   * @param cutOffDistinction
   * @return void
   */
  public void setDiCutoff(float cutOffDistinction) {
    this.cutOffDistinction_ = cutOffDistinction;
  }



  public float getDiCutoff() {
    return this.cutOffDistinction_;
  }



  /**
   * Sets the high distinction cut-off mark for the unit.
   * 
   * @param cutOffHighDistinction
   * @return void
   */
  public void setHdCutoff(float cutOffHighDistinction) {
    this.cutOffHighDistinction_ = cutOffHighDistinction;
  }



  public float getHdCutoff() {
    return this.cutOffHighDistinction_;
  }



  /**
   * Sets the additional exam cut-off mark for the unit.
   * 
   * @param cutOffAdditionalExam
   * @return void
   */
  public void setAeCutoff(float cutOffAdditionalExam) {
    this.cutOffAdditionalExam_ = cutOffAdditionalExam;
  }



  public float getAeCutoff() {
    return this.cutOffAdditionalExam_;
  }



  /**
   * Adds a StudentUnitRecord to the unit.
   * 
   * @param studentUnitRecord
   * @return void
   */
  public void addStudentRecord(IStudentUnitRecord studentUnitRecord) {
    this.studentUnitRecordList_.add(studentUnitRecord);
  }



  public IStudentUnitRecord getStudentRecord(int studentId) {
    for (IStudentUnitRecord studentUnitRecord : this.studentUnitRecordList_) {
      if (studentUnitRecord.getStudentID() == studentId) {
        return studentUnitRecord;
      }
    }
    return null;
  }



  public StudentUnitRecordList listStudentRecords() {
    return this.studentUnitRecordList_;
  }



  @Override
  public int getAsg1Weight() {
    return this.assessmentOneWeight_;
  }



  @Override
  public int getAsg2Weight() {
    return this.assessmentTwoWeight_;
  }



  @Override
  public int getExamWeight() {
    return this.examWeight_;
  }



  /**
   * Sets the assessment weights.
   * 
   * @param assessmentOneWeight
   * @param assessmentTwoWeight
   * @param examWeight
   * @return void
   * @throws RuntimeException
   */
  @Override
  public void setAssessmentWeights(int assessmentOneWeight, int assessmentTwoWeight, int examWeight) {
    if (assessmentOneWeight < 0 || assessmentOneWeight > 100 ||
        assessmentTwoWeight < 0 || assessmentTwoWeight > 100 ||
        examWeight < 0 || examWeight > 100 ) {
      throw new RuntimeException("Assessment weights cant be less than zero or greater than 100");
    }

    if (assessmentOneWeight + assessmentTwoWeight + examWeight != 100) {
      throw new RuntimeException("Assessment weights must add to 100");
    }

    this.assessmentOneWeight_ = assessmentOneWeight;
    this.assessmentTwoWeight_ = assessmentTwoWeight;
    this.examWeight_ = examWeight;

  }



  /**
   * Sets the grade cutoff thresholds.
   * 
   * @param cutOffPass
   * @param cutOffCredit
   * @param cutOffDistinction
   * @param cutOffHighDistinction
   * @param cutOffAdditionalExam
   * @return void
   * @throws RuntimeException
   */
  private void setCutoffs( float cutOffPass, float cutOffCredit, float cutOffDistinction, float cutOffHighDistinction, float cutOffAdditionalExam) {
    if (cutOffPass < 0 || cutOffPass > 100 ||
        cutOffCredit < 0 || cutOffCredit > 100 ||
        cutOffDistinction < 0 || cutOffDistinction > 100 ||
        cutOffHighDistinction < 0 || cutOffHighDistinction > 100 ||
        cutOffAdditionalExam < 0 || cutOffAdditionalExam > 100 ) {
      throw new RuntimeException("Assessment cutoffs cant be less than zero or greater than 100");
    }
    if (cutOffAdditionalExam >= cutOffPass) {
      throw new RuntimeException("AE cutoff must be less than PS cutoff");
    }
    if (cutOffPass >= cutOffCredit) {
      throw new RuntimeException("PS cutoff must be less than CR cutoff");
    }
    if (cutOffCredit >= cutOffDistinction) {
      throw new RuntimeException("CR cutoff must be less than DI cutoff");
    }
    if (cutOffDistinction >= cutOffHighDistinction) {
      throw new RuntimeException("DI cutoff must be less than HD cutoff");
    }

  }



  /**
   * Gives a two character grade code for the given assessment
   * and exam marks.
   * 
   * @param assessmentOneMark
   * @param assessmentTwoMark
   * @param examMark
   * @return String
   * @throws RuntimeException
   */
  public String getGrade(float assessmentOneMark, float assessmentTwoMark, float examMark) {
    float totalMark = assessmentOneMark + assessmentTwoMark + examMark;

    if (assessmentOneMark < 0 || assessmentOneMark > this.getAsg1Weight() ||
        assessmentTwoMark < 0 || assessmentTwoMark > this.getAsg2Weight() ||
        examMark < 0 || examMark > this.getExamWeight() ) {
      throw new RuntimeException("marks cannot be less than zero or greater than assessment weights");
    }

    if (totalMark < this.getAeCutoff()) {
      return "FL";
    }
    else if (totalMark < this.getPsCutoff()) {
      return "AE";
    }
    else if (totalMark < this.getCrCutoff()) {
      return "PS";
    }
    else if (totalMark < this.getDiCutoff()) {
      return "CR";
    }
    else if (totalMark < this.getHdCutoff()) {
      return "DI";
    }
    else {
      return "HD";
    }

  }



}