package com.suyonoion.textclockapi17;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class TampilkanHalaman2 extends Activity {
    Button copy2;
    EditText copyTxt2;
    int sdk = android.os.Build.VERSION.SDK_INT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textclock2);
        copy2 = (Button) findViewById(R.id.copy2);
        copyTxt2 = (EditText) findViewById(R.id.copytxt2);
        copy2.setOnClickListener(new View.OnClickListener() {
            String CopyText2;
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                CopyText2 = copyTxt2.getText().toString();
                if (CopyText2.length() != 0) {
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(CopyText2);
                        Toast.makeText(getApplicationContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", CopyText2);
                        Toast.makeText(getApplicationContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Text kosong, tidak ada apapun yang ter-Copy", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}