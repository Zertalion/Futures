package com.george.dao;

import com.george.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesDAO extends ADAO<Sales> {

    @Autowired
    public SalesDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Sales> findAll() {
        return jdbcTemplate.query("SELECT id, firstName, lastName,department, age FROM Sales",
                new SalesRowMapper());
    }

    @Override
    public Sales findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, firstName, lastName,department, age FROM Sales where id=?",
                new Object[]{id},
                new SalesRowMapper());
    }

    @Override
    public int insert(Sales obj) {
        return jdbcTemplate.update("INSERT INTO sales (id,lastName,firstName,age,department) VALUES (?,?,?,?,?)",
                obj.getId(), obj.getLastName(), obj.getFirstName(), obj.getAge(), obj.getDepartment());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from Sales where id = ?", id);
    }

    @Override
    public int update(Sales obj) {
        return jdbcTemplate.update("UPDATE sales SET age = ?, department = ? where id = ? ", obj.getAge(), obj.getDepartment(), obj.getId());
    }

    public Sales findSalesByFirstAndLastName(String firstName, String lastName) {
        return (Sales) jdbcTemplate.queryForObject("SELECT id, FirstName, LastName,department, age " +
                        "FROM Sales where firstName = ? and lastName = ? ",
                new Object[]{firstName, lastName},
                new SalesRowMapper());
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//
//        SalesDAO salesDAO = ctx.getBean(SalesDAO.class);
//        ClientsDAO clientsDAO = ctx.getBean(ClientsDAO.class);
//        ContractDAO contractDAO = ctx.getBean(ContractDAO.class);
//
//        Sales ret = new Sales(2,"ionescu","mihai","sales",35);
//        List<Sales> rez;
//
//        Clients retC = new Clients(3,"Ionescu","Mihai","RO",25,2);
//        List<Clients> rezC;
//
//        Contract retCO;
//        Contract ad = new Contract(2,1,2,"2010-10-10 12:00:00","2011-10-10 12:00:00","euro","dolar",1.1,10000,100);
//        List<Contract> rezCO;
//int a;
//
///*
//a=contractDAO.update(ad);
//        System.out.println(a);
//
//        retCO = contractDAO.findById(1);
//        System.out.println(retCO.toString());
//        rezCO = contractDAO.findAll();
//        for(int i=0; i < rezCO.size(); i++){
//            System.out.println(rezCO.get(i).toString());
//        }
//
//       // a=clientsDAO.insert(retC);
//*/
//        a=clientsDAO.insert(retC);
//        System.out.println(a);
//        rezC = clientsDAO.findAll();
//        for(int i=0; i<rezC.size(); i++){
//            System.out.println(rezC.get(i).toString());
//        }
//
//
//
//      //a=salesDAO.update(ret);
//        //System.out.println(a);
//       // rez = salesDAO.findAll();
////        System.out.println(ret.toString());
////        for (int i = 0; i < rez.size(); i++) {
////            System.out.println(rez.get(i).toString());
////        }
//      //  int r;
//        //r = salesDAO.deleteById(2);
//        //System.out.print(r);
//        //r=salesDAO.insert(2,"ionescu","mihai",35,"sales");
//        //System.out.print(r);
//        // r = salesDAO.updateById(2, 34, "saless");
//        // if (r == 1)
//        //   System.out.print("Succes");
//        //else System.out.print("Fail");*/
//
//
//    }

    private static class SalesRowMapper implements RowMapper<Sales> {
        @Override
        public Sales mapRow(ResultSet rs, int i) throws SQLException {
            return Sales.builder()
                    .id(rs.getInt("id"))
                    .lastName(rs.getString("lastName"))
                    .firstName(rs.getString("firstName"))
                    .age(rs.getInt("age"))
                    .department(rs.getString("department"))
                    .build();
        }
    }
}

