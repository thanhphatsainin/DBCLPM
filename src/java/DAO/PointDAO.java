/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class PointDAO extends DAO {

    public PointDAO() {
        super();
    }
    
    
    public Point getPointByIdStudent(String idStudent) {
        Point point = new Point();
        
        String sql = "SELECT * FROM point WHERE studentId=?;"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idStudent);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                point.setId(rs.getString("Id"));
                point.setCC(rs.getFloat("Chuyencan"));
                point.setTP1(rs.getFloat("TP1"));
                point.setTP2(rs.getFloat("TP2"));
                point.setDT(rs.getFloat("Diemthi"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return point;
    }
    
     public boolean editPoint(Point point, String idStudent) {
        String sql = "UPDATE point SET Chuyencan=?, TP1=?, TP2=?, Diemthi=? WHERE studentId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, point.getCC());
            ps.setFloat(2, point.getTP1());
            ps.setFloat(3, point.getTP2());
            ps.setFloat(4, point.getDT());
            ps.setString(5, idStudent);
            return ps.executeUpdate() > 0;

//            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi edit");
        }
        return false;
    }
    
}
