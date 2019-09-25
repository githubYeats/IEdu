package com.xuecheng.framework.domain.cms.request;

import lombok.Data;

/**
 * Author: Feiyue
 * Date: 2019/9/25 15:55
 * Desc: 页面请求模型类
 */

/**
 * 用于定义页面查询的查询参数，包括: 页面id，页面名称，别名，所属的站点id，使用的模板id。
 */
@Data // lombok注解，自动添加setter/getter方法
public class QueryPageRequest{
    //页面ID
    private String pageId;

    //页面名称
    private String pageName;

    //别名
    private String pageAliase;

    //站点id
    private String siteId;

    //模版id
    private String templateId;
}
