package com.example.dell.myapplicationtarp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main0Activity extends AppCompatActivity {
    private static final String TAG = "ViewDatabase";
    DatabaseReference databaseReference;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;
    private  String userID;
     ListView mListView;
     String userId="";
ArrayAdapter<String> adapter;
String[] default_items = new String[]{"Name","Email","number"};
List<String> itemlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainzero);

        mListView = (ListView) findViewById(R.id.listview);
        itemlist = new ArrayList<>() ;
        databaseReference = FirebaseDatabase.getInstance().getReference("Patient");
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        //Toast.makeText(this, "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();
        userId = currentFirebaseUser.getUid();
        DatabaseReference datab = databaseReference.child(userId).child("Pres");
        DatabaseReference datab1 = datab.child("szcvcxvzx").child("Medicines");
        datab1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    System.out.println(dataSnapshot);
                    Medicines studentDetails = dataSnapshot.getValue(Medicines.class);

                    System.out.println("DATA" + studentDetails.getExpiry());
                    itemlist.add(studentDetails.getComponents());
                    itemlist.add(studentDetails.getExpiry());
                    itemlist.add(studentDetails.getMfg());
                    itemlist.add(studentDetails.getName());
                    itemlist.add(String.valueOf(studentDetails.getQty()));

                }

                adapter = new ArrayAdapter<String>(Main0Activity.this,android.R.layout.simple_list_item_activated_1,itemlist);
           mListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


                throw databaseError.toException();
            }
        });
    }


}


