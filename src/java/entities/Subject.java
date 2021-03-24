/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Subject implements Serializable{
    private String id, idTeacher, name;
    private ArrayList<Classic> lisClassics;
    private PhanTramDiem phanTramDiem;
    

    public Subject() {
    }

    public Subject(String id, String idTeacher, String name) {
        this.id = id;
        this.idTeacher = idTeacher;
        this.name = name;
    }

    public Subject(String id, String idTeacher, String name, ArrayList<Classic> lisClassics, PhanTramDiem phanTramDiem) {
        this.id = id;
        this.idTeacher = idTeacher;
        this.name = name;
        this.lisClassics = lisClassics;
        this.phanTramDiem = phanTramDiem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Classic> getLisClassics() {
        return lisClassics;
    }

    public void setLisClassics(ArrayList<Classic> lisClassics) {
        this.lisClassics = lisClassics;
    }

    public PhanTramDiem getPhanTramDiem() {
        return phanTramDiem;
    }

    public void setPhanTramDiem(PhanTramDiem phanTramDiem) {
        this.phanTramDiem = phanTramDiem;
    }
    
    

    
    
    
    
}
