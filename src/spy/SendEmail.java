package spy;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
//    public static void main(String [] args)
//    {
//        // 收件人电子邮箱
//        String to = "78599297@qq.com";
//
//        // 发件人电子邮箱
//        String from = "chiming3165@gmail.com";
//
//        // 指定发送邮件的主机为 localhost
//        String host = "localhost";
//
//        // 获取系统属性
//        Properties properties = System.getProperties();
//
//        // 设置邮件服务器
//        properties.setProperty("mail.smtp.host", host);
//
//        // 获取默认session对象
//        Session session = Session.getDefaultInstance(properties);
//
//        try{
//            // 创建默认的 MimeMessage 对象
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: 头部头字段
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: 头部头字段
//            message.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress(to));
//
//            // Set Subject: 头部头字段
//            message.setSubject("This is the Subject Line!");
//
//            // 设置消息体
//            message.setText("This is actual message");
//
//            // 发送消息
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        }catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }
}
