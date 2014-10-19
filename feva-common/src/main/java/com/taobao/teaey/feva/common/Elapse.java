package com.taobao.teaey.feva.common;

/**
 * @author teaey masfay@163.com
 * @date 2014-05-23
 * @since 1.0.0.0
 */
public class Elapse {
    static final class LocalCache {
        long start;
    }

    private static final ThreadLocal<LocalCache> timestamp = new ThreadLocal<LocalCache>() {
        @Override
        protected LocalCache initialValue() {
            return new LocalCache();
        }
    };
    private static final ThreadLocal<LocalCache> timestampNanos = new ThreadLocal<LocalCache>() {
        @Override
        protected LocalCache initialValue() {
            return new LocalCache();
        }
    };

    public static final void p() {
        timestamp.get().start = System.currentTimeMillis();
    }

    public static final long q() {
        return System.currentTimeMillis() - timestamp.get().start;
    }

    public static final void pn() {
        timestamp.get().start = System.nanoTime();
    }

    public static final long qn() {
        return System.nanoTime() - timestampNanos.get().start;
    }
}
