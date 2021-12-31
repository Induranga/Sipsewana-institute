package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;
import dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
public void registerStudent(StudentDTO studentDTO);
List <CourseDTO>getAllCourses();
List <StudentDTO>getAllStudent();
List<StudentDTO>getStudentFromCourse(String courseID);



}
