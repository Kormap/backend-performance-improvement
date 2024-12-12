package com.performance.improvement.common.model;

import com.performance.improvement.common.ApiConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "기본 응답")
@Data
public class MainResponse<T> {

    @Schema(description = "응답 상태", example = "success")
    private String status;

    @Schema(description = "응답 메시지", example = "Operation completed successfully.")
    private String message;

    private T data;

    public MainResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public MainResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static <T> MainResponse<T> getSuccessResponse(T data) {
        return new MainResponse<>(
                ApiConstants.Status.SUCCESS,
                ApiConstants.Message.OPERATION_COMPLETED,
                data
        );
    }
}
