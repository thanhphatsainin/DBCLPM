/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import entities.PhanTramDiem;
import entities.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class PhanTramDiemDAO extends DAO{
    public PhanTramDiemDAO() {
        super();
    }
    
    
    public PhanTramDiem getPhanTramDiemByIdSubject(String idSubject) {
        PhanTramDiem result = new PhanTramDiem();
        String sql = "SELECT * FROM phantramdiem where SubjectId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idSubject);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.setId(rs.getString("Id"));
                result.setIdSubject(idSubject);
                result.setPhantramCC(rs.getFloat("PhantramCC"));
                result.setPhantramTP1(rs.getFloat("PhantramTP1"));
                result.setPhantramTP2(rs.getFloat("PhantramTP2"));
                result.setPhantramDT(rs.getFloat("PhantramDT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public void editPhanTramDiem(PhanTramDiem phanTramDiem) {
        String sql = "UPDATE phantramdiem SET PhantramCC=?, PhantramTP1=?, PhantramTP2 =?, PhantramDT=? WHERE Id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
//            ps.setString(1, phanTramDiem.getIdSubject());
            ps.setFloat(1, phanTramDiem.getPhantramCC());
            ps.setFloat(2, phanTramDiem.getPhantramTP1());
            ps.setFloat(3, phanTramDiem.getPhantramTP2());
            ps.setFloat(4, phanTramDiem.getPhantramDT());
            ps.setString(5, phanTramDiem.getId());
            

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
