package com.guilhermebrandao.infra.security;

import com.guilhermebrandao.dao.client.ClientDaoImpl;
import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.request.ClientPutRequestBody;
import com.guilhermebrandao.service.exception.InvalidPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    private static ClientDaoImpl clientDaoImpl;

    @Autowired
    public PasswordValidator(ClientDaoImpl clientDaoImpl){
        this.clientDaoImpl = clientDaoImpl;
    }

    public static boolean validateClientPassword(String password){
        if(lowerCase(password) && uppperCase(password) &&  Numbers(password)
                && especialChar(password) && passwordSize(password, 8, 30)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean validateNewClientPassword(ClientPutRequestBody clientPutRequestBody){
        if(validateClientPassword(clientPutRequestBody.getNewPassword()) &&
                validateOldClientPassword(clientPutRequestBody.getOldPassword(), clientPutRequestBody.getId())){
            return true;
        }else {
            return false;
        }
    }

    private static boolean lowerCase(String password){
        if(password.matches("(.*[a-z].*)")){
            return true;
        }else{
            throw new InvalidPassword("Senha Inválida! não contém caracteres Minúsculos");
        }
    }

    private static boolean uppperCase(String password){
        if(password.matches("(.*[A-Z].*)")){
            return true;
        }else{
            throw new InvalidPassword("Senha Inválida! não contém caracteres Maiúsculos");
        }
    }

    private static boolean Numbers(String password){
        if(password.matches("(.*[0-9].*)")){
            return true;
        }else{
            throw new InvalidPassword("Senha Inválida! não contém números");
        }
    }

    private static boolean especialChar(String password){
        if(password.matches("(.*[^a-zA-Z 0-9].*)")){
            return true;
        }else{
            throw new InvalidPassword("Senha Inválida! A senha não contém caracteres especiais");
        }
    }

    private static boolean passwordSize(String password, Integer min, Integer max) {
        if (password.length() >= min && password.length() <= max) {
            return true;
        } else {
            throw new InvalidPassword("Senha Inválida! A senha precisa ter o tamanho entre " + min + "-" + max + " caracteres");
        }
    }

    private static boolean validateOldClientPassword(String oldPassword, Long clientId) {
        Client client = (Client) clientDaoImpl.findById(clientId).get();
        if (oldPassword.equals(client.getPassword())) {
            return true;
        } else {
            throw new InvalidPassword("Senha Inválida! A senha antiga está incorreta");
        }
    }
}
