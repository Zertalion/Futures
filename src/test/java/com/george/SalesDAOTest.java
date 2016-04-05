package com.george;

/**
 * Created by georg_000 on 3/24/2016.
 */
import com.george.dao.SalesDAO;
import com.george.model.Sales;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;


public class SalesDAOTest {
    private static ApplicationContext ctx;
    private static SalesDAO salesDAO;

    @BeforeClass
    public static void setUp(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        salesDAO = ctx.getBean(SalesDAO.class);
    }
    @Ignore
    @Test
    public void testSales(){

        Sales input = new Sales(0,"test1","test2","test3",2);
        salesDAO.insert(input);
        Sales output  = salesDAO.findSalesByFirstAndLastName("test2","test1");

        assertEquals(input.getFirstName(), output.getFirstName());
        assertEquals(input.getLastName(), output.getLastName());
        assertEquals(input.getAge(), output.getAge());
    }

}
