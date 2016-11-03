package app.test;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.LruCache;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class MyLruCache extends LruCache{
    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public MyLruCache(int maxSize) {
        super(maxSize);
    }
}
