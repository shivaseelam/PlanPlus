package org.oz.sppol.bo.common.user;

import org.oz.tdp.security.MyEncrypt;

/**
 * Created by WIN on 5/17/2017.
 */
public class FwkUserBO {

    private int _userId;
    private String _userName;
    private String _encPassword;
    private String _displayName;
    private String _firstName;
    private String _lastName;
    private String _middleName;
    private String _emailAddress;
    private String _phoneNumber;
    private int _managerUserId;
    private String _managerTree;
    private String _userTitle;
    private String _defaultLoginAppcode;
    private String _pswdExpireDate = "-1"; // -1 means never expire
    private String _territoryRole = "";
    private String _functionResponsibility = "";
    private String _enableSync = "N";
    private String _accessKey;

    private String _autoGenKey;

    private String _longStrFieldH = "";

    private String _lastLoginDate = "";
    private int _numLoginTotal = 0;
    private int _contactId = 0;
    protected String _activeStatus    = "Y";

    public int getuserId() {
        return _userId;
    }

    public void setuserId(int _userId) {
        this._userId = _userId;
    }

    public String getuserName() {
        return _userName;
    }

    public void setuserName(String _userName) {
        this._userName = _userName;
    }

    public String getencPassword() {
        return _encPassword;
    }

    public void setencPassword(String _encPassword) {
        this._encPassword = _encPassword;
    }

    public String getdisplayName() {
        return _displayName;
    }

    public void setdisplayName(String _displayName) {
        this._displayName = _displayName;
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

    public String getemailAddress() {
        return _emailAddress;
    }

    public void setemailAddress(String _emailAddress) {
        this._emailAddress = _emailAddress;
    }

    public String getphoneNumber() {
        return _phoneNumber;
    }

    public void setphoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    public int getmanagerUserId() {
        return _managerUserId;
    }

    public void setmanagerUserId(int _managerUserId) {
        this._managerUserId = _managerUserId;
    }

    public String getmanagerTree() {
        return _managerTree;
    }

    public void setmanagerTree(String _managerTree) {
        this._managerTree = _managerTree;
    }

    public String getuserTitle() {
        return _userTitle;
    }

    public void setuserTitle(String _userTitle) {
        this._userTitle = _userTitle;
    }

    public String getdefaultLoginAppcode() {
        return _defaultLoginAppcode;
    }

    public void setdefaultLoginAppcode(String _defaultLoginAppcode) {
        this._defaultLoginAppcode = _defaultLoginAppcode;
    }

    public String getpswdExpireDate() {
        return _pswdExpireDate;
    }

    public void setpswdExpireDate(String _pswdExpireDate) {
        this._pswdExpireDate = _pswdExpireDate;
    }

    public String getterritoryRole() {
        return _territoryRole;
    }

    public void setterritoryRole(String _territoryRole) {
        this._territoryRole = _territoryRole;
    }

    public String getfunctionResponsibility() {
        return _functionResponsibility;
    }

    public void setfunctionResponsibility(String _functionResponsibility) {
        this._functionResponsibility = _functionResponsibility;
    }

    public String getenableSync() {
        return _enableSync;
    }

    public void setenableSync(String _enableSync) {
        this._enableSync = _enableSync;
    }

    public String getaccessKey() {
        return _accessKey;
    }

    public void setaccessKey(String _accessKey) {
        this._accessKey = _accessKey;
    }

    public String getautoGenKey() {
        return _autoGenKey;
    }

    public void setautoGenKey(String _autoGenKey) {
        this._autoGenKey = _autoGenKey;
    }

    public String getlongStrFieldH() {
        return _longStrFieldH;
    }

    public void setlongStrFieldH(String _longStrFieldH) {
        this._longStrFieldH = _longStrFieldH;
    }

    public String getlastLoginDate() {
        return _lastLoginDate;
    }

    public void setlastLoginDate(String _lastLoginDate) {
        this._lastLoginDate = _lastLoginDate;
    }

    public int getnumLoginTotal() {
        return _numLoginTotal;
    }

    public void setnumLoginTotal(int _numLoginTotal) {
        this._numLoginTotal = _numLoginTotal;
    }

    public int getcontactId() {
        return _contactId;
    }

    public void setcontactId(int _contactId) {
        this._contactId = _contactId;
    }

    public boolean isActive(){ return  _activeStatus!=null && _activeStatus.equals("Y");}
    public String getDecryptedPassword() {
        return MyEncrypt.decrypt(_encPassword);
    }
    public String getUndecryptedPassword() {
        return _encPassword;
    }

    public void setPassword(String val) {
        _encPassword = MyEncrypt.encrypt(val);
        //Code Migration: security
        if ( getuserId() > 0 )
        {
            int nCurrHours = (int) ( ( new java.util.Date() ).getTime() / (long) 3600000 );  // in hours
            /*setHashFieldValue( "PSWD_LAST_RESET", ""+nCurrHours );*/
        }
    }
}
