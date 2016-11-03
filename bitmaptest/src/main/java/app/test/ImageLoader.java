package app.test;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class ImageLoader {
    private LruCache<String, Bitmap> mMemoryCache;
    private DiskLruCache mDiskLruCache;
    private Context mContext;
    private boolean mIsDiskLruCacheCREATED;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private ImageLoader(Context context) {
        mContext = context.getApplicationContext();
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };

//        File disCacheDir = getDiskCacheDir(mContext, "bitmap");
//
//        if (!disCacheDir.exists()) {
//            disCacheDir.mkdir();
//        }

//        if(getUsableSpace(disCacheDir)>DISK_CACHE_SIZE){
//            try{
//                mDiskLruCache=new DiskLruCache().open(disCacheDir,1,1,DISK_CACHE_SIZE);
//                mIsDiskLruCacheCREATED=true;
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
    }

//    private File getDiskCacheDir(Context mContext, String bitmap) {
//    }

}
