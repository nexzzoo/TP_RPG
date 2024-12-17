public class Game {
    Team playerTeam;
    Team enemyTeam;

    public Game(Team playerTeam, Team enemyTeam) {
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
    }

    public void play() {
        System.out.println("Début du combat !");
        while (!playerTeam.isLoose() && !enemyTeam.isLoose()) {
            Battler player = playerTeam.battlers.get(0);
            Battler enemy = enemyTeam.battlers.get(0);

            // Le joueur attaque en premier
            player.attack(enemy);
            if (enemy.isDead()) {
                System.out.println(enemy.name + " est vaincu !");
                break;
            }

            // L'ennemi attaque ensuite
            enemy.attack(player);
            if (player.isDead()) {
                System.out.println(player.name + " est vaincu !");
                break;
            }
        }

        // Afficher l'équipe gagnante
        Team winner = getWinnerTeam();
        if (winner == playerTeam) {
            System.out.println("L'équipe du joueur a gagné !");
        } else {
            System.out.println("L'équipe ennemie a gagné !");
        }
    }

    public Team getWinnerTeam() {
        return playerTeam.isLoose() ? enemyTeam : playerTeam;
    }
}
