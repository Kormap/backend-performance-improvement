package com.performance.improvement.notice.service;

import com.performance.improvement.notice.model.entity.Notice;
import com.performance.improvement.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final CacheManager cacheManager;

    @Transactional(readOnly = true)
    @Cacheable(value = "noticeCache")
    public List<Notice> findAllNotice() {
        List<Notice> notices = noticeRepository.findAll();
        // put 메소드를 사용하여 key 설정
        cacheManager.getCache("noticeCache").put("noticeList", notices);
        return notices;
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "noticeCache", key = "'noticeCache-'+ #pageable.pageNumber", condition = "#pageable.pageNumber <= 5")
    public Page<Notice> findPageNotice(Pageable pageable) {

        Page<Notice> notices = noticeRepository.findAll(pageable);
        // put 메소드를 사용하여 key 설정
        cacheManager.getCache("noticeCache").put("noticeList" + pageable.getPageNumber(), notices);
        return notices;
    }
}
