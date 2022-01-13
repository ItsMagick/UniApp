package com.example.unistundenplan.View.LessonDetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.unistundenplan.R;



public class ModuleHandbookFragment extends Fragment {



    public ModuleHandbookFragment() { }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_handbook, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView webView = getView().findViewById(R.id.module_webview);
        webView.loadUrl("https://www.hof-university.de/studieninteressierte/studienangebot/mobile-computing-bsc/modulhandbuch.html?tx_modulhandbuch_modulhandbuch%5Baction%5D=showMhb&tx_modulhandbuch_modulhandbuch%5Bback%5D%5Bclass%5D=MC&tx_modulhandbuch_modulhandbuch%5Bback%5D%5Bid%5D=0&tx_modulhandbuch_modulhandbuch%5Bback%5D%5Bsem%5D=3&tx_modulhandbuch_modulhandbuch%5Bback%5D%5Byear%5D=WS%202021&tx_modulhandbuch_modulhandbuch%5Bclass%5D=MC&tx_modulhandbuch_modulhandbuch%5Bcontroller%5D=Modulhandbuch&tx_modulhandbuch_modulhandbuch%5Bid%5D=26222&tx_modulhandbuch_modulhandbuch%5Bid2%5D=6757&tx_modulhandbuch_modulhandbuch%5Bsem%5D=3&tx_modulhandbuch_modulhandbuch%5Byear%5D=WS%202021&cHash=8257081a0f97c7354724069d73672cc9");
    }
}