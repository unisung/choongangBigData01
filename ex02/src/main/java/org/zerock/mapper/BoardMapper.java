package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();

	/* register()메소드명은 boardMapper.xml의 id로 사용*/
	public void register(BoardVO board);

	public BoardVO get(Long bno);
}
