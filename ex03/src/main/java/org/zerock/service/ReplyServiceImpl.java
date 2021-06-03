package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
    
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		return mapper.insertReply(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		return mapper.delete(rno);
	}

	/*
	 * @Override public List<ReplyVO> getList(Criteria cri, Long bno) { return
	 * mapper.getListWithPaging(cri, bno); }
	 */
	
	@Override
	public ReplyPageDTO getList(Criteria cri, Long bno) {
		return new ReplyPageDTO(mapper.getCountByBno(bno),
				                       mapper.getListWithPaging(cri, bno));
	}
	
	@Override
	public int getCountByBno(long bno) {
		return mapper.getCountByBno(bno);
	}

}
