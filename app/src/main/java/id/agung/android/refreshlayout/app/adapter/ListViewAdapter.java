package id.agung.android.refreshlayout.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.agung.android.refreshlayout.R;

/**
 * Created by agung on 07/08/18.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {
    private String[] mArray;
    private Context context;

    public ListViewAdapter(String[] mArray, Context context) {
        this.mArray = mArray;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate
                (android.R.layout.simple_list_item_1, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextView.setText(mArray[position]);
    }

    @Override
    public int getItemCount() {
        return mArray.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
