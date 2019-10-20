package generics;

import java.util.ArrayList;
import java.util.Collections;

public class LeagueTable<P extends Player, T extends Team> {
    private String name;

    private ArrayList<T> teams = new ArrayList<T>();

    public LeagueTable(String name) {
        this.name = name;
    }

    public ArrayList<T> getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        while (teams.contains(team)) {
            System.out.println("League table already contains " + team.getName());
            return false;
        }
        teams.add(team);
        System.out.println(team.getName() + " has been added to the league table");
        return true;
    }

    public void showLeagueTable() {
        Collections.sort(teams);
        for (T team : teams) {
            System.out.println(team.getName() + ": " + team.ranking());
        }
    }

}
