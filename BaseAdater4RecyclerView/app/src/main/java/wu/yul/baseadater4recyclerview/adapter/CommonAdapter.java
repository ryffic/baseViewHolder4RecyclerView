package wu.yul.baseadater4recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import wu.yul.baseadater4recyclerview.R;

/**
 * Project Name：BaseAdater4RecyclerView
 * Describe：
 * Created By：yul
 * Modify：yul
 * Modify Time：4:13 PM
 * Remark：
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    public List<T> mDataSet;
    public final int resID;

    public CommonAdapter(List<T> list, int resID) {
        mDataSet = list;
        this.resID = resID;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resID, parent, false);
        return new BaseViewHolder(view);
    }

    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, mDataSet.get(position));

    }

    public abstract void convert(BaseViewHolder holder, T t);

    public int getItemCount() {
        return mDataSet.size();
    }

}
