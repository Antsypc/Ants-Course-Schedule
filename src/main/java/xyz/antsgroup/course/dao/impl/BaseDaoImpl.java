package xyz.antsgroup.course.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
//import java.util.StringTokenizer;


import xyz.antsgroup.course.dao.BaseDao;
import xyz.antsgroup.course.util.DBTool;

public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {

	private Class<T> entityClass;

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	private int result = 0;

	@SuppressWarnings({ "unchecked" })
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();
		entityClass = (Class<T>) type.getActualTypeArguments()[0];
		// Type genericType = getClass().getGenericSuperclass();
		// Type[] params = ((ParameterizedType) genericType)
		// .getActualTypeArguments();
		// entityClass = (Class) params[0];
	}

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
	public int save(T entity) throws Exception {
        String classname = entityClass.getSimpleName();
        classname = classname.substring(0,1).toLowerCase() + classname.substring(1, classname.length());
		String sql = "INSERT INTO " + classname + " (";
		List<Method> list = this.matchPojoMethods(entity, "get");
		Iterator<Method> iter = list.iterator();
		Object[] obj = new Object[list.size()];
		int i = 0;
		// 拼接sql语句 insert into tableName (fieldName1, fieldName2,
		// fieldName3,......
		while (iter.hasNext()) {
			Method method = iter.next();
			sql += method.getName().substring(3).toLowerCase() + ",";

			// 如果字段属性为Date，先进行格式转换，再调用get方法
			if (method.getReturnType().getSimpleName().indexOf("Date") != -1) {
				SimpleDateFormat sbf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				obj[i] = sbf.format(method.invoke(entity, new Object[] {}));
			} else {
				obj[i] = method.invoke(entity, new Object[] {});
			}
			i++;
		}

		// 去掉最后一个,符号insert insert into tableName (fieldName1, fieldName2,
		// fieldName3,......) values(
		sql = sql.substring(0, sql.lastIndexOf(",")) + ") values(";

		// 拼装预编译SQL语句insert insert into tableName (fieldName1, fieldName2,
		// fieldName3,...... values(?,?,?,......
		for (int j = 0; j < list.size(); j++) {
			sql += "?,";
		}

		// 去掉SQL语句最后一个,符号insert insert into tableName(fieldName1, fieldName2,
		// fieldName3) values(?,?,?);
		sql = sql.substring(0, sql.lastIndexOf(",")) + ")";


		try {
			conn = DBTool.getConnection();
			ps = conn.prepareStatement(sql);
			for (int j = 0; j < obj.length; j++) {
				ps.setObject(j + 1, obj[j]);
			}
			// sql语句拼接结束，打印sql语句
			System.out.println("sql=" + sql);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return result;
	}

	/**
	 * 删除
	 * 
	 * @param entity
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void delete(ID id) throws Exception {
        String classname = entityClass.getSimpleName();
        classname = classname.substring(0,1).toLowerCase() + classname.substring(1, classname.length());
		String sql = "delete from " + classname + " where ";
		T entity = entityClass.newInstance();
		// 存放被操作表主键的方法
		Method idMethod = null;

		List<Method> list = this.matchPojoMethods(entity, "set");
		Iterator<Method> iter = list.iterator();

		// 取得setXXXId方法
		while (iter.hasNext()) {
			Method method = iter.next();
			if (method.getName().indexOf("Id") != -1
					&& method.getName().substring(3).length() == 2) {
				idMethod = method;
			} else if ((entity.getClass().getSimpleName() + "Id")
					.equalsIgnoreCase(method.getName().substring(3))) {
				idMethod = method;
			}
		}

		// 第一个字母转为小写
		sql += idMethod.getName().substring(3, 4).toLowerCase()
				+ idMethod.getName().substring(4) + "= ?";


		try {
			conn = DBTool.getConnection();
			ps = conn.prepareStatement(sql);
			if (id instanceof Integer) {
				ps.setInt(1, (Integer) id);
			} else if (id instanceof String) {
				ps.setString(1, (String) id);
			}
			System.out.println("sql=" + sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	/**
	 * 更新
	 * 
	 * @param entity
	 * @return
	 */
	public void update(T entity) throws Exception {
        String classname = entityClass.getSimpleName();
        classname = classname.substring(0,1).toLowerCase() + classname.substring(1, classname.length());
		String sql = "update "
				+ classname + " set ";

		List<Method> list = this.matchPojoMethods(entity, "get");

		// 装载参数
		Object obj[] = new Object[list.size()];
		int i = 0;

		// 临时Method对象,负责迭代时装method对象.
		Method tempMethod = null;

		// 由于修改时不需要修改ID,所以按顺序加参数则应该把Id移到最后.
		Method idMethod = null;
		Iterator<Method> iter = list.iterator();
		while (iter.hasNext()) {
			tempMethod = iter.next();

			// 如果方法名中带有ID字符串并且长度为2,则视为ID.
			if (tempMethod.getName().lastIndexOf("Id") != -1
					&& tempMethod.getName().substring(3).length() == 2) {
				obj[list.size() - 1] = tempMethod.invoke(entity,
						new Object[] {});
				// 把ID字段的对象存放到一个变量中,然后在集合中删掉.
				idMethod = tempMethod;
				iter.remove();
				// 如果方法名去掉set/get字符串以后与pojo + "id"想符合(大小写不敏感),则视为ID
			} else if ((entity.getClass().getSimpleName() + "Id")
					.equalsIgnoreCase(tempMethod.getName().substring(3))) {
				obj[list.size() - 1] = tempMethod.invoke(entity,
						new Object[] {});
				idMethod = tempMethod;
				iter.remove();
			}
		}

		// 把迭代指针移到第一位
		iter = list.iterator();
		while (iter.hasNext()) {
			tempMethod = iter.next();
			sql += tempMethod.getName().substring(3).toLowerCase() + "= ?,";
			obj[i] = tempMethod.invoke(entity, new Object[] {});
			i++;
		}

		// 去掉最后一个,符号
		sql = sql.substring(0, sql.lastIndexOf(","));

		// 添加条件
		sql += " where " + idMethod.getName().substring(3).toLowerCase()
				+ " = ?";


		try {
			conn = DBTool.getConnection();
			ps = conn.prepareStatement(sql);
			for (int j = 0; j < obj.length; j++) {
				ps.setObject(j + 1, obj[j]);
			}
			// SQL拼接完成,打印SQL语句
			System.out.println(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	public T get(ID id) throws Exception {
        String classname = entityClass.getSimpleName();
        classname = classname.substring(0,1).toLowerCase() + classname.substring(1, classname.length());
			String sql = "select * from "
				+ classname + " where ";

		// 通过子类的构造函数,获得参数化类型的具体类型.比如BaseDAO<T>也就是获得T的具体类型
		T entity = entityClass.newInstance();

		// 存放Pojo(或被操作表)主键的方法对象
		Method idMethod = null;

		List<Method> list = this.matchPojoMethods(entity, "set");
		Iterator<Method> iter = list.iterator();

		// 过滤取得Method对象
		while (iter.hasNext()) {
			Method tempMethod = iter.next();
			if (tempMethod.getName().indexOf("Id") != -1
					&& tempMethod.getName().substring(3).length() == 2) {
				idMethod = tempMethod;
			} else if ((entity.getClass().getSimpleName() + "Id")
					.equalsIgnoreCase(tempMethod.getName().substring(3))) {
				idMethod = tempMethod;
			}
		}
		// 第一个字母转为小写
		sql += idMethod.getName().substring(3, 4).toLowerCase()
				+ idMethod.getName().substring(4) + " = ?";

		try {
			conn = DBTool.getConnection();
			ps = conn.prepareStatement(sql);

			// 判断id的类型
			if (id instanceof Integer) {
				ps.setInt(1, (Integer) id);
			} else if (id instanceof String) {
				ps.setString(1, (String) id);
			}

			System.out.println(sql);
			rs = ps.executeQuery();

			// 把指针指向迭代器第一行
			iter = list.iterator();

			// 封装
			while (rs.next()) {
				while (iter.hasNext()) {
					Method method = iter.next();
					if (method.getParameterTypes()[0].getSimpleName().indexOf(
							"String") != -1) {
						// 由于list集合中,method对象取出的方法顺序与数据库字段顺序不一致(比如:list的第一个方法是setDate,而数据库按顺序取的是"123"值)
						// 所以数据库字段采用名字对应的方式取.
						this.setString(
								method,
								entity,
								rs.getString(method.getName().substring(3)
										.toLowerCase()));
					} else if (method.getParameterTypes()[0].getSimpleName()
							.indexOf("Date") != -1) {
						this.setDate(
								method,
								entity,
								rs.getDate(method.getName().substring(3)
										.toLowerCase()));
					} else {
						this.setInt(
								method,
								entity,
								rs.getInt(method.getName().substring(3)
										.toLowerCase()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            if(conn != null) {
                conn.close();
            }
		}

		return entity;
	}

	/*
	 * 根据sql进行查询
	 * 
	 * @param sql
	 * 
	 * @return
	 */
	public List<T> queryByCondition(String sql) throws Exception {
		// String className = null;
		// StringTokenizer token = new StringTokenizer(sql);
		// for(int i = 0; i <= 3 && token.hasMoreTokens(); i++){
		// className = token.nextToken();
		// }
		// System.out.println(className);
		// className = className.substring(0, 1).toUpperCase() +
		// className.substring(1);
		// @SuppressWarnings("unchecked")
		// T entity = (T) Class.forName(className).newInstance();
		//T entity = entityClass.newInstance();
		List<T> l = new ArrayList<T>();
		//List<Method> list = this.matchPojoMethods(entity, "set");
		
		conn = DBTool.getConnection();
		ps = conn.prepareStatement(sql);
		System.out.println(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			T entity = entityClass.newInstance();
			List<Method> list = this.matchPojoMethods(entity, "set");
			Iterator<Method> iter = list.iterator();
			while (iter.hasNext()) {
				Method method = iter.next();
				if (method.getParameterTypes()[0].getSimpleName().indexOf(
						"String") != -1) {
					// 由于list集合中,method对象取出的方法顺序与数据库字段顺序不一致(比如:list的第一个方法是setDate,而数据库按顺序取的是"123"值)
					// 所以数据库字段采用名字对应的方式取.
					this.setString(
							method,
							entity,
							rs.getString(method.getName().substring(3)
									.toLowerCase()));
				} else if (method.getParameterTypes()[0].getSimpleName()
						.indexOf("Date") != -1) {
					this.setDate(
							method,
							entity,
							rs.getDate(method.getName().substring(3)
									.toLowerCase()));
				} else {
					this.setInt(
							method,
							entity,
							rs.getInt(method.getName().substring(3)
									.toLowerCase()));
				}
			}
			l.add(entity);
		}

		return l;
	}

	public List<T> getAll() throws Exception{
        String classname = entityClass.getSimpleName();
        classname = classname.substring(0,1).toLowerCase() + classname.substring(1, classname.length());
		String sql = "select * from " + classname;
		
		List<T> l = new ArrayList<T>();
		try {
			conn = DBTool.getConnection();
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = ps.executeQuery();
			
			
			while (rs.next()) {
				T entity = entityClass.newInstance();
				List<Method> list = this.matchPojoMethods(entity, "set");
				Iterator<Method> iter = list.iterator();
				while (iter.hasNext()) {
					Method method = iter.next();
					if (method.getParameterTypes()[0].getSimpleName().indexOf(
							"String") != -1) {
						// 由于list集合中,method对象取出的方法顺序与数据库字段顺序不一致(比如:list的第一个方法是setDate,而数据库按顺序取的是"123"值)
						// 所以数据库字段采用名字对应的方式取.
						this.setString(
								method,
								entity,
								rs.getString(method.getName().substring(3)
										.toLowerCase()));
					} else if (method.getParameterTypes()[0].getSimpleName()
							.indexOf("Date") != -1) {
						this.setDate(
								method,
								entity,
								rs.getDate(method.getName().substring(3)
										.toLowerCase()));
					} else {
						this.setInt(
								method,
								entity,
								rs.getInt(method.getName().substring(3)
										.toLowerCase()));
					}
				}
				l.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	public void batchDelete(ID[] ids) throws Exception {
		
	}

	private List<Method> matchPojoMethods(T entity, String methodName) {
		// 获得当前Pojo所有方法对象
		Method[] methods = entity.getClass().getDeclaredMethods();

		// List容器存放所有带get字符串的Method对象
		List<Method> list = new ArrayList<Method>();

		// 过滤当前Pojo类所有带get字符串的Method对象,存入List容器
		for (int index = 0; index < methods.length; index++) {
			if (methods[index].getName().indexOf(methodName) != -1) {
				list.add(methods[index]);
			}
		}
		return list;
	}

	/**
	 * 参数类型为String时,为entity字段设置参数,对应set
	 */
	public String setString(Method method, T entity, String arg)
			throws Exception {
		return (String) method.invoke(entity, new Object[] { arg });
	}

	/**
	 * 参数类型为Date时,为entity字段设置参数,对应set
	 */
	public Date setDate(Method method, T entity, Date arg) throws Exception {
		return (Date) method.invoke(entity, new Object[] { arg });
	}

	/**
	 * 参数类型为Integer或int时,为entity字段设置参数,对应set
	 */
	public Integer setInt(Method method, T entity, Integer arg)
			throws Exception {


		         return (Integer) method.invoke(entity, new Object[] { arg });
	}

}
