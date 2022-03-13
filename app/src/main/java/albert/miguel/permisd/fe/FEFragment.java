package albert.miguel.permisd.fe;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
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


public class FEFragment extends Fragment {

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,button20;
    FloatingActionButton fab;
    RelativeLayout LinearLayout1;
    Button btnTirageAuSort;
    TextView tvTirageAuSort;
    ImageButton imageButtonGoToFEQuestions;
    int numeroTirageAuSort = 0;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    TextView badge_notification_1,badge_notification_2,badge_notification_3,badge_notification_4,badge_notification_5,badge_notification_6,badge_notification_7,badge_notification_8,badge_notification_9,badge_notification_10,badge_notification_11,badge_notification_12,badge_notification_13,badge_notification_14,badge_notification_15,badge_notification_16,badge_notification_17,badge_notification_18,badge_notification_19,badge_notification_20;
    int FE1,FE2,FE3,FE4,FE5,FE6,FE7,FE8,FE9,FE10,FE11,FE12,FE13,FE14,FE15,FE16,FE17,FE18,FE19,FE20;
    Button btnRAZcompteursFE;

    LineChartView lineChartView;
    String[] axisData = {"01", "02", "03", "04", "05", "06", "07", "08", "09","10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fe_fragment,container,false);

        LinearLayout1 = (RelativeLayout)v.findViewById(R.id.LinearLayout1);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout1.setPadding(200,6,200,6);
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            LinearLayout1.setPadding(6,6,6,6);
            //Do some stuff
        }

        pref = getActivity().getSharedPreferences("MyPref2", MODE_PRIVATE);
        editor = pref.edit();
        FE1 = pref.getInt("countFE1", 0);
        FE2 = pref.getInt("countFE2", 0);
        FE3 = pref.getInt("countFE3", 0);
        FE4 = pref.getInt("countFE4", 0);
        FE5 = pref.getInt("countFE5", 0);
        FE6 = pref.getInt("countFE6", 0);
        FE7 = pref.getInt("countFE7", 0);
        FE8 = pref.getInt("countFE8", 0);
        FE9 = pref.getInt("countFE9", 0);
        FE10 = pref.getInt("countFE10", 0);
        FE11 = pref.getInt("countFE11", 0);
        FE12 = pref.getInt("countFE12", 0);
        FE13 = pref.getInt("countFE13", 0);
        FE14 = pref.getInt("countFE14", 0);
        FE15 = pref.getInt("countFE15", 0);
        FE16 = pref.getInt("countFE16", 0);
        FE17 = pref.getInt("countFE17", 0);
        FE18 = pref.getInt("countFE18", 0);
        FE19 = pref.getInt("countFE19", 0);
        FE20 = pref.getInt("countFE20", 0);

        badge_notification_1 = (TextView)v.findViewById(R.id.badge_notification_1);
        badge_notification_1.setText(String.valueOf(FE1));
        badge_notification_2 = (TextView)v.findViewById(R.id.badge_notification_2);
        badge_notification_2.setText(String.valueOf(FE2));
        badge_notification_3 = (TextView)v.findViewById(R.id.badge_notification_3);
        badge_notification_3.setText(String.valueOf(FE3));
        badge_notification_4 = (TextView)v.findViewById(R.id.badge_notification_4);
        badge_notification_4.setText(String.valueOf(FE4));
        badge_notification_5 = (TextView)v.findViewById(R.id.badge_notification_5);
        badge_notification_5.setText(String.valueOf(FE5));
        badge_notification_6 = (TextView)v.findViewById(R.id.badge_notification_6);
        badge_notification_6.setText(String.valueOf(FE6));
        badge_notification_7 = (TextView)v.findViewById(R.id.badge_notification_7);
        badge_notification_7.setText(String.valueOf(FE7));
        badge_notification_8 = (TextView)v.findViewById(R.id.badge_notification_8);
        badge_notification_8.setText(String.valueOf(FE8));
        badge_notification_9 = (TextView)v.findViewById(R.id.badge_notification_9);
        badge_notification_9.setText(String.valueOf(FE9));
        badge_notification_10 = (TextView)v.findViewById(R.id.badge_notification_10);
        badge_notification_10.setText(String.valueOf(FE10));
        badge_notification_11 = (TextView)v.findViewById(R.id.badge_notification_11);
        badge_notification_11.setText(String.valueOf(FE11));
        badge_notification_12 = (TextView)v.findViewById(R.id.badge_notification_12);
        badge_notification_12.setText(String.valueOf(FE12));
        badge_notification_13 = (TextView)v.findViewById(R.id.badge_notification_13);
        badge_notification_13.setText(String.valueOf(FE13));
        badge_notification_14 = (TextView)v.findViewById(R.id.badge_notification_14);
        badge_notification_14.setText(String.valueOf(FE14));
        badge_notification_15 = (TextView)v.findViewById(R.id.badge_notification_15);
        badge_notification_15.setText(String.valueOf(FE15));
        badge_notification_16 = (TextView)v.findViewById(R.id.badge_notification_16);
        badge_notification_16.setText(String.valueOf(FE16));
        badge_notification_17 = (TextView)v.findViewById(R.id.badge_notification_17);
        badge_notification_17.setText(String.valueOf(FE17));
        badge_notification_18 = (TextView)v.findViewById(R.id.badge_notification_18);
        badge_notification_18.setText(String.valueOf(FE18));
        badge_notification_19 = (TextView)v.findViewById(R.id.badge_notification_19);
        badge_notification_19.setText(String.valueOf(FE19));
        badge_notification_20 = (TextView)v.findViewById(R.id.badge_notification_20);
        badge_notification_20.setText(String.valueOf(FE20));

        lineChartView = v.findViewById(R.id.chart);

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
                i.putInt("numeroDeFiche", 1);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button13 = (Button) v.findViewById(R.id.myButton13);
        button13.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 13);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button14 = (Button) v.findViewById(R.id.myButton14);
        button14.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 14);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button15 = (Button) v.findViewById(R.id.myButton15);
        button15.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 15);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button16 = (Button) v.findViewById(R.id.myButton16);
        button16.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 16);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button17 = (Button) v.findViewById(R.id.myButton17);
        button17.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 17);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button18 = (Button) v.findViewById(R.id.myButton18);
        button18.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 18);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button19 = (Button) v.findViewById(R.id.myButton19);
        button19.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 19);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                transaction.commit();
            }
        });
        button20 = (Button) v.findViewById(R.id.myButton20);
        button20.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle i = new Bundle();
                i.putInt("numeroDeFiche", 20);
                FEquestionFragment FEquestionFragment = new FEquestionFragment();
                FEquestionFragment.setArguments(i);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
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
                numeroTirageAuSort = (int) (Math.random() * 20 + 1);
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

                if ((numeroTirageAuSort <=20) && (numeroTirageAuSort>=1)){
                    Bundle i = new Bundle();
                    i.putInt("numeroDeFiche", numeroTirageAuSort);
                    FEquestionFragment FEquestionFragment = new FEquestionFragment();
                    FEquestionFragment.setArguments(i);
                    FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_frame,FEquestionFragment ); // give your fragment container id in first parameter
                    transaction.disallowAddToBackStack();
                    transaction.setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
                    transaction.commit();
                }
            }
        });
        btnRAZcompteursFE = (Button) v.findViewById(R.id.btnRAZcompteursFE);
        btnRAZcompteursFE.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                editor.clear();
                editor.commit();
                FE1 = pref.getInt("countFE1", 0);
                FE2 = pref.getInt("countFE2", 0);
                FE3 = pref.getInt("countFE3", 0);
                FE4 = pref.getInt("countFE4", 0);
                FE5 = pref.getInt("countFE5", 0);
                FE6 = pref.getInt("countFE6", 0);
                FE7 = pref.getInt("countFE7", 0);
                FE8 = pref.getInt("countFE8", 0);
                FE9 = pref.getInt("countFE9", 0);
                FE10 = pref.getInt("countFE10", 0);
                FE11 = pref.getInt("countFE11", 0);
                FE12 = pref.getInt("countFE12", 0);
                FE13 = pref.getInt("countFE13", 0);
                FE14 = pref.getInt("countFE14", 0);
                FE15 = pref.getInt("countFE15", 0);
                FE16 = pref.getInt("countFE16", 0);
                FE17 = pref.getInt("countFE17", 0);
                FE18 = pref.getInt("countFE18", 0);
                FE19 = pref.getInt("countFE19", 0);
                FE20 = pref.getInt("countFE20", 0);
                badge_notification_1.setText(String.valueOf(FE1));
                badge_notification_2.setText(String.valueOf(FE2));
                badge_notification_3.setText(String.valueOf(FE3));
                badge_notification_4.setText(String.valueOf(FE4));
                badge_notification_5.setText(String.valueOf(FE5));
                badge_notification_6.setText(String.valueOf(FE6));
                badge_notification_7.setText(String.valueOf(FE7));
                badge_notification_8.setText(String.valueOf(FE8));
                badge_notification_9.setText(String.valueOf(FE9));
                badge_notification_10.setText(String.valueOf(FE10));
                badge_notification_11.setText(String.valueOf(FE11));
                badge_notification_12.setText(String.valueOf(FE12));
                badge_notification_13.setText(String.valueOf(FE13));
                badge_notification_14.setText(String.valueOf(FE14));
                badge_notification_15.setText(String.valueOf(FE15));
                badge_notification_16.setText(String.valueOf(FE16));
                badge_notification_17.setText(String.valueOf(FE17));
                badge_notification_18.setText(String.valueOf(FE18));
                badge_notification_19.setText(String.valueOf(FE19));
                badge_notification_20.setText(String.valueOf(FE20));

                chart();
            }
        });
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
    }

    protected void chart(){
        int[] yAxisData = {FE1, FE2, FE3, FE4, FE5, FE6, FE7, FE8, FE9, FE10, FE11, FE12, FE13, FE14, FE15, FE16, FE17, FE18, FE19, FE20};
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
