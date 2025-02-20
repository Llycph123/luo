package com.luo.study.practice.collection.playcard;

import lombok.Data;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author luolingyan
 * @create 2025-02-20 10:36
 * 扑克牌游戏
 * 1、创建一副扑克牌
 * 包括四种花色：黑桃、红桃、梅花、方片
 * 十三点数：2-10、J、Q、K、A，不考虑大小王
 * 2、创建两名玩家
 * 玩家至少要有ID、姓名、手牌等属性，手牌为扑克牌的集合
 * 3、洗牌
 * 将之前创建的“一副扑克牌”打乱顺序
 * 4、发票
 * 将洗牌之后的扑克牌集合，从第一张开始，发给两名玩家，按照一人一张的方式，每人发两张
 * 5、游戏
 * 比较两名玩家手中的扑克牌，规则为：取两人各自手中点数最大的牌进行比较，点数大的赢；
 * 若两人各自的点数最大的牌相等，则再按花色比较
 */
@Data
public class Game {
    //花色
    public static final String[] DESIGN_COLORS = new String[]{"黑桃","红桃","梅花","方片"};
    //点数
    public static final String[] CARD_NUMBERS = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    //总牌数
    public static final int TOTAL_CARD_NUM = 52;
    //玩家数量
    public static final int PLAYER_NUM = 2;
    //每个玩家的牌数
    public static final int PLAYER_CARD_NUM = 2;

    //卡牌
    private static final List<Card> PLAY_CARDS = new ArrayList<>(TOTAL_CARD_NUM);

    //玩家
    private static List<Player> players = new ArrayList<>(PLAYER_NUM);

    public static void main(String[] args) {
        //创建卡牌
        generateCard();
        //洗牌
        suffleCards();
        //添加玩家
        addPlayer(PLAYER_NUM);
        //欢迎玩家
        hello();
        //发牌
        dealCards(PLAYER_NUM, PLAYER_CARD_NUM);
        //开始游戏
        startGame();
    }

    public static void startGame() {
        System.out.println("---------------开始游戏---------------");
        System.out.println("---------------玩家各自的手牌为---------------");
        for(Player player:players){
            System.out.println(String.format("%s:%s", player.getName(),player.getCards()));
        }
        System.out.println("玩家比分前"+players);
        Collections.sort(players, new PlayerComparator());
        System.out.println("玩家比分后"+players);
        System.out.println(String.format("---------------玩家%s获胜！---------------", players.get(PLAYER_NUM - 1)));
    }

    /**
     * 创建卡牌
     * @return
     */
    public static void generateCard(){
        PLAY_CARDS.clear();
        for(int i = 0; i < DESIGN_COLORS.length; i++){
            System.out.println("---------------创建花色为"+ DESIGN_COLORS[i] + "的卡牌---------------");
            Set<Card> cards = new HashSet<>();
            for(int j = 0; j < CARD_NUMBERS.length; j++){
                Card card = Card.builder()
                        .designColor(DESIGN_COLORS[i])
                        .number(CARD_NUMBERS[j])
                        .build();
                cards.add(card);
            }
            System.out.println(cards);
            System.out.println("---------------花色为"+ DESIGN_COLORS[i] + "的卡牌创建成功---------------" + "\n");
            PLAY_CARDS.addAll(cards);
        }
    }

    /**
     * 洗牌
     */
    public static void suffleCards(){
        Set<Card> cards = new HashSet<>();
        System.out.println("---------------开始洗牌---------------");
        System.out.println("---------------洗牌前---------------");
        System.out.println(PLAY_CARDS);
        System.out.println("---------------洗牌后---------------");
        while (cards.size() < TOTAL_CARD_NUM){
            int index = ThreadLocalRandom.current().nextInt(0, TOTAL_CARD_NUM);
            cards.add(PLAY_CARDS.get(index));
        }
        PLAY_CARDS.clear();
        PLAY_CARDS.addAll(cards);
        System.out.println(PLAY_CARDS);
        System.out.println("---------------洗牌结束！---------------");

    }

    /**
     * 创建玩家
     * @param num 玩家数量
     */
    public static void addPlayer(int num){
        players.clear();
        Scanner scanner = new Scanner(System.in);
        for(int i = 1; i <= num; i++){
            System.out.println(String.format("请输入第%d位玩家的ID和姓名：", i));
            System.out.println("输入ID：");
            int id = scanner.nextInt();
            System.out.println("输入姓名：");
            String name = scanner.next();
            Player player = Player.builder()
                            .id(id)
                            .name(name)
                            .cards(new ArrayList<>())
                            .build();
            players.add(player);
        }
    }

    /**
     * 欢迎玩家
     */
    public static void hello(){
        for(Player player:players){
            System.out.println(String.format("欢迎玩家%s！", player.getName()));
        }
    }

    /**
     * 发牌数量
     * @param playNum 玩家数量
     * @param cardNum 每个玩家的牌数
     */
    public static void dealCards(int playNum, int cardNum){
        System.out.println("---------------开始发牌---------------");
        //要发的牌数
        int totalNum = playNum * cardNum;
        for(int i = 0; i < totalNum; i++){
            int playerNo = i % playNum;//第几个玩家拿牌
            Player player = players.get(playerNo);
            player.getCards().add(PLAY_CARDS.get(i));
            System.out.println(String.format("---------------玩家%s拿牌", player.getName()));
        }
        System.out.println("---------------发牌结束---------------");
    }

}
