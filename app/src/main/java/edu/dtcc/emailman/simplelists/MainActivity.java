package edu.dtcc.emailman.simplelists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] sandwiches =
                {"Ham", "Turkey","Roast Beef","Salami","Italian Combo","Tuna","Liverwurst",
                "BLT", "Ham and Cheese", "Turkey and Cheese", "Salami and Cheese"};
        ListAdapter listAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sandwiches);
        ListView myListView = (ListView) findViewById(R.id.lvSandwiches);
        myListView.setAdapter(listAdapter);

        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String sandwich = String.valueOf(adapterView.getItemAtPosition(i));

                        TextView tvChoice = (TextView) findViewById(R.id.tvChoice);
                        tvChoice.setText("Ordering one " + sandwich.toLowerCase() + " sandwich");
                    }
                }
        );
    }
}
