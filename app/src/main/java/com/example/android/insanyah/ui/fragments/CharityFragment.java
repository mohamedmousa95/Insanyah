package com.example.android.insanyah.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.insanyah.Helpers.Constants;
import com.example.android.insanyah.Helpers.Requests;
import com.example.android.insanyah.R;
import com.example.android.insanyah.adapters.DonationsAdapter;
import com.example.android.insanyah.adapters.VolunteersAdapter;
import com.example.android.insanyah.datamodels.PostDataModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class CharityFragment extends Fragment {

//    RequestQueue requestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_charity, container, false);

        Button buttonDonations=(Button) view.findViewById(R.id.button_donations);
        buttonDonations.setBackgroundColor(Color.TRANSPARENT);


        String NGOID = getArguments().getString("ngoID");

        Log.v("charity image again", NGOID);

        LinearLayout donations = (LinearLayout) view.findViewById(R.id.layout_donations);
        donations.setVisibility(View.VISIBLE);

        final RecyclerView donateRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_donation_item);
        final RecyclerView volunteerRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_volunteer_item);

        LinearLayoutManager layoutManagerDonate = new LinearLayoutManager(getActivity());
        LinearLayoutManager layoutManagerVolunteer = new LinearLayoutManager(getActivity());


        DividerItemDecoration dividerItemDecorationDonate = new DividerItemDecoration(donateRecyclerView.getContext(),
                layoutManagerDonate.getOrientation());
        DividerItemDecoration dividerItemDecorationVolunteer = new DividerItemDecoration(volunteerRecyclerView.getContext(),
                layoutManagerVolunteer.getOrientation());

        donateRecyclerView.setLayoutManager(layoutManagerDonate);
        donateRecyclerView.addItemDecoration(dividerItemDecorationDonate);

        volunteerRecyclerView.setLayoutManager(layoutManagerVolunteer);
        volunteerRecyclerView.addItemDecoration(dividerItemDecorationVolunteer);

        String url=Constants.BASE_URL + Constants.GET_DONATIONS_POSTS+"?ngoId=" + NGOID + "&offset=1";
        Log.v("charity donations url",url);
        Requests.getRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String respo=response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: "+respo);
                        Toast.makeText(getActivity(), respo, Toast.LENGTH_SHORT).show();

                        PostDataModel[] postDataModel=new Gson().fromJson(respo,PostDataModel[].class);
                        DonationsAdapter newsFeedAdapter= new DonationsAdapter(getActivity(),postDataModel.length, Arrays.asList(postDataModel));
                        donateRecyclerView.setAdapter(newsFeedAdapter);
                    }
                });
            }
        });


        Requests.getRequest(Constants.BASE_URL + Constants.GET_VOLUNTEERS_POSTS+"?ngoId=" + NGOID + "&offset=1", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String respo=response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: "+respo);
                        Toast.makeText(getActivity(), respo, Toast.LENGTH_SHORT).show();

                        PostDataModel[] postDataModel=new Gson().fromJson(respo,PostDataModel[].class);
                        VolunteersAdapter newsFeedAdapter= new VolunteersAdapter(getActivity(),postDataModel.length, Arrays.asList(postDataModel));
                        volunteerRecyclerView.setAdapter(newsFeedAdapter);
                    }
                });
            }
        });





//        FormBody.Builder formBulilder=new FormBody.Builder();
//
//        formBulilder.add("Offset","1");
//        formBulilder.add("InterestsIds","5");
//
//        RequestBody requestBody=formBulilder.build();
//
//        Requests.postRequest(Constants.BASE_URL + Constants.GET_NEWS_FEEDS_POSTS,requestBody, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final String respo=response.body().string();
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.d(TAG, "run: "+respo);
//                        Toast.makeText(getActivity(), respo, Toast.LENGTH_SHORT).show();
//
//                        PostDataModel[] postDataModel=new Gson().fromJson(respo,PostDataModel[].class);
//                        NewsFeedAdapter newsFeedAdapter= new NewsFeedAdapter(getActivity(), Arrays.asList(postDataModel));
//                        donateRecyclerView.setAdapter(newsFeedAdapter);
//                    }
//                });
//
//            }
//        });


//        requestQueue = Volley.newRequestQueue(getActivity());
//
//        requestDonate("fc558353-b4b6-4a57-9b69-689219e40a41", donateRecyclerView, NGOID);
//        requestVolunteer("fc558353-b4b6-4a57-9b69-689219e40a41", volunteerRecyclerView, NGOID);
        return view;
    }

//
//    public void requestDonate(String apiKey, final RecyclerView recyclerView, String ngoID) {
//
//        Log.v("ngo id",ngoID);
//        Log.v("7aamaadaaa","7amaaaddaaaaa");
//        String url = "http://ensaneia.com/api/Post/GetNgoDoantionsPosts?ngoId=" + ngoID + "&offset=1";
//        Map<String, String> headers = new HashMap<>();
//        headers.put("X-ApiKey", apiKey);
//
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, null, headers, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Log.d("Response: ", response.toString());
//                Log.v("resss", response.toString());
//                Log.v("length", response.length() + "");
//
//                ArrayList<Donate> donates = new ArrayList<>();
//
//                for (int i = 0; i < response.length(); i++) {
//                    JSONObject charityObject;
//                    try {
//                        charityObject = response.getJSONObject(i);
//
////                            Log.v("is donation", "yes");
//
//                        String charityImage = charityObject.getString("AccountImage");
//                        String charityCreatedTime = charityObject.getString("CreatedTime");
//
//                        ArrayList<String> interestsNames = new ArrayList<>();
//                        JSONArray interestsArray = charityObject.getJSONArray("Interests");
//                        for (int j = 0; j < interestsArray.length() && j < 3; j++) {
//                            String interestName = interestsArray.getJSONObject(j).getString("Name");
//                            interestsNames.add(interestName);
//                            Log.v("interests name", interestName);
//                        }
//
//                        JSONObject donation = charityObject.getJSONObject("DonationModel");
//
//                        String donationName = donation.getString("Name");
//                        String donationLogo = donation.getString("Logo");
//                        String donationDetails = donation.getString("Details");
//                        String likesCount = charityObject.getString("LikesCount");
//                        String targetAmountDouble = donation.getString("TargetAmount");
//                        String targetRecieved = donation.getString("TargetRecieved");
//                        String charityName = donation.getString("NgoName");
//                        String charityID = donation.getString("NgoID");
//                        String currency = donation.getString("Currency");
//
//                        int targetAmountInt = (int) Double.parseDouble(targetAmountDouble);
//                        int targetRecInt = (int) Double.parseDouble(targetRecieved);
//                        String targetAmount = targetAmountInt + "";
//
//                        int targetRemainingInt = targetAmountInt - targetRecInt;
//                        String targetRemaining = targetRemainingInt + "";
//
//                        Donate donate = new Donate(charityImage, charityCreatedTime, donationName, donationLogo, donationDetails, likesCount, targetAmount, targetRemaining, charityName, charityID, interestsNames,currency);
//                        donates.add(donate);
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//                Log.v("number of donates", donates.size() + "");
//                DonationsAdapter adapter = new DonationsAdapter(getActivity(), donates.size(), donates);
//                recyclerView.setAdapter(adapter);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.v("err", error.toString());
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }

//
//    public void requestVolunteer(String apiKey, final RecyclerView recyclerView, String ngoID) {
//
//        Log.v("ngo id",ngoID);
//        Log.v("7aamaadaaa","7amaaaddaaaaa");
//
//        String url = "http://ensaneia.com/api/Post/GetNgoVolunteersPosts?ngoId=" + ngoID + "&offset=1";
//        Map<String, String> headers = new HashMap<>();
//        headers.put("X-ApiKey", apiKey);
//
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, null, headers, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Log.d("Response: ", response.toString());
//                Log.v("resss", response.toString());
//                Log.v("length", response.length() + "");
//
//                ArrayList<Volunteer> volunteers = new ArrayList<>();
//
//                for (int i = 0; i < response.length(); i++) {
//                    JSONObject charityObject;
//                    try {
//                        charityObject = response.getJSONObject(i);
//
//                        String charityImage = charityObject.getString("AccountImage");
//                        String charityCreatedTime = charityObject.getString("CreatedTime");
//
//                        ArrayList<String> interestsNames = new ArrayList<>();
//                        JSONArray interestsArray = charityObject.getJSONArray("Interests");
//                        for (int j = 0; j < interestsArray.length() && j < 3; j++) {
//                            String interestName = interestsArray.getJSONObject(j).getString("Name");
//                            interestsNames.add(interestName);
////                                Log.v("interests name",interestName);
//                        }
//
//
//                        JSONObject volunteering = charityObject.getJSONObject("Volunteers");
//
//                        String volunteeringName = volunteering.getString("Name");
//                        String volunteeringDetails = volunteering.getString("Details");
//                        String charityName = volunteering.getString("NgoName");
//                        String charityID = volunteering.getString("NgoID");
//
//
//                        JSONArray storedSkills = volunteering.getJSONArray("StoredSkills");
//                        ArrayList<String> skills = new ArrayList<>();
//
//                        for (int j = 0; j < storedSkills.length(); j++) {
//                            skills.add(storedSkills.getString(j));
////                                Log.v("skills",skills.get(j));
//                        }
//
//                        Volunteer volunteer = new Volunteer(charityImage, charityCreatedTime, volunteeringName, volunteeringDetails, skills, charityName, charityID, interestsNames);
//                        volunteers.add(volunteer);
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//                Log.v("number of volunteers", volunteers.size() + "");
//                VolunteersAdapter adapter = new VolunteersAdapter(getActivity(), volunteers.size(), volunteers);
//                recyclerView.setAdapter(adapter);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.v("err", error.toString());
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }


}
