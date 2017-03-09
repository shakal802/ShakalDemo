package com.example.shak.shakaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.shak.shakaldemo.bean.Book;
import com.example.shak.shakaldemo.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener {
    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt4;
    private GestureDetector mGestureDetector;

    @BindView(R.id.fl) FrameLayout fl;


    @OnClick(R.id.main_timer_bt)
    public void main_timer_btClick(){
    toActivity((TimerActivity.class));
    }

    @OnClick(R.id.main_animation_bt)
    public void main_animation_btClick(){
        toActivity((AnimationActivity.class));
    }

    @OnClick(R.id.main_animator_bt)
    public void main_animator_btClick(){
        toActivity((AnimatorActivity.class));
    }

    @OnClick(R.id.main_quiz_bt)
    public void main_quiz4_btClick(){
        toActivity((Quiz4Activity.class));
    }

//    @OnClick(R.id.main_quiz_bt)
//    public void main_quiz_btClick(){
//
//        Intent intent = new Intent(this,Quiz4Activity.class);
//        startActivityForResult(intent,5);
//    }

    @OnClick(R.id.bt2)
    public void button2Click(){

        Intent intent = new Intent(this,DialogActivity.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);

        mGestureDetector = new GestureDetector(this,new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    private void initialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt4 = (ImageButton) findViewById(R.id.bt4);

    }

    @Override
    protected void onStart(){
        super.onStart();
        toastShort("onStart");
    }


    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(),ViewPagerActivity.class);
                intent.putExtra("key","value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer",12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Yan");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                startActivityForResult(intent,3);
              //  Intent intent = new Intent(v.getContext(),ListViewActivity.class);
              //  startActivity(intent);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(v.getContext(),ActivityA.class);
                startActivityForResult(intent,4);
                //  Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                //  startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort("From ViewPager");
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            case 4:
                toastShort("To Activity");
            case 5:
                toastShort("To Quiz 5");
                break;
            default:
        }
    }

@Override
    public boolean onTouch(View v, MotionEvent event){
    return mGestureDetector.onTouchEvent(event);
}

   private class simpleGestureListener extends
           GestureDetector.SimpleOnGestureListener {

       public boolean onDown(MotionEvent e) {
           UtilLog.logD("MyGesture", "onDown");
           toastShort("onDown");
           return true;
       }

       public void onShowPress(MotionEvent e) {
           toastShort("onShowPress");
       }

       public void onLongPress(MotionEvent e){
           toastShort("onLongPress");
       }

       public boolean onSingleTapUp(MotionEvent e){
           toastShort("onSingleTapUp");
           return true;
       }

       public boolean onSingleTapConfirmed(MotionEvent e){
           toastShort("onSingleTapConfirmed");
           return true;
       }

       public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
           toastShort("onScroll");
           return true;
       }

       public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
           toastShort("onFling");
           return true;
       }

       public boolean onDoubleTap(MotionEvent e) {
           toastShort("onDoubleTap");
           return true;
       }

       public boolean onDoubleTapEvent(MotionEvent e){
           toastShort("onDoubleTapEvent");
           return true;
       }
   }

}

