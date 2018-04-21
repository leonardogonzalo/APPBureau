package com.appbureau.appbureau.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.appbureau.appbureau.R;
import com.appbureau.appbureau.entidad.Mineria;

import java.util.List;

public class MineraAdapter extends RecyclerView.Adapter<MineraAdapter.MineraHolder> {

    List<Mineria> minerias;
    LayoutInflater inflater;
    private Activity activity;

    public interface OnClickEstado
    {
        void onclickEstado(int dato);
    }

    public OnClickEstado listener;

    public MineraAdapter(Activity context, List<Mineria> minerias) {
        this.activity = context;
        this.minerias = minerias;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public MineraHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.item_minera,parent,false);

        MineraHolder mineraHolder=new MineraHolder(view);

        return mineraHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MineraHolder holder, final int position) {



            holder.btestado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onclickEstado(position);
                }
            });

    }

    @Override
    public int getItemCount() {
        return minerias.size();
    }

    public Activity getActivity() {
        return activity;
    }
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        try{
            listener = (OnClickEstado)getActivity();

        }catch (ClassCastException e){
            throw new ClassCastException("La activity no implementar interfaces" + e.getMessage());
        }
    }

    public class MineraHolder extends RecyclerView.ViewHolder
    {
        TextView txtnombreminera,txtciudadminera,txtfecha,txtnormas;
        Button btestado;

        public MineraHolder(View itemView) {
            super(itemView);
            txtnombreminera=(TextView)itemView.findViewById(R.id.txtnombreminera);
            txtciudadminera=(TextView)itemView.findViewById(R.id.txtciudadminera);
            txtfecha=(TextView)itemView.findViewById(R.id.txtfecha);
            txtnormas=(TextView)itemView.findViewById(R.id.txtnormas);
            btestado=(Button)itemView.findViewById(R.id.btestado);

        }
    }
}
