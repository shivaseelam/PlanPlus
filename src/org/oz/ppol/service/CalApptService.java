package org.oz.ppol.service;

import org.oz.ppol.dto.CalApptDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by siva on 1/2/2017.
 */
@Service
public interface CalApptService {

    public  String createCalAppt(CalApptDTO calApptDTO);
    public  String updateCalAppt(CalApptDTO calApptDTO);
    public  CalApptDTO calApptById(int apptId);
    public  int  deleteCalAppt(int apptId);
    public  List<CalApptDTO> getAllCalAppts();

}
