package com.george;

import com.george.dao.ClientsDAO;
import com.george.dao.SalesDAO;
import com.george.model.Clients;
import com.george.model.Sales;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;

/**
 * Created by georg_000 on 3/22/2016.
 */

public class ClientDAOTest {

    private static ApplicationContext ctx;
    private static ClientsDAO clientsDAO;
    private static SalesDAO salesDAO;

    @BeforeClass
    public static void setUp(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        clientsDAO = ctx.getBean(ClientsDAO.class);
        salesDAO = ctx.getBean(SalesDAO.class);
    }

    @Ignore
    @Test
    public void testClients(){
        Sales inputForClient = new Sales(0,"test1","test2","test3",2);
        salesDAO.insert(inputForClient);
        Clients input = new Clients(0,"Ionescu","Mihai","CD2",25, 1);
        clientsDAO.insert(input);
        Clients output  = clientsDAO.findClientByfirstAndLastName("Mihai","Ionescu","CD2");

        assertEquals(input.getFirstName(), output.getFirstName());
        assertEquals(input.getLastName(), output.getLastName());
        assertEquals(input.getAge(), output.getAge());
        assertEquals(input.getNationality(), output.getNationality());
    }

}
