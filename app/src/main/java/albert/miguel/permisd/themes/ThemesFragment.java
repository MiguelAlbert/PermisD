package albert.miguel.permisd.themes;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import albert.miguel.permisd.MainActivity;
import albert.miguel.permisd.MainFragment;
import albert.miguel.permisd.R;

public class ThemesFragment extends Fragment {

    FloatingActionButton fab;
    LinearLayout LinearLayout1;
    Button button1, button2, button3, button4, button5, button6;
    Button btnTirageAuSort;
    TextView tvTirageAuSort;
    ImageButton imageButtonGoToFEQuestions;
    int numeroTirageAuSort = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.theme_fragment,container,false);

        LinearLayout1 = (LinearLayout)v.findViewById(R.id.LinearLayout1);

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
        button1 = (Button) v.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle i = new Bundle();
                i.putInt("numeroDeTheme", 1);
                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                ViewPagerTheme.setArguments(i);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
                fab.show();
            }
        });
        button2 = (Button) v.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle i = new Bundle();
                i.putInt("numeroDeTheme", 2);
                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                ViewPagerTheme.setArguments(i);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
                fab.show();
            }
        });
        button3 = (Button) v.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle i = new Bundle();
                i.putInt("numeroDeTheme", 3);
                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                ViewPagerTheme.setArguments(i);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
                fab.show();
            }
        });
        button4 = (Button) v.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle i = new Bundle();
                i.putInt("numeroDeTheme", 4);
                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                ViewPagerTheme.setArguments(i);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
                fab.show();
            }
        });
        button5 = (Button) v.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle i = new Bundle();
                i.putInt("numeroDeTheme", 5);
                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                ViewPagerTheme.setArguments(i);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
                fab.show();
            }
        });
        button6 = (Button) v.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle i = new Bundle();
                i.putInt("numeroDeTheme", 6);
                ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                ViewPagerTheme.setArguments(i);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                transaction.disallowAddToBackStack();
                transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                transaction.commit();
                fab.show();
            }
        });
        tvTirageAuSort = (TextView) v.findViewById(R.id.tvTirageAuSort);
        btnTirageAuSort = (Button) v.findViewById(R.id.btnTirageAuSort);
        btnTirageAuSort.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                numeroTirageAuSort = (int) (Math.random() * 6 + 1);
                tvTirageAuSort.setText("" + numeroTirageAuSort);

            }
        });
        imageButtonGoToFEQuestions = (ImageButton) v.findViewById(R.id.imageButtonGoToFEQuestions);
        imageButtonGoToFEQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((numeroTirageAuSort <=6) && (numeroTirageAuSort>=1)){
                    Bundle i = new Bundle();
                    i.putInt("numeroDeTheme", numeroTirageAuSort);
                    ViewPagerTheme ViewPagerTheme = new ViewPagerTheme();
                    ViewPagerTheme.setArguments(i);
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_frame, ViewPagerTheme); // give your fragment container id in first parameter
                    transaction.disallowAddToBackStack();
                    transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
                    transaction.commit();
                    fab.show();
                }
            }
        });

        /* Define Your Functionality Here
           Find any view  => v.findViewById()
          Specifying Application Context in Fragment => getActivity() */

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
    }

}
