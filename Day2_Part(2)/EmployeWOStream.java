import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class EmployeWOStream {

    public static void printEmpList(List<Employee> employeeList) {
        for (Employee empList : employeeList) {
            // System.out.print(empList + " ");
            System.out.printf("ID: %-5d", empList.getId());
            System.out.printf("Name: %-25s ", empList.getName());
            System.out.printf("Age: %-5d", empList.getAge());
            System.out.printf("Gender: %-10s ", empList.getGender());
            System.out.printf("Department: %-30s", empList.getDepartment());
            System.out.printf("Joining Year: %-8d", empList.getYearOfJoining());
            System.out.printf("Salary: %-10f", empList.getSalary());
            System.out.println();
        }
    }

    public static void countMaleAndFemale(List<Employee> employeeList) {
        int femaleCount = 0, maleCount = 0;
        for (Employee empList : employeeList) {
            if (empList.getGender() == "Male") {
                maleCount++;
            } else {
                femaleCount++;
            }
        }
        System.out.println("Male employees : " + maleCount);
        System.out.println("Female employees : " + femaleCount);
    }

    public static void printAllDepartmentName(List<Employee> employeeList) {
        Set<String> departments = new HashSet<>();
        for (Employee employee : employeeList) {
            departments.add(employee.getDepartment());
        }
        System.out.println("Departments in the organization:");
        for (String department : departments) {
            System.out.println(department);
        }
    }

    public static void averageAgeOfMaleAndFemale(List<Employee> employeeList) {
        int maleAgeSum = 0;
        int maleCount = 0;
        int femaleAgeSum = 0;
        int femaleCount = 0;
        for (Employee employee : employeeList) {
            if (employee.getGender().equalsIgnoreCase("male")) {
                maleAgeSum += employee.getAge();
                maleCount++;
            } else if (employee.getGender().equalsIgnoreCase("female")) {
                femaleAgeSum += employee.getAge();
                femaleCount++;
            }
        }
        // Calculate the average age for male and female employees
        double maleAverageAge = (double) maleAgeSum / maleCount;
        double femaleAverageAge = (double) femaleAgeSum / femaleCount;

        System.out.printf("Average age of male employees: %.3f", maleAverageAge);
        System.out.printf("\nAverage age of female employees:%.3f\n ", femaleAverageAge);
    }

    public static void detailsOfHighPaid(List<Employee> employeeList) {
        Employee highestPaidEmployee = null;
        double highestSalary = Double.MIN_VALUE;

        for (Employee employee : employeeList) {
            if (employee.getSalary() > highestSalary) {
                highestSalary = employee.getSalary();
                highestPaidEmployee = employee;
            }
        }
        if (highestPaidEmployee != null) {
            System.out.println("Details of highest paid employee:");
            System.out.println(highestPaidEmployee);
        } else {
            System.out.println("No employee found.");
        }
    }

    public static void employeeNamesJoinedAtYear(int year, List<Employee> employeeList) {
        List<String> employeesJoinedAfterYear = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getYearOfJoining() > year) {
                employeesJoinedAfterYear.add(employee.getName());
            }
        }
        // Print the names of employees who have joined after 2015
        System.out.println("Names of employees who have joined after " + year + " : ");
        for (String name : employeesJoinedAfterYear) {
            System.out.println(name);
        }
    }

    public static void countTheNumOfEmpInDepartment(List<Employee> employeeList) {
        Map<String, Integer> employeeCountByDepartment = new HashMap<>();
        for (Employee employee : employeeList) {
            String department = employee.getDepartment();
            if (employeeCountByDepartment.containsKey(department)) {
                employeeCountByDepartment.put(department,
                        employeeCountByDepartment.get(department) + 1);
            } else {
                employeeCountByDepartment.put(department, 1);
            }
        }
        // Print the number of employees in each department
        System.out.println("Number of employees in each department:");
        for (Map.Entry<String, Integer> entry : employeeCountByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void avgSalaryEachDepartment(List<Employee> employeeList) {
        // Map to store total salary and count of employees for each department
        Map<String, Double> totalSalaryByDepartment = new HashMap<>();
        Map<String, Integer> employeeCountByDepartment = new HashMap<>();
        // Iterate over employee list to calculate total salary and count for each department
        for (Employee employee : employeeList) {
            String department = employee.getDepartment();
            double salary = employee.getSalary();

            totalSalaryByDepartment.put(department,
                    totalSalaryByDepartment.getOrDefault(department, 0.0) + salary);
            employeeCountByDepartment.put(department,
                    employeeCountByDepartment.getOrDefault(department, 0) + 1);
        }
        // Calculate average salary for each department
        Map<String, Double> averageSalaryByDepartment = new HashMap<>();
        for (String department : totalSalaryByDepartment.keySet()) {
            double totalSalary = totalSalaryByDepartment.get(department);
            int employeeCount = employeeCountByDepartment.get(department);
            double averageSalary = totalSalary / employeeCount;
            averageSalaryByDepartment.put(department, averageSalary);
        }
        // Print the average salary of each department
        System.out.println("Average salary of each department:");
        for (Map.Entry<String, Double> entry : averageSalaryByDepartment.entrySet()) {
            System.out.printf(entry.getKey() + ": %.3f \n", entry.getValue());
        }
    }

    public static void youngestEmpOfDepartment(List<Employee> employeeList) {
        Employee youngestMaleInProductDev = null;
        for (Employee employee : employeeList) {
            // Check if the employee is male and in the Product Development department
            if (employee.getGender().equalsIgnoreCase("Male")
                    && employee.getDepartment().equalsIgnoreCase("Product Development")) {
                // If youngestMaleInProductDev is null or the current employee is younger, update youngestMaleInProductDev
                if (youngestMaleInProductDev == null || employee.getAge() < youngestMaleInProductDev.getAge()) {
                    youngestMaleInProductDev = employee;
                }
            }
        }
        // Print the details of the youngest male employee in the Product Development department
        if (youngestMaleInProductDev != null) {
            System.out.println("Details of the youngest male employee in the Product Development department:");
            System.out.println(youngestMaleInProductDev);
        } else {
            System.out.println("No male employee found in the Product Development department.");
        }
    }

    public static void countMaleFemaleInDepartment(List<Employee> employeeList) {
        int maleCount = 0;
        int femaleCount = 0;
        for (Employee employee : employeeList) {
            if (employee.getDepartment().equalsIgnoreCase("Sales And Marketing")) {
                if (employee.getGender().equalsIgnoreCase("Male")) {
                    maleCount++;
                } else if (employee.getGender().equalsIgnoreCase("Female")) {
                    femaleCount++;
                }
            }
        }
        System.out.println("Male employees in Sales and Marketing: " + maleCount);
        System.out.println("Female employees in Sales and Marketing: " + femaleCount);
    }

    public static void avgSalaryOfMAleAndFemale(List<Employee> employeeList) {
        double totalMaleSalary = 0;
        double totalFemaleSalary = 0;
        int maleCount = 0;
        int femaleCount = 0;
        for (Employee employee : employeeList) {
            if (employee.getGender().equalsIgnoreCase("Male")) {
                totalMaleSalary += employee.getSalary();
                maleCount++;
            } else if (employee.getGender().equalsIgnoreCase("Female")) {
                totalFemaleSalary += employee.getSalary();
                femaleCount++;
            }
        }
        double maleAverageSalary = maleCount > 0 ? totalMaleSalary / maleCount : 0;
        double femaleAverageSalary = femaleCount > 0 ? totalFemaleSalary / femaleCount : 0;

        System.out.println("Average salary of male employees: " + maleAverageSalary);
        System.out.println("Average salary of female employees: " + femaleAverageSalary);
    }

    public static void namesOfEmpEachDepartment(List<Employee> employeeList) {
        Map<String, List<String>> departmentEmployees = new HashMap<>();
        for (Employee employee : employeeList) {
            String department = employee.getDepartment();
            String name = employee.getName();
            if (!departmentEmployees.containsKey(department)) {
                departmentEmployees.put(department, new ArrayList<>());
            }
            departmentEmployees.get(department).add(name);
        }
        departmentEmployees.forEach((department, employees) -> {
            System.out.println("Department: " + department);
            System.out.println("Employees: " + employees);
        });
    }

    public static void avgAndTotalSalaryOfOrg(List<Employee> employeeList) {
        double totalSalary = 0;
        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }
        double averageSalary = employeeList.isEmpty() ? 0 : totalSalary / employeeList.size();
        System.out.println("Total salary of the whole organization: " + totalSalary);
        System.out.println("Average salary of the whole organization: " + averageSalary);
    }

    public static void separateYoungerOrEqualToAge(List<Employee> employeeList) {
        List<Employee> youngerOrEqual25 = new ArrayList<>();
        List<Employee> olderThan25 = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getAge() <= 25) {
                youngerOrEqual25.add(employee);
            } else {
                olderThan25.add(employee);
            }
        }
        System.out.println("Employees younger or equal to 25 years:");
        youngerOrEqual25.forEach(System.out::println);

        System.out.println("\nEmployees older than 25 years:");
        olderThan25.forEach(System.out::println);
    }
    
    public static void oldestEmpInOrgGetAge(List<Employee> employeeList){
        Employee oldestEmployee = null;
        for (Employee employee : employeeList) {
            if (oldestEmployee == null || employee.getAge() > oldestEmployee.getAge()) {
                oldestEmployee = employee;
            }
        }
        if (oldestEmployee != null) {
            System.out.println("Oldest employee: " + oldestEmployee.getName());
            System.out.println("Age: " + oldestEmployee.getAge());
            System.out.println("Department: " + oldestEmployee.getDepartment());
        }
    } 
}
