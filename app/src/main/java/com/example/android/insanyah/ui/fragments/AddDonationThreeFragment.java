package com.example.android.insanyah.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.android.insanyah.R;

import java.util.Calendar;

public class AddDonationThreeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_donation_threee, container, false);
        Spinner dropdownCard = (Spinner)view.findViewById(R.id.spinner_card);
        String[] itemsCard = new String[]{getString(R.string.card_cvv)};
        ArrayAdapter<String> adapterCard = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, itemsCard);
        dropdownCard.setAdapter(adapterCard);

        final EditText date;
        date = (EditText)view.findViewById(R.id.edit_text_valid_until);

        TextWatcher tw = new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "ddmmyyyy";
            private Calendar cal = Calendar.getInstance();

            int pos=0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                pos=date.getText().length();
            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(date.getText().length()==2 && pos!=3)
                {   date.setText(date.getText().toString()+"/");
                    date.setSelection(3);
                }

//                if (!s.toString().equals(current)) {
//                    String clean = s.toString().replaceAll("[^\\d.]", "");
//                    String cleanC = current.replaceAll("[^\\d.]", "");
//
//                    int cl = clean.length();
//                    int sel = cl;
//                    for (int i = 2; i <= cl && i < 6; i += 2) {
//                        sel++;
//                    }
//                    //Fix for pressing delete next to a forward slash
//                    if (clean.equals(cleanC)) sel--;
//
//                    if (clean.length() < 8) {
//                        clean = clean + ddmmyyyy.substring(clean.length());
//                    } else {
//                        //This part makes sure that when we finish entering numbers
//                        //the date is correct, fixing it otherwise
//                        int day = Integer.parseInt(clean.substring(0, 2));
//                        int mon = Integer.parseInt(clean.substring(2, 4));
//                        int year = Integer.parseInt(clean.substring(4, 8));
//
//                        if (mon > 12) mon = 12;
//                        cal.set(Calendar.MONTH, mon - 1);
//                        year = (year < 1900) ? 1900 : (year > 2100) ? 2100 : year;
//                        cal.set(Calendar.YEAR, year);
//                        // ^ first set year for the line below to work correctly
//                        //with leap years - otherwise, date e.g. 29/02/2012
//                        //would be automatically corrected to 28/02/2012
//
//                        day = (day > cal.getActualMaximum(Calendar.DATE)) ? cal.getActualMaximum(Calendar.DATE) : day;
//                        clean = String.format("%02d%02d%02d", day, mon, year);
//                    }
//
//                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
//                            clean.substring(2, 4),
//                            clean.substring(4, 8));
//
//                    sel = sel < 0 ? 0 : sel;
//                    current = clean;
//                    date.setText(current);
//                    date.setSelection(sel < current.length() ? sel : current.length());
//                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        date.addTextChangedListener(tw);


        return view;
    }

}
