package com.example.presentacioninicioapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPagerPresent;
    private LinearLayout pointLayout;

    private TextView[] linearPoint;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerPresent = (ViewPager)findViewById(R.id.viewPagerPresent);
        pointLayout = (LinearLayout)findViewById(R.id.linearPoint);

        sliderAdapter = new SliderAdapter(this);
        viewPagerPresent.setAdapter(sliderAdapter);

        addLinearPoint(0);
        viewPagerPresent.addOnPageChangeListener(viewListener);

    }

    public void addLinearPoint(int position){
        linearPoint = new TextView[3];
        pointLayout.removeAllViews();
        for (int i=0; i< linearPoint.length; i++){
            linearPoint [i]= new TextView(this);
            linearPoint [i].setText(Html.fromHtml("<span style=letter-spacing:3px>&#8226;</span> "));
            linearPoint [i].setTextSize(33);
            linearPoint [i].setTextColor(getResources().getColor(R.color.colorTransparentEhite));

            pointLayout.addView(linearPoint[i]);
        }
        if (linearPoint.length>0){
            linearPoint[position].setTextColor(getResources().getColor(R.color.ColorFondo));
            linearPoint[position].setTextSize(35);
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {

            addLinearPoint(i);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}