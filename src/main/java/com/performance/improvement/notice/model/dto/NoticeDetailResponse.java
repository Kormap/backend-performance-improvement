package com.performance.improvement.notice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "예제 상세 응답")
@AllArgsConstructor
@Data
public class NoticeDetailResponse {
    @Schema(description = "알림 ID")
    private Long id;

    @Schema(description = "알림 제목", example = "알림 제목입니다.")
    private String title;

    @Schema(description = "알림 내용", example = "알림 내용입니다.")
    private String content;

    @Schema(description = "알림 작성자", example = "알림 작성자입니다.")
    private String who;
}
