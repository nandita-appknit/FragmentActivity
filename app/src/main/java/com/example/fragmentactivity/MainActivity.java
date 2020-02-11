package com.example.fragmentactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageReadLiastener
{
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null){
                return;
            }
            MessageFragment messageFragment=new MessageFragment();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,messageFragment,null);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onmessageread(String message) {
    textView=findViewById(R.id.Display_Message);
    textView.setText(message);
    }
}
