package id.agung.android.refreshlayout.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.agung.android.refreshlayout.R;
import id.agung.android.refreshlayout.app.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;
    @BindView(R.id.textview)
    TextView textView;
    @BindView(R.id.m_btn_progressbar)
    Button mBtnProgressbar;

    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        homeToolbar("Home");

        mBtnProgressbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressStatus = 0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100){
                            progressStatus += 1;
                            try {
                                Thread.sleep(20);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar.setProgress(progressStatus);
                                    textView.setText(progressStatus + "");
                                }
                            });
                        }
                    }
                }).start();
            }
        });
    }

    @OnClick({R.id.m_btn_listview, R.id.m_btn_recyclerview, R.id.m_btn_scrollview})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.m_btn_listview:
                startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.m_btn_recyclerview:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.m_btn_scrollview:
                startActivity(new Intent(this, ScrollViewActivity.class));
                break;
        }

    }
}
