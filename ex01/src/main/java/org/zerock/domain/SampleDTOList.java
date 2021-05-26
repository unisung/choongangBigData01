package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	private List<SampleDTO> list;

	 //사용자 정의 기본생성자
	public SampleDTOList() {
		list = new ArrayList<>();
	}

	 
}
