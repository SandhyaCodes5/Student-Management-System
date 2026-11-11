package myPackage;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();
        int choice;
        do {
        	System.out.println("===STUDENT MANAGEMENT SYSTEM===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
            if(sc.hasNextInt()) {
            	choice = sc.nextInt();
            }else {
            	System.out.println("Invalid input. Please enter a number.");
            	sc.nextLine();
            	choice = 0;
            	continue;
            }
            switch(choice) {
            case 1:{
            	System.out.println("Enter student id");
            	if(!sc.hasNextInt()) {
            		System.out.println("Please enter a valid number");
            		sc.nextLine();
            		break;
            	}
            	int id = sc.nextInt();
            	if(id<=0) {
            		System.out.println("Student id must be positive");
            		break;
            	}
            	sc.nextLine();
            	System.out.println("Enter student name");
            	String name = sc.nextLine();
            	if(name.trim().isEmpty()) {
            		System.out.println("Student name cannot be empty.");
            		break;
            	}
            	System.out.println("Enter student email");
            	String email = sc.nextLine();
            	if(email.trim().isEmpty()) {
            		System.out.println("Email cannot be empty.");
            		break;
            	}
            	if(!email.contains("@") || !email.contains(".")) {
            		System.out.println("Please enter a valid email.");
            		break;
            	}
            	System.out.println("Enter student course");
            	String course = sc.nextLine();
            	if (course.trim().isEmpty()) {
            		System.out.println("Course cannot be empty.");
            		break;
            	}
            	sm.addStudent(id, name, email, course);
            	break;
            }
            case 2:
            	sm.viewStudents();
            	break;
            case 3:{
            	System.out.println("Enter student id");
            	if(!sc.hasNextInt()) {
            		System.out.println("Please enter a valid number");
            		sc.nextLine();
            		break;
            	}
            	int id = sc.nextInt();
            	if(id<=0) {
            		System.out.println("Student id must be positive.");
            		break;
            	}
            	sc.nextLine();
            	System.out.println("Enter new name");
            	String newName = sc.nextLine();
            	if(newName.trim().isEmpty()) {
            		System.out.println("Name cannot be empty.");
            		break;
            	}
            	System.out.println("Enter new email");
            	String newEmail = sc.nextLine();
            	if(newEmail.trim().isEmpty()) {
            		System.out.println("Email cannot be empty.");
            		break;
            	}
            	if(!newEmail.contains("@") || !newEmail.contains(".")) {
            		System.out.println("Please enter a valid email.");
            		break;
            	}
            	System.out.println("Enter new Course.");
            	String newCourse = sc.nextLine();
            	if(newCourse.trim().isEmpty()) {
            		System.out.println("Course cannot be empty");
            		break;
            	}
            	sm.updateStudent(id, newName, newEmail, newCourse);
            	break;
            }
            case 4:{
            	System.out.println("Enter student id to be deleted.");
            	if(!sc.hasNextInt()) {
            		System.out.println("Please enter a valid number");
            		sc.nextLine();
            		break;
            	}
            	int id = sc.nextInt();
            	if(id<=0) {
            		System.out.println("Student id should be positive.");
            		break;
            	}
            	System.out.println("Are you sure you want to delete this student? (yes/no)");
            	sc.nextLine();
            	String confirm = sc.nextLine();
            	if(confirm.equalsIgnoreCase("no")) {
            		System.out.println("Deletion cancelled");
            		break;
            	}
            	else if(!confirm.equalsIgnoreCase("yes")) {
            		System.out.println("Invalid input. Answer in yes or no");
            		break;
            	}
            	sm.deleteStudent(id);
            	break;
            }
            case 5:{
            	System.out.println("Enter student id to be searched");
            	if(!sc.hasNextInt()) {
            		System.out.println("Please enter a valid number");
            		sc.nextLine();
            		break;
            	}
            	int id = sc.nextInt();
            	if(id<=0) {
            		System.out.println("Student id should be positive");
            		break;
            	}
            	sm.searchStudent(id);
            	break;
            }
            case 6:
            	System.out.println("Exiting Student Management System");
            	break;
            default:
            	System.out.println("Invalid choice");
            }
        }while(choice!=6);
        sc.close();
    }
}
