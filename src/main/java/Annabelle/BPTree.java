package Annabelle;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BPTree implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int order;
	private BPTreeNode root;
	String tablename;
	String columnname;

	/**
	 * Creates an empty B+ tree
	 * 
	 * @param order the maximum number of keys in the nodes of the tree
	 * @throws Exception 
	 */
	public BPTree(int order, String tablename, String columnname) throws Exception {
		this.tablename = tablename;
		this.columnname = columnname;
		this.order = order;
		root = new BPTreeLeafNode(this.order, tablename, columnname);
		root.setRoot(true);
	}

	/**
	 * Inserts the specified key associated with the given record in the B+ tree
	 * 
	 * @param key             the key to be inserted
	 * @param recordReference the reference of the record associated with the key
	 * @throws Exception 
	 */
	public void insert(Comparable key, BPTreeRefRecord recordReference) throws Exception {
		BPTreePushUp pushUp = root.insert(key, recordReference, null, -1);
		if (pushUp != null) {
			BPTreeInnerNode newRoot = new BPTreeInnerNode(order, tablename, columnname);
			newRoot.insertLeftAt(0, pushUp.key, root);
			newRoot.setChild(1, pushUp.newNode);
			root.setRoot(false);
			root = newRoot;
			root.setRoot(true);
		}
	}
	
//	public void replaceRef(Comparable key, BPTreeRefRecord oldRef, BPTreeRefRecord newRef) throws ClassNotFoundException, IOException{
//		ArrayList<BPTreeRefRecord> reff = this.search(key);
//		for(int i=0;i<reff.size();i++){
//			if(reff.get(i).compareTTo(oldRef)){
//				reff.add(i, newRef);
//				return;
//			}
//		}
//	}

	/**
	 * Looks up for the record that is associated with the specified key
	 * 
	 * @param key the key to find its record
	 * @return the reference of the record associated with this key
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<BPTreeRefRecord> search(Comparable key) throws ClassNotFoundException, IOException {
		return root.search(key);
	}
	public BPTreeRefRecord searchd(Comparable key) throws ClassNotFoundException, IOException {
		return root.searchd(key);
	}
	/**
	 * Delete a key and its associated record from the tree.
	 * 
	 * @param key the key to be deleted
	 * @return a boolean to indicate whether the key is successfully deleted or it
	 *         was not in the tree
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean delete(Comparable key) throws ClassNotFoundException, IOException {
		boolean done = root.delete(key, null, -1);
		// go down and find the new root in case the old root is deleted
		while (root instanceof BPTreeInnerNode && !root.isRoot())
			root = ((BPTreeInnerNode) root).getFirstChild();
		return done;
	}
	public boolean delete(Comparable key,BPTreeRefRecord value) throws ClassNotFoundException, IOException {
		boolean done = root.delete(key,value, null, -1);
		// go down and find the new root in case the old root is deleted
		while (root instanceof BPTreeInnerNode && !root.isRoot())
			root = ((BPTreeInnerNode) root).getFirstChild();
		return done;
	}


	/**
	 * Returns a string representation of the B+ tree.
	 */
	public String toString() {

		// <For Testing>
		// node : (id)[k1|k2|k3|k4]{P1,P2,P3,}
		String s = "";
		Queue<BPTreeNode> cur = new LinkedList<BPTreeNode>(), next;
		cur.add(root);
		while (!cur.isEmpty()) {
			next = new LinkedList<BPTreeNode>();
			while (!cur.isEmpty()) {
				BPTreeNode curNode = cur.remove();
				System.out.print(curNode);
				if (curNode instanceof BPTreeLeafNode)
					System.out.print("->");
				else {
					// System.out.print("{");
					BPTreeInnerNode parent = (BPTreeInnerNode) curNode;
					for (int i = 0; i <= parent.numberOfKeys; ++i) {
						// System.out.print(parent.getChild(i).index+",");
						try {
							next.add(parent.getChild(i));
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// System.out.print("} ");
				}

			}
			System.out.println();// {13,12,16,51,22,40,35,30,29,27,25,18,23,19,17,14,2,20,8,2,15,9,7,3,4};
			cur = next;
		}
		// </For Testing>
		return s;
	}
	public ArrayList<BPTreeRefRecord> search(Comparable key1, Comparable key2, boolean equal1, boolean equal2)
			throws ClassNotFoundException, IOException {
		if (key1 != null) {
			BPTreeNI ni = root.searchn(key1);
			BPTreeLeafNode leftnode = ni.leaf;
			return leftnode.complete(key1, key2, equal1, equal2,ni.index);
		} else {
			BPTreeLeafNode leftnode = getFirstLeafNode();
			return leftnode.complete(key1, key2, equal1, equal2,-1);
		}
	}
	public ArrayList<BPTreeRefRecord> notequal(Comparable key) throws ClassNotFoundException, IOException{
		BPTreeLeafNode leftnode = getFirstLeafNode();
		return leftnode.complete2(key);
	}
	public BPTreeLeafNode getFirstLeafNode() throws ClassNotFoundException, IOException {
		return root.getFirstLeafNode();
	}
}
