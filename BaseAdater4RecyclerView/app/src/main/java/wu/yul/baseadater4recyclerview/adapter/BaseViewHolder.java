package wu.yul.baseadater4recyclerview.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import wu.yul.baseadater4recyclerview.utils.CircleTransform;
import wu.yul.baseadater4recyclerview.utils.RoundTransform;

/**
 * Project Name：BaseAdater4RecyclerView
 * Describe：
 * Created By：yul
 * Modify：yul
 * Modify Time：4:49 PM
 * Remark：
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private int position;
    private final SparseArray<View> views;
    private View rootView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        position = getLayoutPosition();
        rootView = itemView;
        views = new SparseArray<>();
    }

    public <T extends View> T getView(int viewID) {
        View view = views.get(viewID);
        if (null == view) {
            view = rootView.findViewById(viewID);
            views.put(viewID, view);
        }
        return (T) view;
    }

    public BaseViewHolder setText(int viewID, int resID) {
        TextView view = getView(resID);
        view.setText(resID);
        return this;
    }

    public BaseViewHolder setText(int viewID, String text) {
        TextView view = getView(viewID);
        view.setText(text);
        return this;
    }

    /**
     * @param viewId
     * @param text
     * @return
     */
    public BaseViewHolder setChbText(int viewId, String text) {
        CheckBox view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为TextView设置字体颜色
     *
     * @param viewId
     * @param color
     * @return
     */
    public BaseViewHolder setTextColor(int viewId, int color) {
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    /**
     * 为TextView设置背景色
     *
     * @param viewId
     * @param color
     * @return
     */
    public BaseViewHolder setTextBackgroundColor(int viewId, int color) {
        TextView view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * 为TextView设置背景色
     *
     * @param viewId
     * @param color
     * @return
     */
    public BaseViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public BaseViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param bm
     * @return
     */
    public BaseViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param url
     * @return
     */
    public BaseViewHolder setImageByUrl(int viewId, String url) {
        Glide.with(mContext).load(url).centerCrop().into((ImageView) getView
                (viewId));
        //ImageLoader.getInstance().displayImage(url, (ImageView) getView(viewId));
        return this;
    }


    /**
     * 为ImageView设置圆形图片
     *
     * @param viewId
     * @param url
     * @return
     */
    public BaseViewHolder setImageByUrlToRound(int viewId, String url) {
        Glide.with(mContext).load(url).asBitmap().centerCrop().
                transform(new CircleTransform
                        (mContext)).into((ImageView) getView(viewId));
        return this;
    }


    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param url
     * @return
     */
    public BaseViewHolder setImageByUrl(int viewId, String url, int size) {
        ImageView imageView = getView(viewId);
        //Glide.with(mContext).load(url).placeholder(R.drawable.ic_place_holder).centerCrop().override(size, size)
        // .into(imageView);
        Glide.with(mContext).load(url).centerCrop().into(imageView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = size;
        layoutParams.height = size;
        imageView.requestLayout();
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param url
     * @return
     */
    public BaseViewHolder setRoundImageByUrl(int viewId, String url, int size, int dp) {
        ImageView imageView = getView(viewId);
        //Glide.with(mContext).load(url).placeholder(R.drawable.ic_place_holder).centerCrop().override(size, size)
        // .into(imageView);
        Glide.with(mContext).load(url).transform(new RoundTransform(mContext, dp))
                .centerCrop().into(imageView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = size;
        layoutParams.height = size;
        imageView.requestLayout();
        return this;
    }

    /**
     * Add links into a TextView.
     *
     * @param viewId The id of the TextView to linkify.
     * @return The ViewHolder for chaining.
     */
    public BaseViewHolder linkify(int viewId) {
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    /**
     * Sets the progress of a ProgressBar.
     *
     * @param viewId   The view id.
     * @param progress The progress.
     * @return The ViewHolder for chaining.
     */
    public BaseViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }

    /**
     * Sets the progress and max of a ProgressBar.
     *
     * @param viewId   The view id.
     * @param progress The progress.
     * @param max      The max value of a ProgressBar.
     * @return The ViewHolder for chaining.
     */
    public BaseViewHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    /**
     * Sets the range of a ProgressBar to 0...max.
     *
     * @param viewId The view id.
     * @param max    The max value of a ProgressBar.
     * @return The ViewHolder for chaining.
     */
    public BaseViewHolder setMax(int viewId, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    /**
     * Sets the rating (the number of stars filled) of a RatingBar.
     *
     * @param viewId The view id.
     * @param rating The rating.
     * @return The ViewHolder for chaining.
     */
    public BaseViewHolder setRating(int viewId, float rating) {
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    public BaseViewHolder setVisibility(int viewId, int status) {
        View view = getView(viewId);
        view.setVisibility(status);
        return this;
    }

    /**
     * Sets the rating (the number of stars filled) and max of a RatingBar.
     *
     * @param viewId The view id.
     * @param rating The rating.
     * @param max    The range of the RatingBar to 0...max.
     * @return The ViewHolder for chaining.
     */
    public BaseViewHolder setRating(int viewId, float rating, int max) {
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    public BaseViewHolder setWidth(int viewId, int size) {
        View v = getView(viewId);
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        layoutParams.width = size;
        v.requestLayout();
        return this;
    }

    public BaseViewHolder setChecked(int chDefault, boolean b) {
        CheckBox box = getView(chDefault);
        box.setChecked(b);
        return this;
    }

    public BaseViewHolder setTypeface(int viewId, int type) {
        TextView tv = getView(viewId);
        tv.setTypeface(Typeface.MONOSPACE, type);
        return this;
    }

    public BaseViewHolder setFlags(int viewId, int flag) {
        TextView tv = getView(viewId);
        tv.getPaint().setFlags(flag);
        return this;
    }
}
