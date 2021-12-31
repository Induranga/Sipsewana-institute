package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBoardController {


    public StackPane dashboardContex;
    public AnchorPane backStackPaneContex;


    public void initialize(){


    }


    public void btnStudentRegister(ActionEvent actionEvent) throws IOException {

        URL resource= getClass().getResource("../view/StudentAddForm.fxml");
        Parent load = FXMLLoader.load(resource);
        /*Stage window=(Stage) dashboardContex.getScene().getWindow();
        window.setScene(new Scene(load));
*/
        Stage stage=new Stage();
        stage.setScene(new Scene(load));
        stage.show();

    }

    public void btnManage(ActionEvent actionEvent) throws IOException {
        URL resource= getClass().getResource("../view/ManageCouses.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage=new Stage();
        stage.setScene(new Scene(load));
        stage.show();



    }

    public void btnUpdateStudent(ActionEvent actionEvent) throws IOException {
        URL resource= getClass().getResource("../view/ManageStudent.fxml");
        Parent load = FXMLLoader.load(resource);

        Stage stage=new Stage();
        stage.setScene(new Scene(load));
        stage.show();



    }

    public void btnDeleteStudent(ActionEvent actionEvent) {


    }
}
