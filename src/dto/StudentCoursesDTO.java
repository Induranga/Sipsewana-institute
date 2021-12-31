package dto;

import entity.Course;
import entity.Student;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


public class StudentCoursesDTO {
   private int id;

 private Student student;

    private Course course;

   private Date registerDate;

    public StudentCoursesDTO(int id, Student student, Course course, Date registerDate) {
        this.setId(id);
        this.setStudent(student);
        this.setCourse(course);
        this.setRegisterDate(registerDate);
    }

    public StudentCoursesDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
