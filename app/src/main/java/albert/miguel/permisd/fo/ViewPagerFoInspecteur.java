package albert.miguel.permisd.fo;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import albert.miguel.permisd.MainActivity;
import albert.miguel.permisd.MainFragment;
import albert.miguel.permisd.R;

public class ViewPagerFoInspecteur extends Fragment {

    FloatingActionButton fab;
    LinearLayout LinearLayout1;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.viewpager_fragment,container,false);

        LinearLayout1 = (LinearLayout)v.findViewById(R.id.LinearLayout1);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout1.setPadding(0,0,0,0);
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            LinearLayout1.setPadding(0,0,0,0);
            //Do some stuff
        }

        viewPager = (ViewPager) v.findViewById(R.id.vpPager);
        tabLayout = (TabLayout) v.findViewById(R.id.tab);

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
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        viewPagerAdapter.addFragment(new FoInspecteur1Fragment(), "FO1");
        viewPagerAdapter.addFragment(new FoInspecteur2Fragment(), "FO2");
        viewPagerAdapter.addFragment(new FoInspecteur3Fragment(), "FO3");
        viewPagerAdapter.addFragment(new FoInspecteur4Fragment(), "FO4");
        viewPagerAdapter.addFragment(new FoInspecteur5Fragment(), "FO5");
        viewPagerAdapter.addFragment(new FoInspecteur6Fragment(), "FO6");
        viewPagerAdapter.addFragment(new FoInspecteur7Fragment(), "FO7");
        viewPagerAdapter.addFragment(new FoInspecteur8Fragment(), "FO8");
        viewPagerAdapter.addFragment(new FoInspecteur9Fragment(), "FO9");
        viewPagerAdapter.addFragment(new FoInspecteur10Fragment(), "FO10");
        viewPagerAdapter.addFragment(new FoInspecteur11Fragment(), "FO11");
        viewPagerAdapter.addFragment(new FoInspecteur12Fragment(), "FO12");
        viewPager.setAdapter(viewPagerAdapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<>();
        List<String> fragmentTitles = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }

        public void addFragment(Fragment fragment, String name) {
            fragmentList.add(fragment);
            fragmentTitles.add(name);
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's state here
    }

}
