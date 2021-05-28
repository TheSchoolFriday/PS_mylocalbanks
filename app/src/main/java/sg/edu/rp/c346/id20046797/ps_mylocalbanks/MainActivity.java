package sg.edu.rp.c346.id20046797.ps_mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textDBS, textOCBC, textUOB;
    Button btnViral1, btnViral2, btnViral3, btnInvite;
    String selectedText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDBS = findViewById(R.id.tvDBS);
        textOCBC = findViewById(R.id.tvOCBC);
        textUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(textDBS);
        registerForContextMenu(textOCBC);
        registerForContextMenu(textUOB);

        btnViral1 = findViewById(R.id.buttonFirstViral);
        btnViral2 = findViewById(R.id.buttonSecondViral);
        btnViral3 = findViewById(R.id.buttonThirdViral);

        btnInvite = findViewById(R.id.buttonInvite);

        btnViral1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                startActivity(intent);
            }
        });
        
        btnViral2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This is not an actual Function but for Show.", Toast.LENGTH_SHORT).show();
            }
        });

        btnViral3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This is not an actual Function but for Show.", Toast.LENGTH_SHORT).show();
            }
        });

        btnInvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Unfortunately, I have no friends.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.EnglishSelection:
                Toast.makeText(this, "English Selected", Toast.LENGTH_SHORT).show();
                textDBS.setText("DBS");
                textOCBC.setText("OCBC");
                textUOB.setText("UOB");
                break;

            case R.id.ChineseSelection:
                Toast.makeText(this, "Chinese Selected", Toast.LENGTH_SHORT).show();
                textDBS.setText("星展银行");
                textOCBC.setText("华侨银行");
                textUOB.setText("大华银行");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");
        menu.add(0, 2, 2, "Favourite");
        menu.add(0, 3, 3, "Un-favourite");

        if (v == textDBS) {
            selectedText = "DBS";
        } else if (v == textOCBC) {
            selectedText = "OCBC";
        } else if (v == textUOB) {
            selectedText = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (selectedText) {
            case "DBS":
                if (item.getItemId() == 0) {
                    Intent intentDBS = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                    startActivity(intentDBS);
                } else if (item.getItemId() == 1) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 63330033)));
                } else if (item.getItemId() == 2) {
                    textDBS.setTextColor(Color.RED);
                } else if (item.getItemId() == 3) {
                    textDBS.setTextColor(Color.WHITE); // Mine Changes to White because it would be hard to read if its black.
                }
                break;

            case "OCBC":
                if (item.getItemId() == 0) {
                    Intent intentOCBC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway"));
                    startActivity(intentOCBC);
                } else if (item.getItemId() == 1) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 63633333)));
                } else if (item.getItemId() == 2) {
                    textOCBC.setTextColor(Color.RED);
                } else if (item.getItemId() == 3) {
                    textOCBC.setTextColor(Color.WHITE); // Mine Changes to White because it would be hard to read if its black.
                }
                break;

            case "UOB":
                if (item.getItemId() == 0) {
                    Intent intentUOB = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/personal/support/index.page"));
                    startActivity(intentUOB);
                } else if (item.getItemId() == 1) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 65350775)));
                } else if (item.getItemId() == 2) {
                    textUOB.setTextColor(Color.RED);
                } else if (item.getItemId() == 3) {
                    textUOB.setTextColor(Color.WHITE); // Mine Changes to White because it would be hard to read if its black.
                }
                break;
        }

        return super.onContextItemSelected(item);
    }


}