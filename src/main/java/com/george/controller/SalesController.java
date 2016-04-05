package com.george.controller;

import com.george.dao.SalesDAO;
import com.george.model.Sales;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/sales")
public class SalesController {

    @Autowired
    private SalesDAO salesDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Sales findById(@PathVariable int id) {
        return salesDAO.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sales> findAll() {
        return salesDAO.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int insert(@RequestBody Sales sales) {
        return salesDAO.insert(sales);
    }

    @RequestMapping(value = "/up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int update(@RequestBody Sales sales) {
        return salesDAO.update(sales);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int deleteById(@RequestParam("id") int id) throws MessagingException {
        return salesDAO.deleteById(id);
    }


}
