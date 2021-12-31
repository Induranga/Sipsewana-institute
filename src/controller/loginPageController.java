package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class loginPageController {
    public TextField userNameTxt;

    public JFXButton btnLoogin;
    public AnchorPane backgroundContex;

        Stage stage = null;
    public void btnLogin(ActionEvent actionEvent) throws IOException {
        URL resource= getClass().getResource("../view/DashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window=(Stage) backgroundContex.getScene().getWindow();
        window.setScene(new Scene(load));
    }

}
