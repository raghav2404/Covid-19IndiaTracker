package android.example.covid_19indiatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Info extends AppCompatActivity {
private TextView tv,tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
         tv=findViewById(R.id.tv);
         tv1=findViewById(R.id.api);


    }
}
