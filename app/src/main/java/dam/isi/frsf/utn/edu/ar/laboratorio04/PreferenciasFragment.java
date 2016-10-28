package dam.isi.frsf.utn.edu.ar.laboratorio04;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreferenciasFragment extends PreferenceFragment {
    EditTextPreference userEditText;
    EditTextPreference emailEditText;
    RingtonePreference ringtonepref;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String user = sp.getString("usuario","usuario default");
        String mail = sp.getString("email","email default");
        String ringtone = sp.getString("ringtone","ningun ringtone");

        userEditText = (EditTextPreference) findPreference("usuario");
        userEditText.setSummary(user);

        emailEditText = (EditTextPreference) findPreference("email");
        emailEditText.setSummary(mail);

        ringtonepref = (RingtonePreference) findPreference("ringtone");
        ringtonepref.setSummary(ringtone);

    }


}
