package org.oz.ppol.controller;

import org.oz.ppol.dto.CalApptDTO;
import org.oz.ppol.service.CalApptService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by siva on 1/2/2017.
 */
public class CalApptController extends AbstractController {


    private CalApptService calApptService;

    public void setCalApptService(CalApptService calApptService) {
        this.calApptService = calApptService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CalApptDTO> calApptDTOs = null;
        HttpSession session = null;
        calApptDTOs = calApptService.getAllCalAppts();
        session = request.getSession();
        session.setAttribute("lstCalAppts",calApptDTOs);
        return  new ModelAndView("list_cal_appts");

    }
}
