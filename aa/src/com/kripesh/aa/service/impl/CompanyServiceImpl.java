/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripesh.aa.service.impl;

import com.kripesh.aa.dao.CompanyDAO;
import com.kripesh.aa.dao.impl.CompanyDAOImpl;
import com.kripesh.aa.entity.Company;
import com.kripesh.aa.service.CompanyService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CompanyServiceImpl implements CompanyService{

    private CompanyDAO cDAO= new CompanyDAOImpl();
    @Override
    public int insert(Company c) throws ClassNotFoundException, SQLException {
        return cDAO.insert(c);
    }

    @Override
    public int update(Company c)throws ClassNotFoundException, SQLException {
        return cDAO.update(c);
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException{
        return cDAO.delete(id);
    }

    @Override
    public List<Company> getAll()throws ClassNotFoundException, SQLException {
        return cDAO.getAll();
    }

    @Override
    public Company getById(int id)throws ClassNotFoundException, SQLException {
        return cDAO.getById(id);
    }
    
}
