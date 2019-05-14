package com.longhu.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: houyong
 * @descririiption: 邮件发送模板类
 * @create: 2019-03-12 18:03
 */
public class EmailUtils {
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration configuration;

    /**
     * 发送简单文本
     */
    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(to);
        smm.setSubject(subject);
        smm.setText(content);
        smm.setFrom(from);
        javaMailSender.send(smm);
    }

    /**
     * 发送带附件的邮件
     */
    public void sendAttachmentEmail(String to, String subject, String content, String filePath) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        //添加多个附件可以使用多条
        helper.addAttachment(fileName, file);
        helper.addAttachment(fileName + "-2", file);
        javaMailSender.send(message);
        System.out.println("带附件的邮件发送成功");
    }

    /**
     * 发送图片和gif动图
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath 文件路径
     * @param rscId
     */
    public void sendInlinResourceMail(String to, String subject, String content,
                                      String rscPath, String rscId) throws Exception {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        FileSystemResource res = new FileSystemResource(new File(rscPath));

        //可以发送带多个图片的邮件
        helper.addInline(rscId, res);
        helper.addInline(rscId, res);
        javaMailSender.send(message);
    }

    /**
     * 发送模板邮件
     *
     * @param to
     * @param subject
     * @param freemarkerName
     * @throws Exception
     */
    public void freemarkerSendMail(String to, String subject, String freemarkerName) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        Map<String, Object> model = new HashMap<>(16);
        model.put("UserName", "houyong");
        Template template = configuration.getTemplate(freemarkerName);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        helper.setText(html, true);
        javaMailSender.send(message);

    }
}
