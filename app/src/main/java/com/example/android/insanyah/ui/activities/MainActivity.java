package com.example.android.insanyah.ui.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.insanyah.R;

import com.example.android.insanyah.ui.fragments.AboutFragment;
import com.example.android.insanyah.ui.fragments.AddDonationOneFragment;
import com.example.android.insanyah.ui.fragments.AddDonationThreeFragment;
import com.example.android.insanyah.ui.fragments.AddDonationTwoFragment;
import com.example.android.insanyah.ui.fragments.MyDonationsNotEmptyFragment;
import com.example.android.insanyah.ui.fragments.NewsFeedFragment;
import com.example.android.insanyah.ui.fragments.SettingsFragment;
import com.example.android.insanyah.ui.fragments.ThankYouFragment;
import com.example.android.insanyah.ui.fragments.ViewPlanFragment;
import com.example.android.insanyah.ui.fragments.ViewReportFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    Fragment   fragment;
    Class fragclass;

    boolean buttonOnlineFifty=false;
    boolean buttonOnlineHundred=false;
    boolean buttonOnlineTwoHundred=false;

    boolean buttonRepFifty=false;
    boolean buttonRepHundred=false;
    boolean buttonRepTwoHundred=false;

//    private int progressStatus = 0;
//    private Handler handler = new Handler();

//
//    boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragclass = AddDonationThreeFragment.class;
        fragclass = NewsFeedFragment.class;
        try {
            fragment=(Fragment) fragclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();

//        fragclass = AddDonationThreeFragment.class;
//        try {
//            fragment=(Fragment) fragclass.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).commit();


        String response=getIntent().getStringExtra("type");
        if(response!=null){
            if(response.equals("settings")){
                fragclass = SettingsFragment.class;
                try {
                    fragment=(Fragment) fragclass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
            }
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news_feed) {

//            LinearLayout newsFeed = (LinearLayout) findViewById(R.id.layout_news_feed);
//            newsFeed.setVisibility(View.VISIBLE);
//
//            LinearLayout mydoempty = (LinearLayout) findViewById(R.id.layout_my_donations_empty);
//            mydoempty.setVisibility(View.INVISIBLE);
//
//            LinearLayout mydonotempty = (LinearLayout) findViewById(R.id.layout_my_donations_not_empty);
//            mydonotempty.setVisibility(View.INVISIBLE);

            fragclass = NewsFeedFragment.class;
            try {
                fragment=(Fragment) fragclass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();

//            LinearLayout newsFeed = (LinearLayout) findViewById(R.id.layout_news_feed);
//            newsFeed.setVisibility(View.VISIBLE);
//
//            LinearLayout mydoempty = (LinearLayout) findViewById(R.id.layout_my_donations_empty);
//            mydoempty.setVisibility(View.INVISIBLE);
//
//            LinearLayout mydonotempty = (LinearLayout) findViewById(R.id.layout_my_donations_not_empty);
//            mydonotempty.setVisibility(View.INVISIBLE);

            Log.v("hnaa","newsfeed");

        } else if (id == R.id.nav_my_donations) {

//            LinearLayout newsFeed = (LinearLayout) findViewById(R.id.layout_news_feed);
//            newsFeed.setVisibility(View.INVISIBLE);
//
//            LinearLayout mydoempty = (LinearLayout) findViewById(R.id.layout_my_donations_empty);
//            mydoempty.setVisibility(View.VISIBLE);
//
//            LinearLayout mydonotempty = (LinearLayout) findViewById(R.id.layout_my_donations_not_empty);
//            mydonotempty.setVisibility(View.INVISIBLE);

            fragclass = MyDonationsNotEmptyFragment.class;
            try {
                fragment=(Fragment) fragclass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();

//            LinearLayout newsFeed = (LinearLayout) findViewById(R.id.layout_news_feed);
//            newsFeed.setVisibility(View.INVISIBLE);
//
//            LinearLayout mydoempty = (LinearLayout) findViewById(R.id.layout_my_donations_empty);
//            mydoempty.setVisibility(View.VISIBLE);
//
//            LinearLayout mydonotempty = (LinearLayout) findViewById(R.id.layout_my_donations_not_empty);
//            mydonotempty.setVisibility(View.INVISIBLE);

            Log.v("hnaa","mydonations");

        } else if (id == R.id.nav_contact_us) {
//            Intent intent = new Intent(this, About.class);
//            startActivity(intent);

            fragclass = AboutFragment.class;
            try {
                fragment=(Fragment) fragclass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();

        } else if (id == R.id.nav_settings) {
//            Intent intent = new Intent(this, Settings.class);
//            startActivity(intent);

            fragclass = SettingsFragment.class;
            try {
                fragment=(Fragment) fragclass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();



//            Fragment frg = getSupportFragmentManager().findFragmentById(R.id.fragment_place_holder);
//            final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.detach(frg);
//            ft.attach(frg);
//            ft.commit();

//            FragmentManager manager = getSupportFragmentManager();
//            FragmentTransaction ft = manager.beginTransaction();
//            Fragment newFragment = this;
//            this.onDestroy();
//            ft.remove(this);
//            ft.replace(container.getId(),newFragment);
//            //container is the ViewGroup of current fragment
//            ft.addToBackStack(null);
//            ft.commit();

//            Spinner dropdownLang = (Spinner)getSupportFragmentManager().findFragmentById(R.id.fragment_place_holder).getView().findViewById(R.id.spinner_language);
//            String[] itemsLang = new String[]{"English", "عربي"};
//            ArrayAdapter<String> adapterLang = new ArrayAdapter(this, R.layout.item_spinner, itemsLang);
//
//            if(getSupportFragmentManager().findFragmentById(R.id.fragment_place_holder)==null){
//                Log.v("1","null");
//            }
//
//            if(getSupportFragmentManager().findFragmentById(R.id.fragment_place_holder).getView()==null){
//                Log.v("2","null");
//            }
//
//            if(getSupportFragmentManager().findFragmentById(R.id.fragment_place_holder).getView().findViewById(R.id.spinner_language)==null){
//                Log.v("3","null");
//            }
//            if(dropdownLang==null){
//                Log.v("dropdownLang","null");
//            }
//
//            if(adapterLang==null){
//                Log.v("adapterLang","null");
//            }
//            dropdownLang.setAdapter(adapterLang);
//
//            if (loadLocale().equals("en")) {
//                dropdownLang.setSelection(0);
//            } else if (loadLocale().equals("ar")) {
//                dropdownLang.setSelection(1);
//            }
//
//            dropdownLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    if (position == 0) {
//                        if(flag){
//                            Intent intent = new Intent(getBaseContext(), Settings.class);
//                            startActivity(intent);
//                        }
//                        flag=true;
//                        Log.v("hnaa","en");
//                        changeLang("en");
//
//                    } else {
//                        if(flag){
//                            Intent intent = new Intent(getBaseContext(), Settings.class);
//                            startActivity(intent);
//                        }
//                        flag=true;
//                        Log.v("hnaa","ar");
//                        changeLang("ar");
////                    Intent intent = new Intent(getBaseContext(), Settings.class);
////                    startActivity(intent);
//                    }
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parent) {
//
//                }
//            });

        } else if (id == R.id.nav_share) {

        }else if(id==R.id.nav_select_interests){
            Intent intent = new Intent(this, SelectInterest.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }


//    public void onClickCharity(View view){
////        Intent intent = new Intent(this, ViewPlan.class);
////        startActivity(intent);
//
//        fragclass = CharityFragment.class;
//        try {
//            fragment=(Fragment) fragclass.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//
//
////        Bundle bundle = new Bundle();
////        bundle.putString("ngoID",((com.example.android.insanyah.Helpers.Donate)donates.get(getAdapterPosition())).charityID );
////        fragment.setArguments(bundle);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
//    }


    public void onClickLike(View view) {
        ImageView like = (ImageView) findViewById(R.id.like);
        ImageView likeRed = (ImageView) findViewById(R.id.likeRed);
        like.setVisibility(View.INVISIBLE);
        likeRed.setVisibility(View.VISIBLE);
    }

    public void onClickRedLike(View view) {
        ImageView like = (ImageView) findViewById(R.id.like);
        ImageView likeRed = (ImageView) findViewById(R.id.likeRed);
        like.setVisibility(View.VISIBLE);
        likeRed.setVisibility(View.INVISIBLE);
    }

    public void onClickShare(View view) {
        ImageView share = (ImageView) findViewById(R.id.share);
        ImageView shareRed = (ImageView) findViewById(R.id.shareRed);
        share.setVisibility(View.INVISIBLE);
        shareRed.setVisibility(View.VISIBLE);
    }

    public void onClickRedShare(View view) {
        ImageView share = (ImageView) findViewById(R.id.share);
        ImageView shareRed = (ImageView) findViewById(R.id.shareRed);
        share.setVisibility(View.VISIBLE);
        shareRed.setVisibility(View.INVISIBLE);
    }




    public void viewPlan(View view){
//        Intent intent = new Intent(this, ViewPlan.class);
//        startActivity(intent);

        fragclass = ViewPlanFragment.class;
        try {
            fragment=(Fragment) fragclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
    }

    public void viewReport(View view){
//        Intent intent = new Intent(this, ViewReport.class);
//        startActivity(intent);

        fragclass = ViewReportFragment.class;
        try {
            fragment=(Fragment) fragclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
    }






    public void onClickChangePlan(View view){
//        Intent intent=new Intent(this,AddDonationOne.class);
//        startActivity(intent);  fragclass = NewsFeedFragment.class;

        fragclass = AddDonationOneFragment.class;
        try {
            fragment=(Fragment) fragclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
    }


//    public String loadLocale() {
//        String langPref = "Language";
//        SharedPreferences prefs = getSharedPreferences("CommonPrefs",
//                Activity.MODE_PRIVATE);
//        String language = prefs.getString(langPref, "");
//        return language;
////        changeLang(language);
//    }
//
//    public void changeLang(String lang) {
//        if (lang.equalsIgnoreCase(""))
//            return;
//        Locale myLocale = new Locale(lang);
//        saveLocale(lang);
//        Locale.setDefault(myLocale);
//        android.content.res.Configuration config = new android.content.res.Configuration();
//        config.locale = myLocale;
//        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
////        Intent intent = new Intent(getBaseContext(), Settings.class);
////        startActivity(intent);
//    }

    public void saveLocale(String lang) {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }

    public void stageTwo(View view) {
//        Intent intent = new Intent(this, AddDonationTwo.class);
//        startActivity(intent);

        fragclass = AddDonationTwoFragment.class;
        try {
            fragment=(Fragment) fragclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
    }

    public void stageThree(View view) {
//        Intent intent = new Intent(this, AddDonationThree.class);
//        startActivity(intent);
        fragclass = AddDonationThreeFragment.class;
        try {
            fragment=(Fragment) fragclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
    }


    public void onClickRep(View view) {
        LinearLayout rep = (LinearLayout) findViewById(R.id.layout_rep);
        LinearLayout online = (LinearLayout) findViewById(R.id.layout_online);
        LinearLayout inKind = (LinearLayout) findViewById(R.id.layout_in_kind);

        rep.setVisibility(View.VISIBLE);
        online.setVisibility(View.INVISIBLE);
        inKind.setVisibility(View.INVISIBLE);

        ImageView onlineBorder=(ImageView) findViewById(R.id.online_black_border);
        onlineBorder.setVisibility(View.INVISIBLE);

        ImageView repBorder=(ImageView) findViewById(R.id.rep_black_border);
        repBorder.setVisibility(View.VISIBLE);

        ImageView inKindBorder=(ImageView) findViewById(R.id.in_kind_black_border);
        inKindBorder.setVisibility(View.INVISIBLE);
    }

    public void onClickInKind(View view) {

        LinearLayout rep = (LinearLayout) findViewById(R.id.layout_rep);
        LinearLayout online = (LinearLayout) findViewById(R.id.layout_online);
        LinearLayout inKind = (LinearLayout) findViewById(R.id.layout_in_kind);

        rep.setVisibility(View.INVISIBLE);
        online.setVisibility(View.INVISIBLE);
        inKind.setVisibility(View.VISIBLE);

        ImageView onlineBorder=(ImageView) findViewById(R.id.online_black_border);
        onlineBorder.setVisibility(View.INVISIBLE);

        ImageView repBorder=(ImageView) findViewById(R.id.rep_black_border);
        repBorder.setVisibility(View.INVISIBLE);

        ImageView inKindBorder=(ImageView) findViewById(R.id.in_kind_black_border);
        inKindBorder.setVisibility(View.VISIBLE);
    }

    public void onClickOnline(View view) {

        LinearLayout rep = (LinearLayout) findViewById(R.id.layout_rep);
        LinearLayout online = (LinearLayout) findViewById(R.id.layout_online);
        LinearLayout inKind = (LinearLayout) findViewById(R.id.layout_in_kind);

        rep.setVisibility(View.INVISIBLE);
        online.setVisibility(View.VISIBLE);
        inKind.setVisibility(View.INVISIBLE);

        ImageView onlineBorder=(ImageView) findViewById(R.id.online_black_border);
        onlineBorder.setVisibility(View.VISIBLE);

        ImageView repBorder=(ImageView) findViewById(R.id.rep_black_border);
        repBorder.setVisibility(View.INVISIBLE);

        ImageView inKindBorder=(ImageView) findViewById(R.id.in_kind_black_border);
        inKindBorder.setVisibility(View.INVISIBLE);
    }

    public void onClickSMS(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle(R.string.insanyah);
        alertDialog.setMessage(R.string.sms_message);
        alertDialog.setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendSMS("01117773460","insanyah");
                dialog.dismiss();

            }
        });

        alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }

    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
            Log.v("errorr",ex.getMessage().toString());
        }
    }

    public void confirm(View view){
//        Intent intent = new Intent(this, ThankYou.class);
//        startActivity(intent);
        fragclass = ThankYouFragment.class;
        try {
            fragment=(Fragment) fragclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
    }


    public void donate(View view){
//        Intent intent = new Intent(this, AddDonationOne.class);
//        startActivity(intent);
        fragclass = AddDonationOneFragment.class;
        try {
            fragment=(Fragment) fragclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
    }


    public void onClickDonations(View view) {
        LinearLayout donations = (LinearLayout) findViewById(R.id.layout_donations);
        donations.setVisibility(View.VISIBLE);

        LinearLayout volunteers = (LinearLayout) findViewById(R.id.layout_volunteers);
        volunteers.setVisibility(View.INVISIBLE);

        LinearLayout aboutus = (LinearLayout) findViewById(R.id.layout_about_us);
        aboutus.setVisibility(View.INVISIBLE);

        Button buttonDonations=(Button) findViewById(R.id.button_donations);
        Button buttonVolunteers=(Button) findViewById(R.id.button_volunteers);
        Button buttonMedia=(Button) findViewById(R.id.button_media);
        Button buttonAbout=(Button) findViewById(R.id.button_about_us);

        buttonDonations.setBackgroundColor(Color.TRANSPARENT);
        buttonVolunteers.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
        buttonMedia.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
        buttonAbout.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
    }

    public void onClickVolunteers(View view) {
        LinearLayout donations = (LinearLayout) findViewById(R.id.layout_donations);
        donations.setVisibility(View.INVISIBLE);

        LinearLayout volunteers = (LinearLayout) findViewById(R.id.layout_volunteers);
        volunteers.setVisibility(View.VISIBLE);

        LinearLayout aboutus = (LinearLayout) findViewById(R.id.layout_about_us);
        aboutus.setVisibility(View.INVISIBLE);

        Button buttonDonations=(Button) findViewById(R.id.button_donations);
        Button buttonVolunteers=(Button) findViewById(R.id.button_volunteers);
        Button buttonMedia=(Button) findViewById(R.id.button_media);
        Button buttonAbout=(Button) findViewById(R.id.button_about_us);

        buttonDonations.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
        buttonVolunteers.setBackgroundColor(Color.TRANSPARENT);
        buttonMedia.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
        buttonAbout.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
    }

    public void onClickMedia(View view) {
        LinearLayout donations = (LinearLayout) findViewById(R.id.layout_donations);
        donations.setVisibility(View.INVISIBLE);

        LinearLayout volunteers = (LinearLayout) findViewById(R.id.layout_volunteers);
        volunteers.setVisibility(View.INVISIBLE);

        LinearLayout aboutus = (LinearLayout) findViewById(R.id.layout_about_us);
        aboutus.setVisibility(View.INVISIBLE);

        Button buttonDonations=(Button) findViewById(R.id.button_donations);
        Button buttonVolunteers=(Button) findViewById(R.id.button_volunteers);
        Button buttonMedia=(Button) findViewById(R.id.button_media);
        Button buttonAbout=(Button) findViewById(R.id.button_about_us);

        buttonDonations.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
        buttonVolunteers.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
        buttonMedia.setBackgroundColor(Color.TRANSPARENT);
        buttonAbout.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));

    }

//    public void onClickTimeline(View view) {
//        RelativeLayout timeline = (RelativeLayout) findViewById(R.id.layout_timeline);
//        timeline.setVisibility(View.VISIBLE);
//
//        RelativeLayout aboutus = (RelativeLayout) findViewById(R.id.layout_about_us);
//        aboutus.setVisibility(View.INVISIBLE);
//    }

    public void onClickAboutUs(View view) {
//        RelativeLayout timeline = (RelativeLayout) findViewById(R.id.layout_timeline);
//        timeline.setVisibility(View.INVISIBLE);

        LinearLayout donations = (LinearLayout) findViewById(R.id.layout_donations);
        donations.setVisibility(View.INVISIBLE);

        LinearLayout volunteers = (LinearLayout) findViewById(R.id.layout_volunteers);
        volunteers.setVisibility(View.INVISIBLE);

        LinearLayout aboutus = (LinearLayout) findViewById(R.id.layout_about_us);
        aboutus.setVisibility(View.VISIBLE);

        Button buttonDonations=(Button) findViewById(R.id.button_donations);
        Button buttonVolunteers=(Button) findViewById(R.id.button_volunteers);
        Button buttonMedia=(Button) findViewById(R.id.button_media);
        Button buttonAbout=(Button) findViewById(R.id.button_about_us);

        buttonDonations.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
        buttonVolunteers.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
        buttonMedia.setBackground(ContextCompat.getDrawable(getBaseContext(),R.color.colorWhite));
        buttonAbout.setBackgroundColor(Color.TRANSPARENT);
    }

    public void onClickNewCard(View view){
        LinearLayout newCard = (LinearLayout) findViewById(R.id.new_card);
        newCard.setVisibility(View.VISIBLE);

        LinearLayout existingCard = (LinearLayout) findViewById(R.id.existing_card);
        existingCard.setVisibility(View.INVISIBLE);
    }

    public void onClickExistingCard(View view){
        LinearLayout newCard = (LinearLayout) findViewById(R.id.new_card);
        newCard.setVisibility(View.INVISIBLE);

        LinearLayout existingCard = (LinearLayout) findViewById(R.id.existing_card);
        existingCard.setVisibility(View.VISIBLE);
    }

    public void onClickAmount(View view){
        if(view==findViewById(R.id.button_online_fifty)){
//             Log.v("amount","fifty");
            Button buttonFifty=(Button) findViewById(R.id.button_online_fifty);
            Button buttonHundred=(Button) findViewById(R.id.button_online_hundred);
            Button buttonTwoHundred=(Button) findViewById(R.id.button_online_two_hundred);

            if(buttonOnlineFifty==false){
                buttonFifty.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorWhite));
                buttonFifty.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_selected));
                buttonOnlineFifty=true;
                buttonHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonOnlineHundred=false;
                buttonTwoHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonTwoHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonOnlineTwoHundred=false;
//                Log.v("amount","hnaa1");
            }else{
                buttonFifty.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonFifty.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonOnlineFifty=false;
//                Log.v("amount","hnaa2");
            }
        }else if(view ==findViewById(R.id.button_online_hundred)){

            Button buttonFifty=(Button) findViewById(R.id.button_online_fifty);
            Button buttonHundred=(Button) findViewById(R.id.button_online_hundred);
            Button buttonTwoHundred=(Button) findViewById(R.id.button_online_two_hundred);
            if(buttonOnlineHundred==false){
                buttonHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorWhite));
                buttonHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_selected));
                buttonOnlineHundred=true;
                buttonFifty.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonFifty.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonOnlineFifty=false;
                buttonTwoHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonTwoHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonOnlineTwoHundred=false;
            }else{
                buttonHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonOnlineHundred=false;
            }

        }else if(view == findViewById(R.id.button_online_two_hundred)){
//            Log.v("amount","two hundreed");
            Button buttonFifty=(Button) findViewById(R.id.button_online_fifty);
            Button buttonHundred=(Button) findViewById(R.id.button_online_hundred);
            Button buttonTwoHundred=(Button) findViewById(R.id.button_online_two_hundred);
            if(buttonOnlineTwoHundred==false){
                buttonTwoHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorWhite));
                buttonTwoHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_selected));
                buttonOnlineTwoHundred=true;
                buttonFifty.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonFifty.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonOnlineFifty=false;
                buttonHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonOnlineHundred=false;
            }else{
                buttonTwoHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonTwoHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonOnlineTwoHundred=false;
            }

        }



        if(view==findViewById(R.id.button_rep_fifty)){
//             Log.v("amount","fifty");
            Button buttonHundred=(Button) findViewById(R.id.button_rep_hundred);
            Button buttonFifty=(Button) findViewById(R.id.button_rep_fifty);
            Button buttonTwoHundred=(Button) findViewById(R.id.button_rep_two_hundred);
            if(buttonRepFifty==false){
                buttonFifty.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorWhite));
                buttonFifty.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_selected));
                buttonRepFifty=true;
                buttonHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonRepHundred=false;
                buttonTwoHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonTwoHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonRepTwoHundred=false;
//                Log.v("amount","hnaa1");
            }else{
                buttonFifty.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonFifty.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonRepFifty=false;
//                Log.v("amount","hnaa2");
            }
        }else if(view ==findViewById(R.id.button_rep_hundred)){

            Button buttonHundred=(Button) findViewById(R.id.button_rep_hundred);
            Button buttonFifty=(Button) findViewById(R.id.button_rep_fifty);
            Button buttonTwoHundred=(Button) findViewById(R.id.button_rep_two_hundred);

            if(buttonRepHundred==false){
                buttonHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorWhite));
                buttonHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_selected));
                buttonRepHundred=true;
                buttonFifty.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonFifty.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonRepFifty=false;
                buttonTwoHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonTwoHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonRepTwoHundred=false;
            }else{
                buttonHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonRepHundred=false;
            }

        }else if(view == findViewById(R.id.button_rep_two_hundred)){
//            Log.v("amount","two hundreed");
            Button buttonHundred=(Button) findViewById(R.id.button_rep_hundred);
            Button buttonFifty=(Button) findViewById(R.id.button_rep_fifty);
            Button buttonTwoHundred=(Button) findViewById(R.id.button_rep_two_hundred);
            if(buttonRepTwoHundred==false){
                buttonTwoHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorWhite));
                buttonTwoHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_selected));
                buttonRepTwoHundred=true;
                buttonFifty.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonFifty.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonRepFifty=false;
                buttonHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonRepHundred=false;
            }else{
                buttonTwoHundred.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.colorPrimary));
                buttonTwoHundred.setBackground(ContextCompat.getDrawable(getBaseContext(),R.drawable.button_border));
                buttonRepTwoHundred=false;
            }

        }
    }



}
