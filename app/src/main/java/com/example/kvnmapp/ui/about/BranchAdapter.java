package com.example.kvnmapp.ui.about;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.kvnmapp.R;

import java.util.List;

public class BranchAdapter extends PagerAdapter {
    private Context context;
    private List<com.example.kvnmapp.ui.about.BranchModel> list;

    public BranchAdapter(Context context, List<BranchModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.brance_item_layout, container, false);

        ImageView brIcon;
        TextView brTitle, brDesc;

        brIcon = view.findViewById(R.id.branch_icon);
        brTitle = view.findViewById(R.id.branch_title);
        brDesc = view.findViewById(R.id.branch_desc);

        brIcon.setImageResource(list.get(position).getImg());

        brTitle.setText(list.get(position).getTitle());
        brDesc.setText(list.get(position).getDescription());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}