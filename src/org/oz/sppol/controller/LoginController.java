package org.oz.sppol.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.oz.sppol.dto.customerdto.CustomerDTO;
import org.oz.sppol.service.common.subscriber.FwkSubscriberService;
import org.oz.sppol.service.common.user.FwkUserService;
import org.oz.sppol.service.common.user.FwkUserServiceImpl;
import org.oz.sppol.service.customerservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by WIN on 5/18/2017.
 */
@RestController
public class LoginController {



    @Autowired
    private CustomerService customerService;
   /* @RequestMapping(value="/login")
    public String showLoginForm(){

        //return "redirect:/html/login.html";

    }*/

    @Autowired
    private FwkUserService fwkUserService;
    @Autowired
    private FwkSubscriberService fwkSubscriberService;

    @RequestMapping(value="/login")
    public ModelAndView showLoginForm(){

        return new ModelAndView("redirect:/html/login.html");
    }
    @RequestMapping(value="/html/submitform",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    //public  ModelAndView loginAuthenticate(@PathVariable("accountname") String accountname,@PathVariable("username")String username,@PathVariable("password") String password)
    public ResponseEntity<List<CustomerDTO>> loginAuthenticate(@RequestBody Map data)
    {



        String accountname= (String) data.get("accountname");
        String username= (String) data.get("username");
        String password= (String) data.get("password");
        boolean msg = fwkSubscriberService.subscriberServiceExist("ahsWebBean",accountname);

        List<CustomerDTO> customerDTO = null;
        customerDTO=customerService.getAllCustomersRest();
        if(customerDTO  == null && fwkUserService.validate("ahsWebBean",username, password, "") >0)
        {

            return new ResponseEntity<List<CustomerDTO>>(HttpStatus.NO_CONTENT);
        }
    return new ResponseEntity<List<CustomerDTO>>(customerDTO, HttpStatus.OK);


    }

}
