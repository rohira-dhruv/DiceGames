package androidsamples.java.dicegames;

import android.util.Log;
import android.widget.inline.InlineContentView;

import androidx.lifecycle.ViewModel;

public class WalletViewModel extends ViewModel {

  private static final String TAG = "WalletViewModel";

  private static final int WIN_VALUE = 6;
  private static final int INCREMENT = 5;
  private static final int BONUS = 5;
  private static final int PENALTY = 5;

  private int mBalance;
  private Die mDie;
  private int lastRoll;
  private int singleSixes;
  private int doubleSixes;
  private int totalRolls;
  private int doubleOthers;

  /**
   * The no argument constructor.
   */
  public WalletViewModel() {
    // TODO implement method
    mBalance = 0;
    lastRoll = 0;
    singleSixes = 0;
    doubleOthers = 0;
    doubleSixes = 0;
    totalRolls = 0;
    mDie = new Die6();
  }

  /**
   * Reports the current balance.
   *
   */
  public int balance() {
    // TODO implement method
    return mBalance;
  }

  /**
   * Rolls the {@link Die} in the wallet and implements the changes accordingly.
   */
  public void rollDie() {
    // TODO implement method

    //die roll
    lastRoll = mDie.value();
    mDie.roll();
    totalRolls ++;
    Log.d(TAG, "Die roll = " + mDie.value());

    //double sixes
    if(mDie.value() == WIN_VALUE && lastRoll == WIN_VALUE) {
      doubleSixes ++;
      mBalance += INCREMENT + BONUS;
    }
    //single six
    else if(mDie.value() == WIN_VALUE){
      singleSixes ++;
      mBalance += INCREMENT;
    }
    //double other
    else if(mDie.value() ==  lastRoll){
      doubleOthers ++;
      mBalance -= PENALTY;
    }
    Log.d(TAG, "New Balance = " + mBalance);
  }

  /**
   * Reports the current value of the {@link Die}.
   *
   */
  public int dieValue() {
    // TODO implement method
    return mDie.value();
  }

  /**
   * Reports the number of single (or first) sixes rolled so far.
   *
   */
  public int singleSixes() {
    // TODO implement method
    return singleSixes;
  }

  /**
   * Reports the total number of dice rolls so far.
   *
   */
  public int totalRolls() {
    // TODO implement method
    return totalRolls;
  }

  /**
   * Reports the number of times two sixes were rolled in a row.
   *
   */
  public int doubleSixes() {
    // TODO implement method
    return doubleSixes;
  }

  /**
   * Reports the number of times any other number was rolled twice in a row.
   *
   */
  public int doubleOthers() {
    // TODO implement method
    return doubleOthers;
  }

  /**
   * Reports the value of the die on the previous roll.
   *
   */
  public int previousRoll() {
    // TODO implement method
    return lastRoll;
  }

  @Override
  protected void onCleared() {
    super.onCleared();
    Log.d(TAG, "onCleared");
  }
}
