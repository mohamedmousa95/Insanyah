package com.example.android.insanyah.ui.fragments;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.insanyah.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddDonationTwoFragment extends Fragment {

    String [] citiesNames;
    String [] areasNames;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_donation_two, container, false);
        this.view=view;

        Spinner dropdownCurrency = (Spinner)view.findViewById(R.id.spinner_currency_rep);
        String[] itemsCurrency = new String[]{getString(R.string.currency_eg),getString(R.string.currency_dollar)};
        ArrayAdapter<String> adapterCurrency = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, itemsCurrency);
        dropdownCurrency.setAdapter(adapterCurrency);

        Spinner dropdownCurrencyOnline = (Spinner)view.findViewById(R.id.spinner_currency_online);
        String[] itemsCurrencyOnline = new String[]{getString(R.string.currency_eg),getString(R.string.currency_dollar)};
        ArrayAdapter<String> adapterCurrencyOnline = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, itemsCurrencyOnline);
        dropdownCurrencyOnline.setAdapter(adapterCurrencyOnline);


        Spinner dropdownColTimeKind = (Spinner)view.findViewById(R.id.spinner_col_time_kind);
        String[] itemsColTimeKind = new String[]{getString(R.string.collection_time_1),getString(R.string.collection_time_2),getString(R.string.collection_time_3)};
        ArrayAdapter<String> adapterColTimeKind = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, itemsColTimeKind);
        dropdownColTimeKind.setAdapter(adapterColTimeKind);


        Spinner dropdownColTimeRep = (Spinner)view.findViewById(R.id.spinner_col_time_rep);
        String[] itemsColTimeRep = new String[]{getString(R.string.collection_time_1),getString(R.string.collection_time_2),getString(R.string.collection_time_3)};
        ArrayAdapter<String> adapterColTimeRep = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, itemsColTimeRep);
        dropdownColTimeRep.setAdapter(adapterColTimeRep);

        DatePicker datePickerRep = (DatePicker) view.findViewById(R.id.dp_datepicker_rep);
        datePickerRep.setMinDate(System.currentTimeMillis()-1000);

        DatePicker datePickerInKind = (DatePicker) view.findViewById(R.id.dp_datepicker_inkind);
        datePickerInKind.setMinDate(System.currentTimeMillis()-1000);

        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.SEND_SMS},1);

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest citiesRequest = new StringRequest(Request.Method.GET, "https://www.insanyah.com/api/CityApi/Get?CountryId=66", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("cities", response.toString());
                try {
                    JSONArray citiesArray = new JSONArray(response);
                    citiesNames=new String[citiesArray.length()];
                    for (int i = 0; i < citiesArray.length(); i++) {
                        JSONObject cityObject = citiesArray.getJSONObject(i);
                        String cityName = cityObject.getString("Name");
                        citiesNames[i]=cityName;
                        Log.v("name", cityName);
                    }
                    fillCityAdapter();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(citiesRequest);


        return view;
    }

    public void fillCityAdapter(){
        Log.v("da5lt","adapter");
        Spinner dropdownCityRep = (Spinner) view.findViewById(R.id.spinner_city_rep);
        ArrayAdapter<String> adapterCityRep = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, citiesNames);
        dropdownCityRep.setAdapter(adapterCityRep);

        Spinner dropdownCityKind = (Spinner) view.findViewById(R.id.spinner_city_kind);
        ArrayAdapter<String> adapterCityKind = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, citiesNames);
        dropdownCityKind.setAdapter(adapterCityKind);

        dropdownCityRep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                StringRequest citiesRequest = new StringRequest(Request.Method.GET, "https://www.insanyah.com/api/NeighborhoodApi/GetByCulture?cityId="+(position+1)+"&currentCulture=0", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.v("areas",response.toString());
                        try {
                            JSONArray areasArray = new JSONArray(response);
                            areasNames=new String[areasArray.length()];
                            for (int i = 0; i < areasArray.length(); i++) {
                                JSONObject cityObject = areasArray.getJSONObject(i);
                                String areaName = cityObject.getString("name");
                                areasNames[i]=areaName;
                                Log.v("name", areaName);
                            }

                            fillAreaAdapterRep();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(citiesRequest);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        dropdownCityKind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                StringRequest citiesRequest = new StringRequest(Request.Method.GET, "https://www.insanyah.com/api/NeighborhoodApi/GetByCulture?cityId="+(position+1)+"&currentCulture=0", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.v("areas",response.toString());
                        try {
                            JSONArray areasArray = new JSONArray(response);
                            areasNames=new String[areasArray.length()];
                            for (int i = 0; i < areasArray.length(); i++) {
                                JSONObject cityObject = areasArray.getJSONObject(i);
                                String areaName = cityObject.getString("name");
                                areasNames[i]=areaName;
                                Log.v("name", areaName);
                            }

                            fillAreaAdapterKind();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(citiesRequest);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void fillAreaAdapterRep(){
        Spinner dropdownRep = (Spinner) view.findViewById(R.id.spinner_neigbhorhood_rep);
        ArrayAdapter<String> adapterRep = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, areasNames);
        dropdownRep.setAdapter(adapterRep);
    }

    public void fillAreaAdapterKind(){
        Spinner dropdownKind = (Spinner) view.findViewById(R.id.spinner_neigbhorhood_kind);
        ArrayAdapter<String> adapterKind = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, areasNames);
        dropdownKind.setAdapter(adapterKind);
    }

}
