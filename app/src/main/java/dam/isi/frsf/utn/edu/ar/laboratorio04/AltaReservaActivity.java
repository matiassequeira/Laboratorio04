package dam.isi.frsf.utn.edu.ar.laboratorio04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Departamento;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Reserva;

public class AltaReservaActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtFechaInicio;
    EditText txtFechaFin;
    Departamento depto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_reserva);
        txtFechaInicio = (EditText) findViewById(R.id.editFInicio);
        txtFechaFin = (EditText) findViewById(R.id.editFFin);
        Button btnReservar = (Button) findViewById(R.id.buttonReserva);
        btnReservar.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        depto = (Departamento) intent.getSerializableExtra("deptoSeleccionado");

    }

    @Override
    public void onClick(View v) {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Calendar c = Calendar.getInstance();
        try {
            c.setTime(df.parse(txtFechaInicio.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c1 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(txtFechaFin.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date fechaInicio = c.getTime();
        Date fechaFin = c1.getTime();

        Reserva reserva = new Reserva(depto.getReservas().get(depto.getReservas().size()-1).getId()+1,fechaInicio,fechaFin,depto);

        depto.getReservas().add(reserva);

        Toast.makeText(v.getContext(), "Reserva creada" , Toast.LENGTH_SHORT).show();

        finish();

    }
}
