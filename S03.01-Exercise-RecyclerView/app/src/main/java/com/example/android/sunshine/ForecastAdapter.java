package com.example.android.sunshine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private static final String TAG = ForecastAdapter.class.getSimpleName();

    private String[] mWeatherData;

    @NonNull
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Log.d(TAG,"on create view holder");

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new ForecastAdapterViewHolder(view);
    }

    public void setmWeatherData(String[] mWeatherData) {
        this.mWeatherData = mWeatherData;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastAdapterViewHolder forecastAdapterViewHolder, int position) {
        Log.d(TAG,"onBindViewHolder " + position);
        String weatherForThisDay = mWeatherData[position];
        forecastAdapterViewHolder.mWeatherTextView.setText(weatherForThisDay);
    }

    @Override
    public int getItemCount() {
        return mWeatherData == null ? 0 : mWeatherData.length;
    }

    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    }
}
