package com.example.mallwork.ServiceImp;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Entity.Product;
import com.example.mallwork.Tools.PageBean;
import com.example.mallwork.Vo.ProductFloorVo;
import com.example.mallwork.Vo.ProductListVo;

import java.util.List;

public interface ProductServiceImp {
	/**
	 * ������Ʒչʾ
	 * @param productId
	 * @param partId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public SverResponse<PageBean<Product>> findProduct(Integer productId, Integer partId, Integer pageNum, Integer pageSize);
	/**
	 * �Ż�����������Ʒ
	 * @param num
	 * @return
	 */
	public SverResponse<List<Product>> findHotProducts(Integer num);
	/**
	 * �Ż������ҳ����¥������
	 * @return
	 */
	public SverResponse<ProductFloorVo> findFloorProducts();
	/**
	 * �Ż���������Ʒ��Ż����Ʒ��Ϣ
	 * @param productId
	 * @return
	 */
	public SverResponse<Product> findProductDetailForPortal(Integer productId);
	/**
	 * ������Ʒ
	 * @param productTypeId
	 * @param partsId
	 * @param name
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public SverResponse<PageBean<ProductListVo>> findProductsForProtal(Integer productTypeId, Integer partsId,
																	   String name, int pageNum, int pageSize);
}
