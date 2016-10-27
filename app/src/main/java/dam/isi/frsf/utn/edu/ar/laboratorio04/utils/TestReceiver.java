package dam.isi.frsf.utn.edu.ar.laboratorio04.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.net.URI;

import dam.isi.frsf.utn.edu.ar.laboratorio04.ListarReservasActivity;
import dam.isi.frsf.utn.edu.ar.laboratorio04.MainActivity;
import dam.isi.frsf.utn.edu.ar.laboratorio04.R;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Reserva;
import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Usuario;

/**
 * Created by Matias on 14/10/2016.
 */
public class TestReceiver extends BroadcastReceiver {
    private static final String tag = "TestReceiver";

    @Override
    public void onReceive(Context context, Intent intent){
        if(/*System.currentTimeMillis() % 3 == 0*/true) {

            Log.d("Etiqueta", "Entra al onReceive");

            AlarmaReserva.cancelarAlarma();

            Reserva reserva = (Reserva) intent.getSerializableExtra("reserva");
            Usuario usuario = (Usuario) intent.getSerializableExtra("usuario");

            usuario.getReservas().get(usuario.getReservas().size()-1).setConfirmada(true);

            MainActivity.actualizarReserva(reserva);


            String ns= Context.NOTIFICATION_SERVICE;
            NotificationManager notifmanager= (NotificationManager) context.getSystemService(ns);

            Intent i= new Intent(context, ListarReservasActivity.class);
            i.putExtra("usuario",usuario);
            PendingIntent pi = PendingIntent.getActivity(context, reserva.getId(), i, PendingIntent.FLAG_ONE_SHOT);

            //seteando ringotne a la notificacion
            RingtoneManager rinmanager = null;
            Uri uri = rinmanager.getRingtoneUri(rinmanager.TYPE_NOTIFICATION);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pi)
                    .setContentTitle("Confirmacion reserva")
                    .setContentText("La reserva ha sido confirmada!")
                    .setSound(uri);

            notifmanager.notify(1, builder.build());
        }
    }
}