package com.example.list_avata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick  {
    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mAdapter = new ContactAdapter(this,listContacts);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContacts.get(i);
                Toast.makeText(MainActivity.this,model.getName() + ": " + model.getPhone(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        lvContact = (ListView)findViewById(R.id.lvContact);
        ivUser = (ImageView)findViewById(R.id.ivUser);
        tvName = (TextView)findViewById(R.id.tvName);

    }
    private void initData(){
        ContactModel contact = new ContactModel("Nguyen Tien Duoc","012345789",R.drawable.ic_u1);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van Minh","01263716237",R.drawable.ic_u2);
        listContacts.add(contact);
        contact = new ContactModel("Luong Minh Trang","01263716237",R.drawable.ic_u3);
        listContacts.add(contact);
        contact = new ContactModel("Pham Duc Cong","01263716237",R.drawable.ic_u4);
        listContacts.add(contact);
        contact = new ContactModel("Pham Viet Ha","01263716237",R.drawable.ic_u5);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Phuong Linh","01263716237",R.drawable.ic_u1);
        listContacts.add(contact);
        contact = new ContactModel("Doan Duc Trong","01263716237",R.drawable.ic_u2);
        listContacts.add(contact);
        contact = new ContactModel("Luong Quang Phong","01263716237",R.drawable.ic_u3);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Hai Phong","01263716237",R.drawable.ic_u4);
        listContacts.add(contact);
        contact = new ContactModel("Minh Van Phuoc","01263716237",R.drawable.ic_u5);
        listContacts.add(contact);

    }

    public void registerChildItemClick(int position){
        ContactModel contact = listContacts.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.unRegisterChildOnClick();
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel contact = listContacts.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }
}
