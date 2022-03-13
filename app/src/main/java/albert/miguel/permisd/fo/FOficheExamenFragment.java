package albert.miguel.permisd.fo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import albert.miguel.permisd.MainActivity;
import albert.miguel.permisd.R;

import static android.content.Context.MODE_PRIVATE;

public class FOficheExamenFragment extends Fragment {

    SharedPreferences prefNumFO;
    SharedPreferences.Editor editor;
    WebView webView,webView2;
    public String fileName1 = "";
    public String fileName2 = "";
    TextView textView2, textView13;
    FloatingActionButton fab;
    LinearLayout LinearLayout1;
    ImageButton imageButton1, imageButton2;
    MediaPlayer mPlayer;
    String name;
    int numero;
    ImageButton imageButtonPlusFO, imageButtonMoinsFO;

    private Context mContext;
    private Activity mActivity;
    private Button mButtonPlay;
    private Button mButtonStop;
    private Button mButtonPause;
    private Button mButtonResume;
    private SeekBar mSeekBar;
    private TextView mPass;
    private TextView mDuration;
    private TextView mDue;
    private Handler mHandler;
    private Runnable mRunnable;

    private int mInterval = 10;

    Context thiscontext;
    AdView mAdView;
    FrameLayout adcontainer;
    private static final String AD_UNIT_ID = "ca-app-pub-6506972643290681/2450064282";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fo_fiche_examen_fragment,container,false);

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

                FOFragment FOFragment = new FOFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.content_frame, FOFragment);
                transaction.disallowAddToBackStack();
                transaction.commit();

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });
        numero = this.getArguments().getInt("numeroDeFiche");
        name = String.valueOf(numero);
        fileName1 = ("fo"+name+"_1.html");
        fileName2 = ("fo"+name+"_2.html");

        prefNumFO = getActivity().getSharedPreferences("MyPrefCountFO", MODE_PRIVATE);
        editor = prefNumFO.edit();
        int numbadge = prefNumFO.getInt("countFO"+numero, 0);
        editor.putInt("countFO"+numero,numbadge+1);
        editor.apply();

        webView = (WebView) v.findViewById(R.id.simpleWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(getResources().getColor(R.color.transparentColor));
        webView.loadUrl("file:///android_asset/FichesOrales/" + fileName1);

        webView2 = (WebView) v.findViewById(R.id.simpleWebView2);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setBackgroundColor(getResources().getColor(R.color.transparentColor));
        webView2.loadUrl("file:///android_asset/FichesOrales/" + fileName2);

        textView2 = (TextView) v.findViewById(R.id.textView2);
        textView2.setText("Fiche orale n°" + name);
        textView13 = (TextView) v.findViewById(R.id.textView13);
        if (numero == 1) {
            textView13.setText("Conduite dans des conditions atmosphériques difficiles, route de nuit ...");
        }
        if (numero == 2) {
            textView13.setText("Comportement en cas d’accident");
        }
        if (numero == 3) {
            textView13.setText("Conduite en montagne ou zones accidentées");
        }
        if (numero == 4) {
            textView13.setText("Gestes et postures – Accident du travail");
        }
        if (numero == 5) {
            textView13.setText("Chargement – Surcharge");
        }
        if (numero == 6) {
            textView13.setText("Le dépassement");
        }
        if (numero == 7) {
            textView13.setText("Dynamique du véhicule");
        }
        if (numero == 8) {
            textView13.setText("Alcool, stupéfiants, médicaments");
        }
        if (numero == 9) {
            textView13.setText("Eco-conduite et conduite citoyenne");
        }
        if(numero == 10){
            textView13.setText("Porte-à-faux - Angles morts");
        }
        if(numero == 11){
            textView13.setText("Comportement en tunnels et aux passages à niveau");
        }
        if(numero == 12){
            textView13.setText("Systèmes de sécurité et d’aides à la conduite");
        }
        imageButtonPlusFO = (ImageButton) v.findViewById(R.id.imageButtonPlusFO);
        imageButtonMoinsFO = (ImageButton) v.findViewById(R.id.imageButtonMoinsFO);
        if (numero == 12) {
            imageButtonPlusFO.setVisibility(View.INVISIBLE);
            imageButtonMoinsFO.setVisibility(View.VISIBLE);
        } else if (numero == 1) {
            imageButtonMoinsFO.setVisibility(View.INVISIBLE);
            imageButtonPlusFO.setVisibility(View.VISIBLE);
        } else {
            imageButtonPlusFO.setVisibility(View.VISIBLE);
            imageButtonPlusFO.setVisibility(View.VISIBLE);
        }

        mContext = getContext();
        mActivity = getActivity();

        // Get the widget reference from xml layout
        mButtonPlay = v.findViewById(R.id.btn_play);
        mButtonStop = v.findViewById(R.id.btn_stop);
        mButtonPause = v.findViewById(R.id.btn_pause);
        mButtonResume = v.findViewById(R.id.btn_resume);
        mSeekBar = v.findViewById(R.id.seek_bar);
        mPass = v.findViewById(R.id.tv_pass);
        mDuration = v.findViewById(R.id.tv_duration);
        mDue = v.findViewById(R.id.tv_due);
// Initialize the handler
        mHandler = new Handler();

        // Initially disable the buttons
        mButtonStop.setEnabled(false);
        mButtonPause.setEnabled(false);
        mButtonResume.setEnabled(false);

        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If media player another instance already running then stop it first
                stopPlaying();

                if (numero == 1) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche1);
                } else if (numero == 2) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche2);
                } else if (numero == 3) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche3);
                } else if (numero == 4) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche4);
                } else if (numero == 5) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche5);
                } else if (numero == 6) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche6);
                } else if (numero == 7) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche7);
                } else if (numero == 8) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche8);
                } else if (numero == 9) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche9);
                } else if (numero == 10) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche10);
                } else if (numero == 11) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche11);
                } else if (numero == 12) {
                    mPlayer = MediaPlayer.create(getActivity(), R.raw.fiche12);
                }

                // Start the media player
                mPlayer.start();

                // Get the current audio stats
                getAudioStats();
                // Initialize the seek bar
                initializeSeekBar();

                // Disable the start and resume button
                mButtonPlay.setEnabled(false);
                mButtonResume.setEnabled(false);
                mButtonPause.setEnabled(true);
                mButtonStop.setEnabled(true);
            }
        });

        // Set a click listener for top playing button
        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                mButtonStop.setEnabled(false);
                mButtonResume.setEnabled(false);
                mButtonPause.setEnabled(false);
                mButtonPlay.setEnabled(true);
            }
        });

        // Click listener for pause button
        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPlayer!=null && mPlayer.isPlaying()){
                    /*
                        void pause ()
                            Pauses playback. Call start() to resume.

                        Throws
                            IllegalStateException : if the internal player engine has not been initialized.
                    */
                    mPlayer.pause();
                    mButtonPause.setEnabled(false);
                    mButtonStop.setEnabled(false);
                    mButtonPlay.setEnabled(false);
                    mButtonResume.setEnabled(true);
                    mButtonPlay.setEnabled(true);
                }
            }
        });

        // Click listener for resume button
        mButtonResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPlayer!=null){
                    /*
                        void seekTo (int msec)
                            Seeks to specified time position. Same as seekTo(long, int) with mode = SEEK_PREVIOUS_SYNC.

                        Parameters
                            msec int : the offset in milliseconds from the start to seek to

                        Throws
                            IllegalStateException : if the internal player engine has not been initialized
                    */
                    //mPlayer.seekTo(mPlayer.getCurrentPosition());

                    /*
                        void start ()
                            Starts or resumes playback. If playback had previously been paused,
                            playback will continue from where it was paused. If playback had been
                            stopped, or never started before, playback will start at the beginning.

                        Throws
                            IllegalStateException : if it is called in an invalid state
                    */

                    // Start the media player from paused position, so at this situation do not
                    // need to call seekTo() method
                    mPlayer.start();
                    mButtonResume.setEnabled(false);
                    mButtonPause.setEnabled(true);
                    mButtonPlay.setEnabled(true);
                    mButtonStop.setEnabled(true);
                }
            }
        });

        // Set a change listener for seek bar
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(mPlayer!=null && b){
                    mPlayer.seekTo(i*mInterval);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        imageButtonPlusFO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero++;
                if (numero > 12) {
                    numero = 12;
                }
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", numero);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
            }
        });


        imageButtonMoinsFO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero--;
                if (numero < 1) {
                    numero = 1;
                }
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", numero);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
            }
        });


        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        return v;
    }

    protected void stopPlaying(){
        // If media player is not null then try to stop it
        if(mPlayer!=null){
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
            if(mHandler!=null){
                mHandler.removeCallbacks(mRunnable);
            }
        }
    }

    protected void getAudioStats(){
        int duration  = mPlayer.getDuration()/1000; // In milliseconds
        int due = (mPlayer.getDuration() - mPlayer.getCurrentPosition())/1000;
        int pass = duration - due;

        mPass.setText("" + pass + "s");
        mDuration.setText("" + duration + "s");
        mDue.setText("" + due + "s");
    }

    protected void initializeSeekBar(){
        mSeekBar.setMax(mPlayer.getDuration()/mInterval);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                if(mPlayer!=null){
                    int mCurrentPosition = mPlayer.getCurrentPosition()/mInterval; // In milliseconds
                    mSeekBar.setProgress(mCurrentPosition);
                    getAudioStats();
                }
                mHandler.postDelayed(mRunnable,mInterval);
            }
        };
        mHandler.postDelayed(mRunnable,mInterval);
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
    public void onPause() {
        if (mPlayer != null) {
            mPlayer.stop();
        }
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
    }

}
