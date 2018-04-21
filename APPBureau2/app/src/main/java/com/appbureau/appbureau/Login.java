package com.appbureau.appbureau;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        util=new Util(getApplicationContext());
    }

    public void Ingresar(View view)
    {
        try
        {
            if(ValidarIngreso())
            {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else
            {
                util.ShowMensaje("No esta autorizado");
            }

        }
        catch (Exception ex)
        {
            util.ShowMensaje("Error: "+ex.getMessage());
        }

    }

    public Boolean ValidarIngreso()
    {
        return true;
    }
}
