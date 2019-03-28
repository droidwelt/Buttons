package droidwelt.ru.buttontest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class App  extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static Context getContext() {
        return context;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getBaseContext();
        setTextSizeToApp ();
    }


    public  void  setTextSizeToApp () {
        int size_coef = getTextSizePosit ();
        final float start_value = 0.55f; //начальное значение размера шрифта
        final float step = 0.15f; //шаг увеличения коэффициента
        Resources res = getContext().getResources();

        float new_value = start_value + size_coef * step;
        Configuration configuration = new Configuration(res.getConfiguration());
        configuration.fontScale = new_value;
        res.updateConfiguration(configuration, res.getDisplayMetrics());
    }




    public void setTextSizePosit(int iVal ) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(App.getContext());
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("textsize_posit", iVal);
        editor.apply();
    }

    public int getTextSizePosit() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(App.getContext());
        return sp.getInt("textsize_posit", 2);
    }


}
