package app.daazi.aluno.mediaescolarscrollview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;


public class TerceiroBimestreActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText editMateria, editNotaProva, editNotaTrabalho;
    TextView txtResultado, txtSituacao;

    double notaProva;
    double notaTrabalho;
    double media;

    boolean dadosValidados = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceiro_bimestre);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editMateria = findViewById(R.id.editMateria);
        editNotaProva = findViewById(R.id.editNotaProva);
        editNotaTrabalho = findViewById(R.id.editNotaTrabalho);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
        txtSituacao = findViewById(R.id.txtSituacao);

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

                        if (media >= 7) txtSituacao.setText("Aprovado");
                        else txtSituacao.setText("Reprovado");

                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Informe os dados...",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

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
}