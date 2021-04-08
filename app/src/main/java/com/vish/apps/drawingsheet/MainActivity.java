package com.vish.apps.drawingsheet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.FrameLayout;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Drawing drawing;
    FrameLayout toolbar;
    FrameLayout bottombar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        toolbar = (FrameLayout) findViewById(R.id.toolbar);
        bottombar = (FrameLayout) findViewById(R.id.bottombar);

        drawing = new Drawing(this, null);

    }



    public void undoClick(View view){
    }
    public void clearClick(View view){
    }
}
