package m.srinivas.campstar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class OneFragment extends Fragment {
    RecyclerView group_recyler;
    ArrayList<Groups> groups;
    public OneFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        groups = new ArrayList<Groups>();
        groups.add(new Groups("dadi"));
        groups.add(new Groups("dadi"));
        groups.add(new Groups("dadi"));
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_one, container, false);
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.group_recyler);


// 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // this is data fro recycler view


        // 3. create an adapter
        Group_Adapter mAdapter = new Group_Adapter(OneFragment.this,groups,R.layout.group_single);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;

    }
}
