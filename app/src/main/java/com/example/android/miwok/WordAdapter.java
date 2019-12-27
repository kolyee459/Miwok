package com.example.android.miwok;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    WordAdapter(Activity context, ArrayList<Word> words){
        super(context, 0, words);
    }
    WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId ){
        super(context, 0, words);
        mColorResourceId = colorResourceId;


    }



    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Word currentWord = getItem(position);
        TextView defaultTextView =  listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        TextView numberTextView =  listItemView.findViewById(R.id.miwok_text_view);
        numberTextView.setText(currentWord.getMiwokTranslation());

        ImageView image =  listItemView.findViewById(R.id.image);
        image.setImageResource(currentWord.getImageResourceId());
        if (currentWord.hasValidImage()) {

            image.setVisibility(View.VISIBLE);

        }
        else{
            image.setVisibility(View.GONE);
        }




        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}

