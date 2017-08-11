package com.example.objectanimatort;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ObjectAnimator alphaAni, rotationApi, rotationXApi, rotationYApi, translationXApi, translationYApi, scaleXApi, scaleYApi,circleAni,circlebgApi;
    private TextView tv_alpha, tv_rotation, tv_rotationX, tv_rotationY, tv_translationX, tv_translationY, tv_scaleX, tv_scaleY;
    private CircleView circleView;
    private AnimatorSet set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initAnim();
    }

    private void initListener() {
        tv_alpha.setOnClickListener(this);
        tv_rotation.setOnClickListener(this);
        tv_rotationX.setOnClickListener(this);
        tv_rotationY.setOnClickListener(this);
        tv_translationX.setOnClickListener(this);
        tv_translationY.setOnClickListener(this);
        tv_scaleX.setOnClickListener(this);
        tv_scaleY.setOnClickListener(this);
        circleView.setOnClickListener(this);
    }

    private void initView() {
        tv_alpha = (TextView) findViewById(R.id.tv_alpha);
        tv_rotation = (TextView) findViewById(R.id.tv_rotation);
        tv_rotationX = (TextView) findViewById(R.id.tv_rotationX);
        tv_rotationY = (TextView) findViewById(R.id.tv_rotationY);
        tv_translationX = (TextView) findViewById(R.id.tv_translationX);
        tv_translationY = (TextView) findViewById(R.id.tv_translationY);
        tv_scaleX = (TextView) findViewById(R.id.tv_scaleX);
        tv_scaleY = (TextView) findViewById(R.id.tv_scaleY);
        circleView= (CircleView) findViewById(R.id.circleView);
    }

    private void initAnim() {
        alphaAni = ObjectAnimator.ofFloat(tv_alpha, "alpha", 1, 0, 1);
        alphaAni.setDuration(3000);
        rotationApi = ObjectAnimator.ofFloat(tv_rotation, "rotation", 0, 180);
        rotationApi.setDuration(2000);
        rotationXApi = ObjectAnimator.ofFloat(tv_rotationX, "rotationX", 0, 180, 0);
        rotationXApi.setDuration(2000);
        rotationXApi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                if (value > 90) {
                    tv_rotationX.setText("翻页了");

                } else {
                    tv_rotationX.setText("rotationX");
                }
            }
        });
        rotationXApi.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        rotationYApi = ObjectAnimator.ofFloat(tv_rotationY, "rotationY", 0, 360);
        rotationYApi.setDuration(2000);
        translationXApi = ObjectAnimator.ofFloat(tv_translationX, "translationX", 0, 200, -200, 0);
        translationXApi.setDuration(2000);
        translationYApi = ObjectAnimator.ofFloat(tv_translationY, "translationY", 0, 200, -200, 0);
        translationYApi.setDuration(2000);
        scaleXApi = ObjectAnimator.ofFloat(tv_scaleX, "scaleX", 1, 3, 1);
        scaleXApi.setDuration(2000);
        scaleYApi = ObjectAnimator.ofFloat(tv_scaleY, "scaleY", 1, 3, 1);
        scaleYApi.setDuration(2000);
        circleAni=ObjectAnimator.ofInt(circleView,"pointRadius",100,200,300,200,100);
        circlebgApi=ObjectAnimator.ofInt(circleView,"pointColor",0xffff00ff, 0xffffff00, 0xffff00ff);
        set=new AnimatorSet();
        set.setDuration(3000);
        set.play(circleAni).with(circlebgApi);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_alpha:
                alphaAni.start();
                break;
            case R.id.tv_rotation:
                rotationApi.start();
                break;
            case R.id.tv_rotationX:
                rotationXApi.start();
                break;
            case R.id.tv_rotationY:
                rotationYApi.start();
                break;
            case R.id.tv_translationX:
                translationXApi.start();
                break;
            case R.id.tv_translationY:
                translationYApi.start();
                break;
            case R.id.tv_scaleX:
                scaleXApi.start();
                break;
            case R.id.tv_scaleY:
                scaleYApi.start();
                break;
            case R.id.circleView:
                set.start();
                break;
        }
    }
}
