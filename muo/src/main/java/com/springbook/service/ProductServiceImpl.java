package com.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.domain.Criteria;
import com.springbook.domain.ProductVO;
import com.springbook.mapper.ProductMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	@Setter(onMethod_=@Autowired)
	private ProductMapper mapper;
	
	
	@Override
	public void register(ProductVO vo) {
		mapper.register(vo);
		
	}

	@Override
	public ProductVO getProduct(Long it_number) {
		return mapper.getProduct(it_number);
	}

	@Override
	public boolean modify(ProductVO vo) {
		// TODO Auto-generated method stub
		return mapper.modify(vo)==1;
	}
	
	@Override
	public boolean listModify(ProductVO vo) {
		// TODO Auto-generated method stub
		return mapper.listModify(vo) == 1;
	}

	@Override
	public boolean remove(Long it_number) {
		// TODO Auto-generated method stub
		return mapper.remove(it_number)>0;
	}

	@Override
	public List<ProductVO> getList() {
		return mapper.getList();
	}

	@Override
	public List<ProductVO> getListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}



	
}
