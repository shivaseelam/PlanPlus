package org.oz.sppol.dao;

import org.oz.sppol.bo.CalApptBO;

import java.util.List;

/**
 * Created by siva on 1/2/2017.
 */
public interface CalApptDAO {

    public List<CalApptBO> getAllCalAppts();
    public CalApptBO getCalApptById(int id);
    public  int updateCalAppt(CalApptBO calApptBO);
    public  int insertCalAppt(CalApptBO calApptBO);
    public  int deleteCalAppt(int apptId);

}
