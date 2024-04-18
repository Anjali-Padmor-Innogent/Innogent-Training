package assigdaytwopartone;

import static assigdaytwopartone.Test.studentList;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Student;

public class StudentFailed {

    public static List<Student> getFailStudent(List<Student> studList, Character gender, Integer age, Integer class_id,
            String city, Integer pincode) {
        List<Student> rankedStudent = StudentsRanking.ranking(studList);
        List<Student> FailStudent = Filters.studFailFilterByStatusAgeClassGender(rankedStudent, age, class_id,
                gender);
        List<Integer> stud_id = Filters.getStudentIdByAddress(city, pincode);
        List<Student> student = new ArrayList<Student>();
        student = FailStudent.stream().filter(s -> stud_id.contains(s.getId())).collect(Collectors.toList());
        if (student.isEmpty()) {
            return Collections.emptyList();
        } else {
            return student;
        }
    }

    public static List<Student> failStudentByAge(Integer age) {
        List<Student> students = studentList.stream().filter(s -> s.getAge() > 20).peek(s -> s.setStatus("Fail")).collect(Collectors.toList());
//		students.forEach(System.out::println);
        return students;
    }
}
