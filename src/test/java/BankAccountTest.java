import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0);
    }

    @Test
    @DisplayName("Test 1: Hesap doğru bakiye ile başlatılmalı")
    void testInitialBalance() {
        assertEquals(100.0, account.getBalance(), "Başlangıç bakiyesi hatalı.");
    }

    @Test
    @DisplayName("Test 2: Para yatırma işlemi bakiyeyi artırmalı")
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Yatırma işlemi sonrası bakiye hatalı.");
    }

    @Test
    @DisplayName("Test 3: Para çekme işlemi bakiyeyi azaltmalı")
    void testWithdraw() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "Çekme işlemi sonrası bakiye hatalı.");
    }

    @Test
    @DisplayName("Test 4: Yetersiz bakiyede Exception fırlatılmalı")
    void testWithdrawInsufficientFunds() {
  
        Exception exception = assertThrows(RuntimeException.class, () -> {
            account.withdraw(200.0);
        });

        assertEquals("Yetersiz bakiye.", exception.getMessage());
    }

    @Test
    @DisplayName("Test 5: Negatif tutar yatırılmaya çalışıldığında hata vermeli")
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
    }

    @Test
    @DisplayName("Test 6: Negatif tutar çekilmeye çalışıldığında hata vermeli")
    void testWithdrawNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-20.0);
        });
    }

    @Test
    @DisplayName("Test 7: Yatırma ve çekme işlemleri ardışık yapıldığında bakiye doğru kalmalı")
    void testDepositAndWithdrawChained() {
        account.deposit(50.0);  // Bakiye: 150
        account.withdraw(30.0); // Bakiye: 120
        account.deposit(10.0);  // Bakiye: 130
        
        assertEquals(130.0, account.getBalance());
    }
}
