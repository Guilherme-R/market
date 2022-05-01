package com.guilhermebrandao.dao.client;

import com.guilhermebrandao.dao.DAO;

public interface ClientDao extends DAO {

    void updatePassword(String newPassword);

}
