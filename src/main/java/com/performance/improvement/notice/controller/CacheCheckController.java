package com.performance.improvement.notice.controller;

import com.performance.improvement.notice.model.entity.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cache")
public class CacheCheckController {

    private final CacheManager cacheManager;

    Logger logger = Logger.getLogger(CacheCheckController.class.getName());

    @GetMapping("/notice")
    public Object getCachedNotice() {
        Cache cache = cacheManager.getCache("noticeCache");
        if (cache != null) {
            Cache.ValueWrapper valueWrapper = cache.get("noticeList");  // "noticeList" key로 데이터 조회
            if (valueWrapper != null) {
                logger.info("==============> 캐시된 데이터 조회 완료(notice cache hit)");
                return (List<Notice>) valueWrapper.get();  // 캐시에서 반환된 값은 List<Notice> 타입으로 변환
            }else {
                logger.info("==============> 캐시된 데이터 조회 실패!!! (notice cache read failed)");
            }
        }
        return new ArrayList<>();  // 캐시에서 값을 못 찾으면 빈 리스트 반환
    }

    @GetMapping("/notice/{pageNum}")
    public Object getCachedPageNotice(@PathVariable int pageNum) {
        Cache cache = cacheManager.getCache("noticeCache");
        if (cache != null) {
            Cache.ValueWrapper valueWrapper = cache.get("noticeList" + pageNum);  // "noticeList" key로 데이터 조회
            if (valueWrapper != null) {
                logger.info("==============> 캐시된 데이터 조회 완료(notice cache hit)");
                return (Page<Notice>) valueWrapper.get();  // 캐시에서 반환된 값은 List<Notice> 타입으로 변환
            }else {
                logger.info("==============> 캐시된 데이터 조회 실패!!! (notice cache read failed)");
            }
        }
        return new ArrayList<>();  // 캐시에서 값을 못 찾으면 빈 리스트 반환
    }
}
