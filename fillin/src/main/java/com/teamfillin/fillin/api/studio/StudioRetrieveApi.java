package com.teamfillin.fillin.api.studio;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfillin.fillin.api.FillinApiResponse;
import com.teamfillin.fillin.domain.studio.StudioDetailRetrieveService;
import com.teamfillin.fillin.domain.studio.StudioLocationResult;
import com.teamfillin.fillin.domain.studio.StudioRetrieverService;

@RestController
@RequestMapping("/studio")
public class StudioRetrieveApi {

	private final StudioRetrieverService studioRetrieverService;
	private final StudioDetailRetrieveService studioDetailRetrieveService;

	public StudioRetrieveApi(StudioRetrieverService studioRetrieverService,
		StudioDetailRetrieveService studioDetailRetrieveService) {
		this.studioRetrieverService = studioRetrieverService;
		this.studioDetailRetrieveService = studioDetailRetrieveService;
	}

	/**
	 * 	studio 데이터가 많아지게 되면 클라이언트로 부터 현재 위치 값을 받아
	 * 	구역 내 studio search 하는 api 로 변경
	 */
	@GetMapping("/maps")
	public FillinApiResponse retrieveAllStudio() {
		List<StudioLocationResult> studioLocationResults = studioRetrieverService.retrieveAllStudio();
		return FillinApiResponse.success(HttpStatus.OK, new StudioRetrieveAllResponse(studioLocationResults));
	}

	@GetMapping("/{studioId}")
	public FillinApiResponse retrieveStudioDetail(@PathVariable long studioId) {
		return FillinApiResponse.success(HttpStatus.OK, studioDetailRetrieveService.retrieveDetail(studioId));
	}
}
