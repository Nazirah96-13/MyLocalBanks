package sg.edu.rp.c346.id17032457.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView dbs;
    TextView ocbc;
    TextView uob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = findViewById(R.id.textViewDBS);
        ocbc = findViewById(R.id.textViewOCBC);
        uob = findViewById(R.id.textViewUOB);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //menu add method
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // …
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            dbs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                    startActivity(intent);
                }
            });

            ocbc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                    startActivity(intent);
                }
            });

            uob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.uob.com.sg"));
                    startActivity(intent);
                }
            });


            return true; //menu item successfully handled
        }
        //Source Code 3b
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            dbs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ "1800 111 1111"));
                    startActivity(intentCall);

                }
            });


            ocbc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ "1800 363 3333"));
                    startActivity(intentCall);

                }
            });


            uob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ "1800 222 2121"));
                    startActivity(intentCall);

                }
            });

            return true;  //menu item successfully handled
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");

            return true;
        } else if (id == R.id.ChineseSelection) {

            dbs.setText("数据库银行");
            ocbc.setText("华侨银行");
            uob.setText("乌布银行");


            return true;
        } else {
           Log.e("onOptionsItemSelected", "Error, neither English nr Chinese");
        }

        return super.onOptionsItemSelected(item);
    }










}






