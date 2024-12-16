package com.performance.improvement.notice.model.entity;

import com.performance.improvement.example.model.dto.ExampleDetailResponse;
import com.performance.improvement.notice.model.dto.NoticeDetailResponse;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notice_id_gen")
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 30)
    @Column(name = "title", length = 30)
    private String title;

    @Size(max = 100)
    @Column(name = "content", length = 100)
    private String content;

    @Size(max = 30)
    @Column(name = "who", length = 30)
    private String writer;

    @NotNull
    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @NotNull
    @Column(name = "update_date", nullable = false)
    private Instant updateDate;

    public NoticeDetailResponse toDetailResponse() {
        return new NoticeDetailResponse(
                this.id,
                this.title,
                this.content,
                this.writer
        );
    }
}