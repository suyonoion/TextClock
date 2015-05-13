package com.suyonoion.textclockapi17;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
    TabHost tabHost;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = getTabHost();
        setTabs();
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.notif,
                (ViewGroup) findViewById(R.id.relativeLayout1));

        Toast toast = new Toast(this);
        toast.setView(view);
        toast.show();
    }


    private void setTabs()
    {
        addTab("Home", R.drawable.tab_home, Home.class);
        addTab("TextClock", R.drawable.tab_textclock, TampilkanHalaman1.class);
        addTab("TextClock", R.drawable.tab_textclock, TampilkanHalaman2.class);
        addTab("TextClock", R.drawable.tab_textclock, TampilkanHalaman3.class);
        addTab("Hasil Tes Paste", R.drawable.tab_sukses, TestingPaste.class);

    }
    private void addTab(String labelId, int drawableId, Class<?> c)
    {
        Intent intent = new Intent(this, c);
        TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);

        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
        title.setText(labelId);
        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
        icon.setImageResource(drawableId);
        spec.setIndicator(tabIndicator);
        spec.setContent(intent);
        tabHost.addTab(spec);
    }

}