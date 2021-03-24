/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import entities.BangDiem;
import entities.Classic;
import entities.Point;
import entities.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.text.html.parser.DTD;

/**
 *
 * @author DELL
 */
public class StudentDAO extends DAO{
    public StudentDAO() {
        super();
    }
    
    public Student getStudentByUserID(String idStudent) {
        Student student = new Student();
        String sql = "SELECT * FROM student WHERE Id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idStudent);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student.setId(idStudent);
                student.setMaSV(rs.getString("MaSV"));
                student.setName(rs.getString("Name"));
                
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<BangDiem> getListStudentByIdUser(String idUser) {
        ArrayList<BangDiem> listBangDiems = new ArrayList<>();
        String sql = "select s.Id, s.Name, s.MaSV, p.Id,  p.Chuyencan, p.TP1, p.TP2, p.Diemthi, ptd.PhantramCC, ptd.PhantramTP1, ptd.PhantramTP2, ptd.PhantramDT from teacher t, user u, point p, subject sub, student s, classic c, phantramdiem ptd where  s.Id = p.studentId and c.Id = p.ClassicId and ptd.SubjectId = c.SubjectId and u.Id = t.userId and t.Id = sub.teacherId and sub.Id = c.SubjectId and u.Id = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idUser);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                Point p = new Point();
                p.setId(rs.getString("p.Id"));
                p.setCC(rs.getFloat("p.Chuyencan"));
                p.setTP1(rs.getFloat("p.TP1"));
                p.setTP2(rs.getFloat("p.TP2"));
                p.setDT(rs.getFloat("p.Diemthi"));
                               
                float ptCC, ptTP1, ptTP2, ptDT, tb;
                ptCC = rs.getFloat("ptd.PhantramCC");
                ptTP1 = rs.getFloat("ptd.PhantramTP1");
                ptTP2 = rs.getFloat("ptd.PhantramTP2");
                ptDT = rs.getFloat("ptd.PhantramDT");
                
                
                Student student = new Student();
                student.setId(rs.getString("s.Id"));
                student.setMaSV(rs.getString("s.Name"));
                student.setName(rs.getString("s.MaSV"));
                
                tb = tinhTB(p.getCC(), p.getTP1(), p.getTP2(), p.getDT(), ptCC, ptTP1, ptTP2, ptDT);
                if (p.getCC() != 0 && p.getTP1()!= 0 && p.getTP2()!= 0 ) {         
                    p.setDKDT(1);
                }
                else{
                    float a = 0;
                    p.setDT(a);
                    p.setDKDT(0);
                }
                p.setDiemTB(tb);
                
                BangDiem bangDiem = new BangDiem(student,Integer.parseInt(student.getId()), p);
                listBangDiems.add(bangDiem);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBangDiems;
    }
    
    public float tinhTB(float cc, float tp1, float tp2, float dt, float ptCC, float ptTP2, float ptTP1, float ptDT){
        float tb = (cc*ptCC + tp1*ptTP1 + tp2*ptTP2 + dt*ptDT)/100;
        return tb;
    }
}
