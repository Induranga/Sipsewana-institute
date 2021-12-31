package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;

import java.util.List;

public interface ManageCourseBO extends SuperBO {

void addCourse(CourseDTO courseDTO);

boolean ifExistCourse(String id);

List<CourseDTO>getAllCourses();
    /*cousre use karann ba */

void updateCourseDetails(CourseDTO courseDTO);

boolean deleteCourse(String id);

}
