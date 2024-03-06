/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

/**
 *
 * @author PC
 */
public class Student_Information {
    String IDtable;

    
    String Nametable;
    String Programtable;
    String Coursetable;
    String Yeartable;

    

    public Student_Information(String IDtable, String Nametable, String Programtable, String Coursetable, String Yeartable) {
        this.IDtable = IDtable;
        this.Nametable = Nametable;
        this.Programtable = Programtable;
        this.Coursetable = Coursetable;
        this.Yeartable = Yeartable;
    }
    
    public String getIDtable() {
        return IDtable;
    }

    public void setIDtable(String IDtable) {
        this.IDtable = IDtable;
    }

    

    public String getNametable() {
        return Nametable;
    }

    public void setNametable(String Nametable) {
        this.Nametable = Nametable;
    }

    public String getProgramtable() {
        return Programtable;
    }

    public void setProgramtable(String Programtable) {
        this.Programtable = Programtable;
    }

    public String getCoursetable() {
        return Coursetable;
    }

    public void setCoursetable(String Coursetable) {
        this.Coursetable = Coursetable;
    }

    public String getYeartable() {
        return Yeartable;
    }

    public void setYeartable(String Yeartable) {
        this.Yeartable = Yeartable;
    }
    
    
}
