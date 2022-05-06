package com.guilhermebrandao.infra.security;

import com.guilhermebrandao.dao.customer.CustomerDaoImpl;
import com.guilhermebrandao.domain.Customer;
import com.guilhermebrandao.request.CustomerPutRequestBody;
import com.guilhermebrandao.service.exception.InvalidPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    private static CustomerDaoImpl customerDaoImpl;

    @Autowired
    public PasswordValidator(CustomerDaoImpl customerDaoImpl){
        this.customerDaoImpl = customerDaoImpl;
    }

    public static boolean validateCustomerPassword(String password){
        return lowerCase(password) && uppperCase(password) &&  Numbers(password)
                && especialChar(password) && passwordSize(password, 8, 30);
    }

    public static boolean validateNewCustomerPassword(CustomerPutRequestBody customerPutRequestBody){
        return validateCustomerPassword(customerPutRequestBody.getNewPassword())
                && validateOldClientPassword(customerPutRequestBody.getOldPassword(), customerPutRequestBody.getId());
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
        Customer customer = (Customer) customerDaoImpl.findById(clientId).get();
        if (oldPassword.equals(customer.getPassword())) {
            return true;
        } else {
            throw new InvalidPassword("Senha Inválida! A senha antiga está incorreta");
        }
    }
}
