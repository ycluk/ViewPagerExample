package pdn.yingchiuluk.viewpagerexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Stack1Fragment extends Fragment {
    interface ButtonClickCallback {
        void goToNextFragment();
    }

    ButtonClickCallback OnButtonClick;

    public Stack1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            OnButtonClick = (ButtonClickCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement ButtonClickCallback");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stack1, container, false);

        Button nextFragmentButton = (Button) v.findViewById(R.id.next_fragment_button);

        nextFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnButtonClick.goToNextFragment();
            }
        });

        return v;
    }

}
