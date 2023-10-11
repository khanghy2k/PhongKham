package com.example.PhongKham.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Users {
    private String id;
    @NotEmpty(message = "Tài Khoản không được để trống")
    private String username;
    @NotEmpty(message = "Mật Khẩu không được để trống")
    private String password;
    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Địa chỉ email không hợp lệ")
    private String email;
    private Date created_at;

    public Users() {
    }

    public Users(String id, String username, String password, String email, Date created_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.created_at = created_at;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
