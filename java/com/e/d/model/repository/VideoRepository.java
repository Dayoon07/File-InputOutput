package com.e.d.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e.d.model.entity.VideoEntity;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

}
