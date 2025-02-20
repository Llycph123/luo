package com.luo.study.practice.collection.playcard;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author luolingyan
 * @create 2025-02-20 10:46
 */
@Data
@Builder
public class Player {
    private int id;
    private String name;
    private List<Card> cards;
}

