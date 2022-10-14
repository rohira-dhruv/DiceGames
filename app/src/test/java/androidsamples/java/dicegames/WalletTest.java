package androidsamples.java.dicegames;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WalletTest {
  @Test
  public void increment_five_when_first_six(){
    Die6 die = mock(Die6.class);
    WalletViewModel wallet = spy(WalletViewModel.class);
    wallet.mDie = die;
    when(die.value()).thenReturn(6);
    wallet.rollDie();
    assertThat(wallet.balance(), is(5));
  }

  @Test
  public void increment_10_when_double_six(){
    Die6 die = mock(Die6.class);
    WalletViewModel wallet = spy(WalletViewModel.class);
    wallet.mDie = die;
    when(die.value()).thenReturn(6).thenReturn(6).thenReturn(5).thenReturn(6);
    for(int i=0; i<4; i++) {
      wallet.rollDie();
//      System.out.println(wallet.balance());
    }
    assertThat(wallet.balance(), is(20));
  }

  @Test
  public void check_balance_case1(){
    Die6 die = mock(Die6.class);
    WalletViewModel wallet = spy(WalletViewModel.class);
    wallet.mDie = die;
    when(die.value()).thenReturn(6).thenReturn(6).thenReturn(6).thenReturn(3).thenReturn(3).thenReturn(6)
            .thenReturn(1).thenReturn(6).thenReturn(6).thenReturn(5).thenReturn(4);
    for(int i=0; i<11; i++) {
      wallet.rollDie();
//      System.out.println(wallet.balance());
    }
    assertThat(wallet.balance(), is(40));
  }

  @Test
  public void check_balance_case2(){
    Die6 die = mock(Die6.class);
    WalletViewModel wallet = spy(WalletViewModel.class);
    wallet.mDie = die;
    when(die.value()).thenReturn(4).thenReturn(6).thenReturn(5).thenReturn(5).thenReturn(2).thenReturn(6)
            .thenReturn(5).thenReturn(2).thenReturn(6).thenReturn(1).thenReturn(1);
    for(int i=0; i<11; i++) {
      wallet.rollDie();
//      System.out.println(wallet.balance());
    }
    assertThat(wallet.balance(), is(5));
  }

  @Test
  public void check_balance_case3(){
    Die6 die = mock(Die6.class);
    WalletViewModel wallet = spy(WalletViewModel.class);
    wallet.mDie = die;
    when(die.value()).thenReturn(4).thenReturn(6).thenReturn(1).thenReturn(4).thenReturn(5).thenReturn(5)
            .thenReturn(2).thenReturn(3).thenReturn(3).thenReturn(5).thenReturn(5);
    for(int i=0; i<11; i++) {
      wallet.rollDie();
//      System.out.println(wallet.balance());
    }
    assertThat(wallet.balance(), is(-10));
  }

  @Test
  public void check_balance_case4(){
    Die6 die = mock(Die6.class);
    WalletViewModel wallet = spy(WalletViewModel.class);
    wallet.mDie = die;
    when(die.value()).thenReturn(6).thenReturn(6).thenReturn(6).thenReturn(6).thenReturn(6).thenReturn(1)
            .thenReturn(1).thenReturn(2).thenReturn(1).thenReturn(1).thenReturn(1);
    for(int i=0; i<11; i++) {
      wallet.rollDie();
//      System.out.println(wallet.balance());
    }
    assertThat(wallet.balance(), is(30));
  }

  @Test
  public void check_balance_case5(){
    Die6 die = mock(Die6.class);
    WalletViewModel wallet = spy(WalletViewModel.class);
    wallet.mDie = die;
    when(die.value()).thenReturn(1).thenReturn(1).thenReturn(1).thenReturn(5).thenReturn(5).thenReturn(2)
            .thenReturn(3).thenReturn(3).thenReturn(2).thenReturn(2).thenReturn(6);
    for(int i=0; i<11; i++) {
      wallet.rollDie();
//      System.out.println(wallet.balance());
    }
    assertThat(wallet.balance(), is(-20));
  }
}