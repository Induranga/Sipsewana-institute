package dao.custom.impl;

import dao.custom.QuaryDao;
import dto.StudentDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class QuaryDaoImpl implements QuaryDao {
    @Override
    public List<StudentDTO> getStudentFromCourseId(String id) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="select s.id,s.nic,s.name,s.dateOfBirth,s.gender,s.parentName,s.mobile,s.address,s.ol_result,s.al_result,s.email from Student s inner join StudentCourses sc on s.id=sc.student.id where sc.course.id=:courseId";
        Query query = session.createQuery(hql);
        query.setParameter("courseId",id);

        List<Object[]> list = ((org.hibernate.query.Query) query).list();
        List<StudentDTO> studentDTOS=new ArrayList<>();
        for (Object[] objects : list) {
            studentDTOS.add(new StudentDTO(String.valueOf(objects[0]),String.valueOf(objects[1]),String.valueOf(objects[2]),String.valueOf(objects[3]),String.valueOf(objects[4]),String.valueOf(objects[5]),String.valueOf(objects[6]),String.valueOf(objects[7]),String.valueOf(objects[8]),String.valueOf(objects[9]),String.valueOf(objects[10])));
        }

        transaction.commit();
        session.close();

        return studentDTOS;
    }
    }

