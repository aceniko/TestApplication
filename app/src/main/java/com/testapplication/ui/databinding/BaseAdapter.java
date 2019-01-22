package com.testapplication.ui.databinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.testapplication.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BaseAdapter<T> extends RecyclerView.Adapter<DataBindingHolder> {

    protected final static int VIEW_TYPE_LOADER = -3;
    protected final static int VIEW_TYPE_HEADER = -2;
    protected final static int VIEW_TYPE_ITEM = -1;

    private Context context;
    private int resource;
    private List<T> list;
    private boolean loading;

    public BaseAdapter(@NonNull Context context, int resource, @NonNull List<T> objects) {
        this.context = context;
        this.resource = resource;
        this.list = objects;
    }

    public BaseAdapter(@NonNull Context context){
        super();
        this.context = context;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        if(loading) {
            if(!this.isLoading())
                this.list.add(null);
        }
        else
            this.list.remove(null);
        this.loading = loading;
        notifyDataSetChanged();
    }

    @Override
    public DataBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding=null;
        switch (viewType){
            case VIEW_TYPE_LOADER:
                binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_progress, parent, false);
                break;
            case VIEW_TYPE_HEADER:

                break;
            case VIEW_TYPE_ITEM:
                binding = DataBindingUtil.inflate(layoutInflater, resource, parent, false);
                break;
        }
        // set the view's size, margins, paddings and layout parameters
        return new DataBindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(DataBindingHolder holder, int position) {
        final T item = list.get(position);
        holder.bind(item, new DataBindingUtils(context));
    }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        if(loading && position==getItemCount()-1)
            return VIEW_TYPE_LOADER;
        else
            return VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return list == null? 0 : list.size();
    }

    public void add(T item){
        list.add(item);
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<T> items){
        list.addAll(items);
        notifyDataSetChanged();
    }

    public void removeAllItems(){
        this.list = new ArrayList<>();
    }

}
