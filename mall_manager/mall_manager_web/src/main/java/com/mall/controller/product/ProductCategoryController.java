package com.mall.controller.product;

import com.mall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUiTree;
import pojo.ResponseResult;

import java.util.List;

/**
 * 商品分类管理控制器
 */
@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 根据parent_id返回数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUiTree> getProductCategoryByParentId(@RequestParam(value = "id",defaultValue = "0") Short parentId){
        List<EasyUiTree> easyUiTrees=productCategoryService.findProductCategoryListByParentId(parentId);
        return easyUiTrees;
    }

    /**
     * 添加分类
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult addCategory(Short parentId,String name){
        ResponseResult responseResult=productCategoryService.addCategory(parentId,name);
        return responseResult;
    }


}
