import java.util.ArrayList;
import java.util.List;

public class Team {
    List<Battler> battlers = new ArrayList<>();

    public Team(Battler battler) {
        battlers.add(battler);
    }

    public boolean isLoose() {
        for (Battler battler : battlers) {
            if (!battler.isDead()) {
                return false; // Au moins un combattant est encore en vie
            }
        }
        return true; // Tous les combattants sont morts
    }
}
