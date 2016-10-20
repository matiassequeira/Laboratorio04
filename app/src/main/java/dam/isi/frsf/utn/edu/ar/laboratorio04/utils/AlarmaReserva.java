package dam.isi.frsf.utn.edu.ar.laboratorio04.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.*;

import dam.isi.frsf.utn.edu.ar.laboratorio04.modelo.Reserva;

/**
 * Created by Matias on 14/10/2016.
 */
public class AlarmaReserva {

    static Context contexto;
    static Reserva reserva;

    public AlarmaReserva (Context context,Reserva res){

        contexto=context;
        reserva=res;

        //Obtener un intent para invocar al receptor
        Intent intent = new Intent(context, TestReceiver.class);
        intent.putExtra("reserva", reserva);

        PendingIntent pi = PendingIntent.getBroadcast(context,reserva.getId(),intent,0);

        // Programar la alarma
        AlarmManager am =(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, 1000, 5*1000, pi);
    }

    public static void cancelarAlarma(){
        //Usarel intent usadopara invocarTestReceiver

        if (contexto !=null && reserva != null) {
            Intent intent = new Intent(contexto, TestReceiver.class);

            PendingIntent pi = PendingIntent.getBroadcast(contexto, reserva.getId(), intent, 0);
            // Cancelar la alarma
            AlarmManager am = (AlarmManager) contexto.getSystemService(Context.ALARM_SERVICE);
            am.cancel(pi);
        }
    }

}
