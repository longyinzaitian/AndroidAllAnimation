package com.husy.androidallanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XmlViewActivity extends AppCompatActivity {

    @Bind(R.id.alpha)
    TextView alpha;
    @Bind(R.id.scale)
    TextView scale;
    @Bind(R.id.traslate)
    TextView traslate;
    @Bind(R.id.rotate)
    TextView rotate;
    @Bind(R.id.all_ani)
    TextView allAni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.alpha, R.id.scale, R.id.traslate, R.id.rotate, R.id.all_ani})
    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.alpha:
                Animation alpha_animation = AnimationUtils
                        .loadAnimation(XmlViewActivity.this, R.anim.alpha);
                alpha.startAnimation(alpha_animation);
                break;
            case R.id.scale:
                Animation scale_animation = AnimationUtils
                        .loadAnimation(XmlViewActivity.this, R.anim.scale);
                scale.startAnimation(scale_animation);
                break;
            case R.id.traslate:
                Animation traslate_animation = AnimationUtils
                        .loadAnimation(XmlViewActivity.this, R.anim.traslate);
                traslate.startAnimation(traslate_animation);
                break;
            case R.id.rotate:
                Animation rotate_animation = AnimationUtils
                        .loadAnimation(XmlViewActivity.this, R.anim.rotate);
                rotate.startAnimation(rotate_animation);
                break;
            case R.id.all_ani:
                Animation all_animation = AnimationUtils
                        .loadAnimation(XmlViewActivity.this,R.anim.all);
                allAni.startAnimation(all_animation);
                all_animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(XmlViewActivity.this, "开始啦。", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(XmlViewActivity.this,"结束啦。。。。。。",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
