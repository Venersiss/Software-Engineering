/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author PC
 */
public class FXMLDocumentController implements Initializable {

   public class student 
    
    void showdata(int modelnumber) {

        ObservableList<Table> data = FXCollections.observableArrayList();
        DBConnection.init();
        Connection c = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = c.prepareStatement("Select * from soft_eng.table_prototype");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                data.add(new Table(""))
                //Table.addRow(new Object[]{rs.getString("weapon_id"), rs.getString("class"), rs.getString("name"), rs.getString("type"), rs.getString("price")});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private TableView<?> Table;
    @FXML
    private Label label;
    @FXML
    private TextField Namefield;
    @FXML
    private TextField Coursefield;
    @FXML
    private TextField Programfield;
    @FXML
    private TextField Yearfield;
    @FXML
    private Button Closebutton;
    @FXML
    private Button Createbutton;
    @FXML
    private Button Updatebutton;
    @FXML
    private Button Deletebutton;
    @FXML
    private Button Refreshbutton;
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void Close(ActionEvent event) {
    }

    @FXML
    private void Create_Data(ActionEvent event) {
    }

    @FXML
    private void Update_Data(ActionEvent event) {
    }

    @FXML
    private void Delete_Data(ActionEvent event) {
    }

    @FXML
    private void Refresh(ActionEvent event) {
    }
    
}
