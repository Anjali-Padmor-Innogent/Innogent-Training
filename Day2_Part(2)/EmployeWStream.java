import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

public class EmployeWStream {

    public static void printEmpList(List<Employee> employeeList) {
        employeeList.stream().forEach(System.out::println);
    }

    public static void countMaleAndFemale(List<Employee> employeeList) {
        long maleCount = employeeList.stream().filter(emp -> emp.getGender().equalsIgnoreCase("Male")).count();
        long femaleCount = employeeList.stream().filter(emp -> emp.getGender().equalsIgnoreCase("Female")).count();
        System.out.println("Male employees : " + maleCount);
        System.out.println("Female employees : " + femaleCount);
    }

    public static void printAllDepartmentName(List<Employee> employeeList) {
        // employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        employeeList.stream().map(emp -> emp.getDepartment()).distinct()
                .forEach(department -> System.out.println(department));
    }

    public static void averageAgeOfMaleAndFemale(List<Employee> employeeList) {
        double maleAverageAge = employeeList.stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("male"))
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0);

        // Calculate the average age of female employees
        double femaleAverageAge = employeeList.stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("female"))
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0);

        System.out.printf("Average age of male employees: %.3f", maleAverageAge);
        System.out.printf("\nAverage age of female employees:%.3f\n ", femaleAverageAge);
    }

    public static void detailsOfHighPaid(List<Employee> employeeList) {
        Employee highestPaidEmployee = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);

        if (highestPaidEmployee != null) {
            System.out.println("Details of highest paid employee:");
            System.out.println(highestPaidEmployee);
        } else {
            System.out.println("No employee found.");
        }
    }

    public static void employeeNamesJoinedAtYear(int year, List<Employee> employeeList) {
        List<String> employeesJoinedAfter2015 = employeeList.stream()
                .filter(employee -> employee.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("Names of employees who have joined after 2015:");
        employeesJoinedAfter2015.forEach(System.out::println);

    }

    public static void countTheNumOfEmpInDepartment(List<Employee> employeeList) {
        Map<String, Long> employeeCountByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));

        System.out.println("Number of employees in each department:");
        employeeCountByDepartment.forEach((department, count) -> System.out.println(department + ": " + count));
    }

    public static void avgSalaryEachDepartment(List<Employee> employeeList) {
        Map<String, Double> averageSalaryByDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        // Print the average salary of each department
        System.out.println("Average salary of each department:");
        averageSalaryByDepartment
                .forEach((department, averageSalary) -> System.out.println(department + ": " + averageSalary));
    }

    public static void youngestEmpOfDepartment(List<Employee> employeeList) {
        Optional<Employee> youngestMaleInProductDev = employeeList.stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("Product Development"))
                .min(Comparator.comparingInt(Employee::getAge));
        // Check if there is a youngest male employee in the Product Developmen
        // department
        if (youngestMaleInProductDev.isPresent()) {
            Employee youngestEmployee = youngestMaleInProductDev.get();
            System.out.println("Details of the youngest male employee in the Product Development department:");
            System.out.println(youngestEmployee);
        } else {
            System.out.println("No male employee found in the Product Development department.");
        }
    }

    public static void countMaleFemaleInDepartment(List<Employee> employeeList) {
        long maleCount = employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And Marketing")
                        && employee.getGender().equalsIgnoreCase("Male"))
                .count();

        long femaleCount = employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("Sales And Marketing")
                        && employee.getGender().equalsIgnoreCase("Female"))
                .count();

        System.out.println("Male employees in Sales And Marketing: " + maleCount);
        System.out.println("Female employees in Sales And Marketing: " + femaleCount);
    }

    public static void avgSalaryOfMAleAndFemale(List<Employee> employeeList) {
        double maleAverageSalary = employeeList.stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        double femaleAverageSalary = employeeList.stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase("Female"))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println("Average salary of male employees: " + maleAverageSalary);
        System.out.println("Average salary of female employees: " + femaleAverageSalary);
    }

    public static void namesOfEmpEachDepartment(List<Employee> employeeList) {
        Map<String, List<String>> departmentEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));

        departmentEmployees.forEach((department, employees) -> {
            System.out.println("Department: " + department);
            System.out.println("Employees: " + employees);
        });
    }

    public static void avgAndTotalSalaryOfOrg(List<Employee> employeeList) {
        double totalSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        double averageSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println("Total salary of the whole organization: " + totalSalary);
        System.out.println("Average salary of the whole organization: " + averageSalary);
    }

    public static void separateYoungerOrEqualToAge(List<Employee> employeeList) {
        List<Employee> youngerOrEqual25 = employeeList.stream()
                .filter(employee -> employee.getAge() <= 25)
                .collect(Collectors.toList());

        List<Employee> olderThan25 = employeeList.stream()
                .filter(employee -> employee.getAge() > 25)
                .collect(Collectors.toList());

        System.out.println("Employees younger or equal to 25 years:");
        youngerOrEqual25.forEach(System.out::println);

        System.out.println("\nEmployees older than 25 years:");
        olderThan25.forEach(System.out::println);
    }

    public static void oldestEmpInOrgGetAge(List<Employee> employeeList) {
        Optional<Employee> oldestEmployee = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge));

        oldestEmployee.ifPresent(employee -> {
            System.out.println("Oldest employee: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Department: " + employee.getDepartment());
        });
    }
}
