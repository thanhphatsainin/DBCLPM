/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import entities.Classic;
import entities.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ClassicDAO extends DAO{
    public ClassicDAO() {
        super();
    }
    
    
    public ArrayList<Classic> getListClassicByIdSubject(String idSubject) {
        ArrayList<Classic> result = new ArrayList<>();
        String sql = "SELECT * FROM classic where SubjectId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idSubject);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Classic classic = new Classic();
                classic.setId(rs.getString("Id"));
                classic.setName(rs.getString("Name"));
                classic.setTime(rs.getString("Time"));
                result.add(classic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
