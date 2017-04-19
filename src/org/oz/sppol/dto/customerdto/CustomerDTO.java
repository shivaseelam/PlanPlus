package org.oz.sppol.dto.customerdto;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * Created by shiva9 on 2/7/2017.
 */
public class CustomerDTO  implements Serializable{

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


    public int getcustomerId() {
        return _customerId;
    }

    public void setcustomerId(int _customerId) {
        this._customerId = _customerId;
    }

    public int getcustomerNumber() {
        return _customerNumber;
    }

    public void setcustomerNumber(int _customerNumber) {
        this._customerNumber = _customerNumber;
    }

    public String getcustomerType() {
        return _customerType;
    }

    public void setcustomerType(String _customerType) {
        this._customerType = _customerType;
    }

    public String getdisplayName() {
        return _displayName;
    }

    public void setdisplayName(String _displayName) {
        this._displayName = _displayName;
    }

    public String geturl() {
        return _url;
    }

    public void seturl(String _url) {
        this._url = _url;
    }

    public int getnetWorth() {
        return _netWorth;
    }

    public void setnetWorth(int _netWorth) {
        this._netWorth = _netWorth;
    }

    public String getcustomerCategory() {
        return _customerCategory;
    }

    public void setcustomerCategory(String _customerCategory) {
        this._customerCategory = _customerCategory;
    }

    public String getbusinessLine() {
        return _businessLine;
    }

    public void setbusinessLine(String _businessLine) {
        this._businessLine = _businessLine;
    }

    public int getnumEmployee() {
        return _numEmployee;
    }

    public void setnumEmployee(int _numEmployee) {
        this._numEmployee = _numEmployee;
    }

    public int getannualRevenue() {
        return _annualRevenue;
    }

    public void setannualRevenue(int _annualRevenue) {
        this._annualRevenue = _annualRevenue;
    }

    public String getfiscalYearEnd() {
        return _fiscalYearEnd;
    }

    public void setfiscalYearEnd(String _fiscalYearEnd) {
        this._fiscalYearEnd = _fiscalYearEnd;
    }

    public int getyearEstablished() {
        return _yearEstablished;
    }

    public void setyearEstablished(int _yearEstablished) {
        this._yearEstablished = _yearEstablished;
    }

    public String getdunsNumber() {
        return _dunsNumber;
    }

    public void setdunsNumber(String _dunsNumber) {
        this._dunsNumber = _dunsNumber;
    }

    public String getstockTicker() {
        return _stockTicker;
    }

    public void setstockTicker(String _stockTicker) {
        this._stockTicker = _stockTicker;
    }

    public String getsicCode() {
        return _sicCode;
    }

    public void setsicCode(String _sicCode) {
        this._sicCode = _sicCode;
    }

    public String getfirstName() {
        return _firstName;
    }

    public void setfirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getlastName() {
        return _lastName;
    }

    public void setlastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String getmiddleName() {
        return _middleName;
    }

    public void setmiddleName(String _middleName) {
        this._middleName = _middleName;
    }

    public String getsex() {
        return _sex;
    }

    public void setsex(String _sex) {
        this._sex = _sex;
    }

    public String getbirthDate() {
        return _birthDate;
    }

    public void setbirthDate(String _birthDate) {
        this._birthDate = _birthDate;
    }

    public String gettitle() {
        return _title;
    }

    public void settitle(String _title) {
        this._title = _title;
    }

    public String getjobTitle() {
        return _jobTitle;
    }

    public void setjobTitle(String _jobTitle) {
        this._jobTitle = _jobTitle;
    }

    public String getdepartment() {
        return _department;
    }

    public void setdepartment(String _department) {
        this._department = _department;
    }

    public String getresponsibility() {
        return _responsibility;
    }

    public void setresponsibility(String _responsibility) {
        this._responsibility = _responsibility;
    }

    public String getdecisionMaker() {
        return _decisionMaker;
    }

    public void setdecisionMaker(String _decisionMaker) {
        this._decisionMaker = _decisionMaker;
    }

    public String getleadSource() {
        return _leadSource;
    }

    public void setleadSource(String _leadSource) {
        this._leadSource = _leadSource;
    }

    public String getleadSourceDetail() {
        return _leadSourceDetail;
    }

    public void setleadSourceDetail(String _leadSourceDetail) {
        this._leadSourceDetail = _leadSourceDetail;
    }

    public String getarFlag() {
        return _arFlag;
    }

    public void setarFlag(String _arFlag) {
        this._arFlag = _arFlag;
    }

    public int getarBillingAddrId() {
        return _arBillingAddrId;
    }

    public void setarBillingAddrId(int _arBillingAddrId) {
        this._arBillingAddrId = _arBillingAddrId;
    }

    public int getportraitFileId() {
        return _portraitFileId;
    }

    public void setportraitFileId(int _portraitFileId) {
        this._portraitFileId = _portraitFileId;
    }

    public int getleadId() {
        return _leadId;
    }

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

    public void setexternalRefkey(String _externalRefkey) {
        this._externalRefkey = _externalRefkey;
    }

    public String getlastCallDate() {
        return _lastCallDate;
    }

    public void setlastCallDate(String _lastCallDate) {
        this._lastCallDate = _lastCallDate;
    }

    public String getlastEmailDate() {
        return _lastEmailDate;
    }

    public void setlastEmailDate(String _lastEmailDate) {
        this._lastEmailDate = _lastEmailDate;
    }

    public int getprocessStepTxId() {
        return _processStepTxId;
    }

    public void setprocessStepTxId(int _processStepTxId) {
        this._processStepTxId = _processStepTxId;
    }

    public String getprocessStepDue() {
        return _processStepDue;
    }

    public void setprocessStepDue(String _processStepDue) {
        this._processStepDue = _processStepDue;
    }

    public int getprivate() {
        return _private;
    }

    public void setprivate(int _private) {
        this._private = _private;
    }

    public int gethasTags() {
        return _hasTags;
    }

    public void sethasTags(int _hasTags) {
        this._hasTags = _hasTags;
    }

    public String gettags() {
        return _tags;
    }

    public void settags(String _tags) {
        this._tags = _tags;
    }

    public String getnextCallDate() {
        return _nextCallDate;
    }

    public void setnextCallDate(String _nextCallDate) {
        this._nextCallDate = _nextCallDate;
    }

    public String getnextCallTime() {
        return _nextCallTime;
    }

    public void setnextCallTime(String _nextCallTime) {
        this._nextCallTime = _nextCallTime;
    }

    public String getnextCallGoal() {
        return _nextCallGoal;
    }

    public void setnextCallGoal(String _nextCallGoal) {
        this._nextCallGoal = _nextCallGoal;
    }

    public String getnextCallNote() {
        return _nextCallNote;
    }

    public void setnextCallNote(String _nextCallNote) {
        this._nextCallNote = _nextCallNote;
    }

    public String getexternalPartnerId() {
        return _externalPartnerId;
    }

    public void setexternalPartnerId(String _externalPartnerId) {
        this._externalPartnerId = _externalPartnerId;
    }

    public boolean isbSkipGcalSync() {
        return _bSkipGcalSync;
    }

    public void setbSkipGcalSync(boolean _bSkipGcalSync) {
        this._bSkipGcalSync = _bSkipGcalSync;
    }

    public int getnextCallUserid() {
        return _nextCallUserid;
    }

    public void setnextCallUserid(int _nextCallUserid) {
        this._nextCallUserid = _nextCallUserid;
    }

    public String getcompanyName() {
        return _companyName;
    }

    public void setcompanyName(String _companyName) {
        this._companyName = _companyName;
    }

    public String getaccessKey() {
        return _accessKey;
    }

    public void setaccessKey(String _accessKey) {
        this._accessKey = _accessKey;
    }

    public Hashtable get_hashtableParams() {
        return _hashtableParams;
    }

    public void sethashtableParams(Hashtable _hashtableParams) {
        this._hashtableParams = _hashtableParams;
    }

    public String getlongStrFieldH() {
        return _longStrFieldH;
    }

    public void setlongStrFieldH(String _longStrFieldH) {
        this._longStrFieldH = _longStrFieldH;
    }

    public String getgoogleContactId() {
        return _googleContactId;
    }

    public void setgoogleContactId(String _googleContactId) {
        this._googleContactId = _googleContactId;
    }
}
