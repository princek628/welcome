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
public class fragment_dont extends Fragment {

    private RecyclerView recyclerview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_donts, container, false);

        recyclerview = (RecyclerView) view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> items = new ArrayList<String>();

        items.add("DO NOT take photos with your phone inside the office. Taking photos is strictly prohibited.");
        items.add("DO NOT be late for any session or presentation. Some leads are very strict and may not allow you to attend that session.");
        items.add("For guys who smoke, use the breaks and go to the proper area where smoking is allowed.");
        items.add("DO NOT use your phone frequently because many ILP centers don’t allow the usage of phones inside the office. If it is allowed in small amounts, make sure you maintain your phone etiquette by using the breaks to make a call,  moving to a corner and speaking in a low tone. Other than that, calling up your friend to come to class, sending an SMS in class, playing games and checking your Facebook  is totally allowed, provided that you don’t get caught! ");
        items.add("DO NOT chew gums and throw them here and there. It’ll be bad if you are caught chewing gums  If you really have to chew something, do it at your own risk! ");
        items.add("DO NOT take food items to office.");
        items.add("DO NOT waste your coffee breaks and big break. You get them after long hours. Freshen yourself up in these 15 or 30 minutes!");
        items.add("DO NOT wander off in the middle of lab sessions. If you need to drink water (coz guys don’t usually carry water) or wash your face (coz girls usually do that), ask your lead or let the person beside you know that. That way, if you are not in your seat, people will know that you didn’t ditch that session.");
        items.add("DO NOT dress improperly throughout the week.");
        items.add("DO NOT use offensive language, direct/indirect insults, swearing and criticism. It will be bad for your rating and people will give bad feedback about you and know you as someone having an attitude problem. If you’re heard by any lead or supervisor, it can cost you your job. So, keep it all outside the office! Discussing about how your lead is teaching JAVA is totally normal but, keep it low! You have feedback sessions for that!");
        items.add("DO NOT indulge in any destructive activities like breaking  and damaging things. That is the last thing TCS expects from you. Do not run about and behave like children. Remember, be in your very best behaviour, always!");

        RVAdapter adapter = new RVAdapter(items);
        recyclerview.setAdapter(adapter);

    }

}