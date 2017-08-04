package pdn.yingchiuluk.viewpagerexample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Stack1Fragment.ButtonClickCallback {

    MyFragmentPagerAdapter mMyFragmentPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyFragmentPagerAdapter =
                new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.setAdapter(mMyFragmentPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void goToNextFragment() {
        /**
         * use view pager to find Tab 1 fragment and invoke its goToStack2Fragment method
         */
        Tab1Fragment fragment = (Tab1Fragment) getSupportFragmentManager().findFragmentByTag(
                "android:switcher:" + mViewPager.getId() + ":" + mMyFragmentPagerAdapter.getItemId(0));

        if (fragment != null) {
            fragment.goToStack2Fragment();
        }
    }

    @Override
    public void onBackPressed() {

        Tab1Fragment fragment = (Tab1Fragment) getSupportFragmentManager().findFragmentByTag(
                "android:switcher:" + mViewPager.getId() + ":" + mMyFragmentPagerAdapter.getItemId(0));

        /**
         * check if it exist and isVisible (at the foreground with user interacting with it),
         *  even has other fragments on its container, it is still at the foreground
         *
         *  if its child fragment manager back stack still has items in it, pop the stack to show
         *  previous fragment instead of quitting the entire app, otherwise default back button
         *  pressed behavior is used
         */
        if (fragment != null && fragment.isVisible() &&
                fragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            fragment.getChildFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}
