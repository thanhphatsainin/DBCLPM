/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author DELL
 */
public class Point {
    private String id, idClassic, idStudent;
    private Float CC, TP1, TP2, DT,diemTB;
    private int DKDT;

    public Point() {
    }

    public Point(String id, Float CC, Float TP1, Float TP2, Float DT) {
        this.id = id;
        this.CC = CC;
        this.TP1 = TP1;
        this.TP2 = TP2;
        this.DT = DT;
    }

    
    
    public Point(String id, String idClassic, String idStudent, Float CC, Float TP1, Float TP2, Float DT, Float diemTB, int DKDT) {
        this.id = id;
        this.idClassic = idClassic;
        this.idStudent = idStudent;
        this.CC = CC;
        this.TP1 = TP1;
        this.TP2 = TP2;
        this.DT = DT;
        this.diemTB = diemTB;
        this.DKDT = DKDT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClassic() {
        return idClassic;
    }

    public void setIdClassic(String idClassic) {
        this.idClassic = idClassic;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public Float getCC() {
        return CC;
    }

    public void setCC(Float CC) {
        this.CC = CC;
    }

    public Float getTP1() {
        return TP1;
    }

    public void setTP1(Float TP1) {
        this.TP1 = TP1;
    }

    public Float getTP2() {
        return TP2;
    }

    public void setTP2(Float TP2) {
        this.TP2 = TP2;
    }

    public Float getDT() {
        return DT;
    }

    public void setDT(Float DT) {
        this.DT = DT;
    }

    public Float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(Float diemTB) {
        this.diemTB = diemTB;
    }

    public int getDKDT() {
        return DKDT;
    }

    public void setDKDT(int DKDT) {
        this.DKDT = DKDT;
    }
   
}
