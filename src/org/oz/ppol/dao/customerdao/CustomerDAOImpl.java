 package org.oz.ppol.dao.customerdao;

import org.oz.ppol.bo.customer.CustomerBO;
import org.oz.ppol.dto.customerdto.CustomerDTO;
import org.oz.ppol.perzpageview.CustomerUtil;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shiva9 on 2/7/2017.
 */
public class CustomerDAOImpl  extends  JdbcDaoSupport implements CustomerDAO {

    //private static final String GET_ALL_CUSTOMERS= "SELECT CUSTOMER_ID,FIRST_NAME,LAST_NAME FROM   SLS_CUSTOMER WHERE ACTIVE_STATUS='Y'  ; ";
    private static final String GET_ALL_CUSTOMERS= "SELECT CUSTOMER_ID,FIRST_NAME,LAST_NAME,CUSTOMER_NUMBER,DISPLAY_NAME,CUSTOMER_CATEGORY  FROM   SLS_CUSTOMER WHERE ACTIVE_STATUS='Y'  ; ";
    private static final String GET_CUSTOMER_ID= "SELECT * FROM SLS_CUSTOMER WHERE   ACTIVE_STATUS='Y' AND CUSTOMER_ID = ?";
    private static final String DELETE_CUSTOMER= "UPDATE SLS_CUSTOMER SET ACTIVE_STATUS='Y' WHERE CUSTOMER_ID = ?";

    /*private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }
*/

    @Override
    public List<CustomerBO> getAllCustomerDetails() {


        /*List<CustomerBO> customerBOs = getJdbcTemplate().query("SELECT * FROM SLS_CUSTOMER",new BeanPropertyRowMapper<CustomerBO>(CustomerBO.class));
        System.out.print(customerBOs);*/

        List<CustomerBO> customers = new ArrayList<CustomerBO>();
        List<Map<String, Object>> customerBOs =getJdbcTemplate().queryForList(GET_ALL_CUSTOMERS);
        for(Map row: customerBOs)
        {
            CustomerBO customerBO = new CustomerBO();
            customerBO.setcustomerId((Integer)row.get("CUSTOMER_ID"));
            customerBO.setfirstName((String) row.get("FIRST_NAME"));
            customerBO.setlastName((String)row.get("LAST_NAME"));
            customerBO.setcustomerNumber((Integer) row.get("CUSTOMER_NUMBER"));
            customerBO.setdisplayName((String)row.get("DISPLAY_NAME"));
            customerBO.setcustomerCategory((String)row.get("CUSTOMER_CATEGORY"));
            customers.add(customerBO);
        }
        return  customers;
    }

    private List<CustomerBO> getCustomerBOs(List<CustomerBO> customers,String sql,int customerID) {

        List<Map<String, Object>> customerBOs =getJdbcTemplate().queryForList(sql,customerID);
        for(Map row: customerBOs)
        {
            CustomerBO customerBO = new CustomerBO();
            customerBO.setcustomerId((Integer)row.get("CUSTOMER_ID"));
            customerBO.setfirstName((String) row.get("FIRST_NAME"));
            customerBO.setlastName((String)row.get("LAST_NAME"));
            customerBO.setcustomerNumber((Integer) row.get("CUSTOMER_NUMBER"));
            customerBO.setdisplayName((String)row.get("DISPLAY_NAME"));
            customerBO.setcustomerCategory((String)row.get("CUSTOMER_CATEGORY"));
            customers.add(customerBO);
        }
        return  customers;
    }

    @Override
    public CustomerBO getCustomerDetail(int customerId) {

        List<CustomerBO> customer = new ArrayList<CustomerBO>();
         customer = getCustomerBOs(customer,GET_CUSTOMER_ID,customerId);
        return customer.get(0);
    }

    @Override
    public boolean updateCustomerDetail(CustomerDTO customerDTO) {

        //String updateSql = "UPDATE SLS_CUSTOMER SET  FIRST_NAME='"+customerDTO.getfirstName()+"'  WHERE ACTIVE_STATUS='Y' AND CUSTOMER_ID="+customerDTO.getcustomerId();
        String updateSql = "UPDATE SLS_CUSTOMER SET  FIRST_NAME = ?  WHERE ACTIVE_STATUS= ? AND CUSTOMER_ID= ?";
        Object[] params = { customerDTO.getfirstName(),'Y',customerDTO.getcustomerId()};
         int[] types  ={Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
       int bMsg = getJdbcTemplate().update(updateSql,params,types);
        boolean bSuccess =false;
        if(bMsg>0)
        {
            bSuccess = true;
        }

        return bSuccess;
    }

    @Override
    public boolean insertCustomerDetail(CustomerDTO customerDTO) {
        String insertSql = "INSERT INTO SLS_CUSTOMER (CUSTOMER_ID,FIRST_NAME,LONGSTR_FIELD_H) VALUES(?,?,?) ";
        Object[] params = { customerDTO.getcustomerId(),customerDTO.getfirstName(),""};
        int[] types  ={Types.INTEGER,Types.VARCHAR,Types.VARCHAR};
        int bMsg = getJdbcTemplate().update(insertSql,params,types);
        boolean bSuccess =false;
        if(bMsg>0)
        {
            bSuccess = true;
        }
        return bSuccess;
    }

    @Override
    public boolean deleteCustomerDetail(int customerId) {

        String deleteSql = "UPDATE SLS_CUSTOMER SET  ACTIVE_STATUS= ? WHERE  CUSTOMER_ID= ?";
        Object[] params = { 'N',customerId};
        int[] types  ={Types.VARCHAR,Types.INTEGER};
        int bMsg =  getJdbcTemplate().update(deleteSql,params,types);

        boolean bSuccess =false;
        if(bMsg>0)
        {
            bSuccess = true;
        }

        return bSuccess;
    }

    @Override
    public String getCustomViewColumns(int viewId) {

        String perViewCols = "SELECT COLUMN_PARAM FROM FWK_PERZ_VIEW WHERE VIEW_ID="+viewId+" AND ACTIVE_STATUS ='Y'";

       String columnNames =  getJdbcTemplate().queryForObject(perViewCols,String.class);

        return columnNames;
    }

    @Override
    public List<CustomerBO> getAllCustomersByView() {

        String perzViewColumns = getCustomViewColumns(298);
        List<CustomerBO> customer =  getAllCustomerDetails();
        //String GET_CUSTOMER_VIEW ="SELECT "+perzViewColumns+" FROM SLS_CUSTOMER WHERE ACTIVE_STATUS='Y' ";

        List<CustomerBO> customers = new ArrayList<CustomerBO>();
        //List<Map<String, Object>> customerBOs =getJdbcTemplate().queryForList(GET_CUSTOMER_VIEW);

        for(CustomerBO customerBO1: customer)
        {
            CustomerBO customerBO = new CustomerBO();
            customerBO = CustomerUtil.setValues(customerBO1, perzViewColumns);

            // cust util method

                // cust util method
           /* customerBO.setcustomerNumber((Integer)row.get());
            customerBO.setcustomerId((Integer)row.get("CUSTOMER_ID"));
            customerBO.setfirstName((String) row.get("FIRST_NAME"));
            customerBO.setlastName((String)row.get("LAST_NAME"));
            customerBO.setcustomerNumber((Integer) row.get("CUSTOMER_NUMBER"));
            customerBO.setdisplayName((String)row.get("DISPLAY_NAME"));
            customerBO.setcustomerCategory((String)row.get("CUSTOMER_CATEGORY"));*/
            //customerBO.setlastUpdateDate((Date)row.get("LAST_UPDATE_DATE"));


            customers.add(customerBO);
        }
        return  customers;

    }


}
