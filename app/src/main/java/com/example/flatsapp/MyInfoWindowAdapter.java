package com.example.flatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private final View mView;
    private Context mContext;

    public MyInfoWindowAdapter(Context context){
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.custom_info_window,null);
    }
    private void rendWindow(Marker marker,View view){
        String title = marker.getTitle();
        TextView tvTitle = (TextView) view.findViewById(R.id.title);

        if (!title.equals("")){
            tvTitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView tvSnippet = (TextView) view.findViewById(R.id.snippet);

        if (!snippet.equals("")){
            tvSnippet.setText(snippet);
        }
    }
    @Override
    public View getInfoWindow(Marker marker) {
        rendWindow(marker,mView);
        return mView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        rendWindow(marker,mView);
        return mView;
    }

}
