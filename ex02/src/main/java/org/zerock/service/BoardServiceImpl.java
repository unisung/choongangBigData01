package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	//스프링 4.3 이상 에서 자동 autowired처리
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		mapper.register(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.get(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return mapper.modify(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		return mapper.remove(bno)>0;
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

}
