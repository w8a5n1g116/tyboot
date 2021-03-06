package org.typroject.tyboot.face.order.orm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.typroject.tyboot.core.rdbms.orm.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * <p>
 * 订单产品关系表
 * </p>
 *
 * @author 子杨
 * @since 2018-01-14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("order_product_relation")
public class OrderProductRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
	@TableField("ORDER_SN")
	private String orderSn;
    /**
     * 商品信息主键
     */
	@TableField("PRODUCT_SEQ")
	private Long productSeq;
    /**
     * 商品信息实体类型
     */
	@TableField("PRODUCT_TYPE")
	private String productType;
    /**
     * 商品名称
     */
	@TableField("PRODUCT_NAME")
	private String productName;
    /**
     * 商品数量
     */
	@TableField("COUNT")
	private Integer count;
    /**
     * 商品当前单价
     */
	@TableField("PRODUCT_PRICE")
	private BigDecimal productPrice;

}
