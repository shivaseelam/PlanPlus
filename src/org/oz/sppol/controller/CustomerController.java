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





    @RequestMapping(value="/list_customers",method = RequestMethod.GET)
    public ModelAndView viewCustomers(){


        //String columnHeaders ="";
        String columnHeaders1 ="";
        //columnHeaders = customerService.getCustomViewHeaders(352);
        //String[] csvValues = columnHeaders.split(",");
        String jsonInString = getString();

        ObjectMapper mapper = new ObjectMapper();

        //Map<String,Object> columnMap = new HashMap<>();

        //String columns = " COLUMNS :"+viewCustomerHeaders();
        JSONObject jsonData = new JSONObject();
        JSONArray dataArray = new JSONArray();

        jsonData.put("COLUMNS",viewCustomerHeaders());
        jsonData.put("DATA",customerService.getAllCustomers());
        dataArray.add(jsonData);



        //List columnMap =new ArrayList();
        //columnMap.add(columns);

       /* try {
            //columnHeaders=  mapper.writeValueAsString(csvValues);
            //columnMap.put("COLUMNS",viewCustomerHeaders());
            //columnMap.put("DATA",jsonInString);
            columnHeaders1 =mapper.writeValueAsString(columnMap);
        } catch (Exception e) {
            e.printStackTrace();
        }*/



        return new ModelAndView("list_customers","lstCustomers",dataArray.toJSONString() );
    }



    public JSONArray viewCustomerHeaders()
    {
        String columnHeaders ="";
        columnHeaders = customerService.getCustomViewHeaders(352);
        String[] csvValues = columnHeaders.split(",");
       // Map<String,Object> columnMap = new HashMap<>();
        //MultiValueMap columnMap = new MultiValueMap();
        /*columnMap.put("title1",csvValues[0]);
        columnMap.put("title2",csvValues[1]);
        columnMap.put("title3",csvValues[2]);*/
        //List columnMap = new ArrayList();
        JSONArray list = new JSONArray();
        //JSONObject headers =new JSONObject(); ;
        //JSONObject[] headers = new JSONObject[3]; ;
        //String  custId = "{'title' :'CUSTOMERID'}";
        JSONObject jsonObject;
        //new JSONObject().put(headers.put("title_01","CUSTOMERID"));
        for(int i = 0 ;i <= csvValues.length;i++)
        {
            /*String  keyValue = "{ 'title' :'"+csvValues[i]+"'}";
            columnMap.add(keyValue);*/
            //columnMap.put("title_"+i,csvValues[i]);
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

       /* ObjectMapper mapper = new ObjectMapper();


        try {
            columnHeaders=  mapper.writeValueAsString(columnMap);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return  list;
    }

   /* @RequestMapping(value="/list_customers_headers",method = RequestMethod.GET)
    public @ResponseBody String viewCustomersHeaders(Model model){


        String columnHeaders ="";
         columnHeaders = customerService.getCustomViewHeaders(352);
        String[] csvValues = columnHeaders.split(",");
          *//*Map<String,Object> columnMap = new HashMap<>();
                columnMap.put("sTitle",csvValues[0]);
                columnMap.put("sTitle1",csvValues[1]);
                columnMap.put("sTitle2",csvValues[2]);*//*


            ObjectMapper mapper = new ObjectMapper();


        try {
            columnHeaders=  mapper.writeValueAsString(csvValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return new ModelAndView("list_customers","lstCustomers1",columnHeaders);
       model.addAttribute("list_customers_headers",columnHeaders);
        return  "jsonTemplate";
    }*/
    /*@RequestMapping(value="/list_customers",method = RequestMethod.GET)
    public ModelAndView viewCustomers(Map<String,Object> modelMap){


        String columnHeaders = customerService.getCustomViewHeaders(352);
        String jsonInString = getString();

        modelMap.put("headers",columnHeaders);
        modelMap.put("jsonData",jsonInString);


        return new ModelAndView("list_customers","lstCustomers",modelMap);
    }*/

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


    @RequestMapping(value="/edit_customers/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value="/getCustomer/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") int id){

        CustomerDTO customerDTO = null;
        customerDTO=customerService.getCustomerId(id);
       if(customerDTO  == null)
       {
           return new ResponseEntity<CustomerDTO>(HttpStatus.NOT_FOUND);
       }


        return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);

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

    @RequestMapping(value="/delete_customer/{id}", method = RequestMethod.GET)
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



}
