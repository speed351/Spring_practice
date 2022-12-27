package com.gura.spring04.gallery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring04.gallery.dto.GalleryDto;

@Repository
public class GalleryDaoImpl implements GalleryDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<GalleryDto> getList(GalleryDto dto) {
		// TODO Auto-generated method stub
		return session.selectList("gallery.getList",dto);
	}

	@Override
	public int getCount(GalleryDto dto) {
		return session.selectOne("gallery.getCount",dto);
	}

	@Override
	public void upload(GalleryDto dto) {
		session.insert("gallery.insert",dto);		
		
	}

	@Override
	public GalleryDto getData(int num) {
		return session.selectOne("gallery.getData",num);
	}

	@Override
	public GalleryDto getData(GalleryDto dto) {
		return session.selectOne("gallery.getData2",dto);
	}

	@Override
	public void addViewCount(int num) {
		session.update("gallery.addViewCount", num);
		
	}

	@Override
	public void delete(int num) {
		session.delete("gallery.delete",num);
		
	}

	@Override
	public void update(GalleryDto dto) {
		session.update("gallery.update",dto);
		
	}

}
