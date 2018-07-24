package com.mygit.refreshloadlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mygit.refreshloadlistview.utils.LogUtil;
import com.mygit.refreshloadlistview.utils.Utils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2018/7/24.
 */

public class AdapterName extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<NameBean> mList;

    public AdapterName(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    public void setData(List<NameBean> s) {
        mList = s;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList == null ? null : mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NameHolder nameHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_name_img, null);
            nameHolder = new NameHolder(convertView);
            convertView.setTag(nameHolder);
        } else {
            nameHolder = (NameHolder) convertView.getTag();
        }

        NameBean nameBean = (NameBean) getItem(position);
        if (nameBean != null) {
            if (Utils.notEmpty(nameBean.getName())) {
                nameHolder.nameView.setText(nameBean.getName());
            } else {
                nameHolder.nameView.setText("");
            }

            if (Utils.notEmpty(nameBean.getImageUrl())) {
                Utils.setImgAndGif(mContext, nameBean.getImageUrl(), nameHolder.imageView, R.mipmap.ic_launcher, 500, 220);
            } else {
                nameHolder.imageView.setImageResource(R.mipmap.ic_launcher);
            }
        }else{
            LogUtil.e("为空");
        }

        return convertView;
    }


    static class NameHolder {
        public NameHolder(View view) {
            ButterKnife.bind(this, view);
        }

        @Bind(R.id.name)
        TextView nameView;
        @Bind(R.id.image_view)
        ImageView imageView;
    }
}
