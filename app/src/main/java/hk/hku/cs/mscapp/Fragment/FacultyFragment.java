package hk.hku.cs.mscapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hk.hku.cs.mscapp.R;

public class FacultyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // View view = inflater.inflate(R.layout.fragment_faculty, null);
        return inflater.inflate(R.layout.fragment_faculty, null);
    }
}
