package com.example.k224111488dokhanhlinh.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.k224111488dokhanhlinh.R;
import com.example.k224111488dokhanhlinh.models.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private Activity context;
    private int resource;
    private List<Product> productList;

    public ProductAdapter(@NonNull Activity context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.productList = objects;
    }

    static class ViewHolder {
        EditText edtProductID, edtProductName, edtProductPrice, edtProductCode;
        ImageView imgProduct;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;

        if (item == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(resource, parent, false);

            holder = new ViewHolder();
            holder.edtProductID = item.findViewById(R.id.edt_product_id);
            holder.edtProductName = item.findViewById(R.id.edt_product_name);
            holder.edtProductPrice = item.findViewById(R.id.edt_product_price);
            holder.edtProductCode = item.findViewById(R.id.edt_product_code);

            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        Product product = productList.get(position);

        holder.edtProductID.setText(String.valueOf(product.getId()));
        holder.edtProductName.setText(product.getName());
        holder.edtProductPrice.setText(String.format("%.2f", product.getPrice()));
        holder.edtProductCode.setText(product.getProductCode());


        return item;
    }
}
