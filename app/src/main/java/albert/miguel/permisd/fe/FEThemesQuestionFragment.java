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
import com.google.android.gms.ads.RequestConfiguration;
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
import java.util.Arrays;
import java.util.Locale;

import albert.miguel.permisd.MainActivity;
import albert.miguel.permisd.R;

import static android.content.Context.MODE_PRIVATE;

public class FEThemesQuestionFragment extends Fragment {

    TextView textView2Theme;
    SharedPreferences.Editor editor;
    SharedPreferences pref,prefNumFETheme;
    TextView TextViewQ1,TextViewQ2,TextViewQ3,TextViewQ4,TextViewQ5,TextViewQ6,TextViewQ7,TextViewQ8,TextViewQ9,TextViewQ10,TextViewQ11,TextViewQ12,TextViewQ13,TextViewQ14,TextViewQ15,TextViewQ16,TextViewQ17,TextViewQ18,TextViewQ19,TextViewQ20;
    TextView TextViewR1,TextViewR2,TextViewR3,TextViewR4,TextViewR5,TextViewR6,TextViewR7,TextViewR8,TextViewR9,TextViewR10,TextViewR11,TextViewR12,TextViewR13,TextViewR14,TextViewR15,TextViewR16,TextViewR17,TextViewR18,TextViewR19,TextViewR20;
    FloatingActionButton fab;
    LinearLayout LinearLayout1, llv1, llv2, llv3, llv4, llv5, llv6, llv7, llv8, llv9, llv10, llv11, llv12, llv13, llv14, llv15, llv16, llv17, llv18, llv19, llv20;
    ImageButton imageButtonMoins, imageButtonPlus;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16,imageView17,imageView18,imageView19,imageView20;
    int numero;
    String name;
    TextToSpeech tts1;
    Context thiscontext;
    private AdView mPublisherAdView, mPublisherAdView2, mPublisherAdView3, mPublisherAdView4;

    //AdView mAdView1, mAdView3;
    //FrameLayout adcontainer1, adcontainer3;
    private static final String AD_UNIT_ID = "ca-app-pub-6506972643290681/2450064282";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fe_theme_question_fragment,container,false);

        LinearLayout1 = (LinearLayout)v.findViewById(R.id.LinearLayout1theme);
        thiscontext = container.getContext();

        //MobileAds.initialize(getActivity(), "ca-app-pub-6506972643290681~6744212760");
        MobileAds.initialize(thiscontext, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
/*
        MobileAds.setRequestConfiguration(
                new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("ABCDEF012345"))
                        .build());

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

        adcontainer5 = v.findViewById(R.id.adcontainer5);
        adcontainer5.post(new Runnable() {
            @Override
            public void run() {
                loadAdd5();
            }
        });

         */

        mPublisherAdView = v.findViewById(R.id.publisherAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mPublisherAdView.loadAd(adRequest);

        mPublisherAdView2 = v.findViewById(R.id.publisherAdView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mPublisherAdView2.loadAd(adRequest2);

        mPublisherAdView3 = v.findViewById(R.id.publisherAdView3);
        AdRequest adRequest3 = new AdRequest.Builder().build();
        mPublisherAdView3.loadAd(adRequest3);

        mPublisherAdView4 = v.findViewById(R.id.publisherAdView4);
        AdRequest adRequest4 = new AdRequest.Builder().build();
        mPublisherAdView4.loadAd(adRequest4);


        llv1 = (LinearLayout) v.findViewById(R.id.llv1);
        llv2 = (LinearLayout) v.findViewById(R.id.llv2);
        llv3 = (LinearLayout) v.findViewById(R.id.llv3);
        llv4 = (LinearLayout) v.findViewById(R.id.llv4);
        llv5 = (LinearLayout) v.findViewById(R.id.llv5);
        llv6 = (LinearLayout) v.findViewById(R.id.llv6);
        llv7 = (LinearLayout) v.findViewById(R.id.llv7);
        llv8 = (LinearLayout) v.findViewById(R.id.llv8);
        llv9 = (LinearLayout) v.findViewById(R.id.llv9);
        llv10 = (LinearLayout) v.findViewById(R.id.llv10);
        llv11 = (LinearLayout) v.findViewById(R.id.llv11);
        llv12 = (LinearLayout) v.findViewById(R.id.llv12);
        llv13 = (LinearLayout) v.findViewById(R.id.llv13);
        llv14 = (LinearLayout) v.findViewById(R.id.llv14);
        llv15 = (LinearLayout) v.findViewById(R.id.llv15);
        llv16 = (LinearLayout) v.findViewById(R.id.llv16);
        llv17 = (LinearLayout) v.findViewById(R.id.llv17);
        llv18 = (LinearLayout) v.findViewById(R.id.llv18);
        llv19 = (LinearLayout) v.findViewById(R.id.llv19);
        llv20 = (LinearLayout) v.findViewById(R.id.llv20);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout1.setPadding(200,6,200,6);
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            LinearLayout1.setPadding(6,6,6,6);
            //Do some stuff
        }

        fab = ((MainActivity) getActivity()).getFloatingActionButton();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FEThemesFragment FEThemesFragment = new FEThemesFragment();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.content_frame, FEThemesFragment);
                transaction.disallowAddToBackStack();
                transaction.commit();

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });
        textView2Theme = (TextView)v.findViewById(R.id.textView2Theme);
        numero = getArguments().getInt("numeroDeTheme");

        prefNumFETheme = getActivity().getSharedPreferences("MyPrefCountFEtheme", MODE_PRIVATE);
        editor = prefNumFETheme.edit();
        int numbadge = prefNumFETheme.getInt("countFETheme"+numero, 0);
        editor.putInt("countFETheme"+numero,numbadge+1);
        editor.apply();

        switch (numero) {
            case 1:
                name = "01 - Conducteur";
                break;
            case 2:
                name = "02 - Équipement des véhicules";
                break;
            case 3:
                name = "03 - Masses et dimensions des véhicules";
                break;
            case 4:
                name = "04 - Règles de circulation spécifiques 1/2";
                break;
            case 5:
                name = "05 - Règles de circulation spécifiques 2/2 - Panneaux";
                break;
            case 6:
                name = "06 - Réglementation sociale européenne et Française 1/2";
                break;
            case 7:
                name = "07 - Réglementation sociale européenne et Française 2/2";
                break;
            case 8:
                name = "08 - Règles du transport";
                break;
            case 9:
                name = "09 - Situations dégradées et accidents";
                break;
            case 10:
                name = "10 - Mécanique";
                break;
        }
        textView2Theme.setText("Questions écrites\nThème : " + name);

        imageButtonPlus = (ImageButton) v.findViewById(R.id.imageButtonPlusTheme);
        imageButtonMoins = (ImageButton) v.findViewById(R.id.imageButtonMoinsTheme);
        if(numero == 10){
            imageButtonPlus.setVisibility(View.INVISIBLE);
        } else if (numero == 1){
            imageButtonMoins.setVisibility(View.INVISIBLE);
        }else {
            imageButtonMoins.setVisibility(View.VISIBLE);
            imageButtonPlus.setVisibility(View.VISIBLE);
        }
        TextViewQ1 = (TextView) v.findViewById(R.id.TextViewQ1Theme);
        TextViewQ2 = (TextView) v.findViewById(R.id.TextViewQ2Theme);
        TextViewQ3 = (TextView) v.findViewById(R.id.TextViewQ3Theme);
        TextViewQ4 = (TextView) v.findViewById(R.id.TextViewQ4Theme);
        TextViewQ5 = (TextView) v.findViewById(R.id.TextViewQ5Theme);
        TextViewQ6 = (TextView) v.findViewById(R.id.TextViewQ6Theme);
        TextViewQ7 = (TextView) v.findViewById(R.id.TextViewQ7Theme);
        TextViewQ8 = (TextView) v.findViewById(R.id.TextViewQ8Theme);
        TextViewQ9 = (TextView) v.findViewById(R.id.TextViewQ9Theme);
        TextViewQ10 = (TextView) v.findViewById(R.id.TextViewQ10Theme);
        TextViewQ11 = (TextView) v.findViewById(R.id.TextViewQ11Theme);
        TextViewQ12 = (TextView) v.findViewById(R.id.TextViewQ12Theme);
        TextViewQ13 = (TextView) v.findViewById(R.id.TextViewQ13Theme);
        TextViewQ14 = (TextView) v.findViewById(R.id.TextViewQ14Theme);
        TextViewQ15 = (TextView) v.findViewById(R.id.TextViewQ15Theme);
        TextViewQ16 = (TextView) v.findViewById(R.id.TextViewQ16Theme);
        TextViewQ17 = (TextView) v.findViewById(R.id.TextViewQ17Theme);
        TextViewQ18 = (TextView) v.findViewById(R.id.TextViewQ18Theme);
        TextViewQ19 = (TextView) v.findViewById(R.id.TextViewQ19Theme);
        TextViewQ20 = (TextView) v.findViewById(R.id.TextViewQ20Theme);

        TextViewR1 = (TextView) v.findViewById(R.id.TextViewR1Theme);
        TextViewR2 = (TextView) v.findViewById(R.id.TextViewR2Theme);
        TextViewR3 = (TextView) v.findViewById(R.id.TextViewR3Theme);
        TextViewR4 = (TextView) v.findViewById(R.id.TextViewR4Theme);
        TextViewR5 = (TextView) v.findViewById(R.id.TextViewR5Theme);
        TextViewR6 = (TextView) v.findViewById(R.id.TextViewR6Theme);
        TextViewR7 = (TextView) v.findViewById(R.id.TextViewR7Theme);
        TextViewR8 = (TextView) v.findViewById(R.id.TextViewR8Theme);
        TextViewR9 = (TextView) v.findViewById(R.id.TextViewR9Theme);
        TextViewR10 = (TextView) v.findViewById(R.id.TextViewR10Theme);
        TextViewR11 = (TextView) v.findViewById(R.id.TextViewR11Theme);
        TextViewR12 = (TextView) v.findViewById(R.id.TextViewR12Theme);
        TextViewR13 = (TextView) v.findViewById(R.id.TextViewR13Theme);
        TextViewR14 = (TextView) v.findViewById(R.id.TextViewR14Theme);
        TextViewR15 = (TextView) v.findViewById(R.id.TextViewR15Theme);
        TextViewR16 = (TextView) v.findViewById(R.id.TextViewR16Theme);
        TextViewR17 = (TextView) v.findViewById(R.id.TextViewR17Theme);
        TextViewR18 = (TextView) v.findViewById(R.id.TextViewR18Theme);
        TextViewR19 = (TextView) v.findViewById(R.id.TextViewR19Theme);
        TextViewR20 = (TextView) v.findViewById(R.id.TextViewR20Theme);

        imageButtonPlus = (ImageButton) v.findViewById(R.id.imageButtonPlusTheme);
        imageButtonMoins = (ImageButton) v.findViewById(R.id.imageButtonMoinsTheme);

        if(numero == 5){
            imageView1 = (ImageView) v.findViewById(R.id.imageView1);
            imageView2 = (ImageView) v.findViewById(R.id.imageView2);
            imageView3 = (ImageView) v.findViewById(R.id.imageView3);
            imageView4 = (ImageView) v.findViewById(R.id.imageView4);
            imageView5 = (ImageView) v.findViewById(R.id.imageView5);
            imageView6 = (ImageView) v.findViewById(R.id.imageView6);
            imageView7 = (ImageView) v.findViewById(R.id.imageView7);
            imageView8 = (ImageView) v.findViewById(R.id.imageView8);
            imageView9 = (ImageView) v.findViewById(R.id.imageView9);
            imageView10 = (ImageView) v.findViewById(R.id.imageView10);
            imageView11 = (ImageView) v.findViewById(R.id.imageView11);
            imageView12 = (ImageView) v.findViewById(R.id.imageView12);
            imageView13 = (ImageView) v.findViewById(R.id.imageView13);
            imageView14 = (ImageView) v.findViewById(R.id.imageView14);
            imageView15 = (ImageView) v.findViewById(R.id.imageView15);
            imageView16 = (ImageView) v.findViewById(R.id.imageView16);
            imageView17 = (ImageView) v.findViewById(R.id.imageView17);
            imageView18 = (ImageView) v.findViewById(R.id.imageView18);
            imageView19 = (ImageView) v.findViewById(R.id.imageView19);
            imageView20 = (ImageView) v.findViewById(R.id.imageView20);
            llv1.setPadding(0, 0, 0, 0);
            llv2.setPadding(0, 45, 0, 0);
            llv3.setPadding(0, 45, 0, 0);
            llv4.setPadding(0, 45, 0, 0);
            llv5.setPadding(0, 45, 0, 0);
            llv6.setPadding(0, 45, 0, 0);
            llv7.setPadding(0, 45, 0, 0);
            llv8.setPadding(0, 45, 0, 0);
            llv9.setPadding(0, 45, 0, 0);
            llv10.setPadding(0, 45, 0, 0);
            llv11.setPadding(0, 45, 0, 0);
            llv12.setPadding(0, 45, 0, 0);
            llv13.setPadding(0, 45, 0, 0);
            llv14.setPadding(0, 45, 0, 0);
            llv15.setPadding(0, 45, 0, 0);
            llv16.setPadding(0, 45, 0, 0);
            llv17.setPadding(0, 45, 0, 0);
            llv18.setPadding(0, 45, 0, 0);
            llv19.setPadding(0, 45, 0, 0);
            llv20.setPadding(0, 45, 0, 0);
            loadDataFromAsset();
        }
        pref = getActivity().getSharedPreferences("MyPref", MODE_PRIVATE);
        String question1 = pref.getString("Fiche1Question"+numero, null);
        TextViewQ1.setText(question1);
        String question2 = pref.getString("Fiche2Question"+numero, null);
        TextViewQ2.setText(question2);
        String question3 = pref.getString("Fiche3Question"+numero, null);
        TextViewQ3.setText(question3);
        String question4 = pref.getString("Fiche4Question"+numero, null);
        TextViewQ4.setText(question4);
        String question5 = pref.getString("Fiche5Question"+numero, null);
        TextViewQ5.setText(question5);
        String question6 = pref.getString("Fiche6Question"+numero, null);
        TextViewQ6.setText(question6);
        String question7 = pref.getString("Fiche7Question"+numero, null);
        TextViewQ7.setText(question7);
        String question8 = pref.getString("Fiche8Question"+numero, null);
        TextViewQ8.setText(question8);
        String question9 = pref.getString("Fiche9Question"+numero, null);
        TextViewQ9.setText(question9);
        String question10 = pref.getString("Fiche10Question"+numero, null);
        TextViewQ10.setText(question10);
        String question11 = pref.getString("Fiche11Question"+numero, null);
        TextViewQ11.setText(question11);
        String question12 = pref.getString("Fiche12Question"+numero, null);
        TextViewQ12.setText(question12);
        String question13 = pref.getString("Fiche13Question"+numero, null);
        TextViewQ13.setText(question13);
        String question14 = pref.getString("Fiche14Question"+numero, null);
        TextViewQ14.setText(question14);
        String question15 = pref.getString("Fiche15Question"+numero, null);
        TextViewQ15.setText(question15);
        String question16 = pref.getString("Fiche16Question"+numero, null);
        TextViewQ16.setText(question16);
        String question17 = pref.getString("Fiche17Question"+numero, null);
        TextViewQ17.setText(question17);
        String question18 = pref.getString("Fiche18Question"+numero, null);
        TextViewQ18.setText(question18);
        String question19 = pref.getString("Fiche19Question"+numero, null);
        TextViewQ19.setText(question19);
        String question20 = pref.getString("Fiche20Question"+numero, null);
        TextViewQ20.setText(question20);

        String reponse1 = pref.getString("Fiche1Reponse"+numero, null);
        TextViewR1.setText(reponse1);
        String reponse2 = pref.getString("Fiche2Reponse"+numero, null);
        TextViewR2.setText(reponse2);
        String reponse3 = pref.getString("Fiche3Reponse"+numero, null);
        TextViewR3.setText(reponse3);
        String reponse4 = pref.getString("Fiche4Reponse"+numero, null);
        TextViewR4.setText(reponse4);
        String reponse5 = pref.getString("Fiche5Reponse"+numero, null);
        TextViewR5.setText(reponse5);
        String reponse6 = pref.getString("Fiche6Reponse"+numero, null);
        TextViewR6.setText(reponse6);
        String reponse7 = pref.getString("Fiche7Reponse"+numero, null);
        TextViewR7.setText(reponse7);
        String reponse8 = pref.getString("Fiche8Reponse"+numero, null);
        TextViewR8.setText(reponse8);
        String reponse9 = pref.getString("Fiche9Reponse"+numero, null);
        TextViewR9.setText(reponse9);
        String reponse10 = pref.getString("Fiche10Reponse"+numero, null);
        TextViewR10.setText(reponse10);
        String reponse11 = pref.getString("Fiche11Reponse"+numero, null);
        TextViewR11.setText(reponse11);
        String reponse12 = pref.getString("Fiche12Reponse"+numero, null);
        TextViewR12.setText(reponse12);
        String reponse13 = pref.getString("Fiche13Reponse"+numero, null);
        TextViewR13.setText(reponse13);
        String reponse14 = pref.getString("Fiche14Reponse"+numero, null);
        TextViewR14.setText(reponse14);
        String reponse15 = pref.getString("Fiche15Reponse"+numero, null);
        TextViewR15.setText(reponse15);
        String reponse16 = pref.getString("Fiche16Reponse"+numero, null);
        TextViewR16.setText(reponse16);
        String reponse17 = pref.getString("Fiche17Reponse"+numero, null);
        TextViewR17.setText(reponse17);
        String reponse18 = pref.getString("Fiche18Reponse"+numero, null);
        TextViewR18.setText(reponse18);
        String reponse19 = pref.getString("Fiche19Reponse"+numero, null);
        TextViewR19.setText(reponse19);
        String reponse20 = pref.getString("Fiche20Reponse"+numero, null);
        TextViewR20.setText(reponse20);

        tts1=new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts1.setLanguage(Locale.FRENCH);
                    tts1.setSpeechRate(0.85f);
                }
            }
        });

        sonTouchQuestion();

        imageButtonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero++;
                if (numero > 10) {
                    numero = 10;
                }
                Bundle i = new Bundle();
                i.putInt("numeroDeTheme", numero);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FEThemesQuestionFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
            }
        });


        imageButtonMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero--;
                if (numero < 1) {
                    numero = 1;
                }
                Bundle i = new Bundle();
                i.putInt("numeroDeTheme", numero);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FEThemesQuestionFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
            }
        });

        return v;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
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
        TextViewQ11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ11.getText().toString()+ "La réponse est : "+TextViewR11.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ12.getText().toString()+ "La réponse est : "+TextViewR12.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ13.getText().toString()+ "La réponse est : "+TextViewR13.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ14.getText().toString()+ "La réponse est : "+TextViewR14.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ15.getText().toString()+ "La réponse est : "+TextViewR15.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ16.getText().toString()+ "La réponse est : "+TextViewR16.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ17.getText().toString()+ "La réponse est : "+TextViewR17.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ18.getText().toString()+ "La réponse est : "+TextViewR18.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ19.getText().toString()+ "La réponse est : "+TextViewR19.getText().toString();
                tts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        TextViewQ20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = TextViewQ20.getText().toString()+ "La réponse est : "+TextViewR20.getText().toString();
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
            InputStream ims = getActivity().getAssets().open("PanneauxPL/fiche1.png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView1.setImageDrawable(d);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;

            imageView1.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche2.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView2.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView2.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche3.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView3.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView3.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche4.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView4.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView4.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche5.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView5.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView5.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche6.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView6.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView6.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche7.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView7.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView7.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche8.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView8.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView8.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche9.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView9.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView9.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche10.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView10.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView10.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche11.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView11.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView11.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche12.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView12.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView12.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche13.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView13.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView13.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche14.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView14.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView14.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche15.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView15.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView15.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche16.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView16.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView16.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche17.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView17.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView17.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche18.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView18.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView18.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche19.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView19.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView19.setLayoutParams(params);

            ims = getActivity().getAssets().open("PanneauxPL/fiche20.png");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView20.setImageDrawable(d);
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            params.weight = 1.0f;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            params.height = dpHeightInPx;
            params.width = dpWidthInPx;
            imageView20.setLayoutParams(params);
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

    private void loadAdd5() {
        mAdView5 = new AdView(thiscontext);
        mAdView5.setAdUnitId(AD_UNIT_ID);
        adcontainer5.removeAllViews();
        adcontainer5.addView(mAdView5);
        AdSize adSize = getAdSize5();
        mAdView5.setAdSize(adSize);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView5.loadAd(adRequest);
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

    private AdSize getAdSize5() {
        WindowManager wm = (WindowManager) thiscontext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        float density = displayMetrics.density;
        float adwithpixels = adcontainer5.getWidth();
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
