package id.agung.android.refreshlayout.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import id.agung.android.refreshlayout.R;
import id.agung.android.refreshlayout.app.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        homeToolbar("Home");
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
