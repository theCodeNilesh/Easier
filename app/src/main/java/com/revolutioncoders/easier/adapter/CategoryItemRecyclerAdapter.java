package com.revolutioncoders.easier.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.ProductScreen;
import com.revolutioncoders.easier.R;
import com.revolutioncoders.easier.model.CategoryItem;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public CategoryItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.first_card_design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {

        new ImageLoadTask(categoryItemList.get(position).getImageUrl(), holder.itemImage).execute();
        holder.title.setText(categoryItemList.get(position).getTitle());
        holder.subtxt.setText(categoryItemList.get(position).getSubtxt());
        holder.price.setText(categoryItemList.get(position).getPrice());
        holder.id = categoryItemList.get(position).getItemId();

    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView itemImage;
        TextView title, price, subtxt;
        Integer id;

        public CategoryItemViewHolder(@NonNull final View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.first_rc_img);
            title = itemView.findViewById(R.id.first_rc_title);
            subtxt = itemView.findViewById(R.id.first_rc_subtxt);
            price = itemView.findViewById(R.id.first_rc_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), ProductScreen.class).putExtra("id",id));
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }

    public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        private String url;
        private ImageView imageView;

        public ImageLoadTask(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL urlConnection = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlConnection
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            imageView.setImageBitmap(result);
        }

    }
}
