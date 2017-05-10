package org.oz.sppol.service;

import org.oz.sppol.bo.CalApptBO;
import org.oz.sppol.dao.CalApptDAO;
import org.oz.sppol.dto.CalApptDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siva on 1/2/2017.
 */
public class CalApptServiceImpl  implements CalApptService{



    private CalApptDAO calApptDAO;

    public void setCalApptDAO(CalApptDAO calApptDAO) {
        this.calApptDAO = calApptDAO;
    }

    @Override
    public String createCalAppt(CalApptDTO calApptDTO) {
        CalApptBO calApptBO = null;
         int count = 0;
         calApptBO = new CalApptBO();
        calApptBO.set_apptId(calApptDTO.get_apptId());
        calApptBO.set_apptName(calApptDTO.get_apptName());
        calApptBO.set_apptDesc(calApptDTO.get_apptDesc());
        calApptBO.set_apptPrivate(calApptDTO.get_apptPrivate());
        calApptBO.set_apptDate(calApptDTO.get_apptDate());
        calApptBO.set_apptDateSortable(calApptDTO.get_apptDateSortable());
        calApptBO.set_startTime(calApptDTO.get_startTime());
        calApptBO.set_duration(calApptDTO.get_duration());
        calApptBO.set_evtType(calApptDTO.get_evtType());
        calApptBO.set_evtStatus(calApptDTO.get_evtStatus());
        calApptBO.set_closedFlag(calApptDTO.get_closedFlag());
        calApptBO.set_evtImportance(calApptDTO.get_evtImportance());
        calApptBO.set_evtCategory(calApptDTO.get_evtCategory());
        calApptBO.set_apptUserId(calApptDTO.get_apptUserId());
        calApptBO.set_apptAgenda(calApptDTO.get_apptAgenda());
        calApptBO.set_apptOutcome(calApptDTO.get_apptOutcome());
        calApptBO.set_reminderFlag(calApptDTO.get_reminderFlag());
        calApptBO.set_xferNoteFlag(calApptDTO.get_xferNoteFlag());
        calApptBO.set_accessKey(calApptDTO.get_accessKey());
        calApptBO.set_recurrenceType(calApptDTO.get_recurrenceType());
        calApptBO.set_recurrenceInterval(calApptDTO.get_recurrenceInterval());
        calApptBO.set_recurrenceTimes(calApptDTO.get_recurrenceTimes());
        calApptBO.set_recurrenceDayofWeek(calApptDTO.get_recurrenceDayofWeek());
        calApptBO.set_recurrenceDayofMonth(calApptDTO.get_recurrenceDayofMonth());
        calApptBO.set_evtAllday(calApptDTO.get_evtAllday());
        calApptBO.set_evtAlldayStart(calApptDTO.get_evtAlldayStart());
        calApptBO.set_evtAlldayEnd(calApptDTO.get_evtAlldayEnd());
        calApptBO.set_longStrFieldH(calApptDTO.get_longStrFieldH());
        calApptBO.set_location(calApptDTO.get_location());
        calApptBO.set_apptEndDuration(calApptDTO.get_apptEndDuration());
        calApptBO.set_apptEndTime(calApptDTO.get_apptEndTime());
        calApptBO.set_apptEndDate(calApptDTO.get_apptEndDate());

        count = calApptDAO.insertCalAppt(calApptBO);
        if(count == 0)
            return  calApptDTO.get_apptId()+" appt Creation Failed ";
        else
            return  calApptDTO.get_apptId()+" appt Created Successfully ";


    }

    @Override
    public String updateCalAppt(CalApptDTO calApptDTO) {
        CalApptBO calApptBO = null;
        int count = 0;
        calApptBO.set_apptName(calApptDTO.get_apptName());
        calApptBO.set_apptDesc(calApptDTO.get_apptDesc());
        count = calApptDAO.updateCalAppt(calApptBO);
        if (count == 0)
            return  calApptDTO.get_apptId() +"Appt Updated Failed";
        else
            return  calApptDTO.get_apptId() +"Appt Updated Successfully";

    }

    @Override
    public CalApptDTO calApptById(int apptId) {
        CalApptBO calApptBO = null;
        CalApptDTO calApptDTO = null;

        calApptBO = calApptDAO.getCalApptById(apptId);

        calApptDTO.set_apptId(calApptBO.get_apptId());
        calApptDTO.set_apptName(calApptBO.get_apptName());
        calApptDTO.set_apptDesc(calApptBO.get_apptDesc());
        calApptDTO.set_apptPrivate(calApptBO.get_apptPrivate());
        calApptDTO.set_apptDate(calApptBO.get_apptDate());
        calApptDTO.set_apptDateSortable(calApptBO.get_apptDateSortable());
        calApptDTO.set_startTime(calApptBO.get_startTime());
        calApptDTO.set_duration(calApptBO.get_duration());
        calApptDTO.set_evtType(calApptBO.get_evtType());
        calApptDTO.set_evtStatus(calApptBO.get_evtStatus());
        calApptDTO.set_closedFlag(calApptBO.get_closedFlag());
        calApptDTO.set_evtImportance(calApptBO.get_evtImportance());
        calApptDTO.set_evtCategory(calApptBO.get_evtCategory());
        calApptDTO.set_apptUserId(calApptBO.get_apptUserId());
        calApptDTO.set_apptAgenda(calApptBO.get_apptAgenda());
        calApptDTO.set_apptOutcome(calApptBO.get_apptOutcome());
        calApptDTO.set_reminderFlag(calApptBO.get_reminderFlag());
        calApptDTO.set_xferNoteFlag(calApptBO.get_xferNoteFlag());
        calApptDTO.set_accessKey(calApptBO.get_accessKey());
        calApptDTO.set_recurrenceType(calApptBO.get_recurrenceType());
        calApptDTO.set_recurrenceInterval(calApptBO.get_recurrenceInterval());
        calApptDTO.set_recurrenceTimes(calApptBO.get_recurrenceTimes());
        calApptDTO.set_recurrenceDayofWeek(calApptBO.get_recurrenceDayofWeek());
        calApptDTO.set_recurrenceDayofMonth(calApptBO.get_recurrenceDayofMonth());
        calApptDTO.set_evtAllday(calApptBO.get_evtAllday());
        calApptDTO.set_evtAlldayStart(calApptBO.get_evtAlldayStart());
        calApptDTO.set_evtAlldayEnd(calApptBO.get_evtAlldayEnd());
        calApptDTO.set_longStrFieldH(calApptBO.get_longStrFieldH());
        calApptDTO.set_location(calApptBO.get_location());
        calApptDTO.set_apptEndDuration(calApptBO.get_apptEndDuration());
        calApptDTO.set_apptEndTime(calApptBO.get_apptEndTime());
        calApptDTO.set_apptEndDate(calApptBO.get_apptEndDate());

        return calApptDTO;
    }


    @Override
    public int deleteCalAppt(int apptId) {
        int cnt = 0;
       return  0;
    }

    @Override
    public List<CalApptDTO> getAllCalAppts() {
        List<CalApptBO> calApptBOs =null;
        List<CalApptDTO> calApptDTOs =null;

        CalApptDTO calApptDTO = null;
        calApptBOs = calApptDAO.getAllCalAppts();
        calApptDTOs = new ArrayList<>();
        for (CalApptBO calApptBO: calApptBOs) {
            calApptDTO = new CalApptDTO();
            calApptDTO.set_apptId(calApptBO.get_apptId());
            calApptDTO.set_apptName(calApptBO.get_apptName());
            calApptDTO.set_apptDesc(calApptBO.get_apptDesc());
            calApptDTO.set_apptPrivate(calApptBO.get_apptPrivate());
            calApptDTO.set_apptDate(calApptBO.get_apptDate());
            calApptDTO.set_apptDateSortable(calApptBO.get_apptDateSortable());
            calApptDTO.set_startTime(calApptBO.get_startTime());
            calApptDTO.set_duration(calApptBO.get_duration());
            calApptDTO.set_evtType(calApptBO.get_evtType());
            calApptDTO.set_evtStatus(calApptBO.get_evtStatus());
            calApptDTO.set_closedFlag(calApptBO.get_closedFlag());
            calApptDTO.set_evtImportance(calApptBO.get_evtImportance());
            calApptDTO.set_evtCategory(calApptBO.get_evtCategory());
            calApptDTO.set_apptUserId(calApptBO.get_apptUserId());
            calApptDTO.set_apptAgenda(calApptBO.get_apptAgenda());
            calApptDTO.set_apptOutcome(calApptBO.get_apptOutcome());
            calApptDTO.set_reminderFlag(calApptBO.get_reminderFlag());
            calApptDTO.set_xferNoteFlag(calApptBO.get_xferNoteFlag());
            calApptDTO.set_accessKey(calApptBO.get_accessKey());
            calApptDTO.set_recurrenceType(calApptBO.get_recurrenceType());
            calApptDTO.set_recurrenceInterval(calApptBO.get_recurrenceInterval());
            calApptDTO.set_recurrenceTimes(calApptBO.get_recurrenceTimes());
            calApptDTO.set_recurrenceDayofWeek(calApptBO.get_recurrenceDayofWeek());
            calApptDTO.set_recurrenceDayofMonth(calApptBO.get_recurrenceDayofMonth());
            calApptDTO.set_evtAllday(calApptBO.get_evtAllday());
            calApptDTO.set_evtAlldayStart(calApptBO.get_evtAlldayStart());
            calApptDTO.set_evtAlldayEnd(calApptBO.get_evtAlldayEnd());
            calApptDTO.set_longStrFieldH(calApptBO.get_longStrFieldH());
            calApptDTO.set_location(calApptBO.get_location());
            calApptDTO.set_apptEndDuration(calApptBO.get_apptEndDuration());
            calApptDTO.set_apptEndTime(calApptBO.get_apptEndTime());
            calApptDTO.set_apptEndDate(calApptBO.get_apptEndDate());
          calApptDTOs.add(calApptDTO);
        }

        return calApptDTOs;
    }
}
