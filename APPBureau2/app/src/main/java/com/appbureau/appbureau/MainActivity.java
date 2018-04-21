package com.appbureau.appbureau;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.appbureau.appbureau.adapter.MineraAdapter;
import com.appbureau.appbureau.entidad.Mineria;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,MineraAdapter.OnClickEstado {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Context context;
    Toolbar toolbar;
    Util util;
    RecyclerView recyclerView;
    private ArrayList<Mineria> minerias=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,new FragmentContent())
                .commit();
        navigationView=(NavigationView)findViewById(R.id.navigation_view);

        if(navigationView!=null)
        {
            navigationView.setNavigationItemSelectedListener(this);
        }

    }

    public void UpdateView()
    {

        context=getApplicationContext();
        util=new Util(context);


        toolbar=(Toolbar)findViewById(R.id.toolbarmain);
        setSupportActionBar(toolbar);
        util.ShowMensaje("ingreso");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        if(recyclerView!=null)
        {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int iditem=item.getItemId();

        Fragment fragment=null;

        switch (iditem)
        {
            case R.id.nv_inicio:
                toolbar.setSubtitle("Inicio");

                fragment=new FragmentInicio();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,fragment)
                        .commit();
                toolbar=(Toolbar)findViewById(R.id.toolbarmain);
                setSupportActionBar(toolbar);

                break;
            case R.id.nv_convocatoria:
                toolbar.setSubtitle("Convocatoría");

                Mineria mineria=new Mineria();
                mineria.setNombre("Minera 2");
                mineria.setCiudad("Arequipa");
                mineria.setFechas("Fecha:1888888");
                mineria.setNormas("nodmmdd");


                minerias.add(mineria);

                MineraAdapter mineraAdapter=new MineraAdapter(this,minerias);
                recyclerView.setAdapter(mineraAdapter);

                break;
            case R.id.nv_auditoria:
                toolbar.setSubtitle("Auditoría");
                break;
            case R.id.nv_cerrar:
                util.IrActividad(Login.class);
                break;
        }


        drawerLayout.closeDrawer(Gravity.START);
        return true;
    }


    @Override
    public void onclickEstado(int dato) {

        Button btcancelar,btcambioestado;
        try
        {
            toolbar.setSubtitle("Detalle convocatoria");
            final AlertDialog.Builder builder=new AlertDialog.Builder(this);
            View view= getLayoutInflater().inflate(R.layout.activity_detalle_convocatoria,null);

            btcancelar=(Button)view.findViewById(R.id.btcancelar);
            btcambioestado=(Button)view.findViewById(R.id.btcambioestado);

           final AlertDialog dialog=builder.create();

            btcancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            btcambioestado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OpcionParticipar();
                }
            });

            builder.setView(view);




            builder.show();

        }
        catch (Exception ex)
        {
            util.ShowMensaje("Error: "+ex.getMessage());
        }

    }


    public void OpcionParticipar()
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Participar en Convocatoria");
        dialog.setMessage("Estas seguro de aceptar la convocatoria,al participar nos comunicaremos a la brevedad para validar los datos");
        dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.create();
        dialog.show();


    }
    public void OpcionCancelar()
    {}

}
