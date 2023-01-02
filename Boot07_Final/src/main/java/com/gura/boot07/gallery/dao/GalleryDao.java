package com.gura.boot07.gallery.dao;

import java.util.List;

import com.gura.boot07.gallery.dto.GalleryDto;

public interface GalleryDao {
	public List<GalleryDto> getList(GalleryDto dto);
	public int getCount(GalleryDto dto);
	public void upload(GalleryDto dto);
	public GalleryDto getData(int num);
	public GalleryDto getData(GalleryDto dto);
	public void addViewCount(int num);
	public void delete(int num);
	public void update(GalleryDto dto);
}
