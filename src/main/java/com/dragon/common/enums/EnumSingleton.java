package com.dragon.common.enums;

/**
 * @author ljn
 * @date 2019/4/2.
 */
public enum EnumSingleton {

    A{
        @Override
        public String getType() {
            return "I will not tell you";
        }
    },

    B{
        @Override
        public String getType() {
            return "B";
        }
    },

    C{
        @Override
        public String getType() {
            return "C";
        }
    },

    D{
        @Override
        public String getType() {
            return "D";
        }
    };

    private  int value;

    private String type;

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }


}
