package app.daazi.aluno.mediaescolarscrollview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class QuartoBimestreActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText editMateria, editNotaProva, editNotaTrabalho;
    TextView txtResultado, txtSituacaoFinal;

    double notaProva;
    double notaTrabalho;
    double media;

    boolean dadosValidados = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_bimestre);
       /* Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        editMateria = findViewById(R.id.editMateria);
        editNotaProva = findViewById(R.id.editNotaProva);
        editNotaTrabalho = findViewById(R.id.editNotaTrabalho);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
        txtSituacaoFinal = findViewById(R.id.txtSituacaoFinal);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if(editNotaProva.getText().toString().length()>0) {
                        notaProva = Double.parseDouble(editNotaProva.getText().toString());
                    }else{
                        editNotaProva.setError("*");
                        editNotaProva.requestFocus();
                        dadosValidados = false;
                    }

                    if(editNotaTrabalho.getText().toString().length()>0){
                        notaTrabalho = Double.parseDouble(editNotaTrabalho.getText().toString());
                    }else{
                        editNotaTrabalho.setError("*");
                        editNotaTrabalho.requestFocus();
                        dadosValidados = false;
                    }

                    if(editMateria.getText().toString().length()==0){
                        editMateria.setError("*");
                        editMateria.requestFocus();
                        dadosValidados = false;

                    }

                    if(dadosValidados) {
                        media = (notaProva + notaTrabalho) / 2;
                        txtResultado.setText(String.valueOf(media));

                        if (media >= 7) txtSituacaoFinal.setText("Aprovado");
                        else txtSituacaoFinal.setText("Reprovado");

                        salvarSharedPreferences();


                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Informe os dados...",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

   /* private void setSupportActionBar(Toolbar toolbar) {
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_sair) {

            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void salvarSharedPreferences(){

        SharedPreferences mediaEscolarPref = getSharedPreferences(MainActivity.NOME_SHARED_PREFER, 0);
        SharedPreferences.Editor mediaEscolar = mediaEscolarPref.edit();

        mediaEscolar.putString("materiaQuartoBimestre", editMateria.getText().toString());
        mediaEscolar.putString("situacaoQuartoBimestre", txtSituacaoFinal.getText().toString());
        mediaEscolar.putString("notaProvaQuartoBimestre", String.valueOf(notaProva));
        mediaEscolar.putString("notaTrabalhoQuartoBimestre", String.valueOf(notaTrabalho));
        mediaEscolar.putString("mediaQuartoBimestre", String.valueOf(media));
        mediaEscolar.putBoolean("quartoBimestre", true);

        mediaEscolar.commit();

    }
}