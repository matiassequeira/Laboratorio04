package dam.isi.frsf.utn.edu.ar.laboratorio04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Departamento;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Reserva;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Usuario;

public class ListarReservasActivity extends AppCompatActivity {

    private Intent intent;
    private Usuario usuario;
    ListView listaReservas;
    private ReservaAdapter reservasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_reservas_activity);
        listaReservas = (ListView) findViewById(R.id.listaReservas);
    }

    @Override
    protected void onStart() {
        super.onStart();
        intent = getIntent();
        usuario = (Usuario) intent.getSerializableExtra("usuario");
        listarReservas();

    }


    private void listarReservas() {
        reservasAdapter = new ReservaAdapter(ListarReservasActivity.this,usuario.getReservas());
        listaReservas.setAdapter(reservasAdapter);
    }
}
