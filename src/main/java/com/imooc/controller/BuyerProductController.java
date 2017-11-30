package com.imooc.controller;


import com.imooc.VO.ProductInfoVo;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;







    @GetMapping("list")
    public ResultVO list(){
        //1.查询所有上架的商品---数据库查询
        List<ProductInfo> productInfoList = productService.findUpAll();   //获取


        //2.查询类目(一次性查询)-----数据库查询
        //不要吧数据库的查询放在for循环里面去，这样子一旦循环数目过大，例如要循环一万条数据，要有一万次数据库查询，这样的时间开销是非常大的
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productinfo: productInfoList) {
//            categoryTypeList.add(productinfo.getCategoryType());
//        }
        //获取所有类目，添加到list集合中
        List<Integer> categoryTypeList =  productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        //查询的出来的数据[(categoryId,categoryName,categoryType),(1,'热销榜',2)]
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼接
        //创建list集合等待往里面添加元素
        List<ProductVO> productVOList = new ArrayList<>();

        //遍历类目表
        for (ProductCategory productCategory :productCategoryList) {
            ProductVO productVO = new ProductVO();   //创建productVO对象
            productVO.setCategoryType(productCategory.getCategoryType());  //获取类目type作为productVO type set 的值
            productVO.setCategoryName(productCategory.getCategoryName());  //获取名称name作为productVO name set 的值

            List<ProductInfoVo> productInfoVoList =new ArrayList<>();

            //遍历商品表
            for (ProductInfo productInfo: productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){   //如果类目表的type=商品表的type
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);  //copy productInfo对象给productInfoVo
                    productInfoVoList.add(productInfoVo);   //转成集合
                }
            }
            productVO.setProductInfoVoList(productInfoVoList);  //获取商品列表作为productVO foods set 的值
            productVOList.add(productVO);   //添加到展示列表：[name:热销榜，type：2，foods：{id: "123456",name: "老虎粥", price: 3.2, description: "看什么看，来喝粥啊！", icon: "http://baido.com"}]
        }

        //ResultVO resultVO = new ResultVO();

//        ProductVO productVO= new ProductVO();
//        ProductInfoVo productInfoVo= new ProductInfoVo();
//        productVO.setProductInfoVoList(Arrays.asList(productInfoVo));
//        resultVO.setData(Arrays.asList(productVO));
//        resultVO.setData(productVOList);
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        return  resultVO;


        return ResultVOUtil.success(productVOList);
    }

}
