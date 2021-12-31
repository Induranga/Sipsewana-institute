package bo.custom.impl;

import bo.custom.ManageCourseBO;
import dao.DAOFactory;
import dao.custom.CourseDao;
import dto.CourseDTO;
import dto.StudentDTO;
import entity.Course;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageCourseBOImpl implements ManageCourseBO {

   CourseDao courseDao= (CourseDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public void addCourse(CourseDTO courseDTO) {
        try {
            courseDao.add(new Course(courseDTO.getProgramID(), courseDTO.getProgramName(), courseDTO.getProgramDuration(), courseDTO.getProgramFee()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean ifExistCourse(String id) {
        return courseDao.ifExistCourse(id);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        try {
            List<Course> allCourses = courseDao.getAll();
            List<CourseDTO> allList=new ArrayList<>();



            for (Course course : allCourses) {
                allList.add(new CourseDTO(course.getProgramID(),course.getProgramName(),course.getProgramDuration(),course.getProgramFee()));

            }
            return allList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
return null;
    }



    @Override
    public void updateCourseDetails(CourseDTO courseDTO) {
        try {
            courseDao.update(new Course(courseDTO.getProgramID(), courseDTO.getProgramName(), courseDTO.getProgramDuration(), courseDTO.getProgramFee()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean deleteCourse(String id) {
        try {
            return courseDao.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
return false;
    }


}
