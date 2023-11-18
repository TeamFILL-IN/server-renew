package com.teamfillin.fillin.domain.photo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false)
	private Long userNo;

	@Column(nullable = false)
	private Long studioNo;

	@Column(nullable = false)
	private Long filmNo;

	@Column(nullable = false, length = 500)
	private String imagePath;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private Status status;

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	protected Photo() {
	}

	public Photo(Long userNo, Long studioNo, Long filmNo, String imagePath) {
		this.userNo = userNo;
		this.studioNo = studioNo;
		this.filmNo = filmNo;
		this.imagePath = imagePath;
	}
}
