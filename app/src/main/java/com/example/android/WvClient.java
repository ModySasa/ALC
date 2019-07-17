package com.example.android;

import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AlertDialog;

public class WvClient extends WebViewClient {
    public WvClient(Context context) {
        this.context = context;
    }

    Context context;

    @Override
    public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
        // for SSLErrorHandler
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("notification_error_ssl_cert_invalid");
        builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                handler.proceed();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                handler.cancel();
            }
        });
        final AlertDialog dialog = builder.create();
        dialog.show();
    }
}
