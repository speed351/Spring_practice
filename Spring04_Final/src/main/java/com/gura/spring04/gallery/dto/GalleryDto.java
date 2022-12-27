package com.gura.spring04.gallery.dto;

import org.springframework.web.multipart.MultipartFile;

public class GalleryDto {
	public GalleryDto() {}
	
	private int num;
	private String writer;
	private String caption;
	private String regdate;
	private String imagePath;
	private int startRowNum;
	private int endRowNum;
	private int prevNum;	//이전 글 번호
	private int nextNum;	//다음 글 번호
	// 파일 업로드 처리를 하기 위한 필드
	private MultipartFile myFile;
	// 원본 파일명
	private String orgFileName;
	// 파일 시스템에 저장된 파일명
	private String saveFileName;
	
	
	public GalleryDto(int num, String writer, String caption, String regdate, String imagePath, int startRowNum,
			int endRowNum, int prevNum, int nextNum, MultipartFile myFile, String orgFileName, String saveFileName) {
		super();
		this.num = num;
		this.writer = writer;
		this.caption = caption;
		this.regdate = regdate;
		this.imagePath = imagePath;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
		this.myFile = myFile;
		this.orgFileName = orgFileName;
		this.saveFileName = saveFileName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}
	public int getPrevNum() {
		return prevNum;
	}
	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}
	public int getNextNum() {
		return nextNum;
	}
	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}
	public MultipartFile getMyFile() {
		return myFile;
	}
	public void setMyFile(MultipartFile myFile) {
		this.myFile = myFile;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	
	
	
}
