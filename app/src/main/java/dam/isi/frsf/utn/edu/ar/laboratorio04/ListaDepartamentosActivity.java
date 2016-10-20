package dam.isi.frsf.utn.edu.ar.laboratorio04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Usuario;
import dam.isi.frsf.utn.edu.ar.laboratorio04.utils.BuscarDepartamentosTask;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Departamento;
import dam.isi.frsf.utn.edu.ar.laboratorio04.utils.BusquedaFinalizadaListener;
import dam.isi.frsf.utn.edu.ar.laboratorio04.utils.FormBusqueda;


public class ListaDepartamentosActivity extends AppCompatActivity implements BusquedaFinalizadaListener<Departamento>, AdapterView.OnItemLongClickListener{

    private TextView tvEstadoBusqueda;
    private ListView listaAlojamientos;
    private DepartamentoAdapter departamentosAdapter;
    private List<Departamento> lista;
    Intent intent;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alojamientos);
        lista= new ArrayList<>();
        listaAlojamientos= (ListView ) findViewById(R.id.listaAlojamientos);
        tvEstadoBusqueda = (TextView) findViewById(R.id.estadoBusqueda);
        listaAlojamientos.setOnItemLongClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        intent = getIntent();
        Boolean esBusqueda = intent.getExtras().getBoolean("esBusqueda");
        if(esBusqueda){
            FormBusqueda fb = (FormBusqueda ) intent.getSerializableExtra("frmBusqueda");
            new BuscarDepartamentosTask(ListaDepartamentosActivity.this).execute(fb);
            tvEstadoBusqueda.setText("Buscando....");
            tvEstadoBusqueda.setVisibility(View.VISIBLE);
        }else{
            tvEstadoBusqueda.setVisibility(View.GONE);
            lista=Departamento.getAlojamientosDisponibles();
        }
        departamentosAdapter = new DepartamentoAdapter(ListaDepartamentosActivity.this,lista);
        listaAlojamientos.setAdapter(departamentosAdapter);
    }



    @Override
    public void busquedaFinalizada(List<Departamento> listaDepartamento) {
        //TODO implementar
        lista.clear();
        lista.addAll(listaDepartamento);
        //departamentosAdapter.addAll(listaDepartamento);
        departamentosAdapter.notifyDataSetChanged();
    }

    @Override
    public void busquedaActualizada(String msg) {
        tvEstadoBusqueda.setText(" Buscando..."+msg);
    }




    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Departamento deptoSeleccionado= departamentosAdapter.getItem(position);

        Intent i = new Intent(this,AltaReservaActivity.class);
        i.putExtra("deptoSeleccionado",deptoSeleccionado);
        i.putExtra("usuario", (Usuario) intent.getSerializableExtra("usuario"));
        startActivity(i);
        finish();
        return false;
    }
}
