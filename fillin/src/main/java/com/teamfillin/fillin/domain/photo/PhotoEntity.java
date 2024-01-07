package com.teamfillin.fillin.domain.photo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.teamfillin.fillin.domain.common.BaseTimeEntity;
import com.teamfillin.fillin.resource.Image;

@Entity
@Table(name = "photo")
public class PhotoEntity extends BaseTimeEntity {

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
	private PhotoStatus status;

	protected PhotoEntity() {
	}

	public PhotoEntity(Long userNo, Long studioNo, Long filmNo, String imagePath) {
		this.userNo = userNo;
		this.studioNo = studioNo;
		this.filmNo = filmNo;
		this.imagePath = imagePath;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			PhotoEntity target = (PhotoEntity)obj;
			return no == target.no;
		}
		return false;
	}
}
