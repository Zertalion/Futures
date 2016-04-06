package com.george.controller;

import com.george.dao.ContractDAO;
import com.george.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    private ContractDAO contractDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Contract findById(@PathVariable int id) {
        return contractDAO.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contract> findAll() {return contractDAO.findAll();}

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int insert(@RequestBody Contract contract) {return contractDAO.insert(contract);}

    @RequestMapping(value = "/up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int update(@RequestBody Contract contract) {return contractDAO.update(contract);}

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int deleteById(@RequestParam("id") int id) {return contractDAO.deleteById(id); }


}
