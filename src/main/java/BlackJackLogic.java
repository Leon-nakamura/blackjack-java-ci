package com.example;

import java.util.*;

public class BlackJackLogic {

    // カードデッキの生成とシャッフル
    public static List<String> createDeck() {
        String[] suits = {"H", "C", "D", "S"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        List<String> deck = new ArrayList<>();
        for (String suit : suits) {
            for (String number : numbers) {
                deck.add(suit + number);
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    // 点数計算（Aの柔軟計算含む）
    public static int calculateScore(List<String> hand) {
        int score = 0;
        int aceCount = 0;

        for (String card : hand) {
            String numberStr = card.substring(1);
            if (numberStr.equals("J") || numberStr.equals("Q") || numberStr.equals("K")) {
                score += 10;
            } else if (numberStr.equals("A")) {
                score += 11;
                aceCount++;
            } else {
                score += Integer.parseInt(numberStr);
            }
        }

        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }
        return score;
    }

    // CPU vs CPU（1試合自動実行）
    public static String playAutomatedGame() {
        List<String> deck = createDeck();
        List<String> playerHand = new ArrayList<>();
        List<String> dealerHand = new ArrayList<>();

        playerHand.add(deck.remove(0));
        playerHand.add(deck.remove(0));
        dealerHand.add(deck.remove(0));
        dealerHand.add(deck.remove(0));

        // 簡易CPU戦略: 17未満ならヒットし続ける
        while (calculateScore(playerHand) < 17) {
            playerHand.add(deck.remove(0));
        }

        int playerScore = calculateScore(playerHand);
        if (playerScore > 21) return "LOSE"; // プレイヤーバースト

        // ディーラーの行動: 17未満ならヒット
        while (calculateScore(dealerHand) < 17) {
            dealerHand.add(deck.remove(0));
        }

        int dealerScore = calculateScore(dealerHand);
        if (dealerScore > 21) return "WIN"; // ディーラーバースト

        if (playerScore > dealerScore) return "WIN";
        else if (playerScore < dealerScore) return "LOSE";
        else return "DRAW";
    }
}
