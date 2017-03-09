package org.oz.ppol.perzpageview;

import org.oz.ppol.bo.customer.CustomerBO;

import javax.swing.*;
import javax.swing.text.StringContent;

/**
 * Created by shiva9 on 3/8/2017.
 */
public class CustomerUtil {

    public static CustomerBO setValues(CustomerBO customerBO, String cols)
    {

        String cols1[] = cols.split(",");
        CustomerBO customerBO1 = new CustomerBO();
        for  (String col: cols1){

                customerBO1.setcustomerId(customerBO.getcustomerId());
            if(col.equals("CUSTOMER_NUMBER")){
                customerBO1.setcustomerNumber(customerBO.getcustomerNumber());
            }
            else if(col.equals("DISPLAY_NAME")){
                customerBO1.setdisplayName(customerBO.getdisplayName());
            }
            else if(col.equals("CUSTOMER_CATEGORY")){
                customerBO1.setcustomerCategory(customerBO.getcustomerCategory());
            }



        }

            return customerBO1;
    }
}
