/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package table;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class Student_ListController implements Initializable {

   
    @FXML
    private Button Backbutton;
    ObservableList<Student_Information> tableStudent = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Student_Information, String> IDtable;
    @FXML
    private TableColumn<Student_Information, String> Nametable;
    @FXML
    private TableColumn<Student_Information, String> Programtable;
    @FXML
    private TableColumn<Student_Information, String> Coursetable;
    @FXML
    private TableColumn<Student_Information, String> Yeartable;
    @FXML
    private TableView<Student_Information> TableID;
    @FXML
    private TextField searchfield1;
    @FXML
    private ComboBox<String> ComboBox1;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IDtable.setCellValueFactory(new PropertyValueFactory<>("IDtable"));
        Nametable.setCellValueFactory(new PropertyValueFactory<>("Nametable"));
        Programtable.setCellValueFactory(new PropertyValueFactory<>("Programtable"));
        Coursetable.setCellValueFactory(new PropertyValueFactory<>("Coursetable"));
        Yeartable.setCellValueFactory(new PropertyValueFactory<>("Yeartable"));
        ComboBox();
        load_data();
        
    }    

    @FXML
    private void Backbutton(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
            Stage Close = (Stage) Backbutton.getScene().getWindow();
            Close.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void load_data(){
    try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;//tawag sa tibuok result sa table
            ps = c.prepareStatement("Select * from soft_eng.table");
            rs = ps.executeQuery();
            tableStudent.clear();
            
            while (rs.next()) {
               tableStudent.add(new Student_Information(rs.getString("Student_ID"), rs.getString("Name"), rs.getString("Program"), rs.getString("Course"), rs.getString("Year")));
            }
            TableID.setItems(tableStudent);
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }

    @FXML
    private void Searchfield(ActionEvent event) {
        try {
            DBConnection.init();
            Connection c = (Connection) DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;//tawag sa tibuok result sa table
            switch (ComboBox1.getSelectionModel().getSelectedIndex()) {
            case 0:
                ps = c.prepareStatement("Select * from soft_eng.table WHERE Student_ID LIKE '%"+searchfield1.getText()+"%' ORDER BY Student_ID ASC;");
                rs = ps.executeQuery();
                tableStudent.clear();
                
                break;
            case 1:
                ps = c.prepareStatement("Select * from soft_eng.table WHERE Name LIKE '%"+searchfield1.getText()+"%' ORDER BY Name ASC;");
                rs = ps.executeQuery();
                tableStudent.clear();
                
                break;
            case 2:
                
                ps = c.prepareStatement("Select * from soft_eng.table WHERE Course LIKE '%"+searchfield1.getText()+"%' ORDER BY Course ASC;");
                rs = ps.executeQuery();
                tableStudent.clear();
                
                break;
            case 3:
                ps = c.prepareStatement("Select * from soft_eng.table WHERE Program LIKE '%"+searchfield1.getText()+"%' ORDER BY Program ASC;");
                rs = ps.executeQuery();
                tableStudent.clear();
                
                break;
            case 4:
                ps = c.prepareStatement("Select * from soft_eng.table WHERE Year LIKE '%"+searchfield1.getText()+"%' ORDER BY Year ASC;");
                rs = ps.executeQuery();
                tableStudent.clear();
                
                break;
                
            default:
                throw new AssertionError();
        }
            
            while (rs.next()) {
               tableStudent.add(new Student_Information(rs.getString("Student_ID"), rs.getString("Name"), rs.getString("Program"), rs.getString("Course"), rs.getString("Year")));
            }
            TableID.setItems(tableStudent);
        } catch (Exception e) {
            System.out.println("error");
        }   
    }

    @FXML
    private void ComboBox() {
        ObservableList<String> data = FXCollections.observableArrayList();
        data.add("Student ID");
        data.add("Student Name");
        data.add("Student Course");
        data.add("Student Program");
        data.add("Student Year");
        ComboBox1.setItems(data);
        //OptionsCombo.setValue("Select User Level");
    }
}
