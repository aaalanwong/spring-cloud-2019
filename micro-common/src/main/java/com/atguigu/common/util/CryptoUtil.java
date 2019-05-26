package com.atguigu.common.util;


public class CryptoUtil {

    public static final String DEFAULT_ENCODEING = "UTF-8";

    private static final Integer BYTE_LENGTH = 2;

    public static String byte2hex(byte [] b){
        StringBuilder sb = new StringBuilder();
        for (int n = 0; b != null && n < b.length; n++) {
            String str = Integer.toHexString(b[n] & 0XFF);
            if(str.length() == 1) {
                sb.append("0");
            }
            sb.append(str);
        }
        return sb.toString().toUpperCase();
    }

    public static byte [] hex2Byte(byte [] b){
        if(b.length % BYTE_LENGTH != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte [] b2 = new byte[b.length / BYTE_LENGTH];
        for (int n = 0; n < b.length; n += BYTE_LENGTH) {
            String item = new String(b, n, BYTE_LENGTH);
            b2[n / BYTE_LENGTH] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }
}
