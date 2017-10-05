package com.example.android.insanyah.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.android.insanyah.R;

public class AddDonationOneFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_donation_onee, container, false);

        Spinner dropdownFrequently = (Spinner)view.findViewById(R.id.spinner_frequently);
        String[] itemsFrequently = new String[]{getString(R.string.only_this_time),getString(R.string.every_month),getString(R.string.quarterly),getString(R.string.semi_annually),getString(R.string.annually)};
        ArrayAdapter<String> adapterFrequently = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, itemsFrequently);
        dropdownFrequently.setAdapter(adapterFrequently);


        Spinner dropdownFor = (Spinner)view.findViewById(R.id.spinner_for);
        String[] itemsFor = new String[]{getString(R.string.general_donation)};
        ArrayAdapter<String> adapterFor = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, itemsFor);
        dropdownFor.setAdapter(adapterFor);

        return view;
    }

}
