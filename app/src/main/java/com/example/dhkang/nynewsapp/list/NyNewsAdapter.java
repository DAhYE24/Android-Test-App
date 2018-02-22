package com.example.dhkang.nynewsapp.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dhkang.nynewsapp.ArticleActivity;
import com.example.dhkang.nynewsapp.R;

import java.util.ArrayList;

/**
 * Created by dhkang on 2018-02-20.
 */

public class NyNewsAdapter extends RecyclerView.Adapter<NyNewsAdapter.ItemViewHolder> {
    private static final String LOGO_URL = "http://cfile29.uf.tistory.com/image/156DF3394EFC1EDA1767EC";
    private ArrayList<NyArticleVO> nItems;
    private Context nContext;

    public NyNewsAdapter(ArrayList<NyArticleVO> items) {
        nItems = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        nContext = parent.getContext();
        View view = LayoutInflater.from(nContext).inflate(R.layout.item_recycler_view, parent, false);
        return new ItemViewHolder(view);
    }

    /* Custom ViewHolder */
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSection;
        private TextView tvTitle;
        private TextView tvBrief;
        private ImageView imgNews;

        public ItemViewHolder(View itemView) {  // item_recycler_view의 위젯을 가져와서 binding
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {   // 해당 view를 클릭하면 기사 url로 연결
                    Intent intent = new Intent(nContext, ArticleActivity.class);
                    intent.putExtra("url", nItems.get(getAdapterPosition()).getUrl());
                    nContext.startActivity(intent);
                }
            });
            tvSection = (TextView) itemView.findViewById(R.id.txt_section);
            tvTitle = (TextView) itemView.findViewById(R.id.txt_title);
            tvBrief = (TextView) itemView.findViewById(R.id.txt_brief);
            imgNews = (ImageView) itemView.findViewById(R.id.img_news);
        }
    }

    /* View에 내용을 binding */
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.tvSection.setText(nItems.get(position).getSection());
        holder.tvTitle.setText(nItems.get(position).getTitle());
        holder.tvBrief.setText(nItems.get(position).getAbstract());
        ArrayList<NyMultiVO> nyMultiValues = (ArrayList<NyMultiVO>) nItems.get(position).getMultimedia();
        Glide.with(nContext).load((nyMultiValues.size() > 0)? nyMultiValues.get(2).getUrl() : LOGO_URL).into(holder.imgNews);   // 받아온 json에 imnage url이 없는 경우 뉴욕타임즈 로고로 연결
    }

    @Override
    public int getItemCount() { // 데이터셋의 크기
        return nItems.size();
    }

    /* View에서 해당 item을 지우고 새로운 값을 불러오는 작업 */
    public void enroll(ArrayList<NyArticleVO> articles) {
        nItems.clear();
        nItems.addAll(articles);
        notifyDataSetChanged();
    }
}