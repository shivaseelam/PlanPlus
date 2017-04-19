package org.oz.ppol.vo.customervo;

import java.util.Hashtable;

/**
 * Created by shiva9 on 2/7/2017.
 */
public class CustomerVO {

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

    public void set_customerId(int _customerId) {
        this._customerId = _customerId;
    }

    public int get_customerNumber() {
        return _customerNumber;
    }

    public void set_customerNumber(int _customerNumber) {
        this._customerNumber = _customerNumber;
    }

    public String get_customerType() {
        return _customerType;
    }

    public void set_customerType(String _customerType) {
        this._customerType = _customerType;
    }

    public String get_displayName() {
        return _displayName;
    }

    public void set_displayName(String _displayName) {
        this._displayName = _displayName;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }

    public int get_netWorth() {
        return _netWorth;
    }

    public void set_netWorth(int _netWorth) {
        this._netWorth = _netWorth;
    }

    public String get_customerCategory() {
        return _customerCategory;
    }

    public void set_customerCategory(String _customerCategory) {
        this._customerCategory = _customerCategory;
    }

    public String get_businessLine() {
        return _businessLine;
    }

    public void set_businessLine(String _businessLine) {
        this._businessLine = _businessLine;
    }

    public int get_numEmployee() {
        return _numEmployee;
    }

    public void set_numEmployee(int _numEmployee) {
        this._numEmployee = _numEmployee;
    }

    public int get_annualRevenue() {
        return _annualRevenue;
    }

    public void set_annualRevenue(int _annualRevenue) {
        this._annualRevenue = _annualRevenue;
    }

    public String get_fiscalYearEnd() {
        return _fiscalYearEnd;
    }

    public void set_fiscalYearEnd(String _fiscalYearEnd) {
        this._fiscalYearEnd = _fiscalYearEnd;
    }

    public int get_yearEstablished() {
        return _yearEstablished;
    }

    public void set_yearEstablished(int _yearEstablished) {
        this._yearEstablished = _yearEstablished;
    }

    public String get_dunsNumber() {
        return _dunsNumber;
    }

    public void set_dunsNumber(String _dunsNumber) {
        this._dunsNumber = _dunsNumber;
    }

    public String get_stockTicker() {
        return _stockTicker;
    }

    public void set_stockTicker(String _stockTicker) {
        this._stockTicker = _stockTicker;
    }

    public String get_sicCode() {
        return _sicCode;
    }

    public void set_sicCode(String _sicCode) {
        this._sicCode = _sicCode;
    }

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String get_middleName() {
        return _middleName;
    }

    public void set_middleName(String _middleName) {
        this._middleName = _middleName;
    }

    public String get_sex() {
        return _sex;
    }

    public void set_sex(String _sex) {
        this._sex = _sex;
    }

    public String get_birthDate() {
        return _birthDate;
    }

    public void set_birthDate(String _birthDate) {
        this._birthDate = _birthDate;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_jobTitle() {
        return _jobTitle;
    }

    public void set_jobTitle(String _jobTitle) {
        this._jobTitle = _jobTitle;
    }

    public String get_department() {
        return _department;
    }

    public void set_department(String _department) {
        this._department = _department;
    }

    public String get_responsibility() {
        return _responsibility;
    }

    public void set_responsibility(String _responsibility) {
        this._responsibility = _responsibility;
    }

    public String get_decisionMaker() {
        return _decisionMaker;
    }

    public void set_decisionMaker(String _decisionMaker) {
        this._decisionMaker = _decisionMaker;
    }

    public String get_leadSource() {
        return _leadSource;
    }

    public void set_leadSource(String _leadSource) {
        this._leadSource = _leadSource;
    }

    public String get_leadSourceDetail() {
        return _leadSourceDetail;
    }

    public void set_leadSourceDetail(String _leadSourceDetail) {
        this._leadSourceDetail = _leadSourceDetail;
    }

    public String get_arFlag() {
        return _arFlag;
    }

    public void set_arFlag(String _arFlag) {
        this._arFlag = _arFlag;
    }

    public int get_arBillingAddrId() {
        return _arBillingAddrId;
    }

    public void set_arBillingAddrId(int _arBillingAddrId) {
        this._arBillingAddrId = _arBillingAddrId;
    }

    public int get_portraitFileId() {
        return _portraitFileId;
    }

    public void set_portraitFileId(int _portraitFileId) {
        this._portraitFileId = _portraitFileId;
    }

    public int get_leadId() {
        return _leadId;
    }

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

    public void set_externalRefkey(String _externalRefkey) {
        this._externalRefkey = _externalRefkey;
    }

    public String get_lastCallDate() {
        return _lastCallDate;
    }

    public void set_lastCallDate(String _lastCallDate) {
        this._lastCallDate = _lastCallDate;
    }

    public String get_lastEmailDate() {
        return _lastEmailDate;
    }

    public void set_lastEmailDate(String _lastEmailDate) {
        this._lastEmailDate = _lastEmailDate;
    }

    public int get_processStepTxId() {
        return _processStepTxId;
    }

    public void set_processStepTxId(int _processStepTxId) {
        this._processStepTxId = _processStepTxId;
    }

    public String get_processStepDue() {
        return _processStepDue;
    }

    public void set_processStepDue(String _processStepDue) {
        this._processStepDue = _processStepDue;
    }

    public int get_private() {
        return _private;
    }

    public void set_private(int _private) {
        this._private = _private;
    }

    public int get_hasTags() {
        return _hasTags;
    }

    public void set_hasTags(int _hasTags) {
        this._hasTags = _hasTags;
    }

    public String get_tags() {
        return _tags;
    }

    public void set_tags(String _tags) {
        this._tags = _tags;
    }

    public String get_nextCallDate() {
        return _nextCallDate;
    }

    public void set_nextCallDate(String _nextCallDate) {
        this._nextCallDate = _nextCallDate;
    }

    public String get_nextCallTime() {
        return _nextCallTime;
    }

    public void set_nextCallTime(String _nextCallTime) {
        this._nextCallTime = _nextCallTime;
    }

    public String get_nextCallGoal() {
        return _nextCallGoal;
    }

    public void set_nextCallGoal(String _nextCallGoal) {
        this._nextCallGoal = _nextCallGoal;
    }

    public String get_nextCallNote() {
        return _nextCallNote;
    }

    public void set_nextCallNote(String _nextCallNote) {
        this._nextCallNote = _nextCallNote;
    }

    public String get_externalPartnerId() {
        return _externalPartnerId;
    }

    public void set_externalPartnerId(String _externalPartnerId) {
        this._externalPartnerId = _externalPartnerId;
    }

    public boolean is_bSkipGcalSync() {
        return _bSkipGcalSync;
    }

    public void set_bSkipGcalSync(boolean _bSkipGcalSync) {
        this._bSkipGcalSync = _bSkipGcalSync;
    }

    public int get_nextCallUserid() {
        return _nextCallUserid;
    }

    public void set_nextCallUserid(int _nextCallUserid) {
        this._nextCallUserid = _nextCallUserid;
    }

    public String get_companyName() {
        return _companyName;
    }

    public void set_companyName(String _companyName) {
        this._companyName = _companyName;
    }

    public String get_accessKey() {
        return _accessKey;
    }

    public void set_accessKey(String _accessKey) {
        this._accessKey = _accessKey;
    }

    public Hashtable get_hashtableParams() {
        return _hashtableParams;
    }

    public void set_hashtableParams(Hashtable _hashtableParams) {
        this._hashtableParams = _hashtableParams;
    }

    public String get_longStrFieldH() {
        return _longStrFieldH;
    }

    public void set_longStrFieldH(String _longStrFieldH) {
        this._longStrFieldH = _longStrFieldH;
    }

    public String get_googleContactId() {
        return _googleContactId;
    }

    public void set_googleContactId(String _googleContactId) {
        this._googleContactId = _googleContactId;
    }
}
