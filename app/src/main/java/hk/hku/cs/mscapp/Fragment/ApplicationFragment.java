package hk.hku.cs.mscapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import hk.hku.cs.mscapp.R;

public class ApplicationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_application, null);
        WebView webView = (WebView) view.findViewById(R.id.web);

      //  webView.getSettings().setJavaScriptEnabled(true);
        // webView.getSettings().setBlockNetworkImage(true);

        webView.loadUrl("https://aal.hku.hk/tpg/programme/master-science-computer-science");
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBlockNetworkImage(false);
        return view;
    }
}
