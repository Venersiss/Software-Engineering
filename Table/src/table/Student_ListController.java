/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package table;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class Student_ListController implements Initializable {

   
    @FXML
    private TextField field1;
    @FXML
    private Button Searchbutton;
    @FXML
    private ComboBox<?> Combobox;
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
        load_data();
        
    }    

    @FXML
    private void Backbutton(ActionEvent event) {
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
}
