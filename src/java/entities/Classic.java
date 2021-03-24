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
public class Classic implements Serializable{
    private String id, idSubject, name, time;
    private ArrayList<Point> listPoint;

    public Classic() {
    }

    public Classic(String id, String idSubject, String name, String time, ArrayList<Point> listPoint) {
        this.id = id;
        this.idSubject = idSubject;
        this.name = name;
        this.time = time;
        this.listPoint = listPoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<Point> getListPoint() {
        return listPoint;
    }

    public void setListPoint(ArrayList<Point> listPoint) {
        this.listPoint = listPoint;
    }

    
    
}
