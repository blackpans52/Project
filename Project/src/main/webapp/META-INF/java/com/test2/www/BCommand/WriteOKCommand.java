package com.test2.www.BCommand;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import org.imgscalr.Scalr;

import com.test2.www.DAO.BoardDAO;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DTO.BoardDTO;
import com.test2.www.DTO.MemberDTO;
import com.test2.www.Command.Command;

public class WriteOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BoardDAO bDao = BoardDAO.getBoardDAO();
		MemberDAO mDao = MemberDAO.getMemberDAO();
		MemberDTO userInfo = (MemberDTO)session.getAttribute("userInfo");
		MemberDTO mDto = mDao.getMember(userInfo.getId());
		String board_code = request.getParameter("bCode");
		
		BoardDTO bDto = new BoardDTO();
		bDto.setId(mDto.getId());
		bDto.setNickname(mDto.getNickname());
		bDto.setTitle(request.getParameter("title"));
		bDto.setContents(request.getParameter("contents"));
		bDto.setArticle_category(request.getParameter("article_category"));
		bDto.setBoard_code(board_code);
		String contents = bDto.getContents();
		int first = contents.indexOf("<img src=\"");
        int last = contents.indexOf("\" ", first);
		if(first != -1) {
			StringBuffer contents1 = new StringBuffer();
	        contents1.append(contents.substring(first+10, last));
	        StringBuffer contents2 = contents1.insert(contents1.lastIndexOf("/")+1,"thumb_");
	        bDto.setThumbnail(contents2.toString());
	        String filePath = request.getRealPath("uploadedFiles");
	        int last2 = bDto.getThumbnail().lastIndexOf("/");
	        String fileName = bDto.getThumbnail().substring(last2+7, bDto.getThumbnail().length());
			filePath += "\\"+fileName;
			if(bDao.getBoardInfoDAO(board_code).getBoard_category2().equals("picture")) {
				createThumbnail(filePath,200,150);				
			} else if(bDao.getBoardInfoDAO(board_code).getBoard_category2().equals("news")) {
				createThumbnail(filePath,720,360);
			}			
		}
		bDao.writeDAO(bDto);
		bDao.articleCnt(1,board_code);
		request.setAttribute("msg", "글이 작성되었습니다.");
		request.setAttribute("bCode", board_code);
	}
	
	public void createThumbnail(String filePath, int dw, int dh) {
		String oPath = filePath; // 원본 경로
        File oFile = new File(oPath);
        
        int index = oPath.lastIndexOf(".");
        String ext = oPath.substring(index + 1); // 파일 확장자

        String tPath = oFile.getParent() + File.separator + "thumb_" + oFile.getName(); // 썸네일저장 경로
        File tFile = new File(tPath);
        
        try {
        	// 저장된 원본파일로부터 BufferedImage 객체를 생성합니다.        	
        	BufferedImage srcImg = ImageIO.read(new File(filePath));
        	
        	// 원본 이미지의 너비와 높이 입니다. 
        	int ow = srcImg.getWidth(); 
        	int oh = srcImg.getHeight();
        	
        	// 원본 너비를 기준으로 하여 썸네일의 비율로 높이를 계산합니다. 
        	int nw = ow; int nh = (ow * dh) / dw;

        	// 계산된 높이가 원본보다 높다면 crop이 안되므로 
        	// 원본 높이를 기준으로 썸네일의 비율로 너비를 계산합니다. 
        	if(nh > oh) { 
        		nw = (oh * dw) / dh; 
        		nh = oh;
        	}        
        	
        	BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);
        	BufferedImage destImg = Scalr.resize(cropImg, dw, dh);       	
        	ImageIO.write(destImg, ext, tFile);
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}	
}
