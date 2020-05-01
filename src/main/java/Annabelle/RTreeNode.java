package Annabelle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class RTreeNode implements Serializable {

	/**
	 * Abstract class that collects the common functionalities of the inner and leaf
	 * nodes
	 */
	private static final long serialVersionUID = 1L;
	protected Comparable[] keys;
	protected int numberOfKeys;
	protected int order;
	protected int index; // for printing the tree
	private boolean isRoot;
	private static int nextIdx = 0;
	String filename;
	String tablename;
	String columnname;

	public RTreeNode(int order, String tablename, String columnname) throws Exception {
		this.tablename = tablename;
		this.columnname = columnname;
		
		index = nextIdx++;
		filename = "..//Annabelle//data//"+tablename + columnname + index + ".ser";

		numberOfKeys = 0;
		this.order = order;
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(this);
		out.close();
		file.close();
		
	}

	/**
	 * @return a boolean indicating whether this node is the root of the B+ tree
	 */
	public boolean isRoot() {
		return isRoot;
	}

	/**
	 * set this node to be a root or unset it if it is a root
	 * 
	 * @param isRoot the setting of the node
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void setRoot(boolean isRoot) throws ClassNotFoundException, IOException {
		this.isRoot = isRoot;
		refresh();
	}

	/**
	 * find the key at the specified index
	 * 
	 * @param index the index at which the key is located
	 * @return the key which is located at the specified index
	 */
	public Comparable getKey(int index) {
		return keys[index];
	}

	/**
	 * sets the value of the key at the specified index
	 * 
	 * @param index the index of the key to be set
	 * @param key   the new value for the key
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void setKey(int index, Comparable key) throws ClassNotFoundException, IOException {
		keys[index] = key;
		refresh();
	}

	/**
	 * @return a boolean whether this node is full or not
	 */
	public boolean isFull() {
		return numberOfKeys == order;
	}

	/**
	 * @return the last key in this node
	 */
	public Comparable getLastKey() {
		return keys[numberOfKeys - 1];
	}

	/**
	 * @return the first key in this node
	 */
	public Comparable getFirstKey() {
		return keys[0];
	}

	/**
	 * @return the minimum number of keys this node can hold
	 */
	public abstract int minKeys();

	/**
	 * insert a key with the associated record reference in the B+ tree
	 * 
	 * @param key             the key to be inserted
	 * @param recordReference a pointer to the record on the hard disk
	 * @param parent          the parent of the current node
	 * @param ptr             the index of the parent pointer that points to this
	 *                        node
	 * @return a key and a new node in case of a node splitting and null otherwise
	 * @throws Exception 
	 */
	public abstract RTreePushUp insert(Comparable key, RTreeRefRecord recordReference, RTreeInnerNode parent, int ptr) throws Exception;

	public abstract ArrayList<RTreeRefRecord> search(Comparable key) throws ClassNotFoundException, IOException;
	public abstract RTreeLeafNode getFirstLeafNode() throws ClassNotFoundException, IOException ;

	
	public abstract RTreeNI searchn(Comparable key) throws ClassNotFoundException, IOException;
	public abstract RTreeRefRecord searchd(Comparable key) throws ClassNotFoundException, IOException;

	/**
	 * delete a key from the B+ tree recursively
	 * 
	 * @param key    the key to be deleted from the B+ tree
	 * @param parent the parent of the current node
	 * @param ptr    the index of the parent pointer that points to this node
	 * @return true if this node was successfully deleted and false otherwise
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public abstract boolean delete(Comparable key, RTreeInnerNode parent, int ptr) throws IOException, ClassNotFoundException;
	public abstract boolean delete(Comparable key,RTreeRefRecord value, RTreeInnerNode parent, int ptr) throws IOException, ClassNotFoundException;

	/**
	 * A string represetation for the node
	 */
	public String toString() {
		String s = "";// "(" + index + ")";

		s += "[";
		for (int i = 0; i < order; i++) {
			String key = " ";
			if (i < numberOfKeys)
				key = keys[i].toString();

			s += key;
			if (i < order - 1)
				s += "|";
		}
		s += "]";
		return s;
	}
	public void refresh() throws IOException, ClassNotFoundException {
		if (filename != null) {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this);
			out.close();
			file.close();
		}
	}
	

}
