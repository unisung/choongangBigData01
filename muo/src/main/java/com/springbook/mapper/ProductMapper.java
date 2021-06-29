package com.springbook.mapper;

import java.util.List;

import com.springbook.domain.Criteria;
import com.springbook.domain.ProductVO;

public interface ProductMapper {
	
	public List<ProductVO> getList();
	
	public List<ProductVO> getListWithPaging(Criteria cri);
	
	public void register(ProductVO vo);
	
	public ProductVO getProduct(Long it_number);
	
	public int modify(ProductVO vo);
	
	public int listModify(ProductVO vo);
	
	public int remove(Long it_number);
	
	public int getTotalCount(Criteria cri);
	
	/* public void insertProductKey(ProductVO vo); */
}
