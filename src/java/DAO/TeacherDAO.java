/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class TeacherDAO extends DAO{
    public TeacherDAO() {
        super();
    }
    
    public Teacher getTeacherByUserID(String idUser){
        Teacher teacher = new Teacher();
        String sql = "SELECT * FROM teacher WHERE userId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idUser);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                teacher.setId(rs.getString("id"));
                teacher.setIdUser(rs.getString("userId"));
                teacher.setName(rs.getString("name"));               
                return teacher;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
