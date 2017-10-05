package com.example.android.insanyah.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.insanyah.Helpers.Constants;
import com.example.android.insanyah.Helpers.Requests;
import com.example.android.insanyah.R;
import com.example.android.insanyah.adapters.NewsFeedAdapter;
import com.example.android.insanyah.datamodels.PostDataModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

public class NewsFeedFragment extends Fragment  {

//    RequestQueue requestQueue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_feed, container, false);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_item);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        final ArrayList<String> interests = getActivity().getIntent().getStringArrayListExtra("interests");

        FormBody.Builder formBulilder=new FormBody.Builder();

        formBulilder.add("Offset","1");
        for(int i=0;i<interests.size();i++){
            formBulilder.add("InterestsIds",interests.get(i));
        }

        RequestBody requestBody=formBulilder.build();

        Requests.postRequest(Constants.BASE_URL + Constants.GET_NEWS_FEEDS_POSTS,requestBody, new Callback() {
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
//                        Toast.makeText(getActivity(), respo, Toast.LENGTH_SHORT).show();

                        PostDataModel[] postDataModel=new Gson().fromJson(respo,PostDataModel[].class);
                        NewsFeedAdapter newsFeedAdapter= new NewsFeedAdapter(getActivity(), Arrays.asList(postDataModel));
                        recyclerView.setAdapter(newsFeedAdapter);
                    }
                });

            }
        });
//        requestQueue = Volley.newRequestQueue(getActivity());
//        request("fc558353-b4b6-4a57-9b69-689219e40a41",interests,recyclerView);
        return view;
    }


//    public void request(String token,ArrayList<String> interests,final RecyclerView recyclerView){
//        String url = "http://ensaneia.com/api/Post/GetNewsFeedsPosts";
//        Map<String, String> requestParams = new HashMap<String, String>();
//        requestParams.put("Offset", "1");
//
//        if (interests != null)
//            for (int i = 0; i < interests.size(); i++) {
//                requestParams.put("InterestsIds", interests.get(i));
//                Log.v("interest number", interests.get(i));
//            }
//
//        Map<String,String> headers=new HashMap<>();
//        headers.put("X-ApiKey",token);
//
//
//        JsonArrayRequest jsObjRequest = new JsonArrayRequest(Request.Method.POST, url, requestParams,headers, new Response.Listener<JSONArray>() {
//
//            @Override
//            public void onResponse(JSONArray response) {
//                Log.d("Response: ", response.toString());
//                Log.v("resss", response.toString());
//                Log.v("length", response.length() + "");
//
//                ArrayList<Object> newsFeed=new ArrayList<>();
//
//                for (int i = 0; i < response.length(); i++) {
//                    JSONObject charityObject;
//                    try {
//                        charityObject = response.getJSONObject(i);
//
//                        if (charityObject.getString("IsDonation") == "true") {
////                            Log.v("is donation", "yes");
//
//                            String charityImage = charityObject.getString("AccountImage");
//                            String charityCreatedTime = charityObject.getString("CreatedTime");
//
//                            ArrayList<String> interestsNames=new ArrayList<>();
//                            JSONArray interestsArray=charityObject.getJSONArray("Interests");
//                            for(int j=0;j<interestsArray.length() && j<3;j++){
//                               String interestName = interestsArray.getJSONObject(j).getString("Name");
//                                interestsNames.add(interestName);
////                                Log.v("interests name",interestName);
//                            }
//
//                            JSONObject donation = charityObject.getJSONObject("DonationModel");
//
//                            String donationName = donation.getString("Name");
//                            String donationLogo = donation.getString("Logo");
//                            String donationDetails = donation.getString("Details");
//                            String likesCount = charityObject.getString("LikesCount");
//                            String targetAmountDouble = donation.getString("TargetAmount");
//                            String targetRecieved = donation.getString("TargetRecieved");
//                            String charityName=donation.getString("NgoName");
//                            String charityID=donation.getString("NgoID");
//                            String currency=donation.getString("Currency");
//
//                            int targetAmountInt=(int) Double.parseDouble(targetAmountDouble);
//                            int targetRecInt=(int)Double.parseDouble(targetRecieved);
//                            String targetAmount=targetAmountInt+"";
//
//                            int targetRemainingInt=targetAmountInt-targetRecInt;
//                            String targetRemaining=targetRemainingInt+"";
//
//                            Donate donate = new Donate(charityImage, charityCreatedTime,  donationName, donationLogo, donationDetails, likesCount,targetAmount, targetRemaining,charityName,charityID,interestsNames,currency);
//                            newsFeed.add(donate);
//
//                        } else if (charityObject.getString("IsVolunteer") == "true") {
////                            Log.v("is volunteer", "yes");
//
//                            String charityImage = charityObject.getString("AccountImage");
//                            String charityCreatedTime = charityObject.getString("CreatedTime");
//
//                            ArrayList<String> interestsNames=new ArrayList<>();
//                            JSONArray interestsArray=charityObject.getJSONArray("Interests");
//                            for(int j=0;j<interestsArray.length() && j<3;j++){
//                                String interestName = interestsArray.getJSONObject(j).getString("Name");
//                                interestsNames.add(interestName);
////                                Log.v("interests name",interestName);
//                            }
//
//
//                            JSONObject volunteering = charityObject.getJSONObject("VolunteerModel");
//
//                            String volunteeringName = volunteering.getString("Name");
//                            String volunteeringDetails = volunteering.getString("Details");
//                            String charityName=volunteering.getString("NgoName");
//                            String charityID=volunteering.getString("NgoID");
//
//
//                            JSONArray storedSkills=volunteering.getJSONArray("StoredSkills");
//                            ArrayList<String> skills=new ArrayList<>();
//
//                            for(int j=0;j<storedSkills.length();j++){
//                                skills.add(storedSkills.getString(j));
////                                Log.v("skills",skills.get(j));
//                            }
//
//                            VolunteerModel volunteer=new VolunteerModel(charityImage,charityCreatedTime,volunteeringName,volunteeringDetails,skills,charityName,charityID,interestsNames);
//                            newsFeed.add(volunteer);
//                        }
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//                Log.v("number of news feed", newsFeed.size()+"");
//                NewsFeedAdapter adapter = new NewsFeedAdapter(getActivity(), newsFeed.size(), newsFeed);
//                recyclerView.setAdapter(adapter);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError response) {
//                Log.d("Response: ", response.toString());
//                Log.v("err", response.toString());
//            }
//        });
//        requestQueue.add(jsObjRequest);
//    }
}
