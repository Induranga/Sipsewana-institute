package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import dto.CourseDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.List;

public class StudentAddControlller {


    public TextField txtStuId;
    StudentBO mangeStudentBO = (StudentBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENT);
    List<CourseDTO> allCourses = mangeStudentBO.getAllCourses();
    public javafx.scene.control.TextField txtstuName;
    public JFXComboBox cmbCousres;
    public JFXComboBox cmbStuGen;
    public TextField txtStuDOB;
    public TextField txtStuNIC;
    public TextField txtStuParentName;
    public TextField txtStuAddress;
    public TextField txtStuPhoneNum;
    public TextField txtStuOL;
    public TextField txtStuAL;
    public TextField txtStuEmail;



    /*Pattern idPattern = Pattern.compile("^[0-9]{1,4}$");
    Pattern namePattern = Pattern.compile("^[A-z]*[ ]?[A-z]*[ ]?[A-z]$");
    LinkedHashMap<TextField,Pattern> hashMap=new LinkedHashMap<>();
    RegisterStudentBO studentBO =(RegisterStudentBO) BoFactory.getBOFactory().getBO(BoFactory.BoTypes.STUDENT);

    */public void initialize(){

        ObservableList<String> gender= FXCollections.observableArrayList();
        gender.add("male");
        gender.add("female");
        gender.add("other");
        cmbStuGen.setItems(gender);

       /* course.add("Motor Mechanics");
        course.add("Quantity Surveying");
        course.add("Electronics");
        course.add("Foreign languages - English");
        course.add("Computer Hardware");*/

        ObservableList<String> courseNames=FXCollections.observableArrayList();
        for (CourseDTO allCourses : allCourses) {
            courseNames.add(allCourses.getProgramName());
        }
        cmbCousres.setItems(courseNames);
        //hashmapDataSet();
    }


    public void registerStudent(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(txtStuId.getText());
        studentDTO.setNic(txtStuNIC.getText());
        studentDTO.setName(txtstuName.getText());
        studentDTO.setDateOfBirth(txtStuDOB.getText());
        studentDTO.setGender(String.valueOf(cmbStuGen.getValue()));
        studentDTO.setParentName(txtStuParentName.getText());
        studentDTO.setMobile(txtStuPhoneNum.getText());
        studentDTO.setAddress(txtStuAddress.getText());
        studentDTO.setOl_result(txtStuOL.getText());
        studentDTO.setAl_result(txtStuAL.getText());
        studentDTO.setEmail(txtStuEmail.getText());

        for (CourseDTO course : allCourses) {
            if (cmbCousres.getValue().equals(course.getProgramName())){
                studentDTO.setCourseDTO(course);
                break;
            }
        }


        if (txtStuId.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Fail").showAndWait();
        }else {
            mangeStudentBO.registerStudent(studentDTO);
            new Alert(Alert.AlertType.CONFIRMATION,"Student Regiter Complete").showAndWait();
        }
    }
    }

  /*  private void hashmapDataSet() {
        hashMap.put(txtStudentId,idPattern);
        hashMap.put(txtName,namePattern);
    }*/




 /*   public void textField_KeyReleased(KeyEvent keyEvent) {
        Object response = ValidationUtil.validate(hashMap,btnRegister);
        if (keyEvent.getCode()== KeyCode.ENTER) {
            if(response instanceof TextField){
                TextField textField= (TextField) response;
                textField.requestFocus();
            }
        }
    }*/


