package com.example.velkstore.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.velkstore.R;
import com.example.velkstore.adapters.ItemsAdapters;
import com.example.velkstore.databinding.FragmentHomeBinding;
import com.example.velkstore.models.ItemsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    RecyclerView itemsRec;
    FirebaseFirestore db;
    ScrollView scrollView;
    ProgressBar progressBar;


    //Items
    List<ItemsModel> itemsModelList;
    ItemsAdapters itemsAdapters;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        db = FirebaseFirestore.getInstance();
        View root = binding.getRoot();

        itemsRec = root.findViewById(R.id.pop_rec);
        scrollView = root.findViewById(R.id.scroll_view);
        progressBar = root.findViewById(R.id.progressbar);

        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);

        //Items
        itemsRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        itemsModelList = new ArrayList<>();
        itemsAdapters = new ItemsAdapters(getActivity(),itemsModelList);
        itemsRec.setAdapter(itemsAdapters);

        db.collection("Items")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                ItemsModel itemsModel = document.toObject(ItemsModel.class);
                                itemsModelList.add(itemsModel);
                                itemsAdapters.notifyDataSetChanged();

                                progressBar.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);
                            }
                        } else {

                            Toast.makeText(getActivity(), "error: " + task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}