package com.performance.improvement.example.controller;

import com.performance.improvement.common.model.MainResponse;
import com.performance.improvement.example.model.dto.ExampleCreateRequest;
import com.performance.improvement.example.model.dto.ExampleDetailResponse;
import com.performance.improvement.example.model.dto.ExampleUpdateRequest;
import com.performance.improvement.example.service.ExampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/example")
@Tag(name = "예시 API", description = "예시를 보여주기 위한 API")
public class ExampleController {

    private final ExampleService exampleService;

    @Operation(summary = "예시 생성", description = "예시를 생성합니다. 반환 값(SUCCESS/FAIL)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "example created : SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid input data.")
    })
    @PostMapping
    public ResponseEntity<MainResponse<String>> createExample(
            @Valid @RequestBody ExampleCreateRequest request
    ) {
        String exampleId = exampleService.createExample(request);
        return ResponseEntity.ok(MainResponse.getSuccessResponse("예제 생성완료: " + exampleId));
    }

    @Operation(summary = "예시 단건 조회", description = "예시를 단건 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "example read : SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid input data.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MainResponse<ExampleDetailResponse>> findExampleById(
            @Schema(example = "042482cb-f1cd-4935-9579-e12da625961f")
            @PathVariable(required = true) UUID id
    ) {
        ExampleDetailResponse exampleResponse = exampleService.findExampleById(id);
        return ResponseEntity.ok(MainResponse.getSuccessResponse(exampleResponse));
    }

    @Operation(summary = "예시 다건 조회", description = "예시를 다건 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "example read : SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid input data.")
    })
    @GetMapping
    public ResponseEntity<MainResponse<List<ExampleDetailResponse>>> findExampleList(
    ) {
        List<ExampleDetailResponse> exampleResponseList = exampleService.findExampleList();
        return ResponseEntity.ok(MainResponse.getSuccessResponse(exampleResponseList));
    }

    @Operation(summary = "QueryDSL 예시 조회", description = "QueryDSL 제목 컬럼 LIKE 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "example read : SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid input data.")
    })
    @GetMapping("/querydsl/title")
    public ResponseEntity<MainResponse<List<ExampleDetailResponse>>> findExampleByTitle(
            @Parameter(required = true) String exampleTitle
    ){
        List<ExampleDetailResponse> exampleDetailResponseList =exampleService.findExampleByTitle(exampleTitle);
        return ResponseEntity.ok(MainResponse.getSuccessResponse(exampleDetailResponseList));
    }

    @Operation(summary = "예시 단건 수정", description = "예시를 단건 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "example updated : SUCCESS"),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid input data.")
    })
    @PatchMapping
    public ResponseEntity<MainResponse<String>> updateExample(
            @Valid @RequestBody ExampleUpdateRequest request
    ) {
        String exampleId = exampleService.updateExample(request);
        return ResponseEntity.ok(MainResponse.getSuccessResponse("Example updated : " + exampleId));
    }
}
