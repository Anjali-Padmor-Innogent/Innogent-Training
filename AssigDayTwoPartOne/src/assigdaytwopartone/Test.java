package assigdaytwopartone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Address;
import model.Classes;
import model.Student;

public class Test {

    public static final String pathOfCsvFileStudent = "C:\\Users\\hp\\Desktop\\Inno-Assg\\AssigDayTwoPartOne\\src\\CSV_file\\Student.csv";
    public static final String pathOfCsvFileClass = "C:\\Users\\hp\\Desktop\\Inno-Assg\\AssigDayTwoPartOne\\src\\CSV_file\\Class.csv";
    public static final String pathOfCsvFileAddress = "C:\\Users\\hp\\Desktop\\Inno-Assg\\AssigDayTwoPartOne\\src\\CSV_file\\Address.csv";

    public static List<Student> studentList = new ArrayList<Student>();
    public static List<Classes> classList = new ArrayList<Classes>();
    public static List<Address> addrList = new ArrayList<Address>();

    public static void main(String[] args) throws IOException {
//        	upload the csv data files
        UploadFile.uploadStudent(new File(pathOfCsvFileStudent));
        UploadFile.uploadClass(new File(pathOfCsvFileClass));
        UploadFile.uploadAddress(new File(pathOfCsvFileAddress));

//        Filter by pinCode
        Filters.onlyByPinCode(452002).forEach(System.out::println);
//        Filter by city
//        Filters.onlyByCity("delhi").forEach(System.out::println);
//        Filter by age
//        Filters.onlyByAge(11).forEach(System.out::println);
//        Filter by className
//        Filters.onlyByClassName('A').forEach(System.out::println);
//        ------------------------------------------------------------------------------------------------------------------------
//        Pass student Filter by pincode
//        ------------------------------------------------------------------------------------------------------------------------
//		1.Find all students of pincode X(ex X = 482002). I can pass different filters like gender, age, class
//        Filters.getByPinCode(452002, 'F', 10, 1).forEach(System.out::println);
//		2.Find all students of city ex X = Indore. I can pass different filters like gender, age, class
//        Filters.getByCity("indore", 'F', 10, 1).forEach(System.out::println);
//		3.marks < 50 failed else passed
//		Give ranks to highest mark achievers.
//		Highest marks - First
//		Third Highest marks - third
//		Rest of all pass / fail
//        List<Student> studRank = StudentsRanking.ranking(studentList);
//        studRank.forEach(System.out::println);
//		4.Get the passed students. I can pass different filters like gender, age, class, city, pincode
//        List<Student> passedStudent = StudentPassed.getPassStudent(studentList, 'F', 11, 1, "indore", 442002);
//        passedStudent.forEach(System.out::println);
//		5.Get the failed students. I can pass different filters like gender, age, class, city, pincode
//        List<Student> failedStudent = StudentFailed.getFailStudent(studentList, 'M', 11, 3, "indore", 482002);
//        failedStudent.forEach(System.out::println);
//		6.Find all student of class X (ex X = A).  I can pass different filters like gender, age, class, city, pincode
//        List<Student> classStudent = StudentClass.getStudentByClass(studentList, 'A', 'F', 10, "indore", 452002);
//        classStudent.forEach(System.out::println);
//		8.It should fail if student record is having age > 20.
//        List<Student> failedStudentByAge = StudentsRanking.failStudentByAge(20);
//        failedStudentByAge.forEach(System.out::println);
//		9.I should be able to delete student. After that it should delete the respective obj from Address & Student.
//        System.out.println(StudentDeleted.deleteStudent(2));
//        studentList.forEach(System.out::println);
//        addrList.forEach(System.out::println);
//		10	If there is no student remaining in that class. Class should also be deleted.
//        System.out.println(DeleteClass.deleteClass());
//        classList.forEach(System.out::println);
//		11	I should be able to read paginated students.
//		like : read female students first 1-9
//		like : read female students first 7-8 order by name	
//		like : read female students first 1-5 order by marks
//		like : read female students first 9-50 order by marks
//        PaginatedStudents.getSortedStudentByOrder(studentList, 'F', 1, 4, "marks", false).forEach(System.out::println);
    }

}
