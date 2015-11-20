package wu.yul.baseadater4recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import wu.yul.baseadater4recyclerview.adapter.BaseViewHolder;
import wu.yul.baseadater4recyclerview.adapter.CommonAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rlv;
    private RecyclerView.LayoutManager mLayoutManager;
    private CommonAdapter mCommonAdapter;
    private List <String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    protected void onResume() {
        super.onResume();
    }

    private void initialize() {

        rlv = (RecyclerView) findViewById(R.id.rlv);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mList = new ArrayList<>();
        for(int i=0;i<10;i++){
            mList.add("TestData"+i);
        }
        mCommonAdapter = new CommonAdapter<String>(mList,R.layout.item_rlv) {
            public void convert(BaseViewHolder holder, String string) {
                holder.setText(R.id.tv,string);
            }
        };
        rlv.setLayoutManager(mLayoutManager);
        rlv.setAdapter(mCommonAdapter);
    }
}
