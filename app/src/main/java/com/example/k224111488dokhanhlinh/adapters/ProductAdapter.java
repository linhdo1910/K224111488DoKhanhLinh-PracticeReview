package com.example.k224111488dokhanhlinh.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.k224111488dokhanhlinh.R;
import com.example.k224111488dokhanhlinh.models.Product;

public class ProductAdapter extends ArrayAdapter<Product> {
    Activity context;
    int resource;
    public ProductAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(resource, null);

        TextView txtProductId = item.findViewById(R.id.txtProductId);
        TextView txtProductName = item.findViewById(R.id.txtProductName);
        TextView txtProductQuantity = item.findViewById(R.id.txtProductCode);
        TextView txtProductPrice = item.findViewById(R.id.txtProductPrice);
        ImageView imgProduct = item.findViewById(R.id.imgProduct);

        Product p = getItem(position);
        if (p != null) {
            txtProductId.setText("ID: " + p.getId());
            txtProductName.setText(p.getName());
            txtProductQuantity.setText("Quantity: " + p.getProductCode());
            txtProductPrice.setText("Price: " + p.getPrice() + " VNĐ");

            if (p.getImageLink() != null && !p.getImageLink().isEmpty() && imgProduct != null) {
                Glide.with(context)
                        .load(p.getImageLink())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)
                        .into(imgProduct);
            } else if (imgProduct != null) {
                imgProduct.setImageResource(R.drawable.ic_launcher_foreground);
            }
        }

        return item;
    }}

