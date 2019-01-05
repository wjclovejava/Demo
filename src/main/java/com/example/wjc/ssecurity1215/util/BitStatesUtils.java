package com.example.wjc.ssecurity1215.util;

/**
 * @author ZhangZH 二进制状态类
 */
public class BitStatesUtils {

    /**
     * 同盾反欺诈
     */
    public static final long TONGDUN_ANTI_FRAUD = 1L;

    /**
     * 绑定银行卡
     */
    public static final long BIND_BANK_CARD = 1L << 1;

    /**
     * 身份信息
     */
    public static final long IDENTITY_INFORMATION = 1L << 2;

    /**
     * 基本信息
     */
    public static final long BASIC_INFORMATION = 1L << 3;

    /**
     * 手机验证
     */
    public static final long MOBILE_VERIFICATION = 1L << 4;

    /**
     * 芝麻平台是否授权
     */
    public static final long ZHIMA_AUTHORISE = 1L << 5;


    /**
     * @param states 所有状态值
     * @param value  需要判断状态值
     * @return 是否存在
     */
    public static boolean hasState(long states, long value) {
        return (states & value) != 0;
    }

    /**
     * @param states 已有状态值
     * @param value  需要添加状态值
     * @return 新的状态值
     */
    public static long addState(long states, long value) {
        if (hasState(states, value)) {
            return states;
        }
        return (states | value);
    }

    /**
     * @param states 已有状态值
     * @param value  需要删除状态值
     * @return 新的状态值
     */
    public static long removeState(long states, long value) {
        if (!hasState(states, value)) {
            return states;
        }
        return states ^ value;
    }
}