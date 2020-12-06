package com.xyjawq.learn.algorithm.queue;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author: xyjawq
 * @date: 2020/12/5
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑倒最右边，窗口每次向右边滑一个位置。如果数组长度为n，窗口大小为w，则一共产生n-w+1个
 * 窗口的最大值。实现一个函数：
 * * 输入：整型数组arr，窗口大小为w
 * * 输出：一个长度为n-w+1的数组res，res[i] 表示每一种窗口状态下的最大值。
 * tips: 此种解法错误，请参考原著
 **/
public class WindowMaxValue {
    /**
     * 获取窗口滑动最大值
     * @param input 输入
     * @param winSize 窗口大小
     * @return 最大值数组
     */
    public static Integer[]  getMaxValue(Integer[] input, int winSize) {
        if (null == input || input.length == 0 || winSize == 0) {
            return new Integer[0];
        }
        Integer curMaxValue = input[0];
        Integer secMaxValue = Integer.MIN_VALUE;
        for (int i = 1; i < (winSize > input.length ? input.length : winSize); i++) {
            if (curMaxValue < input[i]) {
                secMaxValue = curMaxValue;
                curMaxValue = input[i];
            } else if (secMaxValue < input[i]) {
                secMaxValue = input[i];
            }
        }

        Integer[] res = new Integer[(input.length > winSize ? (input.length - winSize) : 0) + 1];
        res[0] = curMaxValue;
        // 窗口尺寸大于数组长度，直接取数组最大值
        if (winSize > input.length) {
            return res;
        }
        // 窗口每滑动一次，只需要比较当右边的值和最大值以及左边的值的比较
        for (int i = winSize; i < input.length; i++) {
            Integer out = input[i - winSize];
            Integer in = input[i];
            // 最大值若滑出，第二大值将成为最大
            if (out == curMaxValue) {
                curMaxValue = secMaxValue;
                secMaxValue = Integer.MIN_VALUE;
            }
            // 最大值小于滑入，最大值为滑入值, 第二大值成为原来最大值
            if (curMaxValue < in) {
                secMaxValue = curMaxValue;
                curMaxValue = in;
            } else if(secMaxValue < in) { // 第二大值也和输入值比较
               secMaxValue = in;
            }
            res[i-winSize+1] = curMaxValue;
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] input = {4,3,5,4,3,3,6,7};
        System.out.println(StringUtils.join(input,","));
        for (int i = 0; i < 10; i++) {
            System.out.println(StringUtils.join(WindowMaxValue.getMaxValue(input, i),","));
        }
    }
}
