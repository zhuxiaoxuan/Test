package app.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webview;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webView1);
//
        //webview.reload();// reload page

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG, "shouldOverrideUrlLoading: url:" + url);
                view.loadUrl(url);
                return true;
            }
        });

        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
//                titleview.setText(title);//a textview
                Log.i(TAG, "onReceivedTitle: title:" + title);
            }
        });
        webview.setDownloadListener(new MyDownloadListenter());

        webview.loadUrl("http://www.baidu.com/");
    }

    class MyDownloadListenter implements DownloadListener {

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            Log.i(TAG, "onDownloadStart: url ==== >" + url);
            new HttpThread(url).start();
        }
    }
}
