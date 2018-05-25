package com.dragon.demo.annotation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 商品
 *
 * @ClassName: GoodsEO
 * @author: wangjj
 * @date: 2016/5/18
 */
public class GoodsEO  {
    /**
     * 商品单号
     */
    @AliYunField(ALiYunFieldEnum.ID)
    private String goodsId;

    /**
     * 卖家帐号
     */
    @AliYunField(ALiYunFieldEnum.USERACCOUNT_ID)
    private Long useraccountId;

    /**
     * 卖家帐号名
     */
    private String sellerAccount;

    /**
     * 标题
     */
    @AliYunField(ALiYunFieldEnum.TITLE)
    private String title;

    /**
     * 商品图片
     */
    @AliYunField(ALiYunFieldEnum.GOODS_IMG)
    private String goodsImg;

    /**
     * 商品类型
     * 1:装备 2：帐号 3：金币
     */
    @AliYunField(value = ALiYunFieldEnum.GOODS_TYPE, gt = "0")
    private int goodsType;

    /**
     * 单价
     */
    @AliYunField(value = ALiYunFieldEnum.PRICE, gt = "0")
    private BigDecimal price;

    /**
     * 发布件数
     */
//    @AliYunField(ALiYunFieldEnum.DELIVERY_NUM)
    private int deliveryNum;

    /**
     * 单位
     */
    @AliYunField(ALiYunFieldEnum.UNIT_NAME)
    private String unitName;

    /**
     * 剩余件数
     */
    @AliYunField(value = ALiYunFieldEnum.DELIVERY_NUM, gt = "0")
    private int blanceNum;

    /**
     * 每件数量
     */
    @AliYunField(value = ALiYunFieldEnum.UNIT_NUM, gt = "0")
    private BigInteger unitNum;

    /**
     * 保证金
     */
    private BigDecimal bond;

    /**
     * 游戏ID
     */
    @AliYunField(ALiYunFieldEnum.GAME_ID)
    private String gameId;

    /**
     * 游戏区ID
     */
    @AliYunField(ALiYunFieldEnum.REGION_ID)
    private String regionId;

    /**
     * 游戏服ID
     */
    @AliYunField(ALiYunFieldEnum.SERVER_ID)
    private String serverId;

    /**
     * 阵营ID
     */
    @AliYunField(ALiYunFieldEnum.RACE_ID)
    private String raceId;

    /**
     * 游戏名称
     */
    @AliYunField(ALiYunFieldEnum.GAME_NAME)
    private String gameName;

    /**
     * 游戏区名称
     */
    @AliYunField(ALiYunFieldEnum.REGION_NAME)
    private String regionName;

    /**
     * 游戏服名称
     */
    @AliYunField(ALiYunFieldEnum.SERVER_NAME)
    private String serverName;

    /**
     * 阵营名称
     */
    @AliYunField(ALiYunFieldEnum.RACE_NAME)
    private String raceName;

    /**
     * 是否上架
     */
    private Boolean isOnline;

    /**
     * 描述
     */
    @AliYunField(value = ALiYunFieldEnum.DESCRIPTION)
    private String description;

    /**
     * 创建时间
     */
    @AliYunField(value = ALiYunFieldEnum.CREATE_TIME,methodName = "getTime")
    private Date createTime;

    /**
     * 修改时间
     */
    @AliYunField(value = ALiYunFieldEnum.LAST_UPDATE_TIME, methodName = "getTime")
    private Date lastUpdateTime;

    /**
     * 失效时间
     */
    private Date invalidTime;

    /**
     * 是否速卖宝
     */
    @AliYunField(value = ALiYunFieldEnum.IS_SMB, invokeName = "changeBooleanToString")
    private Boolean isSmb;

    /**
     * 游戏帐号
     */
    private String gameAccount;

    /**
     * 角色
     */
    private String gameRoleName;

    /**
     * 游戏帐号密码
     */
    private String gamePwd;

    /**
     * 二级密码
     */
    private String gamePwd2;

    /**
     * 服务费百分比
     */
    @AliYunField(value = ALiYunFieldEnum.SERVICE_PRICE, gt = "0")
    private BigDecimal servicePrice;

    /**
     * 手机号
     */
    private String tel;

    /**
     * QQ
     */
    private String qq;

    /**
     * WEIXIN
     */
    private String weixin;

    /**
     * 要求
     */
    private String requirement;

    /**
     * 审核员
     */
    private String auditor;

    /**
     * 审核时间
     */
    private Date auditorCreateTime;

    /**
     * 审核状态
     */
    private Integer auditorStatus;

    /**
     * 卖家身份证正面
     */
    private String idcardImgFront;

    /**
     * 卖家身份证反面
     */
    private String idcardImgBack;

    /**
     * 金币栏位排序
     */
    private Integer sort;

    /**
     * 是否金币栏位
     */
    private Boolean isGoldRow;

    /**
     * 查多个商品类型
     */
    private String goodsTypeStr;

    /**
     * 是否身份证认证
     */
    private Boolean isIdentityVerified;

    /**
     * 是否愿意视频沟通
     */
    private Boolean isAllowVedio;

    /**
     * 卖家真实姓名
     */
    private String sellerName;

    /**
     * 卖家已删除
     */
    private Boolean isSellerDeleted;

    /**
     * 是否已失效
     */
    private Boolean isInvalid;

    /**
     * 游戏区服
     */
    private String gameProp;

    /**
     * 总金额
     */
    @AliYunField(ALiYunFieldEnum.TOTAL_AMOUNT)
    private BigDecimal totalAmount;

    /**
     * 卖方类型(1:普通卖家;2:商城内部卖家)
     */
    private Integer sellerType;

    /**
     * 审核原因
     */
    private int auditorReason;

    /**
     * 其他原因
     */
    private String auditorOtherReason;

    /**
     * 排位
     */
    private Integer place;

    /**
     * 暗号
     */
    private String secretWord;

    /**
     * 别名
     */
    @AliYunField(ALiYunFieldEnum.OTHER_NAME)
    private String otherName;

    /**
     * 装备类型名称
     */
    @AliYunField(ALiYunFieldEnum.EQUIP_TYPE_NAME)
    private String equipTypeName;

    /**
     * 武器类型名称
     */
    @AliYunField(ALiYunFieldEnum.WEAPON_TYPE_NAME)
    private String weaponTypeName;

    /**
     * 支付状态
     */
    private int payStatus;

    /**
     * 押金
     */
    @AliYunField(value = ALiYunFieldEnum.DEPOSIT)
    private BigDecimal deposit;

    /**
     * 支付方式
     */
    private int payType;

    /**
     * 机器人截图时间
     */
    private Date captureImgTime;

    /**
     * 是否自动截图
     */
    @AliYunField(ALiYunFieldEnum.IS_ROBOT_CAPTURE)
    private boolean isRobotCapture;

    /**
     * 帐号发布流程状态
     */
    private int accountFlowState;

    /**
     * 角色职业
     */
    @AliYunField(ALiYunFieldEnum.OCCUPATION_NAME)
    private String occupationName;

    /**
     * 角色段位
     */
    @AliYunField(ALiYunFieldEnum.DAN_NAME)
    private String danName;

    /**
     * 是否重新立即推送截图
     */
    private Boolean isRecapture;

    /**
     * 游戏类型
     * 1：网游 2：手游
     */
    private Integer gameType;

    /**
     * 运营商id
     */
    @AliYunField(ALiYunFieldEnum.SERVICE_PROVIDER_ID)
    private String serviceProviderId;

    /**
     * 运营商名称
     */
    @AliYunField(ALiYunFieldEnum.SERVICE_PROVIDER_NAME)
    private String serviceProviderName;

    /**
     * 商品来源
     */
    private String goodsSource;

    /**
     * 是否安心买
     */
    @AliYunField(ALiYunFieldEnum.IS_AXM)
    private Boolean isAxm;

    @AliYunField(ALiYunFieldEnum.INSERT_TIME)
    private Long insertTime;

    /**
     * 安心买保费
     */
    private BigDecimal insurance;

    /**
     * 结算卖家id
     */
    private Long signSellerAccountId;

    /**
     * 结算卖家手机号
     */
    private String signSellerAccountName;

    /**
     * 帐号收费费用
     */
    private BigDecimal commission;

    /**
     * 角色段位
     */
    private String roleDivision;
    /**
     * 角色等级
     */
    @AliYunField(value = ALiYunFieldEnum.ROLE_RANK, gt = "0")
    private Integer roleRank;
    /**
     * 英雄个数
     */
    @AliYunField(value =ALiYunFieldEnum.HERO_NUM, gt = "0")
    private Integer heroNum;
    /**
     * 皮肤个数
     */
    @AliYunField(value = ALiYunFieldEnum.SKIN_NUM, gt = "0")
    private Integer skinNum;
    /**
     * 稀有皮肤
     */
    @AliYunField(ALiYunFieldEnum.RARE_SKIN)
    private String rareSkin;
    /**
     * 时间
     */
    private String sellHour;

    /**
     * 参考价
     */
    private Integer advicePrice;

    /**
     * 当日可发数量
     */
    private BigInteger todaySellNum;

    // sunjianlin 2017.2.16添加

    /**
     * M站交易类型
     * 1.装备 2.帐号 3.游戏币 4.通货
     */
    @AliYunField(value =ALiYunFieldEnum.TRADE_TYPE, gt = "0")
    private Integer tradeType;

    /**
     * 是否寄售
     */
    @AliYunField(ALiYunFieldEnum.IS_JISHOU)
    private Boolean isJishou;

    /**
     * 物品存放处
     */
    private String goodsLocation;

    //region  主站商品字段添加

    /**
     * 商品属性 集合
     */
    @AliYunField(value = ALiYunFieldEnum.PROPERTY_VALUES)
    private String propertyValues;
    /**
     * 等级值
     */
    private String creditValue;
    /**
     * 保障服务类型+说明集合
     */
    private String signs;
    /**
     * 用户名
     */
    private String useraccountName;
    /**
     * 商品是否可以购买
     */
    private Integer notBuyStatus;
    /**
     * 小图集合
     */
    @AliYunField(value =ALiYunFieldEnum.SMALL_IMG_LIST)
    private String smallImgList;

    /**
     * 大图集合
     *
     * @return
     */
    @AliYunField(value =ALiYunFieldEnum.BIG_IMG_LIST)
    private String bigImgList;
    /**
     * 帐号增值服务列表
     */
    private String incrementItems;
    /**
     * 帐号交易次数
     */
    private Integer tradeCount;
    /**
     * 帐号安全等级
     */
    private String qualifyType;
    /**
     * 交易类型
     */
    @AliYunField(ALiYunFieldEnum.TRADING_SERVICE_TYPE)
    private Integer tradingServiceType;
    /**
     * 交易方式
     */
    private Integer tradeMode;
    /**
     * 交易方式名称
     */
    private String tradeModeName;
    /**
     * 商品来源类型
     * 1、主站
     */
    @AliYunField(value = ALiYunFieldEnum.GOODS_SOURCE_TYPE)
    private Integer goodsSourceType;

    /**
     * 劫金包赔
     */

    private Boolean isDamagesMoney;

    /**
     * 是否清理过截图
     */
    private Boolean isCleanImg;

    /**
     * 自动下架,是否从阿里云删除过
     */
    private Boolean DeleteAliyun;

    /**
     * 新平台id(主站)
     */
    private String newPlatformId;

    /**
     * 新区id(主站)
     */
    private String newRegionId;

    /**
     * 新服id(主站)
     */
    private String newServerId;

    /**
     * 新平台(主站)
     */
    private String newPlatformName;

    /**
     * 新区(主站)
     */
    private String newRegionName;

    /**
     * 新服(主站)
     */
    private String newServerName;

    /**
     * 是否已经替换类目
     */
    private Boolean isReplace;

    /**
     * 是否增加主站类目
     */
    private Boolean isAddMainCategory;

    /**
     * 帐号商品审核失败时存放标题
     */
    private String propertyValuesTitle;

    /**
     * 主站商品类型
     */
    private Integer mainGoodsType;

    /**
     * 主站商品状态
     */
    private Integer mainGoodsStatus;

    /**
     * 新的游戏区服
     */
    private String newGameProp;

    /**
     * MW_C_ZH_00033_商品打通_20170603 dongjianwei
     * 动态属性筛选
     */
    @AliYunField(value = ALiYunFieldEnum.FILTER_PROPERTY)
    private String filterProperty;

    /**
     * MW_C_ZH_00033_商品打通_20170606 dongjianwei
     * 主站游戏ID
     */
    private String mainGid;

    /**
     * 推广
     * 客服后台页面，帐号管理表单中添加一列“推广”
     */
    private String pushAddress;

    /**
     * 手游商品排序值 MW_N_SY_00089 dongjianwei
     */
    @AliYunField(ALiYunFieldEnum.SORT_SCORE)
    private Integer sortScore;

    //region 固定属性新增liudq 2017/09/01
    private String webPwd;              //网站密码
    private String realName;            //真实姓名
    private String idcardCode;          //身份证号码
    private String securityQuestion1;    //密保问题1
    private String secretAnswer1;       //密保答案1
    private String securityQuestion2;   //密保问题2
    private String secretAnswer2;       //密保答案2
    private String securityQuestion3;   //密保问题3
    private String secretAnswer3;       //密保答案3
    private String bindMobile;          //绑定手机
    private String safetyCode;          //安全码
    private String superPwd;            //超级密码
    private String mailbox;             //邮箱
    private String mailboxPwd;          //邮箱密码
    private String mailboxOwnPwd;       //邮箱独立密码
    private String mailboxSquestion;    //邮箱密保问题
    private String mailboxSanswer;      //邮箱密保答案
    private String warehousePwd;        //仓库密码

    public String getWebPwd() {
        return webPwd;
    }

    public void setWebPwd(String webPwd) {
        this.webPwd = webPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdcardCode() {
        return idcardCode;
    }

    public void setIdcardCode(String idcardCode) {
        this.idcardCode = idcardCode;
    }

    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecretAnswer1() {
        return secretAnswer1;
    }

    public void setSecretAnswer1(String secretAnswer1) {
        this.secretAnswer1 = secretAnswer1;
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public String getSecretAnswer2() {
        return secretAnswer2;
    }

    public void setSecretAnswer2(String secretAnswer2) {
        this.secretAnswer2 = secretAnswer2;
    }

    public String getSecurityQuestion3() {
        return securityQuestion3;
    }

    public void setSecurityQuestion3(String securityQuestion3) {
        this.securityQuestion3 = securityQuestion3;
    }

    public String getSecretAnswer3() {
        return secretAnswer3;
    }

    public void setSecretAnswer3(String secretAnswer3) {
        this.secretAnswer3 = secretAnswer3;
    }

    public String getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile;
    }

    public String getSafetyCode() {
        return safetyCode;
    }

    public void setSafetyCode(String safetyCode) {
        this.safetyCode = safetyCode;
    }

    public String getSuperPwd() {
        return superPwd;
    }

    public void setSuperPwd(String superPwd) {
        this.superPwd = superPwd;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getMailboxPwd() {
        return mailboxPwd;
    }

    public void setMailboxPwd(String mailboxPwd) {
        this.mailboxPwd = mailboxPwd;
    }

    public String getMailboxOwnPwd() {
        return mailboxOwnPwd;
    }

    public void setMailboxOwnPwd(String mailboxOwnPwd) {
        this.mailboxOwnPwd = mailboxOwnPwd;
    }

    public String getMailboxSquestion() {
        return mailboxSquestion;
    }

    public void setMailboxSquestion(String mailboxSquestion) {
        this.mailboxSquestion = mailboxSquestion;
    }

    public String getMailboxSanswer() {
        return mailboxSanswer;
    }

    public void setMailboxSanswer(String mailboxSanswer) {
        this.mailboxSanswer = mailboxSanswer;
    }

    public String getWarehousePwd() {
        return warehousePwd;
    }

    public void setWarehousePwd(String warehousePwd) {
        this.warehousePwd = warehousePwd;
    }

    //endregion

    /**
     * MW_N_SY_00095 liudq  用户自定义区服
     */
    private String supplyServerName;

    public String getSupplyServerName() {
        return supplyServerName;
    }

    public void setSupplyServerName(String supplyServerName) {
        this.supplyServerName = supplyServerName;
    }

    /**
     * 新增 云验号标志 fuyanting 20170714
     * 云验号标志
     * @return
     */

    private Boolean isCloudAccount;

    public Boolean getIsCloudAccount() {
        return isCloudAccount;
    }

    public void setIsCloudAccount(Boolean isCloudAccount) {
        this.isCloudAccount = isCloudAccount;
    }

    public String getPushAddress(){
        return pushAddress;
    }

    public void setPushAddress(String pushAddress){
        this.pushAddress = pushAddress;
    }

    public Boolean getIsCleanImg() {
        return isCleanImg;
    }

    public void setIsCleanImg(Boolean isCleanImg) {
        this.isCleanImg = isCleanImg;
    }

    public Integer getGoodsSourceType() {
        return goodsSourceType;
    }

    public void setGoodsSourceType(Integer goodsSourceType) {
        this.goodsSourceType = goodsSourceType;
    }

    public String getTradeModeName() {
        return tradeModeName;
    }

    public void setTradeModeName(String tradeModeName) {
        this.tradeModeName = tradeModeName;
    }

    public Integer getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(Integer tradeMode) {
        this.tradeMode = tradeMode;
    }

    public Integer getTradingServiceType() {
        return tradingServiceType;
    }

    public void setTradingServiceType(Integer tradingServiceType) {
        this.tradingServiceType = tradingServiceType;
    }

    public String getQualifyType() {
        return qualifyType;
    }

    public void setQualifyType(String qualifyType) {
        this.qualifyType = qualifyType;
    }

    public Integer getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    public String getIncrementItems() {
        return incrementItems;
    }

    public void setIncrementItems(String incrementItems) {
        this.incrementItems = incrementItems;
    }

    public String getBigImgList() {
        return bigImgList;
    }

    public void setBigImgList(String bigImgList) {
        this.bigImgList = bigImgList;
    }

    public String getSmallImgList() {
        return smallImgList;
    }

    public void setSmallImgList(String smallImgList) {
        this.smallImgList = smallImgList;
    }

    public Integer getNotBuyStatus() {
        return notBuyStatus;
    }

    public void setNotBuyStatus(Integer notBuyStatus) {
        this.notBuyStatus = notBuyStatus;
    }

    public String getUseraccountName() {
        return useraccountName;
    }

    public void setUseraccountName(String useraccountName) {
        this.useraccountName = useraccountName;
    }

    public String getSigns() {
        return signs;
    }

    public void setSigns(String signs) {
        this.signs = signs;
    }

    public String getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(String creditValue) {
        this.creditValue = creditValue;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public Boolean getIsJishou() {
        return isJishou;
    }

    public void setIsJishou(Boolean isJishou) {
        this.isJishou = isJishou;
    }

    public String getGoodsLocation() {
        return goodsLocation;
    }

    public void setGoodsLocation(String goodsLocation) {
        this.goodsLocation = goodsLocation;
    }

    public String getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(String propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Boolean getDeleteAliyun() {
        return DeleteAliyun;
    }

    public void setDeleteAliyun(Boolean deleteAliyun) {
        DeleteAliyun = deleteAliyun;
    }

//endregion
    /**
     * 短信验证码
     */
    private String validationCode;

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    //    //每个属性的参考价
    /*
    * 短信验证开关
    * */
    private Boolean messageOpen;

    /*
    * 发货时间
    * */
    private Date sendTime;
//    //每个属性的参考价
//    private Integer roleDivisionPrice;
//    private Integer roleRankPrice;
//    private Integer heroNumPrice;
//    private Integer skinNumPrice;
//    private Integer rareSkinPrice;
//    private Integer sellHourPrice;

//    public Integer getRoleDivisionPrice() {
//        return roleDivisionPrice;
//    }
//
//    public void setRoleDivisionPrice(Integer roleDivisionPrice) {
//        this.roleDivisionPrice = roleDivisionPrice;
//    }
//
//    public Integer getRoleRankPrice() {
//        return roleRankPrice;
//    }
//
//    public void setRoleRankPrice(Integer roleRankPrice) {
//        this.roleRankPrice = roleRankPrice;
//    }
//
//    public Integer getHeroNumPrice() {
//        return heroNumPrice;
//    }
//
//    public void setHeroNumPrice(Integer heroNumPrice) {
//        this.heroNumPrice = heroNumPrice;
//    }
//
//    public Integer getSkinNumPrice() {
//        return skinNumPrice;
//    }
//
//    public void setSkinNumPrice(Integer skinNumPrice) {
//        this.skinNumPrice = skinNumPrice;
//    }
//
//    public Integer getRareSkinPrice() {
//        return rareSkinPrice;
//    }
//
//    public void setRareSkinPrice(Integer rareSkinPrice) {
//        this.rareSkinPrice = rareSkinPrice;
//    }
//
//    public Integer getSellHourPrice() {
//        return sellHourPrice;
//    }
//
//    public void setSellHourPrice(Integer sellHourPrice) {
//        this.sellHourPrice = sellHourPrice;
//    }

    public Integer getAdvicePrice() {
        return advicePrice;
    }

    public void setAdvicePrice(Integer advicePrice) {
        this.advicePrice = advicePrice;
    }

    public String getRoleDivision() {
        return roleDivision;
    }

    public void setRoleDivision(String roleDivision) {
        this.roleDivision = roleDivision;
    }

    public Integer getRoleRank() {
        return roleRank;
    }

    public void setRoleRank(Integer roleRank) {
        this.roleRank = roleRank;
    }

    public Integer getHeroNum() {
        return heroNum;
    }

    public void setHeroNum(Integer heroNum) {
        this.heroNum = heroNum;
    }

    public Integer getSkinNum() {
        return skinNum;
    }

    public void setSkinNum(Integer skinNum) {
        this.skinNum = skinNum;
    }

    public String getRareSkin() {
        return rareSkin;
    }

    public void setRareSkin(String rareSkin) {
        this.rareSkin = rareSkin;
    }

    public String getSellHour() {
        return sellHour;
    }

    public void setSellHour(String sellHour) {
        this.sellHour = sellHour;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Long getUseraccountId() {
        return useraccountId;
    }

    public void setUseraccountId(Long useraccountId) {
        this.useraccountId = useraccountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        //保留两位小数
//        DecimalFormat df = new DecimalFormat("0.00");
//        String prices = df.format(price);
//        this.price =new BigDecimal(prices);
        this.price = price;
    }

    public int getDeliveryNum() {
        return deliveryNum;
    }

    public void setDeliveryNum(int deliveryNum) {
        this.deliveryNum = deliveryNum;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public int getBlanceNum() {
        return blanceNum;
    }

    public void setBlanceNum(int blanceNum) {
        this.blanceNum = blanceNum;
    }

    public BigInteger getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(BigInteger unitNum) {
        this.unitNum = unitNum;
    }

    public BigDecimal getBond() {
        return bond;
    }

    public void setBond(BigDecimal bond) {
        this.bond = bond;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId == null ? null : gameId.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId == null ? null : serverId.trim();
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId == null ? null : raceId.trim();
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName == null ? null : serverName.trim();
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName == null ? null : raceName.trim();
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Boolean getIsSmb() {
        return isSmb;
    }

    public void setIsSmb(Boolean isSmb) {
        this.isSmb = isSmb;
    }

    public String getGameAccount() {
        return gameAccount;
    }

    public void setGameAccount(String gameAccount) {
        this.gameAccount = gameAccount == null ? null : gameAccount.trim();
    }

    public String getGameRoleName() {
        return gameRoleName;
    }

    public void setGameRoleName(String gameRoleName) {
        this.gameRoleName = gameRoleName == null ? null : gameRoleName.trim();
    }

    public String getGamePwd() {
        return gamePwd;
    }

    public void setGamePwd(String gamePwd) {
        this.gamePwd = gamePwd == null ? null : gamePwd.trim();
    }

    public String getGamePwd2() {
        return gamePwd2;
    }

    public void setGamePwd2(String gamePwd2) {
        this.gamePwd2 = gamePwd2 == null ? null : gamePwd2.trim();
    }

    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Date getAuditorCreateTime() {
        return auditorCreateTime;
    }

    public void setAuditorCreateTime(Date auditorCreateTime) {
        this.auditorCreateTime = auditorCreateTime;
    }

    public Integer getAuditorStatus() {
        return auditorStatus;
    }

    public void setAuditorStatus(Integer auditorStatus) {
        this.auditorStatus = auditorStatus;
    }

    public String getIdcardImgFront() {
        return idcardImgFront;
    }

    public void setIdcardImgFront(String idcardImgFront) {
        this.idcardImgFront = idcardImgFront == null ? null : idcardImgFront.trim();
    }

    public String getIdcardImgBack() {
        return idcardImgBack;
    }

    public void setIdcardImgBack(String idcardImgBack) {
        this.idcardImgBack = idcardImgBack == null ? null : idcardImgBack.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsGoldRow() {
        return isGoldRow;
    }

    public void setIsGoldRow(Boolean isGoldRow) {
        this.isGoldRow = isGoldRow;
    }

    public String getGoodsTypeStr() {
        return goodsTypeStr;
    }

    public void setGoodsTypeStr(String goodsTypeStr) {
        this.goodsTypeStr = goodsTypeStr;
    }

    public Boolean getIsIdentityVerified() {
        return isIdentityVerified;
    }

    public void setIsIdentityVerified(Boolean isIdentityVerified) {
        this.isIdentityVerified = isIdentityVerified;
    }

    public Boolean getIsAllowVedio() {
        return isAllowVedio;
    }

    public void setIsAllowVedio(Boolean isAllowVedio) {
        this.isAllowVedio = isAllowVedio;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Boolean getIsSellerDeleted() {
        return isSellerDeleted;
    }

    public void setIsSellerDeleted(Boolean isSellerDeleted) {
        this.isSellerDeleted = isSellerDeleted;
    }

    public Boolean getIsInvalid() {
        return isInvalid;
    }

    public void setIsInvalid(Boolean isInvalid) {
        this.isInvalid = isInvalid;
    }

    public String getGameProp() {
        return gameProp;
    }

    public void setGameProp(String gameProp) {
        this.gameProp = gameProp;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getSellerType() {
        return sellerType;
    }

    public void setSellerType(Integer sellerType) {
        this.sellerType = sellerType;
    }

    public String getAuditorOtherReason() {
        return auditorOtherReason;
    }

    public void setAuditorOtherReason(String auditorOtherReason) {
        this.auditorOtherReason = auditorOtherReason;
    }

    public int getAuditorReason() {
        return auditorReason;
    }

    public void setAuditorReason(int auditorReason) {
        this.auditorReason = auditorReason;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getEquipTypeName() {
        return equipTypeName;
    }

    public void setEquipTypeName(String equipTypeName) {
        this.equipTypeName = equipTypeName;
    }

    public String getWeaponTypeName() {
        return weaponTypeName;
    }

    public void setWeaponTypeName(String weaponTypeName) {
        this.weaponTypeName = weaponTypeName;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public Date getCaptureImgTime() {
        return captureImgTime;
    }

    public void setCaptureImgTime(Date captureImgTime) {
        this.captureImgTime = captureImgTime;
    }

    public boolean getIsRobotCapture() {
        return isRobotCapture;
    }

    public void setIsRobotCapture(boolean isRobotCapture) {
        this.isRobotCapture = isRobotCapture;
    }

    public int getAccountFlowState() {
        return accountFlowState;
    }

    public void setAccountFlowState(int accountFlowState) {
        this.accountFlowState = accountFlowState;
    }

    public String getDanName() {
        return danName;
    }

    public void setDanName(String danName) {
        this.danName = danName;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
    }

    public Boolean getIsRecapture() {
        return isRecapture;
    }

    public void setIsRecapture(Boolean isRecapture) {
        this.isRecapture = isRecapture;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    public String getGoodsSource() {
        return goodsSource;
    }

    public void setGoodsSource(String goodsSource) {
        this.goodsSource = goodsSource;
    }

    public BigDecimal getInsurance() {
        return insurance;
    }

    public void setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    public Boolean getIsAxm() {
        return isAxm;
    }

    public void setIsAxm(Boolean isAxm) {
        this.isAxm = isAxm;
    }

    public Long getSignSellerAccountId() {
        return signSellerAccountId;
    }

    public void setSignSellerAccountId(Long signSellerAccountId) {
        this.signSellerAccountId = signSellerAccountId;
    }

    public String getSignSellerAccountName() {
        return signSellerAccountName;
    }

    public void setSignSellerAccountName(String signSellerAccountName) {
        this.signSellerAccountName = signSellerAccountName;
    }

    public BigInteger getTodaySellNum() {
        return todaySellNum;
    }

    public void setTodaySellNum(BigInteger todaySellNum) {
        this.todaySellNum = todaySellNum;
    }

    public Boolean getMessageOpen() {
        return messageOpen;
    }

    public void setMessageOpen(Boolean messageOpen) {
        this.messageOpen = messageOpen;
    }

    public Boolean getIsDamagesMoney() {
        return isDamagesMoney;
    }

    public void setIsDamagesMoney(Boolean damagesMoney) {
        isDamagesMoney = damagesMoney;
    }

    public String getPropertyValuesTitle() {
        return propertyValuesTitle;
    }

    public void setPropertyValuesTitle(String propertyValuesTitle) {
        this.propertyValuesTitle = propertyValuesTitle;
    }

    public Integer getMainGoodsType() {
        return mainGoodsType;
    }

    public void setMainGoodsType(Integer mainGoodsType) {
        this.mainGoodsType = mainGoodsType;
    }

    public Integer getMainGoodsStatus() {
        return mainGoodsStatus;
    }

    public void setMainGoodsStatus(Integer mainGoodsStatus) {
        this.mainGoodsStatus = mainGoodsStatus;
    }


    public String getNewPlatformId() {
        return newPlatformId;
    }

    public void setNewPlatformId(String newPlatformId) {
        this.newPlatformId = newPlatformId;
    }

    public String getNewRegionId() {
        return newRegionId;
    }

    public void setNewRegionId(String newRegionId) {
        this.newRegionId = newRegionId;
    }

    public String getNewServerId() {
        return newServerId;
    }

    public void setNewServerId(String newServerId) {
        this.newServerId = newServerId;
    }

    public String getNewPlatformName() {
        return newPlatformName;
    }

    public void setNewPlatformName(String newPlatformName) {
        this.newPlatformName = newPlatformName;
    }

    public String getNewRegionName() {
        return newRegionName;
    }

    public void setNewRegionName(String newRegionName) {
        this.newRegionName = newRegionName;
    }

    public String getNewServerName() {
        return newServerName;
    }

    public void setNewServerName(String newServerName) {
        this.newServerName = newServerName;
    }

    public Boolean getIsReplace() {
        return isReplace;
    }

    public void setIsReplace(Boolean isReplace) {
        this.isReplace = isReplace;
    }

    public Boolean getIsAddMainCategory() {
        return isAddMainCategory;
    }

    public void setIsAddMainCategory(Boolean isAddMainCategory) {
        this.isAddMainCategory = isAddMainCategory;
    }

    public String getNewGameProp() {
        return newGameProp;
    }

    public void setNewGameProp(String newGameProp) {
        this.newGameProp = newGameProp;
    }

    public String getFilterProperty() {
        return filterProperty;
    }

    public void setFilterProperty(String filterProperty) {
        this.filterProperty = filterProperty;
    }

    public String getMainGid() {
        return mainGid;
    }

    public void setMainGid(String mainGid) {
        this.mainGid = mainGid;
    }

    public Long getInsertTime() {
        return insertTime;
}

    public void setInsertTime(Long insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getSortScore() {
        return sortScore;
    }

    public void setSortScore(Integer sortScore) {
        this.sortScore = sortScore;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
