package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    private String team;
    private String score;
    private TextView teamName;
    private ImageButton plusButton;
    private ImageButton minusButton;
    private TextView scoreView;

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score,container,false);
        if(getArguments() != null){
            team = getArguments().getString("teamName");
        }

        teamName = (TextView) view.findViewById(R.id.tvTeamName);
        teamName.setText(team);

        scoreView = (TextView) view.findViewById(R.id.textView2);

        plusButton = (ImageButton) view.findViewById(R.id.btnPlus);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = String.valueOf(scoreView.getText());
                int scorePlus = Integer.parseInt(score)+1;
                scoreView.setText(scorePlus+"");
            }
        });

        minusButton = (ImageButton) view.findViewById(R.id.btnMinus);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = String.valueOf(scoreView.getText());
                int scoreMinus = Integer.parseInt(score)-1;
                scoreView.setText(scoreMinus+"");
            }
        });

        return view;
    }

    public static ScoreFragment newInstance(String teamName) {

        Bundle args = new Bundle();
        args.putString("teamName",teamName);
        ScoreFragment fragment = new ScoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}