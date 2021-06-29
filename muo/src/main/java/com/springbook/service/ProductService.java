package com.springbook.service;

import java.util.List;

import com.springbook.domain.Criteria;
import com.springbook.domain.ProductVO;

public interface ProductService {
	
	public void register(ProductVO vo);
	
	public ProductVO getProduct(Long it_number);
	
	public boolean modify(ProductVO vo);
	
	public boolean listModify(ProductVO vo);
	
	public boolean remove(Long it_number);
	
	public List<ProductVO> getList();
	
	public List<ProductVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
