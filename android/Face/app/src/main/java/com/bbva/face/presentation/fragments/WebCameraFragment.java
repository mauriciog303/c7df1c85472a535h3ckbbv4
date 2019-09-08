package com.bbva.face.presentation.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.bbva.face.R;

public class WebCameraFragment extends Fragment {

    private WebView webview;

    public WebCameraFragment() {
    }

    public static WebCameraFragment newInstance() {
        WebCameraFragment fragment = new WebCameraFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_web_camera, container, false);
        webview = root.findViewById(R.id.wbProject);

        //wbProject.loadUrl("https://www.bbvaexperience.com");
        //wbProject.loadUrl("https://www.google.com.mx");
//        wbProject.loadUrl("https://www.youtube.com/watch?v=DkeiKbqa02g");
//        wbProject.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                wbProject.loadUrl(request.getUrl().toString());
//                return true;
//            }
//        });
        //wbProject.loadUrl("https://developer.android.com/guide/webapps/webview");

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.getSettings().setPluginState(WebSettings.PluginState.ON);
        webview.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webview.getSettings().setAllowFileAccessFromFileURLs(true);
        webview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webview.setWebChromeClient(new WebChromeClient());

        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (request.getOrigin().toString().equals("file:///")) {
                            request.grant(request.getResources());
                        } else {
                            request.deny();
                        }
                    }
                });
            }


        });
        webview.loadUrl("https://mauriciog303.github.io/hackbbva2019/");
        return root;
    }

}
