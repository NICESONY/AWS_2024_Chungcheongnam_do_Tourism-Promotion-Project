package com.mysite.sbb.question;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.S3Service;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;


@Service
public class QuestionNaverService implements QuestionService{
	
	@Autowired
	private JavaMailSender mailsender;
	
	@Autowired
	private UserService userService;

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private S3Service s3Service;
	@Override
    public Question getQuestion(Integer id) {  
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else { // 조회할 데이터가 디비에 존재하지 않을 경우 예외 처리
            throw new DataNotFoundException("question not found");
        }
    }
    
    
    public void create(Question question, MultipartFile file1) {
    //네이버 메일 발송
    	
    SiteUser user = userService.authen();
    	
	SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("samuel0507@naver.com");//설정한 네이버 메일만 사용, 변조 불가
		message.setTo(user.getEmail());//진짜 수신자 메일 주소
		message.setSubject("다음의 제목으로 글이 입력되었습니다. [" + question.getSubject()+"]");//메일 제목
		message.setText(question.getContent());//메일 내용
		
		mailsender.send(message);
    	
    	
    	
    //	이미지
		UUID uuid = UUID.randomUUID();
		String fileName1 = uuid + "_" + file1.getOriginalFilename();
		
		try {
			s3Service.uploadFile(file1, fileName1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		question.setUser(user);
		question.setImage1(fileName1);
    	
        question.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    public void delete(Integer id) {
    	questionRepository.deleteById(id);
    }


	public List<Question> readlist() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}


	@Override
	public List<Question> findBySubjectLike(String kw) {
		// TODO Auto-generated method stub
		return questionRepository.findBySubjectLike("%"+kw+"%");
	}
}
