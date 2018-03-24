package com.skripsi.android.publikasi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private RecyclerView recyclerViewListPub;
    private RecyclerView recyclerViewRekomendasiPub;
    private RecyclerViewAdapter adapter;
    private List<Publikasi> publikasiList;
    private List<Publikasi> publikasiRekomendasi;
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
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        rootView.setTag(TAG);
        recyclerViewListPub = (RecyclerView) rootView.findViewById(R.id.recyclerViewList);
        recyclerViewRekomendasiPub = (RecyclerView) rootView.findViewById((R.id.recyclerViewRcmd));


        //Recycler view
        recyclerViewListPublikasi();
        recyclerViewRekomendasiPublikasi();



        preparePublikasi();

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_settings).setVisible(false);
        menu.findItem(R.id.action_logout).setVisible(false);
    }

    private void recyclerViewListPublikasi(){
        //Adapter
        publikasiList = new ArrayList<>();
        adapter = new RecyclerViewAdapter(getActivity(),publikasiList);
        recyclerViewListPub.setLayoutManager(RecyclerViewLayoutManager);

        //Add Item
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewListPub.setLayoutManager(HorizontalLayout);
        recyclerViewListPub.setAdapter(adapter);
    }

    private void recyclerViewRekomendasiPublikasi(){
        //untuk sementara

        publikasiRekomendasi = new ArrayList<>();
        adapter = new RecyclerViewAdapter(getActivity(),publikasiRekomendasi);
        recyclerViewRekomendasiPub.setLayoutManager(RecyclerViewLayoutManager);

        //Add Item
        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewRekomendasiPub.setLayoutManager(HorizontalLayout);
        recyclerViewRekomendasiPub.setAdapter(adapter);


    }


    private void preparePublikasi(){
        int covers = R.mipmap.cover_publikasi;

        Publikasi a = new Publikasi("Publikasi1", covers, "no katalog 1", "no publikasi 1", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        a = new Publikasi("Publikasi2", covers,"no katalog 2", "no publikasi 2", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        a = new Publikasi("Publikasi3", covers,"no katalog 3", "no publikasi 3", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        a = new Publikasi("Publikasi4", covers,"no katalog 4", "no publikasi 4", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        a = new Publikasi("Publikasi5", covers,"no katalog 5", "no publikasi 5", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        a = new Publikasi("Publikasi6", covers,"no katalog 6", "no publikasi 6", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        a = new Publikasi("Publikasi7", covers,"no katalog 7", "no publikasi 7", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        a = new Publikasi("Publikasi8", covers,"no katalog 8", "no publikasi 8", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        a = new Publikasi("Publikasi9", covers,"no katalog 9", "no publikasi 9", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        a = new Publikasi("Publikasi10", covers,"no katalog 10", "no publikasi 10", "12-12-2012","x MB");
        publikasiList.add(a);
        publikasiRekomendasi.add(a);

        adapter.notifyDataSetChanged();


    }
}
