package datamanagement;
      
public class ListStudentsCTL {
	//private variable for method
	private StudentManager sm;
	public ListStudentsCTL() {sm = StudentManager.get();}
    public void listStudents( IStudentLister lister, String unitCode ) {
         	lister.clearStudents();
            //map students by their unit
         	StudentMap students = sm.getStudentsByUnit( unitCode );
            //for loop to add student, get student id
         	for (Integer id : students.keySet() ) lister.addStudent(students.get(id));
    }
}
