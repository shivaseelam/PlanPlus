package org.oz.sppol.bo;

import java.util.Hashtable;

/**
 * Created by siva on 1/2/2017.
 */
public class CalApptBO {


    protected int    _apptId;
    protected String _apptName;
    protected String _apptDesc;
    protected String _apptPrivate = "N";
    protected String _apptDate;
    protected String _startTime;
    protected String _duration;
    /*Bug: 2930   Task: Calendar > Create new appt > appointment includes all Users in view   :010*/
    //protected String _evtType = "APPT";
    protected String _evtType = "";
    protected String _evtStatus;
    protected String _evtImportance;
    protected String _evtCategory;
    protected int    _apptUserId;
    protected String _apptAgenda  = "";
    protected String _apptOutcome = "";
    protected String _apptDateSortable;
    protected String _closedFlag = "N";
    protected String _reminderFlag = "N";  // N means the workflow engine has not send out the reminder
    protected String _xferNoteFlag = "N";
    protected String _accessKey;
    protected String _recurrenceType	= "";
    protected int    _recurrenceInterval	= 0;
    protected int    _recurrenceTimes	= 0;
    protected String _recurrenceDayofWeek;
    protected String _recurrenceDayofMonth;
    protected String _evtAllday = "N";
    protected String _evtAlldayStart = "";
    protected String _evtAlldayEnd = "";
    /*PPOL-1152 Case 90259927 - Calendar to save appointments that start one day and end the next*/
    protected String _evtMultiday = "N";
    protected String _apptEndDate = "";
    protected String _apptEndTime = "";
    protected String _apptEndDuration = "";

    protected String _externalRefkeyGcal = "";

    protected String _longStrFieldH = "";
    protected Hashtable _hashtableParams = new Hashtable();
    protected String _location = "";

    public int get_apptId() {
        return _apptId;
    }

    public void set_apptId(int _apptId) {
        this._apptId = _apptId;
    }

    public String get_apptName() {
        return _apptName;
    }

    public void set_apptName(String _apptName) {
        this._apptName = _apptName;
    }

    public String get_apptDesc() {
        return _apptDesc;
    }

    public void set_apptDesc(String _apptDesc) {
        this._apptDesc = _apptDesc;
    }

    public String get_apptPrivate() {
        return _apptPrivate;
    }

    public void set_apptPrivate(String _apptPrivate) {
        this._apptPrivate = _apptPrivate;
    }

    public String get_apptDate() {
        return _apptDate;
    }

    public void set_apptDate(String _apptDate) {
        this._apptDate = _apptDate;
    }

    public String get_startTime() {
        return _startTime;
    }

    public void set_startTime(String _startTime) {
        this._startTime = _startTime;
    }

    public String get_duration() {
        return _duration;
    }

    public void set_duration(String _duration) {
        this._duration = _duration;
    }

    public String get_evtType() {
        return _evtType;
    }

    public void set_evtType(String _evtType) {
        this._evtType = _evtType;
    }

    public String get_evtStatus() {
        return _evtStatus;
    }

    public void set_evtStatus(String _evtStatus) {
        this._evtStatus = _evtStatus;
    }

    public String get_evtImportance() {
        return _evtImportance;
    }

    public void set_evtImportance(String _evtImportance) {
        this._evtImportance = _evtImportance;
    }

    public String get_evtCategory() {
        return _evtCategory;
    }

    public void set_evtCategory(String _evtCategory) {
        this._evtCategory = _evtCategory;
    }

    public int get_apptUserId() {
        return _apptUserId;
    }

    public void set_apptUserId(int _apptUserId) {
        this._apptUserId = _apptUserId;
    }

    public String get_apptAgenda() {
        return _apptAgenda;
    }

    public void set_apptAgenda(String _apptAgenda) {
        this._apptAgenda = _apptAgenda;
    }

    public String get_apptOutcome() {
        return _apptOutcome;
    }

    public void set_apptOutcome(String _apptOutcome) {
        this._apptOutcome = _apptOutcome;
    }

    public String get_apptDateSortable() {
        return _apptDateSortable;
    }

    public void set_apptDateSortable(String _apptDateSortable) {
        this._apptDateSortable = _apptDateSortable;
    }

    public String get_closedFlag() {
        return _closedFlag;
    }

    public void set_closedFlag(String _closedFlag) {
        this._closedFlag = _closedFlag;
    }

    public String get_reminderFlag() {
        return _reminderFlag;
    }

    public void set_reminderFlag(String _reminderFlag) {
        this._reminderFlag = _reminderFlag;
    }

    public String get_xferNoteFlag() {
        return _xferNoteFlag;
    }

    public void set_xferNoteFlag(String _xferNoteFlag) {
        this._xferNoteFlag = _xferNoteFlag;
    }

    public String get_accessKey() {
        return _accessKey;
    }

    public void set_accessKey(String _accessKey) {
        this._accessKey = _accessKey;
    }

    public String get_recurrenceType() {
        return _recurrenceType;
    }

    public void set_recurrenceType(String _recurrenceType) {
        this._recurrenceType = _recurrenceType;
    }

    public int get_recurrenceInterval() {
        return _recurrenceInterval;
    }

    public void set_recurrenceInterval(int _recurrenceInterval) {
        this._recurrenceInterval = _recurrenceInterval;
    }

    public int get_recurrenceTimes() {
        return _recurrenceTimes;
    }

    public void set_recurrenceTimes(int _recurrenceTimes) {
        this._recurrenceTimes = _recurrenceTimes;
    }

    public String get_recurrenceDayofWeek() {
        return _recurrenceDayofWeek;
    }

    public void set_recurrenceDayofWeek(String _recurrenceDayofWeek) {
        this._recurrenceDayofWeek = _recurrenceDayofWeek;
    }

    public String get_recurrenceDayofMonth() {
        return _recurrenceDayofMonth;
    }

    public void set_recurrenceDayofMonth(String _recurrenceDayofMonth) {
        this._recurrenceDayofMonth = _recurrenceDayofMonth;
    }

    public String get_evtAllday() {
        return _evtAllday;
    }

    public void set_evtAllday(String _evtAllday) {
        this._evtAllday = _evtAllday;
    }

    public String get_evtAlldayStart() {
        return _evtAlldayStart;
    }

    public void set_evtAlldayStart(String _evtAlldayStart) {
        this._evtAlldayStart = _evtAlldayStart;
    }

    public String get_evtAlldayEnd() {
        return _evtAlldayEnd;
    }

    public void set_evtAlldayEnd(String _evtAlldayEnd) {
        this._evtAlldayEnd = _evtAlldayEnd;
    }

    public String get_evtMultiday() {
        return _evtMultiday;
    }

    public void set_evtMultiday(String _evtMultiday) {
        this._evtMultiday = _evtMultiday;
    }

    public String get_apptEndDate() {
        return _apptEndDate;
    }

    public void set_apptEndDate(String _apptEndDate) {
        this._apptEndDate = _apptEndDate;
    }

    public String get_apptEndTime() {
        return _apptEndTime;
    }

    public void set_apptEndTime(String _apptEndTime) {
        this._apptEndTime = _apptEndTime;
    }

    public String get_apptEndDuration() {
        return _apptEndDuration;
    }

    public void set_apptEndDuration(String _apptEndDuration) {
        this._apptEndDuration = _apptEndDuration;
    }

    public String get_externalRefkeyGcal() {
        return _externalRefkeyGcal;
    }

    public void set_externalRefkeyGcal(String _externalRefkeyGcal) {
        this._externalRefkeyGcal = _externalRefkeyGcal;
    }

    public String get_longStrFieldH() {
        return _longStrFieldH;
    }

    public void set_longStrFieldH(String _longStrFieldH) {
        this._longStrFieldH = _longStrFieldH;
    }

    public Hashtable get_hashtableParams() {
        return _hashtableParams;
    }

    public void set_hashtableParams(Hashtable _hashtableParams) {
        this._hashtableParams = _hashtableParams;
    }

    public String get_location() {
        return _location;
    }

    public void set_location(String _location) {
        this._location = _location;
    }
}
