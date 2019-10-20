package generics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class MainGeneric {
    public static void main(String[] args) {
//        LeagueTable<FootballPlayer, Team<FootballPlayer>> footballLeague = new LeagueTable<>("AFL");
//        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
//        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
//        Team<FootballPlayer> hawthorn= new Team<>("Hawthorn");
//        Team<FootballPlayer> fremantle= new Team<>("Fremantle");
//        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
//
//        hawthorn.matchResult(fremantle, 1, 0);
//        hawthorn.matchResult(adelaideCrows, 3, 8);
//
//        adelaideCrows.matchResult(fremantle, 2, 1);
//
//        footballLeague.addTeam(adelaideCrows);
//        footballLeague.addTeam(melbourne);
//        footballLeague.addTeam(hawthorn);
//        footballLeague.addTeam(fremantle);
//
////        footballLeague.add(baseballTeam);
//        footballLeague.showLeagueTable();
//
//        BaseballPlayer pat = new BaseballPlayer("Pat");
//        SoccerPlayer beckham = new SoccerPlayer("Beckham");
//        Team rawTeam = new Team("Raw Team");
//        rawTeam.addPlayer(beckham); // unchecked warning
//        rawTeam.addPlayer(pat);     // unchecked warning
//
//        footballLeague.addTeam(rawTeam);     // unchecked warning
//
//        LeagueTable<FootballPlayer, Team<FootballPlayer>> rawLeague = new LeagueTable<>("Raw");
//        rawLeague.addTeam(adelaideCrows);     // no warning
////        rawLeague.addTeam(baseballTeam);    // no warning, baseballPlayer is not allowed here
//        rawLeague.addTeam(rawTeam);         // no warning
//
//        LeagueTable reallyRaw = new LeagueTable("Really raw");
//        reallyRaw.addTeam(adelaideCrows);     // unchecked warning
//        reallyRaw.addTeam(baseballTeam);    // unchecked warning
//        reallyRaw.addTeam(rawTeam);         // unchecked warning
//

        int solved1 = calculateBinaryGap(1041);
        int solved2 = calculateBinaryGap(32);
        int solved3 = calculateBinaryGap(9);
        System.out.println(" 1041 : " + solved1 + "\n 32 : " + solved2 + "\n 9 : " + solved3);
        System.out.println("141 : " + calculateBinaryGap(141));

        int[] array = {1, 3, 4, 55, 1, 4, 2, 56, 55, 3, 2, 7, 8};
        System.out.println(oddOccurencesInArray(array));
    }

    static Integer calculateBinaryGapWithStream(int n) {
        return Stream.of(
                Integer.toBinaryString(n)
                        .replaceAll("0+$", "")
                        .split("1+")
        )
                .filter(a -> a != null)
                .map(String::length)
                .max(Integer::compare)
                .orElse(0);
    }

    static Integer calculateBinaryGap(int N) {
        return calculateBinaryGap(N >>> Integer.numberOfTrailingZeros(N), 0, 0);
    }

    private static Integer calculateBinaryGap(int n, int max, int current) {
        if (n == 0) {
            return max;
        } else if ((n & 1) == 0) {
            return calculateBinaryGap(n >>> 1, max, current + 1);
        } else {
            return calculateBinaryGap(n >>> 1, Math.max(max, current), 0);
        }
    }

    static int oddOccurencesInArray(int[] input) {
        Set<Integer> unpairedNumbers = new HashSet<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (unpairedNumbers.contains(input[i])) {
                unpairedNumbers.remove(Integer.valueOf(input[i]));
            } else {
                unpairedNumbers.add(input[i]);
            }
        }
        Integer[] responce = new Integer[unpairedNumbers.size()];
        for (Integer number : unpairedNumbers) {
            System.out.println(number);
        }
        Iterator<Integer> itr = unpairedNumbers.iterator();
        return itr.next();
    }

}
