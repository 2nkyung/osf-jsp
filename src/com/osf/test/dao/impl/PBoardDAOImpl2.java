package com.osf.test.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.osf.test.dao.PBoardDAO2;
import com.osf.test.db.DBCon;
import com.osf.test.vo.PhotoBoardVO;

public class PBoardDAOImpl2 implements PBoardDAO2 {
	private static final String INSERT_PBOARD = "insert into photo_board"
			+"(pb_num, pb_title, pb_content, pb_credat, pb_cretim, pb_file_path, pb_real_path)"
			+" values(seq_pb_num.nextval,?,?,to_char(sysdate, 'YYYYMMDD')"
			+ ",to_char(sysdate,'hh24miss'),?,?)";
	
	private static final String SELECT_PBOARD_LIST = "select * from photo_board";
	private static final String SELECT_PBOARD = "select * from photo_board where PB_NUM=?";
	
	@Override
	public int insertPBoard(PhotoBoardVO pBoard) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(INSERT_PBOARD);
			ps.setString(1, pBoard.getPbTitle());
			ps.setString(2, pBoard.getPbContent());
			ps.setString(3, pBoard.getPbFilePath());
			ps.setString(4, pBoard.getPbRealPath());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<PhotoBoardVO> selectPBoardList() {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(SELECT_PBOARD_LIST);
			List<PhotoBoardVO> pbList = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PhotoBoardVO pb = new PhotoBoardVO();
				pb.setPbNum(rs.getInt("pb_num"));
				pb.setPbTitle(rs.getString("pb_title"));
				pb.setPbContent(rs.getString("pb_content"));
				pb.setPbCretim(rs.getString("pb_cretim"));
				pb.setPbCredat(rs.getString("pb_credat"));
				pb.setPbFilePath(rs.getString("pb_file_path"));
				pb.setPbRealPath(rs.getString("pb_real_path"));
				pbList.add(pb);
			}
			return pbList;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PhotoBoardVO selectBoard(int pbNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
