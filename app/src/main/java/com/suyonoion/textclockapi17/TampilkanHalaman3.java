package com.suyonoion.textclockapi17;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Suyono on 5/13/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class  TampilkanHalaman3 extends Activity {
    Button copy3,copy4;
    EditText copyTxt3,copyTxt4;
    int sdk = android.os.Build.VERSION.SDK_INT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textclock3);
        copy3 = (Button) findViewById(R.id.copy3);
        copy4 = (Button) findViewById(R.id.copy4);
        copyTxt3 = (EditText) findViewById(R.id.copytxt3);
        copyTxt4 = (EditText) findViewById(R.id.copytxt4);
        copy3.setOnClickListener(new View.OnClickListener() {
            String CopyText3;
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                CopyText3 = copyTxt3.getText().toString();
                if (CopyText3.length() != 0) {
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(CopyText3);
                        Toast.makeText(getApplicationContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", CopyText3);
                        Toast.makeText(getApplicationContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Nothing to Copy", Toast.LENGTH_SHORT).show();
                }
            }
        });
        copy4.setOnClickListener(new View.OnClickListener() {
            String CopyText4;
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                CopyText4 = copyTxt4.getText().toString();
                if (CopyText4.length() != 0) {
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(CopyText4);
                        Toast.makeText(getApplicationContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", CopyText4);
                        Toast.makeText(getApplicationContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Text Kosong, Tidak ada apapun yang ter-Copy", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
