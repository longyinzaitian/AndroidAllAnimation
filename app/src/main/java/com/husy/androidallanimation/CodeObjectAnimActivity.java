package com.husy.androidallanimation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CodeObjectAnimActivity extends AppCompatActivity {

    @Bind(R.id.traslate)
    TextView traslate;
    @Bind(R.id.rotate)
    TextView rotate;
    @Bind(R.id.alpha)
    TextView alpha;
    @Bind(R.id.zuhe1)
    TextView zuhe1;
    @Bind(R.id.zuhe2)
    TextView value;
    @Bind(R.id.scale)
    TextView scale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.traslate, R.id.alpha, R.id.rotate,R.id.scale, R.id.zuhe1, R.id.zuhe2})
    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.traslate:
                ObjectAnimator translateA =
                        ObjectAnimator.ofFloat(traslate, "translationX", 300, -200);
                translateA.setDuration(3000);
                translateA.setRepeatCount(1);
                translateA.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Toast.makeText(CodeObjectAnimActivity.this, "开始啦", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(CodeObjectAnimActivity.this, "结束啦", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                translateA.start();
                break;
            case R.id.alpha:
                ObjectAnimator alphaA =
                        ObjectAnimator.ofFloat(alpha, "alpha", 0.2f, 1);
                alphaA.setDuration(3000);
                alphaA.start();
                break;
            case R.id.rotate:
                ObjectAnimator rotateA =
                        ObjectAnimator.ofFloat(rotate, "rotation", 20, 180);
                rotateA.setDuration(3000);
                rotateA.start();
                break;
            case R.id.scale:
                ObjectAnimator scaleA =
                        ObjectAnimator.ofFloat(scale,"scaleX",0.2f,1);
                scaleA.start();
                break;
            case R.id.zuhe1:
                PropertyValuesHolder tx =
                        PropertyValuesHolder.ofFloat("translationX", 300, -200);
                PropertyValuesHolder ty =
                        PropertyValuesHolder.ofFloat("translationY", 50, -10);
                PropertyValuesHolder sx =
                        PropertyValuesHolder.ofFloat("scaleX", 0.1f, 1);
                ObjectAnimator.ofPropertyValuesHolder(zuhe1, tx, ty, sx)
                        .setDuration(3000).start();

                break;
            case R.id.zuhe2:
                final ValueAnimator valueAnimator = ValueAnimator
                        .ofInt(20, 100);
                valueAnimator.setDuration(5000);
                valueAnimator.setTarget(value);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        value.setText(""+(int)animation.getAnimatedValue());
                    }
                });
                valueAnimator.start();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
