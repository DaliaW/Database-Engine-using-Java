package Annabelle;

import java.io.Serializable;
import java.util.ArrayList;

public class PairIndex implements Serializable{
		String col;
		String Table;
		int colIndex;
		
		public PairIndex(String col,int n,String table,int colIndex){
			this.col = col;
			this.Table=table;
			this.colIndex = colIndex;
		}

		public String getCol() {
			return col;
		}

		public void setCol(String col) {
			this.col = col;
		}

		public String getTable() {
			return Table;
		}

		public void setTable(String table) {
			Table = table;
		}


		public int getColIndex() {
			return colIndex;
		}

		public void setColIndex(int colIndex) {
			this.colIndex = colIndex;
		}
}

