package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
   @Id
    private String programID;
    private String programName;
    private String programDuration;
    private double programFee;


    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private Set<StudentCourses> studentCourses=new HashSet<>();

    public Set<StudentCourses> getStudentCourses() {

        return studentCourses;
    }

    public void addStudentCourses(StudentCourses studentCourses) {
        getStudentCourses().add(studentCourses);

    }


    public Course(String programID, String programName, String programDuration, double programFee) {
        this.setProgramID(programID);
        this.setProgramName(programName);
        this.setProgramDuration(programDuration);
        this.setProgramFee(programFee);
    }

    public Course() {
    }

    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(String programDuration) {
        this.programDuration = programDuration;
    }

    public double getProgramFee() {
        return programFee;
    }

    public void setProgramFee(double programFee) {
        this.programFee = programFee;
    }
}
