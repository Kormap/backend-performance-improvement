package com.performance.improvement.notice.repository;

import com.performance.improvement.notice.model.entity.Notice;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Page<Notice> findAll(Pageable pageable);
    List<Notice> findByUpdateDateBetween(@NotNull LocalDateTime startDate, @NotNull LocalDateTime endDate);
}
