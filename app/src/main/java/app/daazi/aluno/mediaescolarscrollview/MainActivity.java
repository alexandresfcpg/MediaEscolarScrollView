package app.daazi.aluno.mediaescolarscrollview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public static final String NOME_SHARED_PREFER = "mediaEscolarPref";

    Button btnPrimeiroBimestre, btnSegundoBimestre, btnTerceiroBimestre, btnQuartoBimestre, btnResultadoFinal;

    boolean primeiroBimestre, segundoBimestre, terceiroBimestre, quartoBimestre;
    String materiaPrimeiroBimestre, materiaSegundoBimestre, materiaTerceiroBimestre, materiaQuartoBimestre;
    String situacaoPrimeiroBimestre, situacaoSegundoBimestre, situacaoTerceiroBimestre, situacaoQuartoBimestre;
    String notaProvaPrimeiroBimestre, notaProvaSegundoBimestre, notaProvaTerceiroBimestre, notaProvaQuartoBimestre;
    String notaTrabalhoPrimeiroBimestre, notaTrabalhoSegundoBimestre, notaTrabalhoTerceiroBimestre, notaTrabalhoQuartoBimestre;
    String mediaPrimeiroBimestre, mediaSegundoBimestre, mediaTerceiroBimestre, mediaQuartoBimestre;
    double mediaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        Log.i("MediaEscolar", "onCreate");

        lerSharedPreferences();

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
                Snackbar.make(view, "Limpando todos os registros", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                clearSharedPreferences();
            }
        });

        visualizarResultado();

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

    private void lerSharedPreferences() {

        SharedPreferences mediaEscolarPref = getSharedPreferences(NOME_SHARED_PREFER, 0);


        materiaPrimeiroBimestre = mediaEscolarPref.getString("materiaPrimeiroBimestre", "");
        materiaSegundoBimestre = mediaEscolarPref.getString("materiaSegundoBimestre", "");
        materiaTerceiroBimestre = mediaEscolarPref.getString("materiaTerceiroBimestre", "");
        materiaQuartoBimestre = mediaEscolarPref.getString("materiaQuartoBimestre", "");

        situacaoPrimeiroBimestre = mediaEscolarPref.getString("situacaoPrimeiroBimestre", "");
        situacaoSegundoBimestre = mediaEscolarPref.getString("situacaoSegundoBimestre", "");
        situacaoTerceiroBimestre = mediaEscolarPref.getString("situacaoTerceiroBimestre", "");
        situacaoQuartoBimestre = mediaEscolarPref.getString("situacaoQuartoBimestre", "");

        notaProvaPrimeiroBimestre = mediaEscolarPref.getString("notaProvaPrimeiroBimestre", "0.0");
        notaProvaSegundoBimestre = mediaEscolarPref.getString("notaProvaSegundoBimestre", "0.0");
        notaProvaTerceiroBimestre = mediaEscolarPref.getString("notaProvaTerceiroBimestre", "0.0");
        notaProvaQuartoBimestre = mediaEscolarPref.getString("notaProvaQuartoBimestre", "0.0");

        notaTrabalhoPrimeiroBimestre = mediaEscolarPref.getString("notaTrabalhoPrimeiroBimestre", "0.0");
        notaTrabalhoSegundoBimestre = mediaEscolarPref.getString("notaTrabalhoSegundoBimestre", "0.0");
        notaTrabalhoTerceiroBimestre = mediaEscolarPref.getString("notaTrabalhoTerceiroBimestre", "0.0");
        notaTrabalhoQuartoBimestre = mediaEscolarPref.getString("notaTrabalhoQuartoBimestre", "0.0");

        mediaPrimeiroBimestre = mediaEscolarPref.getString("mediaPrimeiroBimestre", "0.0");
        mediaSegundoBimestre = mediaEscolarPref.getString("mediaSegundoBimestre", "0.0");
        mediaTerceiroBimestre = mediaEscolarPref.getString("mediaTerceiroBimestre", "0.0");
        mediaQuartoBimestre = mediaEscolarPref.getString("mediaQuartoBimestre", "0.0");

        primeiroBimestre = mediaEscolarPref.getBoolean("primeiroBimestre", false);
        segundoBimestre = mediaEscolarPref.getBoolean("segundoBimestre", false);
        terceiroBimestre = mediaEscolarPref.getBoolean("terceiroBimestre", false);
        quartoBimestre = mediaEscolarPref.getBoolean("quartoBimestre", false);


    }

    private void visualizarResultado() {

        if (primeiroBimestre) {
            btnPrimeiroBimestre.setText(materiaPrimeiroBimestre + " - 1º Bimestre " + situacaoPrimeiroBimestre + " - Nota" + formatarValorDecimal(Double.parseDouble(mediaPrimeiroBimestre)));
            btnPrimeiroBimestre.setEnabled(false);
            btnSegundoBimestre.setEnabled(primeiroBimestre);
        }

        if (segundoBimestre) {
            btnSegundoBimestre.setText(materiaSegundoBimestre + " - 2º Bimestre " + situacaoSegundoBimestre + " - Nota" + formatarValorDecimal(Double.parseDouble(mediaSegundoBimestre)));
            btnSegundoBimestre.setEnabled(false);
            btnTerceiroBimestre.setEnabled(segundoBimestre);
        }

        if (terceiroBimestre) {
            btnTerceiroBimestre.setText(materiaTerceiroBimestre + " - 3º Bimestre " + situacaoTerceiroBimestre + " - Nota" + formatarValorDecimal(Double.parseDouble(mediaTerceiroBimestre)));
            btnTerceiroBimestre.setEnabled(false);
            btnQuartoBimestre.setEnabled(terceiroBimestre);
        }

        if (quartoBimestre) {
            btnQuartoBimestre.setText(materiaQuartoBimestre + " - 4º Bimestre " + situacaoQuartoBimestre + " - Nota" + formatarValorDecimal(Double.parseDouble(mediaQuartoBimestre)));
            btnQuartoBimestre.setEnabled(false);
            btnResultadoFinal.setEnabled(true);

            mediaFinal = 0;
            mediaFinal += Double.parseDouble(mediaPrimeiroBimestre);
            mediaFinal += Double.parseDouble(mediaSegundoBimestre);
            mediaFinal += Double.parseDouble(mediaTerceiroBimestre);
            mediaFinal += Double.parseDouble(mediaQuartoBimestre);

            String mensagemFinal = "";

            mediaFinal = (mediaFinal / 4);

            if ((Double.parseDouble(mediaPrimeiroBimestre) >= 7)
                    && (Double.parseDouble(mediaSegundoBimestre) >= 7)
                    && (Double.parseDouble(mediaTerceiroBimestre) >= 7)
                    && (Double.parseDouble(mediaQuartoBimestre) >= 7)) {

                mensagemFinal = mediaFinal >= 7 ? "Aprovado com Média Final " + formatarValorDecimal(mediaFinal) :
                        "Reprovado com Média Final " + formatarValorDecimal(mediaFinal);
            } else {
                mensagemFinal = "Reprovado por matéria com média final " + formatarValorDecimal(mediaFinal);
            }

            btnResultadoFinal.setText(mensagemFinal);
        }

    }

    private static String formatarValorDecimal(double valor) {

        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(valor);
    }

    private void clearSharedPreferences() {

        SharedPreferences mediaEscolarPref = getSharedPreferences(NOME_SHARED_PREFER, 0);
        SharedPreferences.Editor editor = mediaEscolarPref.edit();
        editor.clear();
        editor.commit();

        clearMenur();

    }

    private void clearMenur() {

        btnResultadoFinal.setEnabled(false);
        btnQuartoBimestre.setEnabled(false);
        btnTerceiroBimestre.setEnabled(false);
        btnSegundoBimestre.setEnabled(false);
        btnPrimeiroBimestre.setEnabled(true);

        btnResultadoFinal.setText("Resultado Final");
        btnPrimeiroBimestre.setText("1º Bimestre");
        btnSegundoBimestre.setText("2º Bimestre");
        btnTerceiroBimestre.setText("3º Bimestre");
        btnQuartoBimestre.setText("4º Bimestre");
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

        lerSharedPreferences();
        visualizarResultado();
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

    public void onRestart() {
        super.onRestart();
    }
}