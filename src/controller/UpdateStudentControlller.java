package controller;

import bo.BoFactory;
import bo.custom.ManageStudentBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import dto.CourseDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

public class UpdateStudentControlller {
    public TextField txtstuName;
    public TextField txtStuDOB;
    public TextField txtStuNIC;
    public TextField txtStuParentName;
    public TextField txtStuAddress;
    public TextField txtStuPhoneNum;
    public TextField txtStuOL;
    public TextField txtStuAL;
    public JFXComboBox cmbCousres;
    public JFXComboBox cmbStuGen;
    public TextField txtStuEmail;
    public TextField txtStuId;
    public TableView tblUpdateStudent;
    public TableColumn colStudentCourse;
    public TableColumn btnRemove;



    private StudentBO manageStudentBO =(StudentBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENT);
    private List<CourseDTO> allCourses = manageStudentBO.getAllCourses();
    public void initialize(){

        ObservableList<String> courseNames= FXCollections.observableArrayList();
        for (CourseDTO allCourses : allCourses) {
            courseNames.add(allCourses.getProgramName());
        }
        cmbCousres.setItems(courseNames);
    }
    public void registerStudent(ActionEvent actionEvent) {
        
    }

    public void btnAddCourse(ActionEvent actionEvent) {
    }
}
