package hk.hku.cs.mscapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;

import hk.hku.cs.mscapp.MainActivity;
import hk.hku.cs.mscapp.R;

import android.content.Intent;

public class AdmissionFragment extends Fragment implements OnClickListener {
    //  MainActivity activity = (MainActivity) getActivity();
    @Nullable
    private Button aBtn;
    private Button tBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admission, container, false);
        aBtn = (Button) view.findViewById(R.id.online);
        aBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ApplicationFragment af = new ApplicationFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction tx = fm.beginTransaction();
                tx.replace(R.id.content_fragment, af);
                tx.addToBackStack(null);
                tx.commit();

            }
        });
        tBtn = (Button) view.findViewById(R.id.time);
        tBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                TableFragment tf = new TableFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction tx = fm.beginTransaction();
                tx.replace(R.id.content_fragment, tf);
                tx.addToBackStack(null);
                tx.commit();
            }
        });
        //   return inflater.inflate(R.layout.fragment_admission, null);

        return view;
    }

    @Override
    public void onClick(View v) {
//
//        TableFragment tf = new TableFragment();
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction tx = fm.beginTransaction();
//        tx.replace(R.id.content_fragment, tf);
//        tx.addToBackStack(null);
//        tx.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}