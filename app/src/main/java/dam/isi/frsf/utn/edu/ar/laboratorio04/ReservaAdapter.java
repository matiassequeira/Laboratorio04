package dam.isi.frsf.utn.edu.ar.laboratorio04;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Departamento;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Reserva;

public class ReservaAdapter extends ArrayAdapter<Reserva>  {
    private LayoutInflater inflater;
    private Context contexto;


    public ReservaAdapter(Context contexto, List<Reserva> items) {
        super(contexto, R.layout.fila, items);
        inflater = LayoutInflater.from(contexto);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DecimalFormat df = new DecimalFormat("#.##");
        View row = convertView;

        if (row == null) row = inflater.inflate(R.layout.fila, parent, false);

        TextView txtEstadoReserva = (TextView) row.findViewById(R.id.estadoReserva);

        if (this.getItem(position).getConfirmada()){
            txtEstadoReserva.setText("   Confirmada");
            txtEstadoReserva.setTextColor(Color.GREEN);
        }
        else {
            txtEstadoReserva.setText("   Pendiente");
            txtEstadoReserva.setTextColor(Color.YELLOW);
        }

        Departamento depto= this.getItem(position).getAlojamiento();

        TextView txtCiudad = (TextView) row.findViewById(R.id.ciudad);
        txtCiudad.setText(depto.getCiudad().getNombre());
        TextView txtDescripcion = (TextView) row.findViewById(R.id.descripcion);
        txtDescripcion.setText("Unico!! " + depto.getDescripcion());
        TextView txtPrecio = (TextView) row.findViewById(R.id.precio);
        txtPrecio.setText("$" + (df.format(depto.getPrecio())));
        TextView txtCapacidad = (TextView) row.findViewById(R.id.capacidadMax);
        txtCapacidad.setText(depto.getCapacidadMaxima()+".");
        return (row);

    }

}
