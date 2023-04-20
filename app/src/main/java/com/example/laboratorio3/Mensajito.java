package com.example.laboratorio3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Mensajito extends DialogFragment {

    int resultado;

    public Mensajito(int resultado) {
        this.resultado = resultado;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("" + resultado).setTitle("Resultado").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { dialog.cancel(); }
        });

        return builder.create();

    }

}
