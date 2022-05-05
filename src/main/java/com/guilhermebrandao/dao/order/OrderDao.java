package com.guilhermebrandao.dao.order;

import com.guilhermebrandao.dao.DAO;

import java.util.List;

public interface OrderDao<T> extends DAO {

    List<T> findAllByClientId(Long clientId);
}
