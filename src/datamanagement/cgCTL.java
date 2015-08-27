package datamanagement;

/**
 * UI controller class
 */
public class cgCTL {

  cgUI CGUI;
  String cuc = null;
  Integer currentStudentID = null;
  boolean changed = false;



  /**
   * Blank constructor
   */
  public cgCTL()
  {

  }



  /**
   * Initialises the user interface and sets initial state.
   */
  public void execute()
  {
    CGUI = new cgUI(this);
    CGUI.setState1(false);

    CGUI.setState2(false);
    CGUI.setState3(false);
    CGUI.setState4(false);
    CGUI.setState5(false);
    CGUI.setState6(false);
    CGUI.Refresh3();

    ListUnitsCTL luCTL = new ListUnitsCTL();
    luCTL.listUnits(CGUI);
    CGUI.setVisible(true);
    CGUI.setState1(true);
  }



  /**
   * Sets state and initialises a new student list controller.
   */
  public void unitSelected(String code)
  {
    if (code.equals("NONE"))
      CGUI.setState2(false);
    else {
      ListStudentsCTL lsCTL = new ListStudentsCTL();
      lsCTL.listStudents(CGUI, code);
      cuc = code;
      CGUI.setState2(true);
    }
    CGUI.setState3(false);
  }



  /**
   * Sets state and initialises a new student manager.
   */
  public void studentSelected(Integer id)
  {
    currentStudentID = id;
    if (currentStudentID.intValue() == 0) {
      CGUI.Refresh3();
      CGUI.setState3(false);
      CGUI.setState4(false);
      CGUI.setState5(false);
      CGUI.setState6(false);
    }
    else {
      IStudent s = StudentManager.get().getStudent(id);

      IStudentUnitRecord r = s.getUnitRecord(cuc);

      CGUI.setRecord(r);
      CGUI.setState3(true);
      CGUI.setState4(true);
      CGUI.setState5(false);
      CGUI.setState6(false);
      changed = false;
    }
  }



  /**
   * Checks a new grade given marks and updates states accordingly.
	 *
	 * @return String grade
   */
  public String checkGrade(float f, float g, float h)
  {
    IUnit u = UnitManager.UM().getUnit(cuc);
    String s = u.getGrade(f, g, h);
    CGUI.setState4(true);
    CGUI.setState5(false);
    if (changed) {
    CGUI.setState6(true);
    }
    return s;
  }



  /**
   * Sets UI state to allow marks to be changed.
   */
  public void enableChangeMarks()
  {
    CGUI.setState4(false);
    CGUI.setState6(false);
    CGUI.setState5(true);
    changed = true;
  }



  /**
   * Saves grades that havebeen entered.
   */
  public void saveGrade(float asg1, float asg2, float exam)
  {
    IUnit u = UnitManager.UM().getUnit(cuc);
    IStudent s = StudentManager.get().getStudent(currentStudentID);

    IStudentUnitRecord r = s.getUnitRecord(cuc);
    r.setAssignmentGrade1(asg1);
    r.setAssignmentGrade2(asg2);
    r.setExamGrade(exam);
    StudentUnitRecordManager.getInstance().saveRecord(r);
    CGUI.setState4(true);
    CGUI.setState5(false);
    CGUI.setState6(false);
  }

}
