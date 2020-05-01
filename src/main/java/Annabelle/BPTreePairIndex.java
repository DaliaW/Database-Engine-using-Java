package Annabelle;

import java.io.Serializable;
import java.util.ArrayList;

public class BPTreePairIndex  extends PairIndex implements Serializable{
	BPTree btree;
	
	public BPTreePairIndex(String col,int n,String table, int colIndex) throws Exception{
		super(col,n,table,colIndex);
		btree = new BPTree(n, table, col);
	}
}
