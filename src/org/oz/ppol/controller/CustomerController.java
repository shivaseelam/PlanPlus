package org.oz.ppol.controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.oz.ppol.bo.customer.CustomerBO;
import org.oz.ppol.dto.CalApptDTO;
import org.oz.ppol.dto.customerdto.CustomerDTO;
import org.oz.ppol.service.customerservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by shiva9 on 2/7/2017.
 */

@Controller
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    /*public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }*/



   /* @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        List<CustomerDTO> customerDTOs = null;
        HttpSession session = null;
        customerDTOs = customerService.getAllCustomers();
        *//*ObjectMapper mapper = new ObjectMapper();*//*
        session = request.getSession();
        session.setAttribute("lstCustomers",customerDTOs);

        return  new ModelAndView("list_customers");
    }*/


    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model)  {

        List<CustomerDTO> customerDTOs = null;
         customerDTOs=customerService.getAllCustomers();
        ObjectMapper mapper = new ObjectMapper();

        String jsonInString = null;


            jsonInString = mapper.writeValueAsString(customerDTOs);


        model.addAttribute("employeeList",jsonInString);
        return "list_customers";
    }*/




    @RequestMapping("/list_customers")
    public ModelAndView viewCustomers(){


        String jsonInString = getString();


        return new ModelAndView("list_customers","lstCustomers",jsonInString);
    }

    private String getString() {
        List<CustomerDTO> customerDTOs = null;
        customerDTOs=customerService.getAllCustomers();
        ObjectMapper mapper = new ObjectMapper();

        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(customerDTOs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonInString;
    }


    @RequestMapping(value="/edit_customers/{id}")
    public ModelAndView editCustomer(@PathVariable("id") int id){

        CustomerDTO customerDTO = null;
        customerDTO=customerService.getCustomerId(id);
        ObjectMapper mapper = new ObjectMapper();

        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(customerDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return new ModelAndView("edit_customers","command",customerDTO);
    }


    @RequestMapping(value="/update_customer",method = RequestMethod.POST)
    public ModelAndView updateCustomer(@ModelAttribute("customerDTO")CustomerDTO customerDTO){
    //public ModelAndView updateCustomer(@RequestParam("customerDTO")CustomerDTO customerDTO){
    //public ModelAndView updateCustomer(@RequestBody CustomerDTO customerDTO){

         boolean bSuccess ;
        //int id = customerDTO.getcustomerId();
        bSuccess=customerService.updateCusotmer(customerDTO);
        return new ModelAndView("edit_customers","command",customerDTO);
    }

    @RequestMapping(value="/delete_customer/{id}",method = RequestMethod.POST)
    public ModelAndView deleteCustomer(@PathVariable("id") int id){

        CustomerDTO customerDTO = null;
         boolean bSuccess =customerService.deleteCustomer(id);
        /*ObjectMapper mapper = new ObjectMapper();

        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(customerDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        String jsonInString = getString();

        //return new ModelAndView("list_customers","updateCustomer",jsonInString);
        //return new ModelAndView("list_customers","lstCustomers",jsonInString);
        return new ModelAndView("redirect:/list_customers");
    }

    @RequestMapping(value="/create_customer",method = RequestMethod.POST)
    public ModelAndView createCustomer(@ModelAttribute("customerDTO")CustomerDTO customerDTO){

        boolean bSuccess ;
        bSuccess=customerService.createCustomer(customerDTO);
        return new ModelAndView("redirect:/list_customers");
    }

    @RequestMapping(value="/displayForm")
    public ModelAndView createCustomer(){

        return new ModelAndView("customer_create","command",new CustomerDTO());
    }



}
