package com.luo.study.practice.collection.playcard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author luolingyan
 * @create 2025-02-20 13:30
 */
public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        List<Card> cards1 = o1.getCards();
        List<Card> cards2 = o2.getCards();
        Collections.sort(cards1);
        Collections.sort(cards2);
        Card maxCard1 = cards1.get(0);
        Card maxCard2 = cards2.get(0);
        System.out.println(String.format("玩家%s的最大点数牌为：%s", o1.getName(), maxCard1.getDesignColor()+maxCard1.getNumber()));
        System.out.println(String.format("玩家%s的最大点数牌为：%s", o2.getName(), maxCard2.getDesignColor()+maxCard2.getNumber()));
        return maxCard1.compareTo(maxCard2);
    }
}
