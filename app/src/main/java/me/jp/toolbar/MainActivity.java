package me.jp.toolbar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<Class> mList = new ArrayList<>();
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.awesome_toolbar);
        setSupportActionBar(toolbar);

        initView();
        initEvent();
    }

    private void initEvent() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,mList.get(i));
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mList.add(ToolbarActivity.class);

        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(new ItemAdapter(this));

    }

    private class ItemAdapter extends BaseAdapter {
        Context mContext;

        public ItemAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int i) {
            return mList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (null == view) {
                view = new TextView(mContext);

            }
            String txt = mList.get(i).getSimpleName();
            ((TextView)view).setPadding(20,20,20,20);
            ((TextView)view).setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
            ((TextView)view).setText(txt);

            return view;
        }
    }

}
