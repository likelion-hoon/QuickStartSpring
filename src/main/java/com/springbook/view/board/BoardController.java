package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap") 
	public Map<String, String> searchConditionMap() {	
		
		Map<String, String> conditionMap = new HashMap<String, String>(); 
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap; 
	}

	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.insertBoard(vo);
		return "getBoardList.do"; // 글을 등록하고 글 목록을 출력해야 한다.
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 보기
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {

		model.addAttribute("board",boardDAO.getBoard(vo)); // Model 정보 저장
		return "getBoard.jsp";
	}

	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {

		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}
}
