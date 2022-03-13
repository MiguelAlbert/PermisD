package albert.miguel.permisd.fe;

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

public class FEThemesFragment extends Fragment {

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
    FloatingActionButton fab;
    LinearLayout LinearLayout1;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int FEtheme1,FEtheme2,FEtheme3,FEtheme4,FEtheme5,FEtheme6,FEtheme7,FEtheme8,FEtheme9,FEtheme10;
    TextView badge_notification_1,badge_notification_2,badge_notification_3,badge_notification_4,badge_notification_5,badge_notification_6,badge_notification_7,badge_notification_8,badge_notification_9,badge_notification_10;
    Button btnRAZcompteursFEtheme;
    Button btnTirageAuSort;
    TextView tvTirageAuSort;
    ImageButton imageButtonGoToFEQuestions;
    int numeroTirageAuSort = 0;
    LineChartView lineChartView;
    String[] axisData = {"01", "02", "03", "04", "05", "06", "07", "08", "09","10"};
    Context thiscontext;
    //private AdView mAdView;
    //FrameLayout adcontainer;
    private static final String AD_UNIT_ID = "ca-app-pub-6506972643290681/2450064282";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fe_theme_fragment,container,false);

        LinearLayout1 = (LinearLayout)v.findViewById(R.id.LinearLayout1);
        thiscontext = container.getContext();
/*
        MobileAds.initialize(thiscontext, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adcontainer = v.findViewById(R.id.adcontainer);
        adcontainer.post(new Runnable() {
            @Override
            public void run() {
                loadAdd();
            }
        });

        adcontainer2 = v.findViewById(R.id.adcontainer2);
        adcontainer2.post(new Runnable() {
            @Override
            public void run() {
                loadAdd2();
            }
        });
         */

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout1.setPadding(200,6,200,6);
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            LinearLayout1.setPadding(6,6,6,6);
            //Do some stuff
        }

        pref = getActivity().getSharedPreferences("MyPrefCountFEtheme", MODE_PRIVATE);
        editor = pref.edit();
        FEtheme1 = pref.getInt("countFETheme1", 0);
        FEtheme2 = pref.getInt("countFETheme2", 0);
        FEtheme3 = pref.getInt("countFETheme3", 0);
        FEtheme4 = pref.getInt("countFETheme4", 0);
        FEtheme5 = pref.getInt("countFETheme5", 0);
        FEtheme6 = pref.getInt("countFETheme6", 0);
        FEtheme7 = pref.getInt("countFETheme7", 0);
        FEtheme8 = pref.getInt("countFETheme8", 0);
        FEtheme9 = pref.getInt("countFETheme9", 0);
        FEtheme10 = pref.getInt("countFETheme10", 0);


        badge_notification_1 = (TextView)v.findViewById(R.id.badge_notification_1);
        badge_notification_1.setText(String.valueOf(FEtheme1));
        badge_notification_2 = (TextView)v.findViewById(R.id.badge_notification_2);
        badge_notification_2.setText(String.valueOf(FEtheme2));
        badge_notification_3 = (TextView)v.findViewById(R.id.badge_notification_3);
        badge_notification_3.setText(String.valueOf(FEtheme3));
        badge_notification_4 = (TextView)v.findViewById(R.id.badge_notification_4);
        badge_notification_4.setText(String.valueOf(FEtheme4));
        badge_notification_5 = (TextView)v.findViewById(R.id.badge_notification_5);
        badge_notification_5.setText(String.valueOf(FEtheme5));
        badge_notification_6 = (TextView)v.findViewById(R.id.badge_notification_6);
        badge_notification_6.setText(String.valueOf(FEtheme6));
        badge_notification_7 = (TextView)v.findViewById(R.id.badge_notification_7);
        badge_notification_7.setText(String.valueOf(FEtheme7));
        badge_notification_8 = (TextView)v.findViewById(R.id.badge_notification_8);
        badge_notification_8.setText(String.valueOf(FEtheme8));
        badge_notification_9 = (TextView)v.findViewById(R.id.badge_notification_9);
        badge_notification_9.setText(String.valueOf(FEtheme9));
        badge_notification_10 = (TextView)v.findViewById(R.id.badge_notification_10);
        badge_notification_10.setText(String.valueOf(FEtheme10));

        lineChartView = v.findViewById(R.id.chart2);

        chart();

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
                i.putString("nomDuTheme", button1.getText().toString());
                i.putInt("numeroDeTheme", 1);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                i.putString("nomDuTheme", button2.getText().toString());
                i.putInt("numeroDeTheme", 2);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                i.putString("nomDuTheme", button3.getText().toString());
                i.putInt("numeroDeTheme", 3);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                i.putString("nomDuTheme", button4.getText().toString());
                i.putInt("numeroDeTheme", 4);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                i.putString("nomDuTheme", button5.getText().toString());
                i.putInt("numeroDeTheme", 5);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                i.putString("nomDuTheme", button6.getText().toString());
                i.putInt("numeroDeTheme", 6);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                i.putString("nomDuTheme", button7.getText().toString());
                i.putInt("numeroDeTheme", 7);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                i.putString("nomDuTheme", button8.getText().toString());
                i.putInt("numeroDeTheme", 8);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                i.putString("nomDuTheme", button9.getText().toString());
                i.putInt("numeroDeTheme", 9);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                i.putString("nomDuTheme", button10.getText().toString());
                i.putInt("numeroDeTheme", 10);
                FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                FEThemesQuestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
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
                numeroTirageAuSort = (int) (Math.random() * 10 + 1);
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

                if ((numeroTirageAuSort <=10) && (numeroTirageAuSort>=1)){
                    Bundle i = new Bundle();
                    switch (numeroTirageAuSort) {
                        case 1:
                            i.putString("nomDuTheme", button1.getText().toString());
                            break;
                        case 2:
                            i.putString("nomDuTheme", button2.getText().toString());
                            break;
                        case 3:
                            i.putString("nomDuTheme", button3.getText().toString());
                            break;
                        case 4:
                            i.putString("nomDuTheme", button4.getText().toString());
                            break;
                        case 5:
                            i.putString("nomDuTheme", button5.getText().toString());
                            break;
                        case 6:
                            i.putString("nomDuTheme", button6.getText().toString());
                            break;
                        case 7:
                            i.putString("nomDuTheme", button7.getText().toString());
                            break;
                        case 8:
                            i.putString("nomDuTheme", button8.getText().toString());
                            break;
                        case 9:
                            i.putString("nomDuTheme", button9.getText().toString());
                            break;
                        case 10:
                            i.putString("nomDuTheme", button10.getText().toString());
                            break;
                    }
                    i.putInt("numeroDeTheme", numeroTirageAuSort);
                    FEThemesQuestionFragment FEThemesQuestionFragment = new FEThemesQuestionFragment();
                    FEThemesQuestionFragment.setArguments(i);
                    FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_frame,FEThemesQuestionFragment ); // give your fragment container id in first parameter
                    transaction.disallowAddToBackStack();
                    transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                    transaction.commit();
                }
            }
        });

        btnRAZcompteursFEtheme = (Button) v.findViewById(R.id.btnRAZcompteursFEtheme);
        btnRAZcompteursFEtheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                FEtheme1 = pref.getInt("countFETheme1", 0);
                FEtheme1 = pref.getInt("countFETheme1", 0);
                FEtheme2 = pref.getInt("countFETheme2", 0);
                FEtheme3 = pref.getInt("countFETheme3", 0);
                FEtheme4 = pref.getInt("countFETheme4", 0);
                FEtheme5 = pref.getInt("countFETheme5", 0);
                FEtheme6 = pref.getInt("countFETheme6", 0);
                FEtheme7 = pref.getInt("countFETheme7", 0);
                FEtheme8 = pref.getInt("countFETheme8", 0);
                FEtheme9 = pref.getInt("countFETheme9", 0);
                FEtheme10 = pref.getInt("countFETheme10", 0);

                badge_notification_1.setText(String.valueOf(FEtheme1));
                badge_notification_2.setText(String.valueOf(FEtheme2));
                badge_notification_3.setText(String.valueOf(FEtheme3));
                badge_notification_4.setText(String.valueOf(FEtheme4));
                badge_notification_5.setText(String.valueOf(FEtheme5));
                badge_notification_6.setText(String.valueOf(FEtheme6));
                badge_notification_7.setText(String.valueOf(FEtheme7));
                badge_notification_8.setText(String.valueOf(FEtheme8));
                badge_notification_9.setText(String.valueOf(FEtheme9));
                badge_notification_10.setText(String.valueOf(FEtheme10));

                chart();
            }
        });

        return v;
    }
    /*
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

     */


    protected void chart(){
        int[] yAxisData = {FEtheme1, FEtheme2, FEtheme3, FEtheme4, FEtheme5, FEtheme6, FEtheme7, FEtheme8, FEtheme9, FEtheme10};
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
