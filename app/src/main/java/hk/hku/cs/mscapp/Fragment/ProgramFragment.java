package hk.hku.cs.mscapp.Fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;


import hk.hku.cs.mscapp.R;
import hk.hku.cs.mscapp.StreamsActivity;

public class ProgramFragment extends Fragment {

    public TextView s1, s2, s3,s4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_program, container, false);
        s1=(TextView) view.findViewById(R.id.stream1);
        s2=(TextView) view.findViewById(R.id.stream2);
        s3=(TextView) view.findViewById(R.id.stream3);
        s4=(TextView) view.findViewById(R.id.stream4);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), StreamsActivity.class);
                myIntent.putExtra("stream",1);
                startActivity(myIntent);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), StreamsActivity.class);
                myIntent.putExtra("stream",2);
                startActivity(myIntent);
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), StreamsActivity.class);
                myIntent.putExtra("stream",3);
                startActivity(myIntent);
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), StreamsActivity.class);
                myIntent.putExtra("stream",4);
                startActivity(myIntent);
            }
        });


        return view;



    }


}
