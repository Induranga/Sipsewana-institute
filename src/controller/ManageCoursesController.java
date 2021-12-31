package controller;

import bo.BoFactory;
import bo.custom.ManageCourseBO;
import dto.CourseDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.CourseTM;

import java.util.List;
import java.util.Optional;

public class ManageCoursesController {
    public TableView<CourseTM> tblProgramme;
    public TableColumn colProgramId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;
    public TextField txtcourseID;
    public TextField txtcourseProgram;
    public TextField txtcourseDuration;
    public TextField txtcourseFee;
    public TextField txtCourseSearch;

    ManageCourseBO manageCourseBO = (ManageCourseBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.COURSE);

    public void initialize() {
        tblProgramme.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("programID"));
        tblProgramme.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("programName"));
        tblProgramme.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("programDuration"));
        tblProgramme.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("programFee"));


        loadAllCourses();

   /*     tblProgramme.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{


                txtcourseID.setText(newValue.getProgramID());
                txtcourseProgram.setText(newValue.getProgramName());
                txtcourseDuration.setText(newValue.getProgramDuration());
                txtcourseFee.setText(String.valueOf(newValue.getProgramFee()));            
        });*/

    }

    private void loadAllCourses() {
        tblProgramme.getItems().clear();
        List<CourseDTO> courseDTOList = manageCourseBO.getAllCourses();

        for (CourseDTO courseDTO : courseDTOList) {
            tblProgramme.getItems().add(new CourseTM(courseDTO.getProgramID(), courseDTO.getProgramName(), courseDTO.getProgramDuration(), courseDTO.getProgramFee()));

        }
    }


    public void btnCouseAdd(ActionEvent actionEvent) {


/*
        manageCourseBO.addCourse(new CourseDTO(txtcourseID.getText(), txtcourseProgram.getText(), txtcourseDuration.getText(), Double.valueOf(txtcourseFee.getText())));
*/
        if (manageCourseBO.ifExistCourse(txtcourseID.getText())) {
            new Alert(Alert.AlertType.WARNING, "Course Allready").showAndWait();
        } else {
            //use validation
            if (txtcourseID.getText().isEmpty() | txtcourseProgram.getText().isEmpty() | txtcourseDuration.getText().isEmpty() | txtcourseFee.getText().isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Try Again").showAndWait();
            } else {
                manageCourseBO.addCourse(new CourseDTO(txtcourseID.getText(), txtcourseProgram.getText(), txtcourseDuration.getText(), Double.valueOf(txtcourseFee.getText())));
                new Alert(Alert.AlertType.CONFIRMATION, "Course aded Complete").showAndWait();
                loadAllCourses();
            }
        }

    }

    public void btnCouseUpdate(ActionEvent actionEvent) {
        manageCourseBO.updateCourseDetails(new CourseDTO(txtcourseID.getText(),txtcourseProgram.getText(),txtcourseDuration.getText(),Double.valueOf(txtcourseFee.getText())));
        new Alert(Alert.AlertType.CONFIRMATION,"Update Success").showAndWait();
        loadAllCourses();

    }



    public void btnSelectOnActin(ActionEvent actionEvent) {
        CourseTM selectedItem = tblProgramme.getSelectionModel().getSelectedItem();

        ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"are you sure select", ok, cancel);

        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.orElse(ok)==ok){
            txtcourseID.setText(selectedItem.getProgramID());
            txtcourseProgram.setText(selectedItem.getProgramName());
            txtcourseDuration.setText(selectedItem.getProgramDuration());
            txtcourseFee.setText(String.valueOf(selectedItem.getProgramFee()));
        }

    }
}
