package id.agung.android.refreshlayout.app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.baoyz.widget.PullRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.agung.android.refreshlayout.R;
import id.agung.android.refreshlayout.app.base.BaseActivity;

public class ListViewActivity extends BaseActivity {
    @BindView(R.id.swipe_refresh_layout)
    PullRefreshLayout mSwipeRefresh;
    @BindView(R.id.listview)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        initToolbar("List View");

        String[] array = new String[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = "Ganteng " + i;
        }

        mListView.setAdapter(new android.widget.ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, array));

        mSwipeRefresh.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefresh.setRefreshing(false);
                    }
                }, 3000);
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
                mSwipeRefresh.setRefreshStyle(PullRefreshLayout.STYLE_MATERIAL);
                return true;
            case R.id.action_circle:
                mSwipeRefresh.setRefreshStyle(PullRefreshLayout.STYLE_CIRCLES);
                return true;
            case R.id.action_water_drop:
                mSwipeRefresh.setRefreshStyle(PullRefreshLayout.STYLE_WATER_DROP);
                return true;
            case R.id.action_ring:
                mSwipeRefresh.setRefreshStyle(PullRefreshLayout.STYLE_RING);
                return true;
            case R.id.action_smartisan:
                mSwipeRefresh.setRefreshStyle(PullRefreshLayout.STYLE_SMARTISAN);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
