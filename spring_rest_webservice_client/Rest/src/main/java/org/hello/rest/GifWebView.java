package org.hello.rest;

import android.content.Context;
import android.webkit.WebView;

/**
 * Created by Rafael on 16/07/2016.
 */
public class GifWebView extends WebView {

    public GifWebView(Context context, String path) {
        super(context);

        loadUrl(path);
    }
}