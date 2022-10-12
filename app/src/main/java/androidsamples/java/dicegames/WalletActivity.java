package androidsamples.java.dicegames;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class WalletActivity extends AppCompatActivity {

  private static final String TAG = "WalletActivity";


  private TextView mTxtBalance;
  private Button mBtnRoll;
  private WalletViewModel mWalletVM;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    Log.d(TAG, "onCreate");
    setContentView(R.layout.activity_wallet);

    mTxtBalance = findViewById(R.id.txt_balance);
    mBtnRoll = findViewById(R.id.btn_roll);

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
        updateUI();
      }
    });

  }

  private void updateUI() {
    mTxtBalance.setText(Integer.toString(mWalletVM.balance()));
    mBtnRoll.setText(Integer.toString(mWalletVM.dieValue()));
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