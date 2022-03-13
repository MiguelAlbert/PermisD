package albert.miguel.permisd;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.MobileAds;

import albert.miguel.permisd.fe.FEFragment;
import albert.miguel.permisd.fe.FEThemesFragment;
import albert.miguel.permisd.fe.FEquizzFragment;
import albert.miguel.permisd.fo.FOFragment;
import albert.miguel.permisd.fo.ViewPagerFoInspecteur;
import albert.miguel.permisd.fo.ViewPagerManoeuvres8_10;
import albert.miguel.permisd.themes.ThemesFragment;
import albert.miguel.permisd.themes.ViewPagerTheme;

public class MainFragment extends Fragment {

        Button button7, button4, button5, button3, button21, button22, button23, button24, button25, button26, button2, button31, button27, button8, button28, button6, button29;
        //Questions C
        //https://script.google.com/macros/s/AKfycbxOLElujQcy1-ZUer1KgEvK16gkTLUqYftApjNCM_IRTL3HSuDk/exec?id=1bgdL9itc3N0BzaZzrTRYBIX2pCsms2ISTHq8mdPKrtk&sheet=C
        //https://www.tutorialspoint.com/android/android_json_parser.htm
        private String TAG = MainActivity.class.getSimpleName();
        private ProgressDialog pDialog;
        private static String url = "https://script.google.com/macros/s/AKfycbxOLElujQcy1-ZUer1KgEvK16gkTLUqYftApjNCM_IRTL3HSuDk/exec?id=1bgdL9itc3N0BzaZzrTRYBIX2pCsms2ISTHq8mdPKrtk&sheet=C01";
        Context thiscontext;
        Activity thisActivity;
        SharedPreferences pref;
        SharedPreferences.Editor editor;
        LinearLayout LinearLayout1;
        ImageView ImageView2;
        FloatingActionButton fab;

        private InterstitialAd mInterstitialAd;
        private static final String AD_UNIT_ID = "ca-app-pub-6506972643290681/6339698717";

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

                thiscontext = container.getContext();
                View v = inflater.inflate(R.layout.accueil_fragment,container,false);
                thisActivity = getActivity();
                ImageView2 = (ImageView) v.findViewById(R.id.imageView2);

                LinearLayout1 = (LinearLayout)v.findViewById(R.id.LinearLayout1);

                fab = ((MainActivity) getActivity()).getFloatingActionButton();
                if (fab != null) {
                        fab.hide();
                }

                loadAdd();

                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){


                        if ((getResources().getConfiguration().screenLayout &
                                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                                Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                                // on a large screen device ...
                                LinearLayout1.setPadding(100,6,100,6);
                        }

                       LinearLayout1.setPadding(200,6,200,6);
                }

                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                        if ((getResources().getConfiguration().screenLayout &
                                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                                Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                                // on a large screen device ...
                                LinearLayout1.setPadding(50,6,50,6);
                        }
                        LinearLayout1.setPadding(6,6,6,6);
                        //ImageView2.setMaxHeight(3000);
                        //Do some stuff
                }

                button7 = (Button) v.findViewById(R.id.button7);
                button7.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                FEFragment FEFragment = new FEFragment();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame,FEFragment ); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });

                button4 = (Button) v.findViewById(R.id.button4);
                button4.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                FEThemesFragment FEThemesFragment = new FEThemesFragment();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame,FEThemesFragment ); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button5 = (Button) v.findViewById(R.id.button5);
                button5.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                FEquizzFragment FEquizzFragment = new FEquizzFragment();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame,FEquizzFragment ); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button3 = (Button) v.findViewById(R.id.button3);
                button3.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                Verifs1Fragment Verifs1Fragment = new Verifs1Fragment();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame,Verifs1Fragment ); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button29 = (Button) v.findViewById(R.id.button29);
                button29.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                ThemesFragment ThemesFragment = new ThemesFragment();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame, ThemesFragment); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                                fab.show();
                        }
                });
                button21 = (Button) v.findViewById(R.id.button21);
                button21.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                Bundle i = new Bundle();
                                i.putInt("numeroDeTheme", 1);
                                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                                ViewPagerTheme.setArguments(i);
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button22 = (Button) v.findViewById(R.id.button22);
                button22.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                Bundle i = new Bundle();
                                i.putInt("numeroDeTheme", 2);
                                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                                ViewPagerTheme.setArguments(i);
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button23 = (Button) v.findViewById(R.id.button23);
                button23.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                Bundle i = new Bundle();
                                i.putInt("numeroDeTheme", 3);
                                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                                ViewPagerTheme.setArguments(i);
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button24 = (Button) v.findViewById(R.id.button24);
                button24.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                Bundle i = new Bundle();
                                i.putInt("numeroDeTheme", 4);
                                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                                ViewPagerTheme.setArguments(i);
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button25 = (Button) v.findViewById(R.id.button25);
                button25.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                Bundle i = new Bundle();
                                i.putInt("numeroDeTheme", 5);
                                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                                ViewPagerTheme.setArguments(i);
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button26 = (Button) v.findViewById(R.id.button26);
                button26.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                Bundle i = new Bundle();
                                i.putInt("numeroDeTheme", 6);
                                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                                ViewPagerTheme.setArguments(i);
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button2 = (Button) v.findViewById(R.id.button2);
                button2.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                FOFragment FOFragment = new FOFragment();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame,FOFragment ); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button31 = (Button) v.findViewById(R.id.button31);
                button31.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                ViewPagerFoInspecteur ViewPagerFoInspecteur = new ViewPagerFoInspecteur();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame,ViewPagerFoInspecteur ); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button27 = (Button) v.findViewById(R.id.button27);
                button27.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                Verifs2Fragment Verifs2Fragment = new Verifs2Fragment();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame,Verifs2Fragment ); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button8 = (Button) v.findViewById(R.id.button8);
                button8.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                ViewPagerManoeuvres8_10 ViewPagerManoeuvres8_10 = new ViewPagerManoeuvres8_10();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame,ViewPagerManoeuvres8_10 ); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
                button6 = (Button) v.findViewById(R.id.button6);
                button6.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View v)
                        {
                                OutilsFragment OutilsFragment = new OutilsFragment();
                                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.content_frame,OutilsFragment ); // give your fragment container id in first parameter
                                transaction.disallowAddToBackStack();
                                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                                transaction.commit();
                                if (mInterstitialAd != null) {
                                        mInterstitialAd.show(thisActivity);
                                } else {
                                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
                                }
                            fab.show();
                        }
                });
        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        return v;
    }

        private void loadAdd() {
                MobileAds.initialize(thiscontext, new OnInitializationCompleteListener() {
                        @Override
                        public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                                AdRequest adRequest = new AdRequest.Builder().build();

                                InterstitialAd.load(thiscontext,"ca-app-pub-6506972643290681/6339698717", adRequest,
                                        new InterstitialAdLoadCallback() {
                                                @Override
                                                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                                        // The mInterstitialAd reference will be null until
                                                        // an ad is loaded.
                                                        mInterstitialAd = interstitialAd;
                                                        Log.i(TAG, "onAdLoaded");

                                                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                                                                @Override
                                                                public void onAdDismissedFullScreenContent() {
                                                                        // Called when fullscreen content is dismissed.
                                                                        Log.d("TAG", "The ad was dismissed.");
                                                                }

                                                                @Override
                                                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                                        // Called when fullscreen content failed to show.
                                                                        Log.d("TAG", "The ad failed to show.");
                                                                }

                                                                @Override
                                                                public void onAdShowedFullScreenContent() {
                                                                        // Called when fullscreen content is shown.
                                                                        // Make sure to set your reference to null so you don't
                                                                        // show it a second time.
                                                                        mInterstitialAd = null;
                                                                        Log.d("TAG", "The ad was shown.");
                                                                }
                                                        });
                                                }

                                                @Override
                                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                                        // Handle the error
                                                        Log.i(TAG, loadAdError.getMessage());
                                                        mInterstitialAd = null;
                                                }
                                        });
                        }
                });
        }

        @Override
        public void onResume() {
                Log.e("DEBUG", "onResume of HomeFragment");
                super.onResume();
                loadAdd();
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
                super.onSaveInstanceState(outState);

                //Save the fragment's state here
        }
}
