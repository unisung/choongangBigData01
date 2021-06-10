package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;

/* 첨부파일 db처리 */
public interface BoardAttachMapper {

	public void insert(BoardAttachVO vo);//첨부파일 db저장
	public void delete(String uuid); //첨부파일 삭재
	public List<BoardAttachVO> findByBno(Long bno);//게시글 번호에 해당하는 첨부파일 리스트 출력
	public void deleteAll(Long bno);
}
