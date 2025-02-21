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

    //降序
    @Override
    public int compareTo(Card o) {
        int result = o.getNumber().compareTo(this.getNumber());
        if(result == 0){
            return o.getDesignColor().compareTo(this.getDesignColor());
        }
        return result;
    }
}
