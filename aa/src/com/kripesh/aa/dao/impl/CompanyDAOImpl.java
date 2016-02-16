/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripesh.aa.dao.impl;

import com.kripesh.aa.dao.CompanyDAO;
import com.kripesh.aa.dbutil.DbConnection;
import com.kripesh.aa.entity.Company;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CompanyDAOImpl implements CompanyDAO{

    private DbConnection db= new DbConnection();
    @Override
    public int insert(Company c)throws ClassNotFoundException,SQLException{
        db.open();
        String sql="INSERT INTO company(name,address,email,status)VALUE(?,?,?,?)";
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getAddress());
        stmt.setString(3, c.getEmail());
        stmt.setBoolean(4, c.isStatus());
        int result=db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int update(Company c)throws ClassNotFoundException,SQLException {
        db.open();
        String sql="UPDATE company SET name=?,address=?,email=?,status=? WHERE id=?";
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getAddress());
        stmt.setString(3, c.getEmail());
        stmt.setBoolean(4, c.isStatus());
        stmt.setInt(5, c.getId());
        int result=db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int delete(int id)throws ClassNotFoundException,SQLException {
        db.open();
        String sql="DELETE FROM company WHERE id=?";
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setInt(1, id);
        int result=db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public List<Company> getAll()throws ClassNotFoundException,SQLException {
       List<Company> cList = new ArrayList<Company>();
       db.open();
       String sql="SELECT * FROM company";
       ResultSet rs= db.executeQuery();
       while(rs.next()){
           cList.add(mapdata(rs));
       }
       db.close();
       return cList;
    }

    @Override
    public Company getById(int id) throws ClassNotFoundException,SQLException{
        Company c=null;
        db.open();
        String sql="SELECT * FROM company WHERE id=?";
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs= db.executeQuery();
        while(rs.next()){
            c=mapdata(rs);
        }
        db.close();
        return c;
    }
    
    private Company mapdata(ResultSet rs) throws SQLException{
        Company c = new Company();
        c.setId(rs.getInt("id"));
        c.setName(rs.getString("name"));
        c.setEmail(rs.getString("email"));
        c.setAddress(rs.getString("address"));
        c.setStatus(rs.getBoolean("status"));
        return c;
    }
    
}
