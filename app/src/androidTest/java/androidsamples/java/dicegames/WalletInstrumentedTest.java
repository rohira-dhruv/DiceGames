package androidsamples.java.dicegames;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static androidx.test.runner.lifecycle.Stage.RESUMED;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class WalletInstrumentedTest {
  @Rule
  public ActivityScenarioRule<WalletActivity> activityRule = new ActivityScenarioRule<>(WalletActivity.class);

  @Test
  public void total_roll_count_increment_on_click() {
    onView(withId(R.id.btn_die)).perform(click());
    onView(withId(R.id.txt_total_rolls)).check(matches(withText("1")));
  }

  public static Activity getCurrentActivity() {
    final Activity[] currentActivity = {null};
    getInstrumentation().runOnMainSync(new Runnable() {
      @Override
      public void run() {
        Collection resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
        if(resumedActivities.iterator().hasNext()){
          currentActivity[0] = (Activity)resumedActivities.iterator().next();
        }
      }
    });
    return currentActivity[0];
  }

  @Test
  public void total_roll_count_increment_on_click_2() {
    for(int i=0;i<2;i++)
      onView(withId(R.id.btn_die)).perform(click());
    onView(withId(R.id.txt_total_rolls)).check(matches(withText("2")));
  }

  @Test
  public void checkOrientationChange() {
    Activity mActivity = getCurrentActivity();
    mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    onView(withId(R.id.linearLayout)).check(matches(isCompletelyDisplayed()));
  }


  @Test
  public void checkOrientationPersistenceTotalRolls() {
    Activity mActivity = getCurrentActivity();
    for(int i=0; i<5; i++)
      onView(withId(R.id.btn_die)).perform(click());
    mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    onView(withId(R.id.txt_total_rolls)).check(matches(withText("5")));
  }

//  @Test
//  public void checkMultipleRotationPersistenceTotalRolls() {
//    Activity mActivity = getCurrentActivity();
//    for(int i=0; i<5; i++)
//      onView(withId(R.id.btn_die)).perform(click());
//    mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//    //to add delay between rotation and count increment.
//    for(int i=0;i<100000000;i++);
//
//    for(int j=0; j<5; j++)
//      onView(withId(R.id.btn_die)).perform(click());
//
//    mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//    onView(withId(R.id.txt_total_rolls)).check(matches(withText("10")));
//  }





}