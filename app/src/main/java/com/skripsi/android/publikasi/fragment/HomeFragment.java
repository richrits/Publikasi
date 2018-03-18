package com.skripsi.android.publikasi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.skripsi.android.publikasi.MainActivity;
import com.skripsi.android.publikasi.Publikasi;
import com.skripsi.android.publikasi.R;
import com.skripsi.android.publikasi.utils.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<Publikasi> publikasiList;
    private LinearLayoutManager HorizontalLayout;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        rootView.setTag(TAG);
        //Recycler view

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewList);


        publikasiList = new ArrayList<>();
        adapter = new RecyclerViewAdapter(getActivity(),publikasiList);
        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        //Add Item
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);
        recyclerView.setAdapter(adapter);

        preparePublikasi();

        return rootView;
    }

    private void preparePublikasi(){
        int covers = R.mipmap.cover_publikasi;

        Publikasi a = new Publikasi("Publikasi 1", covers);
        publikasiList.add(a);

        a = new Publikasi("Publikasi 2", covers);
        publikasiList.add(a);

        a = new Publikasi("Publikasi 3", covers);
        publikasiList.add(a);

        a = new Publikasi("Publikasi 4", covers);
        publikasiList.add(a);

        a = new Publikasi("Publikasi 5", covers);
        publikasiList.add(a);

        a = new Publikasi("Publikasi 6", covers);
        publikasiList.add(a);

        a = new Publikasi("Publikasi 7", covers);
        publikasiList.add(a);

        a = new Publikasi("Publikasi 8", covers);
        publikasiList.add(a);

        a = new Publikasi("Publikasi 9", covers);
        publikasiList.add(a);

        a = new Publikasi("Publikasi 10", covers);
        publikasiList.add(a);

        adapter.notifyDataSetChanged();


    }
}
