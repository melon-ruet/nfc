package com.nuspay.melon.classickeychange;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordAdapter extends BaseAdapter  {

    /*********** Declare Used Variables *********/
    private Activity activity;
    ArrayList <String> sector,data;
    private static LayoutInflater inflater=null;

    /*************  CustomAdapter Constructor *****************/
    public RecordAdapter(Activity a,
                         ArrayList<String> sector,
                         ArrayList<String> data) {

        /********** Take passed values **********/
        activity = a;
        this.sector = sector;
        this.data = data;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {

        if(sector.size()<=0)
            return 1;
        return sector.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{

        public TextView sectorNo;
        public TextView keyA;
        public TextView keyB;
        public TextView accessBits;

    }

    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            view = inflater.inflate(R.layout.simplerow, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.sectorNo = (TextView) view.findViewById(R.id.sector_no);
            holder.keyA =(TextView)view.findViewById(R.id.keyA);
            holder.keyB =(TextView)view.findViewById(R.id.keyB);
            holder.accessBits = (TextView)view.findViewById(R.id.access_bits);

            /************  Set holder with LayoutInflater ************/
            view.setTag(holder);
        }
        else
            holder=(ViewHolder)view.getTag();

        if(sector.size() > 0)
        {
            holder.sectorNo.setText(sector.get(position));
            holder.keyA.setText(data.get(position).substring(0, 12));
            holder.accessBits.setText(data.get(position).substring(12, 20));
            holder.keyB.setText(data.get(position).substring(20, 32));
        }
        return view;
    }
}
