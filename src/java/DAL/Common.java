package DAL;

import java.sql.Date;
import java.time.LocalDate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

public class Common {

    public static boolean checkPhone(String phone) {
        return phone.matches("\\d+");
    }

    public static boolean checkDate(Date date) {
        return date.before(getCurrentDate());
    }

    public static Date getCurrentDate() {
        LocalDate curDate = java.time.LocalDate.now();
        return Date.valueOf(curDate.toString());
    }

    public static void main(String[] args) {
        System.out.println(getCurrentDate());
    }

    public static String convertPassToMD5(String password) {
        MessageDigest convert = null;

        try {

            convert = MessageDigest.getInstance("MD5");

        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, e);
        }

        convert.update(password.getBytes());
        byte[] passwordByte = convert.digest();
        return DatatypeConverter.printHexBinary(passwordByte);
    }

    
}
