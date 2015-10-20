package com.husy.androidallanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.code_animation)
    TextView codeAnimation;
    @Bind(R.id.xml_animation)
    TextView xmlAnimation;
    @Bind(R.id.object_animator)
    TextView objectAnimator;
    @Bind(R.id.xml_object_animator)
    TextView xmlObjectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.code_animation, R.id.xml_animation, R.id.object_animator,R.id.xml_object_animator})
    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.code_animation:
                startActivity(new Intent(MainActivity.this
                        , CodeViewAnimation.class));
                break;
            case R.id.xml_animation:
                startActivity(new Intent(MainActivity.this,
                        XmlViewActivity.class));
                break;
            case R.id.object_animator:
                startActivity(new Intent(MainActivity.this,
                        CodeObjectAnimActivity.class));
                break;
            case R.id.xml_object_animator:
                startActivity(new Intent(MainActivity.this,
                        XMLAnimatorActivity.class));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
