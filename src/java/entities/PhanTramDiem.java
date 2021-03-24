/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class PhanTramDiem implements Serializable{
    private String id, idSubject;
    private Float phantramCC, phantramTP1, phantramTP2, phantramDT;

    public PhanTramDiem() {
    }

    public PhanTramDiem(String id, String idSubject, Float phantramCC, Float phantramTP1, Float phantramTP2, Float phantramDT) {
        this.id = id;
        this.idSubject = idSubject;
        this.phantramCC = phantramCC;
        this.phantramTP1 = phantramTP1;
        this.phantramTP2 = phantramTP2;
        this.phantramDT = phantramDT;
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

    public Float getPhantramCC() {
        return phantramCC;
    }

    public void setPhantramCC(Float phantramCC) {
        this.phantramCC = phantramCC;
    }

    public Float getPhantramTP1() {
        return phantramTP1;
    }

    public void setPhantramTP1(Float phantramTP1) {
        this.phantramTP1 = phantramTP1;
    }

    public Float getPhantramTP2() {
        return phantramTP2;
    }

    public void setPhantramTP2(Float phantramTP2) {
        this.phantramTP2 = phantramTP2;
    }

    public Float getPhantramDT() {
        return phantramDT;
    }

    public void setPhantramDT(Float phantramDT) {
        this.phantramDT = phantramDT;
    }

    
}
