package com.george;

import com.george.dao.ClientsDAO;
import com.george.dao.ContractDAO;
import com.george.dao.SalesDAO;
import com.george.model.Clients;
import com.george.model.Contract;
import com.george.model.Sales;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class ContractDAOTest {

    private static ApplicationContext ctx;
    private static ClientsDAO clientsDAO;
    private static SalesDAO salesDAO;
    private static ContractDAO contractDAO;

    @BeforeClass
    public static void setUp() {
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        clientsDAO = ctx.getBean(ClientsDAO.class);
        salesDAO = ctx.getBean(SalesDAO.class);
        contractDAO = ctx.getBean(ContractDAO.class);
    }

@Ignore
    @Test
    public void testContract() {

        Sales inputForContract = Sales.builder()
                .lastName("test1")
                .firstName("test2")
                .dateOfBirth("1111-11-11")
                .department("dept")
                .build();
        salesDAO.insert(inputForContract);
        Clients inputForC = Clients.builder()
                .lastName("Ionescu")
                .firstName("Gica")
                .dateOfBirth("1111-11-11")
                .nationality("RO")
                .build();
        clientsDAO.insert(inputForC);
        Contract input =  Contract.builder()
                .ClientID(27)
                .SalesID(33)
                .creationDate("2010-10-10 12:00:00.0")
                .settlementDate("2011-10-10")
                .usedCurrency("euro")
                .boughtCurrency("dolar")
                .exchangeRate(1.1)
                .amount(10000)
                .price(100)
                .build();

        contractDAO.insert(input);

        Contract output = contractDAO.findById(12);

        assertEquals(input.getCreationDate(), output.getCreationDate());
        assertEquals(input.getSettlementDate(), output.getSettlementDate());
        assertEquals(input.getBoughtCurrency(), output.getBoughtCurrency());
        assertEquals(input.getUsedCurrency(), output.getUsedCurrency());


    }

}
