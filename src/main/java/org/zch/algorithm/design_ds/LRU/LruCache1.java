package org.zch.algorithm.design_ds.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 参考：org.apache.ibatis.cache.decorators.LruCache
 */
public class LruCache1 {
    int capacity;
    private Map<Object, Object> cache;
    private Object eldestKey;

    public LruCache1(int capacity) {
        setSize(capacity);
    }

    public int getSize() {
        return cache.size();
    }

    public void setSize(final int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Object, Object>(capacity, .75F, true) {
            private static final long serialVersionUID = 4267176411845948333L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                boolean tooBig = size() > capacity;
                if (tooBig) {
                    eldestKey = eldest.getKey();
                }
                return tooBig;
            }
        };
    }

    public void putObject(Object key, Object value) {
        cache.put(key, value);
    }

    public Object getObject(Object key) {
        return cache.get(key); //touch
    }
}
