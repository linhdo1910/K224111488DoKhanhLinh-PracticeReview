package com.example.k224111488dokhanhlinh;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k224111488dokhanhlinh.models.Product;

public class ProductDetailActivity extends AppCompatActivity {
    EditText edt_product_id;
    EditText edt_product_code;
    EditText edt_product_name;
    EditText edt_product_price;
    Button btnAdd, btnSave, btnRemove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        displayProductDetails();
    }

    private void displayProductDetails() {
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("SELECTED_PRODUCT");
        if (product != null) {
            edt_product_id.setText(String.valueOf(product.getId()));
            edt_product_name.setText(product.getName());
            edt_product_code.setText(product.getProductCode());
            edt_product_price.setText(String.valueOf(product.getPrice()));
        }
    }

    private void addViews() {
        edt_product_id = findViewById(R.id.edt_product_id);
        edt_product_code = findViewById(R.id.edt_product_code);
        edt_product_name = findViewById(R.id.edt_product_name);
        edt_product_price = findViewById(R.id.edt_product_price);

        btnAdd = findViewById(R.id.btnAdd);
        btnSave = findViewById(R.id.btnSave);
        btnRemove = findViewById(R.id.btnRemove);
    }

}

