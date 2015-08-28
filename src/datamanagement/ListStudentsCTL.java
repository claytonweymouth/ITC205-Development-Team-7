package datamanagement;
      
public class ListStudentsCTL {
    private StudentManager sm_;
    public ListStudentsCTL() {sm_ = StudentManager.get();}
    
    
    
    public void listStudents( IStudentLister lister, String unitCode ) {
       	lister.clearStudents();
        /**
         * map students by their unit
         */
       	StudentMap students = sm_.getStudentsByUnit( unitCode );
        /**
         * for loop to add student, get student id
         */
       	for (Integer id : students.keySet() ) lister.addStudent(students.get(id));
    }
}
