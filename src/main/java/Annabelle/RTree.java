package Annabelle;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RTree implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int order;
	private RTreeNode root;
	String tablename;
	String columnname;

	/**
	 * Creates an empty B+ tree
	 * 
	 * @param order the maximum number of keys in the nodes of the tree
	 * @throws Exception 
	 */
	public RTree(int order, String tablename, String columnname) throws Exception {
		this.tablename = tablename;
		this.columnname = columnname;
		this.order = order;
		root = new RTreeLeafNode(this.order, tablename, columnname);
		root.setRoot(true);
	}

	/**
	 * Inserts the specified key associated with the given record in the B+ tree
	 * 
	 * @param key             the key to be inserted
	 * @param recordReference the reference of the record associated with the key
	 * @throws Exception 
	 */
	public void insert(Polygon key, RTreeRefRecord recordReference) throws Exception {
		Dimension dim1 = key.getBounds().getSize();
		int Area = dim1.width * dim1.height;
		System.out.println("Area :"+Area);


		RTreePushUp pushUp = root.insert(Area, recordReference, null, -1);
		if (pushUp != null) {
			RTreeInnerNode newRoot = new RTreeInnerNode(order, tablename, columnname);
			newRoot.insertLeftAt(0, pushUp.key, root);
			newRoot.setChild(1, pushUp.newNode);
			root.setRoot(false);
			root = newRoot;
			root.setRoot(true);
		}
	}

	/**
	 * Looks up for the record that is associated with the specified key
	 * 
	 * @param key the key to find its record
	 * @return the reference of the record associated with this key
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<RTreeRefRecord> search(Polygon key) throws ClassNotFoundException, IOException {
		Dimension dim1 = key.getBounds().getSize();
		int Area = dim1.width * dim1.height;
		return root.search(Area);
	}
	public RTreeRefRecord searchd(Polygon key) throws ClassNotFoundException, IOException {
		Dimension dim1 = key.getBounds().getSize();
		int Area = dim1.width * dim1.height;
		return root.searchd(Area);
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
	public boolean delete(Polygon key) throws ClassNotFoundException, IOException {
		Dimension dim1 = key.getBounds().getSize();
		int Area = dim1.width * dim1.height;
		boolean done = root.delete(Area, null, -1);
		// go down and find the new root in case the old root is deleted
		while (root instanceof RTreeInnerNode && !root.isRoot())
			root = ((RTreeInnerNode) root).getFirstChild();
		return done;
	}
	public boolean delete(Polygon key,RTreeRefRecord value) throws ClassNotFoundException, IOException {
		Dimension dim1 = key.getBounds().getSize();
		int Area = dim1.width * dim1.height;
		boolean done = root.delete(Area,value, null, -1);
		// go down and find the new root in case the old root is deleted
		while (root instanceof RTreeInnerNode && !root.isRoot())
			root = ((RTreeInnerNode) root).getFirstChild();
		return done;
	}


	/**
	 * Returns a string representation of the B+ tree.
	 */
	public String toString() {

		// <For Testing>
		// node : (id)[k1|k2|k3|k4]{P1,P2,P3,}
		String s = "";
		Queue<RTreeNode> cur = new LinkedList<RTreeNode>(), next;
		cur.add(root);
		while (!cur.isEmpty()) {
			next = new LinkedList<RTreeNode>();
			while (!cur.isEmpty()) {
				RTreeNode curNode = cur.remove();
				System.out.print(curNode);
				if (curNode instanceof RTreeLeafNode)
					System.out.print("->");
				else {
					// System.out.print("{");
					RTreeInnerNode parent = (RTreeInnerNode) curNode;
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
	public ArrayList<RTreeRefRecord> search(Polygon key1, Polygon key2, boolean equal1, boolean equal2)
			throws ClassNotFoundException, IOException {

		if (key1 != null) {
			Dimension dim1 = key1.getBounds().getSize();
			int area1 = dim1.width * dim1.height;
			int area2=-1;
			if(key2!=null) {
				Dimension dim2 = key2.getBounds().getSize();
				area2 = dim2.width * dim2.height;
			}

			RTreeNI ni = root.searchn(area1);
			RTreeLeafNode leftnode = ni.leaf;
			return leftnode.complete(area1, key2==null?null:area2, equal1, equal2, ni.index);
		} else {
			Dimension dim2 = key2.getBounds().getSize();
			int area2 = dim2.width * dim2.height;
			RTreeLeafNode leftnode = getFirstLeafNode();
			return leftnode.complete(null, area2, equal1, equal2, -1);
		}
	}

	public ArrayList<RTreeRefRecord> notequal(Polygon key) throws ClassNotFoundException, IOException{
		Dimension dim1 = key.getBounds().getSize();
		int area = dim1.width * dim1.height;
		RTreeLeafNode leftnode = getFirstLeafNode();
		return leftnode.complete2(area);
	}
	public RTreeLeafNode getFirstLeafNode() throws ClassNotFoundException, IOException {
		return root.getFirstLeafNode();
	}
}
