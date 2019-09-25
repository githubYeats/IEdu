package com.xuecheng.framework.domain.cms;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data // lombok注解，自动添加setter/getter方法
@ToString // lombok注解，自动添加toString()方法
@Document(collection = "cms_page") // mongodb注解，实体类与数据库中的collection进行映射
public class CmsPage {
    //页面ID
    @Id
    private String pageId;

    //页面名称
    private String pageName;

    //别名
    private String pageAliase;

    //站点ID
    private String siteId;

    //访问地址
    private String pageWebPath;

    //参数
    private String pageParameter;

    //物理路径
    private String pagePhysicalPath;

    //类型（静态/动态）
    private String pageType;

    //页面模版
    private String pageTemplate;

    //页面静态化内容
    private String pageHtml;

    //状态
    private String pageStatus;

    //创建时间
    private Date pageCreateTime;

    //模版id
    private String templateId;

    //参数列表
    private List<CmsPageParam> pageParams;

    //模版文件Id
//    private String templateFileId;

    //静态文件Id
    private String htmlFileId;

    //数据Url
    private String dataUrl;

}
