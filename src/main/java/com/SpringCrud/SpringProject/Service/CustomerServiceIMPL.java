package com.SpringCrud.SpringProject.Service;

import com.SpringCrud.SpringProject.CustomerRepo.CustomerRepo;
import com.SpringCrud.SpringProject.DTO.CustomerDTO;
import com.SpringCrud.SpringProject.DTO.CustomerSaveDTO;
import com.SpringCrud.SpringProject.DTO.CustomerUpdateDTO;
import com.SpringCrud.SpringProject.entity.Customer;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToStdout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService{

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String addCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customer=new Customer();
        customer.setCustomername(customerSaveDTO.getCustomername());
        customer.setCustomeraddress(customerSaveDTO.getCustomeraddress());
        customer.setMobile(customerSaveDTO.getMobile());

        customerRepo.save(customer);
        return customer.getCustomername();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomers=customerRepo.findAll();
       List<CustomerDTO> customerDTOList=new ArrayList<>();
       for(Customer a:getCustomers){
           CustomerDTO customerDTO=new CustomerDTO();
           customerDTO.setCustomerid(a.getCustomerid());
           customerDTO.setCustomername(a.getCustomername());
           customerDTO.setCustomeraddress(a.getCustomeraddress());
           customerDTO.setMobile(a.getMobile());
           customerDTOList.add(customerDTO);
       };
      return customerDTOList;
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
       if(customerRepo.existsById(customerUpdateDTO.getCustomerid()))
       {
           Customer customer=customerRepo.getById(customerUpdateDTO.getCustomerid());

           customer.setCustomername(customerUpdateDTO.getCustomername());
           customer.setCustomeraddress(customerUpdateDTO.getCustomeraddress());
           customer.setMobile(customerUpdateDTO.getMobile());
           customerRepo.save(customer);
       }
       else
       {
           System.out.println("Customer Id do Not Exist");
       }
       return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }
        else
        {
            System.out.println("customer id not found");
        }
        return true;
    }

}
