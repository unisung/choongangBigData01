package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);

	/* register()메소드명은 boardMapper.xml의 id로 사용*/
	public void register(BoardVO board);

	public BoardVO get(Long bno);

	public int modify(BoardVO board);

	public int remove(Long bno);
	
	public int getTotalCount(Criteria cri);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount) ;
	
	
}
