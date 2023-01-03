package com.gura.boot07.gallery.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.gallery.dao.GalleryDao;
import com.gura.boot07.gallery.dto.GalleryDto;

@Service
public class GalleryServiceImpl implements GalleryService{

	//하나의 서비스에서 여러개의 dao에 의존할 수도 있다.
	@Autowired
	private GalleryDao GalleryDao;
	
	@Value("${file.location}")
	private String fileLocation;
	
	
	@Override
	public void getList(HttpServletRequest request) {
		// 한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT = 5;
		// 하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT = 5;

		// 보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum = 1;
		// 페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum = request.getParameter("pageNum");
		// 만일 페이지 번호가 파라미터로 넘어 온다면
		if (strPageNum != null) {
			// 숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum = Integer.parseInt(strPageNum);
		}

		// 보여줄 페이지의 시작 ROWNUM
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		// 보여줄 페이지의 끝 ROWNUM
		int endRowNum = pageNum * PAGE_ROW_COUNT;

		/*
		 * [ 검색 키워드에 관련된 처리 ] -검색 키워드가 파라미터로 넘어올수도 있고 안넘어 올수도 있다.
		 */
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");
		// 만일 키워드가 넘어오지 않는다면
		if (keyword == null) {
			// 키워드와 검색 조건에 빈 문자열을 넣어준다.
			// 클라이언트 웹브라우저에 출력할때 "null" 을 출력되지 않게 하기 위해서
			keyword = "";
			condition = "";
		}

		// 특수기호를 인코딩한 키워드를 미리 준비한다.
		String encodedK = URLEncoder.encode(keyword);

		// GalleryDto 객체에 startRowNum 과 endRowNum 을 담는다.
		GalleryDto dto = new GalleryDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
 
		// 만일 검색 키워드가 넘어온다면
		if (!keyword.equals("")) {
			// 검색 조건이 무엇이냐에 따라 분기 하기
			if (condition.equals("caption_writer")) {// 설명 + 내용 검색인 경우
				// 검색 키워드를 GalleryDto 에 담아서 전달한다.
				dto.setCaption(keyword);
				dto.setWriter(keyword);
			} else if (condition.equals("caption")) { // 설명 검색인 경우
				dto.setCaption(keyword);
			} else if (condition.equals("writer")) { // 작성자 검색인 경우
				dto.setWriter(keyword);
			} // 다른 검색 조건을 추가 하고 싶다면 아래에 else if() 를 계속 추가 하면 된다.
		}
		// 글 목록 얻어오기
		List<GalleryDto> list = GalleryDao.getList(dto);
		// 전체글의 갯수
		int totalRow = GalleryDao.getCount(dto);

		// 하단 시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		// 하단 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;

		// 전체 페이지의 갯수
		int totalPageCount = (int) Math.ceil(totalRow / (double) PAGE_ROW_COUNT);
		// 끝 페이지 번호가 전체 페이지 갯수보다 크다면 잘못된 값이다.
		if (endPageNum > totalPageCount) {
			endPageNum = totalPageCount; // 보정해 준다.
		}
		// view page 에서 필요한 값을 request 에 담아준다.
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		request.setAttribute("encodedK", encodedK);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("list", list);
		request.setAttribute("totalRow", totalRow);
	}

	@Override
	public void getDetail(HttpServletRequest request) {
		// 자세히 보여줄 글번호를 읽어온다.
		int num = Integer.parseInt(request.getParameter("num"));
		// 조회수 올리기
		GalleryDao.addViewCount(num);

		/*
		 * [ 검색 키워드에 관련된 처리 ] -검색 키워드가 파라미터로 넘어올수도 있고 안넘어 올수도 있다.
		 */
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");
		// 만일 키워드가 넘어오지 않는다면
		if (keyword == null) {
			// 키워드와 검색 조건에 빈 문자열을 넣어준다.
			// 클라이언트 웹브라우저에 출력할때 "null" 을 출력되지 않게 하기 위해서
			keyword = "";
			condition = "";
		}
		// GalleryDto 객체를 생성해서
		GalleryDto dto = new GalleryDto();
		// 자세히 보여줄 글번호를 넣어준다.
		dto.setNum(num);
		// 만일 검색 키워드가 넘어온다면
		if (!keyword.equals("")) {
			// 검색 조건이 무엇이냐에 따라 분기 하기
			if (condition.equals("caption_writer")) {// 설명 + 내용 검색인 경우
				// 검색 키워드를 GalleryDto 에 담아서 전달한다.
				dto.setCaption(keyword);
				dto.setWriter(keyword);
			} else if (condition.equals("caption")) { // 설명 검색인 경우
				dto.setCaption(keyword);
			} else if (condition.equals("writer")) { // 작성자 검색인 경우
				dto.setWriter(keyword);
			} // 다른 검색 조건을 추가 하고 싶다면 아래에 else if() 를 계속 추가 하면 된다.
		}

		// 글하나의 정보를 얻어온다.
		GalleryDto resultDto = GalleryDao.getData(dto);

		// 특수기호를 인코딩한 키워드를 미리 준비한다.
		String encodedK = URLEncoder.encode(keyword);


		// request scope 에 글 하나의 정보 담기
		request.setAttribute("dto", resultDto);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		request.setAttribute("encodedK", encodedK);
	}

	@Override
	public void saveContent(GalleryDto dto, ModelAndView mView, HttpServletRequest request) {
		// 업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값 얻어오기
		MultipartFile myFile = dto.getMyFile();
		// 원본 파일명
		String orgFileName = myFile.getOriginalFilename();
		// 파일의 크기  
		long fileSize = myFile.getSize();

		// webapp/resources/upload 폴더 까지의 실제 경로(서버의 파일시스템 상에서의 경로)
		String realPath = fileLocation;
		// 저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		// 디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		if (!upload.exists()) {// 만일 디렉토리가 존재하지 않으면
			upload.mkdir(); // 만들어 준다.
		}
		// 저장할 파일 명을 구성한다.
		String saveFileName = System.currentTimeMillis() + orgFileName;
		try {
			// upload 폴더에 파일을 저장한다.
			myFile.transferTo(new File(filePath + saveFileName));
			System.out.println(filePath + saveFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// dto 에 업로드된 파일의 정보를 담는다.
		String id = (String) request.getSession().getAttribute("id");
		dto.setWriter(id); // 세션에서 읽어낸 파일 업로더의 아이디
		dto.setOrgFileName(orgFileName);
		dto.setSaveFileName(saveFileName);
		dto.setImagePath(saveFileName);
		// fileDao 를 이용해서 DB 에 저장하기
		GalleryDao.upload(dto);
		// view 페이지에서 사용할 모델 담기
		mView.addObject("dto", dto);
		
	}

	@Override
	public void updateContent(GalleryDto dto) {
		GalleryDao.update(dto);

	}

	@Override
	public void deleteContent(int num, HttpServletRequest request) {
		//세션에 로그인된 아이디를 읽어와서
		
		//글 작성자와 로그인된 아이디가 다르다면
		
		//예외를 발생시켜서 삭제가 안되도록 한다
		GalleryDao.delete(num);
	}

	@Override
	public void getData(HttpServletRequest request) {
		//수정할 글 번호
		int num = Integer.parseInt(request.getParameter("num"));
		//수정할 글의 정보 얻어와서
		GalleryDto dto = GalleryDao.getData(num);
		//request에 담아준다.
		request.setAttribute("dto",dto);

	}

}
