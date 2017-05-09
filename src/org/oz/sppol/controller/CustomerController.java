package org.oz.sppol.controller;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.oz.sppol.bo.customer.*;
import org.oz.sppol.dto.customerdto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.oz.sppol.dto.customerdto.*;
import org.oz.sppol.service.customerservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by shiva9 on 2/7/2017.
 */

/*@Controller*/
@RestController
public class CustomerController {


    @Autowired
    private CustomerService customerService;



        /*ModelAndView Render part*/
    @RequestMapping(value="/list_customers",method = RequestMethod.GET)
    public ModelAndView viewCustomers(){

        JSONObject jsonData = new JSONObject();
        JSONArray dataArray = new JSONArray();

        jsonData.put("COLUMNS",viewCustomerHeaders());
        jsonData.put("DATA",customerService.getAllCustomers());
        dataArray.add(jsonData);
        return new ModelAndView("list_customers","lstCustomers",dataArray.toJSONString() );
    }



    public JSONArray viewCustomerHeaders()
    {
        String columnHeaders ="";
        columnHeaders = customerService.getCustomViewHeaders(352);
        String[] csvValues = columnHeaders.split(",");
        JSONArray list = new JSONArray();
        JSONObject jsonObject;
        for(int i = 0 ;i <= csvValues.length;i++)
        {
            jsonObject = new JSONObject();

            if(i==csvValues.length)
            {
                jsonObject.put("title","EDIT/DELETE");
            }
            else
            {
                jsonObject.put("title",csvValues[i]);
            }
            list.add(jsonObject);
        }
        System.out.print(list);

       return  list;
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


    @RequestMapping(value="/edit_customers/id={id}", method = RequestMethod.GET)
    public ModelAndView editCustomer(@PathVariable("id") int id){

        CustomerDTO customerDTO = null;
        customerDTO=customerService.getCustomerId(id);
        return new ModelAndView("edit_customers","command",customerDTO);
    }




    @RequestMapping(value="/update_customer", method = RequestMethod.PUT)
    public ModelAndView updateCustomer(@ModelAttribute("customerDTO")CustomerDTO customerDTO){
         boolean bSuccess ;
        bSuccess=customerService.updateCusotmer(customerDTO);
        return new ModelAndView("edit_customers","command",customerDTO);
    }

    @RequestMapping(value="/delete_customer/{id}")
    public ModelAndView deleteCustomer(@PathVariable("id") int id){

        CustomerDTO customerDTO = null;
         boolean bSuccess =customerService.deleteCustomer(id);
        String jsonInString = getString();
        return new ModelAndView("redirect:/list_customers");
    }

    @RequestMapping(value="/create_customer")
    public ModelAndView createCustomer(@ModelAttribute("customerDTO")CustomerDTO customerDTO){

        boolean bSuccess ;
        bSuccess=customerService.createCustomer(customerDTO);
        return new ModelAndView("redirect:/list_customers");
    }

    @RequestMapping(value="/displayForm")
    public ModelAndView createCustomer(){

        return new ModelAndView("customer_create","command",new CustomerDTO());
    }

        /*JsonData for RestController CRUD OPERATIONS*/

    /*Retrieve all users*/
    @RequestMapping(value="/contact/listCustomers",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDTO>> getCustomerById(){

        List<CustomerDTO> customerDTO = null;
        customerDTO=customerService.getAllCustomersRest();
        if(customerDTO  == null )
        {

            return new ResponseEntity<List<CustomerDTO>>(HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<List<CustomerDTO>>(customerDTO, HttpStatus.OK);

    }

    @RequestMapping(value="/customer_ng",method = RequestMethod.GET)
    public ModelAndView customerAngularView()
    {
        return new ModelAndView("customer_ng","listCustomer",getString());
    }

    /*Retrieve Single user*/

    @RequestMapping(value="/contact/get/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomerById(@PathVariable("id") int id){

        CustomerDTO customerDTO = null;
        customerDTO=customerService.getCustomerId(id);
        if(customerDTO  == null || customerDTO.getcustomerId() <= 0)
        {
            return new ResponseEntity<String>("NO RECORD FOUND WITH DATA ID",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customerDTO, HttpStatus.OK);

    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CustomerDTO> deleteUser(@PathVariable("id") int id) {
        CustomerDTO customerDTO = null;
        boolean bSuccess =customerService.deleteCustomer(id);
        if (bSuccess) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<CustomerDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> updateUser(@PathVariable("id") int id, @RequestBody CustomerDTO customerDTO) {

        boolean bSuccess ;
        CustomerDTO customerDTO1 = null;
        customerDTO1=customerService.getCustomerId(id);
        bSuccess=customerService.updateCusotmer(customerDTO);

        if(bSuccess)
            return new ResponseEntity<CustomerDTO>(customerDTO1, HttpStatus.OK);

        
        return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);


    }



}



