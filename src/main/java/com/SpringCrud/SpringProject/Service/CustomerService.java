package com.SpringCrud.SpringProject.Service;

import com.SpringCrud.SpringProject.DTO.CustomerDTO;
import com.SpringCrud.SpringProject.DTO.CustomerSaveDTO;
import com.SpringCrud.SpringProject.DTO.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    String addCustomer(CustomerSaveDTO customerSaveDTO);

    List<CustomerDTO> getAllCustomer();

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    boolean deleteCustomer(int id);
}
