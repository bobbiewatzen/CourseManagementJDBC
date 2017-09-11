package packt.book.jee.eclipse.ch4.bean;

import java.sql.SQLException;
import packt.book.jee.eclipse.ch4.dao.*;

public class Course {
  private int id;
  private String name;
  private int credits;
  //private CourseDAO courseDAO = new CourseDAO();
  
  public boolean isValidCourse() {
	return name != null && credits != 0;
  }
  
  public void addCourse() throws SQLException {
	CourseDAO.addCourse(this); //static method
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
  public int getCredits() {
    return credits;
  }
  public void setCredits(int credits) {
    this.credits = credits;
  }
}