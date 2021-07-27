package org.tk.spring.ehcache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class EhCacheEventLogger implements CacheEventListener<Object, Object> {

    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        System.out.printf("Cache event %s  %s  %s", cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
