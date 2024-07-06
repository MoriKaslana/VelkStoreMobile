package com.example.velkstore.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.velkstore.R;
import com.example.velkstore.adapters.ViewAllAdapter;
import com.example.velkstore.models.ViewAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    ViewAllAdapter viewAllAdapter;
    List<ViewAllModel> viewAllModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        firestore = FirebaseFirestore.getInstance();
        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.view_all_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewAllModelList = new ArrayList<>();
        viewAllAdapter = new ViewAllAdapter(this, viewAllModelList);
        recyclerView.setAdapter(viewAllAdapter);

        // Fetching data based on type (HSR)
        if (type != null && type.equalsIgnoreCase("HSR")) {
            firestore.collection("AllProducts")
                    .whereEqualTo("type", "HSR")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                                    ViewAllModel viewAllModel = documentSnapshot.toObject(ViewAllModel.class);
                                    if (viewAllModel != null) {
                                        viewAllModelList.add(viewAllModel);
                                    }
                                }
                                viewAllAdapter.notifyDataSetChanged();
                            } else {
                                // Log error
                                // Log.e(TAG, "Error getting documents: ", task.getException());
                            }
                        }
                    });
        } else {
            // Handle case where type is null or not "HSR"
        }
    }
}
