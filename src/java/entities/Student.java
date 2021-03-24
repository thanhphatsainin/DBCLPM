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
public class Student implements Serializable{
    private String id, idUser, name, maSV;
    private ArrayList<Point> listPoints;

    public Student() {
    }

    public Student(String id, String name, String maSV) {
        this.id = id;
        this.name = name;
        this.maSV = maSV;
    }
    
    

    public Student(String id, String idUser, String name, String maSV, ArrayList<Point> listPoints) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.maSV = maSV;
        this.listPoints = listPoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public ArrayList<Point> getListPoints() {
        return listPoints;
    }

    public void setListPoints(ArrayList<Point> listPoints) {
        this.listPoints = listPoints;
    }
    
    
}
