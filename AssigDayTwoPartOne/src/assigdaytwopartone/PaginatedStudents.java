package assigdaytwopartone;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import model.Student;

public class PaginatedStudents {

    //	like : read female students first 1-9
    public static List<Student> getSortedStudentByOrder(List<Student> studList, Character gender, int start, int end,
            String sortBy, boolean ReverseOrder) {
        Comparator<Student> comparator = getComparator(sortBy, ReverseOrder);
        return studList.stream().filter(s -> s.getGender().equals(gender)).sorted(comparator).skip(start - 1).limit(end)
                .collect(Collectors.toList());
    }

    public static Comparator<Student> getComparator(String sortBy, boolean reverseOrder) {
        Comparator<Student> comparator = null;
        switch (sortBy) {
            case "name":
                comparator = Comparator.comparing(Student::getName);
                break;
            case "marks":
                comparator = Comparator.comparing(Student::getMarks).reversed();
                break;
            case "class_id":
                comparator = Comparator.comparing(Student::getClass_id);
                break;
            default:
                comparator = Comparator.comparing(Student::getId);
        }
        return comparator;
    }
}
