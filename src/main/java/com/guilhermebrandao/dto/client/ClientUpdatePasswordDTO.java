package com.guilhermebrandao.dto.client;

import com.guilhermebrandao.domain.Client;

public class ClientUpdatePasswordDTO {

    private Long id;
    private String oldPassword;
    private String newPassword;

    public ClientUpdatePasswordDTO(){
    }

    public ClientUpdatePasswordDTO(Client client) {
        this.id = client.getId();
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
