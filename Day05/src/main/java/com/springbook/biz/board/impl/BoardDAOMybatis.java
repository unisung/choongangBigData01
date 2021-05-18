package com.springbook.biz.board.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;
	

}
