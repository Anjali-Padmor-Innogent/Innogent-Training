import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Optional;
import java.util.HashSet;
import java.util.Set;

class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee() {
        System.out.println("Default");
    }

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        // ============================WithOut Stream=======================================

        // for (Employee empList : employeeList){
        // // System.out.print(empList + " ");
        // System.out.printf("ID: %-5d" , empList.getId());
        // System.out.printf("Name: %-25s " , empList.getName());
        // System.out.printf("Age: %-5d" , empList.getAge());
        // System.out.printf("Gender: %-10s " , empList.getGender());
        // System.out.printf("Department: %-30s" , empList.getDepartment());
        // System.out.printf("Joining Year: %-8d" , empList.getYearOfJoining());
        // System.out.printf("Salary: %-10f" , empList.getSalary());
        // System.out.println();
        // }

        // ============================With Stream=======================================

        // employeeList.stream().forEach(empList->{
        // // System.out.print(empList + " ");
        // System.out.printf("ID: %-5d" , empList.getId());
        // System.out.printf("Name: %-25s " , empList.getName());
        // System.out.printf("Age: %-5d" , empList.getAge());
        // System.out.printf("Gender: %-10s " , empList.getGender());
        // System.out.printf("Department: %-30s" , empList.getDepartment());
        // System.out.printf("Joining Year: %-8d" , empList.getYearOfJoining());
        // System.out.printf("Salary: %-10f" , empList.getSalary());
        // System.out.println();
        // });

        // 1) How many male and female employees are there in the organization?

        // ============================WithOut Stream=======================================

        // int femaleCount = 0, maleCount = 0;
        // for (Employee empList : employeeList) {
        //     if (empList.getGender() == "Male") {
        //         maleCount++;
        //     } else {
        //         femaleCount++;
        //     }
        // }
        // System.out.println("Male employees : " + maleCount);
        // System.out.println("Female employees : " + femaleCount);

        // ============================With Stream=======================================

        // long maleCount = employeeList.stream().filter(emp ->
        // emp.getGender().equalsIgnoreCase("Male")).count();
        // long femaleCount = employeeList.stream().filter(emp ->
        // emp.getGender().equalsIgnoreCase("Female")).count();
        // System.out.println("Male employees : " + maleCount);
        // System.out.println("Female employees : " + femaleCount);

        // 2) Print the name of all departments in the organization?

        // ============================WithOut Stream=======================================

        // Set<String> departments = new HashSet<>();
        // for (Employee employee : employeeList) {
        // departments.add(employee.getDepartment());
        // }

        // System.out.println("Departments in the organization:");
        // for (String department : departments) {
        // System.out.println(department);
        // }

        // ============================With Stream=======================================

        // employeeList.stream()
        // .map(Employee::getDepartment) // Extract department names
        // .distinct() // Get unique department names
        // .forEach(System.out::println); // Print each department name

        // -----------------------------Answer----------------------
        // .stream() converts the employeeList into a stream of elements.
        // .map(Employee::getDepartment) extracts the department name of each employee.
        // .distinct() filters out duplicate department names to get unique ones.
        // .forEach(System.out::println) prints each unique department name to the
        // console.

        // -------------------------------------------

        // employeeList.stream()
        // .map(Employee::getDepartment) // Extract department names
        // .distinct() // Get unique department names
        // .forEach(department -> System.out.println(department)); // Print each
        // department name

        // -------------------------------------------

        // employeeList.stream().map(emp->emp.getDepartment()).distinct().forEach(department->System.out.println(department));

        // 3)What is the average age of male and female employees?

        // ============================WithOut Stream=======================================

        // int maleAgeSum = 0;
        // int maleCount = 0;
        // int femaleAgeSum = 0;
        // int femaleCount = 0;
        // for (Employee employee : employeeList) {
        // if (employee.getGender().equalsIgnoreCase("male")) {
        // maleAgeSum += employee.getAge();
        // maleCount++;
        // } else if (employee.getGender().equalsIgnoreCase("female")) {
        // femaleAgeSum += employee.getAge();
        // femaleCount++;
        // }
        // }

        // // Calculate the average age for male and female employees
        // double maleAverageAge = (double) maleAgeSum / maleCount;
        // double femaleAverageAge = (double) femaleAgeSum / femaleCount;

        // System.out.printf("Average age of male employees: %.3f" , maleAverageAge);
        // System.out.printf("\nAverage age of female employees:%.3f\n " ,
        // femaleAverageAge);

        // ============================With Stream=======================================

        // double maleAverageAge = employeeList.stream()
        // .filter(employee -> employee.getGender().equalsIgnoreCase("male"))
        // .mapToInt(Employee::getAge)
        // .average()
        // .orElse(0);

        // // Calculate the average age of female employees
        // double femaleAverageAge = employeeList.stream()
        // .filter(employee -> employee.getGender().equalsIgnoreCase("female"))
        // .mapToInt(Employee::getAge)
        // .average()
        // .orElse(0);

        // System.out.printf("Average age of male employees: %.3f" , maleAverageAge);
        // System.out.printf("\nAverage age of female employees:%.3f\n " ,
        // femaleAverageAge);

        // ------------------------Summary----------------------
        // // We use the stream() method to convert the employeeList into a stream
        // ofelements.
        // // We use the filter method to filter the stream based on the gender of the
        // employees.
        // // We use the mapToInt method to map each employee to their age as an
        // integer.
        // // We use the average method to calculate the average age for each gender
        // group.
        // // Finally, we use orElse(0) to handle the case where there are no male
        // orfemale employees, returning 0 as the default value in such cases.

        // 4)Get the details of highest paid employee in the organization?

        // ============================WithOut Stream=======================================

        // Employee highestPaidEmployee = null;
        // double highestSalary = Double.MIN_VALUE;

        // for (Employee employee : employeeList) {
        // if (employee.getSalary() > highestSalary) {
        // highestSalary = employee.getSalary();
        // highestPaidEmployee = employee;
        // }
        // }

        // if (highestPaidEmployee != null) {
        // System.out.println("Details of highest paid employee:");
        // System.out.println("ID: " + highestPaidEmployee.getId());
        // System.out.println("Name: " + highestPaidEmployee.getName());
        // System.out.println("Age: " + highestPaidEmployee.getAge());
        // System.out.println("Gender: " + highestPaidEmployee.getGender());
        // System.out.println("Department: " + highestPaidEmployee.getDepartment());
        // System.out.println("Joining Year: " +
        // highestPaidEmployee.getYearOfJoining());
        // System.out.println("Salary: " + highestPaidEmployee.getSalary());
        // } else {
        // System.out.println("No employee found.");
        // }

        // ============================With Stream=======================================

        // Employee highestPaidEmployee = employeeList.stream()
        // .max(Comparator.comparing(Employee::getSalary))
        // .orElse(null);

        // if (highestPaidEmployee != null) {
        // System.out.println("Details of highest paid employee:");
        // System.out.println("ID: " + highestPaidEmployee.getId());
        // System.out.println("Name: " + highestPaidEmployee.getName());
        // System.out.println("Age: " + highestPaidEmployee.getAge());
        // System.out.println("Gender: " + highestPaidEmployee.getGender());
        // System.out.println("Department: " + highestPaidEmployee.getDepartment());
        // System.out.println("Joining Year: " +
        // highestPaidEmployee.getYearOfJoining());
        // System.out.println("Salary: " + highestPaidEmployee.getSalary());
        // } else {
        // System.out.println("No employee found.");
        // }

        // 5) Get the names of all employees who have joined after 2015?

        // ============================WithOut Stream=======================================

        // List<String> employeesJoinedAfter2015 = new ArrayList<>();
        // for (Employee employee : employeeList) {
        // if (employee.getYearOfJoining() > 2015) {
        // employeesJoinedAfter2015.add(employee.getName());
        // }
        // }

        // // Print the names of employees who have joined after 2015
        // System.out.println("Names of employees who have joined after 2015:");
        // for (String name : employeesJoinedAfter2015) {
        // System.out.println(name);
        // }

        // ============================With Stream=======================================

        // Get the names of employees who have joined after 2015 using streams
        // List<String> employeesJoinedAfter2015 = employeeList.stream()
        // .filter(employee -> employee.getYearOfJoining() > 2015)
        // .map(Employee::getName)
        // .collect(Collectors.toList());

        // // Print the names of employees who have joined after 2015
        // System.out.println("Names of employees who have joined after 2015:");
        // // for (String name : employeesJoinedAfter2015) {
        // // System.out.println(name);
        // // }
        // employeesJoinedAfter2015.forEach(System.out::println);

        // 6)Count the number of employees in each department?

        // ============================WithOut Stream=======================================

        // Map<String, Integer> employeeCountByDepartment = new HashMap<>();
        // for (Employee employee : employeeList) {
        // String department = employee.getDepartment();
        // if (employeeCountByDepartment.containsKey(department)) {
        // employeeCountByDepartment.put(department,
        // employeeCountByDepartment.get(department) + 1);
        // } else {
        // employeeCountByDepartment.put(department, 1);
        // }
        // }

        // // Print the number of employees in each department
        // System.out.println("Number of employees in each department:");
        // for (Map.Entry<String, Integer> entry : employeeCountByDepartment.entrySet())
        // {
        // System.out.println(entry.getKey() + ": " + entry.getValue());
        // }

        // ============================With Stream=======================================

        // Map<String, Long> employeeCountByDepartment = employeeList.stream()
        // .collect(Collectors.groupingBy(Employee::getDepartment,
        // Collectors.counting()));

        // // Print the number of employees in each department
        // System.out.println("Number of employees in each department:");
        // employeeCountByDepartment.forEach((department, count) ->
        // System.out.println(department + ": " + count));

        // ---------------------------------------------------------------------------------

        // Map<String, Long> employeeCountByDepartment = employeeList.stream()
        // .collect(Collectors.groupingBy(e -> e.getDepartment(),
        // Collectors.counting()));

        // // Print the number of employees in each department
        // System.out.println("Number of employees in each department:");
        // employeeCountByDepartment.forEach((department, count) ->
        // System.out.println(department + ": " + count));

        // 7) What is the average salary of each department?

        // ============================WithOut Stream=======================================

        // // Map to store total salary and count of employees for each department
        // Map<String, Double> totalSalaryByDepartment = new HashMap<>();
        // Map<String, Integer> employeeCountByDepartment = new HashMap<>();

        // // Iterate over employee list to calculate total salary and count for each
        // // department
        // for (Employee employee : employeeList) {
        // String department = employee.getDepartment();
        // double salary = employee.getSalary();

        // totalSalaryByDepartment.put(department,
        // totalSalaryByDepartment.getOrDefault(department, 0.0) + salary);
        // employeeCountByDepartment.put(department,
        // employeeCountByDepartment.getOrDefault(department, 0) + 1);
        // }

        // // Calculate average salary for each department
        // Map<String, Double> averageSalaryByDepartment = new HashMap<>();
        // for (String department : totalSalaryByDepartment.keySet()) {
        // double totalSalary = totalSalaryByDepartment.get(department);
        // int employeeCount = employeeCountByDepartment.get(department);
        // double averageSalary = totalSalary / employeeCount;
        // averageSalaryByDepartment.put(department, averageSalary);
        // }

        // // Print the average salary of each department
        // System.out.println("Average salary of each department:");
        // for (Map.Entry<String, Double> entry : averageSalaryByDepartment.entrySet())
        // {
        // System.out.printf(entry.getKey() + ": %.3f \n", entry.getValue());
        // }

        // ============================With Stream=======================================

        // Map<String, Double> averageSalaryByDepartment = employeeList.stream()
        // .collect(Collectors.groupingBy(Employee::getDepartment,
        // Collectors.averagingDouble(Employee::getSalary)));

        // // Print the average salary of each department
        // System.out.println("Average salary of each department:");
        // averageSalaryByDepartment
        // .forEach((department, averageSalary) -> System.out.println(department + ": "
        // + averageSalary));

        // Map<String, Double> averageSalaryByDepartment = employeeList.stream()
        // .collect(Collectors.groupingBy(e -> e.getDepartment(),
        // Collectors.averagingDouble(e -> e.getSalary())));

        // // Print the average salary of each department
        // System.out.println("Average salary of each department:");
        // averageSalaryByDepartment
        // .forEach((department, averageSalary) -> System.out.println(department + ": "
        // + averageSalary));

        // 8) Get the details of youngest male employee in the product development
        // department?

        // ============================WithOut Stream=======================================

        // Employee youngestMaleInProductDev = null;

        // for (Employee employee : employeeList) {
        // // Check if the employee is male and in the Product Development department
        // if (employee.getGender().equalsIgnoreCase("Male")
        // && employee.getDepartment().equalsIgnoreCase("Product Development")) {
        // // If youngestMaleInProductDev is null or the current employee is younger,
        // // update youngestMaleInProductDev
        // if (youngestMaleInProductDev == null || employee.getAge() <
        // youngestMaleInProductDev.getAge()) {
        // youngestMaleInProductDev = employee;
        // }
        // }
        // }

        // // Print the details of the youngest male employee in the Product Development
        // // department
        // if (youngestMaleInProductDev != null) {
        // System.out.println("Details of the youngest male employee in the Product
        // Development department:");
        // System.out.println("ID: " + youngestMaleInProductDev.getId());
        // System.out.println("Name: " + youngestMaleInProductDev.getName());
        // System.out.println("Age: " + youngestMaleInProductDev.getAge());
        // System.out.println("Gender: " + youngestMaleInProductDev.getGender());
        // System.out.println("Department: " +
        // youngestMaleInProductDev.getDepartment());
        // System.out.println("Joining Year: " +
        // youngestMaleInProductDev.getYearOfJoining());
        // System.out.println("Salary: " + youngestMaleInProductDev.getSalary());
        // } else {
        // System.out.println("No male employee found in the Product Development
        // department.");
        // }

        // ============================With Stream=======================================

        // Optional<Employee> youngestMaleInProductDev = employeeList.stream()
        // .filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
        // .filter(employee -> employee.getDepartment().equalsIgnoreCase("Product
        // Development"))
        // .min(Comparator.comparingInt(Employee::getAge));

        // // Check if there is a youngest male employee in the Product Development
        // // department
        // if (youngestMaleInProductDev.isPresent()) {
        // Employee youngestEmployee = youngestMaleInProductDev.get();
        // System.out.println("Details of the youngest male employee in the Product
        // Development department:");
        // System.out.println("ID: " + youngestEmployee.getId());
        // System.out.println("Name: " + youngestEmployee.getName());
        // System.out.println("Age: " + youngestEmployee.getAge());
        // System.out.println("Gender: " + youngestEmployee.getGender());
        // System.out.println("Department: " + youngestEmployee.getDepartment());
        // System.out.println("Joining Year: " + youngestEmployee.getYearOfJoining());
        // System.out.println("Salary: " + youngestEmployee.getSalary());
        // } else {
        // System.out.println("No male employee found in the Product Development
        // department.");
        // }

        // 9) How many male and female employees are there in the sales and marketing
        // team?

        // ============================WithOut Stream=======================================

        // int maleCount = 0;
        // int femaleCount = 0;

        // for (Employee employee : employeeList) {
        // if (employee.getDepartment().equalsIgnoreCase("Sales And Marketing")) {
        // if (employee.getGender().equalsIgnoreCase("Male")) {
        // maleCount++;
        // } else if (employee.getGender().equalsIgnoreCase("Female")) {
        // femaleCount++;
        // }
        // }
        // }

        // System.out.println("Male employees in Sales and Marketing: " + maleCount);
        // System.out.println("Female employees in Sales and Marketing: " +
        // femaleCount);

        // ============================With Stream=======================================

        // long maleCount = employeeList.stream()
        // .filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And
        // Marketing") && employee.getGender().equalsIgnoreCase("Male"))
        // .count();

        // long femaleCount = employeeList.stream()
        // .filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And
        // Marketing") && employee.getGender().equalsIgnoreCase("Female"))
        // .count();

        // System.out.println("Male employees in Sales And Marketing: " + maleCount);
        // System.out.println("Female employees in Sales And Marketing: " +
        // femaleCount);

        // 10 What is the average salary of male and female employees?

        // ============================WithOut Stream=======================================

        // double totalMaleSalary = 0;
        // double totalFemaleSalary = 0;
        // int maleCount = 0;
        // int femaleCount = 0;

        // for (Employee employee : employeeList) {
        // if (employee.getGender().equalsIgnoreCase("Male")) {
        // totalMaleSalary += employee.getSalary();
        // maleCount++;
        // } else if (employee.getGender().equalsIgnoreCase("Female")) {
        // totalFemaleSalary += employee.getSalary();
        // femaleCount++;
        // }
        // }

        // double maleAverageSalary = maleCount > 0 ? totalMaleSalary / maleCount : 0;
        // double femaleAverageSalary = femaleCount > 0 ? totalFemaleSalary /
        // femaleCount : 0;

        // System.out.println("Average salary of male employees: " + maleAverageSalary);
        // System.out.println("Average salary of female employees: " +
        // femaleAverageSalary);

        // ============================With Stream=======================================

        // double maleAverageSalary = employeeList.stream()
        // .filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
        // .mapToDouble(Employee::getSalary)
        // .average()
        // .orElse(0);

        // double femaleAverageSalary = employeeList.stream()
        // .filter(employee -> employee.getGender().equalsIgnoreCase("Female"))
        // .mapToDouble(Employee::getSalary)
        // .average()
        // .orElse(0);

        // System.out.println("Average salary of male employees: " + maleAverageSalary);
        // System.out.println("Average salary of female employees: " +
        // femaleAverageSalary);

        // 11 List down the names of all employees in each department?

        // ============================WithOut Stream=======================================
        // Map<String, List<String>> departmentEmployees = new HashMap<>();

        // for (Employee employee : employeeList) {
        // String department = employee.getDepartment();
        // String name = employee.getName();
        // if (!departmentEmployees.containsKey(department)) {
        // departmentEmployees.put(department, new ArrayList<>());
        // }
        // departmentEmployees.get(department).add(name);
        // }

        // departmentEmployees.forEach((department, employees) -> {
        // System.out.println("Department: " + department);
        // System.out.println("Employees: " + employees);
        // });

        // ============================With Stream=======================================

        // Map<String, List<String>> departmentEmployees = employeeList.stream()
        // .collect(Collectors.groupingBy(Employee::getDepartment,
        // Collectors.mapping(Employee::getName, Collectors.toList())));

        // departmentEmployees.forEach((department, employees) -> {
        // System.out.println("Department: " + department);
        // System.out.println("Employees: " + employees);
        // });

        // 12 What is the average salary and total salary of the whole organization?

        // ============================WithOut Stream=======================================
        // double totalSalary = 0;
        // for (Employee employee : employeeList) {
        // totalSalary += employee.getSalary();
        // }
        // double averageSalary = employeeList.isEmpty() ? 0 : totalSalary /
        // employeeList.size();

        // System.out.println("Total salary of the whole organization: " + totalSalary);
        // System.out.println("Average salary of the whole organization: " +
        // averageSalary);

        // ============================With Stream=======================================
        // double totalSalary = employeeList.stream()
        // .mapToDouble(Employee::getSalary)
        // .sum();

        // double averageSalary = employeeList.stream()
        // .mapToDouble(Employee::getSalary)
        // .average()
        // .orElse(0);

        // System.out.println("Total salary of the whole organization: " + totalSalary);
        // System.out.println("Average salary of the whole organization: " +
        // averageSalary);

        // 13 Separate the employees who are younger or equal to 25 years from those
        // employees who are older than 25 years?

        // ============================WithOut Stream=======================================

        // List<Employee> youngerOrEqual25 = new ArrayList<>();
        // List<Employee> olderThan25 = new ArrayList<>();

        // for (Employee employee : employeeList) {
        // if (employee.getAge() <= 25) {
        // youngerOrEqual25.add(employee);
        // } else {
        // olderThan25.add(employee);
        // }
        // }

        // System.out.println("Employees younger or equal to 25 years:");
        // for (Employee empList : youngerOrEqual25) {
        // // System.out.print(empList + " ");
        // System.out.printf("ID: %-5d" , empList.getId());
        // System.out.printf("Name: %-25s " , empList.getName());
        // System.out.printf("Age: %-5d" , empList.getAge());
        // System.out.printf("Gender: %-10s " , empList.getGender());
        // System.out.printf("Department: %-25s" , empList.getDepartment());
        // System.out.printf("Joining Year: %-8d" , empList.getYearOfJoining());
        // System.out.printf("Salary: %-10.3f" , empList.getSalary());
        // System.out.println();
        // }

        // System.out.println("\nEmployees older than 25 years:");
        // for (Employee empList : olderThan25) {
        // // System.out.print(empList + " ");
        // System.out.printf("ID: %-5d" , empList.getId());
        // System.out.printf("Name: %-25s " , empList.getName());
        // System.out.printf("Age: %-5d" , empList.getAge());
        // System.out.printf("Gender: %-10s " , empList.getGender());
        // System.out.printf("Department: %-25s" , empList.getDepartment());
        // System.out.printf("Joining Year: %-8d" , empList.getYearOfJoining());
        // System.out.printf("Salary: %-10.3f" , empList.getSalary());
        // System.out.println();
        // }

        // ============================With Stream=======================================
        // List<Employee> youngerOrEqual25 = employeeList.stream()
        // .filter(employee -> employee.getAge() <= 25)
        // .collect(Collectors.toList());

        // List<Employee> olderThan25 = employeeList.stream()
        // .filter(employee -> employee.getAge() > 25)
        // .collect(Collectors.toList());

        // System.out.println("Employees younger or equal to 25 years:");
        // youngerOrEqual25.forEach(empList->{
        // // System.out.print(empList + " ");
        // System.out.printf("ID: %-5d" , empList.getId());
        // System.out.printf("Name: %-25s " , empList.getName());
        // System.out.printf("Age: %-5d" , empList.getAge());
        // System.out.printf("Gender: %-10s " , empList.getGender());
        // System.out.printf("Department: %-25s" , empList.getDepartment());
        // System.out.printf("Joining Year: %-8d" , empList.getYearOfJoining());
        // System.out.printf("Salary: %-10.3f" , empList.getSalary());
        // System.out.println();
        // });

        // System.out.println("\nEmployees older than 25 years:");
        // olderThan25.forEach(empList->{
        // // System.out.print(empList + " ");
        // System.out.printf("ID: %-5d" , empList.getId());
        // System.out.printf("Name: %-25s " , empList.getName());
        // System.out.printf("Age: %-5d" , empList.getAge());
        // System.out.printf("Gender: %-10s " , empList.getGender());
        // System.out.printf("Department: %-25s" , empList.getDepartment());
        // System.out.printf("Joining Year: %-8d" , empList.getYearOfJoining());
        // System.out.printf("Salary: %-10.3f" , empList.getSalary());
        // System.out.println();
        // });

        // 14 Who is the oldest employee in the organization? What is his age and which
        // department he belongs to?

        // ============================WithOut Stream=======================================

        // Employee oldestEmployee = null;
        // for (Employee employee : employeeList) {
        //     if (oldestEmployee == null || employee.getAge() > oldestEmployee.getAge()) {
        //         oldestEmployee = employee;
        //     }
        // }

        // if (oldestEmployee != null) {
        //     System.out.println("Oldest employee: " + oldestEmployee.getName());
        //     System.out.println("Age: " + oldestEmployee.getAge());
        //     System.out.println("Department: " + oldestEmployee.getDepartment());
        // }

        // ============================With Stream=======================================
        // Optional<Employee> oldestEmployee = employeeList.stream()
        // .max(Comparator.comparingInt(Employee::getAge));

        // oldestEmployee.ifPresent(employee -> {
        // System.out.println("Oldest employee: " + employee.getName());
        // System.out.println("Age: " + employee.getAge());
        // System.out.println("Department: " + employee.getDepartment());
        // });

    }

}