package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button btnLoadURL;
    Spinner categorySpn, subCategorySpn;
    ArrayList<String> alSubCategory;
    ArrayAdapter<String> aaSubCategory;
    String[][] sites = {
            {
                "https://www.rp.edu.sg", "https://www.rp.edu.sg/student-life"
            },
            {
                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLoadURL = findViewById(R.id.btnLoadURL);
        categorySpn = findViewById(R.id.categorySPN);
        subCategorySpn = findViewById(R.id.subCategorySPN);

        alSubCategory = new ArrayList<>();
        aaSubCategory = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                alSubCategory);

        final String [] rpSubCategory = getResources().getStringArray(R.array.rp);
        final String [] soiSubCategory = getResources().getStringArray(R.array.soi);
        alSubCategory.addAll(Arrays.asList(rpSubCategory));
        subCategorySpn.setAdapter(aaSubCategory);

        categorySpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        alSubCategory.clear();
                        alSubCategory.addAll(Arrays.asList(rpSubCategory));
                        subCategorySpn.setAdapter(aaSubCategory);
                        break;
                    case 1:
                        alSubCategory.clear();
                        alSubCategory.addAll(Arrays.asList(soiSubCategory));
                        subCategorySpn.setAdapter(aaSubCategory);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnLoadURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), WebActivity.class);
                int category = categorySpn.getSelectedItemPosition();
                int subcategory = subCategorySpn.getSelectedItemPosition();

                String url = sites[category][subcategory];
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }
}
