package Annabelle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;



public class RTreeInnerNode extends RTreeNode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// BPTreeNode [] children;
	String[] childrenfilename;

	/**
	 * create BPTreeNode given order.
	 * 
	 * @param n
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public RTreeInnerNode(int n, String tablename, String columnname) throws Exception {
		super(n, tablename, columnname);
		keys = new Comparable[n];
		// children = new BPTreeNode[n+1];
		childrenfilename = new String[n + 1];
	}

	/**
	 * get child with specified index
	 * 
	 * @return Node which is child at specified index
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public RTreeNode getChild(int index) throws ClassNotFoundException, IOException {
		if(childrenfilename[index]!=null) {
			FileInputStream file = new FileInputStream(childrenfilename[index]);
			ObjectInputStream in = new ObjectInputStream(file);
			RTreeNode n = (RTreeNode) in.readObject();
			in.close();
			file.close();
			return n;
		}
		else
			return null;
	}

	/**
	 * creating child at specified index
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void setChild(int index, RTreeNode child) throws ClassNotFoundException, IOException {
		if(child!=null)
			childrenfilename[index] = child.filename;
		refresh();
	}

	/**
	 * get the first child of this node.
	 * 
	 * @return first child node.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public RTreeNode getFirstChild() throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(childrenfilename[0]);
		ObjectInputStream in = new ObjectInputStream(file);
		RTreeNode n = (RTreeNode) in.readObject();
		in.close();
		file.close();
		return n;
	}

	/**
	 * get the last child of this node
	 * 
	 * @return last child node.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public RTreeNode getLastChild() throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(childrenfilename[numberOfKeys]);
		ObjectInputStream in = new ObjectInputStream(file);
		RTreeNode n = (RTreeNode) in.readObject();
		in.close();
		file.close();
		return n;
	}

	/**
	 * @return the minimum keys values in InnerNode
	 */
	public int minKeys() {
		if (this.isRoot())
			return 1;
		return (order + 2) / 2 - 1;
	}

	/**
	 * insert given key in the corresponding index.
	 * 
	 * @param key    key to be inserted
	 * @param RTreeRefRecord    reference which that inserted key is located
	 * @param parent parent of that inserted node
	 * @param ptr    index of pointer in the parent node pointing to the current
	 *               node
	 * @return value to be pushed up to the parent.
	 * @throws Exception
	 */
	public RTreePushUp insert(Comparable key, RTreeRefRecord recordReference, RTreeInnerNode parent, int ptr) throws Exception {
		int index = findIndex(key);
		FileInputStream file = new FileInputStream(childrenfilename[index]);
		ObjectInputStream in = new ObjectInputStream(file);
		RTreeNode n = (RTreeNode) in.readObject();
		in.close();
		file.close();
		RTreePushUp pushUp = n.insert(key, recordReference, this, index);
		refresh();
		if (pushUp == null) {
			refresh();
			return null;
		}
		if (this.isFull()) {
			RTreeInnerNode newNode = this.split(pushUp);
			refresh();
			Comparable newKey = newNode.getFirstKey();
			refresh();
			newNode.deleteAt(0, 0);
			refresh();
			return new RTreePushUp(newNode, newKey);
		} else {
			index = 0;
			while (index < numberOfKeys && getKey(index).compareTo(key) < 0)
				++index;
			this.insertRightAt(index, pushUp.key, pushUp.newNode);
			refresh();
			return null;
		}
	}

	/**
	 * split the inner node and adjust values and pointers.
	 * 
	 * @param pushup key to be pushed up to the parent in case of splitting.
	 * @return Inner node after splitting
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public RTreeInnerNode split(RTreePushUp pushup) throws Exception {
		int keyIndex = this.findIndex((Comparable) pushup.key);
		int midIndex = numberOfKeys / 2 - 1;
		if (keyIndex > midIndex) // split nodes evenly
			++midIndex;
		refresh();
		int totalKeys = numberOfKeys + 1;
		// move keys to a new node
		RTreeInnerNode newNode = new RTreeInnerNode(order, tablename, columnname);
		for (int i = midIndex; i < totalKeys - 1; ++i) {
			newNode.insertRightAt(i - midIndex, this.getKey(i), this.getChild(i + 1));
			numberOfKeys--;

		}
		newNode.setChild(0, this.getChild(midIndex));

		// insert the new key
	
		if (keyIndex < totalKeys / 2)
			this.insertRightAt(keyIndex, pushup.key, pushup.newNode);
		else
			newNode.insertRightAt(keyIndex - midIndex, pushup.key, pushup.newNode);

		return newNode;
	}

	/**
	 * find the correct place index of specified key in that node.
	 * 
	 * @param key to be looked for
	 * @return index of that given key
	 */
	public int findIndex(Comparable key) {
		for (int i = 0; i < numberOfKeys; ++i) {
			int cmp = getKey(i).compareTo(key);
			if (cmp > 0)
				return i;
		}
		return numberOfKeys;
	}

	/**
	 * insert at given index a given key
	 * 
	 * @param index where it inserts the key
	 * @param key   to be inserted at index
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private void insertAt(int index, Comparable key) throws ClassNotFoundException, IOException {
		for (int i = numberOfKeys; i > index; --i) {
			this.setKey(i, this.getKey(i - 1));
			this.setChild(i + 1, this.getChild(i));
		}
		this.setKey(index, key);
		numberOfKeys++;
		refresh();
	}

	/**
	 * insert key and adjust left pointer with given child.
	 * 
	 * @param index     where key is inserted
	 * @param key       to be inserted in that index
	 * @param leftChild child which this node points to with pointer at left of that
	 *                  index
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void insertLeftAt(int index, Comparable key, RTreeNode leftChild) throws ClassNotFoundException, IOException {
		insertAt(index, key);
		this.setChild(index + 1, this.getChild(index));
		this.setChild(index, leftChild);
	}

	/**
	 * insert key and adjust right pointer with given child.
	 * 
	 * @param index      where key is inserted
	 * @param key        to be inserted in that index
	 * @param rightChild child which this node points to with pointer at right of
	 *                   that index
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void insertRightAt(int index, Comparable key, RTreeNode rightChild) throws ClassNotFoundException, IOException {
		insertAt(index, key);
		this.setChild(index + 1, rightChild);
	}

	/**
	 * delete key and return true or false if it is deleted or not
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean delete(Comparable key, RTreeInnerNode parent, int ptr) throws IOException, ClassNotFoundException {
		boolean done = false;
		for (int i = 0; !done && i < numberOfKeys; ++i)
			if (keys[i].compareTo(key) > 0) {
				FileInputStream file = new FileInputStream(childrenfilename[i]);
				ObjectInputStream in = new ObjectInputStream(file);
				RTreeNode n = (RTreeNode) in.readObject();
				in.close();
				file.close();

				done = n.delete(key, this, i);
			}
		if (!done) {
			FileInputStream file = new FileInputStream(childrenfilename[numberOfKeys]);
			ObjectInputStream in = new ObjectInputStream(file);
			RTreeNode n = (RTreeNode) in.readObject();
			in.close();
			file.close();
			done = n.delete(key, this, numberOfKeys);


		}if (numberOfKeys < this.minKeys()) {
			if (isRoot()) {
				this.getFirstChild().setRoot(true);

				this.setRoot(false);
				return done;
			}
			// 1.try to borrow
			if (borrow(parent, ptr))
				return done;
			// 2.merge
			merge(parent, ptr);
		}
		return done;
	}
	public boolean delete(Comparable key,RTreeRefRecord value, RTreeInnerNode parent, int ptr) throws IOException, ClassNotFoundException {
		boolean done = false;
		for (int i = 0; !done && i < numberOfKeys; ++i)
			if (keys[i].compareTo(key) > 0) {
				FileInputStream file = new FileInputStream(childrenfilename[i]);
				ObjectInputStream in = new ObjectInputStream(file);
				RTreeNode n = (RTreeNode) in.readObject();
				in.close();
				file.close();

				done = n.delete(key,value, this, i);
			}
		if (!done) {
			FileInputStream file = new FileInputStream(childrenfilename[numberOfKeys]);
			ObjectInputStream in = new ObjectInputStream(file);
			RTreeNode n = (RTreeNode) in.readObject();
			in.close();
			file.close();
			done = n.delete(key,value, this, numberOfKeys);


		}if (numberOfKeys < this.minKeys()) {
			if (isRoot()) {
				this.getFirstChild().setRoot(true);

				this.setRoot(false);
				return done;
			}
			// 1.try to borrow
			if (borrow(parent, ptr))
				return done;
			// 2.merge
			merge(parent, ptr);
		}
		return done;
	}
	

	/**
	 * borrow from the right sibling or left sibling in case of overflow.
	 * 
	 * @param parent of the current node
	 * @param ptr    index of pointer in the parent node pointing to the current
	 *               node
	 * @return true or false if it can borrow form right sibling or left sibling or
	 *         it can not
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean borrow(RTreeInnerNode parent, int ptr) throws ClassNotFoundException, IOException {
		// check left sibling
		if (ptr > 0) {
			RTreeInnerNode leftSibling = (RTreeInnerNode) parent.getChild(ptr - 1);
			if (leftSibling.numberOfKeys > leftSibling.minKeys()) {
				this.insertLeftAt(0, parent.getKey(ptr - 1), leftSibling.getLastChild());
				parent.deleteAt(ptr - 1);
				parent.insertRightAt(ptr - 1, leftSibling.getLastKey(), this);
				leftSibling.deleteAt(leftSibling.numberOfKeys - 1);
				return true;
			}
		}

		// check right sibling
		if (ptr < parent.numberOfKeys) {
			RTreeInnerNode rightSibling = (RTreeInnerNode) parent.getChild(ptr + 1);
			if (rightSibling.numberOfKeys > rightSibling.minKeys()) {
				this.insertRightAt(this.numberOfKeys, parent.getKey(ptr), rightSibling.getFirstChild());
				parent.deleteAt(ptr);
				parent.insertRightAt(ptr, rightSibling.getFirstKey(), rightSibling);
				rightSibling.deleteAt(0, 0);
				return true;
			}
		}
		return false;
	}

	/**
	 * try to merge with left or right sibling in case of overflow
	 * 
	 * @param parent of the current node
	 * @param ptr    index of pointer in the parent node pointing to the current
	 *               node
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(RTreeInnerNode parent, int ptr) throws ClassNotFoundException, IOException {
		if (ptr > 0) {
			// merge with left
			RTreeInnerNode leftSibling = (RTreeInnerNode) parent.getChild(ptr - 1);
			leftSibling.merge(parent.getKey(ptr - 1), this);
			parent.deleteAt(ptr - 1);
		} else {
			// merge with right
			RTreeInnerNode rightSibling = (RTreeInnerNode) parent.getChild(ptr + 1);
			this.merge(parent.getKey(ptr), rightSibling);
			parent.deleteAt(ptr);
		}
	}

	/**
	 * merge the current node with the passed node and pulling the passed key from
	 * the parent to be inserted with the merged node
	 * 
	 * @param parentKey   the pulled key from the parent to be inserted in the
	 *                    merged node
	 * @param foreignNode the node to be merged with the current node
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void merge(Comparable parentKey, RTreeInnerNode foreignNode) throws ClassNotFoundException, IOException {
		this.insertRightAt(numberOfKeys, parentKey, foreignNode.getFirstChild());
		for (int i = 0; i < foreignNode.numberOfKeys; ++i)
			this.insertRightAt(numberOfKeys, foreignNode.getKey(i), foreignNode.getChild(i + 1));
		refresh();
	}

	/**
	 * delete the key at the specified index with the option to delete the right or
	 * left pointer
	 * 
	 * @param keyIndex the index whose key will be deleted
	 * @param childPtr 0 for deleting the left pointer and 1 for deleting the right
	 *                 pointer
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void deleteAt(int keyIndex, int childPtr) throws ClassNotFoundException, IOException // 0 for left and 1 for right
	{
		for (int i = keyIndex; i < numberOfKeys - 1; ++i) {
			keys[i] = keys[i + 1];

			childrenfilename[i + childPtr] = childrenfilename[i + childPtr + 1];
		}

		if (childPtr == 0) 
			childrenfilename[numberOfKeys - 1] = childrenfilename[numberOfKeys];
		
		numberOfKeys--;
		refresh();
	}

	/**
	 * searches for the record reference of the specified key
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public ArrayList<RTreeRefRecord> search(Comparable key) throws ClassNotFoundException, IOException {
		FileInputStream file = new FileInputStream(childrenfilename[findIndex(key)]);
		ObjectInputStream in = new ObjectInputStream(file);
		RTreeNode n = (RTreeNode) in.readObject();
		in.close();
		file.close();
		return n.search(key);
	}
	public RTreeRefRecord searchd(Comparable key) throws ClassNotFoundException, IOException {
		FileInputStream file = new FileInputStream(childrenfilename[findIndex(key)]);
		ObjectInputStream in = new ObjectInputStream(file);
		RTreeNode n = (RTreeNode) in.readObject();
		in.close();
		file.close();
		return n.searchd(key);
	}

	/**
	 * delete the key at the given index and deleting its right child
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void deleteAt(int index) throws ClassNotFoundException, IOException {
		deleteAt(index, 1);
	}
	public  RTreeLeafNode getFirstLeafNode() throws ClassNotFoundException, IOException {
		FileInputStream file = new FileInputStream(childrenfilename[0]);
		ObjectInputStream in = new ObjectInputStream(file);
		RTreeNode n = (RTreeNode) in.readObject();
		in.close();
		
		file.close();
		return n.getFirstLeafNode();
	}


	public RTreeNI searchn(Comparable key) throws ClassNotFoundException, IOException {
		FileInputStream file = new FileInputStream(childrenfilename[findIndex(key)]);
		ObjectInputStream in = new ObjectInputStream(file);
		RTreeNode n = (RTreeNode) in.readObject();
		in.close();
		file.close();
		return n.searchn(key);
	}
}
