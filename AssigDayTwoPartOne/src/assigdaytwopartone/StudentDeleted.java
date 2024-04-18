package assigdaytwopartone;

import static assigdaytwopartone.Test.addrList;
import static assigdaytwopartone.Test.studentList;
import java.util.stream.Collectors;

public class StudentDeleted {

    public static String deleteStudent(Integer student_id) {
        int originalSize = studentList.size();

        studentList = studentList.stream().filter(s -> s.getId() != student_id).collect(Collectors.toList());
        addrList = addrList.stream().filter(s -> s.getStudent_id() != student_id).collect(Collectors.toList());

        int newSize = studentList.size();
        if (newSize != originalSize) {
            return "Student Deleted";
        } else {
            return "Student Does Not Exist";
        }
    }
}
