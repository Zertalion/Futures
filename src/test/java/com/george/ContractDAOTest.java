package com.george;

import com.george.dao.ClientsDAO;
import com.george.dao.ContractDAO;
import com.george.dao.SalesDAO;
import com.george.model.Clients;
import com.george.model.Sales;
import com.george.model.Contract;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;

public class ContractDAOTest {

    private static ApplicationContext ctx;
    private static ClientsDAO clientsDAO;
    private static SalesDAO salesDAO;
    private static ContractDAO contractDAO;

    @BeforeClass
    public static void setUp(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        clientsDAO = ctx.getBean(ClientsDAO.class);
        salesDAO = ctx.getBean(SalesDAO.class);
        contractDAO = ctx.getBean(ContractDAO.class);
    }
    @Ignore
    @Test
    public void testContract(){

        Sales inputForContract = new Sales(0,"test1","test2","test3",2);
        salesDAO.insert(inputForContract);
        Clients inputForC = new Clients(0,"Ionescu","Mihai","CD2",25, 22);
        clientsDAO.insert(inputForC);
        Contract input = new Contract(0,18,22,"2010-10-10 12:00:00.0","2011-10-10","euro","dolar",1.1,10000,100);
        contractDAO.insert(input);

        Contract output = contractDAO.findById(8);

        assertEquals(input.getCreationDate(), output.getCreationDate());
        assertEquals(input.getSettlementDate(), output.getSettlementDate());
        assertEquals(input.getBoughtCurrency(), output.getBoughtCurrency());
        assertEquals(input.getUsedCurrency(), output.getUsedCurrency());


    }

}
