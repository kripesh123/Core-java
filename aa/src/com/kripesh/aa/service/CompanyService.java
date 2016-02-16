/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripesh.aa.service;

import com.kripesh.aa.entity.Company;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CompanyService {
    int insert(Company c)throws ClassNotFoundException,SQLException;
    int update(Company c)throws ClassNotFoundException,SQLException;
    int delete(int id)throws ClassNotFoundException,SQLException;
    List<Company>getAll()throws ClassNotFoundException,SQLException;
    Company getById(int id)throws ClassNotFoundException,SQLException;
}
