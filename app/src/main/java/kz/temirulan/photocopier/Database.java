package kz.temirulan.photocopier;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Database {

    public Database() {
    }

    public static void putUser(Context context, String user, String pass) {
        SharedPreferences prefs = context.getSharedPreferences("temir", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int n = prefs.getInt("users_cnt", 0) + 1;
        //Toast.makeText(context, n + "", Toast.LENGTH_SHORT).show();
        editor.putString("user" + n, user);
        editor.putString("pass" + n, pass);
        editor.putInt("users_cnt", n);
        editor.commit();
        Toast.makeText(context, "User created!", Toast.LENGTH_SHORT).show();
    }

    public static boolean checkUser(Context context, String user, String pass) {
        SharedPreferences prefs = context.getSharedPreferences("temir", Context.MODE_PRIVATE);
        int n = prefs.getInt("users_cnt", 0);
        for (int i = 1; i <= n; i++) {
            String cur_user = prefs.getString("user" + i, "");
            String cur_pass = prefs.getString("pass" + i, "");
            if (user.compareTo(cur_user) == 0 && pass.compareTo(cur_pass) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void putScan(Context context, String user, String name, int bright, int contr, int idx, int ids) {
        SharedPreferences prefs = context.getSharedPreferences("temir", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int n = prefs.getInt("scans_cnt", 0) + 1;
        editor.putString("user_scan" + n, user);
        editor.putString("name" + n, name);
        editor.putInt("bright" + n, bright);
        editor.putInt("contr" + n, contr);
        editor.putInt("idx" + n, idx);
        editor.putInt("ids" + n, ids);
        editor.putInt("scans_cnt", n);
        editor.commit();
        Toast.makeText(context, "Scan added!", Toast.LENGTH_SHORT).show();
        Log.d("temir", "User: " + user + ", " +
                "Name: " + name + ", " +
                "Brightness: " + bright + ", " +
                "Contrast: " + contr + ", " +
                "Extension: " + idx + ", " +
                "Scanner: " + ids);
    }

    public static ArrayList<String> getScans(Context context, String user) {
        SharedPreferences prefs = context.getSharedPreferences("temir", Context.MODE_PRIVATE);
        int n = prefs.getInt("scans_cnt", 0);
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            String user_scan = prefs.getString("user_scan" + i, "");
            String name = prefs.getString("name" + i, "");
            int bright = prefs.getInt("bright" + i, 0);
            int contr = prefs.getInt("contr" + i, 0);
            int idx = prefs.getInt("idx" + i, 0);
            int ids = prefs.getInt("ids" + i, 0);
            if (user_scan.compareTo(user) != 0) continue;
            res.add("Name: " + name + ", " +
                    "Brightness: " + bright + ", " +
                    "Contrast: " + contr + ", " +
                    "Extension: " + idx + ", " +
                    "Scanner: " + ids);
            Log.d("temir", "User: " + user + ", " +
                    "Name: " + name + ", " +
                    "Brightness: " + bright + ", " +
                    "Contrast: " + contr + ", " +
                    "Extension: " + idx + ", " +
                    "Scanner: " + ids);
        }
        return res;
    }

    public static void putPrint(Context context, String user, int bright, int contr, int ids) {
        SharedPreferences prefs = context.getSharedPreferences("temir", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int n = prefs.getInt("prints_cnt", 0) + 1;
        editor.putString("user_print" + n, user);
        editor.putInt("brightp" + n, bright);
        editor.putInt("contrp" + n, contr);
        editor.putInt("idsp" + n, ids);
        editor.putInt("prints_cnt", n);
        editor.commit();
        Toast.makeText(context, "Printed!", Toast.LENGTH_SHORT).show();
    }

    public static ArrayList<String> getPrints(Context context, String user) {
        SharedPreferences prefs = context.getSharedPreferences("temir", Context.MODE_PRIVATE);
        int n = prefs.getInt("prints_cnt", 0);
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            String user_print = prefs.getString("user_print" + i, "");
            String name = prefs.getString("namep" + i, "");
            int bright = prefs.getInt("brightp" + i, 0);
            int contr = prefs.getInt("contrp" + i, 0);
            int ids = prefs.getInt("idsp" + i, 0);
            if (user_print.compareTo(user) != 0) continue;
            res.add("Name: " + name + ", " +
                    "Pages: " + bright + ", " +
                    "Color: " + contr + ", " +
                    "Printer: " + ids);
        }
        return res;
    }
}
