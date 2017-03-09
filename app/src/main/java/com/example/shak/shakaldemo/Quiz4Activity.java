package com.example.shak.shakaldemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shak on 2/13/17.
 */

public class Quiz4Activity extends BaseActivity {


    private int checkedID;
    private final int DIALOG = 12345;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case DIALOG:
                    Bundle bundle = msg.getData();
                    String s = bundle.getString("msg");
                    toastShort("Dialog Message:" +s);
                    toastShort("");
                    break;
                default:
            }

            super.handleMessage(msg);

        }
    };

    @BindView(R.id.rdg) RadioGroup radioGroup;
    @OnClick(R.id.dialog_ok)
    public void okClick(){
        switch (checkedID){
            case R.id.rb1:
                toViewPager();
                break;
            case R.id.rb2:
                toListView();
                break;
            default:
        }
    }

    private void toViewPager(){
        toActivity((ViewPagerActivity.class));
    }

    private void toListView(){
        toActivity((ListViewActivity.class));
    }

    @OnClick(R.id.dialog_cancel)
    public void dialog_cancel_btClick(){
        toActivity((MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz4_activity);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;
            }
        });
    }

}
