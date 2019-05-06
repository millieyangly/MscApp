package hk.hku.cs.mscapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import hk.hku.cs.mscapp.EventActivity;
import hk.hku.cs.mscapp.NewsActivity;
import hk.hku.cs.mscapp.R;
import hk.hku.cs.mscapp.StreamsActivity;

public class MainFragment extends Fragment {
    public RelativeLayout s1, s2, s3, s4, s5;
    public RelativeLayout n1, n2, n3, n4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        s1 = (RelativeLayout) view.findViewById(R.id.event1);
        s2 = (RelativeLayout) view.findViewById(R.id.event2);
        s3 = (RelativeLayout) view.findViewById(R.id.event3);
        s4 = (RelativeLayout) view.findViewById(R.id.event4);
        s5 = (RelativeLayout) view.findViewById(R.id.event5);

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), EventActivity.class);
                myIntent.putExtra("event", 1);
                startActivity(myIntent);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), EventActivity.class);
                myIntent.putExtra("event", 2);
                startActivity(myIntent);
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), EventActivity.class);
                myIntent.putExtra("event", 3);
                startActivity(myIntent);
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), EventActivity.class);
                myIntent.putExtra("event", 4);
                startActivity(myIntent);
            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), EventActivity.class);
                myIntent.putExtra("event", 5);
                startActivity(myIntent);
            }
        });


        n1=(RelativeLayout)view.findViewById(R.id.news1);
        n2=(RelativeLayout)view.findViewById(R.id.news2);
        n3=(RelativeLayout)view.findViewById(R.id.news3);
        n4=(RelativeLayout)view.findViewById(R.id.news4);

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), NewsActivity.class);
                myIntent.putExtra("news", 1);
                startActivity(myIntent);
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), NewsActivity.class);
                myIntent.putExtra("news", 2);
                startActivity(myIntent);
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), NewsActivity.class);
                myIntent.putExtra("news", 3);
                startActivity(myIntent);
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), NewsActivity.class);
                myIntent.putExtra("news", 4);
                startActivity(myIntent);
            }
        });


        return view;
    }
}
