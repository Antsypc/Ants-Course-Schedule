package xyz.antsgroup.course.controller.teacher;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.dao.impl.CourseDao;
import xyz.antsgroup.course.dao.impl.LabRoomDao;
import xyz.antsgroup.course.dao.impl.LabRoomUsageDao;
import xyz.antsgroup.course.entity.Course;
import xyz.antsgroup.course.entity.LabRoom;
import xyz.antsgroup.course.entity.LabRoomUsage;
import xyz.antsgroup.course.entity.Reservation;

/*
 * 查询实验室预约
 */
@WebServlet("/QueryReservationServlet")
public class QueryReservationServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//	BaseDao<LabRoomUsage, String> labRoomUsageDao = new LabRoomUsageDao();
//	BaseDao<LabRoom, String> labRoomDao = new LabRoomDao();
//	BaseDao<Course, String> courseDao = new CourseDao();
//
//	//List<Reservation> rooms = new LinkedList<>();
//
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		response.setCharacterEncoding("UTF-8");
//		String teacherId = (String) request.getSession().getAttribute("id");
//		System.out.println(teacherId);
//		String sql = "select * from labroomusage where teacherId = '"
//				+ teacherId + "' order by labRoomUsageId desc";
//		System.out.println(sql);
//
//		try {
//			List<Reservation> rooms = new LinkedList<Reservation>();
//
//			// 查询该老师预约的实验室
//			List<LabRoomUsage> labRoomUsages = labRoomUsageDao
//					.queryByCondition(sql);
//			for (LabRoomUsage labRoomUsage : labRoomUsages) {
//				String labRoomId = labRoomUsage.getLabRoomId();
//
//				// 根据courseId查询course
//				String courseId = String.valueOf(labRoomUsage.getCourseId());
//				String status = labRoomUsage.getIsOk();
//				System.out.println(status);
//				if ("0".equals(status)) {
//					status = "预约待审";
//				}
//				if("1".equals(status)) {
//					status = "预约通过";
//				}
//				if("2".equals(status)) {
//					status = "预约失败";
//				}
//				System.out.println(status);
//				Course course = courseDao.get(courseId);
//				// 根据labRoomId查询实验室
//				LabRoom labRoom = labRoomDao.get(labRoomId);
//
//				Reservation room = new Reservation();
//
//				room.setLabRoomUsageId(labRoomUsage.getLabRoomUsageId());
//				room.setCampus(labRoom.getCampus());
//				room.setBuilding(labRoom.getBuilding());
//				room.setCourseName(course.getCourseName());
//				room.setStatus(status);
//
//				int timeFrom = labRoomUsage.getTimeFrom();
//				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//				String period = df.format(new Date((long)timeFrom*1000));
//
//				room.setReservedPeriod(period);
//				room.setRoomName(labRoom.getRoomName());
//				room.setCourseCapacity(120);
//				room.setCapacity(labRoom.getCapacity());
//
//				rooms.add(room);
//			}
//			request.setAttribute("rooms", rooms);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		//request.setAttribute("rooms", rooms);
//		request.getRequestDispatcher("/laboratory/reservation.jsp").forward(request, response);
//
//	}

}
