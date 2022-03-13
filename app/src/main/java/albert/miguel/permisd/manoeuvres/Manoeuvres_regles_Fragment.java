package albert.miguel.permisd.manoeuvres;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import albert.miguel.permisd.R;

public class Manoeuvres_regles_Fragment extends Fragment {

    LinearLayout LinearLayout1;
    WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.manoeuvres_fragment_regles,container,false);

        LinearLayout1 = (LinearLayout)v.findViewById(R.id.LinearLayout1);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout1.setPadding(6, 6, 6, 6);
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            LinearLayout1.setPadding(6,6,6,6);
            //Do some stuff
        }
        webView = (WebView) v.findViewById(R.id.simpleWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings();
        webView.setBackgroundColor(getResources().getColor(R.color.transparentColor));
        webView.loadUrl("file:///android_asset/Manoeuvres/regles.html");
        return v;
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);


    }
}
