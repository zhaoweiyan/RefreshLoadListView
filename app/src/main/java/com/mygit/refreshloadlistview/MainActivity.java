package com.mygit.refreshloadlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mygit.refreshloadlistview.utils.LogUtil;
import com.mygit.refreshloadlistview.xlistview.XListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final int FIRST_PAGE = 0;
    @Bind(R.id.list_view)
    XListView xListView;
    @Bind(R.id.iv_empty)
    ImageView iv_empty;

    private int currentPage = FIRST_PAGE;

    private MainActivity mContext;
    private AdapterName adapterName;
    List<NameBean> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        initAdapter();
        initData(FIRST_PAGE);
    }

    private void initData(int i) {
        if (currentPage == FIRST_PAGE) {
            mList.clear();
        }
        for(int j=0;j<10;j++){
            NameBean nameBean = new NameBean();
            nameBean.setName("这个是第" + i+ "页");
            nameBean.setImageUrl("https://avatars2.githubusercontent.com/u/15058217?s=40&v=4");
            mList.add(nameBean);
        }
        onLoad();
        if(mList.size()>0){
            adapterName.setData(mList);
            iv_empty.setVisibility(View.GONE);
            xListView.setVisibility(View.VISIBLE);
        }else{
            iv_empty.setVisibility(View.VISIBLE);
            xListView.setVisibility(View.GONE);
        }
    }

    private void initAdapter() {
        adapterName = new AdapterName(mContext);
        xListView.setAdapter(adapterName);
        xListView.setPullLoadEnable(true);
        xListView.setXListViewListener(xlistViewListner);
    }


 XListView.IXListViewListener xlistViewListner = new XListView.IXListViewListener() {
        @Override
        public void onRefresh() {
            currentPage = FIRST_PAGE;
            initData(FIRST_PAGE);
        }

        @Override
        public void onLoadMore() {
            LogUtil.e("展示展示");
            ++currentPage;
            initData(currentPage);
        }
    };

    private void onLoad() {
        if (xListView != null) {
            xListView.stopRefresh();
            xListView.stopLoadMore();
            xListView.setRefreshTime("刚刚");
        }
    }
}
