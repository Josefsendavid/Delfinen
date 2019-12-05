
import model.Medlem;
import org.junit.Test;
import static org.junit.Assert.*;

public class KontingentTest {

    @Test
    public void kontingentBetaling() {
        //Arrange
        Medlem medlem = new Medlem(150197, "Mathias", 22, "Senior", "Motionist", true);
        //Act        
        int betaling = 0;
        int under18 = 1000;
        int over18 = 1600;
        int passivtMedlemsskab = 500;
        int over60 = (over18 / 100) * 75;
        int expected = 1600;

        if (medlem.getAlder() < 18 && medlem.isAktivtmedlemsskab() == true) {
            betaling = under18;
        } else if (medlem.getAlder() >= 18 && medlem.getAlder() < 60 && medlem.isAktivtmedlemsskab() == true) {
            betaling = over18;
        } else if (medlem.getAlder() >= 60 && medlem.isAktivtmedlemsskab() == true) {
            betaling = over60;
        } else if (medlem.isAktivtmedlemsskab() == false) {
            betaling = passivtMedlemsskab;
        }
        //Assert
        assertEquals(expected, betaling);
    }
}
