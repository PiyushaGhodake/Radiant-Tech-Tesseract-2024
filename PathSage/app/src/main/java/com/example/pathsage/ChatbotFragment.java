package com.example.pathsage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChatbotFragment extends Fragment {

    public ChatbotFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_chatbot, container, false);

        WebView webView1 = rootView.findViewById(R.id.webView1);
        String video1 = "<iframe width=\"510\" height=\"300\" src=\"https://www.youtube.com/embed/Iyb-oaaR20U?si=0LY8YhIfbqncDcgi\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webView1.loadData(video1, "text/html","utf-8");
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.setWebChromeClient(new WebChromeClient());

        WebView webView2 = rootView.findViewById(R.id.webView2);
        String video2 = "<iframe width=\"510\" height=\"300\" src=\"https://www.youtube.com/embed/oXJErYTsDR0?si=9qQDsNjLVVssahKy\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webView2.loadData(video2, "text/html","utf-8");
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebChromeClient(new WebChromeClient());

        WebView webView3 = rootView.findViewById(R.id.webView3);
        String video3 = "<iframe width=\"510\" height=\"300\" src=\"https://www.youtube.com/embed/YWVxasaOnNs?si=rOJbONeT1D14d02y\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
        webView3.loadData(video3, "text/html","utf-8");
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.setWebChromeClient(new WebChromeClient());

        return rootView;
    }
}
