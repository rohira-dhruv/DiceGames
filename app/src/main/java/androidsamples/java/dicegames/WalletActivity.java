package androidsamples.java.dicegames;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class WalletActivity extends AppCompatActivity {

  private static final String TAG = "WalletActivity";


  private TextView mTxtBalance;
  private Button mBtnRoll;
  private TextView mPrevRoll;
  private TextView mSingleSixes;
  private TextView mTotalRolls;
  private TextView mDoubleSixes;
  private TextView mDoubleOthers;
  private WalletViewModel mWalletVM;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    Log.d(TAG, "onCreate");
    setContentView(R.layout.activity_wallet);

    mTxtBalance = findViewById(R.id.txt_balance);
    mBtnRoll = findViewById(R.id.btn_roll);
    mPrevRoll = findViewById(R.id.txt_prev_roll_value);
    mSingleSixes = findViewById(R.id.txt_sixes_rolled_value);
    mTotalRolls = findViewById(R.id.txt_total_rolls_value);
    mDoubleOthers = findViewById(R.id.txt_double_others_value);
    mDoubleSixes = findViewById(R.id.txt_double_sixes_value);

    mWalletVM = new ViewModelProvider(this).get(WalletViewModel.class);

    updateUI();


    //Persistent data using Bundle
//    if(savedInstanceState != null){
//      mBalance = savedInstanceState.getInt(KEY_BALANCE,0);
//      int dieValue =  savedInstanceState.getInt(KEY_DIE_VALUE, 0);
//      mTxtBalance.setText(Integer.toString(mBalance));
//      mBtnRoll.setText(Integer.toString(dieValue));
//      Log.d(TAG, "Restored: Balance = "+mBalance+", die = " + dieValue);
//    }

    mBtnRoll.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mWalletVM.rollDie();
        if(mWalletVM.inc){
          Toast.makeText(WalletActivity.this, "Congratulations!", Toast.LENGTH_SHORT).show();
        }
        updateUI();
      }
    });

  }

  private void updateUI() {
    mTxtBalance.setText(Integer.toString(mWalletVM.balance()));
    mBtnRoll.setText(Integer.toString(mWalletVM.dieValue()));
    mPrevRoll.setText(Integer.toString(mWalletVM.previousRoll()));
    mSingleSixes.setText(Integer.toString(mWalletVM.singleSixes()));
    mTotalRolls.setText(Integer.toString(mWalletVM.totalRolls()));
    mDoubleSixes.setText(Integer.toString(mWalletVM.doubleSixes()));
    mDoubleOthers.setText(Integer.toString(mWalletVM.doubleOthers()));
  }

//  @Override
//  protected void onSaveInstanceState(@NonNull Bundle outState){
//    super.onSaveInstanceState(outState);
//    Log.d(TAG, "onSaveInstanceState");
//    outState.putInt(KEY_BALANCE, mBalance);
//    outState.putInt(KEY_DIE_VALUE, mDie.value());
//    Log.d(TAG, "Savcd: Balance = " + mBalance + ", die = " + mDie.value());
//  }


}