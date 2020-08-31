package com.example.list_avata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context mContext;
    private List<ContactModel> listContacts;
    private IOnChildItemClick iOnChildItemClick;

    public ContactAdapter(Context mContext, List<ContactModel> listContacts) {
        this.mContext = mContext;
        this.listContacts = listContacts;
    }

    public void unRegisterChildOnClick() {
        this.iOnChildItemClick = null;
    }

    public ContactAdapter(MainActivity mainActivity, List<ContactModel> listContacts) {
    }

    @Override
    public int getCount(){
        return listContacts.size();
    }
    @Override
    public  Object getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View rowView = convertView;
        if (rowView == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_contact,parent,false);
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView)rowView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView)rowView.findViewById(R.id.tvPhone);
            holder.ivAvata = (ImageView)rowView.findViewById(R.id.ivAvata);
            rowView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder)rowView.getTag();
        ContactModel model = listContacts.get(position);
        holder.tvName.setText(model.getName());
        holder.tvPhone.setText(model.getPhone());
        holder.ivAvata.setImageResource(model.getImage());
        return rowView;
    }

    public void registerChildItemClick(IOnChildItemClick iOnChildItemClick) {
        this.iOnChildItemClick = iOnChildItemClick;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvata;
    }
}
