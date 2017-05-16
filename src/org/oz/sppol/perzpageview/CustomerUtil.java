package org.oz.sppol.perzpageview;

import org.oz.sppol.bo.customer.CustomerBO;

import javax.swing.*;
import javax.swing.text.StringContent;
import java.util.ArrayList;
import java.util.List;

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
            if(col.equals("FIRST_NAME")){
                customerBO1.setfirstName(customerBO.getfirstName());
            }
            else if(col.equals("LAST_NAME")){
                customerBO1.setlastName(customerBO.getlastName());
            }
            else if(col.equals("CUSTOMER_NUMBER")){
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
    public static List setValues2(CustomerBO customerBO, String cols)
    {

        String cols1[] = cols.split(",");
        List customerBO1 = new ArrayList();
        //customerBO1.add(customerBO.getcustomerId());
        for  (String col: cols1){


            if(col.equals("FIRST_NAME")){
                if(customerBO.getfirstName() != null) {
                    if (customerBO.getfirstName().contains("'")) {
                        customerBO1.add(customerBO.getfirstName().replace("'", ""));

                    } else
                        customerBO1.add(customerBO.getfirstName());
                }
            }
            else if(col.equals("LAST_NAME")){
                if (customerBO.getlastName().contains("'")){
                    customerBO1.add(customerBO.getlastName().replace("'"," "));

                }else
                customerBO1.add(customerBO.getlastName());
            }
            else if(col.equals("CUSTOMER_NUMBER")){
                String customerNum = Integer.toString(customerBO.getcustomerNumber());
                customerBO1.add(customerNum);
            }
            else if(col.equals("DISPLAY_NAME")){
                if (customerBO.getdisplayName().contains("'")){
                    String dspName =customerBO.getdisplayName().replace("'","");
                    customerBO1.add(dspName);

                }else
                customerBO1.add(customerBO.getdisplayName());
            }
            else if(col.equals("CUSTOMER_CATEGORY")) {

                if (customerBO.getcustomerCategory() != null)
                    /*if (customerBO.getcustomerCategory().contains("\n")) {
                        String customerCat = customerBO.getcustomerCategory().replace("\n", "");*/
                        customerBO1.add(customerBO.getcustomerCategory());

                     else
                        customerBO1.add(customerBO.getcustomerCategory());

                /*else
                {
                    customerBO1.add(customerBO.getcustomerCategory());

                }*/
            }
            else if(col.equals("DISPLAY_NAME")){
                if (customerBO.getdisplayName().contains("'")){
                    String dspName =customerBO.getdisplayName().replace("'","");
                    customerBO1.add(dspName);

                }else
                    customerBO1.add(customerBO.getdisplayName());
            }
            //if(col.equals("Edit/Delete")) {

            //}

        }
        String edit_delete = "<a href=edit_customers/id="+customerBO.getcustomerId()+ " class=editor_edit><img src=resources/images/edit.gif title=Edit></a>"+
                "<a  href=delete_customer/"+customerBO.getcustomerId()+" class=editor_delete> <img src=resources/images/delete.gif title=Delete></a>";
        customerBO1.add(edit_delete);
            return customerBO1;
    }



    public static List setValues3(CustomerBO customerBO, String cols)
    {

        String cols1[] = cols.split(",");
        List customerBO1 = new ArrayList();
        //customerBO1.add(customerBO.getcustomerId());
        for  (String col: cols1) {
            String dynamicCol =col.toLowerCase().substring(col.indexOf("_")).toUpperCase();
                     //= col.substring(col.indexOf("_"));
                customerBO1.add("customerBO.get"+dynamicCol+"()");
        }

        return customerBO1;
    }
}
