package controller;

import bo.BoFactory;
import bo.custom.ManageCourseBO;
import bo.custom.ManageStudentBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import view.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class UpdateCoursesController {

    public TableView<StudentTM> UpdateStudent;
    public JFXTextField txtSearch;
    public ComboBox cmbCourses;
    public JFXRadioButton radioID;
    public JFXRadioButton radioIName;
    public JFXButton updateID;
    public AnchorPane backConteContext;

    ManageCourseBO manageCourseBO = (ManageCourseBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.COURSE);
    StudentBO mangeStudentBO = (StudentBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENT);
    private List<CourseDTO> allCourses = mangeStudentBO.getAllCourses();



    public void initialize(){


        ObservableList<String> course=FXCollections.observableArrayList();
        course.add("ALL");
        for (CourseDTO allCourse : allCourses) {
            course.add(allCourse.getProgramName());
        }


        cmbCourses.setItems(course);
        cmbCourses.setValue("ALL");

        UpdateStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        UpdateStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nic"));
        UpdateStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        UpdateStudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        UpdateStudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("gender"));
        UpdateStudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("parentName"));
        UpdateStudent.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("mobile"));
        UpdateStudent.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("address"));
        UpdateStudent.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("ol_result"));
        UpdateStudent.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("al_result"));
        UpdateStudent.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("email"));


    }

    private void loadStudentToTable(List<StudentDTO> studentList){
        UpdateStudent.getItems().clear();

        if (!(studentList==null)) {

            for (StudentDTO studentDTO : studentList) {
                UpdateStudent.getItems().add(new StudentTM(studentDTO.getId(), studentDTO.getNic(), studentDTO.getName(), studentDTO.getDateOfBirth(), studentDTO.getGender(), studentDTO.getParentName(), studentDTO.getMobile(), studentDTO.getAddress(), studentDTO.getOl_result(), studentDTO.getAl_result(), studentDTO.getEmail()));
            }
        }
    }

    public void btnSearchStudent(ActionEvent actionEvent) {
        if (cmbCourses.getSelectionModel().getSelectedItem()=="ALL"){
            loadStudentToTable(mangeStudentBO.getAllStudent());
        }else{
            for (CourseDTO course : allCourses) {
                if (course.getProgramName()==cmbCourses.getSelectionModel().getSelectedItem()){
                    List<StudentDTO> studentDTOList = mangeStudentBO.getStudentFromCourse(course.getProgramID());
                    loadStudentToTable(studentDTOList);
                }
            }
        }





    }

    public void btnUpdateStudent(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/UpdateStudent.fxml");
        Parent load = FXMLLoader.load(resource);
        backConteContext.getChildren().clear();
        backConteContext.getChildren().add(load);
    }

    public void btnDeleteStudent(ActionEvent actionEvent) {
    }

    public void idRadioButton(MouseEvent mouseEvent) {
        if (radioID.isSelected()) {
            radioIName.setSelected(false);
        }
    }

    public void NameRadioButton(MouseEvent mouseEvent) {
        if (radioIName.isSelected()){
            radioID.setSelected(false);
        }
    }
}
