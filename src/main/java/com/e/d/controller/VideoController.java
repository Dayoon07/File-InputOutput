package com.e.d.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.e.d.model.entity.VideoEntity;
import com.e.d.model.repository.VideoRepository;

@RestController
public class VideoController {
	
	@Autowired
	private VideoRepository repository;
	
	@GetMapping("/video/stream/{videoId}")
	public ResponseEntity<InputStreamResource> streamVideo(@PathVariable long videoId) throws IOException {
	    Optional<VideoEntity> videoOptional = repository.findById(videoId);
	    if (videoOptional.isPresent()) {
	        VideoEntity video = videoOptional.get();
	        File videoFile = new File(video.getFilepath());

	        if (!videoFile.exists()) {
	            return ResponseEntity.notFound().build();
	        }

	        InputStreamResource resource = new InputStreamResource(new FileInputStream(videoFile));

	        return ResponseEntity.ok()
	                .contentType(MediaType.valueOf("video/mp4"))
	                .contentLength(videoFile.length())
	                .body(resource);
	    }
	    return ResponseEntity.notFound().build();
	}

	
}
