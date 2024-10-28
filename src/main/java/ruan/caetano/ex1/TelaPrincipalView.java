package ruan.caetano.ex1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaPrincipalView {
    public void onFechar(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Deseja FEchar?");
        if (alert.showAndWait().get()== ButtonType.YES)
        {
            Platform.exit();
        }
    }

    public void onCadEmpresa(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ex1.class.getResource("ex1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage= new Stage();
        stage.setTitle("Cadastro da Empresa");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
