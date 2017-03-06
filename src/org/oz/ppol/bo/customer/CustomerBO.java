package org.oz.ppol.bo.customer;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
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

    public int get_customerId() {
        return _customerId;
    }

    @Autowired
    public void set_customerId(int _customerId) {
        this._customerId = _customerId;
    }

    @Autowired
    public int get_customerNumber() {
        return _customerNumber;
    }

    @Autowired
    public void set_customerNumber(int _customerNumber) {
        this._customerNumber = _customerNumber;
    }

    @Autowired
    public String get_customerType() {
        return _customerType;
    }

    @Autowired
    public void set_customerType(String _customerType) {
        this._customerType = _customerType;
    }

    @Autowired
    public String get_displayName() {
        return _displayName;
    }

    @Autowired
    public void set_displayName(String _displayName) {
        this._displayName = _displayName;
    }

    @Autowired
    public String get_url() {
        return _url;
    }

    @Autowired
    public void set_url(String _url) {
        this._url = _url;
    }

    @Autowired
    public int get_netWorth() {
        return _netWorth;
    }

    @Autowired
    public void set_netWorth(int _netWorth) {
        this._netWorth = _netWorth;
    }

    @Autowired
    public String get_customerCategory() {
        return _customerCategory;
    }

    @Autowired
    public void set_customerCategory(String _customerCategory) {
        this._customerCategory = _customerCategory;
    }

    @Autowired
    public String get_businessLine() {
        return _businessLine;
    }

    @Autowired
    public void set_businessLine(String _businessLine) {
        this._businessLine = _businessLine;
    }

    @Autowired
    public int get_numEmployee() {
        return _numEmployee;
    }

    @Autowired
    public void set_numEmployee(int _numEmployee) {
        this._numEmployee = _numEmployee;
    }

    @Autowired
    public int get_annualRevenue() {
        return _annualRevenue;
    }

    @Autowired
    public void set_annualRevenue(int _annualRevenue) {
        this._annualRevenue = _annualRevenue;
    }

    @Autowired
    public String get_fiscalYearEnd() {
        return _fiscalYearEnd;
    }

    @Autowired
    public void set_fiscalYearEnd(String _fiscalYearEnd) {
        this._fiscalYearEnd = _fiscalYearEnd;
    }

    @Autowired
    public int get_yearEstablished() {
        return _yearEstablished;
    }

    @Autowired
    public void set_yearEstablished(int _yearEstablished) {
        this._yearEstablished = _yearEstablished;
    }

    @Autowired
    public String get_dunsNumber() {
        return _dunsNumber;
    }

    @Autowired
    public void set_dunsNumber(String _dunsNumber) {
        this._dunsNumber = _dunsNumber;
    }

    @Autowired
    public String get_stockTicker() {
        return _stockTicker;
    }

    @Autowired
    public void set_stockTicker(String _stockTicker) {
        this._stockTicker = _stockTicker;
    }

    @Autowired
    public String get_sicCode() {
        return _sicCode;
    }

    @Autowired
    public void set_sicCode(String _sicCode) {
        this._sicCode = _sicCode;
    }

    @Autowired
    public String get_firstName() {
        return _firstName;
    }

    @Autowired
    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    @Autowired
    public String get_lastName() {
        return _lastName;
    }

    @Autowired
    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    @Autowired
    public String get_middleName() {
        return _middleName;
    }

    @Autowired
    public void set_middleName(String _middleName) {
        this._middleName = _middleName;
    }

    @Autowired
    public String get_sex() {
        return _sex;
    }

    @Autowired
    public void set_sex(String _sex) {
        this._sex = _sex;
    }

    @Autowired
    public String get_birthDate() {
        return _birthDate;
    }

    @Autowired
    public void set_birthDate(String _birthDate) {
        this._birthDate = _birthDate;
    }

    @Autowired
    public String get_title() {
        return _title;
    }

    @Autowired
    public void set_title(String _title) {
        this._title = _title;
    }

    @Autowired
    public String get_jobTitle() {
        return _jobTitle;
    }

    @Autowired
    public void set_jobTitle(String _jobTitle) {
        this._jobTitle = _jobTitle;
    }

    @Autowired
    public String get_department() {
        return _department;
    }

    @Autowired
    public void set_department(String _department) {
        this._department = _department;
    }

    @Autowired
    public String get_responsibility() {
        return _responsibility;
    }

    @Autowired
    public void set_responsibility(String _responsibility) {
        this._responsibility = _responsibility;
    }

    @Autowired
    public String get_decisionMaker() {
        return _decisionMaker;
    }

    @Autowired
    public void set_decisionMaker(String _decisionMaker) {
        this._decisionMaker = _decisionMaker;
    }

    @Autowired
    public String get_leadSource() {
        return _leadSource;
    }

    @Autowired
    public void set_leadSource(String _leadSource) {
        this._leadSource = _leadSource;
    }

    @Autowired
    public String get_leadSourceDetail() {
        return _leadSourceDetail;
    }

    @Autowired
    public void set_leadSourceDetail(String _leadSourceDetail) {
        this._leadSourceDetail = _leadSourceDetail;
    }

    @Autowired
    public String get_arFlag() {
        return _arFlag;
    }

    @Autowired
    public void set_arFlag(String _arFlag) {
        this._arFlag = _arFlag;
    }

    @Autowired
    public int get_arBillingAddrId() {
        return _arBillingAddrId;
    }

    @Autowired
    public void set_arBillingAddrId(int _arBillingAddrId) {
        this._arBillingAddrId = _arBillingAddrId;
    }

    @Autowired
    public int get_portraitFileId() {
        return _portraitFileId;
    }

    @Autowired
    public void set_portraitFileId(int _portraitFileId) {
        this._portraitFileId = _portraitFileId;
    }

    @Autowired
    public int get_leadId() {
        return _leadId;
    }

    @Autowired
    public void set_leadId(int _leadId) {
        this._leadId = _leadId;
    }

    public String get_impSessionName() {
        return _impSessionName;
    }

    public void set_impSessionName(String _impSessionName) {
        this._impSessionName = _impSessionName;
    }

    public String get_donotMail() {
        return _donotMail;
    }

    public void set_donotMail(String _donotMail) {
        this._donotMail = _donotMail;
    }

    public String get_donotCall() {
        return _donotCall;
    }

    public void set_donotCall(String _donotCall) {
        this._donotCall = _donotCall;
    }

    public String get_relCompanyName() {
        return _relCompanyName;
    }

    public void set_relCompanyName(String _relCompanyName) {
        this._relCompanyName = _relCompanyName;
    }

    public int get_relCompanyId() {
        return _relCompanyId;
    }

    public void set_relCompanyId(int _relCompanyId) {
        this._relCompanyId = _relCompanyId;
    }

    public String get_externalRefkey() {
        return _externalRefkey;
    }


    @Autowired
    public void set_externalRefkey(String _externalRefkey) {
        this._externalRefkey = _externalRefkey;
    }

    @Autowired
    public String get_lastCallDate() {
        return _lastCallDate;
    }

    @Autowired
    public void set_lastCallDate(String _lastCallDate) {
        this._lastCallDate = _lastCallDate;
    }

    @Autowired
    public String get_lastEmailDate() {
        return _lastEmailDate;
    }

    @Autowired
    public void set_lastEmailDate(String _lastEmailDate) {
        this._lastEmailDate = _lastEmailDate;
    }

    @Autowired
    public int get_processStepTxId() {
        return _processStepTxId;
    }

    @Autowired
    public void set_processStepTxId(int _processStepTxId) {
        this._processStepTxId = _processStepTxId;
    }

    @Autowired
    public String get_processStepDue() {
        return _processStepDue;
    }

    @Autowired
    public void set_processStepDue(String _processStepDue) {
        this._processStepDue = _processStepDue;
    }

    @Autowired
    public int get_private() {
        return _private;
    }

    @Autowired
    public void set_private(int _private) {
        this._private = _private;
    }

    @Autowired
    public int get_hasTags() {
        return _hasTags;
    }

    @Autowired
    public void set_hasTags(int _hasTags) {
        this._hasTags = _hasTags;
    }

    @Autowired
    public String get_tags() {
        return _tags;
    }

    @Autowired
    public void set_tags(String _tags) {
        this._tags = _tags;
    }

    @Autowired
    public String get_nextCallDate() {
        return _nextCallDate;
    }

    @Autowired
    public void set_nextCallDate(String _nextCallDate) {
        this._nextCallDate = _nextCallDate;
    }

    @Autowired
    public String get_nextCallTime() {
        return _nextCallTime;
    }

    @Autowired
    public void set_nextCallTime(String _nextCallTime) {
        this._nextCallTime = _nextCallTime;
    }

    @Autowired
    public String get_nextCallGoal() {
        return _nextCallGoal;
    }

    @Autowired
    public void set_nextCallGoal(String _nextCallGoal) {
        this._nextCallGoal = _nextCallGoal;
    }

    @Autowired
    public String get_nextCallNote() {
        return _nextCallNote;
    }

    @Autowired
    public void set_nextCallNote(String _nextCallNote) {
        this._nextCallNote = _nextCallNote;
    }

    @Autowired
    public String get_externalPartnerId() {
        return _externalPartnerId;
    }

    @Autowired
    public void set_externalPartnerId(String _externalPartnerId) {
        this._externalPartnerId = _externalPartnerId;
    }

    @Autowired
    public boolean is_bSkipGcalSync() {
        return _bSkipGcalSync;
    }

    @Autowired
    public void set_bSkipGcalSync(boolean _bSkipGcalSync) {
        this._bSkipGcalSync = _bSkipGcalSync;
    }

    @Autowired
    public int get_nextCallUserid() {
        return _nextCallUserid;
    }

    @Autowired
    public void set_nextCallUserid(int _nextCallUserid) {
        this._nextCallUserid = _nextCallUserid;
    }

    @Autowired
    public String get_companyName() {
        return _companyName;
    }

    @Autowired
    public void set_companyName(String _companyName) {
        this._companyName = _companyName;
    }

    @Autowired
    public String get_accessKey() {
        return _accessKey;
    }

    @Autowired
    public void set_accessKey(String _accessKey) {
        this._accessKey = _accessKey;
    }

    @Autowired
    public Hashtable get_hashtableParams() {
        return _hashtableParams;
    }

    @Autowired
    public void set_hashtableParams(Hashtable _hashtableParams) {
        this._hashtableParams = _hashtableParams;
    }

    @Autowired
    public String get_longStrFieldH() {
        return _longStrFieldH;
    }

    @Autowired
    public void set_longStrFieldH(String _longStrFieldH) {
        this._longStrFieldH = _longStrFieldH;
    }

    @Autowired
    public String get_googleContactId() {
        return _googleContactId;
    }

    @Autowired
    public void set_googleContactId(String _googleContactId) {
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
}
