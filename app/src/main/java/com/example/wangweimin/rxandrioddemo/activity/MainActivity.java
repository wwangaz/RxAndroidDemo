package com.example.wangweimin.rxandrioddemo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wangweimin.rxandrioddemo.R;
import com.example.wangweimin.rxandrioddemo.entity.Subject;
import com.example.wangweimin.rxandrioddemo.fragment.GridFragment;
import com.example.wangweimin.rxandrioddemo.http.HttpMethods;
import com.example.wangweimin.rxandrioddemo.subsciber.ProgressSubscriber;
import com.example.wangweimin.rxandrioddemo.subsciber.SubscriberOnNextListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.main_content_view)
    RelativeLayout mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Loading data", Snackbar.LENGTH_SHORT).show();
                getMovie();
            }
        });
    }

    public void getMovie() {
        SubscriberOnNextListener<List<Subject>> nextListener = new SubscriberOnNextListener<List<Subject>>() {
            @Override
            public void onNext(List<Subject> list) {
                // TODO: 16/4/8 pass data to GridFragment and add GridFragment to layout
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("subjects", (ArrayList<Subject>) list);
                GridFragment gridFragment = new GridFragment();
                gridFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.main_content_view, gridFragment)
                        .commit();

            }
        };
        ProgressSubscriber<List<Subject>> subscriber = new ProgressSubscriber<>(nextListener, MainActivity.this);
        HttpMethods.getInstance().getTopMovie(subscriber, 0, 10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
