package com.example.mallwork.Service.impl;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Entity.Product;
import com.example.mallwork.Service.ProductService;
import com.example.mallwork.Tools.ConstUtil;
import com.example.mallwork.Tools.PageBean;
import com.example.mallwork.Vo.ProductFloorVo;
import com.example.mallwork.Vo.ProductListVo;
import com.example.mallwork.dao.ParamDao;
import com.example.mallwork.dao.ProductDao;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductDao ProductDao;
	@Autowired
	private ParamDao actionParamDao;
	//��ѯ����
	@Override
	public SverResponse<PageBean<Product>> findProduct(Integer productId, Integer partsId, Integer pageNum,
													   Integer pageSize) {
		// TODO Auto-generated method stub
		//1.��Ҫ����������ò�ѯ��Ʒ��������������Dao���ȡ���ݿ�
		int totalCount=ProductDao.getTotalCount(productId, partsId);
		PageBean<Product> pageBean = new PageBean<>(pageNum, pageSize, totalCount);
		//2.����Dao���ȡ��ҳ��ѯ����Ʒ��Ϣ
		pageBean.setData(ProductDao.findProductsByInfo(productId, partsId, pageNum, pageSize));
		return SverResponse.createRespBySuccess(pageBean);
	}
	/**
	 *����������Ʒ
	 */
	@Override
	public SverResponse<List<Product>> findHotProducts(Integer num) {
		//ֱ�Ӳ�ѯ��������
		List<Product> products = ProductDao.findHotProducts(num);
		return SverResponse.createRespBySuccess(products);
	}
	/**
	 * ����¥������
	 */
	@Override
	public SverResponse<ProductFloorVo> findFloorProducts() {
		//����vo����
		ProductFloorVo vo = new ProductFloorVo();
		//1¥����
		List<Product> products1 = ProductDao.findProductsByProductCategory(ConstUtil.ProductType.TYPE_HNTJX);
		vo.setOneFloor(products1);
		//2¥����
		List<Product> products2 = ProductDao.findProductsByProductCategory(ConstUtil.ProductType.TYPE_JZQZJJX);
		vo.setTwoFloor(products2);
		//3¥����
		List<Product> products3 = ProductDao.findProductsByProductCategory(ConstUtil.ProductType.TYPE_GCQZJJX);
		vo.setThreeFloor(products3);
		//4¥����
		List<Product> products4 = ProductDao.findProductsByProductCategory(ConstUtil.ProductType.TYPE_LMJX);
		vo.setFourFloor(products4);
		return SverResponse.createRespBySuccess(vo);
	}
	/**
	 * �Ż���������Ʒ��Ż����Ʒ��Ϣ
	 */
	@Override
	public SverResponse<Product> findProductDetailForPortal(Integer productId) {
		//�жϲ�Ʒ����Ƿ�Ϊ��
		if(productId ==null) {
			return SverResponse.createByErrorMessage("��Ʒ��Ų���Ϊ��");
		}
		//��ѯ��Ʒ����
		Product product = ProductDao.findProductById(productId);
		//�жϲ�Ʒ�Ƿ��¼�
		if(product==null) {
			return SverResponse.createByErrorMessage("��Ʒ�Ѿ��¼ܣ�");
		}
		if(product.getStatus()==ConstUtil.ProductStatus.STATUS_OFF_SALE) {
			return SverResponse.createByErrorMessage("��Ʒ�Ѿ��¼ܣ�");
		}
		return SverResponse.createRespBySuccess(product);
	}
	/**
	 * ��ѯ��Ʒ��Ϣ
	 */
	public SverResponse<PageBean<ProductListVo>> findProductsForProtal(Integer productTypeId, Integer partsId,
																	   String name, int pageNum, int pageSize) {
		//��������
		Product product = new Product();
		int totalRecord = 0;
		//�ж�name�Ƿ�Ϊ��
		if(name !=null && !name.equals("")) {
			product.setName(name);
		}
		if(productTypeId!=0) {
			product.setProductId(productTypeId);
		}
		if(partsId!=0) {
			product.setPartsId(partsId);
		}
		//ǰ����ʾ��Ʒ��Ϊ����
		product.setStatus(2);
		//���ҷ����������ܼ�¼��
		totalRecord = ProductDao.getTotalCount(product);
		//������ҳ����
		PageBean<ProductListVo> pageBean = new PageBean<>(pageNum, pageSize, totalRecord);
		//��ȡ���� 
		List<Product> products = ProductDao.findProducts(product,pageBean.getStartIndex(),pageSize);
		//��װvo
		List<ProductListVo> voList = Lists.newArrayList();
		for(Product p:products) {
			voList.add(createProductListVo(p));
		}
		pageBean.setData(voList);
		return SverResponse.createRespBySuccess(pageBean);
	}
	
	//��װvo����
	private ProductListVo createProductListVo(Product product) {
		ProductListVo vo = new ProductListVo();
		vo.setId(product.getId());
		vo.setName(product.getName());
		vo.setPartsCategory(actionParamDao.findParamById(product.getPartsId()).getName());
		vo.setProductCategory(actionParamDao.findParamById(product.getProductId()).getName());
		vo.setPrice(product.getPrice());
		vo.setStatus(product.getStatus());
		vo.setIconUrl(product.getIconUrl());
		vo.setStatusDesc(ConstUtil.ProductStatus.getStatusDesc(product.getStatus()));
		vo.setHotStatus(ConstUtil.HotStatus.getHotDesc(product.getHot()));
		vo.setHot(product.getHot());
		return vo;
		
	}
	
}
