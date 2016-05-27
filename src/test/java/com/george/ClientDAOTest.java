package com.george;

import com.george.dao.ClientsDAO;
import com.george.dao.SalesDAO;
import com.george.model.Clients;
import com.george.model.Sales;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;
import java.util.Date;

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
        Clients input =  Clients.builder()
                .lastName("Ionescu")
                .firstName("Gica")
                .dateOfBirth(new Date(0))
                .nationality("RO")
                .build();
        clientsDAO.insert(input);
        Clients output  = clientsDAO.findById(30);

        assertEquals(input.getFirstName(), output.getFirstName());
        assertEquals(input.getLastName(), output.getLastName());
        assertEquals(input.getDateOfBirth(), output.getDateOfBirth());
        assertEquals(input.getNationality(), output.getNationality());
    }

}
