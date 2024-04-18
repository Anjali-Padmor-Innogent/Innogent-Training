package assigdaytwopartone;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import model.Student;

public class StudentPassed {

    public static List<Student> getPassStudent(List<Student> studList, Character gender, Integer age, Integer class_id, String city, Integer pincode) {
        List<Student> rankedStudent = StudentsRanking.ranking(studList);
        List<Student> passedStudent = Filters.rankStudFilterByAgeClassGender(rankedStudent, age, class_id, gender);
        List<Integer> stud_id = Filters.getStudentIdByAddress(city, pincode);
        List<Student> student = passedStudent.stream().filter(s -> stud_id.contains(s.getId())).collect(Collectors.toList());
        if (student.isEmpty()) {
            return Collections.emptyList();
        } else {
            return student;
        }
    }
}
