package albert.miguel.permisd.fe;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import albert.miguel.permisd.MainActivity;
import albert.miguel.permisd.R;

import static android.content.Context.MODE_PRIVATE;

public class FEquestionFragment extends Fragment {

    SharedPreferences pref,pref2;
    SharedPreferences.Editor editor;
    TextView textView2,TextViewQ1,TextViewQ2,TextViewQ3,TextViewQ4,TextViewQ5,TextViewQ6,TextViewQ7,TextViewQ8,TextViewQ9,TextViewQ10;
    FrameLayout FrameLayout1;
    TextView TextViewR1,TextViewR2,TextViewR3,TextViewR4,TextViewR5,TextViewR6,TextViewR7,TextViewR8,TextViewR9,TextViewR10;
    FloatingActionButton fab;
    LinearLayout LinearLayout1;
    ImageButton imageButtonMoins, imageButtonPlus;
    ImageView imageView4;
    int number;
    String name;
    TextToSpeech tts1;
    private AdView mPublisherAdView, mPublisherAdView2;
    Context thiscontext;

    //AdView mAdView1;
    //FrameLayout adcontainer1;
    private static final String AD_UNIT_ID = "ca-app-pub-6506972643290681/2450064282";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.fe_question_fragment,container,false);

        LinearLayout1 = (LinearLayout)v.findViewById(R.id.LinearLayout1);
        thiscontext = container.getContext();
        /*
        MobileAds.initialize(thiscontext, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        adcontainer1 = v.findViewById(R.id.adcontainer1);
        adcontainer1.post(new Runnable() {
            @Override
            public void run() {
                loadAdd1();
            }
        });

        adcontainer3 = v.findViewById(R.id.adcontainer3);
        adcontainer3.post(new Runnable() {
            @Override
            public void run() {
                loadAdd3();
            }
        });

         */

        mPublisherAdView = v.findViewById(R.id.publisherAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);

        mPublisherAdView2 = v.findViewById(R.id.publisherAdView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mPublisherAdView2.loadAd(adRequest2);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout1.setPadding(200,6,200,6);
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            LinearLayout1.setPadding(6,6,6,6);
            //Do some stuff
        }

        textView2 = (TextView) v.findViewById(R.id.textView2);
        TextViewQ1 = (TextView) v.findViewById(R.id.TextViewQ1);
        TextViewQ2 = (TextView) v.findViewById(R.id.TextViewQ2);
        TextViewQ3 = (TextView) v.findViewById(R.id.TextViewQ3);
        TextViewQ4 = (TextView) v.findViewById(R.id.TextViewQ4);
        TextViewQ5 = (TextView) v.findViewById(R.id.TextViewQ5);
        TextViewQ6 = (TextView) v.findViewById(R.id.TextViewQ6);
        TextViewQ7 = (TextView) v.findViewById(R.id.TextViewQ7);
        TextViewQ8 = (TextView) v.findViewById(R.id.TextViewQ8);
        TextViewQ9 = (TextView) v.findViewById(R.id.TextViewQ9);
        TextViewQ10 = (TextView) v.findViewById(R.id.TextViewQ10);
        TextViewR1 = (TextView) v.findViewById(R.id.TextViewR1);
        TextViewR2 = (TextView) v.findViewById(R.id.TextViewR2);
        TextViewR3 = (TextView) v.findViewById(R.id.TextViewR3);
        TextViewR4 = (TextView) v.findViewById(R.id.TextViewR4);
        TextViewR5 = (TextView) v.findViewById(R.id.TextViewR5);
        TextViewR6 = (TextView) v.findViewById(R.id.TextViewR6);
        TextViewR7 = (TextView) v.findViewById(R.id.TextViewR7);
        TextViewR8 = (TextView) v.findViewById(R.id.TextViewR8);
        TextViewR9 = (TextView) v.findViewById(R.id.TextViewR9);
        TextViewR10 = (TextView) v.findViewById(R.id.TextViewR10);

        imageButtonPlus = (ImageButton) v.findViewById(R.id.imageButtonPlus);
        imageButtonMoins = (ImageButton) v.findViewById(R.id.imageButtonMoins);
        imageView4 = (ImageView) v.findViewById(R.id.imageView4);

        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        number = this.getArguments().getInt("numeroDeFiche");

        pref2 = getActivity().getSharedPreferences("MyPref2", MODE_PRIVATE);
        editor = pref2.edit();
        int numbadge = pref2.getInt("countFE"+number, 0);
        editor.putInt("countFE"+number,numbadge+1);
        editor.apply();

        if(number == 20){
            imageButtonPlus.setVisibility(View.INVISIBLE);
        } else if (number == 1){
            imageButtonMoins.setVisibility(View.INVISIBLE);
        }else {
            imageButtonMoins.setVisibility(View.VISIBLE);
            imageButtonPlus.setVisibility(View.VISIBLE);
        }

        name = String.valueOf(number);

        loadDataFromAsset();

        tts1=new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts1.setLanguage(Locale.FRENCH);
                    tts1.setSpeechRate(0.85f);
                }
            }
        });

        textView2.setText("Fiche écrite n°"+name+"\nVersion examen");
        pref = getActivity().getSharedPreferences("MyPref", MODE_PRIVATE);
        String question1 = pref.getString("Fiche"+name+"Question1", null);
        TextViewQ1.setText(question1);
        String question2 = pref.getString("Fiche"+name+"Question2", null);
        TextViewQ2.setText(question2);
        String question3 = pref.getString("Fiche"+name+"Question3", null);
        TextViewQ3.setText(question3);
        String question4 = pref.getString("Fiche"+name+"Question4", null);
        TextViewQ4.setText(question4);
        String question5 = pref.getString("Fiche"+name+"Question5", null);
        TextViewQ5.setText(question5);
        String question6 = pref.getString("Fiche"+name+"Question6", null);
        TextViewQ6.setText(question6);
        String question7 = pref.getString("Fiche"+name+"Question7", null);
        TextViewQ7.setText(question7);
        String question8 = pref.getString("Fiche"+name+"Question8", null);
        TextViewQ8.setText(question8);
        String question9 = pref.getString("Fiche"+name+"Question9", null);
        TextViewQ9.setText(question9);
        String question10 = pref.getString("Fiche"+name+"Question10", null);
        TextViewQ10.setText(question10);

        String reponse1 = pref.getString("Fiche"+name+"Reponse1", null);
        TextViewR1.setText(reponse1);
        String reponse2 = pref.getString("Fiche"+name+"Reponse2", null);
        TextViewR2.setText(reponse2);
        String reponse3 = pref.getString("Fiche"+name+"Reponse3", null);
        TextViewR3.setText(reponse3);
        String reponse4 = pref.getString("Fiche"+name+"Reponse4", null);
        TextViewR4.setText(reponse4);
        String reponse5 = pref.getString("Fiche"+name+"Reponse5", null);
        TextViewR5.setText(reponse5);
        String reponse6 = pref.getString("Fiche"+name+"Reponse6", null);
        TextViewR6.setText(reponse6);
        String reponse7 = pref.getString("Fiche"+name+"Reponse7", null);
        TextViewR7.setText(reponse7);
        String reponse8 = pref.getString("Fiche"+name+"Reponse8", null);
        TextViewR8.setText(reponse8);
        String reponse9 = pref.getString("Fiche"+name+"Reponse9", null);
        TextViewR9.setText(reponse9);
        String reponse10 = pref.getString("Fiche"+name+"Reponse10", null);
        TextViewR10.setText(reponse10);

        fab = ((MainActivity) getActivity()).getFloatingActionButton();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FEFragment FEFragment = new FEFragment();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.content_frame, FEFragment);
                transaction.disallowAddToBackStack();
                transaction.commit();

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }


        });

        sonTouchQuestion();

        imageButtonPlus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                number++;
                if(number>20){
                    number = 20;
                }
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", number);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });

        imageButtonMoins.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                number--;
                if(number<1){
                    number=1;
                }
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", number);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        return v;
    }
    public void sonTouchQuestion() {
        TextViewQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ1.getText().toString()+ "La réponse est : "+TextViewR1.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ2.getText().toString()+ "La réponse est : "+TextViewR2.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ3.getText().toString()+ "La réponse est : "+TextViewR3.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ4.getText().toString()+ "La réponse est : "+TextViewR4.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ5.getText().toString()+ "La réponse est : "+TextViewR5.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ6.getText().toString()+ "La réponse est : "+TextViewR6.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ7.getText().toString()+ "La réponse est : "+TextViewR7.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ8.getText().toString()+ "La réponse est : "+TextViewR8.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ9.getText().toString()+ "La réponse est : "+TextViewR9.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ10.getText().toString()+ "La réponse est : "+TextViewR10.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    public void loadDataFromAsset() {
        try {
            final float scale = getActivity().getResources().getDisplayMetrics().density;
            int dpWidthInPx  = (int) (100 * scale);
            int dpHeightInPx = (int) (100 * scale);
            // get input stream
            InputStream ims = getActivity().getAssets().open("PanneauxPL/fiche"+number+".png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView4.setImageDrawable(d);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView4.setLayoutParams(params);

        } catch (IOException ex) {
            return;
        }
    }
/*
    private void loadAdd1() {
        mAdView1 = new AdView(thiscontext);
        mAdView1.setAdUnitId(AD_UNIT_ID);
        adcontainer1.removeAllViews();
        adcontainer1.addView(mAdView1);
        AdSize adSize = getAdSize1();
        mAdView1.setAdSize(adSize);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);
    }


    private void loadAdd3() {
        mAdView3 = new AdView(thiscontext);
        mAdView3.setAdUnitId(AD_UNIT_ID);
        adcontainer3.removeAllViews();
        adcontainer3.addView(mAdView3);
        AdSize adSize = getAdSize3();
        mAdView3.setAdSize(adSize);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView3.loadAd(adRequest);
    }



    private AdSize getAdSize1() {
        WindowManager wm = (WindowManager) thiscontext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        float density = displayMetrics.density;
        float adwithpixels = adcontainer1.getWidth();
        if(adwithpixels == 0){
            adwithpixels = displayMetrics.widthPixels;
        }
        int adwith = (int)(adwithpixels / density);
        return AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(thiscontext,adwith);
    }


    private AdSize getAdSize3() {
        WindowManager wm = (WindowManager) thiscontext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        float density = displayMetrics.density;
        float adwithpixels = adcontainer3.getWidth();
        if(adwithpixels == 0){
            adwithpixels = displayMetrics.widthPixels;
        }
        int adwith = (int)(adwithpixels / density);
        return AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(thiscontext,adwith);
    }

     */

    public void onPause(){
        if(tts1 !=null){
            tts1.stop();
            tts1.shutdown();
        }
        super.onPause();
    }

}
