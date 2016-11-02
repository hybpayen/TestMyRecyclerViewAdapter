package edu.feicui.testmyrecyclerviewadapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * Created by Han Wenbin on 16-11-2.
 * 封装后的RecyclerView.Adapter
 */
public abstract class RecyclerViewBaseAdapter<T> extends RecyclerView.Adapter<RecyclerViewBaseAdapter.MyHolder> {

    Context mContext;
    //数据源
    ArrayList<T> mList;
    //布局填充器
    LayoutInflater mInflater;
    //子条目布局View
    View view;
    //子条目布局ID
    int LayoutId;
    public RecyclerViewBaseAdapter(Context mContext,ArrayList<T> mList,int LayoutId) {
        this.mContext = mContext;
        this.mList = mList;
        this.LayoutId = LayoutId;
        //初始化布局填充器
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 将子条目布局转化成view，初始化ViewHolder
     * @param parent    子条目所在的RecyclerView
     * @param viewType  The view type of the new View.
     * @return  holder
     */
    @Override
    public RecyclerViewBaseAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = mInflater.inflate(LayoutId, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    /**
     *
     * @param holder  onCreateViewHolder(ViewGroup parent, int viewType)返回的holder
     * @param position  子View的下标
     */
    @Override
    public void onBindViewHolder(RecyclerViewBaseAdapter.MyHolder holder, int position) {
        setView(mContext,holder,position,mList.get(position));
        //给每一个子View绑定点击事件
        holder.itemView.setOnClickListener(new MyOnClickListener(holder,position));
    }

    /**
     * @return  子条目数量
     */
    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    /**
     * 自定义ViewHolder类
     */
    class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
            getView(itemView);
        }
    }

    /**
     * 初始化控件的方法
     * @param view  子条目布局转化的View，即控件所在的子View
     */
    public abstract void getView(View view);

    /**
     * 渲染控件的方法
     * @param context  上下文场景
     * @param holder   所要渲染的控件所在的holder
     * @param position  控件所在的子View下标
     * @param t  实体的对象
     */
    public abstract void setView(Context context,MyHolder holder,int position,T t);

    /**
     * OnClickListener接口的实现类
     */
    public class MyOnClickListener implements View.OnClickListener {
        MyHolder mHolder;
        int position;
        public MyOnClickListener(MyHolder mHolder,int position) {
            this.mHolder = mHolder;
            this.position = position;
        }

        @Override

        public void onClick(View v) {
            mListener.onItemClick(v,mHolder,position);
        }
    }


    OnItemClickListener mListener;

    /**
     * 为外界提供响应点击事件的方法
     * @param mListener
     */
    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }
    /**
     * 自定义接口，采用回调的方式做点击事件的响应
     */
    public interface OnItemClickListener {
        void onItemClick(View v,RecyclerViewBaseAdapter.MyHolder holder,int position);

    }


}
