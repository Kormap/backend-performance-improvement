package com.performance.improvement.example.model.dto;

import com.performance.improvement.example.model.entity.Example;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Schema(description = "예제 생성 요청")
@Data
public class ExampleCreateRequest {
    @NotBlank(message = "예제 제목은 필수 입력사항입니다.")
    @Schema(description = "예제 제목", example = "예제 제목입니다.")
    private String exampleTitle;

    @NotBlank(message = "예제 내용은 필수 입력사항입니다.")
    @Schema(description = "예제 내용", example = "예제 내용입니다.")
    private String exampleContent;

    public Example toEntity(String exampleTitle, String exampleContent) {
        return Example.builder()
                .exampleTitle(exampleTitle)
                .exampleContent(exampleContent)
                .build();
    }
}
