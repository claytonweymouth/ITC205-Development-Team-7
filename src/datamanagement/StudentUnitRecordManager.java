package datamanagement;

import java.util.List;
import java.util.HashMap;

import org.jdom.Element; // Was wildcard, may be other imports needed?



/**
 * Manager class for Student Unit Records.
 */
public class StudentUnitRecordManager
{
  private static StudentUnitRecordManager studentUnitRecordManager_ = null;
  private StudentUnitRecordMap recordMap_;
  private HashMap<String,StudentUnitRecordList> unitCodeHashMap_;
  private HashMap<Integer,StudentUnitRecordList> studentIdHashMap_;



  /**
   * Getter for the current StudentUnitRecordManager_ object.
   * Initialises a new StudentUnitRecordManager object if
   * one has not already been initialised.
   * Singleton pattern.
   *
   * @return StudentUnitRecordManager object instance
   */
  public static StudentUnitRecordManager getInstance()
  {
    if (studentUnitRecordManager_ == null )
      studentUnitRecordManager_ = new StudentUnitRecordManager();
    return studentUnitRecordManager_;
  }



  /**
   * Constructor
   */
  private StudentUnitRecordManager()
  {
    recordMap_ = new StudentUnitRecordMap();
    unitCodeHashMap_ = new HashMap<>();
    studentIdHashMap_ = new HashMap<>();
  }



  /**
   *  Getter for student unit records.
   *
   * @return IStudentUnitRecord conforming object
   */
  public IStudentUnitRecord getStudentUnitRecord( Integer studentID, String unitCode )
  {
    IStudentUnitRecord studentRecord = recordMap_.get(studentID.toString()+unitCode);
    return studentRecord != null ? studentRecord : createStudentUnitRecord(studentID, unitCode);
  }



  /**
   *  Creates an IStudentUnitRecord conforming object
   *
   * @param Integer object of the Unit Code of the new object
   * @param String object of the Student ID of the new object
   * @return IStudentUnitRecord conforming object
   */
  private IStudentUnitRecord createStudentUnitRecord( Integer unitCode, String studentId )
  {
    IStudentUnitRecord studentRecord;
    for (Element element : (List<Element>) XmlManager.getInstance().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
      if (unitCode.toString().equals(element.getAttributeValue("sid")) && studentId.equals(element.getAttributeValue("uid"))) {
        studentRecord = new StudentUnitRecord( new Integer(element.getAttributeValue("sid")),
                                    element.getAttributeValue("uid"),
                                    new Float(element.getAttributeValue("asg1")).floatValue(),
                                    new Float(element.getAttributeValue("asg2")).floatValue(),
                                    new Float(element.getAttributeValue("exam")).floatValue() );
        recordMap_.put(studentRecord.getStudentID().toString()+studentRecord.getUnitCode(), studentRecord);
        return studentRecord;
      }
    }
    throw new RuntimeException("DBMD: createStudent : student unit record not in file");
  }



  /**
   * Gets a list of record by Unit Code.
   *
   * @param String of the relevent unit code.
   * @return StudentUnitRecordList object.
   */
  public StudentUnitRecordList getRecordsByUnit( String unitCode )
  {
    StudentUnitRecordList records = unitCodeHashMap_.get(unitCode);
    if ( records != null )
      return records;
    records = new StudentUnitRecordList();
    for (Element element : (List<Element>) XmlManager.getInstance().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
      if (unitCode.equals(element.getAttributeValue("uid")))
        records.add(new StudentUnitRecordProxy(
          new Integer(element.getAttributeValue("sid")),
          element.getAttributeValue("uid"))
        );
    }
    if ( records.size() > 0 )
      unitCodeHashMap_.put(unitCode, records); // be careful - this could be empty
    return records;
  }



  /**
   * Gets a list of records by Student Id.
   *
   * @param Integer of the relevent student id.
   * @return StudentUnitRecordList object.
   */
  public StudentUnitRecordList getRecordsByStudent( Integer studentID )
  {
    StudentUnitRecordList records = studentIdHashMap_.get(studentID);
    if ( records != null )
      return records;
    records = new StudentUnitRecordList();
    for (Element element : (List<Element>)   XmlManager.getInstance().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record"))
      if (studentID.toString().equals(element.getAttributeValue("sid")))
        records.add(new StudentUnitRecordProxy( new Integer(element.getAttributeValue("sid")), element.getAttributeValue("uid")));
    if ( records.size() > 0 )
      studentIdHashMap_.put(studentID, records); // be careful - this could be empty
    return records;
  }



  /**
   * Saves a record to an XML file
   *
   * @param IStudentUnitRecord conforming object
   */
  public void saveRecord( IStudentUnitRecord record )
  {
    for (Element element : (List<Element>) XmlManager.getInstance().getDocument().getRootElement().getChild("studentUnitRecordTable").getChildren("record")) {
      if (record.getStudentID().toString().equals(element.getAttributeValue("sid")) && record.getUnitCode().equals(element.getAttributeValue("uid"))) {
        element.setAttribute("asg1", new Float(record.getAsg1()).toString());
        element.setAttribute("asg2", new Float(record.getAsg2()).toString());
        element.setAttribute("exam", new Float(record.getExam()).toString());
        XmlManager.getInstance().saveDocument(); //write out the XML file for continuous save
        return;
      }
    }
    throw new RuntimeException("DBMD: saveRecord : no such student record in data");
  }

}
