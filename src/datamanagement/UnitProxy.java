package datamanagement;

public class UnitProxy implements IUnit {
  private String unitCode_;
  private String unitName_;
  private UnitManager unitManager_;

  /**
   * Constructor - instantiates the class with class properties.
   * 
   * @param unitCode
   * @param unitName
   * @return UnitProxy
   */
  public UnitProxy( String unitCode, String unitName ) {
    this.unitCode_ = unitCode;
    this.unitName_ = unitName;
    this.unitManager_ = UnitManager.UM();
  }

  public String getUnitCode() { 
    return this.unitCode_;
  }

  public String getUnitName() { 
    return this.unitName_; 
  }

  public void setPsCutoff(float cutOffPass) {
    this.unitManager_.getUnit(this.unitCode_).setPsCutoff(cutOffPass);
  }

  public float getPsCutoff() {
    return this.unitManager_.getUnit(this.unitCode_).getPsCutoff();
  }

  public void setCrCutoff(float cutOffCredit) {
    this.unitManager_.getUnit(this.unitCode_).setCrCutoff(cutOffCredit);
  }

  public float getCrCutoff() {
    return this.unitManager_.getUnit(this.unitCode_).getCrCutoff();
  }

  public void setDiCutoff(float cutOffDistinction) {
    this.unitManager_.getUnit(this.unitCode_).setDiCutoff(cutOffDistinction);
  }

  public float getDiCutoff() {
    return this.unitManager_.getUnit(this.unitCode_).getDiCutoff();
  }

  public void setHdCutoff(float cutOffHighDistinction) {
    this.unitManager_.getUnit(this.unitCode_).setHdCutoff(cutOffHighDistinction);
  }

  public float getHdCutoff() {
    return this.unitManager_.getUnit(this.unitCode_).getHdCutoff();
  }

  public void setAeCutoff(float cutOffAdditionalExam) {
    this.unitManager_.getUnit(this.unitCode_).setAeCutoff(cutOffAdditionalExam);
  }

  public float getAeCutoff() {
    return this.unitManager_.getUnit(this.unitCode_).getAeCutoff();
  }

  public String getGrade(float assessmentOneMark, float assessmentTwoMark, float examMark) {
    return this.unitManager_.getUnit(this.unitCode_).getGrade(assessmentOneMark, assessmentTwoMark, examMark);
  }

  public void addStudentRecord(IStudentUnitRecord studentUnitRecord) { 
    this.unitManager_.getUnit(this.unitCode_).addStudentRecord(studentUnitRecord);
  }

  public IStudentUnitRecord getStudentRecord(int studentId) {
    return this.unitManager_.getUnit(this.unitCode_).getStudentRecord(studentId);
  }

  public StudentUnitRecordList listStudentRecords() {
    return this.unitManager_.getUnit(this.unitCode_).listStudentRecords();
  }

  public int getAsg1Weight() {
    return this.unitManager_.getUnit(this.unitCode_).getAsg1Weight();
  }

  public int getAsg2Weight() {
    return this.unitManager_.getUnit(this.unitCode_).getAsg2Weight();
  }

  public int getExamWeight() {
    return this.unitManager_.getUnit(this.unitCode_).getExamWeight();
  }

  public void setAssessmentWeights(int assessmentOneWeight, int assessmentTwoWeight, int examWeight) {
    this.unitManager_.getUnit(this.unitCode_).setAssessmentWeights(assessmentOneWeight, assessmentTwoWeight, examWeight);
  }

}
