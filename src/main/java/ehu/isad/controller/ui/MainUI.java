package ehu.isad.controller.ui;

import ehu.isad.Main;
import ehu.isad.controller.db.MainKud;
import ehu.isad.model.Checksums;
import ehu.isad.model.ScanURL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class MainUI<scanURL> implements Initializable{

    private Main main;

    @FXML
    private Button check;

    @FXML
    private TextField text;

    @FXML
    private TableView<ScanURL> tbl;

    @FXML
    private TableColumn<ScanURL, String> tblurl;

    @FXML
    private TableColumn<ScanURL, String> tblmd5;

    @FXML
    private TableColumn<ScanURL, String> tblversion;

    @FXML
    private Label lbl;


    @FXML
    void onClick(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        if (!text.getText().equals("")) {
            String scanUrl = text.getText();
            String md5=lortumd5(scanUrl);
            Kargatu(md5, scanUrl);
        }
    }

    public void Kargatu(String md5, String url1) {

        boolean dago=MainKud.getInstance().datuBaseanDago(md5);
        if (dago==true){
            String bertsioa=MainKud.getInstance().bertsioabueltatu(md5);
            ScanURL scanurl1 = new ScanURL(url1, md5, bertsioa);
            ObservableList<ScanURL> eskaneatutakoak = FXCollections.observableArrayList(scanurl1);
            tbl.setItems(eskaneatutakoak);
            tbl.setEditable(true);
            lbl.setText("Datubasean zegoen");

        }
        else{
            lbl.setText("Ez da datubasean aurkitu");
        }

        tblurl.setCellValueFactory(new PropertyValueFactory<>("url"));
        tblmd5.setCellValueFactory(new PropertyValueFactory<>("md5"));
        tblversion.setCellValueFactory(new PropertyValueFactory<>("version"));
    }

    public String lortumd5 (String urltxt) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        String readme = "/README";
        URL url = new URL(urltxt + readme);
        InputStream is = url.openStream();
        MessageDigest md = MessageDigest.getInstance("MD5");
        String digest = getDigest(is, md, 2048);
        System.out.println(digest);
        return digest;

    }

    private static String getDigest(InputStream is, MessageDigest md, int byteArraySize)
            throws NoSuchAlgorithmException, IOException {

        md.reset();
        byte[] bytes = new byte[byteArraySize];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            md.update(bytes, 0, numBytes);
        }
        byte[] digest = md.digest();
        String result = new String(Hex.encodeHex(digest));
        return result;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
