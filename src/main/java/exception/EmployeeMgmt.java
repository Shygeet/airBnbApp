package exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Employee class to encapsulate Employee details
class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String department;
    private double salary;

    

    @Override
    public int compareTo(Employee other) {
        return this.department.compareTo(other.department); // sorting by name
    }
    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double s) {
        salary=s;
    }
    // Overriding toString() for displaying Employee details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: $" + salary;
    }
}

// Main System Class
public class EmployeeMgmt {
    private ArrayList<Employee> Employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Method to add a new Employee
    private void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employee Employee = new Employee(id, name, department, salary);
        Employees.add(Employee);
        System.out.println("Employee added successfully!");
    }

    // Method to view all Employees
    private void viewEmployees() {
        if (Employees.isEmpty()) {
            System.out.println("No Employees found.");
        } else {
            System.out.println("Employee List before stream:");
            ArrayList<Employee> list =
            	    Employees.stream()
            	             .map(e -> {
            	                 if (e.getSalary() < 1000) {
            	                     e.setSalary(e.getSalary() * 1.5);
            	                 }
            	                 return e;   // ✅ REQUIRED
            	             })
            	             .collect(Collectors.toCollection(ArrayList::new));
            for (Employee emp : list) {
                System.out.println(emp);       
            }
           
            
            
        }
    }

    // Method to remove an Employee by ID
    private void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        Employee toRemove = null;

        for (Employee emp : Employees) {
            if (emp.getId() == id) {
                toRemove = emp;
                break;
            }
        }

        if (toRemove != null) {
            Employees.remove(toRemove);
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee not found.");
        }
    }
    
    private void sortByNameEmployee()
    {
    	System.out.println(" using comparator for mutliple sorting logic by name and salary");
    	Employees.sort(Comparator.comparing(Employee::getName));
    	Employees.sort(Comparator.comparing(Employee::getSalary));

    	Employees.forEach(System.out::println);
    	
    	System.out.println("Now using comparable logic by dept");
    	
    	Collections.sort(Employees);

    	Employees.forEach(System.out::println);
    }

    // Menu method
    private void menu() {
        int choice;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Remove Employee");
            System.out.println("4. Exit");
            System.out.println("5. Sort by ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> removeEmployee();
                case 4 -> System.out.println("Exiting system...");
                case 5 -> sortByNameEmployee();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    // Main method
    public static void main(String[] args) {
        EmployeeMgmt system = new EmployeeMgmt();
        system.menu();
    }
}

