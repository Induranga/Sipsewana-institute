package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Entity
public class StudentCourses {
    @Id
    @Column(name = "index_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_Id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_Id")
    private Course course;

    @CreationTimestamp
    private Date registerDate;

    public StudentCourses(int id, Student student, Course course, Date registerDate) {
        this.setId(id);
        this.setStudent(student);
        this.setCourse(course);
        this.setRegisterDate(registerDate);
    }

    public StudentCourses() {
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
