package com.e.d.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.e.d.model.entity.ImgEntity;
import com.e.d.model.entity.VideoEntity;
import com.e.d.model.repository.ImgRepository;
import com.e.d.model.repository.VideoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	@Autowired
	private VideoRepository vRepository;
	
	@Autowired
	private ImgRepository iRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allVideo", vRepository.findAll());
		model.addAttribute("allImg", iRepository.findAll());
		return "index";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "video/insert";
	}
	
	@GetMapping("/imgInsert")
	public String imgInsert() {
		return "img/insert";
	}
	
	@GetMapping("/video")
	public String viewVideo(@RequestParam long videoId, Model model) {
	    Optional<VideoEntity> videoOptional = vRepository.findById(videoId);
	    if (videoOptional.isPresent()) {
	        VideoEntity video = videoOptional.get();

	        // 조회수 증가
	        video.incrementViews();
	        vRepository.save(video);

	        model.addAttribute("videoInfo", video);
	    }
	    return "video/watch";
	}
	
	@GetMapping("/img")
	public String viewImg(@RequestParam long imgId, Model model) {
	    Optional<ImgEntity> image = iRepository.findById(imgId);
	    if (image.isPresent()) {
	    	image.get().incrementViews();
	    	iRepository.save(image.get());

	        model.addAttribute("imgInfo", image.get());
	    }
	    return "img/view";
	}
	
	@GetMapping("/video/{videoId}")
	public ResponseEntity<InputStreamResource> viewVideo(@PathVariable long videoId) throws IOException {
	    Optional<VideoEntity> videoOptional = vRepository.findById(videoId);
	    if (videoOptional.isPresent()) {
	        VideoEntity video = videoOptional.get();
	        
	        // 영상 파일 경로 (filepath에 실제 영상 파일 경로가 저장되어 있다고 가정)
	        File videoFile = new File(video.getFilepath());

	        if (!videoFile.exists()) {
	            // 파일이 존재하지 않으면 404 Not Found
	            return ResponseEntity.notFound().build();
	        }

	        // 파일을 InputStream으로 읽어서 반환
	        InputStreamResource resource = new InputStreamResource(new FileInputStream(videoFile));

	        // Content-Type은 동적으로 설정할 수 있습니다 (예: video/mp4)
	        return ResponseEntity.ok()
	                .contentType(MediaType.valueOf("video/mp4"))
	                .contentLength(videoFile.length())
	                .body(resource);
	    }
	    return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam String title,
	                     @RequestParam String description,
	                     @RequestParam("filepath") MultipartFile file) {

	    // 파일 저장 디렉토리
	    String uploadDir = "C:/uploads/";
	    String fileName = file.getOriginalFilename();

	    try {
	        // 디렉토리가 없으면 생성
	        File dir = new File(uploadDir);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }

	        // 파일 저장
	        file.transferTo(new File(uploadDir + fileName));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "error"; // 에러 처리
	    }

	    // VideoEntity 생성 및 저장
	    VideoEntity video = VideoEntity.builder()
	            .title(title)
	            .description(description)
	            .filepath("/uploads/" + fileName) // 브라우저에서 접근 가능한 HTTP 경로 저장
	            .created(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분")))
	            .views(0)
	            .build();

	    vRepository.save(video);
	    log.info("Video uploaded: {}", video);

	    return "redirect:/";
	}

	@PostMapping("/image/upload")
	public String uploadImage(@RequestParam String imgname,
	                          @RequestParam("path") MultipartFile path) {

	    // 파일 저장 디렉토리 설정
	    String uploadDir = "C:/uploads/images/";
	    String fileName = path.getOriginalFilename();

	    try {
	        // 디렉토리가 없으면 생성
	        File dir = new File(uploadDir);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }

	        // 파일 저장
	        path.transferTo(new File(uploadDir + fileName));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "error"; // 에러 처리
	    }

	    // ImageEntity 생성 및 저장
	    ImgEntity image = ImgEntity.builder()
	            .imgname(imgname)
	            .path("/uploads/images/" + fileName) // 브라우저에서 접근 가능한 경로 저장
	            .datetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분")))
	            .build();

	    iRepository.save(image); // DB 저장
	    return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
