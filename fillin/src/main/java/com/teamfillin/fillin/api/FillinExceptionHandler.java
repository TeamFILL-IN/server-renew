package com.teamfillin.fillin.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.teamfillin.fillin.FillinException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class FillinExceptionHandler {
	@ExceptionHandler(FillinException.class)
	ResponseEntity<FillinApiResponse> handleFillinException(FillinException e) {
		return FillinApiResponse.failure(e.getErrorCode());
	}
}
