/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.DatatypeConverter;

public class CommonForJSP {

    public  boolean checkPhone(String phone) {
        return phone.matches("\\d+");
    }

    public  boolean checkDate(Date date) {
        return date.before(getCurrentDate());
    }

    public  Date getCurrentDate() {
        LocalDate curDate = java.time.LocalDate.now();
        return Date.valueOf(curDate.toString());
    }

    public String convertPassToMD5(String password) {
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
    
    public String formatDate(Date date, String pattern){
        
        SimpleDateFormat f = new SimpleDateFormat(pattern);
        
        return f.format(date);
    }
    
    public String getFormatPrice(double price) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        return vn.format(price);
    }
    
    
   

}
