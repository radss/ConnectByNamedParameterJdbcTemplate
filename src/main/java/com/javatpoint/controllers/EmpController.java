package com.javatpoint.controllers;

import java.util.ArrayList;  
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  

import com.javatpoint.beans.Emp;  
import com.javatpoint.daoImpl.EmpDaoImpl;

@Controller
public class EmpController {  

	
   //Přivařím beanu dao z ApplicatioContext.xml, která se odkazuje na beanu jt s 
   //org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
   //beana jt se zase odkáže (pomocí ref) na beanu dataSource, která obsahuje připojení do db
   //pořádně pokoumat jak fungují ref, constructor-arg a property name v beanách!!
	
   @Autowired  
    EmpDaoImpl dao;//will inject dao from xml file  
      
    /* It provides list of employees in model object */  
    @RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
        List<Emp> list=dao.getEmployees();  
        return new ModelAndView("viewemp","list",list);  
    }  

}  
