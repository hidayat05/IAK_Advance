package com.maskipli.iak.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.maskipli.iak.R;
import com.maskipli.iak.models.beans.Source;
import com.maskipli.iak.presenters.main.MainPresenter;

import java.util.List;

/**
 * @author nurhidayat
 * @since 5/22/17.
 */

public class GridAdapter extends BaseAdapter {
    private Context context;
    private MainPresenter mainPresenter;
    private List<Source.Sources> listSource;

    public GridAdapter(Context context, MainPresenter presenter, List<Source.Sources> sources) {
        this.context = context;
        this.listSource = sources;
        this.mainPresenter = presenter;
    }

    @Override
    public int getCount() {
        return listSource.size();
    }

    @Override
    public Object getItem(int position) {
        return listSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Source.Sources data = listSource.get(position);
        View gridView;
        if (convertView == null) {
            gridView = inflater.inflate(R.layout.layout_grid_item, null);
        } else {
            gridView = convertView;
        }
        ((TextView) gridView.findViewById(R.id.tv_menu)).setText(data.name);
        gridView.findViewById(R.id.ll_grid_item).setOnClickListener
                (v -> mainPresenter.setOnGridClicked(listSource.get(position).id,
                        listSource.get(position).name));
        return gridView;
    }
}
