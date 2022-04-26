package student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import student.dao.StudentDAO;

public class DeleteStudentController implements Controller {
	private StudentDAO studentDAO;
	
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String id = arg0.getParameter("id");
		int res = studentDAO.deleteStudent(id);
		ModelAndView mav = new ModelAndView("/message");
		String msg = null, url = null;
		if(res>0) {
			msg = "학생삭제성공!! 학생목록페이지로 이동합니다.";
			url = "list.do";
		}else {
			msg = "학생삭제실패!! 학생등록페이지로 이동합니다.";
			url = "student.do";
	}
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
