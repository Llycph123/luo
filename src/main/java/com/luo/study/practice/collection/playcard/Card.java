package com.luo.study.practice.collection.playcard;

import lombok.Builder;
import lombok.Data;

/**
 * @author luolingyan
 * @create 2025-02-20 10:46
 */
@Data
@Builder
public class Card implements Comparable<Card> {
    //花色
    private String designColor;
    //点数
    private String number;

    @Override
    public String toString() {
        return designColor+number;
    }

    @Override
    public int compareTo(Card o) {
        int result = this.getNumber().compareTo(o.getNumber());
        if(result == 0){
            return this.getDesignColor().compareTo(o.getDesignColor());
        }
        return result;
    }
}
