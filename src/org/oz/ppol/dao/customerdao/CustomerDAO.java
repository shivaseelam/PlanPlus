package org.oz.ppol.dao.customerdao;

import org.oz.ppol.bo.customer.CustomerBO;
import org.oz.ppol.dto.customerdto.CustomerDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by shiva9 on 2/7/2017.
 */
public interface CustomerDAO {

    public List<CustomerBO> getAllCustomerDetails();
    public CustomerBO getCustomerDetail(int customerId);
    public boolean updateCustomerDetail(CustomerDTO customerDTO);
    //public boolean insertCustomerDetail(CustomerBO customerBO);
    public boolean insertCustomerDetail(CustomerDTO customerDTO);
    public boolean deleteCustomerDetail(int customerId);


}
