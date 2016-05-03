package com.george.controller;

import com.george.dao.ClientsDAO;
import com.george.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientsController {

    @Autowired
    private ClientsDAO clientsDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Clients findById(@PathVariable int id) {
        return clientsDAO.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clients> findAll() {
        return clientsDAO.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int insert(@RequestBody Clients client) {
        return clientsDAO.insert(client);
    }

    @RequestMapping(value = "/up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int update(@RequestBody Clients client) {
        return clientsDAO.update(client);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int deleteById(@RequestParam("id") int id) {
        return clientsDAO.deleteById(id);
    }


}
