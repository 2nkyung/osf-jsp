package com.osf.test.dao.impl;

import java.util.List;

import com.osf.test.vo.CommonCodeVO;

public interface CommonCodeDAO {
	public List<CommonCodeVO> selectCommonCodeList(String ccGroup);
}
