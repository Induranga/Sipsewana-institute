package bo.custom;

import dto.StudentDTO;

import java.util.List;

public interface ManageStudentBO {


    List<StudentDTO>getAllStudent();
    List<StudentDTO>getStudentFromCourse(String courseID);

}
