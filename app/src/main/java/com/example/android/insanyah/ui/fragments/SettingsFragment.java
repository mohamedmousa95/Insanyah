package com.example.android.insanyah.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.android.insanyah.R;

import java.util.Locale;

import com.example.android.insanyah.ui.activities.MainActivity;


public class SettingsFragment extends Fragment {

    boolean flag=false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settingss, container, false);
        Log.v("on create view","settings fragment");

        Spinner dropdownLang = (Spinner) view.findViewById(R.id.spinner_language);
        String[] itemsLang = new String[]{"English", "عربي"};
        ArrayAdapter<String> adapterLang = new ArrayAdapter(getActivity(), R.layout.item_spinner, itemsLang);
        dropdownLang.setAdapter(adapterLang);

        if (loadLocale().equals("en")) {
            dropdownLang.setSelection(0);
        } else if (loadLocale().equals("ar")) {
            dropdownLang.setSelection(1);
        }

        dropdownLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    changeLang("en");
                    if(flag){
//                        Intent intent = new Intent(getActivity(), MainActivity.class);
//                        startActivity(intent);

//                        Class fragclass = SettingsFragment.class;
//                        Fragment fragment=null;
//                        try {
//                            fragment=(Fragment) fragclass.newInstance();
//                        } catch (InstantiationException e) {
//                            e.printStackTrace();
//                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
//                        } catch (java.lang.InstantiationException e) {
//                            e.printStackTrace();
//                        }
//                        getFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).commit();

                        Intent refresh = new Intent(getActivity(), MainActivity.class);
                        refresh.putExtra("type","settings");
                        startActivity(refresh);
                        getActivity().finish();
                    }
                    flag=true;
                    Log.v("hnaa","en");

                } else {
                    changeLang("ar");
                    if(flag){
//                        Intent intent = new Intent(getActivity(), MainActivity.class);
//                        startActivity(intent);

//                        Class fragclass = SettingsFragment.class;
//                            Fragment fragment=null;
//                            try {
//                                fragment=(Fragment) fragclass.newInstance();
//                            } catch (InstantiationException e) {
//                                e.printStackTrace();
//                            } catch (IllegalAccessException e) {
//                                e.printStackTrace();
//                            } catch (java.lang.InstantiationException e) {
//                                e.printStackTrace();
//                        }
//                        getFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).commit();

                        Intent refresh = new Intent(getActivity(), MainActivity.class);
                        refresh.putExtra("type","settings");
                        startActivity(refresh);
                        getActivity().finish();
                    }
                    flag=true;
                    Log.v("hnaa","ar");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;

    }

    public String loadLocale() {
        String langPref = "Language";
        SharedPreferences prefs = getActivity().getSharedPreferences("CommonPrefs",
                Activity.MODE_PRIVATE);
        String language = prefs.getString(langPref, "");
        return language;
    }




    public void changeLang(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        Locale myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getActivity().getResources().updateConfiguration(config, getActivity().getResources().getDisplayMetrics());
//        Intent intent = new Intent(getBaseContext(), Settings.class);
//        startActivity(intent);

    }

    public void saveLocale(String lang) {
        String langPref = "Language";
        SharedPreferences prefs = getActivity().getSharedPreferences("CommonPrefs",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }





    }
