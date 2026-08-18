package com.example;

public class BlackJackSimulation {
    public static void main(String[] args) {
        int totalGames = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Simulation Started: " + totalGames + " games ===");

        for (int i = 0; i < totalGames; i++) {
            String result = BlackJackLogic.playAutomatedGame();
            if ("WIN".equals(result)) wins++;
            else if ("LOSE".equals(result)) losses++;
            else draws++;
        }

        double winRate = (double) wins / totalGames * 100;
        System.out.printf("Results: Total=%d | Wins=%d (%.2f%%) | Losses=%d | Draws=%d%n",
                totalGames, wins, winRate, losses, draws);
    }
}
