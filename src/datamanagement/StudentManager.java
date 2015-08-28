package datamanagement;

import org.jdom.*;
import java.util.List;



public class StudentManager {
    private static StudentManager self = null; 
    private StudentMap sm_;private java.util.HashMap<String, StudentMap> um_;
    
    
    
    public static StudentManager get() {
        if (self == null) 
        self = new StudentManager(); 
        return self; 
    }
    
    
    
    private StudentManager() {   
        sm_ = new StudentMap();
        um_ = new java.util.HashMap<>();
    }
    
    
    /**
     * get student ID
     * @param id
     * @return is
     */
    public IStudent getStudent(Integer id) {
    	IStudent is = sm_.get(id);
    	return is != null ? is : createStudent(id);
    }
    
    
    
    private Element getStudentElement(Integer id) {
        for (Element el : (List<Element>) XmlManager.getInstance().getDocument().getRootElement().getChild("studentTable").getChildren("student")) 
        if (id.toString().equals(el.getAttributeValue("sid"))) 
        return el;
        return null;
    }
    
    
    /**
     * 
     * @param id
     * @return is
     * @throws RuntimeException
     */
    private IStudent createStudent(Integer id) {
        IStudent is;
        Element el = getStudentElement(id);
        if (el != null) {
            StudentUnitRecordList rlist = StudentUnitRecordManager.getInstance().getRecordsByStudent(id);
        is = new Student(new Integer(el.getAttributeValue("sid")),el.getAttributeValue("fname"),el.getAttributeValue("lname"),rlist);
        sm_.put(is.getID(), is);
        return is; }
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }
    
    
    /**
     * 
     * @param id
     * @return StudentProxy
     * @throws RuntimeException
     */
    private IStudent createStudentProxy(Integer id) {
        Element el = getStudentElement(id);
        if (el != null) return new StudentProxy(id, el.getAttributeValue("fname"), el.getAttributeValue("lname"));
        throw new RuntimeException("DBMD: createStudent : student not in file");
    }
    
    
    
    public StudentMap getStudentsByUnit(String uc) {
    StudentMap s_ = um_.get(uc);
    if (s_ != null) 
    	{
    	return s_;
        }
    s_ = new StudentMap();
    IStudent is;
    StudentUnitRecordList ur = StudentUnitRecordManager.getInstance().getRecordsByUnit(uc);
    for (IStudentUnitRecord S : ur) {
            is = createStudentProxy(new Integer(S.getStudentID()));
            s_.put(is.getID(), is);
    }
    um_.put( uc, s_);
    return s_;
    }
}
