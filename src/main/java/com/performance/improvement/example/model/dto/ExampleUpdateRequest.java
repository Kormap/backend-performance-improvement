package com.performance.improvement.example.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Schema(description = "예제 생성 요청")
@Data
public class ExampleUpdateRequest {
    @Schema(description = "예제 ID", example = "dsdsjakl-312i-dsasadsa..")
    private UUID exampleId;

    @NotBlank(message = "예제 제목은 필수 입력사항입니다.")
    @Schema(description = "예제 제목수정", example = "예제 제목수정.")
    private String exampleTitle;

    @NotBlank(message = "예제 내용은 필수 입력사항입니다.")
    @Schema(description = "예제 내용 수정", example = "예제 내용수정.")
    private String exampleContent;
}
