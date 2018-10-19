package com.team.springboot.myspringboot.commom;

import java.util.List;

public class PageBean<T> {
	private List<T> data;//当前页的数据		查询  limit (pageNumber-1)*pageSize,pageSize
	private int current;//当前页			页面传递过来
	private int total;//总条数		查询  count(*)
	private int pageSize;//每页显示的数量	固定值
	private long totalPage;//总页数			计算出来 (int)Math.ceil(totalRecord*1.0/pageSize);

	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage() {
		return (int)Math.ceil(total*1.0/pageSize);
	}
	
	/**
	 * 获取开始索引
	 * @return
	 */
	public int getStartIndex(){
		return (current-1)*pageSize;
	}
	
	/**
	 * 获取结束索引
	 * @return
	 */
	public int getEndIndex(){
		return getCurrent()*getPageSize();
	}
	
	public PageBean(int pageNumber, int pageSize) {
		this.current = pageNumber;
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageBean{" +
				"data=" + data +
				", current=" + current +
				", total=" + total +
				", pageSize=" + pageSize +
				", totalPage=" + totalPage +
				'}';
	}
}
