package com.SpringCrud.SpringProject.CustomerController;

import com.SpringCrud.SpringProject.DTO.CustomerDTO;
import com.SpringCrud.SpringProject.DTO.CustomerSaveDTO;
import com.SpringCrud.SpringProject.DTO.CustomerUpdateDTO;
import com.SpringCrud.SpringProject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin//third party ooda connect panna(Angular/react)
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO){
        String id=customerService.addCustomer(customerSaveDTO);

        return id;
    }
    @GetMapping(path = "/getAllCustomer")
    public List<CustomerDTO> getAllCustomer(){
        List<CustomerDTO> allCustomers=customerService.getAllCustomer();
        return allCustomers;
    }

    @PostMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String id=customerService.updateCustomer(customerUpdateDTO);

        return id;
    }
    @DeleteMapping(path = "/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id){
        boolean deletecustomer=customerService.deleteCustomer(id);

        return "deleted";
    }

}
