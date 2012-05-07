package ru.sngb.kote.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Some useful security utils. Such as:
 * creating object md5.
 * <p/>
 * Date: 08.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public class security {
    public String takeMd5(Object o) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md ;
        StringBuilder md5 = new StringBuilder();
        md = MessageDigest.getInstance("md5");
        md.reset();
        md.update(o.toString().getBytes());
        byte messageDigest[] = md.digest();
        for (byte aMessageDigest : messageDigest) {
            md5.append(Integer.toHexString(0xFF & aMessageDigest));
        }
        return md5.toString();
    }
}
