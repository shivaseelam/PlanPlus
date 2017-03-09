package org.oz.ppol.service.customerservice;

import org.oz.ppol.bo.customer.CustomerBO;
import org.oz.ppol.dao.customerdao.CustomerDAO;
import org.oz.ppol.dto.customerdto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiva9 on 2/7/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerDAO customerDAO;


    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public boolean createCustomer(CustomerDTO customerDTO) {

        boolean bSuccess = customerDAO.insertCustomerDetail(customerDTO);
        return bSuccess;
    }

    @Override
    public boolean updateCusotmer(CustomerDTO customerDTO) {

        boolean bSuccess = customerDAO.updateCustomerDetail(customerDTO);
        return bSuccess;
    }


    @Override
    public CustomerDTO getCustomerId(int customerId) {

        CustomerBO customerBO = null;
        CustomerDTO customerDTO =new CustomerDTO();

        customerBO = customerDAO.getCustomerDetail(customerId);
        customerDTO.setcustomerId(customerBO.getcustomerId());
        customerDTO.setfirstName(customerBO.getfirstName());
        customerDTO.setlastName(customerBO.getlastName());
        customerDTO.setcompanyName(customerBO.getcompanyName());
        customerDTO.setannualRevenue(customerBO.getannualRevenue());
        customerDTO.setdisplayName(customerBO.getdisplayName());
        return customerDTO;
    }

    @Override
    public boolean deleteCustomer(int customerId) {

            boolean bSuccess = customerDAO.deleteCustomerDetail(customerId);
        return false;
    }


    @Override
    public List<CustomerDTO> getAllCustomers() {
            List<CustomerBO> customerBOs = null;
            List<CustomerDTO> customerDTOs = null;

        CustomerDTO customerDTO = null;
        //customerBOs = customerDAO.getAllCustomerDetails();
        customerBOs = customerDAO.getAllCustomersByView();
        customerDTOs = new ArrayList<>();
        for (CustomerBO customerBO:customerBOs)
        {
             customerDTO=new CustomerDTO();
            customerDTO.setcustomerId(customerBO.getcustomerId());
            customerDTO.setfirstName(customerBO.getfirstName());
            customerDTO.setlastName(customerBO.getlastName());
            customerDTO.setdisplayName(customerBO.getdisplayName());
            customerDTO.setcustomerNumber(customerBO.getcustomerNumber());
            customerDTO.setcustomerCategory(customerBO.getcustomerCategory());

           customerDTOs.add(customerDTO);
        }
        return  customerDTOs;
    }

    public String toString() {
        return "CustomerServiceImpl [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }




    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }




}
