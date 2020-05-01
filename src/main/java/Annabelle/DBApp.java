package Annabelle;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class DBApp implements Serializable {
	static int n;
	static int nodes;

	static HashMap<String, Table> h = new HashMap<String, Table>();

//	public static void main(String[] args)
//			throws Exception {
//				String strTableName = "Student";
//				DBApp P = new DBApp();
//				P.init();
/**************************  create Table *******************************/
//				Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
//				htblColNameType.put("ID", "java.awt.Polygon");
//				htblColNameType.put("name", "java.lang.String");
//				htblColNameType.put("gpa", "java.lang.Double");
//				P.createTable(strTableName, "ID", htblColNameType);	
//				
//				FileInputStream file = new FileInputStream("..//Annabelle//data//Tables.ser");
//				ObjectInputStream in = new ObjectInputStream(file);
//				HashMap<String, Table> object1 = (HashMap<String, Table>) in.readObject();
//				in.close();
//				file.close();
//				
//				Table t = object1.get(strTableName);
//				
//				System.out.println(t.name);
//				System.out.println(t.numOfPages);
//				System.out.println(t.pagesId.size());
//				System.out.println(t.PagesRange.size());
//				System.out.println(t.indexExists.size());
/**************************  create Table *******************************/
/**************************  create B-index *******************************/
//				P.createBTreeIndex(strTableName, "ID");
//				P.createBTreeIndex(strTableName, "gpa");
//				Table t = h.get(strTableName);
//				BPTree b1 = ((BPTreePairIndex)t.indexExists.get("gpa")).btree;
//				BPTree b2 = ((BPTreePairIndex)t.indexExists.get("ID")).btree;
//				ArrayList<BPTreeRefRecord> id = b2.search((Comparable)78452);
//				System.out.println(gpa.get(0).getPage()+" "+gpa.get(0).getIndexInPage());
//				System.out.println();
//				System.out.println(id.get(0).getPage()+" "+id.get(0).getIndexInPage());
//				System.out.println();
//				b1.toString();
//				b2.toString();
/**************************  create B-index *******************************/	
/**************************  insert Table *******************************/				
//				Hashtable<String, Object> htblColNameValue = new Hashtable<String, Object>();	
////				
//				htblColNameValue.put("ID", new Integer(453455));
//				htblColNameValue.put("name", new String("Ahmed Noor"));
//				htblColNameValue.put("gpa", new Double(0.95));
//				P.insertIntoTable(strTableName, htblColNameValue);
//				System.out.println(b1.search((Comparable)0.95));
//				System.out.println();
//				htblColNameValue.clear();
//				htblColNameValue.put("ID", new Integer(5674567));
//				htblColNameValue.put("name", new String("Dalia Noor"));
//				htblColNameValue.put("gpa", new Double(1.25));
//				P.insertIntoTable(strTableName, htblColNameValue);
//				System.out.println(b1.search((Comparable)0.95));
//				System.out.println();
//				htblColNameValue.clear();
//		
//				htblColNameValue.put("ID", new Integer(23498));
//				htblColNameValue.put("name", new String("John Noor"));
//				htblColNameValue.put("gpa", new Double(1.5));
//				P.insertIntoTable(strTableName, htblColNameValue);
//				System.out.println(b1.search((Comparable)0.95));
//				System.out.println();
//				htblColNameValue.clear();
//		
//				htblColNameValue.put("ID", new Integer(78452));
//				htblColNameValue.put("name", new String("Zaky Noor"));
//				htblColNameValue.put("gpa", new Double(0.88));
//				P.insertIntoTable(strTableName, htblColNameValue);
//				System.out.println(b1.search((Comparable)0.95));
//				System.out.println();
//				htblColNameValue.clear();
//				htblColNameValue.put("ID", new Integer(52));
//				htblColNameValue.put("name", new String("Amr Noor"));
//				htblColNameValue.put("gpa", new Double(0.92));
//				P.insertIntoTable(strTableName, htblColNameValue);
//				System.out.println(b1.search((Comparable)0.95));
//				System.out.println();
//				htblColNameValue.clear();
//				htblColNameValue.put("ID", new Integer(453455));
//				htblColNameValue.put("name", new String("Ahmed Noor"));
//				htblColNameValue.put("gpa", new Double(0.95));
//				P.insertIntoTable(strTableName, htblColNameValue);	
//				System.out.println(b1.search((Comparable)0.95));
//				System.out.println();
//				b1.toString();
//				b2.toString();
/**************************  insert Table *******************************/
/**************************  create R-index *******************************/
//				P.createRTreeIndex(strTableName, "ID");
//				P.createRTreeIndex(strTableName, "gpa");
//				Table t = h.get(strTableName);
//				ArrayList<PairIndex> p = t.indexExists;
//				for(int i=0;i<p.size();i++){
//					if(p.get(i).col.equals("gpa")){
//						b1 = ((RTreePairIndex)p.get(i)).btree;
//					}else if(p.get(i).col.equals("ID")){
//						b2 = ((RTreePairIndex)p.get(i)).btree;
//					}
//				}
//				RTree b1 = ((RTreePairIndex)t.indexExists.get("gpa")).btree;
//				RTree b2 = ((RTreePairIndex)t.indexExists.get("ID")).rtree;
//				b1.toString();
//				System.out.println();
//				b2.toString();
/**************************  create R-index *******************************/	
/**************************  update table *******************************/
//			    htblColNameValue.put("name", new String("mohamed1"));
//				htblColNameValue.put("gpa", new Double(1.9));
//				P.updateTable(strTableName, "78452", htblColNameValue);
//				System.out.println(b1);
/**************************  update Table *******************************/			
/**************************  Delete Table *******************************/				
///
				//Linear
//				htblColNameValue.put("name", new String("Zaky Noor"));
//				P.deleteFromTable(strTableName, htblColNameValue);
				//Indexed
//				htblColNameValue.clear();
//				htblColNameValue.put("ID", new Integer(453455));
//				htblColNameValue.put("name", new String("Ahmed Noor"));
//				htblColNameValue.put("gpa", new Double(1.5));
//				P.deleteFromTable(strTableName, htblColNameValue);
//				//Clustering
//				P.deleteFromTable(strTableName, htblColNameValue);
//				htblColNameValue.put("ID", new Integer(453455));
//				htblColNameValue.put("name", new String("Ahmed Noor"));
//				P.deleteFromTable(strTableName, htblColNameValue);
//				System.out.println("After: "+b1.search((Comparable)0.95));		
//				b1.toString();
//				System.out.println();
//				b2.toString();
/**************************  Delete Table *******************************/
/**************************  Select from table *******************************/
//				SQLTerm[] arrSQLTerms = new SQLTerm[3];
//				arrSQLTerms[0] = new SQLTerm();
//				arrSQLTerms[1] = new SQLTerm();
//				arrSQLTerms[2] = new SQLTerm();
//				arrSQLTerms[0]._strTableName = "Student";
//				arrSQLTerms[0]._strColumnName= "gpa";
//				arrSQLTerms[0]._strOperator = "<=";
//				arrSQLTerms[0]._objValue = new Double( 1.0 );
//				arrSQLTerms[1]._strTableName = "Student";
//				arrSQLTerms[1]._strColumnName= "name";
//				arrSQLTerms[1]._strOperator = "=";
//				arrSQLTerms[1]._objValue = "Zaky Noor";
//				arrSQLTerms[2]._strTableName = "Student";
//				arrSQLTerms[2]._strColumnName= "ID";
//				arrSQLTerms[2]._strOperator = "=";
//				arrSQLTerms[2]._objValue = new Integer(78452);
//				String[]strarrOperators = new String[2];
//				strarrOperators[0] = "AND";
//				strarrOperators[1] = "AND";
//				Iterator resultSet = P.selectFromTable(arrSQLTerms , strarrOperators);
//				System.out.println("RESULT");
//				while(resultSet.hasNext()){
//					Object[] o = (Object[]) resultSet.next();
//					for(int i=0;i<o.length;i++){
//						System.out.println(o[i]);
//					}
//				}
/**************************  Select from table *******************************/
/**************************  loading serial files *******************************/	
/**********************1- Student Table*******************************/
//				FileInputStream file0 = new FileInputStream("..//Annabelle//data//Student0.ser");
//				ObjectInputStream in0 = new ObjectInputStream(file0);
//				Vector s0 = (Vector) in0.readObject();
//				in0.close();
//				file0.close();
//				for(int i=0;i<s0.size();i++){
//					Object[] o0 = (Object[])s0.get(i);
//					System.out.println("student0"+i);
//					for(int j=0;j<o0.length;j++){
//						System.out.println(o0[j]);
//					}
//				}
//				System.out.println();
//				FileInputStream file1 = new FileInputStream("..//Annabelle//data//Student1.ser");
//				ObjectInputStream in1 = new ObjectInputStream(file1);
//				Vector s1 = (Vector) in1.readObject();
//				in1.close();
//				file1.close();
//				for(int i=0;i<s1.size();i++){
//					System.out.println("student1"+i);
//					Object[] o1 = (Object[])s1.get(i);
//					for(int j=0;j<o1.length;j++){
//						System.out.println(o1[j]);
//					}
//				}
//				System.out.println();
//				FileInputStream file2 = new FileInputStream("..//Annabelle//data//Student2.ser");
//				ObjectInputStream in2 = new ObjectInputStream(file2);
//				Vector s2 = (Vector) in2.readObject();
//				in2.close();
//				file2.close();
//				for(int i=0;i<s2.size();i++){
//					System.out.println("student2"+i);
//					Object[] o2 = (Object[])s2.get(i);
//					for(int j=0;j<o2.length;j++){
//						System.out.println(o2[j]);
//					}
//				}
/**********************1- Student Table*******************************/
				
//				FileInputStream file = new FileInputStream("..//Annabelle//data//Location0.ser");
//				ObjectInputStream in = new ObjectInputStream(file);
//				Vector object1 = (Vector) in.readObject();
//				in.close();
//				file.close();
//		
//				for (int i = 0; i < ((Object[]) (object1.get(0))).length; i++) {
//
//					if(((Object[]) (object1.get(0)))[i].getClass().getName().equals("java.awt.Polygon")){
//					for(int j=0;j<((Polygon)(((Object[]) (object1.get(0)))[i])).xpoints.length;j++){
//						System.out.println(((Polygon)(((Object[]) (object1.get(0)))[i])).xpoints[j]);
//						System.out.println(((Polygon)(((Object[]) (object1.get(0)))[i])).ypoints[j]);
//					}
//					}
//					else
//					System.out.println(((Object[]) (object1.get(0)))[i]+" 00");
//		
//					if(((Object[]) (object1.get(1)))[i].getClass().getName().equals("java.awt.Polygon")){
//					for(int j=0;j<((Polygon)(((Object[]) (object1.get(1)))[i])).xpoints.length;j++){
//						System.out.println(((Polygon)(((Object[]) (object1.get(1)))[i])).xpoints[j]);
//						System.out.println(((Polygon)(((Object[]) (object1.get(1)))[i])).ypoints[j]);
//					}
//					}else
//					 System.out.println(((Object[]) (object1.get(1)))[i]+" 01");
//				
//				}
				
//				FileInputStream file1 = new FileInputStream("..//Annabelle//data//Events1.ser");
//				ObjectInputStream in1 = new ObjectInputStream(file1);
//				Vector object11 = (Vector) in1.readObject();
//				in1.close();
//				file1.close();
//		
//				for (int i = 0; i < ((Object[]) (object11.get(0))).length; i++) {
//					System.out.println(((Object[]) (object11.get(0)))[i]+" 10");
//		
////					 System.out.println(((Object[]) (object11.get(1)))[i]+" 11");
//				}
//				
//				
//				
//				FileInputStream file10 = new FileInputStream("..//Annabelle//data//Events2.ser");
//				ObjectInputStream in10 = new ObjectInputStream(file10);
//				Vector object10 = (Vector) in10.readObject();
//				in1.close();
//				file1.close();
//		
//				for (int i = 0; i < ((Object[]) (object10.get(0))).length; i++) {
//					System.out.println(((Object[]) (object10.get(0)))[i]+" 20");
//		
////					 System.out.println(((Object[]) (object10.get(1)))[i]+" 21");
//				}
//				FileInputStream file2 = new FileInputStream("..//Annabelle//data//Events3.ser");
//				ObjectInputStream in2 = new ObjectInputStream(file2);
//				Vector object12 = (Vector) in2.readObject();
//				in2.close();
//				file2.close();
//		
//				for (int i = 0; i < ((Object[]) (object12.get(0))).length; i++) {
//					System.out.println(((Object[]) (object12.get(0)))[i]+" 30");
//		
////					System.out.println(((Object[]) (object12.get(1)))[i]+" 31");
//				}
//				FileInputStream file3 = new FileInputStream("..//Annabelle//data//Events4.ser");
//				ObjectInputStream in3 = new ObjectInputStream(file3);
//				Vector object3 = (Vector) in3.readObject();
//				in3.close();
//				file3.close();
//		
//				for (int i = 0; i < ((Object[]) (object3.get(0))).length; i++) {
//					System.out.println(((Object[]) (object3.get(0)))[i]+ "40");
////					System.out.println(((Object[]) (object3.get(1)))[i]+ "41");
//				}
//				
//				FileInputStream file31 = new FileInputStream("..//Annabelle//data//Events5.ser");
//				ObjectInputStream in31 = new ObjectInputStream(file31);
//				Vector object31 = (Vector) in31.readObject();
//				in31.close();
//				file31.close();
//		
//				for (int i = 0; i < ((Object[]) (object31.get(0))).length; i++) {
//					System.out.println(((Object[]) (object31.get(0)))[i]+ "50");
//					System.out.println(((Object[]) (object31.get(1)))[i]+ "51");
//				}
////				
//				FileInputStream file9 = new FileInputStream("..//Annabelle//data//Events6.ser");
//				ObjectInputStream in9 = new ObjectInputStream(file9);
//				Vector object9 = (Vector) in9.readObject();
//				in9.close();
//				file9.close();
//		
//				for (int i = 0; i < ((Object[]) (object9.get(0))).length; i++) {
//					System.out.println(((Object[]) (object9.get(0)))[i]+ "60");
//				
//				}
/**************************  loading serial files *******************************/			
//	}
    /********************** Main Methods to be implemented ***********************************/
	/**
	 * Anything to be initiated in starting the application
	 */
	@SuppressWarnings("unchecked")
	public void init(){
		 try{
			 n = readingFromConfigFile("MaximumRowsCountinPage");
			 nodes = readingFromConfigFile("NodeSize");
			 if(getCSVSize()>1){
				 FileInputStream file = new
				 FileInputStream("..//Annabelle//data//Tables.ser");
				 ObjectInputStream in = new ObjectInputStream(file);
				 HashMap<String, Table> v = (HashMap<String, Table>)in.readObject();
				 h = v;
				 file.close();
				 in.close();
			 }else{
				 FileOutputStream file2 = new FileOutputStream(
				 "..//Annabelle//data//Tables.ser");
				 ObjectOutputStream out = new ObjectOutputStream(file2);
				 out.close();
				 file2.close();
		     }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

	/**
	 * creates a new table in DBMS
	 * @param strTableName table name
	 * @param strClusteringKeyColumn the column to be set the clustering key
	 * @param htblColNameType the types of each column
	 * @throws DBAppException
	 */
	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType) throws DBAppException {
		try {
			if(h.get(strTableName)!=null){
				throw new DBAppException("Table name is already exists");
			}
			Table t = new Table(strTableName);
			h.put(strTableName, t);
			String[] types = new String[htblColNameType.size()];
			String[] colname = new String[htblColNameType.size()];

			Set<Map.Entry<String, String>> entrySet = htblColNameType.entrySet();
			int i = 0;

			FileWriter fr = new FileWriter("..//Annabelle//data//metadata.csv", true);

			String s = "";

			if(htblColNameType.get(strClusteringKeyColumn)==null){
				throw new DBAppException("Type of clustering key does not exist.");
			}
			if(!checkType(htblColNameType.get(strClusteringKeyColumn))){
				throw new DBAppException("Type "+ htblColNameType.get(strClusteringKeyColumn)+" does not exist");
			}
			s = "\n"+strTableName + ", " + strClusteringKeyColumn + ", " + htblColNameType.get(strClusteringKeyColumn) + ", "
					+ "True" + ", " + "False" ;
			fr.write(s);
			for (Map.Entry<String, String> entry1 : entrySet) {
				colname[i] = entry1.getKey();
				types[i] = entry1.getValue();
				if(!checkType(types[i])){
					throw new DBAppException("Type "+ types[i]+" does not exist.");
				}else{
					if (!(colname[i].equals(strClusteringKeyColumn))) {
						s = "\n"+strTableName + ", " + colname[i] + ", " + types[i] + ", " + "False" + ", " + "False" ;
						fr.write(s);
					}
				}
				i++;

			}
			fr.close();

			h.remove(t);
			h.put(strTableName, t);

			 FileOutputStream file2 = new FileOutputStream(
			 "..//Annabelle//data//Tables.ser");
			 ObjectOutputStream out = new ObjectOutputStream(file2);
			 out.writeObject(h);
			 out.close();
			 file2.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * creates a new B+ tree index to a specific column to a specific table 
	 * @param strTableName table name
	 * @param strColName column name to be indexed
	 * @throws DBAppException 
	 */
	public void createBTreeIndex(String strTableName,String strColName) throws DBAppException
			{
				try{
					if(h.get(strTableName)==null)
						throw new DBAppException("Table name '"+strTableName+"' does not exist");
					FileReader fr2 = new FileReader("..//Annabelle//data//metadata.csv");
					BufferedReader br = new BufferedReader(fr2);
					int inc = 0;
					boolean found = false;
					int c = 0;
					ArrayList<String[]> md = new ArrayList<String[]>();
					while (br.ready()) {
						String[] metadata = (br.readLine()).split(", ");
						md.add(metadata);
						if(metadata[0].equals(strTableName)){
							if(metadata[1].equals(strColName)){
								if(metadata[4].equals("True")) 
									throw new DBAppException("Column '"+strColName+"' is already indexed");
								md.get(c)[4] = "True";
								found = true;
							}
							inc = !found?inc+1:inc;
						}
						c++;
					}
					if(!found) throw new DBAppException("Column '"+strColName+"' does not exist");
					FileWriter fr = new FileWriter("..//Annabelle//data//metadata.csv", false);

					String s = md.get(0)[0] + ", " + md.get(0)[1] + ", " + md.get(0)[2] + ", "
							+ md.get(0)[3] + ", " + md.get(0)[4];
					for (int k=1;k<md.size();k++)
						s = s+"\n"+md.get(k)[0] + ", " + md.get(k)[1] + ", " + md.get(k)[2] + ", "
							+ md.get(k)[3] + ", " + md.get(k)[4];
					fr.write(s);
					fr.close();
					
					BPTreePairIndex pi = new BPTreePairIndex(strColName,n,strTableName,inc);
					ArrayList<String> filenames = FindFiles(strTableName);
					for(int i=0;i<filenames.size();i++){
						FileInputStream file = new FileInputStream(filenames.get(i));
						ObjectInputStream in = new ObjectInputStream(file);
						Vector v = (Vector) in.readObject();
						in.close();
						file.close();
						for(int j=0;j<v.size();j++){
							Object key =((Object[]) (v.get(j)))[inc];
							BPTreeRefRecord ref = new BPTreeRefRecord(i,j);
							pi.btree.insert((Comparable)key, ref);
							FileOutputStream file2 = new FileOutputStream(filenames.get(i));
							ObjectOutputStream out = new ObjectOutputStream(file2);
							out.writeObject(v);
							out.close();
							file2.close();
						}
					}
					Table t = h.get(strTableName);
					t.indexExists.put(strColName, pi);
					h.remove(h.get(strTableName));
					h.put(strTableName, t);
					FileOutputStream file2 = new FileOutputStream(
							 "..//Annabelle//data//Tables.ser");
					ObjectOutputStream out2 = new ObjectOutputStream(file2);

					out2.writeObject(h);
					out2.close();
					file2.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	
	
	@SuppressWarnings("resource")

	public void createRTreeIndex(String strTableName,String strColName) throws DBAppException
	{
		try{
			if(h.get(strTableName)==null)
				throw new DBAppException("Table name '"+strTableName+"' does not exist");
			FileReader fr2 = new FileReader("..//Annabelle//data//metadata.csv");
			BufferedReader br = new BufferedReader(fr2);

			int inc = 0;
			boolean found = false;
			int c = 0;
			ArrayList<String[]> md = new ArrayList<String[]>();
			while (br.ready()) {
				String[] metadata = (br.readLine()).split(", ");
				md.add(metadata);
				if(metadata[0].equals(strTableName)){
					if(metadata[1].equals(strColName)){
						if(metadata[2].equals("java.awt.polygon")) { //to check if it's type is polygon or not
							if (metadata[4].equals("True"))
								throw new DBAppException("Column '" + strColName + "' is already indexed");
							md.get(c)[4] = "True";
							found = true;
						}
					}

					inc = !found?inc+1:inc;
				}
				c++;
			}
			if(!found) throw new DBAppException("Column '"+strColName+"' does not exist");
			FileWriter fr = new FileWriter("..//Annabelle//data//metadata.csv", false);

			String s = md.get(0)[0] + ", " + md.get(0)[1] + ", " + md.get(0)[2] + ", "
					+ md.get(0)[3] + ", " + md.get(0)[4];
			for (int k=1;k<md.size();k++)
				s = s+"\n"+md.get(k)[0] + ", " + md.get(k)[1] + ", " + md.get(k)[2] + ", "
						+ md.get(k)[3] + ", " + md.get(k)[4];
			fr.write(s);
			fr.close();

			RTreePairIndex pi = new RTreePairIndex(strColName,n,strTableName,inc);
			ArrayList<String> filenames = FindFiles(strTableName);
			for(int i=0;i<filenames.size();i++){
				FileInputStream file = new FileInputStream(filenames.get(i));
				ObjectInputStream in = new ObjectInputStream(file);
				Vector v = (Vector) in.readObject();
				in.close();
				file.close();
				for(int j=0;j<v.size();j++){
					Object key =((Object[]) (v.get(j)))[inc];
					RTreeRefRecord ref = new RTreeRefRecord(i,j);
					pi.rtree.insert((Polygon) key, ref);
					FileOutputStream file2 = new FileOutputStream(filenames.get(i));
					ObjectOutputStream out = new ObjectOutputStream(file2);
					out.writeObject(v);
					out.close();
					file2.close();
				}
			}
			Table t = h.get(strTableName);
			t.indexExists.put(strColName,pi);
			h.remove(h.get(strTableName));
			h.put(strTableName, t);
			FileOutputStream file2 = new FileOutputStream(
					"..//Annabelle//data//Tables.ser");
			ObjectOutputStream out2 = new ObjectOutputStream(file2);

			out2.writeObject(h);
			out2.close();
			file2.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * inserts a new record to a specific table
	 * @param strTableName table name to be inserted in
	 * @param htblColNameValue the values of each column
	 * @throws DBAppException 
	 */
	@SuppressWarnings("resource")
	public void insertIntoTable(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException{

		try{
			if(h.get(strTableName)==null){
				throw new DBAppException("Table name '"+strTableName+"' Does not exist");
			}
			int fixedArray = getSize(strTableName); // the number of the columns in
			// the table inserted
			Object[] enteries = new Object[fixedArray + 1]; // array of data
			// representing a tuple
			int c = -1;
			ArrayList<String> colNames = new ArrayList<String>();
			FileReader fr2 = new FileReader("..//Annabelle//data//metadata.csv");
			BufferedReader br = new BufferedReader(fr2);
			br.readLine();
			boolean arwa2 = false;
			String arwaColName = "";
			all:while (br.ready()) {
				String[] metadata = (br.readLine()).split(", ");
				if (metadata[0].equals(strTableName)) {
					if(metadata[4].equals("True")) {
						arwaColName = metadata[3].equals("True")?metadata[1]:arwaColName; 
						colNames.add(metadata[1]);
					}
					if(metadata[2].equals("java.awt.Polygon")) arwa2 = true;	
					Object v = htblColNameValue.get(metadata[1]);
					// To compare types entered
					if(v == null){
						throw new DBAppException("Column '"+metadata[1]+"' is missing");
					}
					else if (v.getClass().getName().equals(metadata[2])) {
						enteries[++c] = v;
						htblColNameValue.remove(metadata[1]);
					} 
					else {
						throw new DBAppException("Types are not compitable");
					}
				}
				if(c==fixedArray-1) break all;
			}
			if(htblColNameValue.size()>0){
				throw new DBAppException("Column does not exist");
			}
			enteries[enteries.length - 1] = new Date();
			
			Object key = enteries[0];
			if(key==null){
				throw new DBAppException("Clustering key should not be null");
			}

			ArrayList<String> files = FindFiles(strTableName);
			ArrayList<PPair> ranges = FindRange(strTableName);
			Table t = h.get(strTableName);
			if(arwaColName==""){
				FoundMyVector(files, ranges, key, enteries, strTableName, t,colNames);
			}
			else
			{
			PairIndex exists = t.indexExists.get(arwaColName);
				if(arwa2){
					RTree b = ((RTreePairIndex)exists).rtree;
					RTreeRefRecord refNew  = b.searchd((Polygon)enteries[exists.colIndex]);
					if(refNew!=null)
                   	    refNew.setIndexInPage(refNew.getIndexInPage()+1);
                   	else
                   	    refNew= new RTreeRefRecord(0, 0);
					insertRec(refNew.getPage(),refNew.getIndexInPage(),enteries,files,strTableName,t,colNames);	
				}else{
					BPTree b = ((BPTreePairIndex)exists).btree;
					BPTreeRefRecord refNew  = b.searchd((Comparable)enteries[exists.colIndex]);
					if(refNew!=null)
						refNew.setIndexInPage(refNew.getIndexInPage()+1);
					else
						refNew= new BPTreeRefRecord(0, 0);
					insertRec(refNew.getPage(),refNew.getIndexInPage(),enteries,files,strTableName,t,colNames);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * updates the records of a table
	 * @param strTableName table name to be updated
	 * @param strClusteringKey search key
	 * @param htblColNameValue new values of some columns to be set
	 * @throws DBAppException
	 */
	@SuppressWarnings({ "resource", "rawtypes" })
	public void updateTable(String strTableName, String strClusteringKey, Hashtable<String, Object> htblColNameValue)
			throws DBAppException{
		try{
			if(h.get(strTableName)==null){
				throw new DBAppException("Table name "+strTableName+" does not exist.");
			}
			int fixedArray = getSize(strTableName); // the number of the columns in
			// the table inserted
			Object[] enteries = new Object[fixedArray + 1]; // array of data
			// representing a tuple
//			boolean poly = false;
			String[] indexed = new String[fixedArray];
			boolean[] poly = new boolean[fixedArray];
			int countCol = 0;
			FileReader fr2 = new FileReader("..//Annabelle//data//metadata.csv");
			BufferedReader br = new BufferedReader(fr2);
			br.readLine();
			all: while (br.ready()) {
				// If not all attributes are represented, it will be null
				String[] metadata = (br.readLine()).split(", ");
				if (metadata[0].equals(strTableName)) {
					for (int i = 0; i < fixedArray; i++) {
						indexed[countCol++] = metadata[4].equals("True")?metadata[1]:null;
//						poly[countCol++] = metadata[4].equals("java.awt.Polgon")?true:false;
						if (metadata[3].equals("True")) {
							Object o = parseCheckKey(metadata[2], strClusteringKey);
							if (o != null) {
								enteries[0] = o;
							}
						} else {
							if (metadata[2].equals("java.awt.Polygon")) {
								poly[countCol++]  =true;
							}
	
	
							Object v = htblColNameValue.get(metadata[1]);
							// A specific column is not updated
							if (v == null) {
								enteries[i] = null;
							} else { // To compare types entered
								if(enteries[i]!=null)throw new DBAppException("Column cannot be exist twice");
								if (v.getClass().getName().equals(metadata[2]) && !poly[0]) {
									enteries[i] = htblColNameValue.get(metadata[1]);
									htblColNameValue.remove(metadata[1]);
								} else if (poly[0]) {
									StringTokenizer s1 = new StringTokenizer((String) htblColNameValue.get(metadata[1]),
											"(,)");
									ArrayList<Integer> x = new ArrayList<Integer>();
									ArrayList<Integer> y = new ArrayList<Integer>();
									int n = 0;
									while (s1.hasMoreElements()) {
										x.add(Integer.parseInt(s1.nextToken()));
										y.add(Integer.parseInt(s1.nextToken()));
										n++;
									}
									int[] xp = new int[n];
									int[] yp = new int[n];
									for (int j = 0; j < n; j++) {
										xp[i] = x.get(j);
										yp[i] = y.get(j);
									}
									Polygon p = new Polygon(xp, yp, n);
									enteries[i] = p;
									htblColNameValue.remove(metadata[1]);
								}  else {
									throw new DBAppException("Types are not compatible");
								}
							}
						}
						if (i < fixedArray - 1)
							metadata = (br.readLine()).split(", ");
					}
					break all;
				}
			}
			br.close();
			fr2.close();
			enteries[enteries.length - 1] = new Date();
			ArrayList<Object[]> ref = new ArrayList<Object[]>();
			if (htblColNameValue.size() > 0) {
				throw new DBAppException("Column Does not exist");
			} else {
				ArrayList<String> files = FindFiles(strTableName);
				ArrayList<PPair> ranges = FindRange(strTableName);
				Table t = h.get(strTableName);
				if(indexed[0]==null){ //if the clustering key is not indexed
					// should know the old values of the indexed records before updating
					ArrayList<String> index = FindVectorUpdate(files, ranges, t, enteries[0]);
					if (index.size() > 0) {
						// maybe i can change it to output new references
						ref = BinarySearchUpdate(index, enteries,files);
					}
				}else{
					PairIndex p = t.indexExists.get(indexed[0]);
					if(p!=null){
						if(poly[0]){
							RTreePairIndex bp = (RTreePairIndex)p;
							ArrayList<RTreeRefRecord> r = bp.rtree.search((Polygon)enteries[0]);
							ref = updateRecord(r,enteries,files);
						
						}else{
							BPTreePairIndex bp = (BPTreePairIndex)p;
							ArrayList<BPTreeRefRecord> r = bp.btree.search((Comparable)enteries[0]);
							ref = updateRecords(r,enteries,files);
							
						}
					}
				}
				//check for all the changed columns if they are indexed
				for(int i=1;i<indexed.length;i++){
					if(indexed[i]!=null && enteries[i]!=null){
						if(poly[i]){
							//R tree
							RTree bt = null;
							for(int k=0;k<ref.size();k++){
								PairIndex p = t.indexExists.get(indexed[i]);
								if(p!=null){
									RTreePairIndex bp = (RTreePairIndex) p;
									bt = bp.rtree;
									bt.delete((Polygon)ref.get(k)[i+1],(RTreeRefRecord)ref.get(k)[0] );
								}
								bt.insert((Polygon)enteries[i], (RTreeRefRecord)ref.get(k)[0]);
							}		
						}else{
							BPTree bt = null;
							for(int k=0;k<ref.size();k++){
								PairIndex p = t.indexExists.get(indexed[i]);
								if(p!=null){
									BPTreePairIndex bp = (BPTreePairIndex) p;
									bt = bp.btree;
									bt.delete((Comparable)ref.get(k)[i+1],(BPTreeRefRecord)ref.get(k)[0]);
								}
								bt.insert((Comparable)enteries[i], (BPTreeRefRecord)ref.get(k)[0]);
							}		
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * deletes records that satisfy some conditions
	 * @param strTableName table name that we want to delete from
	 * @param htblColNameValue the column names and values we want to delete that satisfy these conditions
	 * @throws DBAppException
	 */
	@SuppressWarnings("resource")
	public void deleteFromTable(String strTableName, Hashtable<String, Object> htblColNameValue)
			throws DBAppException{
		try{
			if(h.get(strTableName)==null){
				throw new DBAppException("Table name "+strTableName+" does not exist");
			}
			int fixedArray = getSize(strTableName);
			ArrayList<String> indexed = new ArrayList<String>();
			Object[] mockEntery = new Object[fixedArray];
			Table t = h.get(strTableName);

			FileReader fr2 = new FileReader("..//Annabelle//data//metadata.csv");

			BufferedReader br = new BufferedReader(fr2);
			br.readLine();
			int c = 0;
			int index = -1;
			boolean clustered = false;
			String colName = "";
			all: while (br.ready()) {
				String[] metadata = (br.readLine()).split(", ");
				if (metadata[0].equals(strTableName)) {
					if(metadata[4].equals("True")) {
						indexed.add(metadata[1]);
					}
					Object v = new Object();
					if (htblColNameValue.get(metadata[1]) != null) {
						v = htblColNameValue.get(metadata[1]);
						mockEntery[c] = v;
						htblColNameValue.remove(metadata[1]);
						if(metadata[3].equals("True")) clustered = true;
						if(metadata[4].equals("True") && index<0) {
							index = c;
							colName = metadata[1];
						}
					}
					if (c == fixedArray - 1)
						break all;
					c++;
				}
			}
			if(htblColNameValue.size()>0){
				throw new DBAppException("Column does not exist");
			}
			
			int indSize = indexed.size();
			String[] indX = new String[indSize];
			for(int i=0;i<indSize;i++) indX[i] = indexed.get(i);
			ArrayList<String> files = FindFiles(strTableName);
			if(index>=0){
//				System.out.println("Index");
				PairIndex p = t.indexExists.get(colName);
					if(mockEntery[index].getClass().getName().equals("java.awt.Polygon")){
						RTree rtree = ((RTreePairIndex)p).rtree;
						ArrayList<RTreeRefRecord> refr=rtree.search((Polygon) mockEntery[index]);
						deleteRefRecord(files,refr, null, mockEntery,index,rtree,null,indX,t);
					}else{
						BPTree btree = ((BPTreePairIndex)p).btree;
						ArrayList<BPTreeRefRecord> refb = btree.search((Comparable) mockEntery[index]);
						deleteRefRecord(files,null, refb, mockEntery,index,null,btree,indX,t);
					}
			}
			else if(clustered){
				//binarySearch
//				System.out.println("Clustering");
				ArrayList<PPair> pp = FindRange(strTableName);
				ArrayList<String> ff = FindVectorUpdate(files, pp, h.get(strTableName), mockEntery[0]);
				findRefAndDel(ff, mockEntery, clustered,t,indX,files);
			}else{
				//linearSearch
//				System.out.println("Linear");
				findRefAndDel(files, mockEntery, clustered,t,indX,null);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void findRefAndDel(ArrayList<String> files,Object[] mockEntery,boolean cluster,
			Table t, String[] indX,ArrayList<String> allFiles) throws Exception{
		int li = 0;
		int ri = 0;
		ArrayList<int[]> reffs = new ArrayList<int[]>();
		ArrayList<Object[]> dataDel = new ArrayList<Object[]>();
		ArrayList<ArrayList<Object[]>> ooo = new ArrayList<ArrayList<Object[]>>();
		for(int i=0;i<files.size();i++){
			FileInputStream file = new FileInputStream(files.get(i));
			ObjectInputStream in = new ObjectInputStream(file);
			Vector<Object[]> v = (Vector<Object[]>) in.readObject();
			in.close();
			file.close();
			ArrayList<Object[]> op = new ArrayList<Object[]>();
			if(cluster){
				ri = getRightIndex(v, 0, v.size(), mockEntery[0]);
				li = getLeftIndex(v, -1, v.size()-1, mockEntery[0]);
//				System.out.println("RightB "+ri);
//				System.out.println("LeftB "+li);
//				System.out.println(files.get(i));
			}else ri = v.size()-1;	
			if((cluster&&compareTTo(v.get(ri)[0],v.get(li)[0])==0)||!cluster){
//				System.out.println("Right "+ri);
//				System.out.println("Left "+li);
//				System.out.println(files.get(i));
//				System.out.println("Correct");
				big:for(int j=li;j<=ri;j++){
					Object[] oo = v.get(j);
					for(int k=1;k<oo.length-1;k++){
						if(mockEntery[k]!=null){
							if(mockEntery[k].getClass().getName().equals("java.awt.Polygon")){
								if(!compareTToCoor((Polygon)mockEntery[k], (Polygon)oo[k])){
									continue big;
								}
							}else{
								if(compareTTo(mockEntery[k],oo[k])!=0){
									continue big;
								}
							}
						}
					}
					dataDel.add(oo);
					int[] del = new int[2];
					del[0] = cluster?allFiles.indexOf(files.get(i)):i; del[1] = j;
					reffs.add(del);
					op = subListOf(v, j+1, v.size()-1);
					ooo.add(op);
					// if the data deleted is the smallest number in the page, update range in the
					// table
					if(v.size()>1){
						if (compareTTo(oo[0], t.PagesRange.get(i).a) == 0) {
							t.updatepair(t.PagesRange.get(i), ((Object[]) v.get(1))[0], t.PagesRange.get(i).b);
							// if the data deleted is the greatest number in the page, update range in the
							// table
						} else if (compareTTo(oo[0], t.PagesRange.get(i).b) == 0) {
							t.updatepair(t.PagesRange.get(i), t.PagesRange.get(i).a, ((Object[]) v.get(v.size() - 2))[0]);
						}
					}
					
					v.remove(j);
					ri--;
					if(v.size()==0){
						// remove pageID,decrement number of pages,remove the range,remove the page
						t.pagesId.remove(i);
						t.setNumOfPages(t.getNumOfPages() - 1);
						t.PagesRange.remove(i);
						Files.deleteIfExists(Paths.get(files.get(i)));
					}else{
						FileOutputStream file1 = new FileOutputStream(files.get(i));
						ObjectOutputStream out = new ObjectOutputStream(file1);
						out.writeObject(v);
						out.close();
						file1.close();
					}
				}
			}
		}
		deleteNodes(reffs, dataDel, indX, t, ooo);		
	}
	
	public static void deleteNodes(ArrayList<int[]> reffs,ArrayList<Object[]> dataDel,String[] indexed,
			Table t,ArrayList<ArrayList<Object[]>> restdata) throws Exception{
		int reffsSize = reffs.size();
		for(int i=0;i<indexed.length;i++){
			String index = indexed[i];
			PairIndex p = t.indexExists.get(index);
			int colIndex = p.colIndex;
			for(int j=0;j<reffsSize;j++){
				int[] refD = reffs.get(j);
				ArrayList<Object[]> dataInVector = restdata.get(j);
				Object[] op = dataDel.get(j);
				Object d = op[colIndex];
				int daInVe = dataInVector.size();
				if(d.getClass().getName().equals("java.awt.Polygon")){
					RTree r = ((RTreePairIndex)p).rtree;
					RTreeRefRecord rr = new RTreeRefRecord(refD[0], refD[1]);
					r.delete((Polygon)d,rr);
				}else{
					BPTree b = ((BPTreePairIndex)p).btree;
					BPTreeRefRecord bb = new BPTreeRefRecord(refD[0], refD[1]);
					b.delete((Comparable)d,bb);
				}
				for(int k=0;k<daInVe;k++){
					Object[] dd = dataInVector.get(k);
					Object ds = dd[colIndex];
					if(ds.getClass().getName().equals("java.awt.Polygon")){
						RTree r = ((RTreePairIndex)p).rtree;
						ArrayList<RTreeRefRecord> re = r.search((Polygon)ds);
						if(re!=null){
							for(int l=0;l<re.size();l++){
								RTreeRefRecord rrr = re.get(l);
								int page = k+refD[1];
								if(rrr.getPage()==refD[0]&&rrr.getIndexInPage()==k+refD[1]+1){
									try{
										r.delete((Polygon)ds,rrr);
									}catch(FileNotFoundException e){
										
									}
									rrr.setIndexInPage(page);
									r.insert((Polygon)ds, rrr);
								}
							}
						}
					}else{
						BPTree b = ((BPTreePairIndex)p).btree;
						ArrayList<BPTreeRefRecord> be = b.search((Comparable)ds);
						if(be!=null){
							for(int l=0;l<be.size();l++){
								BPTreeRefRecord bbb = be.get(l);
								System.out.println(be);
								int page = k+refD[1];
								if(bbb.getPage()==refD[0]&&bbb.getIndexInPage()==k+refD[1]+1){
									try{
										b.delete((Comparable)ds,bbb);
									}catch(FileNotFoundException e){
										
									}
									bbb.setIndexInPage(page);
									b.insert((Comparable)ds, bbb);
								}
							}
						}
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void deleteRefRecord(ArrayList<String> files,ArrayList<RTreeRefRecord> r,ArrayList<BPTreeRefRecord> b ,
			Object[] enteries,int index,RTree rr,BPTree bb,String[] indexed, Table t)
					throws Exception{
		ArrayList<int[]> reffs = new ArrayList<int[]>();
		ArrayList<Object[]> dataDel = new ArrayList<Object[]>();
		ArrayList<ArrayList<Object[]>> ooo = new ArrayList<ArrayList<Object[]>>();
		if(r!=null){
			all:for(int i=0;i<r.size();i++){
				FileInputStream file = new FileInputStream(files.get(r.get(i).getPage()));
				ObjectInputStream in = new ObjectInputStream(file);
				Vector<Object[]> v = (Vector<Object[]>) in.readObject();
				in.close();
				file.close();
				ArrayList<Object[]> op = new ArrayList<Object[]>();
				RTreeRefRecord rrr = r.get(i);
				Object[] o = v.get(rrr.getIndexInPage());
				for(int j=0;j<enteries.length;j++){
					if(enteries[j]!=null){
						if(enteries[j].getClass().getName().equals("java.awt.Polygon")){
							if(!(compareTToCoor((Polygon)enteries[j],(Polygon)o[j])))
							{
								r.remove(i--);
								continue all;
							}	
						}else{
							if(i!=index){
								if(compareTTo(enteries[j],o[j])!=0){
									r.remove(i--);
									continue all;
								}
							}
						}
					}
				}
				//Save the REF
				int[] del = new int[2];
				del[0] = rrr.getPage(); del[1] = rrr.getIndexInPage();
				reffs.add(del);
				op = subListOf(v, del[1]+1, v.size()-1);
				ooo.add(op);
				dataDel.add(o);
				// if the data deleted is the smallest number in the page, update range in the
				// table
				if(v.size()>1){
					if (compareTTo(o[0], t.PagesRange.get(del[0]).a) == 0) {
						t.updatepair(t.PagesRange.get(del[0]), ((Object[]) v.get(del[1] + 1))[0], t.PagesRange.get(del[0]).b);
						// if the data deleted is the greatest number in the page, update range in the
						// table
					} else if (compareTTo(o[0], t.PagesRange.get(del[0]).b) == 0) {
						t.updatepair(t.PagesRange.get(del[0]), t.PagesRange.get(del[0]).a, ((Object[]) v.get(del[1] - 1))[0]);
					}
				}
				
				v.remove(del[1]);
				if(v.size()==0){
					// remove pageID,decrement number of pages,remove the range,remove the page
					t.pagesId.remove(del[0]);
					t.setNumOfPages(t.getNumOfPages() - 1);
					t.PagesRange.remove(del[0]);
					Files.deleteIfExists(Paths.get(files.get(del[0])));
				}else{
					FileOutputStream file1 = new FileOutputStream(files.get(del[0]));
					ObjectOutputStream out = new ObjectOutputStream(file1);
					out.writeObject(v);
					out.close();
					file1.close();
				}
			}
		}else if(b!=null){
			all:for(int i=0;i<b.size();i++){
				BPTreeRefRecord bbb = b.get(i);
//				System.out.println(bbb);
				FileInputStream file = new FileInputStream(files.get(bbb.getPage()));
				ObjectInputStream in = new ObjectInputStream(file);
				Vector<Object[]> v = (Vector<Object[]>) in.readObject();
				in.close();
				file.close();
				ArrayList<Object[]> op = new ArrayList<Object[]>();
				Object[] o = v.get(bbb.getIndexInPage());
				for(int j=0;j<enteries.length;j++){
					if(enteries[j]!=null&& i!=index){
						if(enteries[j].getClass().getName().equals("java.awt.Polygon")){
							if(!(compareTToCoor((Polygon)enteries[j],(Polygon)o[j])))
							{
								b.remove(i--);
								continue all;
							}	
						}else{
							if(compareTTo(enteries[j],o[j])!=0){
								b.remove(i--);
								continue all;
							}
						}
					}
				}
				//Save the REF
				int[] del = new int[2];
				del[0] = bbb.getPage(); del[1] = bbb.getIndexInPage();
				reffs.add(del);
				op = subListOf(v, del[1]+1, v.size()-1);
				ooo.add(op);
				dataDel.add(o);
				// if the data deleted is the smallest number in the page, update range in the
				// table
				if(v.size()>1){
					if (compareTTo(o[0], t.PagesRange.get(del[0]).a) == 0) {
						t.updatepair(t.PagesRange.get(del[0]), ((Object[]) v.get(del[1] + 1))[0], t.PagesRange.get(del[0]).b);
						// if the data deleted is the greatest number in the page, update range in the
						// table
					} else if (compareTTo(o[0], t.PagesRange.get(del[0]).b) == 0) {
						t.updatepair(t.PagesRange.get(del[0]), t.PagesRange.get(del[0]).a, ((Object[]) v.get(del[1] - 1))[0]);
					}
				}
				
				v.remove(del[1]);
				if(v.size()==0){
					// remove pageID,decrement number of pages,remove the range,remove the page
					t.pagesId.remove(del[0]);
					t.setNumOfPages(t.getNumOfPages() - 1);
					t.PagesRange.remove(del[0]);
					Files.deleteIfExists(Paths.get(files.get(del[0])));
				}else{
					FileOutputStream file1 = new FileOutputStream(files.get(del[0]));
					ObjectOutputStream out = new ObjectOutputStream(file1);
					out.writeObject(v);
					out.close();
					file1.close();
				}
			}
		}
		deleteNodes(reffs, dataDel, indexed, t, ooo);
	}
	
		
	/**
	 * Gets the results of a query
	 * @param arrSQLTerms array of sub-queries
	 * @param strarrOperators array of logical operators
	 * @return the results of a specific query
	 * @throws DBAppException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({ "rawtypes", "resource" })
	public Iterator selectFromTable(SQLTerm[] arrSQLTerms,String[] strarrOperators)throws DBAppException, IOException, ClassNotFoundException{
		//To make sure that the number of the operators are matching with the number of the operations done in the Query.
		if(strarrOperators.length>arrSQLTerms.length-1) throw new DBAppException("Additional Operator(s)");
		if(strarrOperators.length<arrSQLTerms.length-1) throw new DBAppException("Missing Operator(s)");
		
		boolean[] clustered = new boolean[arrSQLTerms.length]; 
		boolean[] indexed = new boolean[arrSQLTerms.length]; 
		int[] colnum = new int[arrSQLTerms.length];
		
		//Scan the table names in the SQLTerms to make sure that the names of the
		//tables are the same and they exist in the DBMS.
		for(int i=0;i<arrSQLTerms.length;i++){
			if(h.get(arrSQLTerms[i]._strTableName)==null)
				throw new DBAppException("Table name '"+arrSQLTerms[i]._strTableName+"' does not exist.");
			else{
				if(i>0&&!(arrSQLTerms[i]._strTableName.equals(arrSQLTerms[i-1]._strTableName)))
					throw new DBAppException("DBMS does not support join queries");
				int count =0;
				boolean colFound = false;
				FileReader fr2 = new FileReader("..//Annabelle//data//metadata.csv");
				BufferedReader br = new BufferedReader(fr2);
				br.readLine();
				while (br.ready()) {
					String[] metadata = (br.readLine()).split(", ");
					System.out.println(metadata[0]+" "+metadata[1]+" "+metadata[2]+" "+metadata[3]+" "+metadata[4]);
					if(metadata[0].equals(arrSQLTerms[i]._strTableName)){
						if(metadata[1].equals(arrSQLTerms[i]._strColumnName)){
							colFound = true;
							colnum[i] = count;
							if(metadata[2].equals(arrSQLTerms[i]._objValue.getClass().getName())){
								if(metadata[3].equals("True")) clustered[i] = true;
								else clustered[i] = false;
								if(metadata[4].equals("True")){
									indexed[i] = true;
								}
							}else throw new DBAppException("Incompitable types.");
							
						}
						count++;
			        }
		        }
				if(!colFound) throw new DBAppException("Column '"+arrSQLTerms[i]._strColumnName+"' does not exist.");
			}
		}
		boolean useTree = false;
		boolean XORExist = false;
		for(int i=0;i<indexed.length;i++){
			if(indexed[i]){
				System.out.println(i+"indexed"+arrSQLTerms[i]._strColumnName);
				if(i==0){
					if(strarrOperators[i].equals("OR") || strarrOperators[i].equals("XOR")){
						indexed[i] = indexed[i+1];
						useTree = indexed[i];
						i++;
						XORExist = true;
					}else if(strarrOperators[i].equals("AND")){
						useTree = true;
					}else throw new DBAppException("Operator '"+strarrOperators[i]+"' is not a valid operator");
				}else{
					if(strarrOperators[i-1].equals("AND")){
						if(!XORExist) useTree = true;
						else indexed[i] = useTree;
					}else if(strarrOperators[i-1].equals("OR") || strarrOperators[i-1].equals("XOR")){
						indexed[i] = useTree;
						XORExist = true;
					}else throw new DBAppException("Operator '"+strarrOperators[i-1]+"' is not a valid operator");
				}
			}else{
				if(i>0){
					if(strarrOperators[i-1].equals("OR") || strarrOperators[i-1].equals("XOR")) useTree = false;
					else if(!(strarrOperators[i-1].equals("AND")))
						 throw new DBAppException("Operator '"+strarrOperators[i-1]+"' is not a valid operator");
				}
			}
		}
		int from = -1;
		int to = -1;
		ArrayList<Object[]> o = new ArrayList<Object[]>();
		ArrayList<String> files = FindFiles(arrSQLTerms[0]._strTableName);
		if(useTree){
			for(int i=0;i<indexed.length;i++){		
				if(indexed[i]){
					int index =0;
					PairIndex p= h.get(arrSQLTerms[i]._strTableName).indexExists.get(arrSQLTerms[i]._strColumnName);
					ArrayList<Object[]> res2 = new ArrayList<Object[]>();
					if(arrSQLTerms[i].getClass().getName().equals("java.awt.Polygon")){
						//RTree if polygon
						RTreePairIndex bp = (RTreePairIndex) p;
						ArrayList<RTreeRefRecord> ref = new ArrayList<RTreeRefRecord>();
						switch(arrSQLTerms[i]._strOperator){
						case ">": ref = bp.rtree.search((Polygon)arrSQLTerms[i]._objValue,null,false,true);break;
						case ">=": ref = bp.rtree.search((Polygon)arrSQLTerms[i]._objValue,null,true,true);break;
						case "<":ref = bp.rtree.search(null,(Polygon)arrSQLTerms[i]._objValue,true,false);break;
						case "<=": ref = bp.rtree.search(null,(Polygon)arrSQLTerms[i]._objValue,true,true);break;
						case "=":ref = bp.rtree.search((Polygon)arrSQLTerms[i]._objValue);break;
						case "!=": ref =bp.rtree.notequal((Polygon)arrSQLTerms[i]._objValue);break;
						default: throw new DBAppException("Operator '"+arrSQLTerms[i]._strOperator+"' does not exist");
						}
						for(int j=0;j<ref.size();j++){
							FileInputStream file = new FileInputStream(files.get(ref.get(j).getPage()));
							ObjectInputStream in = new ObjectInputStream(file);
							Vector object1 = (Vector) in.readObject();
							in.close();
							file.close();
							Polygon p1 = (Polygon)((Object[]) (object1.get(ref.get(j).getIndexInPage())))[bp.colIndex];
							if((compareTToCoor(p1,(Polygon)arrSQLTerms[i]._objValue) && arrSQLTerms[i]._strOperator.equals("="))
									|| (!compareTToCoor(p1,(Polygon)arrSQLTerms[i]._objValue) && arrSQLTerms[i]._strOperator.equals("!="))
									|| arrSQLTerms[i]._strOperator.equals(">=") || arrSQLTerms[i]._strOperator.equals(">")
									|| arrSQLTerms[i]._strOperator.equals("<=") || arrSQLTerms[i]._strOperator.equals("<"))
								res2.add((Object[]) object1.get(ref.get(j).getIndexInPage()));
						}
					}else{
						BPTreePairIndex bp = (BPTreePairIndex) p;
						ArrayList<BPTreeRefRecord> ref = new ArrayList<BPTreeRefRecord>();
						switch(arrSQLTerms[i]._strOperator){
						case ">": ref = bp.btree.search((Comparable)arrSQLTerms[i]._objValue,null,false,true);break;
						case ">=": ref = bp.btree.search((Comparable)arrSQLTerms[i]._objValue,null,true,true);break;
						case "<":ref = bp.btree.search(null,(Comparable)arrSQLTerms[i]._objValue,true,false);break;
						case "<=": ref = bp.btree.search(null,(Comparable)arrSQLTerms[i]._objValue,true,true);break;
						case "=":ref = bp.btree.search((Comparable)arrSQLTerms[i]._objValue);break;
						case "!=": ref =bp.btree.notequal((Comparable)arrSQLTerms[i]._objValue);break;
						default: throw new DBAppException("Operator '"+arrSQLTerms[i]._strOperator+"' does not exist");
						}
						for(int j=0;j<ref.size();j++){
							FileInputStream file = new FileInputStream(files.get(ref.get(j).getPage()));
							ObjectInputStream in = new ObjectInputStream(file);
							Vector object1 = (Vector) in.readObject();
							in.close();
							file.close();
							res2.add((Object[]) object1.get(ref.get(j).getIndexInPage()));
						}
					}
						o = i==0?checkAndAdd(o, res2,null):checkAndAdd(o, res2,strarrOperators[i-1]);
						if(from>=0 && to>=0){
							o = checkAndAdd(strarrOperators, o, arrSQLTerms,from,to, colnum);
							from = -1;
							to = -1;
						}
					}
				else{
					if(i==0){
						from = 0;
						to = 0;
					}else{
						if(o.size()==0)to = i;
						else o = checkAndAdd(strarrOperators, o, arrSQLTerms,i,i, colnum);
					}
				}	
		}
		}else{
			boolean useCluster = false;
			XORExist = false;
			for(int i=0;i<clustered.length;i++){
				System.out.println(clustered[i]+"clustering"+arrSQLTerms[i]._strColumnName);
				if(clustered[i]){
					if(i==0){
						if(strarrOperators[i].equals("OR") || strarrOperators[i].equals("XOR")){
							clustered[i] = clustered[i+1];
							useCluster = clustered[i];
							i++;
							XORExist = true;
						}else if(strarrOperators[i].equals("AND")){
							useCluster = true;
						}else throw new DBAppException("Operator '"+strarrOperators[i]+"' is not a valid operator");
					}else{
						if(strarrOperators[i-1].equals("AND")){
							if(!XORExist)
								useCluster = true;
							else{
								clustered[i] = useCluster; 
							}
						}else if(strarrOperators[i].equals("OR") || strarrOperators[i].equals("XOR")){
							XORExist = true;
							clustered[i] = useCluster;
						}else throw new DBAppException("Operator '"+strarrOperators[i-1]+"' is not a valid operator");
					}
				}else{
					if(i>0){
						if(strarrOperators[i-1].equals("OR") || strarrOperators[i-1].equals("XOR")) useCluster = false;
						else if(!(strarrOperators[i-1].equals("AND")))
							 throw new DBAppException("Operator '"+strarrOperators[i-1]+"' is not a valid operator");
					}
				}
			}
			if(useCluster){
				//binary search
				for(int i=0;i<clustered.length;i++){
					if(clustered[i]){
						ArrayList<PPair> ranges = FindRange(arrSQLTerms[i]._strTableName);
						ArrayList<String> filesSelected =
								FindVectorSelect(files, ranges, arrSQLTerms[i]._objValue,arrSQLTerms[i]._strOperator);
						o = i==0?binarySearchSelect(o,filesSelected,arrSQLTerms[i],null):
							binarySearchSelect(o,filesSelected,arrSQLTerms[i],strarrOperators[i-1]);
						if(from>=0 && to>=0){
							o = checkAndAdd(strarrOperators, o, arrSQLTerms,from,to, colnum);
							from = -1;
							to = -1;
						}				
					}else{
						if(i==0){
							from = 0;
							to = 0;
						}else{
							if(o.size()==0){
								to = i;
							}else{
								o = checkAndAdd(strarrOperators, o, arrSQLTerms,i,i, colnum);
							}
						}
					}
				}
			}else{
				//linear search
				o = linearSearch(arrSQLTerms, strarrOperators, colnum);
			}
		}
		Iterator res = o.iterator();
		return res;	
	}
	/********************** End of main Methods to be implemented ***********************************/
	/******************** Helper methods for insert into table ***************************************/
	/**
	 *  To find in which page i should insert
	 * @param files the files of a specific table
	 * @param vr the ranges of each file of a table
	 * @param key the search key
	 * @param enteries the record we want to insert
	 * @param tablename table name
	 * @param Table table object that has the main info about the table
	 * @throws Exception 
	 */
	public static void FoundMyVector(ArrayList<String> files, ArrayList<PPair> vr, Object key, Object[] enteries,
			String tablename, Table Table,ArrayList<String> col) throws Exception {
		// If the table is empty
		// System.out.println(vr.toString()+" Inside");
		if (Table.numOfPages == 0) {
			insertRec(0, 0, enteries, files, tablename, Table,col);
			return;
		}

		// case one: If the inserted key is smaller than the smallest number in
		// the table
		if (compareTTo((vr.get(0).a), key) > 0) {
			int innerindex = BinarySearch(key, 0, files); // binary search is
			// the one that
			// opens the vector
			insertRec(0, innerindex, enteries, files, tablename, Table,col);
			return;
		}

		// Finding the index normally
		for (int i = 0; i < vr.size(); i++) {
			// System.out.println(vr.toString()+" Inside "+i);
			if ((compareTTo((vr.get(i).a), key) <= 0) && (compareTTo((vr.get(i).b), key) >= 0)) {
				int innerindex = BinarySearch(key, i, files);
				insertRec(i, innerindex, enteries, files, tablename, Table,col);
				return;
			} else if (compareTTo((vr.get(i).a), key) > 0) {
				int innerindex = BinarySearch(key, i - 1, files);
				insertRec(i - 1, innerindex, enteries, files, tablename, Table,col);
				return;
			}
		}

		// If the largest range is smaller than the key
		if (compareTTo((vr.get(vr.size() - 1).b), key) < 0) {
			FileInputStream f = new FileInputStream(files.get(files.size()-1));
			ObjectInputStream io = new ObjectInputStream(f);
			Vector v = (Vector) io.readObject();
			if(v.size()==n)
				insertRec(vr.size(), 0, enteries, files, tablename, Table,col);
			else
				insertRec(vr.size(), v.size()-1, enteries, files, tablename, Table,col);
			return;

		}
		return;
	}
	
	/**
	 * To know where we should insert the data inside a specific page
	 * @param key the clustering key of the inserted record
	 * @param indexv the index of the file we will insert in
	 * @param files the files of a specific table 
	 * @return the index we should insert a record inside the file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	public static int BinarySearch(Object key, int indexv, ArrayList<String> files)
			throws IOException, ClassNotFoundException {

		FileInputStream file = new FileInputStream(files.get(indexv));
		ObjectInputStream in = new ObjectInputStream(file);
		Vector v = (Vector) in.readObject();
		in.close();
		file.close();

		int h = v.size() - 1;
		int l = 0;
		int mid = l + (h - l) / 2;
		while (h >= l) {
			mid = l + (h - l) / 2;
			Object[] x = (Object[]) v.get(mid);
			if (compareTTo(x[0], key) <= 0)
				l = mid + 1;
			else
				h = mid - 1;
		}
		return mid;
	}
	
	/**
	 * inserts the new record to the correct file and handles the shifting of pages
	 * @param indexinfiles the index of the selected file
	 * @param indexinv the index of the new record in a file
	 * @param arrayOfData the record data
	 * @param files all files of a table
	 * @param TableName table name
	 * @param t has the main info about the table
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void insertRec(int indexinfiles, int indexinv, Object[] arrayOfData, ArrayList<String> files,
			String TableName, Table t,ArrayList<String> colNames) throws Exception {
		if (indexinfiles == files.size() && indexinv==0) {
			Vector<Object[]> v = new Vector<Object[]>();
			v.add(0, arrayOfData);

			t.InsertPairOfRanges(((Object[]) (v.firstElement()))[0], ((Object[]) (v.lastElement()))[0]);
			t.addPage();

			h.remove(t);
			h.put(t.name, t);

			FileOutputStream file1 = new FileOutputStream("..//Annabelle//data//" + t.name + t.GetLastId() + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(file1);
			out.writeObject(v);
			out.close();
			file1.close();
			for(int i=0;i<colNames.size();i++){
				PairIndex pi = t.indexExists.get(colNames.get(i));
				int colIndex=pi.colIndex;
					if(arrayOfData[colIndex].getClass().getName().equals("java.awt.Polygon")){
						RTreeRefRecord ref=new RTreeRefRecord(indexinfiles, 0);
						((RTreePairIndex)pi).rtree.insert((Polygon) arrayOfData[colIndex], ref);
					}else{
						BPTreeRefRecord ref=new BPTreeRefRecord(indexinfiles, 0);
						((BPTreePairIndex)pi).btree.insert((Comparable) arrayOfData[colIndex], ref);
					}
				}	 			
			FileOutputStream file2 = new FileOutputStream(
			"..//Annabelle//data//Tables.ser");
			ObjectOutputStream out2 = new ObjectOutputStream(file2);
			out2.writeObject(h);
			out2.close();
			file2.close();
			System.out.println("Awl marra");
			return;
		}
		System.out.println("Sa7");
		indexinfiles = indexinfiles==files.size()?indexinfiles-1:indexinfiles;
		FileInputStream file = new FileInputStream(files.get(indexinfiles));
		ObjectInputStream in = new ObjectInputStream(file);
		Vector object1 = (Vector) in.readObject();
		in.close();
		file.close();

		if (object1.size() == n) {
			System.out.println("8alat");
			Object[] array = (Object[]) object1.remove(object1.size() - 1);
////////////////////////////////// Index Case //////////////////////////////////////////////////
			for(int i=0;i<colNames.size();i++){
				PairIndex pi = t.indexExists.get(colNames.get(i));
				int colIndex=pi.colIndex;
				if(array[colIndex].getClass().getName().equals("java.awt.Polygon")){
					RTreeRefRecord ref=new RTreeRefRecord(indexinfiles, n-1);
					((RTreePairIndex)pi).rtree.delete((Polygon) array[colIndex], ref);
				}else{
					BPTreeRefRecord ref=new BPTreeRefRecord(indexinfiles, n-1);
					((BPTreePairIndex)pi).btree.delete((Comparable) array[colIndex], ref);
				}
			}
//////////////////////////////////Index Case //////////////////////////////////////////////////
			insertRec(indexinfiles + 1, 0, array, files, TableName, t,colNames);
		}
		System.out.println(indexinv);
		object1.add(indexinv, arrayOfData);
		insertNodes(colNames, indexinfiles, indexinv, arrayOfData, subListOf(object1, indexinv+1, object1.size()-1), t);
		t.updatepair(t.PagesRange.get(indexinfiles), ((Object[]) (object1.firstElement()))[0],
					((Object[]) (object1.lastElement()))[0]);
		FileOutputStream file2 = new FileOutputStream((String) files.get(indexinfiles));
		ObjectOutputStream out = new ObjectOutputStream(file2);
		out.writeObject(object1);
		out.close();
		file2.close();

		h.remove(t);
		h.put(TableName, t);

		FileOutputStream file3 = new FileOutputStream(
		"..//Annabelle//data//Tables.ser");
		ObjectOutputStream out2 = new ObjectOutputStream(file3);
		out2.writeObject(h);
		out2.close();
		file3.close();
	}
	
	public static void insertNodes(ArrayList<String> colNames,int indexinfiles,int indexinv,
			Object[] arrayOfData,ArrayList<Object[]> rv,Table t) throws Exception{
		for(int i=0;i<colNames.size();i++){
			PairIndex pi = t.indexExists.get(colNames.get(i));
			int colIndex=pi.colIndex;
			if(arrayOfData[colIndex].getClass().getName().equals("java.awt.Polygon")){
				RTreeRefRecord ref=new RTreeRefRecord(indexinfiles, indexinv);
				((RTreePairIndex)pi).rtree.insert((Polygon) arrayOfData[colIndex], ref);
			}else{
				BPTreeRefRecord ref=new BPTreeRefRecord(indexinfiles, indexinv);
				((BPTreePairIndex)pi).btree.insert((Comparable) arrayOfData[colIndex], ref);
			}
			for(int j=0;j<rv.size();j++){
				Object[] array2 = (Object[]) rv.get(j);
				if(array2[colIndex].getClass().getName().equals("java.awt.Polygon")){
					ArrayList<RTreeRefRecord> refList=((RTreePairIndex)pi).rtree.search((Polygon)array2[colIndex]);
					if(refList==null){
						((RTreePairIndex)pi).rtree.insert((Polygon)array2[colIndex],new RTreeRefRecord(0, 0));
					}else{
						for(int k=0;k<refList.size();k++) {
							RTreeRefRecord rp = refList.get(k);
							if(rp.getIndexInPage()==j && rp.getPage()==indexinfiles){
								try{
									((RTreePairIndex)pi).rtree.delete((Polygon)array2[colIndex],rp);
								}catch(FileNotFoundException e){}
								rp.setIndexInPage(j+1+indexinv);
								((RTreePairIndex)pi).rtree.insert((Polygon)array2[colIndex],rp);
							}
						}
					}
				}
				else{
					ArrayList<BPTreeRefRecord> refList=((BPTreePairIndex)pi).btree.search((Comparable)array2[colIndex]);
					if(refList==null){
						((BPTreePairIndex)pi).btree.insert((Comparable)array2[colIndex],new BPTreeRefRecord(0, 0));
					}else{
						for(int k=0;k<refList.size();k++) {
							BPTreeRefRecord rp = refList.get(k);
							if(rp.getIndexInPage()==j && rp.getPage()==indexinfiles){
								try{
									((BPTreePairIndex)pi).btree.delete((Comparable)array2[colIndex],rp);
								}catch(FileNotFoundException e){}
								rp.setIndexInPage(j+1+indexinv);
								((BPTreePairIndex)pi).btree.insert((Comparable)array2[colIndex],rp);
							}
						}
					}
				}
			}
		}
	}
	
	
	/******************** End of helper methods for insert into table ***************************************/
	/*************************** Helper methods for update table ****************************************/
	/**
	 * gets the index of the columns to be updated
	 * @param files filenames of a table that may have the records
	 * @param enteries the updated values of the columns 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<Object[]>  BinarySearchUpdate(ArrayList<String> files, Object[] enteries,
			ArrayList<String> allFiles) throws IOException, ClassNotFoundException {
		ArrayList<Object[]> ref = new ArrayList<Object[]>();
		for (int i = 0; i < files.size(); i++) {
			FileInputStream file = new FileInputStream(files.get(i));
			ObjectInputStream in = new ObjectInputStream(file);
			Vector v = (Vector) in.readObject();
			in.close();
			file.close();
			
			int left = getLeftIndex(v, -1, v.size()-1, enteries[0]);
			int right = getRightIndex(v, 0, v.size(), enteries[0]);
			for(int j=left;j<=right;j++){
				Object[] r = new Object[enteries.length+1];
				if(enteries[0].getClass().getName().equals("java.awt.Polygon"))
					r[0] = new RTreeRefRecord(allFiles.indexOf(files.get(i)), j);
				else
					r[0] = new BPTreeRefRecord(allFiles.indexOf(files.get(i)), j);
				for (int k = 1; k < r.length; k++) {
					if (enteries[k-1] != null){
						r[k] = ((Object[]) (v.get(j)))[k-1];
						((Object[]) (v.get(j)))[k-1] = enteries[k-1];
					}
				}
				ref.add(r);
				FileOutputStream file2 = new FileOutputStream(files.get(i));
				ObjectOutputStream out = new ObjectOutputStream(file2);
				out.writeObject(v);
				out.close();
				file2.close();
			}
		}
		return ref;
	}

	/**
	 * To find the vector that has the records to be updated
	 * @param files file names of a table
	 * @param ranges ranges of those files according to the clustering key
	 * @param t has the main info of the table
	 * @param key the search key
	 * @return
	 */
	public static ArrayList<String> FindVectorUpdate(ArrayList<String> files, ArrayList<PPair> ranges, Table t,
			Object key) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < ranges.size(); i++) {
			if ((compareTTo(key, (ranges.get(i).a)) >= 0) && (compareTTo(key, (ranges.get(i).b)) <= 0)) {
				res.add(files.get(i));
			}
		}
		return res;
	}
	
	/**
	 * updates the records in all the RefRecords
	 * @param r array list of RefRecords representing pointers to the records that should be updated
	 * @param enteries the new values of the records
	 * @param allFiles the list of all files in a table
	 * @return array list of the pointers of all the old values of the records
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<Object[]> updateRecords(ArrayList<BPTreeRefRecord> r,
			Object[] enteries,ArrayList<String> allFiles) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Object[]> ref = new ArrayList<Object[]>();
		for(int i=0;i<r.size();i++){
			String f = allFiles.get(r.get(i).getPage());
			FileInputStream file = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(file);
			Vector<Object[]> v = (Vector<Object[]>) in.readObject();
			in.close();
			file.close();
			
			Object[] o = new Object[enteries.length];
			o[0] = r.get(i);
			for (int k = 0; k < enteries.length-1; k++) {
				if (enteries[k] != null){
					o[k+1] = ((Object[]) (v.get(r.get(i).getIndexInPage())))[k];
					((Object[]) (v.get(r.get(i).getIndexInPage())))[k] = enteries[k];
				}
			}
			ref.add(o);
			FileOutputStream file2 = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(file2);
			out.writeObject(v);
			out.close();
			file2.close();
		}
		return ref;
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<Object[]> updateRecord(ArrayList<RTreeRefRecord> r,
			Object[] enteries,ArrayList<String> allFiles) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Object[]> ref = new ArrayList<Object[]>();
		for(int i=0;i<r.size();i++){
			String f = allFiles.get(r.get(i).getPage());
			FileInputStream file = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(file);
			Vector<Object[]> v = (Vector<Object[]>) in.readObject();
			in.close();
			file.close();
			if(compareTToCoor((Polygon)((Object[])(v.get(r.get(i).getIndexInPage())))[0],(Polygon)enteries[0])){
				Object[] o = new Object[enteries.length];
				o[0] = r.get(i);
				for (int k = 0; k < enteries.length-1; k++) {
					if (enteries[k] != null){
						o[k+1] = ((Object[]) (v.get(r.get(i).getIndexInPage())))[k];
						((Object[]) (v.get(r.get(i).getIndexInPage())))[k] = enteries[k];
					}
				}
				ref.add(o);
				FileOutputStream file2 = new FileOutputStream(f);
				ObjectOutputStream out = new ObjectOutputStream(file2);
				out.writeObject(v);
				out.close();
				file2.close();
			}
		}
		return ref;
	}
	/******************** End of helper methods for update table ********************************************/
	/********************* Helper methods for select from table ***************************************/
	/**
	 * it does a linear search of a sub-query
	 * @param q the parameters of a specific sub-query
	 * @param result the result so far of the previous sub-queries
	 * @param op the logical operator
	 * @param colnum the column index in the table
	 * @return the result so far after this sub-query
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws DBAppException
	 */
	@SuppressWarnings("rawtypes")
	private static ArrayList<Object[]> linearSearch(SQLTerm[] q,String[] op,int[] colnum)
			throws ClassNotFoundException, IOException, DBAppException{
		ArrayList<String> filenames = FindFiles(q[0]._strTableName);
		ArrayList<Object[]> result2 = new ArrayList<Object[]>();
		for(int i=0;i<filenames.size();i++){
			FileInputStream file = new FileInputStream(filenames.get(i));
			ObjectInputStream in = new ObjectInputStream(file);
			Vector v = (Vector) in.readObject();
			in.close();
			file.close();
				for(int j=0;j<v.size();j++){
					Object[] o = (Object[])v.get(j);
					boolean shouldBeAdded = false;
					boolean couldBeAdded = false;
					for(int k=0;k<q.length;k++){
						if(q[k]._objValue.getClass().getName().equals("java.awt.Polygon")){
							if(q[k]._strOperator.equals("=")){
								if(compareTToCoor((Polygon)o[colnum[k]],(Polygon)q[k]._objValue))couldBeAdded = true ;
								else couldBeAdded = false;
							}else if(q[k]._strOperator.equals("!=")){
								if(!compareTToCoor((Polygon)o[colnum[k]],(Polygon)q[k]._objValue))couldBeAdded = true ;
								else couldBeAdded = false;
							}
						}
						else{
							switch (q[k]._strOperator){
							case">=":if(compareTTo(o[colnum[k]],q[k]._objValue)>=0)couldBeAdded = true;
									else couldBeAdded = false;break;
							case">":if(compareTTo(o[colnum[k]],q[k]._objValue)>0)couldBeAdded = true ;
									else couldBeAdded = false;break;
							case"<=":if(compareTTo(o[colnum[k]],q[k]._objValue)<=0)couldBeAdded = true ;
									else couldBeAdded = false;break;
							case"<":if(compareTTo(o[colnum[k]],q[k]._objValue)<0)couldBeAdded = true ;
									else couldBeAdded = false;break;
							case"!=":if(compareTTo(o[colnum[k]],q[k]._objValue)!=0)couldBeAdded = true ;
									else couldBeAdded = false;break;
							case"=":if(compareTTo(o[colnum[k]],q[k]._objValue)==0)couldBeAdded = true ;
									else couldBeAdded = false;break;
							default: throw new DBAppException("Invalid Arithmetic Operator '"+q[k]._strOperator+"'");
							}
						}
						if(k>0){
							if(op[k-1].equals("AND")){
								if(shouldBeAdded && !couldBeAdded) shouldBeAdded = false;
							}else if(op[k-1].equals("OR")){
							    if(shouldBeAdded || couldBeAdded) shouldBeAdded = true;
							}
							else if(op[k-1].equals("XOR")){
								if((shouldBeAdded && !couldBeAdded)||(!shouldBeAdded && couldBeAdded))
									shouldBeAdded = true; else shouldBeAdded = false;
							}else
								throw new DBAppException("Invalid Arithmetic Operator '"+op[k-1]+"'");
						}else{
							if(op[k].equals("AND")){
								if(shouldBeAdded && !couldBeAdded) shouldBeAdded = false;
							}else if(op[k].equals("OR")){
							    if(shouldBeAdded || couldBeAdded) shouldBeAdded = true;
							}
							else if(op[k].equals("XOR")){
								if((shouldBeAdded && !couldBeAdded)||(!shouldBeAdded && couldBeAdded))
									shouldBeAdded = true; else shouldBeAdded = false;
							}else
								throw new DBAppException("Invalid Arithmetic Operator '"+op[k-1]+"'");
						}
					}
					if(shouldBeAdded) result2.add(o);
				}
		}
		return result2;
	}
	/**
	 * it does a logical operation between two array list of results
	 * @param result the result so far
	 * @param result2 the new results
	 * @param op the logical operator
	 * @return the new result
	 * @throws DBAppException
	 */
	private static ArrayList<Object[]> checkAndAdd(ArrayList<Object[]> result,
			ArrayList<Object[]> result2, String op) throws DBAppException {
		// TODO Auto-generated method stub
		ArrayList<Object[]> result3 = new ArrayList<Object[]>();
		boolean OR = false;
		if(op!=null){
			if(result.size()==0){
				if(op.equals("AND")) return result3;
				else if(op.equals("OR")) return result2;
			}
			for(int i=0;i<result.size();i++){
				if(op.equals("AND")){
					if(containRes(result.get(i),result2)) result3.add(result.get(i));
				}else if(op.equals("OR")){
					if(!OR){
						OR = true;
						result3.addAll(result2);
					}
					if(!(containRes(result.get(i),result3))) result3.add(result.get(i));
					
				}else if(op.equals("XOR")){
					if(!(containRes(result.get(i),result2))) result3.add(result.get(i));
				}else{
					throw new DBAppException("Invalid Arithmetic Operator '"+op+"'");
				}	
			}
			if(op.equals("XOR")){
				for(int i=0;i<result2.size();i++){
					if(!(containRes(result2.get(i),result))) result3.add(result2.get(i));
				}
			}
		}else{
			return result2;
		}
		return result3;
	}
	private static boolean containRes(Object[] objects,
			ArrayList<Object[]> result2) {
		for(int i=0;i<result2.size();i++){
			boolean recFound = true;
			for(int j=0;j<objects.length && recFound;j++){
				if(objects[j].getClass().getName().equals("java.awt.Polygon")){
					if(!(compareTToCoor((Polygon)objects[j], (Polygon)result2.get(i)[j]))) recFound = false;
				}
				else{
					if(!(compareTTo(objects[j], result2.get(i)[j])==0)) recFound = false;
				}
			}
			if(recFound) return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Gets the files that may have the results of a sub-query by doing binary search on the ranges of those files
	 * @param files all the filename of a specific table 
	 * @param ranges all the ranges of each file according to the clustering key
	 * @param key the key we do the search by
	 * @param op the operator that used in the query
	 * @return the files that may have the results of the sub-query
	 * @throws DBAppException
	 */
	public static ArrayList<String> FindVectorSelect(ArrayList<String> files, ArrayList<PPair> ranges,
			Object key,String op) throws DBAppException {
		ArrayList<String> res = new ArrayList<String>();
		int h = ranges.size()-1;
		int l =0;
		int mid = l+(h-l)/2; 
		int index = -1;
		 while(h-l>1) {
			 if(op.equals(">")){
				 if(compareTTo(ranges.get(mid).b,key)<=0) l = mid+1;
				 else{h=mid-1;index=mid;}
			 }else if(op.equals(">=")){
				 if(compareTTo(ranges.get(mid).b,key)<0) l = mid+1;
				 else{h=mid-1;index=mid;}
			 }else if(op.equals("<")){
				 if(compareTTo(ranges.get(mid).a,key)>=0) h = mid-1;
				 else{l=mid+1;index=mid;}
			 }else if(op.equals("<=")){
				 if(compareTTo(ranges.get(mid).a,key)>0) h = mid-1;
				 else{l=mid+1;index=mid;}
			 }
		 }
			 if(op.equals("=")){
				 int leftIndex = getLeftIndex(ranges, -1,ranges.size()-1, key);
				 int rightIndex = getRightIndex(ranges, 0,ranges.size(), key);
				 return (compareTTo(ranges.get(leftIndex).a,key)>0||compareTTo(ranges.get(rightIndex).b, key)<0)?null
						 :subListOf(files,leftIndex, rightIndex);
			 }else if(op.equals("!=")){
				 //special case
				 int leftIndex = getLeftIndex(ranges, -1,ranges.size()-1, key);
				 int rightIndex = getRightIndex(ranges, 0,ranges.size(), key);
				 for(int i=leftIndex;i<=rightIndex;i++){
					 if(!(compareTTo(ranges.get(i).a,key)==0&&compareTTo(ranges.get(i).b,key)==0)) res.add(files.get(i));
				 }
				 return res;
			 }else if(op.equals(">=") || op.equals(">")){
				 return subListOf(files,index, ranges.size()-1);
			 }else if(op.equals("<=")||op.equals("<")){
				 return subListOf(files,0, index);
			 }
		
		return null;
	}
	private static ArrayList<String> subListOf(ArrayList<String> files,
			int leftIndex, int rightIndex) {
		ArrayList<String> res = new ArrayList<String>();
		for(int i=leftIndex;i<=rightIndex;i++){
			res.add(files.get(i));
		}
		// TODO Auto-generated method stub
		return res;
	}
	/**
	 * Finds the result of a specific sub-query in all the selected files
	 * @param o the array list of arrays of objects representing the results of the query so far 
	 * @param filesSelected the files that have the results of the sub-query
	 * @param sqlTerm the parameters of a sub-query
	 * @param operator the logical operator
	 * @return the result of the executing queries so far
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws DBAppException
	 */
	@SuppressWarnings("unchecked")
	private static ArrayList<Object[]> binarySearchSelect(ArrayList<Object[]> o,
			ArrayList<String> filesSelected, SQLTerm sqlTerm,String operator) throws ClassNotFoundException, IOException, DBAppException {
		// TODO Auto-generated method stub
		ArrayList<Object[]> res = new ArrayList<Object[]>();
		if(sqlTerm._strOperator.equals(">=") || sqlTerm._strOperator.equals(">")||
				sqlTerm._strOperator.equals("=")){
			res = FindFirstIndex(sqlTerm._strOperator,filesSelected.get(0),sqlTerm._objValue);
			for(int i=1;i<filesSelected.size();i++){
				if(i==filesSelected.size()-1 && sqlTerm._strOperator.equals("=")){
					res.addAll(FindFirstIndex(sqlTerm._strOperator,filesSelected.get(i),sqlTerm._objValue));
				}
				else{
					FileInputStream file = new FileInputStream(filesSelected.get(i));
					ObjectInputStream in = new ObjectInputStream(file);
					Vector<Object[]> v = (Vector<Object[]>) in.readObject();
					in.close();
					file.close();
					res.addAll(subListOf(v,0, v.size()-1));
				}
			}
		}else if(sqlTerm._strOperator.equals("<=") || sqlTerm._strOperator.equals("<")){
			res =  FindFirstIndex(sqlTerm._strOperator,filesSelected.get(filesSelected.size()-1),sqlTerm._objValue);
			for(int i=filesSelected.size()-2;i>=0;i--){
				FileInputStream file = new FileInputStream(filesSelected.get(i));
				ObjectInputStream in = new ObjectInputStream(file);
				Vector<Object[]> v = (Vector<Object[]>) in.readObject();
				in.close();
				file.close();
				res.addAll(subListOf(v,0, v.size()-1));
			}
		}else if(sqlTerm._strOperator.equals("!=")){
			for(int i=0;i<filesSelected.size();i++){
				res.addAll(FindFirstIndex(sqlTerm._strOperator,filesSelected.get(i),sqlTerm._objValue));
			}
			ArrayList<String> allFiles = FindFiles(sqlTerm._strTableName);
			for(int i=0;i<allFiles.size();i++){
				if(!(filesSelected.contains(allFiles.get(i)))){
					FileInputStream file = new FileInputStream(allFiles.get(i));
					ObjectInputStream in = new ObjectInputStream(file);
					Vector<Object[]> v = (Vector<Object[]>) in.readObject();
					in.close();
					file.close();
					res.addAll(subListOf(v,0, v.size()-1));
				}
			}
		}
		return res;
	}
	
	/**
	 * Gets the results of a sub-query of a specific file
	 * @param _strOperator the arithmetical operator used in a specific query for a specific column
	 * @param fileSearch the file we do a binary search in
	 * @param object the key of the search
	 * @return arrayList of results of this sub-query
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static ArrayList<Object[]> FindFirstIndex(String _strOperator, String fileSearch,
			Object object) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream(fileSearch);
		ObjectInputStream in = new ObjectInputStream(file);
		Vector v = (Vector) in.readObject();
		in.close();
		file.close();

		int h = v.size() - 1;
		int l = 0;
		int index = -1;
		int mid = l + (h - l) / 2;
		if(_strOperator.equals(">=")||_strOperator.equals(">")||_strOperator.equals("<=")||_strOperator.equals("<")){
			while (h >= l) {
				mid = l + (h - l) / 2;
				Object[] x = (Object[]) v.get(mid);
				if(_strOperator.equals(">=")){
					if (compareTTo(x[0], object) < 0)
						l = mid + 1;
					else if (compareTTo(x[0], object) >= 0){
						h = mid - 1;
						index = mid;
					}
				}else if(_strOperator.equals(">")){
					if (compareTTo(x[0], object) <= 0)
						l = mid + 1;
					else if (compareTTo(x[0], object) > 0){
						h = mid - 1;
						index = mid;
					}
				}else if(_strOperator.equals("<=")){
					if (compareTTo(x[0], object) > 0)
						h = mid - 1;
					else if (compareTTo(x[0], object) <= 0){
						l = mid + 1;
						index = mid;
					}
				}else if(_strOperator.equals("<")){
					if (compareTTo(x[0], object) >= 0)
						h = mid - 1;
					else if (compareTTo(x[0], object) < 0){
						l = mid + 1;
						index = mid;
					}
				}
			}
		}
		if(_strOperator.equals("=")){
			int rightIndex = getRightIndex(v, 0, v.size(), object);
			int leftIndex = getLeftIndex(v, -1, v.size()-1, object);
			return (compareTTo(((Object[])(v.get(leftIndex)))[0],object)==0 &&
					compareTTo(((Object[])(v.get(rightIndex)))[0],object)==0)? subListOf(v,leftIndex, rightIndex):null;
		///////////////////////////////////////////////////////////////
		}else if(_strOperator.equals("!=")){
			int rightIndex = getRightIndex(v, 0, v.size(), object);
			int leftIndex = getLeftIndex(v, -1, v.size()-1, object);
			ArrayList<Object[]> res = subListOf(v,0, leftIndex);
			res.addAll(subListOf(v,rightIndex+1, v.size()-1));
			return res;
		}
		//////////////////////////////////////////////////////////////
		if(_strOperator.equals(">")||_strOperator.equals(">="))
			return subListOf(v,index, v.size()-1);
		else if(_strOperator.equals("<")||_strOperator.equals("<="))
			return subListOf(v,0, index);
		return null;
	}
	
	private static ArrayList<Object[]> subListOf(Vector v, int leftIndex,
			int rightIndex) {
		// TODO Auto-generated method stub
		ArrayList<Object[]> res = new ArrayList<Object[]>();
		for(int i=leftIndex;i<=rightIndex;i++){
			res.add((Object[]) v.get(i));
		}
		return res;
	}
	/**
	 * Gets the rightmost index of the last occurrence of a specific key in a vector of arrays of objects
	 * The approach is that when we find a value that is <= the key, we shift the leftmost index till it
	 * reaches the index of the last occurrence of the key in the vector 
	 * @param v the vector of arrays of objects
	 * @param l the leftmost index
	 * @param r the rightmost index
	 * @param key the search key
	 * @return index of the last occurrence of a specific key
	 */
	private static int getRightIndex(Vector<Object[]> v, int l, int r, Object key) 
	{ 
	    int m; 
	    while( r - l > 1 ) 
	    { 
	        m = l + (r - l)/2; 
	  
	        if(key.getClass().getName().equals("java.awt.Polygon")){
		        if( compareTToCoor((Polygon)v.get(m)[0],(Polygon)key)) 
		            l = m; 
		        else
		            r = m; 
	        }else{
		        if( compareTTo(v.get(m)[0],key)<=0 ) 
		            l = m; 
		        else
		            r = m; 
	        }
	    } 	  
	    return l; 
	} 
	/**
	 * Gets the last index of the probability of the last occurrence of a specific key in an array of PPairs
	 * The approach is that it shifts the left index once it finds a range that the key is in
	 * @param p the arrayList of PPairs that we want to search in
	 * @param l the leftmost index
	 * @param r the rightmost index
	 * @param key the key we search for
	 * @return the index of the rightmost index
	 */
	private static int getRightIndex(ArrayList<PPair> p, int l, int r, Object key) 
	{ 
	    int m; 
	    while( r - l > 1 ) 
	    { 
	        m = l + (r - l)/2; 
	  
	        if( compareTTo(p.get(m).a,key)<=0 && compareTTo(p.get(m).b,key)>=0) 
	            l = m; 
	        else
	            r = m; 
	    } 	  
	    return l; 
	} 
	  
	/**
	 * Gets the leftmost index of the first occurrence of a specific key in a vector of arrays of objects
	 * The approach is that when we find a value that is >= the key, we shift the rightmost index till it
	 * reaches the index of the first occurrence of the key in the vector 
	 * @param v the vector of arrays of objects
	 * @param l the leftmost index
	 * @param r the rightmost index
	 * @param key the search key
	 * @return index of the first occurrence of a specific key
	 */
	private static int getLeftIndex(Vector<Object[]> v, int l, int r, Object key) 
	{ 
	    int m; 
	    while( r - l > 1 ) 
	    { 
	        m = l + (r - l)/2; 
	        if(key.getClass().getName().equals("java.awt.Polygon")){
		        if( compareTToCoor((Polygon)v.get(m)[0],(Polygon)key)) 
		            r = m; 
		        else
		            l = m; 
	        }else{
		        if( compareTTo(v.get(m)[0],key)>=0 ) 
		            r = m; 
		        else
		            l = m; 
	        }
	    }   
	    return r; 
	}
	/**
	 * Gets the first index of the probability of the first occurrence of a specific key in an array of PPairs
	 * The approach is that it shifts the right index once it finds a range that the key is in
	 * @param p the arrayList of PPairs that we want to search in
	 * @param l the leftmost index
	 * @param r the rightmost index
	 * @param key the key we search for
	 * @return the index of the leftmost index
	 */
	private static int getLeftIndex(ArrayList<PPair> p, int l, int r, Object key) 
	{ 
	    int m; 
	    while( r - l > 1 ) 
	    { 
	        m = l + (r - l)/2; 
	  
	        if( compareTTo(p.get(m).a,key)<=0 && compareTTo(p.get(m).b,key)>=0 ) 
	            r = m; 
	        else
	            l = m; 
	    }   
	    return r; 
	}
	
	private static ArrayList<Object[]> checkAndAdd(String[] lOp,ArrayList<Object[]> oldRes,
			SQLTerm[] sql,int from,int to,int[] colNum) throws DBAppException{
		for(int j=from;j<=to;j++){
				oldRes = toCheck(oldRes,sql[j],colNum[j],lOp[to-1]);
				if(j>0){
					oldRes = toCheck(oldRes,sql[j],colNum[j],lOp[j-1]);
				}
		}
		return oldRes;
	}
	private static ArrayList<Object[]> toCheck(ArrayList<Object[]> oldRes,
			SQLTerm sql, int j, String _strOperator) throws DBAppException {
		// TODO Auto-generated method stub
		for(int i=0;i<oldRes.size();i++){
			if(_strOperator.equals("AND")){
				switch(sql._strOperator){
				case">":if(!(compareTTo(oldRes.get(i)[j],sql._objValue)>0)) oldRes.remove(i);break;
				case">=":if(!(compareTTo(oldRes.get(i)[j],sql._objValue)>=0)) oldRes.remove(i);break;
				case"<":if(!(compareTTo(oldRes.get(i)[j],sql._objValue)<0)) oldRes.remove(i);break;
				case"<=":if(!(compareTTo(oldRes.get(i)[j],sql._objValue)<=0)) oldRes.remove(i);break;
				case"!=":if(!(compareTTo(oldRes.get(i)[j],sql._objValue)!=0)) oldRes.remove(i);break;
				case"=":if(!(compareTTo(oldRes.get(i)[j],sql._objValue)==0)) oldRes.remove(i);break;
				default: throw new DBAppException("Operator '"+sql._strOperator+"' is not valid");
				}
			}else if(_strOperator.equals("OR")){
				return oldRes;
			}else if(_strOperator.equals("XOR")){
				switch(sql._strOperator){
				case">":if((compareTTo(oldRes.get(i)[j],sql._objValue)>0)) oldRes.remove(i);break;
				case">=":if((compareTTo(oldRes.get(i)[j],sql._objValue)>=0)) oldRes.remove(i);break;
				case"<":if((compareTTo(oldRes.get(i)[j],sql._objValue)<0)) oldRes.remove(i);break;
				case"<=":if((compareTTo(oldRes.get(i)[j],sql._objValue)<=0)) oldRes.remove(i);break;
				case"!=":if((compareTTo(oldRes.get(i)[j],sql._objValue)!=0)) oldRes.remove(i);break;
				case"=":if((compareTTo(oldRes.get(i)[j],sql._objValue)==0)) oldRes.remove(i);break;
				default: throw new DBAppException("Operator '"+sql._strOperator+"' is not valid");
				}
			}
			else throw new DBAppException("Not valid operator "+_strOperator);
		}
		return oldRes;
	}
	/******************************* End of helper methods for select from table ***************************************/
	/************************************* General helper methods *****************************************************/
	/**
	 *  To compare according to each type
	 * @param elem the first element
	 * @param key the second element 
	 * @return an integer representing the result of the comparison
	 */
	public static int compareTTo(Object elem, Object key) {

		if (key instanceof String)
			return (((String) elem).compareTo(((String) key)));
		if (key instanceof Integer) {
			Integer i = (Integer) elem;
			Integer j = (Integer) key;
			return i.compareTo(j);
		}
		if (key instanceof Double) {
			Double a = (Double) elem;
			Double b = (Double) key;
			return (Double.compare(a, b));
		}
		if (key instanceof Date)
			return (((Date) elem).compareTo(((Date) key)));
		if (key instanceof Polygon) {
			Polygon a = (Polygon) elem;
			Polygon b = (Polygon) key;
			Dimension dim1 = a.getBounds().getSize();
			Dimension dim2 = b.getBounds().getSize();
			int nThisAreap1 = dim1.width * dim1.height;
			int nThisAreap2 = dim2.width * dim2.height;

			return (nThisAreap1 - nThisAreap2);
		}
		if (key instanceof Boolean) {
			boolean elem1 = (Boolean) elem;
			boolean key1 = (Boolean) key;
			if (elem1 == false)
				if (key1 == false)
					return 0;
				else
					return -1;
			else if (key1 == true)
				return 0;
			else
				return 1;
		}
		return 0;
	}

	/**
	 * To get the path of the pages of a specific table
	 * @param tablename table name we want to get its file names
	 * @return array list of file paths representing the pages
	 */
	public static ArrayList<String> FindFiles(String tablename) {
		Table t = h.get(tablename);
		ArrayList<Integer> ids = t.pagesId;
		ArrayList<PPair> Ranges = t.PagesRange;
		ArrayList<String> filenames = new ArrayList<String>();
		// ArrayList<String> filenamesWithRanges = new ArrayList<String>(); // ??
		for (int i = 0; i < ids.size(); i++) {
			filenames.add("..//Annabelle//data//" + tablename + ids.get(i) + ".ser");// complete path "student0"
		}
		return filenames;
	}

	/**
	 * To get the ranges of the pages of a specific table
	 * @param strtablename the table name we want to get its range
	 * @return array list or PPiar representing the ranges of every page in a specific table
	 */
	public static ArrayList<PPair> FindRange(String strtablename) {
		Table t = h.get(strtablename);
		return t.PagesRange;
	}

	/**
	 * To get the maximum number of rows from the configuration file
	 * @param string 
	 * @return the maximum number of rows in a page
	 * @throws IOException
	 */
	public int readingFromConfigFile(String string) throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("..\\Annabelle\\config\\DBApp.properties");
		prop.load(ip);
		return Integer.parseInt(prop.getProperty(string));
	}

	/**
	 * checks the type of a key and parse it to the correct type
	 * @param type key type
	 * @param key key value
	 * @return the parsed key
	 * @throws DBAppException
	 */
	public static Object parseCheckKey(String type, String key) throws DBAppException {
		Object o = null;
		if (type.equals("java.lang.Integer")) {
			try {
				o = Integer.parseInt(key);
			} catch (Exception e) {
				throw new DBAppException("Incompitable types");
			}
		} else if (type.equals("java.lang.Double")) {
			try {
				o = Double.parseDouble(key);
			} catch (Exception e) {
				throw new DBAppException("Incompitable types");
			}
		} else if (type.equals("java.lang.Boolean")) {
			try {
				o = Boolean.parseBoolean(key);
			} catch (Exception e) {
				throw new DBAppException("Incompitable types");
			}
		} else if (type.equals("java.lang.String")) {
			o = key;
		} else if (type.equals("java.util.Date")) {
			try {

				String datestring = key;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date2 = sdf.parse(datestring);
				o=date2;

			} catch (Exception e) {
				throw new DBAppException("Incompitable types");
			}
		} else if (type.equals("java.awt.Polygon")) {
			try {
				StringTokenizer s1 = new StringTokenizer(key, "(,)");
				ArrayList<Integer> x = new ArrayList<Integer>();
				ArrayList<Integer> y = new ArrayList<Integer>();
				int n = 0;
				while (s1.hasMoreElements()) {
					x.add(Integer.parseInt(s1.nextToken()));
					y.add(Integer.parseInt(s1.nextToken()));
					n++;
				}
				int[] xp = new int[n];
				int[] yp = new int[n];
				for (int j = 0; j < n; j++) {
					xp[j] = x.get(j);
					yp[j] = y.get(j);
				}
				o = new Polygon(xp, yp, n);
			} catch (Exception e) {
				throw new DBAppException("Incompitable types");
			}
		}else{
			throw new DBAppException("Type Does not exist");
		}

		return o;
	}

	public static int getCSVSize() throws IOException {
		int i = 0;
		try {
			FileReader fr2 = new FileReader("..//Annabelle//data//metadata.csv");
			BufferedReader br = new BufferedReader(fr2);
			while (br.readLine()!=null) {
				i++;
			}
			br.close();
			fr2.close();
		}catch(IOException e) {
			FileWriter fr = new FileWriter("..//Annabelle//data//metadata.csv");
			BufferedWriter br2 = new BufferedWriter(fr);
			String d = "Table Name, Column Name, Column Type, ClusteringKey, Indexed";
			br2.write(d);
			br2.close();
			fr.close();
			return 1;
		}
		return i;
	}
	
	private boolean checkType(String string) {
		if(string.equals("java.lang.Integer")||string.equals("java.lang.String")||string.equals("java.lang.Double")||
				string.equals("java.lang.Boolean")||string.equals("java.awt.Polygon")||string.equals("java.util.Date")){
			return true;
		}

		return false;
	}
	
	/**
	 * To get the number of columns in a specific table
	 * @param tablename the name of the associated table
	 * @return the number of the columns in the associated table
	 * @throws IOException
	 */
	public int getSize(String tablename) throws IOException {
		int i = 0;
		FileReader fr2 = new FileReader("..//Annabelle//data//metadata.csv");
		BufferedReader br = new BufferedReader(fr2);
		br.readLine();
		while (br.ready()) {
			String line = br.readLine();

			String[] metadata = (line).split(", ");

			if (metadata[0].equals(tablename)) {
				i++;
			}
		}
		return i;
	}
	
	public static boolean compareTToCoor(Polygon p1,Polygon p2){
		for(int i=0;i<p1.xpoints.length;i++){
			boolean equal = false;
			two:for(int j=0;j<p2.xpoints.length;j++){
				if(p1.xpoints[i]==p2.xpoints[j] && p1.ypoints[i]==p2.ypoints[j]) {equal = true;break two;}
			}
			if(!equal) return false;
		}
		return true;
	}
	/********************************* End of general Helper methods ***************************************/
}