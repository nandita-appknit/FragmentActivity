package com.example.fragmentactivity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private EditText editText;
    private Button button;
    OnMessageReadLiastener onmessagereadlistener;

    public MessageFragment() {
        // Required empty public constructor
    }
    public interface OnMessageReadLiastener{
        public void onmessageread(String message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_message, container, false);
        editText=view.findViewById(R.id.TextMessage);
        button=view.findViewById(R.id.bn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String message=editText.getText().toString();
            onmessagereadlistener.onmessageread(message);
            }
        });

        return view;

            }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Activity activity=(Activity) context;
        onmessagereadlistener=(OnMessageReadLiastener) activity;
    }
}






