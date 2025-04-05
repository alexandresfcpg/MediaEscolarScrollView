package app.daazi.aluno.mediaescolarscrollview;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import app.daazi.aluno.mediaescolarscrollview.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button btnPrimeiroBimestre, btnSegundoBimestre, btnTerceiroBimestre, btnQuartoBimestre, btnResultadoFinal;

    boolean primeiroBimestre, segundoBimestre, terceiroBimestre, quartoBimestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        btnPrimeiroBimestre = findViewById(R.id.btnPrimeiroBimestre);
        btnSegundoBimestre = findViewById(R.id.btnSegundoBimestre);
        btnTerceiroBimestre = findViewById(R.id.btnTerceiroBimestre);
        btnQuartoBimestre = findViewById(R.id.btnQuartoBimestre);
        btnResultadoFinal = findViewById(R.id.btnResultadoFinal);

        btnPrimeiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela = new Intent(MainActivity.this, PrimeiroBimestreActivity.class);
                startActivity(proximaTela);

            }
        });

        btnSegundoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela = new Intent(MainActivity.this, SegundoBimestreActivity.class);
                startActivity(proximaTela);

            }
        });

        btnTerceiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela = new Intent(MainActivity.this, TerceiroBimestreActivity.class);
                startActivity(proximaTela);

            }
        });

        btnQuartoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela = new Intent(MainActivity.this, QuartoBimestreActivity.class);
                startActivity(proximaTela);

            }
        });

        btnResultadoFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Resultado Final", Toast.LENGTH_SHORT).show();

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    /*private void setSupportActionBar(Toolbar toolbar) {
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i("MediaEscolar", "---> OnResume");

       primeiroBimestre = true;

       if (primeiroBimestre) {
           btnPrimeiroBimestre.setEnabled(true);
           btnSegundoBimestre.setEnabled(true);
           btnPrimeiroBimestre.setText("FECHADO");
       }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onRestart(){
        super.onRestart();
    }
}