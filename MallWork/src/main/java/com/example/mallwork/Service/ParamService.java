package com.example.mallwork.Service;

import com.example.mallwork.Common.SverResponse;
import com.example.mallwork.Entity.Param;

import java.util.List;

public interface ParamService {
	/**
	 * ��ѯ������Ʒ������Ϣ
	 * @return
	 */
	public SverResponse<List<Param>> findAllParams();

}
