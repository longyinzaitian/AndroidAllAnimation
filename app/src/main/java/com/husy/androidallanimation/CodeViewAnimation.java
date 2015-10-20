package com.husy.androidallanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CodeViewAnimation extends AppCompatActivity implements View.OnClickListener {

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

    @OnClick({R.id.alpha, R.id.scale, R.id.traslate, R.id.rotate,R.id.all_ani})
    public void onClick(View v) {
        Log.i("dd", "onclick");
        switch (v.getId()) {
            case R.id.alpha:
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1);
                alphaAnimation.setDuration(3000);
                //加减速差值器
                alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                alpha.startAnimation(alphaAnimation);
                break;
            case R.id.rotate:
                //不指定中心，则默认组件原点为中心
//                RotateAnimation rotateAnimation = new RotateAnimation(0,360);
                //指定中心。
//                RotateAnimation rotateAnimation = new RotateAnimation(0,360,rotate.getWidth()/2,rotate.getHeight()/2);
                //指定旋转中心的类型
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(2000);
                //加速差值器
                rotateAnimation.setInterpolator(new AccelerateInterpolator());
                rotate.startAnimation(rotateAnimation);
                break;
            case R.id.traslate:
                TranslateAnimation translateAnimation = new TranslateAnimation(30, 90, 30, 90);
                translateAnimation.setDuration(3000);
                traslate.startAnimation(translateAnimation);
                break;
            case R.id.scale:
                //默认组件原点为中心
//                ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f,1,0.2f,1);

                //指定为组件的中心
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 1, 0.2f, 1, scale.getWidth() / 2, scale.getHeight() / 2);
                scaleAnimation.setDuration(3000);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(CodeViewAnimation.this,"开始啦。",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(CodeViewAnimation.this,"结束啦。",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                scale.startAnimation(scaleAnimation);
                break;
            case R.id.all_ani:
                Log.i("dd", "allani");
                AlphaAnimation alphaAnimation1 = new AlphaAnimation(0.3f,1f);
                alphaAnimation1.setDuration(5000);
                ScaleAnimation scaleAnimation1 = new ScaleAnimation(0,1,0,1,allAni.getWidth()/2,allAni.getHeight()/2);
                scaleAnimation1.setDuration(5000);
                RotateAnimation rotateAnimation1 = new RotateAnimation(0,360,allAni.getWidth()/2,allAni.getHeight()/2);
                rotateAnimation1.setDuration(5000);
                AnimationSet set = new AnimationSet(true);
                set.addAnimation(alphaAnimation1);
                set.addAnimation(scaleAnimation1);
                set.addAnimation(rotateAnimation1);
                set.setFillEnabled(true);
                set.setDuration(2000);
                set.setRepeatCount(0);
                allAni.startAnimation(set);
                set.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(CodeViewAnimation.this,"开始啦。",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(CodeViewAnimation.this,"结束啦。",Toast.LENGTH_SHORT).show();
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
