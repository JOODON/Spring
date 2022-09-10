package org.example;

import DTO.DAO.RoleDao;
import DTO.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class SELECTALLTEST {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleDao roleDao=ac.getBean(RoleDao.class);
        Connection conn=null;

        List<Role> list =roleDao.selectAll();

        for (Role role:list){
            System.out.println(role);
        }
    }
}
