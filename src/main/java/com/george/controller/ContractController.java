package com.george.controller;

import com.george.dao.ContractDAO;
import com.george.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//@RestController
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    private ContractDAO contractDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Contract findById(@PathVariable int id) {
        return contractDAO.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contract> findAll() {return contractDAO.findAll();}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int insert(@PathVariable Contract obj) {return contractDAO.insert(obj);}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int update(@PathVariable Contract obj) {return contractDAO.update(obj);}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int deleteById(@PathVariable int id) {return contractDAO.deleteById(id); }


}
