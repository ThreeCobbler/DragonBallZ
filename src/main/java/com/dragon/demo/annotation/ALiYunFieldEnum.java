package com.dragon.demo.annotation;

/**
 * GoodsCodeType
 *
 * @ClassName: GoodsCodeType
 * @author: 00
 * @date: 2017/2/16
 */
public enum ALiYunFieldEnum {
    ID("id","LITERAL"),
    USERACCOUNT_ID("useraccount_id","INT"),
    TITLE("title","TEXT"),
    GOODS_TYPE("goods_type","INT"),
    PRICE("price","FLOAT"),
    DELIVERY_NUM("delivery_num","INT"),
    UNIT_NAME("unit_name","TEXT"),
    GAME_ID("game_id","LITERAL"),
    GAME_NAME("game_name","TEXT"),
    REGION_ID("region_id","LITERAL"),
    REGION_NAME("region_name","TEXT"),
    SERVER_ID("server_id","LITERAL"),
    SERVER_NAME("server_name","TEXT"),
    RACE_ID("race_id","LITERAL"),
    RACE_NAME("race_name","TEXT"),
    CREATE_TIME("create_time","INT"),
    LAST_UPDATE_TIME("last_update_time","INT"),
    IS_SMB("is_smb","LITERAL"),
    SERVICE_PRICE("service_price","FLOAT"),
    INSERT_TIME("insert_time","INT"),
    EQUIP_TYPE_NAME("equip_type_name","LITERAL"),
    WEAPON_TYPE_NAME("weapon_type_name","LITERAL"),
    OCCUPATION_NAME("occupation_name","LITERAL"),
    DAN_NAME("dan_name","LITERAL"),
    SERVICE_PROVIDER_ID("service_provider_id","LITERAL"),
    SERVICE_PROVIDER_NAME("service_provider_name","TEXT"),
    BASIC_TYPE("basic_type","INT"),
    BIZ_OFFER_FLAG("biz_offer_flag","TEXT"),
    DESCRIPTION("description","TEXT"),
    BULLY_DEPOSIT("bully_deposit","FLOAT"),
    LEVEL_COMBO_DAY("level_combo_day","INT"),
    COMPLETE_SPARRING_SESSIONS("complete_sparring_sessions","INT"),
    STATISTIC_COUNT("statistic_count","INT"),
    CURRENT_LEVEL_ID("current_level_id","INT"),
    TARGET_LEVEL_ID("target_level_id","INT"),
    LEVEL_NEEDSID("level_needsid","LITERAL"),
    IS_AXM("is_axm","LITERAL"),
    OTHER_NAME("other_name","TEXT"),
    ROLE_RANK("role_rank","INT"),
    HERO_NUM("hero_num","INT"),
    SKIN_NUM("skin_num","INT"),
    TOTAL_AMOUNT("total_amount","FLOAT"),
    RARE_SKIN("rare_skin","TEXT"),
    DEPOSIT("deposit","FLOAT"),
    BLANCENUM("blancenum","INT"),
    TRADE_COUNT("trade_count","INT"),
    NOT_BUY_STATUS("not_buy_status","INT"),
    TRADING_SERVICE_TYPE("trading_service_type","INT"),
    GOODS_SOURCE_TYPE("goods_source_type","INT"),
    PUBLISH_TYPE("publish_type","INT"),
    QUALIFIED("qualified","INT"),
    GAME_MONEY_QUANTITY("game_money_quantity","FLOAT"),
    PROPERTY_VALUES("property_values","TEXT"),
    TRADE_TYPE("trade_type","INT"),
    IS_JISHOU("is_jishou","LITERAL"),
    BROWSE_COUNT("browse_count","INT"),
    UNIT_NUM("unit_num","LITERAL"),
    GTR_BIND_MOBILE("gtr_bind_mobile","LITERAL"),
    GTR_SIX("gtr_six","INT"),
    LIST_GTR("list_gtr","LITERAL"),
    CREDIT_VALUE("credit_value","LITERAL"),
    SIGNS("signs","LITERAL"),
    SMALL_IMG_LIST("small_img_list","LITERAL"),
    BIG_IMG_LIST("big_img_list","LITERAL"),
    TRADE_MODE ("trade_mode","LITERAL"),
    TRADE_MODE_NAME ("trade_mode_name","LITERAL"),
    BIZ_OFFER_TYPE_NAME ("biz_offer_type_name","LITERAL"),
    BIZ_CATEGORY_NAME ("biz_category_name","LITERAL"),
    GTR_SEVEN ("gtr_seven","INT"),
    GTR_EIGHT ("gtr_eight","INT"),
    GTR_NINE ("gtr_nine","INT"),
    GTR_TEN ("gtr_ten","INT"),
    GTR_ELEVEN ("gtr_eleven","INT"),
    GTR_TWELVE ("gtr_twelve","INT"),
    GTR_THIRTEEN ("gtr_thirteen","INT"),
    GTR_FOURTEEN ("gtr_fourteen","INT"),
    GTR_FIFTEEN ("gtr_fifteen","INT"),
    GTR_SIXTEEN ("gtr_sixteen","LITERAL"),
    GTR_SEVENTEEN ("gtr_seventeen","LITERAL"),
    GTR_EIGHTEEN ("gtr_eighteen","LITERAL"),
    GTR_NINETEEN ("gtr_nineteen","LITERAL"),
    GTR_TWENTY ("gtr_twenty","LITERAL"),
    GTR_TWENTY_ONE ("gtr_twenty_one","LITERAL"),
    GTR_TWENTY_TWO ("gtr_twenty_two","LITERAL"),
    GTR_TWENTY_THREE ("gtr_twenty_three","LITERAL"),
    GTR_TWENTY_FOUR ("gtr_twenty_four","LITERAL"),
    GTR_TWENTY_FIVE ("gtr_twenty_five","LITERAL"),
    GTR_SIXTEEN_S ("gtr_sixteen_s","LITERAL"),
    GTR_SEVENTEEN_S ("gtr_seventeen_s","LITERAL"),
    GTR_EIGHTEEN_S ("gtr_eighteen_s","LITERAL"),
    GTR_NINETEEN_S ("gtr_nineteen_s","LITERAL"),
    GTR_TWENTY_S ("gtr_twenty_s","LITERAL"),
    GTR_TWENTY_ONE_S ("gtr_twenty_one_s","LITERAL"),
    GTR_TWENTY_TWO_S ("gtr_twenty_two_s","LITERAL"),
    GTR_TWENTY_THREE_S ("gtr_twenty_three_s","LITERAL"),
    GTR_TWENTY_FOUR_S ("gtr_twenty_four_s","LITERAL"),
    GTR_TWENTY_FIVE_S ("gtr_twenty_five_s","LITERAL"),
    IS_ROBOT_CAPTURE ("is_robot_capture","LITERAL"),
    GTR_ONE ("gtr_one","LITERAL"),
    GTR_TWO ("gtr_two","LITERAL"),
    GTR_THREE ("gtr_three","LITERAL"),
    GTR_FOUR ("gtr_four","LITERAL"),
    GTR_FIVE ("gtr_five","LITERAL"),
    IS_PROMOTION_SERVICE ("is_promotion_service","LITERAL"),
    UNIT_PROMISE_TIME_LOCKED ("unit_promise_time_locked","FLOAT"),
    UNIT_ADDITION ("unit_addition","LITERAL"),
    UNIT_PRICE ("unit_price","FLOAT"),
    START_TIME ("start_time","INT"),
    END_TIME ("end_time","INT"),
    GOODS_IMG ("goods_img","LITERAL"),
    SELLER_ID ("seller_id","LITERAL"),
    SELLER_STATUS ("seller_status","INT"),
    UPDATE_TIME ("update_time","INT"),
    SORT_SCORE ("sort_score","INT"),
    FILTER_PROPERTY("filter_property","TEXT");


    private String value;
    private String type;

    private ALiYunFieldEnum(String value, String type) {
        this.value = value;
        this.type = type;
    }

    /**
     * 根据value值获取对应的枚举
     * @param value
     * @return
     */
    public static ALiYunFieldEnum getTypeByValue(Object value){
        for(ALiYunFieldEnum type : ALiYunFieldEnum.values()){
            if(type.getValue().equals(value)){
                return type;
            }
        }

        throw new IllegalArgumentException("未能找到匹配的CouponType:" + value);
    }

    public String val() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
