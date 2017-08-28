package g4eis.ontern.g4project;

/**
 * Created by piyush on 27/8/17.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
public class fragment_dos extends Fragment {

    private RecyclerView recyclerview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dos, container, false);

        recyclerview = (RecyclerView) view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> items = new ArrayList<String>();

        items.add("Network within. Be it team or organization only network will help you there.");
        items.add("Build Knowledge. It takes you places.");
        items.add("Understand the organization and its structure.");
        items.add("Mingle with people from not just your project.");
        items.add("Utilize the diversity that TCS Offers");
        items.add("Enroll yourself in a lot of activities ( TCS Maitree)");
        items.add("Understand what can be done and what cannot.");
        items.add("Work so hard that there will be dependency on you in your project, that is how you earn respect.");
        items.add("Accept your mistake if any.");


        RVAdapter adapter = new RVAdapter(items);
        recyclerview.setAdapter(adapter);

    }

}