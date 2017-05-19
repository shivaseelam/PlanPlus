package org.oz.tdp.security;

/**
 * Created by WIN on 5/18/2017.
 */
public class MyEncrypt {
    public static final String ENC_KEY = "ebsuite.com";
    static public String decrypt( String s )
    {
        if ( s == null || s.equals("") ) return "";
        if ( s.startsWith( "EBNEA_" ) )
        {
            s = s.substring(6); // substring(6) will remove "EBNEA_"
            s = s.replaceAll( "EB_PLUS", "+" );
            s = s.replaceAll( "EB_PCT", "%" );
            s = s.replaceAll( "EB_AND", "&" );
            s = s.replaceAll( "EB_QMARK", "?" );
            s = s.replaceAll( "EB_EQUAL", "=" );
            DesEncrypter encrypter = new DesEncrypter();
            return encrypter.decrypt( s );
        }
        if ( s.startsWith( "EP_" ) )
        {
            s = s.substring(3); // substring(6) will remove "EBNEA_"
            s = s.replaceAll( "_PLS", "+" );
            s = s.replaceAll( "_PCT", "%" );
            s = s.replaceAll( "_AND", "&" );
            s = s.replaceAll( "_QMK", "?" );
            s = s.replaceAll( "_EQL", "=" );
            DesEncrypter encrypter = new DesEncrypter();
            return encrypter.decrypt( s );
        }

        StringBuffer res = new StringBuffer();
        int p = 0;
        int q = 0;
        while ((q = s.indexOf("BSLASH", p)) > -1) {
            res.append(s.substring(p, q));
            res.append("\\");
            p = q + 6;
        }
        res.append(s.substring(p));

        ColumnarEncryption a = new ColumnarEncryption( ENC_KEY );
        return a.decrypt(res.toString());
    }

    static public String encrypt( String s )
    {
        if ( s == null || s.equals("") ) return "";

        DesEncrypter encrypter = new DesEncrypter();
        String result = encrypter.encrypt(s);  // EBsuite New Encryption Algorithm

        result = replaceAWithB( result, "+", "EB_PLUS" );
        result = replaceAWithB( result, "%", "EB_PCT" );
        result = replaceAWithB( result, "&", "EB_AND" );
        result = replaceAWithB( result, "?", "EB_QMARK" );
        result = replaceAWithB( result, "=", "EB_EQUAL" );
        return "EBNEA_"+result;
    }


    public static boolean isStringNull (String s) {
        if (s == null || s.equals(""))
            return true;
        else
            return false;
    }
    public static String replaceAWithB(String str, String A, String B)
    {
        if ( isStringNull(str) ) return "";

        StringBuffer res = new StringBuffer();
        int p = 0;
        int q = 0;
        while ((q = str.indexOf(A, p)) > -1) {
            res.append(str.substring(p, q));
            if ( B!= null )
                res.append(B);
            p = q + A.length();
        }
        res.append(str.substring(p));
        return res.toString();
    }
}
