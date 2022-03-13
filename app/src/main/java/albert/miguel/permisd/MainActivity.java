package albert.miguel.permisd;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import albert.miguel.permisd.fe.FEFragment;
import albert.miguel.permisd.fe.FEThemesFragment;
import albert.miguel.permisd.fo.FOFragment;
import albert.miguel.permisd.fo.ViewPagerManoeuvres8_10;
import albert.miguel.permisd.themes.ThemesFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Questions C
    //https://script.google.com/macros/s/AKfycbxOLElujQcy1-ZUer1KgEvK16gkTLUqYftApjNCM_IRTL3HSuDk/exec?id=1bgdL9itc3N0BzaZzrTRYBIX2pCsms2ISTHq8mdPKrtk&sheet=C
    //https://www.tutorialspoint.com/android/android_json_parser.htm
    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private static String url = "https://script.google.com/macros/s/AKfycbxOLElujQcy1-ZUer1KgEvK16gkTLUqYftApjNCM_IRTL3HSuDk/exec?id=1bgdL9itc3N0BzaZzrTRYBIX2pCsms2ISTHq8mdPKrtk&sheet=";
    private static final String TAG_MY_FRAGMENT = "myFragment";
    MainFragment mFragment;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    FloatingActionButton fab;
    private InterstitialAd mInterstitialAd;
    private static final String AD_UNIT_ID = "ca-app-pub-6506972643290681/6339698717";
    Context context;
    int j=1;
    int questionvide = 0;
    private ConsentInformation consentInformation;
    private ConsentForm consentForm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        context = getApplicationContext();

        if (savedInstanceState == null) {
            MainFragment MainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame,MainFragment)
                    .disallowAddToBackStack()
                    .commit();
        } else{
            mFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(TAG_MY_FRAGMENT);
        }

        consentement();
        loadAdd();

        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        for(int i=1;i<21;i++) {
            for(int j=1;j<11;j++) {
                String question = pref.getString("Fiche" + String.valueOf(i) + "Question" + String.valueOf(j), null);
                if(question == null) {
                    questionvide++;
                }
            }
        }
        if(questionvide>0){
            new GetContacts().execute();
        }


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Do some stuff
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //Do some stuff
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void consentement() {
        // Set tag for underage of consent. false means users are not underage.
        ConsentRequestParameters params = new ConsentRequestParameters
                .Builder()
                .setTagForUnderAgeOfConsent(false)
                .build();

        consentInformation = (ConsentInformation) UserMessagingPlatform.getConsentInformation(context);
        consentInformation.requestConsentInfoUpdate(
                this,
                params,
                new ConsentInformation.OnConsentInfoUpdateSuccessListener() {
                    @Override
                    public void onConsentInfoUpdateSuccess() {
                        // The consent information state was updated.
                        // You are now ready to check if a form is available.
                        if (consentInformation.isConsentFormAvailable()) {
                            loadForm();
                        }
                    }
                },
                new ConsentInformation.OnConsentInfoUpdateFailureListener() {
                    @Override
                    public void onConsentInfoUpdateFailure(FormError formError) {
                        // Handle the error.
                    }
                });
    }

    private void loadForm() {
        UserMessagingPlatform.loadConsentForm(
                context,
                new UserMessagingPlatform.OnConsentFormLoadSuccessListener() {
                    @Override
                    public void onConsentFormLoadSuccess(ConsentForm consentForm) {
                        MainActivity.this.consentForm = consentForm;
                        if(consentInformation.getConsentStatus() == ConsentInformation.ConsentStatus.REQUIRED) {
                            consentForm.show(
                                    MainActivity.this,
                                    new ConsentForm.OnConsentFormDismissedListener() {
                                        @Override
                                        public void onConsentFormDismissed(@Nullable FormError formError) {
                                            // Handle dismissal by reloading form.
                                            loadForm();
                                        }
                                    });

                        }
                    }
                },
                new UserMessagingPlatform.OnConsentFormLoadFailureListener() {
                    @Override
                    public void onConsentFormLoadFailure(FormError formError) {
                        // Handle the error
                    }
                }
        );
    }

    private void loadAdd() {
        MobileAds.initialize(MainActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                AdRequest adRequest = new AdRequest.Builder().build();

                InterstitialAd.load(MainActivity.this,"ca-app-pub-6506972643290681/6339698717", adRequest,
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

    public FloatingActionButton getFloatingActionButton() {
        this.fab = fab;
        return fab;
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            //Mettre les questions dans Laquestion+ numero de la fiche sur 2 chiffres + 0 + numéro de la question sur 1 chiffre
            editor.clear();
            editor.commit();
            for (j = 1; j < 21; j++) {
                runOnUiThread(changeMessage);
                HttpHandler sh = new HttpHandler();
                // Making a request to url and getting response
                String jsonStr = sh.makeServiceCall(url + "D"+ String.valueOf(j));
                Log.e(TAG, "Response from url: " + jsonStr);
                if (jsonStr != null) {
                    try {
                        JSONObject jsonObj = new JSONObject(jsonStr);

                        // Getting JSON Array node
                        JSONArray questions = jsonObj.getJSONArray("D"+ String.valueOf(j));

                        // looping through All Contacts
                        for (int i = 0; i < questions.length(); i++) {
                            JSONObject c = questions.getJSONObject(i);

                            String question = c.getString("Question");
                            editor.putString("Fiche"+ String.valueOf(j)+ "Question" + String.valueOf(i+1), question);
                            editor.apply();

                            String reponse = c.getString("Réponse");
                            editor.putString("Fiche"+ String.valueOf(j) +"Reponse" + String.valueOf(i+1), reponse);
                            editor.apply();
                        }
                    } catch (final JSONException e) {
                        Log.e(TAG, "Json parsing error: " + e.getMessage());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context,
                                        "Json parsing error: " + e.getMessage(),
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                        });

                    }
                } else {
                    Log.e(TAG, "Couldn't get json from server.");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context,
                                    "Couldn't get json from server. Check LogCat for possible errors!",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            }
                return null;
        }



        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }


    private Runnable changeMessage = new Runnable() {
        @Override
        public void run() {
            //Log.v(TAG, strCharacters);
            pDialog.setMessage("Chargement des questions de la fiche écrite " + j + "/20");
        }
    };

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        //builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Êtes-vous sur(e) de vouloir quitter l'application ?")
                .setCancelable(false)
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        closeContextMenu();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


        /*
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_about) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            // set title
            alertDialogBuilder.setTitle("Informations");
            // set dialog message
            alertDialogBuilder
                    .setMessage("Application développée par Miguel ALBERT\nL'auteur vérifie la véracité des contenus fournis. Il décline toute responsabilité quant à l'inexatitude des informations.")
                    .setNegativeButton("Fermer",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();
            return true;
        }

        if (id == R.id.action_rgpd) {
            consentInformation.reset();
            consentement();
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            // set title
            alertDialogBuilder.setTitle("Réglages");
            // set dialog message
            alertDialogBuilder
                    .setMessage("Bientôt les réglages")
                    .setNegativeButton("Fermer",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();

            return true;

        }
        if (id == R.id.action_maj) {

                new GetContacts().execute();
            /*
            if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                //we are connected to a network
                connected = true;
                new GetContacts().execute();
            }
            else {
                connected = false;
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // set title
                alertDialogBuilder.setTitle("Connexion");
                // set dialog message
                alertDialogBuilder
                        .setMessage("Nous ne pouvons pas télécharger les fiches écrites car vous n'êtes pas connecté à Internet")
                        .setNegativeButton("Ok",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }*/

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_accueil) {

            MainFragment MainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,MainFragment)
                    .disallowAddToBackStack()
                    .commit();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }

        } else if (id == R.id.nav_fe_exam) {

            FEFragment FEFragment = new FEFragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,FEFragment)
                    .disallowAddToBackStack()
                    .commit();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
            fab.show();

        } else if (id == R.id.nav_fe_themes) {

            FEThemesFragment FEThemesFragment = new FEThemesFragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,FEThemesFragment)
                    .disallowAddToBackStack()
                    .commit();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
            fab.show();

        } else if (id == R.id.nav_verifs) {

            Verifs1Fragment Verifs1Fragment = new Verifs1Fragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,Verifs1Fragment)
                    .disallowAddToBackStack()
                    .commit();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
            fab.show();

        } else if (id == R.id.nav_themes) {

            ThemesFragment ThemesFragment = new ThemesFragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,ThemesFragment)
                    .disallowAddToBackStack()
                    .commit();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
            fab.show();

        } else if (id == R.id.nav_fo) {
            FOFragment FOFragment = new FOFragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,FOFragment)
                    .disallowAddToBackStack()
                    .commit();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
            fab.show();

        } else if (id == R.id.nav_verifs2) {

            Verifs2Fragment Verifs2Fragment = new Verifs2Fragment();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,Verifs2Fragment)
                    .disallowAddToBackStack()
                    .commit();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
            fab.show();

        } else if (id == R.id.nav_manoeuvres) {

            ViewPagerManoeuvres8_10 ViewPagerManoeuvres8_10 = new ViewPagerManoeuvres8_10();
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                    .replace(R.id.content_frame,ViewPagerManoeuvres8_10)
                    .disallowAddToBackStack()
                    .commit();
            if (mInterstitialAd != null) {
                mInterstitialAd.show(MainActivity.this);
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.");
            }
            fab.show();

        }   else if (id == R.id.nav_quit) {
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onResume(){
        super.onResume();
        loadAdd();
    }
    @Override
    public void onStart(){
        super.onStart();
        loadAdd();
    }
    public void onRestart(){
        super.onRestart();
        loadAdd();
    }
}
