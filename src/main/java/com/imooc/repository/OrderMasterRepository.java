package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: wuguozhu.
 * @Desc:
 * @Date: 2017/11/19 16:17.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    /**查询某人的订单，分页查 */

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
