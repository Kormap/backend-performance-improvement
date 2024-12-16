//package com.performance.improvement.config;
//
//import org.ehcache.event.CacheEvent;
//import org.ehcache.event.CacheEventListener;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CacheEventLogger implements CacheEventListener<Object, Object> {
//    private static final Logger LOG = LoggerFactory.getLogger(CacheEventLogger.class);
//
//    @Override
//    public void onEvent(CacheEvent cacheEvent) {
//        LOG.info("Cache event = {}, Key = {},  Old value = {}, New value = {}", cacheEvent.getType(),
//                cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
//    }
//}
