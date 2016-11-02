package edu.feicui.testmyrecyclerviewadapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
/**
 * Created by Administrator on 16-11-2.
 */
public class TestAdapter extends RecyclerViewBaseAdapter<Panda> {
    TextView mTvName;
    TextView mTvRace;
    TextView mSpeciality;



    public TestAdapter(Context mContext, ArrayList<Panda> mList, int LayoutId) {
        super(mContext, mList, LayoutId);
    }

    @Override
    public void getView(View view) {
        mTvName = (TextView) view.findViewById(R.id.tv_one);
        mTvRace = (TextView) view.findViewById(R.id.tv_two);
        mSpeciality = (TextView) view.findViewById(R.id.tv_three);

    }

    @Override
    public void setView(Context context, MyHolder holder, int position, Panda panda) {
        mTvName.setText(panda.name);
        mTvRace.setText(panda.race);
        mSpeciality.setText(panda.speciality);
     }
}
