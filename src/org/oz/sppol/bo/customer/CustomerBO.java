package org.oz.sppol.bo.customer;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by shiva9 on 2/7/2017.
 */
public class CustomerBO  {



    public CustomerBO() {

    }

    public CustomerBO(int _customerNumber, String _customerType, String _displayName, String _url, int _netWorth, String _customerCategory, String _businessLine, int _numEmployee, int _annualRevenue, String _fiscalYearEnd, int _yearEstablished, String _dunsNumber, String _stockTicker, String _sicCode, String _firstName, String _lastName, String _middleName, String _sex, String _birthDate, String _title, String _jobTitle, String _department, String _responsibility, String _decisionMaker, String _leadSource, String _leadSourceDetail, String _arFlag, int _arBillingAddrId, int _portraitFileId, int _leadId, String _impSessionName, String _donotMail, String _donotCall, String _relCompanyName, int _relCompanyId, String _externalRefkey, String _lastCallDate, String _lastEmailDate, int _processStepTxId, String _processStepDue, int _private, int _hasTags, String _tags, String _nextCallDate, String _nextCallTime, String _nextCallGoal, String _nextCallNote, String _externalPartnerId, boolean _bSkipGcalSync, int _nextCallUserid, String _companyName, String _accessKey, Hashtable _hashtableParams, String _longStrFieldH, String _googleContactId) {
        this._customerNumber = _customerNumber;
        this._customerType = _customerType;
        this._displayName = _displayName;
        this._url = _url;
        this._netWorth = _netWorth;
        this._customerCategory = _customerCategory;
        this._businessLine = _businessLine;
        this._numEmployee = _numEmployee;
        this._annualRevenue = _annualRevenue;
        this._fiscalYearEnd = _fiscalYearEnd;
        this._yearEstablished = _yearEstablished;
        this._dunsNumber = _dunsNumber;
        this._stockTicker = _stockTicker;
        this._sicCode = _sicCode;
        this._firstName = _firstName;
        this._lastName = _lastName;
        this._middleName = _middleName;
        this._sex = _sex;
        this._birthDate = _birthDate;
        this._title = _title;
        this._jobTitle = _jobTitle;
        this._department = _department;
        this._responsibility = _responsibility;
        this._decisionMaker = _decisionMaker;
        this._leadSource = _leadSource;
        this._leadSourceDetail = _leadSourceDetail;
        this._arFlag = _arFlag;
        this._arBillingAddrId = _arBillingAddrId;
        this._portraitFileId = _portraitFileId;
        this._leadId = _leadId;
        this._impSessionName = _impSessionName;
        this._donotMail = _donotMail;
        this._donotCall = _donotCall;
        this._relCompanyName = _relCompanyName;
        this._relCompanyId = _relCompanyId;
        this._externalRefkey = _externalRefkey;
        this._lastCallDate = _lastCallDate;
        this._lastEmailDate = _lastEmailDate;
        this._processStepTxId = _processStepTxId;
        this._processStepDue = _processStepDue;
        this._private = _private;
        this._hasTags = _hasTags;
        this._tags = _tags;
        this._nextCallDate = _nextCallDate;
        this._nextCallTime = _nextCallTime;
        this._nextCallGoal = _nextCallGoal;
        this._nextCallNote = _nextCallNote;
        this._externalPartnerId = _externalPartnerId;
        this._bSkipGcalSync = _bSkipGcalSync;
        this._nextCallUserid = _nextCallUserid;
        this._companyName = _companyName;
        this._accessKey = _accessKey;
        this._hashtableParams = _hashtableParams;
        this._longStrFieldH = _longStrFieldH;
        this._googleContactId = _googleContactId;
    }

    @Autowired
    private int    _customerId;
    private int    _customerNumber;
    private String _customerType;
    private String _displayName = "";
    private String _url;
    private int    _netWorth;
    private String _customerCategory;
    private String _businessLine;
    private int    _numEmployee;
    private int    _annualRevenue;
    private String _fiscalYearEnd;
    private int    _yearEstablished;
    private String _dunsNumber;
    private String _stockTicker;
    private String _sicCode;
    private String _firstName;
    private String _lastName;
    private String _middleName;
    private String _sex;
    private String _birthDate;
    private String _title;
    private String _jobTitle;
    private String _department;
    private String _responsibility;
    private String _decisionMaker;
    private String _leadSource;
    private String _leadSourceDetail;
    private String _arFlag = "N";
    private int _arBillingAddrId = 0;
    private int _portraitFileId = 0;
    private int _leadId = 0;
    private String _impSessionName = "";
    private String _donotMail = "N";   // "N" means can mail. "Y" means do not mail.
    private String _donotCall = "N";   // "N" means can call. "Y" means do not call.
    private String _relCompanyName = "";
    private int    _relCompanyId = 0;
    private String _externalRefkey = "";
    private String _lastCallDate = "";
    private String _lastEmailDate = "";
    private int    _processStepTxId   = -1;
    private String _processStepDue;
    private int    _private   = 0;
    private int    _hasTags   = 0;
    private String _tags = "";
    private String _nextCallDate = "";
    private String _nextCallTime = "";
    private String _nextCallGoal = "";
    private String _nextCallNote = "";
    private String _externalPartnerId = "";
    private boolean _bSkipGcalSync = false;
    private int    _nextCallUserid = 0;
    private String _companyName = "";   //PPOL-1083

    private String _accessKey = "";
    /*Bug: 2896   Task: From EBSuite > Contact/Oppty Field > add Widget:  File repository*/
    private Hashtable _hashtableParams = new Hashtable();
    private String _longStrFieldH = "";
    //Project ID:13189  Google Contact- NEEDs to be a 2-way sync, not just import  : N2G-010
    private String _googleContactId = "";

    private Date _lastUpdateDate  = null;

    /*public static final SimpleDateFormat iso8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    protected String _ISOLastUpdateDate = null;

    public void  setLastUpdateDate(Date   val)        { _lastUpdateDate = val; _ISOLastUpdateDate = iso8601.format(val);}

    public String getLastUpdateDateStr() { if (_lastUpdateDate!=null) return sdf.format(_lastUpdateDate); else return ""; };
*/
    public int getcustomerId() {
        return _customerId;
    }

    @Autowired
    public void setcustomerId(int _customerId) {
        this._customerId = _customerId;
    }

    @Autowired
    public int getcustomerNumber() {
        return _customerNumber;
    }

    @Autowired
    public void setcustomerNumber(int _customerNumber) {
        this._customerNumber = _customerNumber;
    }

    @Autowired
    public String getcustomerType() {
        return _customerType;
    }

    @Autowired
    public void setcustomerType(String _customerType) {
        this._customerType = _customerType;
    }

    @Autowired
    public String getdisplayName() {
        return _displayName;
    }

    @Autowired
    public void setdisplayName(String _displayName) {
        this._displayName = _displayName;
    }

    @Autowired
    public String geturl() {
        return _url;
    }

    @Autowired
    public void seturl(String _url) {
        this._url = _url;
    }

    @Autowired
    public int getnetWorth() {
        return _netWorth;
    }

    @Autowired
    public void setnetWorth(int _netWorth) {
        this._netWorth = _netWorth;
    }

    @Autowired
    public String getcustomerCategory() {
        return _customerCategory;
    }

    @Autowired
    public void setcustomerCategory(String _customerCategory) {
        this._customerCategory = _customerCategory;
    }

    @Autowired
    public String getbusinessLine() {
        return _businessLine;
    }

    @Autowired
    public void setbusinessLine(String _businessLine) {
        this._businessLine = _businessLine;
    }

    @Autowired
    public int getnumEmployee() {
        return _numEmployee;
    }

    @Autowired
    public void setnumEmployee(int _numEmployee) {
        this._numEmployee = _numEmployee;
    }

    @Autowired
    public int getannualRevenue() {
        return _annualRevenue;
    }

    @Autowired
    public void setannualRevenue(int _annualRevenue) {
        this._annualRevenue = _annualRevenue;
    }

    @Autowired
    public String getfiscalYearEnd() {
        return _fiscalYearEnd;
    }

    @Autowired
    public void setfiscalYearEnd(String _fiscalYearEnd) {
        this._fiscalYearEnd = _fiscalYearEnd;
    }

    @Autowired
    public int getyearEstablished() {
        return _yearEstablished;
    }

    @Autowired
    public void setyearEstablished(int _yearEstablished) {
        this._yearEstablished = _yearEstablished;
    }

    @Autowired
    public String getdunsNumber() {
        return _dunsNumber;
    }

    @Autowired
    public void setdunsNumber(String _dunsNumber) {
        this._dunsNumber = _dunsNumber;
    }

    @Autowired
    public String getstockTicker() {
        return _stockTicker;
    }

    @Autowired
    public void setstockTicker(String _stockTicker) {
        this._stockTicker = _stockTicker;
    }

    @Autowired
    public String getsicCode() {
        return _sicCode;
    }

    @Autowired
    public void setsicCode(String _sicCode) {
        this._sicCode = _sicCode;
    }

    @Autowired
    public String getfirstName() {
        return _firstName;
    }

    @Autowired
    public void setfirstName(String _firstName) {
        this._firstName = _firstName;
    }

    @Autowired
    public String getlastName() {
        return _lastName;
    }

    @Autowired
    public void setlastName(String _lastName) {
        this._lastName = _lastName;
    }

    @Autowired
    public String getmiddleName() {
        return _middleName;
    }

    @Autowired
    public void setmiddleName(String _middleName) {
        this._middleName = _middleName;
    }

    @Autowired
    public String getsex() {
        return _sex;
    }

    @Autowired
    public void setsex(String _sex) {
        this._sex = _sex;
    }

    @Autowired
    public String getbirthDate() {
        return _birthDate;
    }

    @Autowired
    public void setbirthDate(String _birthDate) {
        this._birthDate = _birthDate;
    }

    @Autowired
    public String gettitle() {
        return _title;
    }

    @Autowired
    public void settitle(String _title) {
        this._title = _title;
    }

    @Autowired
    public String getjobTitle() {
        return _jobTitle;
    }

    @Autowired
    public void setjobTitle(String _jobTitle) {
        this._jobTitle = _jobTitle;
    }

    @Autowired
    public String getdepartment() {
        return _department;
    }

    @Autowired
    public void setdepartment(String _department) {
        this._department = _department;
    }

    @Autowired
    public String getresponsibility() {
        return _responsibility;
    }

    @Autowired
    public void setresponsibility(String _responsibility) {
        this._responsibility = _responsibility;
    }

    @Autowired
    public String getdecisionMaker() {
        return _decisionMaker;
    }

    @Autowired
    public void setdecisionMaker(String _decisionMaker) {
        this._decisionMaker = _decisionMaker;
    }

    @Autowired
    public String getleadSource() {
        return _leadSource;
    }

    @Autowired
    public void setleadSource(String _leadSource) {
        this._leadSource = _leadSource;
    }

    @Autowired
    public String getleadSourceDetail() {
        return _leadSourceDetail;
    }

    @Autowired
    public void setleadSourceDetail(String _leadSourceDetail) {
        this._leadSourceDetail = _leadSourceDetail;
    }

    @Autowired
    public String getarFlag() {
        return _arFlag;
    }

    @Autowired
    public void setarFlag(String _arFlag) {
        this._arFlag = _arFlag;
    }

    @Autowired
    public int getarBillingAddrId() {
        return _arBillingAddrId;
    }

    @Autowired
    public void setarBillingAddrId(int _arBillingAddrId) {
        this._arBillingAddrId = _arBillingAddrId;
    }

    @Autowired
    public int getportraitFileId() {
        return _portraitFileId;
    }

    @Autowired
    public void setportraitFileId(int _portraitFileId) {
        this._portraitFileId = _portraitFileId;
    }

    @Autowired
    public int getleadId() {
        return _leadId;
    }

    @Autowired
    public void setleadId(int _leadId) {
        this._leadId = _leadId;
    }

    public String getimpSessionName() {
        return _impSessionName;
    }

    public void setimpSessionName(String _impSessionName) {
        this._impSessionName = _impSessionName;
    }

    public String getdonotMail() {
        return _donotMail;
    }

    public void setdonotMail(String _donotMail) {
        this._donotMail = _donotMail;
    }

    public String getdonotCall() {
        return _donotCall;
    }

    public void setdonotCall(String _donotCall) {
        this._donotCall = _donotCall;
    }

    public String getrelCompanyName() {
        return _relCompanyName;
    }

    public void setrelCompanyName(String _relCompanyName) {
        this._relCompanyName = _relCompanyName;
    }

    public int getrelCompanyId() {
        return _relCompanyId;
    }

    public void setrelCompanyId(int _relCompanyId) {
        this._relCompanyId = _relCompanyId;
    }

    public String getexternalRefkey() {
        return _externalRefkey;
    }


    @Autowired
    public void setexternalRefkey(String _externalRefkey) {
        this._externalRefkey = _externalRefkey;
    }

    @Autowired
    public String getlastCallDate() {
        return _lastCallDate;
    }

    @Autowired
    public void setlastCallDate(String _lastCallDate) {
        this._lastCallDate = _lastCallDate;
    }

    @Autowired
    public String getlastEmailDate() {
        return _lastEmailDate;
    }

    @Autowired
    public void setlastEmailDate(String _lastEmailDate) {
        this._lastEmailDate = _lastEmailDate;
    }

    @Autowired
    public int getprocessStepTxId() {
        return _processStepTxId;
    }

    @Autowired
    public void setprocessStepTxId(int _processStepTxId) {
        this._processStepTxId = _processStepTxId;
    }

    @Autowired
    public String getprocessStepDue() {
        return _processStepDue;
    }

    @Autowired
    public void setprocessStepDue(String _processStepDue) {
        this._processStepDue = _processStepDue;
    }

    @Autowired
    public int getprivate() {
        return _private;
    }

    @Autowired
    public void setprivate(int _private) {
        this._private = _private;
    }

    @Autowired
    public int gethasTags() {
        return _hasTags;
    }

    @Autowired
    public void sethasTags(int _hasTags) {
        this._hasTags = _hasTags;
    }

    @Autowired
    public String gettags() {
        return _tags;
    }

    @Autowired
    public void settags(String _tags) {
        this._tags = _tags;
    }

    @Autowired
    public String getnextCallDate() {
        return _nextCallDate;
    }

    @Autowired
    public void setnextCallDate(String _nextCallDate) {
        this._nextCallDate = _nextCallDate;
    }

    @Autowired
    public String getnextCallTime() {
        return _nextCallTime;
    }

    @Autowired
    public void setnextCallTime(String _nextCallTime) {
        this._nextCallTime = _nextCallTime;
    }

    @Autowired
    public String getnextCallGoal() {
        return _nextCallGoal;
    }

    @Autowired
    public void setnextCallGoal(String _nextCallGoal) {
        this._nextCallGoal = _nextCallGoal;
    }

    @Autowired
    public String getnextCallNote() {
        return _nextCallNote;
    }

    @Autowired
    public void setnextCallNote(String _nextCallNote) {
        this._nextCallNote = _nextCallNote;
    }

    @Autowired
    public String getexternalPartnerId() {
        return _externalPartnerId;
    }

    @Autowired
    public void setexternalPartnerId(String _externalPartnerId) {
        this._externalPartnerId = _externalPartnerId;
    }

    @Autowired
    public boolean is_bSkipGcalSync() {
        return _bSkipGcalSync;
    }

    @Autowired
    public void setbSkipGcalSync(boolean _bSkipGcalSync) {
        this._bSkipGcalSync = _bSkipGcalSync;
    }

    @Autowired
    public int getnextCallUserid() {
        return _nextCallUserid;
    }

    @Autowired
    public void setnextCallUserid(int _nextCallUserid) {
        this._nextCallUserid = _nextCallUserid;
    }

    @Autowired
    public String getcompanyName() {
        return _companyName;
    }

    @Autowired
    public void setcompanyName(String _companyName) {
        this._companyName = _companyName;
    }

    @Autowired
    public String getaccessKey() {
        return _accessKey;
    }

    @Autowired
    public void setaccessKey(String _accessKey) {
        this._accessKey = _accessKey;
    }

    @Autowired
    public Hashtable gethashtableParams() {
        return _hashtableParams;
    }

    @Autowired
    public void sethashtableParams(Hashtable _hashtableParams) {
        this._hashtableParams = _hashtableParams;
    }

    @Autowired
    public String getlongStrFieldH() {
        return _longStrFieldH;
    }

    @Autowired
    public void setlongStrFieldH(String _longStrFieldH) {
        this._longStrFieldH = _longStrFieldH;
    }

    @Autowired
    public String getgoogleContactId() {
        return _googleContactId;
    }

    @Autowired
    public void setgoogleContactId(String _googleContactId) {
        this._googleContactId = _googleContactId;
    }
    @Override
    public String toString() {
        return "CustomerBO{" +
                "_customerId=" + _customerId +
                ", _customerNumber=" + _customerNumber +
                ", _customerType='" + _customerType + '\'' +
                ", _displayName='" + _displayName + '\'' +
                ", _url='" + _url + '\'' +
                ", _netWorth=" + _netWorth +
                ", _customerCategory='" + _customerCategory + '\'' +
                ", _businessLine='" + _businessLine + '\'' +
                ", _numEmployee=" + _numEmployee +
                ", _annualRevenue=" + _annualRevenue +
                ", _fiscalYearEnd='" + _fiscalYearEnd + '\'' +
                ", _yearEstablished=" + _yearEstablished +
                ", _dunsNumber='" + _dunsNumber + '\'' +
                ", _stockTicker='" + _stockTicker + '\'' +
                ", _sicCode='" + _sicCode + '\'' +
                ", _firstName='" + _firstName + '\'' +
                ", _lastName='" + _lastName + '\'' +
                ", _middleName='" + _middleName + '\'' +
                ", _sex='" + _sex + '\'' +
                ", _birthDate='" + _birthDate + '\'' +
                ", _title='" + _title + '\'' +
                ", _jobTitle='" + _jobTitle + '\'' +
                ", _department='" + _department + '\'' +
                ", _responsibility='" + _responsibility + '\'' +
                ", _decisionMaker='" + _decisionMaker + '\'' +
                ", _leadSource='" + _leadSource + '\'' +
                ", _leadSourceDetail='" + _leadSourceDetail + '\'' +
                ", _arFlag='" + _arFlag + '\'' +
                ", _arBillingAddrId=" + _arBillingAddrId +
                ", _portraitFileId=" + _portraitFileId +
                ", _leadId=" + _leadId +
                ", _impSessionName='" + _impSessionName + '\'' +
                ", _donotMail='" + _donotMail + '\'' +
                ", _donotCall='" + _donotCall + '\'' +
                ", _relCompanyName='" + _relCompanyName + '\'' +
                ", _relCompanyId=" + _relCompanyId +
                ", _externalRefkey='" + _externalRefkey + '\'' +
                ", _lastCallDate='" + _lastCallDate + '\'' +
                ", _lastEmailDate='" + _lastEmailDate + '\'' +
                ", _processStepTxId=" + _processStepTxId +
                ", _processStepDue='" + _processStepDue + '\'' +
                ", _private=" + _private +
                ", _hasTags=" + _hasTags +
                ", _tags='" + _tags + '\'' +
                ", _nextCallDate='" + _nextCallDate + '\'' +
                ", _nextCallTime='" + _nextCallTime + '\'' +
                ", _nextCallGoal='" + _nextCallGoal + '\'' +
                ", _nextCallNote='" + _nextCallNote + '\'' +
                ", _externalPartnerId='" + _externalPartnerId + '\'' +
                ", _bSkipGcalSync=" + _bSkipGcalSync +
                ", _nextCallUserid=" + _nextCallUserid +
                ", _companyName='" + _companyName + '\'' +
                ", _accessKey='" + _accessKey + '\'' +
                ", _hashtableParams=" + _hashtableParams +
                ", _longStrFieldH='" + _longStrFieldH + '\'' +
                ", _googleContactId='" + _googleContactId + '\'' +
                '}';
    }

    public Date getlastUpdateDate() {
        return _lastUpdateDate;
    }

    public void setlastUpdateDate(Date _lastUpdateDate) {
        this._lastUpdateDate = _lastUpdateDate;
    }
}
