package com.example.android.insanyah.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.insanyah.R;

public class VolunteeringDetailsFragment extends Fragment {

//    MyCustomAdapter dataAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_volunteering_details, container, false);
//        displayListView();
//        checkButtonClick();
        return view;
    }

//    private void displayListView() {
//
//        //Array list of countries
////        ArrayList<Country> countryList = new ArrayList<Country>();
////        Country country = new Country("AFG","Afghanistan",false);
////        countryList.add(country);
////        country = new Country("ALB","Albania",true);
////        countryList.add(country);
////        country = new Country("DZA","Algeria",false);
////        countryList.add(country);
////        country = new Country("ASM","American Samoa",true);
////        countryList.add(country);
////        country = new Country("AND","Andorra",true);
////        countryList.add(country);
////        country = new Country("AGO","Angola",false);
////        countryList.add(country);
////        country = new Country("AIA","Anguilla",false);
////        countryList.add(country);
//
//        ArrayList<String> countryList=new ArrayList<>();
//        countryList.add("Egypt");
//        countryList.add("USA");
//        countryList.add("Mex.");
//        countryList.add("Arg.");
//
//
//        //create an ArrayAdaptar from the String Array
//        MyCustomAdapter dataAdapter = new MyCustomAdapter(getContext(),
//                R.layout.country_info,countryList);
//
//
//        ListView listView = (ListView) view.findViewById(R.id.listView1);
//        // Assign adapter to ListView
//        listView.setAdapter(dataAdapter);
//
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // When clicked, show a toast with the TextView text
//                String country = (String) parent.getItemAtPosition(position);
//                Toast.makeText(getContext(),
//                        "Clicked on Row: " + country,
//                        Toast.LENGTH_LONG).show();
//            }
//        });
//
////        listView.setOnItemClickListener(new OnItemClickListener() {
////            public void onItemClick(AdapterView<?> parent, View view,
////                                    int position, long id) {
////                // When clicked, show a toast with the TextView text
////                Country country = (Country) parent.getItemAtPosition(position);
////                Toast.makeText(getApplicationContext(),
////                        "Clicked on Row: " + country.getName(),
////                        Toast.LENGTH_LONG).show();
////            }
////        });
//
//    }
//
//    private class MyCustomAdapter extends ArrayAdapter<String> {
//
//        private ArrayList<String> countryList;
//
//        public MyCustomAdapter(Context context, int textViewResourceId,
//                               ArrayList<String> countryList) {
//            super(context, textViewResourceId, countryList);
//            this.countryList = new ArrayList<String>();
//            this.countryList.addAll(countryList);
//        }
//
//        private class ViewHolder {
//            TextView code;
//            CheckBox name;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            ViewHolder holder = null;
//            Log.v("ConvertView", String.valueOf(position));
//
//            if (convertView == null) {
//                LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(
//                        Context.LAYOUT_INFLATER_SERVICE);
//                convertView = vi.inflate(R.layout.country_info, null);
//
//                holder = new ViewHolder();
//                holder.code = (TextView) convertView.findViewById(R.id.code);
//                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
//                convertView.setTag(holder);
//
//                holder.name.setOnClickListener( new View.OnClickListener() {
//                    public void onClick(View v) {
//                        CheckBox cb = (CheckBox) v ;
//                        String  country = (String ) cb.getTag();
//                        Toast.makeText(getActivity().getApplicationContext(),
//                                "Clicked on Checkbox: " + cb.getText() +
//                                        " is " + cb.isChecked(),
//                                Toast.LENGTH_LONG).show();
////                        country.setSelected(cb.isChecked());
//                    }
//                });
//            }
//            else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//
//            String country = countryList.get(position);
////            holder.code.setText(" (" +  country.getCode() + ")");
//            holder.name.setText(country);
////            holder.name.setChecked(country.isSelected());
////            holder.name.setTag(country);
//
//            return convertView;
//
//        }
//
//    }
//
//    private void checkButtonClick() {
//
//
//        Button myButton = (Button) view.findViewById(R.id.findSelected);
//
//        myButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                StringBuffer responseText = new StringBuffer();
//                responseText.append("The following were selected...\n");
//
//                ArrayList<String> countryList = dataAdapter.countryList;
//                for(int i=0;i<countryList.size();i++){
//                    String country = countryList.get(i);
////                    if(country.isSelected()){
////                        responseText.append("\n" + country.getName());
////                    }
//                }
//
//                Toast.makeText(getContext(),
//                        responseText, Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//
////        myButton.setOnClickListener(new OnClickListener() {
////
////            @Override
////            public void onClick(View v) {
////
////                StringBuffer responseText = new StringBuffer();
////                responseText.append("The following were selected...\n");
////
////                ArrayList<Country> countryList = dataAdapter.countryList;
////                for(int i=0;i<countryList.size();i++){
////                    Country country = countryList.get(i);
////                    if(country.isSelected()){
////                        responseText.append("\n" + country.getName());
////                    }
////                }
////
////                Toast.makeText(getApplicationContext(),
////                        responseText, Toast.LENGTH_LONG).show();
////
////            }
////        });
//
//    }



}
