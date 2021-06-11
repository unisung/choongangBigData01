package org.zerock.service;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	//스프링 4.3 이상 에서 자동 autowired처리
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	@Setter(onMethod_=@Autowired)
	private BoardAttachMapper attachMapper;

	@Transactional/* 서비스에서 board테이블 입력, attach테이블 입력 두작업이 하나의 묶음으로 처리*/
	@Override
	public void register(BoardVO board) {
		
		log.info("register....." +board);
		
		//mapper.register(board);
		mapper.insertSelectKey(board);
		//파일첨부하지않았으면
		if(board.getAttachList()==null | board.getAttachList().size()<=0) {
			return;
		}
		
		board.getAttachList().forEach(new Consumer<BoardAttachVO>() {
			@Override
			public void accept(BoardAttachVO attach) {
				attach.setBno(board.getBno());//insertSelectKey에 의해 얻은 bno번호 세팅.
				attachMapper.insert(attach);//첨부파일 반복 입력처리				
			}
		});
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.get(bno);
	}

	/* 게시글 수정시 첨부파일  수정 처리-첨부파일 테이블의 기존 데이타 삭제 후 재입력 */
	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify........ "+board);
		/* 게시글 번호에 해당하는 첨부파일 모두 삭제*/
		attachMapper.deleteAll(board.getBno());
		
		/* 게시글테이블에 해당글번호 내용 수정 처리 */
		boolean modifyResult = mapper.modify(board)==1;
		
		/* 게시글 등록 성공하고, 첨부파일이 존재하면 개별 첨부파일을 tbl_attach테이블에 입력처리 */
		if(modifyResult && board.getAttachList()!=null && board.getAttachList().size()>0) {
			board.getAttachList().forEach(new Consumer<BoardAttachVO>() {
				@Override
				public void accept(BoardAttachVO attach) {
					attach.setBno(board.getBno());
					attachMapper.insert(attach);
				}
			});
		}
		
		return modifyResult;
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {
		attachMapper.deleteAll(bno);
		return mapper.remove(bno)>0;
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		log.info("get Attach list by bno: " +bno);
		return attachMapper.findByBno(bno);
	}

}
