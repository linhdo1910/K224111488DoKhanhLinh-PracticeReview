package com.example.k224111488dokhanhlinh;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    EditText edt_product_imageid;

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
        addView();
        addEvents();
    }

    private void addView() {
        edt_product_id = findViewById(R.id.edt_product_id);
        edt_product_name = findViewById(R.id.edt_product_name);
        edt_product_code = findViewById(R.id.edt_product_code);
        edt_product_price = findViewById(R.id.edt_product_price);
        edt_product_imageid = findViewById(R.id.edt_product_imageid);

        btnAdd = findViewById(R.id.btnAdd);
        btnSave = findViewById(R.id.btnSave);
        btnRemove = findViewById(R.id.btnRemove);

        display_product_details();
    }

    private void addEvents() {
        btnAdd.setOnClickListener(v -> {
            if (validateInputs()) {
                Product newProduct = createProductFromInputs();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("ADD_PRODUCT", newProduct);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btnSave.setOnClickListener(v -> {
            if (validateInputs()) {
                Product updatedProduct = createProductFromInputs();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("SAVE_PRODUCT", updatedProduct);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btnRemove.setOnClickListener(v -> {
            // Nếu bạn muốn trả về product id để xóa
            String idStr = edt_product_id.getText().toString();
            if (idStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập ID sản phẩm để xóa", Toast.LENGTH_SHORT).show();
                return;
            }
            int id = Integer.parseInt(idStr);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("REMOVE_PRODUCT_ID", id);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }

    private boolean validateInputs() {
        if (edt_product_id.getText().toString().isEmpty() ||
                edt_product_name.getText().toString().isEmpty() ||
                edt_product_code.getText().toString().isEmpty() ||
                edt_product_price.getText().toString().isEmpty() ||
                edt_product_imageid.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private Product createProductFromInputs() {
        int id = Integer.parseInt(edt_product_id.getText().toString());
        String name = edt_product_name.getText().toString();
        String productCode = edt_product_code.getText().toString();
        double price = Double.parseDouble(edt_product_price.getText().toString());
        String imageLink = edt_product_imageid.getText().toString();

        return new Product(id, productCode, name, price, imageLink);
    }

    private void display_product_details() {
        Intent intent = getIntent();
        Product c = (Product) intent.getSerializableExtra("SELECTED_PRODUCT");

        if (c != null) {
            edt_product_id.setText(String.valueOf(c.getId()));
            edt_product_name.setText(c.getName());
            edt_product_code.setText(c.getProductCode());
            edt_product_price.setText(String.valueOf(c.getPrice()));
            edt_product_imageid.setText(c.getImageLink());
        } else {
            edt_product_id.setText("");
            edt_product_name.setText("");
            edt_product_code.setText("");
            edt_product_price.setText("");
            edt_product_imageid.setText("");
        }
    }
}
