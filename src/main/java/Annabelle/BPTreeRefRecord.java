package Annabelle;

import java.io.Serializable;

public class BPTreeRefRecord implements Serializable{
	
	/**
	 * This class represents a pointer to the record. It is used at the leaves of the B+ tree 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNo, indexInPage;
	
	public BPTreeRefRecord(int pageNo, int indexInPage)
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

	public boolean compareTTo(BPTreeRefRecord record) {
		return this.pageNo== record.pageNo && this.indexInPage==record.indexInPage;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "pageNo: "+ this.pageNo +"  "+"IndexInPage: "+ this.indexInPage;
	}

	public void setIndexInPage(int i) {
		// TODO Auto-generated method stub
		indexInPage = i;
	}
}
