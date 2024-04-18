package assigdaytwopartone;

import static assigdaytwopartone.Test.studentList;
import java.util.List;
import java.util.stream.Collectors;
import model.Student;

public class StudentsRanking {

    public static List<Student> ranking(List<Student> studentList) {
        List<Student> student = studentList.stream().sorted((a, b) -> (b.getMarks()).compareTo(a.getMarks()))
                .collect(Collectors.toList());
        int studentLen = student.size();
//        for (int i = 0; i < studentLen; i++) {
//            if (i == 0) {
//                student.get(i).setStatus("First");
//            } else if (i == 1) {
//                student.get(i).setStatus("Second");
//            } else if (i == 2) {
//                student.get(i).setStatus("Third");
//            } else if (student.get(i).getMarks() > 50) {
//                student.get(i).setStatus("Pass");
//            } else {
//                student.get(i).setStatus("Fail");
//            }
//        }
        for (int i = 0; i < studentLen; i++) {
            switch (i) {
                case 0:
                    student.get(i).setStatus("First");
                    break;
                case 1:
                    student.get(i).setStatus("Second");
                    break;
                case 2:
                    student.get(i).setStatus("Third");
                    break;
                default:
                    if (student.get(i).getMarks() > 50) {
                        student.get(i).setStatus("Pass");
                    } else {
                        student.get(i).setStatus("Fail");
                    }
                    break;
            }
        }
        System.out.println();
        return studentList;
    }

    public static List<Student> failStudentByAge(Integer age) {
        List<Student> students = studentList.stream().filter(s -> s.getAge() > 20).peek(s -> s.setStatus("Fail")).collect(Collectors.toList());
//		students.forEach(System.out::println);
        return students;
    }
}
