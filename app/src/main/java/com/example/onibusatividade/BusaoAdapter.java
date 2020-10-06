package com.example.onibusatividade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BusaoAdapter extends ArrayAdapter<Busao> {

    int rId;

    public BusaoAdapter(@NonNull Context context, int resource, @NonNull List<Busao> objects) {
        super(context, resource, objects);
        rId = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View mView = convertView;

        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId, null);
        }

        Busao busao = getItem(position);

        TextView textMarca = mView.findViewById(R.id.textMarcaBusao);
        TextView textModelo = mView.findViewById(R.id.textModeloBusao);
        TextView textOrigemDestino = mView.findViewById(R.id.textOrigemDestinoBusao);
        TextView textTipo = mView.findViewById(R.id.textTipoBusao);
        TextView textAssentos = mView.findViewById(R.id.textAssentosBusao);


        textMarca.setText(busao.getMarca());
        textModelo.setText(busao.getModelo());
        textOrigemDestino.setText(busao.getOrigem_destino().toUpperCase());
        textTipo.setText(busao.getTipo());
        textAssentos.setText("Assentos: "+ busao.getAssentos_ocupados() + "/" + String.valueOf(busao.getAssentos()));

        if (busao.getAssentos_ocupados() >= busao.getAssentos()) {
            textOrigemDestino.setTextColor(getContext().getColor(R.color.assentos_cheios));
        } else {
            textOrigemDestino.setTextColor(getContext().getColor(R.color.assentos_ok));
        }

        return mView;
    }
}
