package org.tensorflow.lite.examples.detection;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import org.tensorflow.lite.examples.detection.ecoapp.HintManager;

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

    class Hints {
        LinkedList<String> objs;

        public Hints() {
            HintManager hm = new HintManager();
            for (String key: hm.hints.keySet()) {
                objs.push(key);
            }
        }
    }

    class HintList {
        private Activity context;
        private LinearLayout hintList;



        public HintList(Activity context, String[] nameArrayParam, String[] infoArrayParam) {

        }


    }
}
