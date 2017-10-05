package com.example.android.insanyah.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.insanyah.R;
import com.example.android.insanyah.datamodels.PostDataModel;
import com.example.android.insanyah.datamodels.VolunteerModel;
import com.example.android.insanyah.ui.fragments.CharityFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import it.sephiroth.android.library.widget.HListView;

/**
 * Created by mohamedmoosa on 7/19/17.
 */

public class VolunteersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    int count;
//    ArrayList<com.example.android.insanyah.Helpers.Volunteer> volunteers;
List<PostDataModel> newsFeed;
    Context context;


    private int progressStatus = 0;
    private Handler handler = new Handler();



    public VolunteersAdapter (Context context,int count,  List<PostDataModel> newsFeed){
        this.mInflater = LayoutInflater.from(context);
        this.count=count;
//        this.volunteers = volunteers;
        this.newsFeed = newsFeed;
        this.context=context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//        Log.v("viewtype",viewType+"");
//        if(newsFeed.get(viewType) instanceof com.example.android.insanyah.Helpers.Donate){
//        return new Volunteers(mInflater.inflate(R.layout.item_volunteer,parent,false));
//        }else{
            return new VolunteerHolder(mInflater.inflate(R.layout.item_volunteer,parent,false));
//        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final  PostDataModel postDataModel =newsFeed.get(position);

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
//        Log.v("hnaa","volunteer");
//        Volunteer volunteer=(Volunteer) holder;
////            volunteer.itemClicked.setTag(position);
//        Picasso.with(context).load("https://insanyah.com/files/"+((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(position)).getCharityImage()).into(volunteer.charityImage);
//        volunteer.charityCreatedTime.setText(((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(position)).getCharityCreatedTime());
//        volunteer.volunteerName.setText(((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(position)).getVolunteerName());
//        volunteer.volunteerDetails.setText(((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(position)).getVolunteerDetails());
//        volunteer.charityName.setText(((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(position)).getCharityName());
//
//        ArrayList<String> values=((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(position)).getSkills();
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
//                R.layout.list_view_skills_layout, values);
//        volunteer.skills.setAdapter(adapter);
//
//
////            Log.v("mohsen","mohsen");
////            for(int j=0;j<((com.example.android.insanyah.Volunteers)newsFeed.get(position)).interestsNames.size();j++){
////                Log.v("adapter interests vol",((com.example.android.insanyah.Volunteers)newsFeed.get(position)).interestsNames.get(j));
////            }
//
//        ListAdapter dd=new ListAdapter() {
//            @Override
//            public boolean areAllItemsEnabled() {
//                return false;
//            }
//
//            @Override
//            public boolean isEnabled(int position) {
//                return false;
//            }
//
//            @Override
//            public void registerDataSetObserver(DataSetObserver observer) {
//
//            }
//
//            @Override
//            public void unregisterDataSetObserver(DataSetObserver observer) {
//
//            }
//
//            @Override
//            public int getCount() {
//                return ((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(position)).getInterestsNames().size();
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return null;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return 0;
//            }
//
//            @Override
//            public boolean hasStableIds() {
//                return false;
//            }
//
//            @Override
//            public View getView(int pos, View convertView, ViewGroup parent) {
//                LayoutInflater inflater = (LayoutInflater) context
//                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View rowView = inflater.inflate(R.layout.list_view_interests_layout, parent, false);
////                    TextView textView = (TextView) rowView.findViewById(R.id.label);
//
////                    Log.v("pos",pos+"");
////                    Log.v("size",((com.example.android.insanyah.Volunteers)newsFeed.get(position)).interestsNames.size()+"");
////                    Log.v("name",((com.example.android.insanyah.Volunteers)newsFeed.get(position)).interestsNames.get(pos));
//
//                String mDrawableName = ((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(position)).getInterestsNames().get(pos);
//                int resID = context.getResources().getIdentifier(mDrawableName , "drawable", context.getPackageName());
//                ImageView imageView = (ImageView) rowView.findViewById(R.id.image_view_interest);
//                imageView.setImageResource(resID);
//                return rowView;
//            }
//
//            @Override
//            public int getItemViewType(int position) {
//                return 0;
//            }
//
//            @Override
//            public int getViewTypeCount() {
//                return  1;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//        };
//        volunteer.interestsListView.setAdapter(dd);

    }

    @Override
    public int getItemCount() {
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class VolunteerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView accountImage;
        TextView createdTime;
        TextView ngoName;
        TextView name;
        HListView interestsListView;
        TextView details;
        ListView skills;
//        ImageView charityImage;
//        TextView charityCreatedTime;
//        TextView volunteerName;
//        TextView volunteerDetails;
//        ListView skills;
//        TextView charityName;
//        HListView interestsListView;
//        View itemClicked;
//        Button volunteerButton;


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
//            charityImage =(ImageView) itemView.findViewById(R.id.volunteer_charity_image);
//            charityCreatedTime = (TextView) itemView.findViewById(R.id.volunteer_charity_created_time);
//            volunteerName=(TextView) itemView.findViewById(R.id.volunteer_name);
//            volunteerDetails=(TextView) itemView.findViewById(R.id.volunteer_details);
//            skills=(ListView) itemView.findViewById(R.id.skills);
//            charityName=(TextView) itemView.findViewById(R.id.volunteer_charity_name);
//            interestsListView=(HListView) itemView.findViewById(R.id.list_view_volunteer_interests);
//            charityImage.setOnClickListener(this);
//            volunteerButton=(Button) itemView.findViewById(R.id.button_volunteer);
//            volunteerButton.setOnClickListener(this);

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
//           Log.v("mousaV",getAdapterPosition()+"");
//            if(v.getId()==charityImage.getId()){
//                Log.v("charity image",((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(getAdapterPosition())).getCharityID());
//
//                Class fragclass = CharityFragment.class;
//                Fragment fragment=null;
//                try {
//                    fragment=(Fragment) fragclass.newInstance();
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//
//                Bundle bundle = new Bundle();
//                bundle.putString("ngoID",((com.example.android.insanyah.Helpers.Volunteer)volunteers.get(getAdapterPosition())).getCharityID() );
//                fragment.setArguments(bundle);
//                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).commit();
//            }else if(v.getId()==volunteerButton.getId()){
//                Class fragclass = VolunteeringDetailsFragment.class;
//                Fragment fragment=null;
//                try {
//                    fragment=(Fragment) fragclass.newInstance();
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place_holder,fragment).addToBackStack("stack").commit();
//            }
        }
    }


}
