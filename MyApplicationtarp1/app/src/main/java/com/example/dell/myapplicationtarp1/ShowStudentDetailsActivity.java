package com.example.dell.myapplicationtarp1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
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

public class ShowStudentDetailsActivity extends AppCompatActivity {
    public static final String Database_Path = "Student_Details_Database";

    DatabaseReference databaseReference;
    String userId ="";
    ProgressDialog progressDialog;
    private static String LOG_TAG = "CardViewActivity";
    List<StudentDetails> list = new ArrayList<>();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    RecyclerView recyclerView;
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
    RecyclerView.Adapter adapter ;
    private RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_details);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(ShowStudentDetailsActivity.this));

        progressDialog = new ProgressDialog(ShowStudentDetailsActivity.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();
        if (user!= null) {
            // User is signed in

        }
        else {
            // No user is signed in
        }
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        Toast.makeText(this, "" + currentFirebaseUser.getUid(), Toast.LENGTH_SHORT).show();
        userId = currentFirebaseUser.getUid();

        databaseReference = FirebaseDatabase.getInstance().getReference("Patient");
        DatabaseReference datab = databaseReference.child(userId).child("Pres");

        datab.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    StudentDetails studentDetails = dataSnapshot.getValue(StudentDetails.class);
                    studentDetails.setId(dataSnapshot.getKey());
                    list.add(studentDetails);
                   System.out.println("DATA" + studentDetails.getId());
                }
                adapter = new RecyclerViewAdapter(ShowStudentDetailsActivity.this, list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();
                throw databaseError.toException();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile) {

            return true;
        }

        else if (id == R.id.contactus) {

            return true;
        }
        else if (id == R.id.about) {
            Toast.makeText(getApplicationContext(), "This is simple Demo application with Action Bar", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
