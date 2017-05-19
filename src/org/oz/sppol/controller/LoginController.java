package org.oz.sppol.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.oz.sppol.service.common.subscriber.FwkSubscriberService;
import org.oz.sppol.service.common.user.FwkUserService;
import org.oz.sppol.service.common.user.FwkUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by WIN on 5/18/2017.
 */
@RestController
public class LoginController {

   /* @RequestMapping(value="/login")
    public String showLoginForm(){

        //return "redirect:/pages/login.html";
        return "resources/login.html";
    }*/

    @Autowired
    private FwkUserService fwkUserService;
    @Autowired
    private FwkSubscriberService fwkSubscriberService;

    @RequestMapping(value="/login")
    public ModelAndView showLoginForm(){

        //return "redirect:/pages/login.html";
        return new ModelAndView("redirect:/pages/login.html");
    }
    @RequestMapping(value="/pages/submitform",method = RequestMethod.POST)
    //public  ModelAndView loginAuthenticate(@PathVariable("accountname") String accountname,@PathVariable("username")String username,@PathVariable("password") String password)
    public  @ResponseBody String loginAuthenticate(@RequestBody Map data)
    {

        JSONObject jsonData = new JSONObject();
        JSONArray dataArray = new JSONArray();

        String accountname= (String) data.get("accountname");
        String username= (String) data.get("username");
        String password= (String) data.get("password");
        boolean msg = fwkSubscriberService.subscriberServiceExist("ahsWebBean",accountname);
        if( fwkUserService.validate("ahsWebBean",username, password, "") >0)
        {
            dataArray.add(jsonData.put("done","success"));
            return  dataArray.toJSONString();
        }
        dataArray.add(jsonData.put("msg","invalid"));
        return  dataArray.toJSONString();

        //return new ModelAndView("redirect:/customer_ng");
    }

}
