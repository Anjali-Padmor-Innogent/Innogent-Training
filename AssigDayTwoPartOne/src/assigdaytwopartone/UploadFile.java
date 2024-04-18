package assigdaytwopartone;

import static assigdaytwopartone.Test.addrList;
import static assigdaytwopartone.Test.classList;
import static assigdaytwopartone.Test.studentList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Address;
import model.Classes;
import model.Student;

public class UploadFile {

    public static void uploadStudent(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] studentArr = line.split(",");
            Student student1 = new Student();
            student1.setId(Integer.parseInt(studentArr[0]));
            student1.setName(studentArr[1]);
            student1.setClass_id(Integer.parseInt(studentArr[2]));
            student1.setMarks(Integer.parseInt(studentArr[3]));
            student1.setGender(studentArr[4].toCharArray()[0]);
            student1.setAge(Integer.parseInt(studentArr[5]));
            studentList.add(student1);
        }
//                studentList.stream().forEach(System.out::println);
        br.close();
    }

    public static void uploadClass(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] classArr = line.split(",");
            Classes classes = new Classes();
            classes.setId(Integer.parseInt(classArr[0]));
            classes.setName(classArr[1].toCharArray()[0]);
            classList.add(classes);
        }
//		classList.stream().forEach(System.out::println);
        br.close();
    }

    public static void uploadAddress(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] addArr = line.split(",");
            Address addr = new Address();
            addr.setId(Integer.parseInt(addArr[0]));
            addr.setPin_code(Integer.parseInt(addArr[1]));
            addr.setCity(addArr[2]);
            addr.setStudent_id(Integer.parseInt(addArr[3]));
            addrList.add(addr);
        }
//		addrList.stream().forEach(System.out::println);
        br.close();
    }
}
