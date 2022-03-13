package albert.miguel.permisd.fo;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import albert.miguel.permisd.MainActivity;
import albert.miguel.permisd.MainFragment;
import albert.miguel.permisd.R;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

import static android.content.Context.MODE_PRIVATE;

public class FOFragment extends Fragment {

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12;
    LinearLayout LinearLayout1;
    FloatingActionButton fab;
    Button btnTirageAuSort;
    TextView tvTirageAuSort;
    ImageButton imageButtonGoToFEQuestions;
    int numeroTirageAuSort = 0;

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    TextView badge_notification_1,badge_notification_2,badge_notification_3,badge_notification_4,badge_notification_5,badge_notification_6,badge_notification_7,badge_notification_8,badge_notification_9,badge_notification_10,badge_notification_11,badge_notification_12;
    int FO1,FO2,FO3,FO4,FO5,FO6,FO7,FO8,FO9,FO10,FO11,FO12;
    Button btnRAZcompteursFO;

    LineChartView lineChartView;
    String[] axisData = {"01", "02", "03", "04", "05", "06", "07", "08", "09","10", "11", "12"};

    Context thiscontext;
    AdView mAdView1, mAdView2;
    FrameLayout adcontainer1, adcontainer2;
    private static final String AD_UNIT_ID = "ca-app-pub-6506972643290681/2450064282";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fo_fragment,container,false);

        LinearLayout1 = (LinearLayout)v.findViewById(R.id.LinearLayout1);

        thiscontext = container.getContext();

        //MobileAds.initialize(getActivity(), "ca-app-pub-6506972643290681~5656009377");
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
        adcontainer2 = v.findViewById(R.id.adcontainer2);
        adcontainer2.post(new Runnable() {
            @Override
            public void run() {
                loadAdd2();
            }
        });

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout1.setPadding(200,6,200,6);
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            LinearLayout1.setPadding(6,6,6,6);
            //Do some stuff
        }

        pref = getActivity().getSharedPreferences("MyPrefCountFO", MODE_PRIVATE);
        editor = pref.edit();
        FO1 = pref.getInt("countFO1", 0);
        FO2 = pref.getInt("countFO2", 0);
        FO3 = pref.getInt("countFO3", 0);
        FO4 = pref.getInt("countFO4", 0);
        FO5 = pref.getInt("countFO5", 0);
        FO6 = pref.getInt("countFO6", 0);
        FO7 = pref.getInt("countFO7", 0);
        FO8 = pref.getInt("countFO8", 0);
        FO9 = pref.getInt("countFO9", 0);
        FO10 = pref.getInt("countFO10", 0);
        FO11 = pref.getInt("countFO11", 0);
        FO12 = pref.getInt("countFO12", 0);

        badge_notification_1 = (TextView)v.findViewById(R.id.badge_notification_1);
        badge_notification_1.setText(String.valueOf(FO1));
        badge_notification_2 = (TextView)v.findViewById(R.id.badge_notification_2);
        badge_notification_2.setText(String.valueOf(FO2));
        badge_notification_3 = (TextView)v.findViewById(R.id.badge_notification_3);
        badge_notification_3.setText(String.valueOf(FO3));
        badge_notification_4 = (TextView)v.findViewById(R.id.badge_notification_4);
        badge_notification_4.setText(String.valueOf(FO4));
        badge_notification_5 = (TextView)v.findViewById(R.id.badge_notification_5);
        badge_notification_5.setText(String.valueOf(FO5));
        badge_notification_6 = (TextView)v.findViewById(R.id.badge_notification_6);
        badge_notification_6.setText(String.valueOf(FO6));
        badge_notification_7 = (TextView)v.findViewById(R.id.badge_notification_7);
        badge_notification_7.setText(String.valueOf(FO7));
        badge_notification_8 = (TextView)v.findViewById(R.id.badge_notification_8);
        badge_notification_8.setText(String.valueOf(FO8));
        badge_notification_9 = (TextView)v.findViewById(R.id.badge_notification_9);
        badge_notification_9.setText(String.valueOf(FO9));
        badge_notification_10 = (TextView)v.findViewById(R.id.badge_notification_10);
        badge_notification_10.setText(String.valueOf(FO10));
        badge_notification_11 = (TextView)v.findViewById(R.id.badge_notification_11);
        badge_notification_11.setText(String.valueOf(FO11));
        badge_notification_12 = (TextView)v.findViewById(R.id.badge_notification_12);
        badge_notification_12.setText(String.valueOf(FO12));

        lineChartView = v.findViewById(R.id.chart3);

        chart();

        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        fab = ((MainActivity) getActivity()).getFloatingActionButton();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainFragment MainFragment = new MainFragment();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.replace(R.id.content_frame, MainFragment);
                transaction.disallowAddToBackStack();
                transaction.commit();

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });

        button1 = (Button) v.findViewById(R.id.myButton1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 1);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button2 = (Button) v.findViewById(R.id.myButton2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 2);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button3 = (Button) v.findViewById(R.id.myButton3);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 3);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button4 = (Button) v.findViewById(R.id.myButton4);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 4);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button5 = (Button) v.findViewById(R.id.myButton5);
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 5);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button6 = (Button) v.findViewById(R.id.myButton6);
        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 6);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button7 = (Button) v.findViewById(R.id.myButton7);
        button7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 7);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button8 = (Button) v.findViewById(R.id.myButton8);
        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 8);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button9 = (Button) v.findViewById(R.id.myButton9);
        button9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 9);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button10 = (Button) v.findViewById(R.id.myButton10);
        button10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 10);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button11 = (Button) v.findViewById(R.id.myButton11);
        button11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 11);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button12 = (Button) v.findViewById(R.id.myButton12);
        button12.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 12);
                FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                FOficheExamenFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, FOficheExamenFragment); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        tvTirageAuSort = (TextView) v.findViewById(R.id.tvTirageAuSort);
        btnTirageAuSort = (Button) v.findViewById(R.id.btnTirageAuSort);
        btnTirageAuSort.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroTirageAuSort = (int) (Math.random() * 12 + 1);
                if (numeroTirageAuSort < 10) {
                    tvTirageAuSort.setText("0" + numeroTirageAuSort);
                } else {
                    tvTirageAuSort.setText("" + numeroTirageAuSort);
                }
            }
        });
        imageButtonGoToFEQuestions = (ImageButton) v.findViewById(R.id.imageButtonGoToFEQuestions);
        imageButtonGoToFEQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((numeroTirageAuSort <=12) && (numeroTirageAuSort>=1)){
                    Bundle i = new Bundle();
                    i.putInt("numeroDeFiche", numeroTirageAuSort);
                    FOficheExamenFragment FOficheExamenFragment = new FOficheExamenFragment();
                    FOficheExamenFragment.setArguments(i);
                    FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_frame,FOficheExamenFragment ); // give your fragment container id in first parameter
                    transaction.disallowAddToBackStack();
                    transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                    transaction.commit();
                }
            }
        });
        btnRAZcompteursFO = (Button) v.findViewById(R.id.btnRAZcompteursFO);
        btnRAZcompteursFO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                FO1 = pref.getInt("countFO1", 0);
                FO2 = pref.getInt("countFO2", 0);
                FO3 = pref.getInt("countFO3", 0);
                FO4 = pref.getInt("countFO4", 0);
                FO5 = pref.getInt("countFO5", 0);
                FO6 = pref.getInt("countF06", 0);
                FO7 = pref.getInt("countFO7", 0);
                FO8 = pref.getInt("countFO8", 0);
                FO9 = pref.getInt("countFO9", 0);
                FO10 = pref.getInt("countFO10", 0);
                FO11 = pref.getInt("countFO11", 0);
                FO12 = pref.getInt("countFO12", 0);
                badge_notification_1.setText(String.valueOf(FO1));
                badge_notification_2.setText(String.valueOf(FO2));
                badge_notification_3.setText(String.valueOf(FO3));
                badge_notification_4.setText(String.valueOf(FO4));
                badge_notification_5.setText(String.valueOf(FO5));
                badge_notification_6.setText(String.valueOf(FO6));
                badge_notification_7.setText(String.valueOf(FO7));
                badge_notification_8.setText(String.valueOf(FO8));
                badge_notification_9.setText(String.valueOf(FO9));
                badge_notification_10.setText(String.valueOf(FO10));
                badge_notification_11.setText(String.valueOf(FO11));
                badge_notification_12.setText(String.valueOf(FO12));

                chart();
            }
        });
        return v;
    }

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

    private void loadAdd2() {
        mAdView2 = new AdView(thiscontext);
        mAdView2.setAdUnitId(AD_UNIT_ID);
        adcontainer2.removeAllViews();
        adcontainer2.addView(mAdView2);
        AdSize adSize = getAdSize2();
        mAdView2.setAdSize(adSize);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest);
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
    private AdSize getAdSize2() {
        WindowManager wm = (WindowManager) thiscontext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        float density = displayMetrics.density;
        float adwithpixels = adcontainer2.getWidth();
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


    protected void chart(){
        int[] yAxisData = {FO1, FO2, FO3, FO4, FO5, FO6, FO7, FO8, FO9, FO10, FO11, FO12};
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        Line line = new Line(yAxisValues).setColor(getResources().getColor(R.color.colorPrimaryDark));

        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setTextSize(10);
        axis.setTextColor(getResources().getColor(R.color.colorsimple));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setTextSize(10);
        yAxis.setTextColor(getResources().getColor(R.color.colorsimple));
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 20;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);
    }

}
