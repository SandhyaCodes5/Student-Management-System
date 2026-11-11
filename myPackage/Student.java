package myPackage;

public class Student{
	private int studentId;
	private String name;
	private String email;
	private String course;
	Student(int studentId , String name , String email , String course){
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.course = course;
	}
	public int getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getCourse() {
		return course;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void displayOptions() {
		System.out.println("Student ID: " + studentId);
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Course: " + course);
	}
}