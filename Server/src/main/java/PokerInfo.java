import java.io.Serializable;
import java.util.ArrayList;

public class PokerInfo implements Serializable {
   Player p1;
   Player p2;
   Dealer dealer;

    PokerInfo(Player p1, Player p2, Dealer dealer) {
        this.p1 = p1;
        this.p2 = p2;
        this.dealer = dealer;
    }

}
