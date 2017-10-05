package com.example.android.insanyah.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.insanyah.R;

import java.util.ArrayList;

public class SelectInterest extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    int count = 0;
    ArrayList<String> interests=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_interest);


//
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }

//    public void loadLocale() {
//        String langPref = "Language";
//        SharedPreferences prefs = getSharedPreferences("CommonPrefs",
//                Activity.MODE_PRIVATE);
//        String language = prefs.getString(langPref, "");
//        changeLang(language);
//    }

//    public void setLocale(String lang) {
//        Locale myLocale = new Locale(lang);
//        Resources res = getResources();
//        DisplayMetrics dm = res.getDisplayMetrics();
//        Configuration conf = res.getConfiguration();
//        conf.locale = myLocale;
//        res.updateConfiguration(conf, dm);
////        finish();
//    }




    public void onClickElderly(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_elderly);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("18");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("18");
        }
    }

    public void onClickOrphans(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_orphans);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("2");
//            for(int i=0;i<interests.size();i++){
//                Log.v(i+" m",interests.get(i)+" m");
//            }
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("2");
//            for(int i=0;i<interests.size();i++){
//                Log.v(i+" m",interests.get(i)+" m");
//            }
        }
    }

    public void onClickPoverty(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_poverty);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("1");
//            for(int i=0;i<interests.size();i++){
//                Log.v(i+" m",interests.get(i)+" m");
//            }
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("1");
//           for(int i=0;i<interests.size();i++){
//                Log.v(i+" m",interests.get(i)+" m");
//            }
        }

    }

    public void onClickSpecialNeeds(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_special_needs);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("19");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("19");
        }
    }

    public void onClickNGOs(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_ngos);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("17");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("17");
        }
    }

    public void onClickHunger(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_hunger);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("36");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("36");
        }
    }

    public void onClickWater(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_water);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("34");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("34");
        }
    }

    public void onClickWomenEmp(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_women_emp);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("13");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("13");
        }
    }

    public void onClickYouth(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_youth);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("14");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("14");
        }
    }

    public void onClickEducation(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_education);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("6");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("6");
        }
    }

    public void onClickCulture(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_culture);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("22");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("22");
        }
    }


    public void onClickHealth(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_health);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("21");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("21");
        }
    }

    public void onClickCommSus(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_comm_sus);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("31");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("31");
        }
    }

    public void onClickPertnerships(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_pertnerships);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("25");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("25");
        }
    }

    public void onClickAgriculture(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_agriculture);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("7");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("7");
        }
    }

    public void onClickAnimals(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_animals);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("16");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("16");
        }
    }

    public void onClickUnderwaterLife(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_underwater_life);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("24");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("24");
        }
    }

    public void onClickEnvironment(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_environment);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("5");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("5");
        }
    }

    public void onClickClimateChange(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_climate_change);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("38");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("38");
        }
    }

    public void onClickTourism(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_tourism);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("8");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("8");
        }
    }

    public void onClickEconomics(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_economics);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("10");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("10");
        }
    }

    public void onClickResearch(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_research);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("3");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("3");
        }
    }

    public void onClickIndustry(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_industry);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("27");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("27");
        }
    }

    public void onClickEnergy(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_energy);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("35");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("35");
        }
    }

    public void onClickResponsibleCons(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_responsible_cons);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("39");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("39");
        }
    }

    public void onClickRefuges(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_refuges);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("11");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("11");
        }
    }

    public void onClickReduceIneq(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_reduce_ineq);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("29");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("29");
        }
    }

    public void onClickPeaceAndJustice(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_peace_and_justice);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("28");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("28");
        }
    }


    public void onClickGenderEquality(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_gender_equality);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("30");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("30");
        }
    }

    public void onClickLifeOnEarth(View view) {
        ImageView green = (ImageView) findViewById(R.id.shade_green_life_on_earth);
        if (green.getVisibility() == View.VISIBLE) {
            green.setVisibility(View.INVISIBLE);
            count--;
            interests.remove("32");
        } else {
            green.setVisibility(View.VISIBLE);
            count++;
            interests.add("32");
        }
    }

    public void confirmOnClick(View view) {
        if (count == 0) {
            Toast.makeText(getBaseContext(), getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
            return;
        }

//        for(int i=0;i<interests.size();i++){
//            Log.v("interests",interests.get(i));
//        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("interests",interests);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
//        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else

//        if(id == R.id.nav_news_feed){
//
//            LinearLayout newsFeed= (LinearLayout) findViewById(R.id.layout_news_feed);
//            newsFeed.setVisibility(View.VISIBLE);
//
//            LinearLayout mydoempty= (LinearLayout) findViewById(R.id.layout_my_donations_empty);
//            mydoempty.setVisibility(View.INVISIBLE);
//
//            LinearLayout mydonotempty= (LinearLayout) findViewById(R.id.layout_my_donations_not_empty);
//            mydonotempty.setVisibility(View.INVISIBLE);
//
//        }else if(id == R.id.nav_my_donations){
//
//            LinearLayout newsFeed= (LinearLayout) findViewById(R.id.layout_news_feed);
//            newsFeed.setVisibility(View.INVISIBLE);
//
//            LinearLayout mydoempty= (LinearLayout) findViewById(R.id.layout_my_donations_empty);
//            mydoempty.setVisibility(View.VISIBLE);
//
//            LinearLayout mydonotempty= (LinearLayout) findViewById(R.id.layout_my_donations_not_empty);
//            mydonotempty.setVisibility(View.INVISIBLE);
//
//        }else if (id == R.id.nav_about) {
//            Intent intent = new Intent(this, About.class);
//            startActivity(intent);
//
//        }else if(id == R.id.nav_settings){
//            Intent intent = new Intent(this, Settings.class);
//            startActivity(intent);
//        }else if(id==R.id.nav_share){
//
//        }else if(id==R.id.nav_select_interests){
//            Intent intent = new Intent(this, SelectInterest.class);
//            startActivity(intent);
//        }
//
//        else if (id == R.id.nav_send) {
//
//        }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
