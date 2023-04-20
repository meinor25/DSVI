package com.example.laboratorio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtNum1;
    EditText txtNum2;
    TextView lblResultado;
    Spinner spnOper;
    CheckBox chkDialogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InicializarControles();
    }

    private void InicializarControles() {

        List<Integer> ops = Arrays.asList(0,1,2,3,4);
        ArrayAdapter<Integer> adapterList = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ops);
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        spnOper = (Spinner) findViewById(R.id.spnOper);
        chkDialogo = (CheckBox) findViewById(R.id.chkDialogo);
        lblResultado = (TextView) findViewById(R.id.lblRes);
        spnOper.setAdapter(adapterList);

    }

    public void CalcularRes(View view){
        try{
            int n1 = Integer.parseInt(txtNum1.getText().toString());
            int n2 = Integer.parseInt(txtNum2.getText().toString());
            int op = Integer.parseInt(spnOper.getSelectedItem().toString());
            int resultado;

            // Cambiar a String despues pa que este bonito :)
            switch (op){
                case 0:
                    resultado = n1+n2;
                    break;
                case 1:
                    resultado = n1-n2;
                    break;
                case 2:
                    resultado = n1*n2;
                    break;
                case 3:
                    resultado = n1/n2;
                    break;
                case 4:
                    resultado = (int) Math.pow(n1, n2);
                    break;
                default:
                    resultado = n1+n2;
                    break;


            }

            if (chkDialogo.isChecked()){
                new Mensajito(resultado).show(getSupportFragmentManager(), "a");
            }

            lblResultado.setText(Integer.toString(resultado));
        } catch (Exception e){
            Toast.makeText(this,"Error en la suma de los datos" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}