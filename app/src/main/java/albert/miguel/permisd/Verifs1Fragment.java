package albert.miguel.permisd;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class Verifs1Fragment extends Fragment {

    FloatingActionButton fab;
    LinearLayout LinearLayout1;
    WebView webView,webView2;

    Context thiscontext;
    AdView mAdView;
    FrameLayout adcontainer;
    private static final String AD_UNIT_ID = "ca-app-pub-6506972643290681/2450064282";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.verifs1_fragment,container,false);

        LinearLayout1 = (LinearLayout)v.findViewById(R.id.LinearLayout1);

        thiscontext = container.getContext();

        MobileAds.initialize(thiscontext, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        adcontainer = v.findViewById(R.id.adcontainer);
        adcontainer.post(new Runnable() {
            @Override
            public void run() {
                loadAdd();
            }
        });

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout1.setPadding(6,6,6,6);
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            LinearLayout1.setPadding(6,6,6,6);
            //Do some stuff
        }

        fab = ((MainActivity) getActivity()).getFloatingActionButton();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainFragment MainFragment = new MainFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.content_frame, MainFragment);
                transaction.disallowAddToBackStack();
                transaction.commit();

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });
        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */
        webView = (WebView) v.findViewById(R.id.simpleWebView);
        webView.setBackgroundColor(getResources().getColor(R.color.transparentColor));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/Verifs/socle1_1.html");

        webView2 = (WebView) v.findViewById(R.id.simpleWebView2);
        webView2.setBackgroundColor(getResources().getColor(R.color.transparentColor));
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.loadUrl("file:///android_asset/Verifs/socle1_2.html");
        return v;
    }

    private void loadAdd() {
        mAdView = new AdView(thiscontext);
        mAdView.setAdUnitId(AD_UNIT_ID);
        adcontainer.removeAllViews();
        adcontainer.addView(mAdView);
        AdSize adSize = getAdSize();
        mAdView.setAdSize(adSize);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    private AdSize getAdSize() {
        WindowManager wm = (WindowManager) thiscontext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        float density = displayMetrics.density;
        float adwithpixels = adcontainer.getWidth();
        if(adwithpixels == 0){
            adwithpixels = displayMetrics.widthPixels;
        }
        int adwith = (int)(adwithpixels / density);
        return AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(thiscontext,adwith);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
    }

}
