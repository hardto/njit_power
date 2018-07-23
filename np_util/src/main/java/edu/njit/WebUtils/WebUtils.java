package edu.njit.WebUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class WebUtils {
    private static Logger logger = LoggerFactory.getLogger(WebUtils.class);

    private static Calendar calendar = Calendar.getInstance();

    public static String getTimeNow(){
        return calendar.get(Calendar.YEAR)+""+(calendar.get(Calendar.MONTH)+1)+""+calendar.get(Calendar.DATE);
    }

    public static String getTimeNowWithPattern(String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (!ObectUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (!ObectUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }


    public static void sendEmail(String code,String useremail) throws MessagingException {
        logger.info("验证码已经发送至"+useremail);
        Properties properties = new Properties();
        //开启debug调试
        properties.setProperty("mail.debug", "true");

        //发送服务器需要身份认证
        properties.setProperty("mail.smtp.auth", "true");

        //设置服务器主机
        properties.setProperty("mail.host", "smtp.163.com");

        // 发送邮件协议名称
        properties.setProperty("mail.transport.protocol", "smtp");
        MyAuthenticator myauth = new MyAuthenticator("m17714389130@163.com", "5201314...=====");
        // 设置环境信息
        Session session = Session.getInstance(properties, myauth);

        // 创建邮件对象
        Message msg = new MimeMessage(session);
        msg.setSubject("站点验证码");
        // 设置邮件内容
        msg.setText("您的验证码是:"+code);
        // 设置发件人
        msg.setFrom(new InternetAddress(Const.systemEmail));
        msg.addRecipient(Message.RecipientType.TO,
                new InternetAddress(useremail));//2546977800@qq.com
        Transport.send(msg);
    }



}
class MyAuthenticator
        extends javax.mail.Authenticator {
    private String strUser;
    private String strPwd;
    public MyAuthenticator(String user, String password) {
        this.strUser = user;
        this.strPwd = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(strUser, strPwd);
    }


}
