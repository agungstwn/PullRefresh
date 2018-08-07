package id.agung.android.refreshlayout.app.base;

import android.support.annotation.CallSuper;

/**
 * Created by agung on 07/08/18.
 */

public abstract class BasePresenter<V extends BaseView> {
    private V mView;

    @CallSuper
    public void setView(V mView) {
        this.mView = mView;
    }

    protected V getView() {
        return mView;
    }
}
