package com.george.controller;

import com.george.dao.ClientsDAO;
import com.george.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//@RestController
@RequestMapping(value = "/clients")
public class ClientsController {

    @Autowired
    private ClientsDAO clientsDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Clients findById(@PathVariable int id) {
        return clientsDAO.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clients> findAll() {return clientsDAO.findAll();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int insert(@PathVariable Clients obj) {return clientsDAO.insert(obj);}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int update(@PathVariable Clients obj) {return clientsDAO.update(obj);}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int deleteById(@PathVariable int id) {return clientsDAO.deleteById(id); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Clients findClientsByFirstAndLastName(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String country)
    {return clientsDAO.findClientByFirstAndLastName(firstName,lastName,country);}
}
