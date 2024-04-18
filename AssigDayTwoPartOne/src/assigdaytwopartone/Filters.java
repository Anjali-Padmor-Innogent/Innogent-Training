package assigdaytwopartone;

import static assigdaytwopartone.Test.addrList;
import static assigdaytwopartone.Test.classList;
import static assigdaytwopartone.Test.studentList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Address;
import model.Classes;
import model.Student;

public class Filters {
//        Filter by pinCode

    public static List<Student> onlyByPinCode(Integer pincode) {
//        List<Student> student = new ArrayList<Student>();
//        List<Integer> studPin=new ArrayList<Integer>();
//        
//        for(Address ad :addrList){
//            if(ad.getPin_code()==pincode){
//                studPin.add(ad.getStudent_id());
//            }
//        }
//        for(Student st : studentList){
//            if(studPin.contains(st.getId())){
//                student.add(st);
//            }
//        }
//        return student;
        List<Integer> studPin = addrList.parallelStream()
                .filter(ad -> ad.getPin_code() == pincode)
                .map(Address::getStudent_id)
                .collect(Collectors.toList());

        return studentList.parallelStream()
                .filter(st -> studPin.contains(st.getId()))
                .collect(Collectors.toList());
    }

    //        Filter by city
    public static List<Student> onlyByCity(String city) {
        List<Student> student = new ArrayList<Student>();
        List<Integer> cit = new ArrayList<Integer>();

        for (Address ad : addrList) {
            if (ad.getCity().equals(city)) {
                cit.add(ad.getStudent_id());
            }
        }
        for (Student st : studentList) {
            if (cit.contains(st.getId())) {
                student.add(st);
            }
        }
        return student;
    }

    //        Filter by age
    public static List<Student> onlyByAge(Integer age) {
        List<Student> student = new ArrayList<Student>();
        for (Student st : studentList) {
            if (st.getAge() == age) {
                student.add(st);
            }
        }
        return student;
    }

    public static List<Student> onlyByClassName(Character className) {
        List<Student> student = new ArrayList<Student>();
        List<Integer> classId = new ArrayList<Integer>();
        for (Classes cl : classList) {
            if (cl.getName().equals(className)) {
                classId.add(cl.getId());
            }
        }
        for (Student st : studentList) {
            if (classId.contains(st.getClass_id())) {
                student.add(st);
            }
        }
        return student;
    }

    public static List<Student> getByPinCode(Integer pincode, Character gender, Integer age, Integer classes) {
        List<Student> student = new ArrayList<Student>();
        List<Integer> studPin = new ArrayList<Integer>();
        for (Address addr : addrList) {
            if (addr.getPin_code() == pincode) {
                studPin.add(addr.getStudent_id());
            }
        }
        for (Student stud : studentList) {
            if (studPin.contains(stud.getId())) {
                if (stud.getGender() == gender && stud.getAge() == age && stud.getClass_id() == classes) {
                    student.add(stud);
                }
            }
        }
        return student;
    }

    public static List<Student> getByCity(String city, Character gender, Integer age, Integer classes) {
        List<Student> student = new ArrayList<Student>();
        List<Integer> cit = new ArrayList<Integer>();
        for (Address addr : addrList) {
            if (addr.getCity().equals(city)) {
                cit.add(addr.getStudent_id());
            }
        }
        for (Student stud : studentList) {
            if (cit.contains(stud.getId())) {
                if (stud.getGender() == gender && stud.getAge() == age && stud.getClass_id() == classes) {
                    student.add(stud);
                }
            }
        }
        return student;
    }

    public static List<Student> rankStudFilterByAgeClassGender(List<Student> studentList, Integer age, Integer class_id, Character gender) {
        List<Student> student = new ArrayList<Student>();
        student = studentList.stream().filter(s -> s.getMarks() > 50 && s.getClass_id() == class_id && s.getGender() == gender && s.getAge() == age).collect(Collectors.toList());
        return student;
    }

    // filter student id by address
    public static List<Integer> getStudentIdByAddress(String city, Integer pincode) {
        List<Integer> student = new ArrayList<Integer>();
        student = addrList.stream().filter(addr -> addr.getCity().equals(city) && addr.getPin_code() == pincode).map(Address::getStudent_id).collect(Collectors.toList());
        return student;
    }

    public static List<Student> studFailFilterByStatusAgeClassGender(List<Student> studentList, Integer age, Integer class_id, Character gender) {
        List<Student> student = new ArrayList<Student>();
        student = studentList.stream().filter(stud -> stud.getMarks() <= 50 && stud.getAge() == age && stud.getClass_id() == class_id && stud.getGender() == gender).collect(Collectors.toList());
        return student;
    }

    public static List<Student> getStudentByGenderAgeCityPincode(List<Student> studList, Character gender, Integer age, String city, Integer pincode) {
        List<Integer> studentIdByCityPincode = getStudentIdByAddress(city, pincode);
        List<Student> students = new ArrayList<Student>();
        students = studList.stream().filter(student -> student.getGender().equals(gender) && student.getAge() == age && studentIdByCityPincode.contains(student.getId())).collect(Collectors.toList());
        return students;
    }

}
