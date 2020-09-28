package com.example.presentacioninicioapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.text.HtmlCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    //String infoAbsWorkout=context.getResources().getString(R.string.info_abworkou);

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.fitness1,
            R.drawable.fitnessfeed,
            R.drawable.intermediate
    };

    public String[] slide_headings ={
            "ABS Workout",
            "Nutrición",
            "Aviso legal"

    };

    public int[] slide_content ={

            //context.getResources().getString(R.string.info_abworkou),
            R.string.info_abworkou,
            R.string.info_nutri,
            R.string.info_segur

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (CoordinatorLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_present_app,container,false);

        CollapsingToolbarLayout colapssingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.colapssingToolbar);


        ImageView img_View_present = (ImageView)view.findViewById(R.id.img_View_present);
        TextView txtV_headingPresent = (TextView) view.findViewById(R.id.txtV_headingPresent);
        TextView txtV_contentPresent = (TextView)view.findViewById(R.id.txtV_contentPresent);

        colapssingToolbar.setTitle(slide_headings[position]);
        colapssingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        colapssingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        img_View_present.setImageResource(slide_images[position]);
        //txtV_headingPresent.setText(slide_headings[position]);
        //txtV_contentPresent.setText(slide_content[position]);
        txtV_contentPresent.setText(HtmlCompat.fromHtml(context.getResources().getString(slide_content[position]),HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_DIV));
        //txtV_contentPresent.setText(context.getResources().getString(slide_content[position]));

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((CoordinatorLayout)object);
    }
}
