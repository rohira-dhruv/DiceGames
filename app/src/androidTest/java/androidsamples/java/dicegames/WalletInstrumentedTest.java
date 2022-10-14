package androidsamples.java.dicegames;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.repeatedlyUntil;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.os.RemoteException;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class WalletInstrumentedTest {
  @Rule
  public ActivityScenarioRule<WalletActivity> activityRule = new ActivityScenarioRule<>(WalletActivity.class);

//  @Test
//  public void checkPersistenceOrientationCoins() throws RemoteException {
//    UiDevice device = UiDevice.getInstance(getInstrumentation());
//    onView(withId(R.id.txt_coins)).perform(clearText(), typeText("10"));
//    device.setOrientationLeft();
//    onView(withId(R.id.txt_coins)).check(matches(withText("10")));
//  }

  @Test
  public void total_roll_count_increment() {
    onView(withId(R.id.btn_die)).perform(click());
    onView(withId(R.id.txt_total_rolls)).check(matches(withText("1")));
  }


}