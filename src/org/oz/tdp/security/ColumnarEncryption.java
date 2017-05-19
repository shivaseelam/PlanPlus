package org.oz.tdp.security;

/**
 * Created by WIN on 5/18/2017.
 */
public class ColumnarEncryption {

    protected String _password;

    public ColumnarEncryption(String password) {
        _password = password;
    }

    public String decrypt(String s)
    {
        if (_password == null || _password.trim().length() == 0) {
            return null;
        } else {
            // XOR
            byte[]  b = s.getBytes();
            simpleEncrypt(b, b.length);

            // DE-SCRAMBLE
            return encryptDecrypt(new String(b), _password, false);
        }
    }


    public String encrypt(String s)
    {
        if (_password == null || _password.trim().length() == 0) {
            return null;
        } else {
            // SCRAMBLE
            String result = encryptDecrypt(s, _password, true);

            // XOR
            byte[] b = result.getBytes();
            simpleEncrypt(b, b.length);

            return new String(b);
        }
    }

    /**
     * Helper method with simple encryption technique,
     * only doing an xor on the input string.
     * Is used by the encrypt and decrypt functions in this class.
     *
     * @param  data The byte array representing the data.
     * @param  size The size of the data to encrypt.
     */
    public static void simpleEncrypt(byte[] data, int size) {
        byte key = (byte) (size % 256);
        key = key == 0 ? 0x55 : key;
        for (int i = 0 ; i < size; i++) {
            data[i] ^= key;
        }
    }

    /** implementation of scrambling mechanism */
    private static String encryptDecrypt(String strInputText, String strPassword, boolean e) {
        StringBuffer sbInput = new StringBuffer(strInputText);

        // loop variables
        int i, j;

        // length of password
        int iPL = strPassword.length();

        int  added = 0;
        try {
            if (e) {
                // if encrypting and column is not complete,
                // add x's to the end to fill out column
                int addToEnd = sbInput.length() % iPL;

                if(addToEnd != 0) {
                    for(i = 0; i < iPL - addToEnd; i++) {
                        sbInput.append('x');
                        added++;
                    }
                }
            } else {
                // ADDED BY KLAAS WASLANDER:
                // if decrypting, get the number of added
                // 'x' characters to remove after decrypting!
                int  addedStart = sbInput.length()-2;
                while (addedStart >= 0 && sbInput.charAt(addedStart) != '-') {
                    //System.out.println(sbInput.charAt(addedStart));
                    addedStart--;
                }
                if (addedStart >= 0) {
                    added = Integer.parseInt(sbInput.toString().substring(addedStart+1, sbInput.length()-1));
                    sbInput.setLength(addedStart);
                }
            }
        } catch (Exception e2) {
            System.err.println("<ColumnarEncryption> WARNING: old version of encryption algorithm detected... "+e2);
            return strInputText;
        }

        // create order table

        // convert password to ints, and put into array T
        int[] T = new int[iPL];
        for(i = 0; i < iPL; i++) {
            T[i] = (int)strPassword.charAt(i);
        }

        int[] iOrderTable = new int[iPL];
        StringBuffer sbOrderTable = new StringBuffer();
        int T2 = 0;
        for(i = 0; i < iPL; i++) {
            // find lowest number (character) in array T,
            // and put the index for it in T2
            int min = 256;
            for(j = 0; j < iPL; j++) {
                if(T[j] < min) {
                    min = T[j];
                    T2 = j;
                }
            }
            // set the lowest number to 256 so it is not picked up
            // next time
            T[T2] = 256;

            // put the index of the lowest number into iOrderTable
            iOrderTable[i] = T2;
            // after all of this, you have a table of which columns
            // to read from
        }
        //System.out.println(iOrderTable.length+","+iOrderTable[0]+","+iOrderTable[1]+","+iOrderTable[2]+","+iOrderTable[3]+","+iOrderTable[4]);

        // encrypt-decrypt

        // encrypted-decrypted text goes into this string buffer
        StringBuffer sbOutput = new StringBuffer("");

        // fill sbOutput with spaces so the setCharAt()
        // command will work
        for(i = 0; i < sbInput.length(); i++) {
            sbOutput.append(' ');
        }

        // index of current position in decrypted array
        //System.out.println(sbInput);
        int index;
        for(i = 0, index = 0; i < iPL; i++) {
            for(j = iOrderTable[i]; j < sbInput.length(); j += iPL, index++) {
                // if encrypting, do this
                if(e) {
                    sbOutput.setCharAt(index, sbInput.charAt(j));
                }
                // else if decrypting, do this
                else sbOutput.setCharAt(j, sbInput.charAt(index));
            }
        }

        // ADDED BY KLAAS WASLANDER
        if (e) {
            // register number of added 'x' characters
            sbOutput.append('-');
            sbOutput.append(added);
            sbOutput.append('-');
        } else {
            // after decryption, remove number of added 'x' characters!
            //System.out.println("DECRYPT ADDED CHARS: "+added);
            sbOutput.setLength(sbOutput.length() - added);
        }

        return sbOutput.toString();
    }
}
