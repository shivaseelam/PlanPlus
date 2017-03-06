package org.oz.ppol.dao;

import org.oz.ppol.bo.CalApptBO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by siva on 1/2/2017.
 */
public class CalApptDAOImpl implements CalApptDAO {

    public static final String GET_CALAPPT_BY_ID = "SELECT * FROM CAL_APPT WHERE APPT_ID=? AND ACTIVE_STATUS='Y' AND SGID=?";
    public static final String UPDATE_CALAPPT_BY_ID = "UPDATE CAL_APPT SET APPT_NAME=? ,APPT_DESC=? WHERE APPT_ID=?";
    public static final String GET_ALL_CALAPPTS = "SELECT * FROM CAL_APPT WHERE   ACTIVE_STATUS='Y'";

    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }



    @Override
    public List<CalApptBO> getAllCalAppts() {
        List<CalApptBO> calApptBOs = null;
        calApptBOs = jt.query(GET_ALL_CALAPPTS,new CalApptMapper());

        return calApptBOs;
    }

    @Override
    public CalApptBO getCalApptById(int id) {

        CalApptBO calApptBO = null;
         calApptBO =jt.queryForObject(GET_CALAPPT_BY_ID,new CalApptMapper(),id );

        return calApptBO;
    }

    @Override
    public int updateCalAppt(CalApptBO calApptBO) {
        int count = 0;
        count = jt.update(UPDATE_CALAPPT_BY_ID,calApptBO.get_apptName(),calApptBO.get_apptDesc());
        return 0;
    }

    @Override
    public int insertCalAppt(CalApptBO calApptBO) {
        return 0;
    }

    @Override
    public int deleteCalAppt(int apptId) {
        return 0;
    }



    private class CalApptMapper implements org.springframework.jdbc.core.RowMapper<CalApptBO> {

        @Override
        public CalApptBO mapRow(ResultSet rs, int i) throws SQLException {

            CalApptBO calApptBO = null;

             calApptBO = new CalApptBO();
             calApptBO.set_apptId(rs.getInt(1));
             calApptBO.set_apptName(rs.getString(2));
             calApptBO.set_apptDesc(rs.getString(3));
             calApptBO.set_apptPrivate(rs.getString(4));
             calApptBO.set_apptDate(rs.getString(5));
             calApptBO.set_apptDateSortable(rs.getString(6));
             calApptBO.set_startTime(rs.getString(7));
             calApptBO.set_duration(rs.getString(8));
             calApptBO.set_evtType(rs.getString(9));
             calApptBO.set_evtStatus(rs.getString(10));
             calApptBO.set_closedFlag(rs.getString(11));
             calApptBO.set_evtImportance(rs.getString(12));
             calApptBO.set_evtCategory(rs.getString(13));
             calApptBO.set_apptUserId(rs.getInt(14));
             calApptBO.set_apptAgenda(rs.getString(15));
             calApptBO.set_apptOutcome(rs.getString(16));
             calApptBO.set_reminderFlag(rs.getString(17));
             calApptBO.set_xferNoteFlag(rs.getString(18));
             calApptBO.set_accessKey(rs.getString(19));
             calApptBO.set_recurrenceType(rs.getString(20));
             calApptBO.set_recurrenceInterval(rs.getInt(21));
             calApptBO.set_recurrenceTimes(rs.getInt(22));
             calApptBO.set_recurrenceDayofWeek(rs.getString(23));
             calApptBO.set_recurrenceDayofMonth(rs.getString(24));
             calApptBO.set_evtAllday(rs.getString(25));
             calApptBO.set_evtAlldayStart(rs.getString(26));
             calApptBO.set_evtAlldayEnd(rs.getString(27));
             calApptBO.set_longStrFieldH(rs.getString(28));
             calApptBO.set_location("LOCATION");
             calApptBO.set_apptEndDuration("EVENT_DURATION");
             calApptBO.set_apptEndTime("END_TIME");
             calApptBO.set_apptEndDate("END_DATE");


            return calApptBO;
        }
    }
}
