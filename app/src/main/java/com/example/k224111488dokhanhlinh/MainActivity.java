package com.example.k224111488dokhanhlinh;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.k224111488dokhanhlinh.models.ListEmployee;
import com.example.k224111488dokhanhlinh.models.ListProduct;
import com.example.k224111488dokhanhlinh.models.Product;

public class MainActivity extends AppCompatActivity {

    private ListView lvProduct;
    private ArrayAdapter<Product> adapter;
    private ListProduct lp = new ListProduct();
    MenuItem menu_add_product;
    MenuItem menu_about;

    private static final int ID_ADD_PRODUCT = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addViews() {
        lvProduct = findViewById(R.id.lvProduct);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        lp.generateSampleData();
        adapter.addAll(lp.getProducts());
        lvProduct.setAdapter(adapter);

        menu_add_product=findViewById(R.id.menu_add_product);
        menu_about=findViewById(R.id.menu_about);
    }

    private void addEvents() {
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Product product = adapter.getItem(position);
                openAddProductDetailActivity(product);
            }
        });
    }

    private void openAddProductDetailActivity(Product product) {
        Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
        intent.putExtra("SELECTED_PRODUCT", product);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_add_product) {
            Toast.makeText(MainActivity.this, "Mở màn hình thêm product mới", Toast.LENGTH_SHORT).show();
            openAddProductActivity();
        }
        else if (item.getItemId()==R.id.menu_about) {
            Toast.makeText(MainActivity.this, "Mở màn thông tin student", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openAddProductActivity() {
        Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
        startActivityForResult(intent, ID_ADD_PRODUCT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ID_ADD_PRODUCT && resultCode == 1000 && data != null) {
            Product product = (Product) data.getSerializableExtra("ADD_PRODUCT");
            if (product != null) {
                process_add_product(product);
            }
        }
    }

    private void process_add_product(Product product) {
        boolean result = lp.isExist(product);
        if(result==true)
            return;
        lp.addProduct(product);
        adapter.clear();
        adapter.addAll(lp.getProducts());
    }
}


