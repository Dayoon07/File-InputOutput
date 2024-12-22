package com.e.d.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "U_VIDEO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "video_id", nullable = false)
	private long videoId;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "filepath", nullable = false)
	private String filepath;
	
	@Column(name = "created", nullable = false)
	private String created;
	
	@Column(name = "views")
	private long views;
	
	@Column(name = "uploader_id")
	private long uploaderid;
	
	public void incrementViews() {
		this.views++;
	}
	
}