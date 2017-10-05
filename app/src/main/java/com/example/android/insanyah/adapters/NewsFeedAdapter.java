package com.example.android.insanyah.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.insanyah.R;
import com.example.android.insanyah.datamodels.DonationModel;
import com.example.android.insanyah.datamodels.PostDataModel;
import com.example.android.insanyah.datamodels.VolunteerModel;
import com.example.android.insanyah.ui.fragments.CharityFragment;
import com.example.android.insanyah.ui.fragments.DonatingDetailsFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.widget.HListView;

/**
 * Created by mohamedmoosa on 7/19/17.
 */

public class  NewsFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    List<PostDataModel> newsFeed;
    Context context;
    public final static int TYPE_DONATION=1;
    public final static int TYPE_VOLUNTEER=0;
    private int progressStatus = 100;
    private Handler handler = new Handler(Looper.getMainLooper());



    public NewsFeedAdapter(Context context, List<PostDataModel> newsFeed){
        Log.v("newsfeedadpter","adapter");
        this.mInflater = LayoutInflater.from(context);
        this.newsFeed = newsFeed;
        this.context=context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_DONATION){
            return new DonateHolder(mInflater.inflate(R.layout.item_donate,parent,false));
        }else{
            return new VolunteerHolder(mInflater.inflate(R.layout.item_volunteer,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
//        holder.mCardView.setTag(position);h
        final  PostDataModel postDataModel =newsFeed.get(position);

        if( holder.getItemViewType()==TYPE_DONATION){

            final DonateHolder donateHolder=(DonateHolder) holder;
            final DonationModel donationModel=postDataModel.getDonationModel();

            Picasso.with(context).load("https://insanyah.com/files/"+postDataModel.getAccountImage()).into(donateHolder.accountImage);
            donateHolder.createdTime.setText(postDataModel.getCreatedTime());
            donateHolder.name.setText(donationModel.getName());
            Picasso.with(context).load("https://insanyah.com/files/"+donationModel.getLogo()).into(donateHolder.logo);
            donateHolder.details.setText(donationModel.getDetails());
            donateHolder.likesCount.setText(postDataModel.getLikesCount()+"");
            donateHolder.targetAmount.setText(donationModel.getTargetAmount()+"");
            donateHolder.targetRecieved.setText(donationModel.getTargetRecieved()+"");
            donateHolder.ngoName.setText(donationModel.getNgoName());
            donateHolder.currencyReq.setText(donationModel.getCurrency());
            donateHolder.currencyRem.setText(donationModel.getCurrency());

            ListAdapter listAdapter=new ListAdapter() {
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

                    if(postDataModel.getInterestModels().size()>3){
                        return 3;
                    }else{
                        return postDataModel.getInterestModels().size();
                    }
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
                    LayoutInflater inflater = (LayoutInflater) context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View rowView = inflater.inflate(R.layout.list_view_interests_layout, parent, false);
                    String mDrawableName = postDataModel.getInterestModels().get(pos).getName();
                    int resID = context.getResources().getIdentifier(mDrawableName , "drawable", context.getPackageName());
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
            donateHolder.interestsListView.setAdapter(listAdapter);

            double target=Double.parseDouble(donationModel.getTargetAmount()+"");
            double recieved=Double.parseDouble(donationModel.getTargetRecieved()+"");
            final double percentage;
            percentage=recieved/target*100;

            new Thread(new Runnable() {
                public void run() {
                    while (progressStatus > percentage) {
                        progressStatus += 1;
                        // Update the progress bar and display the
                        //current value in the text view
                        handler.post(new Runnable() {
                            public void run() {
                                donateHolder.progressBar.setProgress(progressStatus);
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

        }else{

            VolunteerHolder volunteerHolder=(VolunteerHolder) holder;
            VolunteerModel volunteerModel =postDataModel.getVolunteerModel();

            Picasso.with(context).load("https://insanyah.com/files/"+postDataModel.getAccountImage()).into(volunteerHolder.accountImage);
            volunteerHolder.createdTime.setText(postDataModel.getCreatedTime());
            volunteerHolder.name.setText(volunteerModel.getName());
            volunteerHolder.details.setText(volunteerModel.getDetails());
            volunteerHolder.ngoName.setText(volunteerModel.getNgoName());

            List<String> values=volunteerModel.getStoredSkills();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                    R.layout.list_view_skills_layout, values);
            volunteerHolder.skills.setAdapter(adapter);
//
//
//            Log.v("mohsen","mohsen");
//            for(int j=0;j<((com.example.android.insanyah.Volunteers)newsFeed.get(position)).interestsNames.size();j++){
//                Log.v("adapter interests vol",((com.example.android.insanyah.Volunteers)newsFeed.get(position)).interestsNames.get(j));
//            }

            ListAdapter listAdapter=new ListAdapter() {
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
                    if(postDataModel.getInterestModels().size()>3){
                        return 3;
                    }else{
                        return postDataModel.getInterestModels().size();
                    }
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
                    LayoutInflater inflater = (LayoutInflater) context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View rowView = inflater.inflate(R.layout.list_view_interests_layout, parent, false);
                    String mDrawableName = postDataModel.getInterestModels().get(pos).getName();
                    int resID = context.getResources().getIdentifier(mDrawableName , "drawable", context.getPackageName());
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
            volunteerHolder.interestsListView.setAdapter(listAdapter);
        }

    }

    @Override
    public int getItemCount() {
        return newsFeed.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(newsFeed.get(position).isIsDonation()) {
        return TYPE_DONATION; }else {return  TYPE_VOLUNTEER;
        }
    }


    // stores and recycles views as they are scrolled off screen
    public class DonateHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView accountImage;
        TextView createdTime;
        TextView ngoName;
        TextView name;
        HListView interestsListView;
        ImageView logo;
        TextView details;
        TextView likesCount;
        ProgressBar progressBar;
        TextView targetAmount;
        TextView targetRecieved;
        TextView currencyReq;
        TextView currencyRem;
        Button donateButton;

        public DonateHolder(View itemView) {

            super(itemView);

            accountImage =(ImageView) itemView.findViewById(R.id.donate_charity_image);
            createdTime = (TextView) itemView.findViewById(R.id.donate_charity_created_time);
            ngoName=(TextView) itemView.findViewById(R.id.donation_charity_name);
            name=(TextView) itemView.findViewById(R.id.donation_name);
            interestsListView=(HListView) itemView.findViewById(R.id.list_view_donate_interests);
            logo=(ImageView) itemView.findViewById(R.id.donation_logo);
            details=(TextView) itemView.findViewById(R.id.donation_details);
            likesCount = (TextView) itemView.findViewById(R.id.likes_count);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBarDonateDetails);
            targetAmount=(TextView) itemView.findViewById(R.id.target_amount);
            targetRecieved=(TextView) itemView.findViewById(R.id.target_recieved);
            currencyReq=(TextView) itemView.findViewById(R.id.tv_currency_req);
            currencyRem=(TextView) itemView.findViewById(R.id.tv_currency_rem);
            donateButton=(Button) itemView.findViewById(R.id.button_donate);

            accountImage.setOnClickListener(this);
            ngoName.setOnClickListener(this);
            donateButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == accountImage.getId() || v.getId()==ngoName.getId()){

                PostDataModel postDataModel =newsFeed.get(getAdapterPosition());

                Class fragclass = CharityFragment.class;
                Fragment fragment=null;
                try {
                    fragment=(Fragment) fragclass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                Bundle bundle = new Bundle();
                bundle.putString("ngoID",postDataModel.getNgoId()+"");
                fragment.setArguments(bundle);
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();

            }else if(v.getId()==donateButton.getId()){

                PostDataModel postDataModel =newsFeed.get(getAdapterPosition());
                DonationModel donationModel=postDataModel.getDonationModel();

                Class fragclass = DonatingDetailsFragment.class;
                Fragment fragment=null;
                try {
                    fragment=(Fragment) fragclass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }


                String charityImage="https://insanyah.com/files/"+postDataModel.getAccountImage();
                String charityCreatedTime=postDataModel.getCreatedTime();
                String charityName=donationModel.getNgoName();
                String donationName=donationModel.getName();
                String donationLogo="https://insanyah.com/files/"+donationModel.getLogo();
                String donationDesc=donationModel.getDetails();
                String likesCount=postDataModel.getLikesCount()+"";
                String targetAmount=donationModel.getTargetAmount()+"";
                String targetRecieve=donationModel.getTargetRecieved()+"";
                String charityID=donationModel.getNgoID()+"";
                String currency=donationModel.getCurrency();

                Bundle bundle = new Bundle();
                ArrayList<String> donationPostData=new ArrayList<>();
                donationPostData.add(charityImage);
                donationPostData.add(charityCreatedTime);
                donationPostData.add(charityName);
                donationPostData.add(donationName);
                donationPostData.add(donationLogo);
                donationPostData.add(donationDesc);
                donationPostData.add(likesCount);
                donationPostData.add(targetAmount);
                donationPostData.add(targetRecieve);
                donationPostData.add(charityID);
                donationPostData.add(currency);

                for(int i=0;i<postDataModel.getInterestModels().size() && i<3;i++){
                    donationPostData.add(postDataModel.getInterestModels().get(i).getName());
                }

                bundle.putStringArrayList("donationPostData",donationPostData);
                fragment.setArguments(bundle);
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
            }
        }
    }


    public class VolunteerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView accountImage;
        TextView createdTime;
        TextView ngoName;
        TextView name;
        HListView interestsListView;
        TextView details;
        ListView skills;

        public VolunteerHolder(View itemView){

            super(itemView);

            accountImage =(ImageView) itemView.findViewById(R.id.volunteer_charity_image);
            createdTime = (TextView) itemView.findViewById(R.id.volunteer_charity_created_time);
            ngoName=(TextView) itemView.findViewById(R.id.volunteer_charity_name);
            name=(TextView) itemView.findViewById(R.id.volunteer_name);
            interestsListView=(HListView) itemView.findViewById(R.id.list_view_volunteer_interests);
            details=(TextView) itemView.findViewById(R.id.volunteer_details);
            skills=(ListView) itemView.findViewById(R.id.skills);

            accountImage.setOnClickListener(this);
            ngoName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           Log.v("mousaV",getAdapterPosition()+"");
            if(v.getId()==accountImage.getId() || v.getId()==ngoName.getId()){

                PostDataModel postDataModel =newsFeed.get(getAdapterPosition());

                Class fragclass = CharityFragment.class;
                Fragment fragment=null;
                try {
                    fragment=(Fragment) fragclass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                Bundle bundle = new Bundle();
                bundle.putString("ngoID",postDataModel.getNgoId()+"");
                fragment.setArguments(bundle);
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
            }
        }
    }
}
