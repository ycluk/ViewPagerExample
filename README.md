# ViewPagerExample
ViewPager with TabLayout with nested fragments


This example shows how to handle back button press for nested fragment in ViewPager.

There is a container fragment that use child fragment manager to show other fragments in the container (FrameLayout) and put the transaction on the back stack.

MainActivity extends AppCompatActivity and tabs use TabLayout.

MainActiviy onBackPress method is overriden. It checks if the container fragment is visible to the user and whether child fragment manager back stack has items in it. If there are items in the back stack, it will pop a fragment off the back stack instead of quitting the app.
