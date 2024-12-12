package com.performance.improvement.example.model.entity;

import com.performance.improvement.common.baseEntity.BaseTimeEntity;
import com.performance.improvement.example.model.dto.ExampleDetailResponse;
import com.performance.improvement.example.model.dto.ExampleUpdateRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Example extends BaseTimeEntity {
    @Id
    private UUID exampleId = UUID.randomUUID();

    @NotNull
    @Column(length = 50, nullable = false)
    private String exampleTitle;

    @NotNull
    @Column(length = 255, nullable = false)
    private String exampleContent;

    @Builder
    public Example(String exampleTitle, String exampleContent) {
        this.exampleTitle = exampleTitle;
        this.exampleContent = exampleContent;
    }

    public void updateExample(ExampleUpdateRequest request) {
        this.exampleTitle = request.getExampleTitle();
        this.exampleContent = request.getExampleContent();
    }

    public ExampleDetailResponse toDetailResponse() {
        return new ExampleDetailResponse(
                this.exampleId,
                this.exampleTitle,
                this.exampleContent
        );
    }
}
