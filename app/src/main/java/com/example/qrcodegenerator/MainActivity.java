package com.example.qrcodegenerator;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextInputEditText editText;
    MaterialButton generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate = findViewById(R.id.generate);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.inputET);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString().trim();
                if (!data.isEmpty()) {
                    QRGEncoder qrgEncoder = new QRGEncoder(
                            data,
                            null,
                            QRGContents.Type.TEXT,
                            500 // dimension (pixels)
                    );

                    try {
                        Bitmap bitmap = qrgEncoder.getBitmap();
                        imageView.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
