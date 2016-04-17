package xyz.antsgroup.course.controller.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.antsgroup.course.util.EquipConsumCategoryDetail;

/**
 * 获取仓库中设备和材料分类的详细信息
 */
public class EquipConsumCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     */
    public EquipConsumCategoryServlet() {
        super();
    }

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out = response.getWriter();
	    
	    String category = null;
        try {
            category = EquipConsumCategoryDetail.getCategoryInJosn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    out.write(category);
	}

}
