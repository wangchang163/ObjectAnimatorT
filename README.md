# ObjectAnimatorT
ObjectAnimator动画的使用以及注意点

ObjectAnimator直接与控件绑定，继承自ValueAnimator，能够使用ValueAnimator的所有方法，并重写ofInt，ofFloat方法等

ObjectAnimator可以根据控件拥有的setXXX方法，来改变这个setXXX值，从而达到动画效果，

ValueAnimator主要通过改变控件属性来达到动画效果，二者还是有不同之处。

ObjectAnimator参数分别是绑定的控件，控件的属性，以及控件属性要改变的值

效果：

![image](https://github.com/wangchang163/ObjectAnimatorT/blob/master/images/objectanimator.gif）

透明度：

    alphaAni = ObjectAnimator.ofFloat(tv_alpha, "alpha", 1, 0, 1);
    
旋转

    rotationApi = ObjectAnimator.ofFloat(tv_rotation, "rotation", 0, 180);
    //x轴旋转
    rotationXApi = ObjectAnimator.ofFloat(tv_rotationX, "rotationX", 0, 180, 0);
    //y轴旋转
     rotationYApi = ObjectAnimator.ofFloat(tv_rotationY, "rotationY", 0, 360);
    
位移：

    //x轴位移
    translationXApi = ObjectAnimator.ofFloat(tv_translationX, "translationX", 0, 200, -200, 0);
    //y轴位移
    translationYApi = ObjectAnimator.ofFloat(tv_translationY, "translationY", 0, 200, -200, 0);
    
    //z轴位移

缩放：
     
     //x轴缩放
     scaleXApi = ObjectAnimator.ofFloat(tv_scaleX, "scaleX", 1, 3, 1);
     //y轴缩放
     scaleYApi = ObjectAnimator.ofFloat(tv_scaleY, "scaleY", 1, 3, 1);
     
     
对于自定义控件，没有的属性怎么处理？-------------------------自定义属性

例如自定义一个圆，先去设置圆的属性类，这里包含半径，颜色

    package com.example.objectanimatort;
  
    /**
    * Created by Administrator on 2017/8/11.
    */
  
    public class Point {
  
      private int radius;
      private int backgroundColor;
  
      public Point(int radius) {
          this.radius = radius;
      }
  
      public int getRadius() {
          return radius;
      }
  
      public void setRadius(int radius) {
          this.radius = radius;
      }
  
      public int getBackgroundColor() {
          return backgroundColor;
      }
  
      public void setBackgroundColor(int backgroundColor) {
          this.backgroundColor = backgroundColor;
      }
    }
    
    
我们在画圆的时候设置圆的set属性

    private Point point=new Point(100);
    private Paint paint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(point!=null){
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,point.getRadius(),paint);
        }
    }
    void setPointRadius(int radius){
        point.setRadius(radius);
        invalidate();
    }
    void setPointColor(int color){
        paint.setColor(color);
        invalidate();
    }

调用：

        circleAni=ObjectAnimator.ofInt(circleView,"pointRadius",100,200,300,200,100);
        circlebgApi=ObjectAnimator.ofInt(circleView,"pointColor",0xffff00ff, 0xffffff00, 0xffff00ff);
        set=new AnimatorSet();
        set.setDuration(3000);
        set.play(circleAni).with(circlebgApi);
   
以上学习自启舰的博客：http://blog.csdn.net/harvic880925/article/details/50995268