package com.example.demolistview;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
    private ArrayList<Food> food;
    private Context context;
    private TextView tvFoodName;
    private ImageView ivStar;

    public FoodAdapter(Context context, int resource, ArrayList<Food> objects){
        super(context, resource, objects);
        // store the food that is passed to this adapter
        food = objects;
        // store context object as we would need to use it later
        this.context = context;
    }
    //getView() is the method ListView will call to get the view object every time listview needs a row
    public View getView(int position, View convertView, ViewGroup parent){
        //the usual way to get the layout inflater object to inflate the xml file into a view object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate the row.xml as the layout for the view object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        //get the imageView object
        ivStar = (ImageView) rowView.findViewById(R.id.ivStar);
        //get the textView object
        tvFoodName = (TextView) rowView.findViewById(R.id.tvFoodName);

        //the parameter position is the index of the row listView is requesting we get the food at the same index
        Food currentFood = food.get(position);
        //set the textview to show the food
        tvFoodName.setText(currentFood.getName());
        //set the image to star or not star accordingly
        if(currentFood.isStar()){
            ivStar.setImageResource(R.drawable.star);
        }
        else {
            ivStar.setImageResource(R.drawable.nostar);
        }
        return rowView;
    }
}
