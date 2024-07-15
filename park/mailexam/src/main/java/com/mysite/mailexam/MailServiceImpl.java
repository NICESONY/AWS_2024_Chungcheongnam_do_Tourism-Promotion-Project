package com.mysite.mailexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailsender;
	
	@Override
	public void create(String title, String content, String addr) {
		// TODO Auto-generated method stub
		System.out.println("네이버 메일을 발송합니다.");
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);
		System.out.println("수신인 주소 : " + addr);
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("samuel0507@naver.com");//설정한 네이버 메일만 사용, 변조 불가
		message.setTo(addr);//진짜 수신자 메일 주소
		message.setSubject(title);//메일 제목
		message.setText(content);//메일 내용
		
		mailsender.send(message);
	}
}
