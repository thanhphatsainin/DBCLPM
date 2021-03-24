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
public class User implements Serializable{
    private String id, username, password, potion;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    
    public User(String id, String username, String password, String potion) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.potion = potion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPotion() {
        return potion;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", potion=" + potion + '}';
    }
    
    
}
