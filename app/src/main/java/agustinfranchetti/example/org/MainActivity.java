package agustinfranchetti.example.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSingle = (Button) findViewById(R.id.btnSingle);
        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, YoutubeActivity.class);
                startActivity(intent);
            }
        });

        Button btnStandalone = (Button) findViewById(R.id.btnStandalone);
        btnStandalone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubmenuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        
    }

    /*@Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnSingle:
                intent = new Intent(this, YoutubeActivity.class);

            case R.id.btnStandalone:
                intent = new Intent(this, SubmenuActivity.class);
                break;
            default:
        }
        if (intent != null) {
            startActivity(intent);
        }
    }*/
}