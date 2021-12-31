package dao.custom.impl;

import dao.custom.StudentCoursesDAO;
import entity.StudentCourses;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.List;

public class StudentCoursesImpl implements StudentCoursesDAO {
    @Override
    public void add(StudentCourses studentCourses) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.save(studentCourses);

        transaction.commit();
        session.close();


    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
return false;
    }

    @Override
    public void update(StudentCourses studentCourses) throws SQLException, ClassNotFoundException {

    }

    @Override
    public StudentCourses search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<StudentCourses> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
