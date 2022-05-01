package com.guilhermebrandao.dto.client;

public class ClientUpdateDTO {

    private Long id;
    private String oldPassword;
    private String newPassword;

    public ClientUpdateDTO(){
    }

    public ClientUpdateDTO(Long idClient, String oldPassword, String newPassword) {
        this.id = idClient;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idClient) {
        this.id = idClient;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
