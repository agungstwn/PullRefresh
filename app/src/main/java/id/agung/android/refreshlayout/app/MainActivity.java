package id.agung.android.refreshlayout.app;

import android.os.Bundle;

import id.agung.android.refreshlayout.R;
import id.agung.android.refreshlayout.app.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar("Home");
    }
}
