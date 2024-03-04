/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package table;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<?> tabledata;
    @FXML
    private TableColumn<?, ?> Nametb;
    @FXML
    private TableColumn<?, ?> Programtb;
    @FXML
    private TableColumn<?, ?> Coursetb;
    @FXML
    private TableColumn<?, ?> Yeartb;

    void inputdata() {
        try {
            // Initialize and get the database connection
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            // Check if the connection is null
            if (c == null) {
                System.out.println("Connection is null");
                return;
            }

            ps = c.prepareStatement("INSERT INTO soft_eng.table(Name,Program, Course, Year) VALUES ('" + Namefield.getText() + "','" + Programfield.getText() + "','" + Coursefield.getText() + "','" + Yearfield.getText() + "')");

            if (!ps.execute()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            ex.printStackTrace(); // Print the stack trace for detailed error information
        }
        Namefield.setText("");
        Programfield.setText("");
        Coursefield.setText("");
        Yearfield.setText("");
    }

    void deletedata(String a) {
        try {
            // Initialize and get the database connection
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            // Check if the connection is null
            if (c == null) {
                System.out.println("Connection is null");
                return;
            }

            ps = c.prepareStatement("DELETE FROM soft_eng.table WHERE idTable = '" + a + "' ");

            if (!ps.execute()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            ex.printStackTrace(); // Print the stack trace for detailed error information
        }
        Namefield.setText("");
        Programfield.setText("");
        Coursefield.setText("");
        Yearfield.setText("");
    }

    void Updatedata(String a, String b, String d) {
        try {
            // Initialize and get the database connection
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            // Check if the connection is null
            if (c == null) {
                System.out.println("Connection is null");
                return;
            }

            ps = c.prepareStatement("UPDATE soft_eng.table SET " + a + " ='" + b + "' WHERE idTable = " + d + " ");

            if (!ps.execute()) {

            }
        } catch (SQLException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            ex.printStackTrace(); // Print the stack trace for detailed error information
        }
        Namefield.setText("");
        Programfield.setText("");
        Coursefield.setText("");
        Yearfield.setText("");
    }
    
   void showdata(int modelnumber) {

        ObservableList<Table> data = FXCollections.observableArrayList();
        DBConnection.init();
        Connection c = DBConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = c.prepareStatement("Select * from soft_eng.table");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                data.set
                //Table.addRow(new Object[]{rs.getString("weapon_id"), rs.getString("class"), rs.getString("name"), rs.getString("type"), rs.getString("price")});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public class student {

    }
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
        inputdata();
    }

    @FXML
    private void Update_Data(ActionEvent event) {
        String[] options = {"Name", "Program", "Course", "Year"};
        String id = JOptionPane.showInputDialog("Input ID of the data you want to update");
        int choice = JOptionPane.showOptionDialog(null, "Select the Data You Want to Update", "Update", 0, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                Updatedata(options[0], Namefield.getText(), id);
                break;
            case 1:
                Updatedata(options[1], Programfield.getText(), id);
                break;
            case 2:
                Updatedata(options[2], Coursefield.getText(), id);
                break;
            case 3:
                Updatedata(options[3], Yearfield.getText(), id);
                break;

        }
    }

    @FXML
    private void Delete_Data(ActionEvent event) {
        String data = JOptionPane.showInputDialog(null, "Input The ID Of The User You Want To Delete");
        deletedata(data);
    }

    @FXML
    private void Refresh(ActionEvent event) {
    }

}
