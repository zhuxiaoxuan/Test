package app.test;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private List<ImageView> views;
    private VPAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        views = new ArrayList<>();
        viewpager = (ViewPager) findViewById(R.id.viewPager);
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(lp);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (i % 2 == 0) {
                imageView.setImageResource(R.mipmap.ic_launcher);
            } else {
                imageView.setImageResource(R.mipmap.second);
            }
            views.add(imageView);
        }
        adapter = new VPAdapter(this, views);
        viewpager.setAdapter(adapter);
        viewpager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void transformPage(View page, float position) {
                if (position < -1) {

                } else if (position <= 0) {//A页面的变化[0,-1)
//                    page.setPivotX(page.getMeasuredWidth());
//                    page.setPivotY(0);
//                    page.setScaleX(1 + position);
//                    page.setPivotX(page.getMeasuredWidth() / 2);
//                    page.setPivotY(page.getMeasuredHeight() / 2);
//                    page.setRotationY(180 * position);
                } else if (position <= 1) {//B页面的变化[1,0)
//                    page.setPivotX(0);
//                    page.setPivotY(0);
//                    page.setScaleX(1 - position);
//                    page.setPivotX(page.getMeasuredWidth() / 2);
//                    page.setPivotY(page.getMeasuredHeight() / 2);
//                    page.setRotationY(180 * position);
                } else {

                }
            }
        });

    }
}
