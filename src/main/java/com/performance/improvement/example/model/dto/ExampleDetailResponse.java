package com.performance.improvement.example.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Schema(description = "예제 상세 응답")
@AllArgsConstructor
@Data
public class ExampleDetailResponse {
    @Schema(description = "예제 ID", example = "2be8119a-b655-419c-92c9-7db023432041")
    private UUID exampleId;

    @Schema(description = "예제 제목", example = "예제 제목입니다.")
    private String exampleTitle;

    @Schema(description = "예제 내용", example = "예제 내용입니다.")
    private String exampleContent;
}
