package org.typroject.tyboot.core.restful.limit.impl;

import org.springframework.web.method.HandlerMethod;
import org.typroject.tyboot.component.cache.Redis;
import org.typroject.tyboot.component.cache.enumeration.CacheType;
import org.typroject.tyboot.core.auth.face.model.SsoSessionsModel;
import org.typroject.tyboot.core.restful.limit.Frequency;
import org.typroject.tyboot.core.restful.limit.LimitStrategy;

import java.util.concurrent.TimeUnit;


/**
 * 使用请求token来限制用户的请求。
 * 在刷新session之后执行限制校验
 */
public class TokenRestrictiveStrategy implements LimitStrategy {


   private  static Frequency frequency;

   public static final String CACHE_KEY_PREFIX_TOKEN = "TOKEN";

    static {
        //每分钟 每个token 最多发起100个请求
        frequency = new Frequency(TimeUnit.MINUTES,1L,60L);
    }
    @Override
    public String  incrementKey(SsoSessionsModel ssoSessionsModel, HandlerMethod handlerMethod) throws Exception {

        return Redis.genKey(
                CacheType.ERASABLE.name(),
                CACHE_KEY_PREFIX,
                CACHE_KEY_PREFIX_TOKEN,
                ssoSessionsModel.getToken());
    }

    @Override
    public Frequency getFrequency() {
        return frequency;
    }

    @Override
    public boolean afterRefreshSession() {
        return true;
    }
}
