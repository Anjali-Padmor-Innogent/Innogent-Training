package assigdaytwopartone;

import static assigdaytwopartone.Test.classList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Classes;
import model.Student;

public class StudentClass {

    public static Integer getStudentClass(Character class_name) {
        int classId = 0;
        for (Classes clas : classList) {
            if (clas.getName().equals(class_name)) {
                classId = clas.getId();
            }
        }
        return classId;
    }

    public static List<Student> getStudentByClass(List<Student> studList, Character class_name, Character gender, Integer age, String city, Integer pincode) {
        int classId = getStudentClass(class_name);
        List<Student> student = new ArrayList<Student>();
//		for(Student stud:studList) {
//			if(stud.getClass_id().equals(classId)) {
//				student.add(stud);
//			}
//		}
        student = studList.stream().filter(s -> s.getClass_id().equals(classId)).collect(Collectors.toList());
        List<Student> students = Filters.getStudentByGenderAgeCityPincode(student, gender, age, city, pincode);
        return students;
    }
}
