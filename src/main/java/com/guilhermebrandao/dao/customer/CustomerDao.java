package com.guilhermebrandao.dao.customer;

import com.guilhermebrandao.dao.DAO;

public interface CustomerDao<T> extends DAO {

    void updatePassword(T t);
}
