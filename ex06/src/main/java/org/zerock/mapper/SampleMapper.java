package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper {
	
	@Insert("insert into tbl_sample1(col1) values(#{data})")
    public int insertCol1(String data);
	
    @Insert("insert into tbl_sample2(col2) values(#{data})")
	public int insertCol2(String data);
  
}
