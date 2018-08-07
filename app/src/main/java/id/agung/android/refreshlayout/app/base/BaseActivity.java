package id.agung.android.refreshlayout.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import id.agung.android.refreshlayout.R;

/**
 * Created by agung on 07/08/18.
 */

public abstract class BaseActivity <V extends BasePresenter> extends AppCompatActivity implements BaseView{

    protected V presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initToolbar(String title) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        ((TextView) findViewById(R.id.title)).setText(title);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    public void homeToolbar(String title){
        Toolbar toolbar = findViewById(R.id.toolbar);
        ((TextView) findViewById(R.id.title)).setText(title);
        toolbar.setTitle("");
    }

    public void initToolbar(String title, boolean isShowBackButton) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        ((TextView) findViewById(R.id.title)).setText(title);
        toolbar.setTitle("");
        if (isShowBackButton) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
            toolbar.setNavigationOnClickListener(view -> onBackPressed());
        } else {
            toolbar.setNavigationIcon(null);
        }
        setSupportActionBar(toolbar);
    }
}
