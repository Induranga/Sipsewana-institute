package dao.custom;

import dao.CrudDAO;
import entity.Student;

import java.sql.SQLException;

public interface StudentDAO extends CrudDAO<Student,String> {

    String generateStudentId() throws SQLException, ClassNotFoundException;
}
