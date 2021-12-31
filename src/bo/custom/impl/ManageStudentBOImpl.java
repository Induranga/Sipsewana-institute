package bo.custom.impl;

import bo.custom.ManageStudentBO;
import dao.DAOFactory;
import dao.custom.CourseDao;
import dao.custom.QuaryDao;
import dao.custom.StudentCoursesDAO;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageStudentBOImpl implements ManageStudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    CourseDao courseDao = (CourseDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    StudentCoursesDAO studentCoursesDAO = (StudentCoursesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENTCOURSE);
    QuaryDao queryDAO = (QuaryDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUARYDAO);




    @Override
    public List<StudentDTO> getAllStudent() {
        try {
            List<Student> all=studentDAO.getAll();
            List<StudentDTO>studentDTOList=new ArrayList<>();

            for (Student student : all) {
                studentDTOList.add(new StudentDTO(student.getId(),student.getNic(),student.getName(),student.getDateOfBirth(),student.getGender(),student.getParentName(),student.getMobile(),student.getAddress(),student.getOl_result(),student.getAl_result(),student.getEmail()));
            }

            return studentDTOList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null ;
    }




    @Override
    public List<StudentDTO> getStudentFromCourse(String courseID) {

        return queryDAO.getStudentFromCourseId(courseID);

    }


   /* @Override
    public List<StudentDTO> getAllStudent() {
        List<Student>all=new ArrayList<>();
        List<StudentDTO>studentDTOList=new ArrayList<>();

         for (Student student:all){

            studentDTOList.add(new StudentDTO(student.getId(),student.getNic(),student.getName(),student.getDateOfBirth(),student.getGender(),student.getParentName(),student.getMobile(),student.getAddress(),student.getOl_result(),student.getAl_result(),student.getEmail(),student.getStudentCourses()));

         }



    }*/
}
