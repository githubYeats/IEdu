package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Author: Feiyue
 * Date: 2019/9/25 20:50
 * Desc:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Test
    public void test_findAll() {
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    /**
     * 测试分页查询： Page<T> findAll(Pageable var1);
     */
    @Test
    public void test_finaAll_1() {
        //分页查询参数
        int page = 0; // mongodb中的页码是从0开始
        int size = 10;

        /*
        public class PageRequest extends AbstractPageRequest
        public abstract class AbstractPageRequest implements Pageable, Serializable
         */
        Pageable pageable = PageRequest.of(page, size); // 多态
        Page<CmsPage> all = cmsPageRepository.findAll(pageable); // 【分页查询】
        System.out.println(all);
    }

    /**
     * 测试添加方法，mongodb中提供的添加方法，取名为save()
     */
    @Test
    public void test_save() {
        //-----------------构造CmsPage对象-----------------
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageId("p01"); // 测试用，简单设置。
        cmsPage.setPageName("测试页面");
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageCreateTime(new Date());
        /*
        CmsPage类中有如下一个属性：
            //参数列表
            private List<CmsPageParam> pageParams;
         */
        // 构造pageParams对象，并添加到cmsPage实例属性中
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);

        // 保存页面
        cmsPageRepository.save(cmsPage);
        // 打印页面
        System.out.println(cmsPage);
    }

    /**
     * 测试“删除”
     */
    @Test
    public void test_delete() {
        cmsPageRepository.deleteById("p01");
    }

    /**
     * 测试“修改”
     * MongoRepository没有提供Update()系列的方法，它提供的是save()方法，保存，如果对象重复就进行了覆盖，也就是做了修改。
     */
    @Test
    public void test_update() {
        /*
           Optional<T> findById(ID var1);
           它直接返回的就是一个Optional对象。

            Optional是jdk1.8引入的类型，引入它的目的是为了解决空指针异常的这一常见错误。
            Optional是一个容器对象，它包括了我们需要的对象，使用isPresent()方法判断所包
            含对象是否为空，isPresent()方法返回false则表示Optional包含对象为空，否则可以使用get()取出对象进行操作。
            Optional的优点是：
                1、提醒你非空判断。      如果不做isPresent()判断，get()方法会提示（不是报错）
                2、将对象非空检测标准化。 直接做(cmsPage!=null)的判断也可以，但是有时会忘记。标准化就是指它提供了isPresent()方法。
         */
        Optional<CmsPage> optional = cmsPageRepository.findById("p01");
        if (optional.isPresent()) {
            // 获取对象 -> 设置属性值 -> 重新保存对象
            CmsPage cmsPage = optional.get();
            cmsPage.setPageName("测试页面01");
            cmsPageRepository.save(cmsPage);
        }
    }

    /**
     * 自定义接口方法的测试。
     * （只要遵循SpringDataMongoDB的规则，SpringDataMongoDB就能自动实现这些接口方法）
     */
    @Test
    public void test_findByPageName() {
        CmsPage page = cmsPageRepository.findByPageName("测试页面01");
        System.out.println(page);
    }
}
