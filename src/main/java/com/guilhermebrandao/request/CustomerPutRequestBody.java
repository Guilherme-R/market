package com.guilhermebrandao.request;

public class CustomerPutRequestBody {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String oldPassword;
    private String newPassword;

    public CustomerPutRequestBody() {
    }

    public CustomerPutRequestBody(Long id, String name, String email, String phone, String oldPassword, String newPassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone;}

    public String getOldPassword() { return oldPassword; }

    public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }

    public String getNewPassword() { return newPassword; }

    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
}
