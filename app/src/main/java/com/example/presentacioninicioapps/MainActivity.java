package com.example.presentacioninicioapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPagerPresent;
    private LinearLayout pointLayout;
    private Button btnNext,btnBack;
    private int currentPage;


    private TextView[] linearPoint;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerPresent = (ViewPager)findViewById(R.id.viewPagerPresent);
        pointLayout = (LinearLayout)findViewById(R.id.linearPoint);
        btnNext = (Button)findViewById(R.id.btn_next);
        btnBack = (Button)findViewById(R.id.btn_back);

        sliderAdapter = new SliderAdapter(this);
        viewPagerPresent.setAdapter(sliderAdapter);

        addLinearPoint(0);
        viewPagerPresent.addOnPageChangeListener(viewListener);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentPage<=0){
                    viewPagerPresent.setCurrentItem(currentPage+1);

                }else if (currentPage == linearPoint.length-1){
                    //viewPagerPresent.setCurrentItem(currentPage+1);
                    SharedPreferences datos1 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    SharedPreferences.Editor miEditor1 = datos1.edit();

                    miEditor1.putString("bandera","1");
                    miEditor1.apply();
                    finish();
                    //Toast.makeText(MainActivity.this,"pagina: " + currentPage,Toast.LENGTH_SHORT).show();

                }else{
                    viewPagerPresent.setCurrentItem(currentPage+1);
                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerPresent.setCurrentItem(currentPage-1);
            }
        });


    }

    public void addLinearPoint(int position){
        linearPoint = new TextView[3];
        pointLayout.removeAllViews();
        for (int i=0; i< linearPoint.length; i++){
            linearPoint [i]= new TextView(this);
            linearPoint [i].setText(Html.fromHtml("<span style=letter-spacing:3px>&#8226;</span> "));
            linearPoint [i].setTextSize(32);
            linearPoint [i].setTextColor(getResources().getColor(R.color.colorIcon));

            pointLayout.addView(linearPoint[i]);
        }
        if (linearPoint.length>0){
            linearPoint[position].setTextColor(getResources().getColor(R.color.colorWhite));
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
            currentPage = i;

            if (i<=0){
                btnNext.setEnabled(true);
                btnNext.setVisibility(View.VISIBLE);
                btnBack.setVisibility(View.INVISIBLE);
                btnNext.setText("Siguiente");

            }else if (i == linearPoint.length-1){
                btnNext.setEnabled(true);
                btnNext.setVisibility(View.VISIBLE);
                btnNext.setText("Iniciar");

            }else{
                btnNext.setEnabled(true);
                btnNext.setVisibility(View.VISIBLE);
                btnBack.setVisibility(View.VISIBLE);
                btnNext.setText("Siguiente");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}