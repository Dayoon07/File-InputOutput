package com.e.d.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "U_IMG")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImgEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "img_id", nullable = false)
	private long imgId;
	
	@Column(name = "imgname", nullable = false)
	private String imgname;
	
	@Lob
	@Column(name = "filepath", nullable = false)
	private String path;
	
	@Column(name = "datetime", nullable = false)
	private String datetime;
	
	@Column(name = "views")
	private long views;
	
	public void incrementViews() {
		this.views++;
	}
	
}
