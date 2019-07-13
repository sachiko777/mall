package com.mall.service.impl;

import com.mall.mapper.ProductCategoryMapper;
import com.mall.pojo.ProductCategory;
import com.mall.pojo.ProductCategoryExample;
import com.mall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUiTree;
import pojo.ResponseResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<EasyUiTree> findProductCategoryListByParentId(Short parentid) {
        ProductCategoryExample productCategoryExample=new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentid);
        List<ProductCategory> productCategoryList=productCategoryMapper.selectByExample(productCategoryExample);
        List<EasyUiTree> easyUiTrees=new ArrayList<>(productCategoryList.size());
        for(ProductCategory productCategory:productCategoryList){
            EasyUiTree easyUiTree=new EasyUiTree();
            easyUiTree.setId(productCategory.getId());
            easyUiTree.setText(productCategory.getName());
            easyUiTree.setSdate(productCategory.getParentId()==0?"closed":"open");
//            easyUiTree.setAttributes(productCategory.getParentId()+"");
            easyUiTrees.add(easyUiTree);
        }
        return easyUiTrees;
    }

    @Override
    public ResponseResult addCategory(Short parentid, String name) {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setParentId(parentid);
        productCategory.setName(name);
        productCategoryMapper.insert(productCategory);
        ResponseResult responseResult=new ResponseResult();
        responseResult.setMsg(productCategory.getId()+"");
        return responseResult;
    }
}
