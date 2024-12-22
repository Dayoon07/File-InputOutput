package com.e.d.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.d.model.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository repository;
	
}
