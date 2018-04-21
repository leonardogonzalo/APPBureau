package com.appbureau.appbureau;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Util {
    Context context;

    public Util(Context context) {
        this.context = context;
    }

    public void IrActividad(Class clase)
    {
        Intent intent=new Intent(context,clase);
        context.startActivity(intent);


    }
    public void ShowMensaje(String mensaje)
    {
        Toast.makeText(context,mensaje, Toast.LENGTH_SHORT).show();
    }
}
