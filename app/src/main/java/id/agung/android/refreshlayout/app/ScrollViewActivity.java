package id.agung.android.refreshlayout.app;

import android.graphics.Color;
import android.os.Bundle;

import com.baoyz.widget.PullRefreshLayout;
import com.baoyz.widget.SmartisanDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.agung.android.refreshlayout.R;
import id.agung.android.refreshlayout.app.base.BaseActivity;

public class ScrollViewActivity extends BaseActivity {

    @BindView(R.id.swipe_refresh_layout)
    PullRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        initToolbar("Scroll View");
        ButterKnife.bind(this);

        mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        mSwipeRefreshLayout.setColorSchemeColors(Color.BLUE);
        mSwipeRefreshLayout.setRefreshDrawable(new SmartisanDrawable(this, mSwipeRefreshLayout));
    }
}
