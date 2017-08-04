package pdn.yingchiuluk.viewpagerexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1Fragment extends Fragment {

    public Tab1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);

        FragmentManager childFragmentManager = getChildFragmentManager();
        int backStackCounter = childFragmentManager.getBackStackEntryCount();

        /**
         * get child fragment manager back stack counter first
         */
        if (backStackCounter == 0) {
            /**
             * if it is zero, find if stack 1 fragment has already existed or not
             */
            Stack1Fragment stack1Fragment = (Stack1Fragment) childFragmentManager.findFragmentByTag("stack1");
            /**
             * if stack 1 fragment does not exist, create a new one
             * we don't need to do anything if it has already existed because Android OS will handle it
             */
            if (stack1Fragment == null) {
                stack1Fragment = new Stack1Fragment();
                /**
                 * not adding this transaction, so back button will NOT go back to the container
                 * in tab 1 fragment
                 */
                childFragmentManager.beginTransaction()
                        .replace(R.id.container, stack1Fragment, "stack1")
                        .commit();
            }
        }
        return v;
    }

    void goToStack2Fragment() {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.container, new Stack2Fragment(), "stack2")
                .addToBackStack("stack2")
                .commit();
    }

}
