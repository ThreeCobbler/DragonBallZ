package com.dragon.common.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotEmpty;

/**
 * @author ljn
 * @date 2018/5/9.
 */
@Configuration
@ConfigurationProperties(prefix = "constants")
public class Constants {

    @NotEmpty
    private String  qqAppId;

    @NotEmpty
    private String qqAppSecret;

    @NotEmpty
    private String qqRedirectUrl;

    @NotEmpty
    private String weCatAppId;

    @NotEmpty
    private String weCatAppSecret;

    @NotEmpty
    private String weCatRedirectUrl;

    public String getQqAppId() {
        return qqAppId;
    }

    public void setQqAppId(String qqAppId) {
        this.qqAppId = qqAppId;
    }

    public String getQqAppSecret() {
        return qqAppSecret;
    }

    public void setQqAppSecret(String qqAppSecret) {
        this.qqAppSecret = qqAppSecret;
    }

    public String getQqRedirectUrl() {
        return qqRedirectUrl;
    }

    public void setQqRedirectUrl(String qqRedirectUrl) {
        this.qqRedirectUrl = qqRedirectUrl;
    }

    public String getWeCatAppId() {
        return weCatAppId;
    }

    public void setWeCatAppId(String weCatAppId) {
        this.weCatAppId = weCatAppId;
    }

    public String getWeCatAppSecret() {
        return weCatAppSecret;
    }

    public void setWeCatAppSecret(String weCatAppSecret) {
        this.weCatAppSecret = weCatAppSecret;
    }

    public String getWeCatRedirectUrl() {
        return weCatRedirectUrl;
    }

    public void setWeCatRedirectUrl(String weCatRedirectUrl) {
        this.weCatRedirectUrl = weCatRedirectUrl;
    }

}
