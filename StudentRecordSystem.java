import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private List<Integer> grades;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }
    
    public void addGrade(int grade) {
        grades.add(grade);
    }
    
    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.size();
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
}

public class StudentRecordSystem {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Student Record System");
        System.out.println("---------------------");
        
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a student");
            System.out.println("2. Display student records");
            System.out.println("3. Calculate average grades");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 0:
                    System.out.println("Thank you for using the Student Record System. Goodbye!");
                    return;
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudentRecords();
                    break;
                case 3:
                    calculateAverageGrades();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            System.out.println();
        }
    }
    
    public static void addStudent() {
        System.out.println("Enter the student's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the student's ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Student student = new Student(name, id);
        students.add(student);
        
        System.out.println("Student added successfully!");
    }
    
    public static void displayStudentRecords() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("Student Records");
            System.out.println("---------------");
            
            for (Student student : students) {
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getId());
                System.out.println("---------------------------");
            }
        }
    }
    
    public static void calculateAverageGrades() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("Average Grades");
            System.out.println("--------------");
            
            for (Student student : students) {
                double averageGrade = student.calculateAverageGrade();
                
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getId());
                System.out.println("Average Grade: " + averageGrade);
                System.out.println("---------------------------");
            }
        }
    }
}
