package com.suyonoion.textclockapi17;
/**
 * Created by Suyono on 5/13/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends Activity {

    Button copy0;
    EditText copyTxt0;
    int sdk = android.os.Build.VERSION.SDK_INT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textclock0);
        copy0 = (Button) findViewById(R.id.copy0);
        copyTxt0 = (EditText) findViewById(R.id.copytxt0);
        copy0.setOnClickListener(new View.OnClickListener() {
            String CopyText0;
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                CopyText0 = copyTxt0.getText().toString();
                if (CopyText0.length() != 0) {
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(CopyText0);
                        Toast.makeText(getApplicationContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", CopyText0);
                        Toast.makeText(getApplicationContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Text kosong, tidak ada apapun yang ter-Copy", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void goTogithub(View b) {
        String url="http://google.com";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


}
