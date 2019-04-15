package org.tensorflow.lite.examples.detection;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.tensorflow.lite.examples.detection.ecoapp.HintManager;

import java.util.ArrayList;
import java.util.LinkedList;

public class HintScrolling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_scrolling);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private LinkedList<String> getKeys() {
        LinkedList<String> objs = new LinkedList<String>();
        for (String key : HintManager.hints.keySet()) {
            objs.push(key);
        }

        return objs;
    }

    private void addHints() {
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_hint_scrolling, null);
        LinkedList<String> hintsList = getKeys();

        for (String hint: hintsList) {
            TextView textView = v.findViewById(R.id.hint_view);
            textView.setText(hint);

            ViewGroup insertPoint = findViewById(R.id.scrollingView);
            insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        }
    }


}
