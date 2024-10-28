package ruan.caetano.ex1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.json.JSONObject;
import ruan.caetano.ex1.util.MaskFieldUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

public class exController implements Initializable {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField tfBairro;

    @FXML
    private TextField tfCEP;

    @FXML
    private TextField tfCNPJ;

    @FXML
    private TextField tfCidade;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfEstado;

    @FXML
    private TextField tfIE;

    @FXML
    private TextField tfNomeFant;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfRazao;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MaskFieldUtil.cnpjField(tfCNPJ);
        MaskFieldUtil.cepField(tfCEP);
        MaskFieldUtil.foneField(tfNumero);
    }
    private void buscaCEP()
    {
        String cep=new String();
        StringBuffer dados = new StringBuffer();
        try {
            URL url = new URL("https://viacep.com.br/ws/"+ cep + "/json");
            URLConnection con = url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setAllowUserInteraction(false);
            InputStream in = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s = "";
            while (null != (s = br.readLine()))
                dados.append(s);
            br.close();
            System.out.println(dados);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JSONObject my_obj = new JSONObject(dados);
        System.out.println(my_obj.getString("cidade"));
        System.out.println(my_obj.getString("bairro"));

    }
    @FXML
    void onCancelar(ActionEvent event) {
        btCancelar.getScene().getWindow().hide();
    }

    @FXML
    void onConfirmar(ActionEvent event) {
        String mensg="Confirma o cadastro da empresa" +tfRazao.getText();
        Alert alerta=new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmação");
        alerta.setContentText(mensg);
        if(alerta.showAndWait().get()==ButtonType.OK)
        {
            tfRazao.setText("");
        }
        System.out.println(mensg);
    }

    public void onCepDigitado(KeyEvent keyEvent) {
        if(tfCEP.getText().length()==9)
        {
            buscaCEP();

        }
    }
}
