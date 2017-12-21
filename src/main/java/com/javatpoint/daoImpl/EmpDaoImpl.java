package com.javatpoint.daoImpl;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.javatpoint.beans.Emp;  
import com.javatpoint.daoI.EmpDaol;


public class EmpDaoImpl implements EmpDaol {  
	
//Klíčová knihovna Spring pro Db. Z ní jsou pujčeny metody queryForObject(), query()
//https://stackoverflow.com/questions/22019796/error-whats-missing-in-spring-namedjdbctemplate
	
  private NamedParameterJdbcTemplate template;  
  
 //Použiju konstruktor pro inicializace typu NamedParameterJdbcTemplate
 public EmpDaoImpl(NamedParameterJdbcTemplate template) {  
	 this.template = template;  
}  
 
public List<Emp> getEmployees(){  
    return template.query("select * from Emp500",new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
            e.setId(rs.getInt("id"));  
            e.setFirstname(rs.getString("firstname"));  
            e.setLastname(rs.getString("lastname"));  
            return e;  
        }  
    });  
}  
}  