package com.performance.improvement.notice.controller;

import com.performance.improvement.common.model.MainResponse;
import com.performance.improvement.notice.model.entity.Notice;
import com.performance.improvement.notice.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @Operation(summary = "알림 조회", description = "알림을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "notice read : SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid input data.")
    })
    @GetMapping
    public ResponseEntity<MainResponse<List<Notice>>> findAllNotice() {
        List<Notice> noticeList = noticeService.findAllNotice();
        return ResponseEntity.ok(MainResponse.getSuccessResponse(noticeList));
    }

    @Operation(summary = "알림 조회(페이징)", description = "알림을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "notice read : SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid input data.")
    })
    @GetMapping("/page")
    public ResponseEntity<MainResponse<Page<Notice>>> findPageNotice(
            @PageableDefault(size = 10, page = 0, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Notice> noticeList = noticeService.findPageNotice(pageable);
        return ResponseEntity.ok(MainResponse.getSuccessResponse(noticeList));
    }

    @Operation(summary = "알림 조회(Date)", description = "알림을 날짜 조건으로 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "notice read where date: SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid input data.")
    })
    @GetMapping("/dates")
    public ResponseEntity<MainResponse<List<Notice>>> findAllNoticeByDate(
        @RequestParam("startDate") String startDate,
        @RequestParam("endDate") String endDate
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<Notice> noticesByDate = noticeService.findAllNoticeByDate(LocalDateTime.parse(startDate, formatter), LocalDateTime.parse(endDate, formatter));
        return ResponseEntity.ok(MainResponse.getSuccessResponse(noticesByDate));
    }
}
