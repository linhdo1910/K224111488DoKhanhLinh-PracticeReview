package com.example.k224111488dokhanhlinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k224111488dokhanhlinh.adapters.ProductAdapter;

import com.example.k224111488dokhanhlinh.models.ListProduct;
import com.example.k224111488dokhanhlinh.models.Product;

public class MainActivity extends AppCompatActivity {
    ListView lvProduct;
    ProductAdapter adapter;
    ListProduct lc=new ListProduct();
    MenuItem menu_add_product;
    MenuItem menu_about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();

    }

    private void addViews() {
        lvProduct=findViewById(R.id.lvProduct);
        adapter=new ProductAdapter( MainActivity.this, R.layout.item_main);
        lvProduct.setAdapter(adapter);

        ListProduct lp=new ListProduct();
        lp.generateSampleData();
        adapter.addAll(lp.getProducts());
    }
    private void openProductDetailActivity(Product p) {
        Intent intent=new Intent(MainActivity.this,
                ProductDetailActivity.class);
        intent.putExtra("SELECTED_PRODUCT",p);
        startActivityForResult(intent, 1001);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_add_product) {
            // Mở màn hình ProductDetailActivity
            Intent intent = new Intent(this, ProductDetailActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.menu_about) {
            Intent intent = new Intent(this,AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == RESULT_OK && data != null) {
            Product addProduct = (Product) data.getSerializableExtra("NEW_PRODUCT");
            if (addProduct != null) {
                lc.addProduct(addProduct); // Thêm vào danh sách
                adapter.clear();
                adapter.addAll(lc.getProducts());
                adapter.notifyDataSetChanged();
            }
        }
    }
}