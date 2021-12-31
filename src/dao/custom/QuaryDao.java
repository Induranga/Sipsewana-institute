package dao.custom;

import dao.SuperDAO;
import dto.StudentDTO;

import java.util.List;

public interface QuaryDao extends SuperDAO {
    List<StudentDTO> getStudentFromCourseId(String id);




}

