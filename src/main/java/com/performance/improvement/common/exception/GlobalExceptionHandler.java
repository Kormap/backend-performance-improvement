package com.performance.improvement.common.exception;

import com.performance.improvement.common.ApiConstants;
import com.performance.improvement.common.model.MainResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // SQL 관련
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<MainResponse<Void>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Throwable rootCause = ex.getRootCause();
        String errorMessage = (rootCause != null ? rootCause.getMessage() : ex.getMessage());
        String parseMessage = parseColumnNameAndMessage(errorMessage);

        return ResponseEntity.badRequest().body(
                new MainResponse<>(
                        ApiConstants.Status.ERROR,
                        parseMessage != null ? parseMessage : ApiConstants.Message.BAD_REQUEST
                )
        );
    }

    // 공통 Exception
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<MainResponse<Void>> handleException(Exception ex) {
        return ResponseEntity.badRequest().body(
                new MainResponse<>(
                        ApiConstants.Status.ERROR,
                        ex.getMessage() != null ? ex.getMessage() : ApiConstants.Message.BAD_REQUEST
                )
        );
    }

    public String parseColumnNameAndMessage(String errorMessage) {
        String columnName = "undefined";

        // H2 메시지에서 컬럼명 추출(길이초과)
        if (errorMessage.contains("Value too long for column")) {
            int startIndex = errorMessage.indexOf("\"") + 1;
            int endIndex = errorMessage.indexOf(" ", startIndex);
            if (startIndex > 0 && endIndex > startIndex) {
                columnName = errorMessage.substring(startIndex, endIndex).trim();
            }
            errorMessage = "입력된 데이터가 허용된 길이를 초과했습니다. (컬럼명: " + columnName.toLowerCase() + ")";
        }

        // MySQL 메시지에서 컬럼명 추출(길이초과)
        else if (errorMessage.contains("Data too long for column")) {
            int startIndex = errorMessage.indexOf("'") + 1;
            int endIndex = errorMessage.indexOf("'", startIndex);
            if (startIndex > 0 && endIndex > startIndex) {
                columnName = errorMessage.substring(startIndex, endIndex).trim();
            }
            errorMessage = "입력된 데이터가 허용된 길이를 초과했습니다. (컬럼명: " + columnName.toLowerCase() + ")";
        }

        return errorMessage;
    }
}