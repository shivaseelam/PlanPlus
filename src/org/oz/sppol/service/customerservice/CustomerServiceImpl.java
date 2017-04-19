package org.oz.sppol.service.customerservice;

import org.json.simple.JSONArray;
import org.oz.sppol.bo.customer.CustomerBO;
import org.oz.sppol.dao.customerdao.CustomerDAO;
import org.oz.sppol.dto.customerdto.CustomerDTO;
import org.oz.sppol.perzpageview.CustomerUtil;
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
    public List getAllCustomers() {
            List<CustomerBO> customerBOs = null;
            List customerDTOs = null;

        CustomerDTO customerDTO = null;
        customerBOs = customerDAO.getAllCustomerDetails();
        //customerBOs = customerDAO.getAllCustomersByView();
        //customerDTOs = new ArrayList<>();
        JSONArray customerArray = new JSONArray();
        for (CustomerBO customerBO:customerBOs)
        {

             //customerDTO=new CustomerDTO();
            //CustomerBO customerBO_DATA = new CustomerBO();
             ;
            /*customerDTO.setcustomerId(customerBO.getcustomerId());
            customerDTO.setfirstName(customerBO.getfirstName());
            customerDTO.setlastName(customerBO.getlastName());
            customerDTO.setdisplayName(customerBO.getdisplayName());
            customerDTO.setcustomerNumber(customerBO.getcustomerNumber());
            customerDTO.setcustomerCategory(customerBO.getcustomerCategory());*/

            customerArray.add(CustomerUtil.setValues2(customerBO, getCustomViewHeaders(352)));
        }
        return  customerArray;
    }

    @Override
    public String getCustomViewHeaders(int viewId) {

        return customerDAO.getCustomViewColumns(viewId);
    }

    public String toString() {
        return "CustomerServiceImpl [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }







    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }




}
