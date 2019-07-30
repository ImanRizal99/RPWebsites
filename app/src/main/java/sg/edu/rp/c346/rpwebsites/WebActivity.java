package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    WebView wvView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);

        wvView = findViewById(R.id.WebView);
        Intent intentReceived = getIntent();
        String url = intentReceived.getStringExtra("url");
        wvView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = wvView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(false);
        webSettings.setDisplayZoomControls(true);
        Log.i("WebActivity",url);
        wvView.loadUrl(url);
    }
}
