package id.agung.android.refreshlayout.app;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.baoyz.widget.PullRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.agung.android.refreshlayout.R;
import id.agung.android.refreshlayout.app.adapter.RecyclerViewAdapter;
import id.agung.android.refreshlayout.app.base.BaseActivity;

public class RecyclerViewActivity extends BaseActivity {

    @BindView(R.id.recyclerview)
    RecyclerView mRecylerview;
    @BindView(R.id.swipe_refresh_layout)
    PullRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initToolbar("Recycler View");
        ButterKnife.bind(this);

        mRecylerview.setLayoutManager(new LinearLayoutManager(this));
        String[] array = new String[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = "Ganteng " + i;
        }
        mRecylerview.setAdapter(new RecyclerViewAdapter(array, this));

        mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 4000);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_material:
                mSwipeRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_MATERIAL);
                return true;
            case R.id.action_circle:
                mSwipeRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_CIRCLES);
                return true;
            case R.id.action_water_drop:
                mSwipeRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_WATER_DROP);
                return true;
            case R.id.action_ring:
                mSwipeRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
                return true;
            case R.id.action_smartisan:
                mSwipeRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_SMARTISAN);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
