package ru.sngb.kote.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Some class.
 * <p/>
 * User: Viacheslav
 * Date: 08.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public class security {
    public String takeMd5(Object o) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md ;
        StringBuffer  md5 = new StringBuffer();
        md = MessageDigest.getInstance("md5");
        md.reset();
        md.update(o.toString().getBytes());
        byte messageDigest[] = md.digest();
        for (int i = 0; i < messageDigest.length; i++) {
            md5.append(Integer.toHexString(0xFF & messageDigest[i]));
        }
        return md5.toString();
    }
}
