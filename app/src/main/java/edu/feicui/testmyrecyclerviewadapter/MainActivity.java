package edu.feicui.testmyrecyclerviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static edu.feicui.testmyrecyclerviewadapter.R.layout.item_rec;

public class MainActivity extends AppCompatActivity implements RecyclerViewBaseAdapter.OnItemClickListener {
    RecyclerView mRecyclerView;
    ArrayList<Panda> mList;
    TestAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onContentChanged() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rec_main);
        mList = new ArrayList<>();
        for (int i=0;i<10;i++) {
            Panda panda = new Panda();
            panda.name = "熊猫";
            panda.race = "兽族";
            panda.speciality = "卖萌";
            mList.add(panda);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TestAdapter(this, mList, item_rec);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(View v, RecyclerViewBaseAdapter.MyHolder holder, int position) {
        Toast.makeText(this, "大熊猫是一种明明可以靠实力吃饭，却偏偏靠卖萌征服世界的动物", Toast.LENGTH_LONG).show();
    }
}
