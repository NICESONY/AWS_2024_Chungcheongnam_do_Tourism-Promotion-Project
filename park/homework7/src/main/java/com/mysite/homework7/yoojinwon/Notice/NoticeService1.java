package com.mysite.homework7.yoojinwon.Notice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.homework7.S3Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeService1 {

	private final NoticeRepository1 nr;
	private final S3Service s3service;

	public void createnotice(Notice1 notice, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
		
		if(!file1.isEmpty()) {
			s3service.uploadFile(file1, file1.getOriginalFilename());
			notice.setImage1(file1.getOriginalFilename());
		}
		if(!file2.isEmpty()) {
			s3service.uploadFile(file2, file2.getOriginalFilename());
			notice.setImage2(file2.getOriginalFilename());
		}
		if(!file3.isEmpty()) {
			s3service.uploadFile(file3, file3.getOriginalFilename());
			notice.setImage3(file3.getOriginalFilename());
		}
		notice.setDate(LocalDateTime.now());
		this.nr.save(notice);
	}
	public List<Notice1> findallnotice(){
		return nr.findAll();
	}
	public Notice1 getnoticeByid(Integer id) {
		
		Optional<Notice1> op = this.nr.findById(id);
		return op.get();
	}
	public void deleteNotice(Integer id) {
		nr.deleteById(id);
	}
	public void update(Notice1 notice, MultipartFile file1, MultipartFile file2, MultipartFile file3)  throws IOException {
		//image1만 변화가 있는경우
		//image2만 변화가 있는경우
		if(!file1.isEmpty()) {
			s3service.uploadFile(file1, file1.getOriginalFilename());
			notice.setImage1(file1.getOriginalFilename());
		}
		if(!file2.isEmpty()) {
			s3service.uploadFile(file2, file2.getOriginalFilename());
			notice.setImage2(file2.getOriginalFilename());
		}
		if(!file3.isEmpty()) {
			s3service.uploadFile(file3, file3.getOriginalFilename());
			notice.setImage3(file3.getOriginalFilename());
		}

		nr.save(notice);
	}
}
