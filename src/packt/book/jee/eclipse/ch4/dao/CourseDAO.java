package packt.book.jee.eclipse.ch4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import packt.book.jee.eclipse.ch4.bean.Course;
import packt.book.jee.eclipse.ch4.db.connection.DatabaseConnectionFactory;

public class CourseDAO {
  public static void addCourse(Course course) throws SQLException  {
    final String sql = "INSERT INTO Course(name, credits) values(?,?)";
    // get connection from connection pool
    try (Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
       PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      stmt.setString(1,  course.getName());
      stmt.setInt(2, course.getCredits());
      stmt.execute();
      try (ResultSet rs = stmt.getGeneratedKeys()) {
        if (rs.next())
          course.setId(rs.getInt(1));
      }
    }
  }
}