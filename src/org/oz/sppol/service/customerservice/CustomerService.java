package org.oz.sppol.service.customerservice;

import org.oz.sppol.bo.customer.CustomerBO;
import org.oz.sppol.dto.customerdto.CustomerDTO;

import java.util.List;

/**
 * Created by shiva9 on 2/7/2017.
 */

public interface CustomerService {

    public boolean createCustomer(CustomerDTO customerDTO);
    public boolean updateCusotmer(CustomerDTO customerDTO);
    public CustomerDTO getCustomerId(int customerId);
    public boolean deleteCustomer(int customerId);
//    public List<CustomerDTO> getAllCustomers();
     public List getAllCustomers();
    public String getCustomViewHeaders(int viewId);

    public List getAllCustomersRest();
}
