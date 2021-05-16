/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author majdi
 */
public class User {
     private int id;
    private String email;
    private String roles; 
    private String password; 
    private int cin;
    private int phone;
    private String name;
    private String genre;
        private static User userConncter;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public User(int id, String email, String roles, String password, int cin, int phone, String name, String genre) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.cin = cin;
        this.phone = phone;
        this.name = name;
        this.genre = genre;
    }

    public User(String email, String roles, String password, int cin, int phone, String name, String genre) {
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.cin = cin;
        this.phone = phone;
        this.name = name;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", roles=" + roles + ", password=" + password + ", cin=" + cin + ", phone=" + phone + ", name=" + name + ", genre=" + genre + '}';
    }

    public static User getUserConncter() {
        return userConncter;
    }

    public static void setUserConncter(User userConncter) {
        User.userConncter = userConncter;
    }

 
}
