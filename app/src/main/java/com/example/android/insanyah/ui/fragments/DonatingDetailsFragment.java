package com.example.android.insanyah.ui.fragments;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.insanyah.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import it.sephiroth.android.library.widget.HListView;

public class DonatingDetailsFragment extends Fragment {

    int progressStatus = 0;
    Handler handler = new Handler();
    String charityID;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_donating_detailss, container, false);
        ArrayList<String> donationPostData = getArguments().getStringArrayList("donationPostData");

        ImageView charityImage = (ImageView) view.findViewById(R.id.donate_charity_image);
        TextView charityCreatedTime = (TextView) view.findViewById(R.id.donate_charity_created_time);
        TextView charityName = (TextView) view.findViewById(R.id.donation_charity_name);
        TextView donationName = (TextView) view.findViewById(R.id.donation_name);
        HListView interestsListView = (HListView) view.findViewById(R.id.list_view_donatee_interests);
        ImageView donationLogo = (ImageView) view.findViewById(R.id.donation_logo);
        TextView donationDetails = (TextView) view.findViewById(R.id.donation_details);
        TextView likesCount = (TextView) view.findViewById(R.id.likes_count);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBarDonateDetails);
        TextView targetAmount = (TextView) view.findViewById(R.id.target_amount);
        TextView targetRecieved = (TextView) view.findViewById(R.id.target_recieved);
        TextView currencyReq = (TextView) view.findViewById(R.id.tv_currency_req);
        TextView currencyRem = (TextView) view.findViewById(R.id.tv_currency_rem);
        charityID = donationPostData.get(9);


        charityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class fragclass = CharityFragment.class;
                Fragment fragment = null;
                try {
                    fragment = (Fragment) fragclass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                }

                Bundle bundle = new Bundle();
                bundle.putString("ngoID", charityID);
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder, fragment).addToBackStack("stack").commit();
            }
        });


        charityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class fragclass = CharityFragment.class;
                Fragment fragment = null;
                try {
                    fragment = (Fragment) fragclass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                }

                Bundle bundle = new Bundle();
                bundle.putString("ngoID", charityID);
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder, fragment).addToBackStack("stack").commit();
            }
        });

//        Log.v("charityID",donationPostData.get(9));
//        charityID=donationPostData.get(9);

        Picasso.with(getContext()).load(donationPostData.get(0)).into(charityImage);
        charityCreatedTime.setText(donationPostData.get(1));
        charityName.setText(donationPostData.get(2));
        donationName.setText(donationPostData.get(3));
        Picasso.with(getContext()).load(donationPostData.get(4)).into(donationLogo);
        donationDetails.setText(donationPostData.get(5));
        likesCount.setText(donationPostData.get(6));
        targetAmount.setText(donationPostData.get(7));
        targetRecieved.setText(donationPostData.get(8));
        currencyReq.setText(donationPostData.get(10));
        currencyRem.setText(donationPostData.get(10));

        final ArrayList<String> interestNames=new ArrayList<>();

        for (int i = 11; i < donationPostData.size(); i++) {
            Log.v("interest name", donationPostData.get(i));
            interestNames.add(donationPostData.get(i));
        }



        ListAdapter dd=new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return interestNames.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int pos, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View rowView = inflater.inflate(R.layout.list_view_interests_layout, parent, false);
                String mDrawableName = interestNames.get(pos);
                int resID = getContext().getResources().getIdentifier(mDrawableName , "drawable", getContext().getPackageName());
                ImageView imageView = (ImageView) rowView.findViewById(R.id.image_view_interest);
                imageView.setImageResource(resID);
                return rowView;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return  1;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };
        interestsListView.setAdapter(dd);

        double target = Double.parseDouble(targetAmount.getText().toString());
        double recieved = Double.parseDouble(targetRecieved.getText().toString());
        final double percentage;
        percentage = recieved / target * 100;

        new Thread(new Runnable() {
            public void run() {
//                int progressStatus = 0;
//                Handler handler = new Handler();
                while (progressStatus < percentage) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return view;
    }

}
