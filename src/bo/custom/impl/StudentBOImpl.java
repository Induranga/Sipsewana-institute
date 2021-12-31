package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.CourseDao;
import dao.custom.QuaryDao;
import dao.custom.StudentCoursesDAO;
import dao.custom.StudentDAO;
import dto.CourseDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Student;
import entity.StudentCourses;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    CourseDao courseDao = (CourseDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);
    StudentCoursesDAO studentCoursesDAO = (StudentCoursesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENTCOURSE);
    QuaryDao queryDAO = (QuaryDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUARYDAO);

    @Override
    public void registerStudent(StudentDTO studentDTO) {
        try {
/*
            studentDAO.add(new Student());
*/

            Student student = new Student(studentDTO.getId(),studentDTO.getNic(),studentDTO.getName(),studentDTO.getDateOfBirth(),studentDTO.getGender(),studentDTO.getParentName(),studentDTO.getMobile(),studentDTO.getAddress(),studentDTO.getOl_result(),studentDTO.getAl_result(),studentDTO.getEmail());

            CourseDTO courseDTO=studentDTO.getCourseDTO();

            Course course=new Course(courseDTO.getProgramID(),courseDTO.getProgramName(),courseDTO.getProgramDuration(),courseDTO.getProgramFee());

            StudentCourses studentCourses=new StudentCourses();
            studentCourses.setStudent(student);
            studentCourses.setCourse(course);

            studentDAO.add(student);
            studentCoursesDAO.add(studentCourses);



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<CourseDTO> getAllCourses() {
        try {
            List<Course> all = courseDao.getAll();
            List<CourseDTO> allCourse = new ArrayList<>();
            for (Course course : all) {
                allCourse.add(new CourseDTO(course.getProgramID(), course.getProgramName(), course.getProgramDuration(), course.getProgramFee()));
            }
            return allCourse;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

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

    //------------------------------------------------------------------

}
