package Annabelle;

import java.io.Serializable;

public class RTreePairIndex  extends PairIndex implements Serializable{
	RTree rtree;
	
	public RTreePairIndex(String col,int n,String table, int colIndex) throws Exception{
		super(col,n,table,colIndex);
		rtree = new RTree(n, table, col);
	}
}
