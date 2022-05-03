package com.guilhermebrandao.dao.client;

import com.guilhermebrandao.dao.DAO;

public interface ClientDao<T> extends DAO {

    void updatePassword(T t);
}
