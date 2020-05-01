package Annabelle;

import java.io.Serializable;

public class RTreeRefRecord implements Serializable{
	
	/**
	 * This class represents a pointer to the record. It is used at the leaves of the B+ tree 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNo, indexInPage;
	
	public RTreeRefRecord(int pageNo, int indexInPage)
	{
		this.pageNo = pageNo;
		this.indexInPage = indexInPage;
	}
	
	/**
	 * @return the page at which the record is saved on the hard disk
	 */
	public int getPage()
	{
		return pageNo;
	}
	
	/**
	 * @return the index at which the record is saved in the page
	 */
	public int getIndexInPage()
	{
		return indexInPage;
	}

	public boolean compareTTo(RTreeRefRecord record) {
		return this.pageNo== record.pageNo && this.indexInPage==record.indexInPage;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "pageNo:"+ this.pageNo +", "+"indexInPage:"+ this.indexInPage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIndexInPage(int indexInPage) {
		this.indexInPage = indexInPage;
	}
}
