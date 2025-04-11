package due.giuaky221121514222.day2;
import android.Manifest;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;



import java.util.List;

import due.giuaky221121514222.R;

public class ContactAdapter extends BaseAdapter {
    private Context mContext;
    private List<ContactModel> listContact;
    private IOnChildItemClick iOnChildItemClick;
    private boolean hideButtons;
    public ContactAdapter(Context mContext, List<ContactModel> listContact, boolean hideButtons){
        this.mContext = mContext;
        this.listContact = listContact;
        this.hideButtons=hideButtons;
    }
    public void registerChildItemClick(IOnChildItemClick iOnChildItemClick){
        this.iOnChildItemClick = iOnChildItemClick;
    }
    public void unRegisterChildItemClick(){
        this.iOnChildItemClick=null;
    }
    @Override
    public int getCount(){
        return listContact.size();
    }
    @Override
    public Object getItem(int i){
        return null;
    }
    @Override
    public long getItemId (int i){
        return 0;
    }
    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup){
        View rowView = convertView;
        if (rowView==null){
            LayoutInflater inflater=((Activity)mContext).getLayoutInflater();
            rowView = inflater.inflate(R.layout.day2_item_contact, null);
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) rowView.findViewById(R.id.tvName);
            holder.tvPhone=(TextView) rowView.findViewById(R.id.tvPhone);
            holder.ivAvatar =(ImageView) rowView.findViewById(R.id.ivUser);
            holder.btCall = (ImageButton) rowView.findViewById(R.id.btCall);
            holder.btEdit=(ImageButton) rowView.findViewById(R.id.btEdit);
            rowView.setTag(holder);

        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.tvName.setText(listContact.get(i).getName());
        holder.tvPhone.setText(listContact.get(i).getPhone());
        holder.ivAvatar.setImageResource(listContact.get(i).getImage());
        if(hideButtons) {
            holder.btCall.setVisibility(View.GONE);
            holder.btEdit.setVisibility(View.GONE);
        }else{

            holder.btCall.setVisibility(View.VISIBLE);
            holder.btEdit.setVisibility(View.VISIBLE);

        }

        holder.btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                onCall(i);
            }
        });

        holder.btEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                iOnChildItemClick.onItemChildClick(i);

            }
        });
        return rowView;



    }
    private void onCall(int position) {
        ContactModel contact = listContact.get(position);
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact.getPhone()));
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        mContext.startActivity(intent);
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
        ImageButton btCall;
        ImageButton btEdit;
    }


}
