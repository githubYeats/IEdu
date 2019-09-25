package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;

/**
 * Author: Feiyue
 * Date: 2019/9/25 16:10
 * Desc:
 */
public interface CmsPageControllerApi {

    /**
     * 页面查询接口，运行分页条件查询
     *
     * @param queryPageRequest 查询条件
     * @param page             当前页码
     * @param size             每页显示的条数
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
