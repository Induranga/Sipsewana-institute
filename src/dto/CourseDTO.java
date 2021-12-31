package dto;

public class CourseDTO {

    private String programID;
    private String programName;
    private String programDuration;
    private Double programFee;

    public CourseDTO() {
    }

    public CourseDTO(String programID, String programName, String programDuration, Double programFee) {
        this.setProgramID(programID);
        this.setProgramName(programName);
        this.setProgramDuration(programDuration);
        this.setProgramFee(programFee);
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

    public Double getProgramFee() {
        return programFee;
    }

    public void setProgramFee(Double programFee) {
        this.programFee = programFee;
    }
}
