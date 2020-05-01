package Annabelle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Table implements Serializable{

	String name;
	int numOfPages;
	ArrayList<Integer> pagesId;
	ArrayList<PPair> PagesRange;
	HashMap<String,PairIndex> indexExists; 


	public Table(String name) {
		this.name = name;
		this.numOfPages = 0;
		pagesId = new ArrayList<Integer>();
		PagesRange= new ArrayList<PPair>();
		indexExists = new HashMap<String,PairIndex>();
	}
	
	public void InsertPairOfRanges(Object a,Object b) {
		PagesRange.add(new PPair(a,b));
	}
	public ArrayList<Integer> getPagesId() {
		return pagesId;
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setPagesId(ArrayList<Integer> pagesId) {
		this.pagesId = pagesId;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	
	public void updatepair(PPair P,Object a,Object b){
		P.setA(a);
		P.setB(b);
	
	}
   
	public void addPage(){
		ArrayList<Integer> tmp = getPagesId();
		tmp.add(getNumOfPages());
		this.setPagesId(tmp);
		this.setNumOfPages(getNumOfPages()+1);
	}
	
	public Integer GetLastId() {
		return this.getPagesId().get(((this.getPagesId().size())-1));
	}


}
