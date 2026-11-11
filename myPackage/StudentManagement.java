package myPackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StudentManagement {

	public void addStudent(int id, String name, String email, String course) {
		String sql = "INSERT INTO students(id, name, email, course) VALUES (?,?,?,?)";
		try(Connection con = DBConnection.getConnection()) {
			if (con == null) {
				return;
			}
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, course);
				int rows = ps.executeUpdate();
				if(rows > 0) {
					System.out.println("Student added successfully.");
				}
				
			}
		}
		catch(SQLException e){
			if(e.getErrorCode() ==1062) {
				System.out.println("Student id already exists.");
			}else {
				e.printStackTrace();
			}
		}
	}
	public void viewStudents() {
		String sql = "SELECT * FROM students";
		try(Connection con = DBConnection.getConnection()){
			if(con == null) {
				return;
			}
			try(PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					boolean found = false;
					while(rs.next()) {
						found = true;
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String email = rs.getString("email");
						String course = rs.getString("course");
						System.out.println("Student id: " + id);
						System.out.println("Student name: " + name);
						System.out.println("Student email: " + email);
						System.out.println("Student course: " + course);
						System.out.println("--------------------------");
					}
					if(!found) {
						System.out.println("No student found!");
					}
				}
			}
		}	
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateStudent(int id, String newName, String newEmail, String newCourse) {
		String sql = "UPDATE students SET name = ? , email = ? , course = ? WHERE id = ?";
		try(Connection con = DBConnection.getConnection()){
			if(con == null) {
				return;
			}
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, newName);
				ps.setString(2, newEmail);
				ps.setString(3, newCourse);
			    ps.setInt(4, id);
			    int rows = ps.executeUpdate();
			    if(rows > 0) {
			    	System.out.println("Student details updated successfully.");
			    }else {
			    	System.out.println("Student not found.");
			    }
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteStudent(int id) {
		String sql = "DELETE FROM students WHERE id = ? ";
		try(Connection con = DBConnection.getConnection()){
			if(con == null) {
				return;
			}try(PreparedStatement ps = con.prepareStatement(sql)) {
			     ps.setInt(1, id);
			     int rows = ps.executeUpdate();
			     if(rows > 0) {
				     System.out.println("Removed successfully.");
			     }else {
				     System.out.println("Student not found.");
			     }
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
    public void searchStudent(int id){
    	String sql = "SELECT * FROM students WHERE id = ?";
    	try(Connection con = DBConnection.getConnection()){
    		if(con == null) {
    			return;
    		}
    		try(PreparedStatement ps = con.prepareStatement(sql)){
    			ps.setInt(1, id);
    			try(ResultSet rs = ps.executeQuery()){
    				if(rs.next()) {
    					int studentId= rs.getInt("id");
    					String name = rs.getString("name");
    					String email = rs.getString("email");
    					String course = rs.getString("course");
    					System.out.println("Student id: "+ studentId);
    					System.out.println("Student name: "+ name);
    					System.out.println("Student email: "+ email);
    					System.out.println("Student course: "+ course);
    				}else {
    					System.out.println("Student not found");
    				}
    			}
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
	public static void main(String[] args) {
	
        StudentManagement sm = new StudentManagement();
        sm.addStudent(1,"Sandhya", "ngowigo@gmail.com", "B.Tech");
        sm.addStudent(2, "Anushka", "anu@gmail.com","BCA");
        sm.addStudent(3, "Shubh", "shubh45@gmail.com", "M.Tech");
        sm.addStudent(1, "Rahul", "rahul@gmail.com", "BCA");
        sm.viewStudents();

}
}
