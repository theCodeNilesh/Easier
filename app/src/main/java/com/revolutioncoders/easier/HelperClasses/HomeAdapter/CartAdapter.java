package com.revolutioncoders.easier.HelperClasses.HomeAdapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.revolutioncoders.easier.Cart;
import com.revolutioncoders.easier.HomeScreen;
import com.revolutioncoders.easier.ProductScreen;
import com.revolutioncoders.easier.ProductScreenEdit;
import com.revolutioncoders.easier.R;
import com.revolutioncoders.easier.adapter.CategoryItemRecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.revolutioncoders.easier.URLenv.del_from_cart;
import static com.revolutioncoders.easier.URLenv.product_details_edit;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    ArrayList<CartHelperClass> cartLocations;

    public CartAdapter(ArrayList<CartHelperClass> cartLocations) {
        this.cartLocations = cartLocations;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_design, parent, false);
        CartViewHolder cartViewHolder = new CartViewHolder(view);
        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        CartHelperClass cartHelperClass = cartLocations.get(position);
        new ImageLoadTask(cartHelperClass.getImage(), holder.image).execute();
        holder.title.setText(cartHelperClass.getTitle());
        holder.price.setText(cartHelperClass.getPrice());
        holder.quantity.setText(cartHelperClass.getQuantity());
        holder.id = cartHelperClass.getId();
        holder.pid =cartHelperClass.getPid();

    }

    @Override
    public int getItemCount() {
        return cartLocations.size();
    }


    public class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView image,edit,del;
        TextView title, price, quantity;
        int id,pid;
        RequestQueue requestQueue;

        public CartViewHolder(@NonNull final View itemView) {
            super(itemView);

            //Hooks

            image = itemView.findViewById(R.id.cart_img);
            title = itemView.findViewById(R.id.cart_title);
            price = itemView.findViewById(R.id.cart_price);
            quantity = itemView.findViewById(R.id.cart_quantity);
            edit= itemView.findViewById(R.id.edit_ic);
            del= itemView.findViewById(R.id.delete_ic);
            requestQueue = Volley.newRequestQueue(itemView.getContext());

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), ProductScreenEdit.class).putExtra("id",id).putExtra("pid",pid));
                    ((Activity)itemView.getContext()).finish();
                }
            });

            del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, del_from_cart,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(itemView.getContext(),"Item Deleted Successfully",Toast.LENGTH_LONG).show();
                                        notifyDataSetChanged();
                                        itemView.invalidate();
//                                    itemView.getContext().startActivity(new Intent(itemView.getContext(), Cart.class));
//                                    ((Activity)itemView.getContext()).finish();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("id", String.valueOf(id));
                            return params;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
            });

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
