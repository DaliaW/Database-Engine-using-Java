package Annabelle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BPTreeLeafNode extends BPTreeNode implements Serializable {

	private static final long serialVersionUID = 1L;
	// private Ref[] records;
	private String[] recordsFilename;
	private String nextfilename = null;

	@SuppressWarnings("unchecked")
	public BPTreeLeafNode(int n, String tablename, String columnname) throws Exception {
		super(n, tablename, columnname);
		keys = new Comparable[n];
		// records = new Ref[n];
		recordsFilename = new String[n];
	}

	/**
	 * @return the next leaf node
	 */

	public BPTreeLeafNode getNext() throws IOException, ClassNotFoundException {
		if (this.nextfilename != null) {
			FileInputStream file = new FileInputStream(this.nextfilename);
			ObjectInputStream in = new ObjectInputStream(file);
			BPTreeLeafNode n = (BPTreeLeafNode) in.readObject();
			in.close();
			file.close();
			return n;
		} else
			return null;
	}

	/**
	 * sets the next leaf node
	 * 
	 * @param node the next leaf node
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void setNext(BPTreeLeafNode node) throws ClassNotFoundException, IOException {
		if (node != null) {
			this.nextfilename = node.filename;
			refresh();
		} else {
			this.nextfilename = null;
			refresh();
		}
	}

	/**
	 * sets the next leaf node
	 * 
	 * @param node the next leaf node
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */

	/**
	 * @param index the index to find its record
	 * @return the reference of the queried index
	 */
	// public Ref getRecord(int index)
	// {
	// return records[index];
	// }
	public String getRecordfilename(int index) {
		return recordsFilename[index];
	}

	/**
	 * sets the record at the given index with the passed reference
	 * 
	 * @param index           the index to set the value at
	 * @param recordReference the reference to the record
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	// public void setRecord(int index, Ref recordReference) throws
	// ClassNotFoundException, IOException
	// {

	// records[index] = recordReference;
	// refresh();
	// }
	public void setRecordfilename(int index, String recordfilename) throws ClassNotFoundException, IOException {
		recordsFilename[index] = recordfilename;
		refresh();
	}

	/**
	 * finds the index at which the passed key must be located
	 * 
	 * @param key the key to be checked for its location
	 * @return the expected index of the key
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
	 * @return the reference of the last record
	 */
	// public Ref getFirstRecord()
	// {
	// return records[0];
	// }
	public String getFirstRecordfilename() {
		return recordsFilename[0];
	}

	/**
	 * @return the reference of the last record
	 */
	// public Ref getLastRecord()
	// {
	// return records[numberOfKeys-1];
	// }
	public String getLastRecordfilname() {
		return recordsFilename[numberOfKeys - 1];
	}

	/**
	 * finds the minimum number of keys the current node must hold
	 */
	public int minKeys() {
		if (this.isRoot())
			return 1;
		return (order + 1) / 2;
	}

	/**
	 * insert the specified key associated with a given record reference in the B+
	 * tree
	 * 
	 * @throws Exception
	 */
	public BPTreePushUp insert(Comparable key, BPTreeRefRecord recordReference, BPTreeInnerNode parent, int ptr) throws Exception {
		boolean dup = false;
		for (int i = 0; i < numberOfKeys; i++) {
			if ((keys[i]).compareTo(key) == 0) {
				dup = true;
				break;
			}
		}
		if (this.isFull() && !dup) {
			BPTreeNode newNode = this.split(key, recordReference);

			Comparable newKey = newNode.getFirstKey();
			return new BPTreePushUp(newNode, newKey); ///////////////////////////////
		} else {
			boolean dupkey = false;
			int index = 0;
			while (index < numberOfKeys && getKey(index).compareTo(key) <= 0) {
				if (getKey(index).compareTo(key) == 0) {
					dupkey = true;
					break;
				} else
					++index;
			}
			this.insertAt(index, key, recordReference);
			return null;
		}
	}

	/**
	 * inserts the passed key associated with its record reference in the specified
	 * index
	 * 
	 * @param index           the index at which the key will be inserted
	 * @param key             the key to be inserted
	 * @param recordReference the pointer to the record associated with the key
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void insertAt(int index, Comparable key, BPTreeRefRecord recordReference) throws ClassNotFoundException, IOException {
		// for (int i = numberOfKeys - 1; i >= index; --i)
		// {
		// this.setKey(i + 1, getKey(i));
		// // this.setRecord(i + 1, getRecord(i));
		// this.setRecordfilename(i+1, getRecordfilename(i));
		// }
		boolean dupkey = false;
		for (int i = 0; i < numberOfKeys; i++) {
			if (keys[i].compareTo(key) == 0) {
				dupkey = true;
				break;
			}
		}
		if (dupkey) {
			String recfilename = this.getRecordfilename(index);
			BPTreeDupPage recPage = getDupPage(recfilename);
			recPage.insertinPage(key, recordReference);
		} else {
			for (int i = numberOfKeys - 1; i >= index; --i) {
				this.setKey(i + 1, getKey(i));
				// this.setRecord(i + 1, getRecord(i));
				this.setRecordfilename(i + 1, getRecordfilename(i));
			}
			this.setKey(index, key);
			BPTreeDupPage newDuppage = new BPTreeDupPage(order, key, this.filename);
			newDuppage.insertinPage(key, recordReference);
			this.setRecordfilename(index, newDuppage.filename);
			// this.setRecord(index, recordReference);
			++numberOfKeys;
		}
		refresh();
	}

	/**
	 * splits the current node
	 * 
	 * @param key             the new key that caused the split
	 * @param recordReference the reference of the new key
	 * @return the new node that results from the split
	 * @throws Exception
	 */
	public BPTreeNode split(Comparable key, BPTreeRefRecord recordReference) throws Exception {
		int keyIndex = this.findIndex(key);
		int midIndex = numberOfKeys / 2;
		if ((numberOfKeys & 1) == 1 && keyIndex > midIndex) // split nodes evenly
			++midIndex;

		int totalKeys = numberOfKeys + 1;
		// move keys to a new node
		BPTreeLeafNode newNode = new BPTreeLeafNode(order, tablename, columnname);
		for (int i = midIndex; i < totalKeys - 1; ++i) {

			ArrayList<BPTreeRefRecord> allRecords = new ArrayList<BPTreeRefRecord>();
			String recfilename = getRecordfilename(i);
			BPTreeDupPage recPage = getDupPage(recfilename);
			allRecords = recPage.getallRecords();

			for (int j = 0; j < allRecords.size(); j++) {
				newNode.insertAt(i - midIndex, this.getKey(i), allRecords.get(j));
			}
			recPage.deleteAllPages();
			numberOfKeys--;
			refresh();

		}

		// insert the new key
		if (keyIndex < totalKeys / 2)
			this.insertAt(keyIndex, key, recordReference);
		else
			newNode.insertAt(keyIndex - midIndex, key, recordReference);

		// set next pointers
		newNode.setNext(this.getNext());
		this.setNext(newNode);

		return newNode;
	}

	/**
	 * returns the record reference with the passed key and null if does not exist
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */

	public BPTreeDupPage getDupPage(String recfilename) throws ClassNotFoundException, IOException {
		if (recfilename != null) {
			FileInputStream file = new FileInputStream(recfilename);
			ObjectInputStream in = new ObjectInputStream(file);
			BPTreeDupPage recPage = (BPTreeDupPage) in.readObject();
			in.close();
			file.close();
			return recPage;
		}
		return null;

	}

	@Override
	public ArrayList<BPTreeRefRecord> search(Comparable key) throws ClassNotFoundException, IOException {
		for (int i = 0; i < numberOfKeys; ++i)
			if (this.getKey(i).compareTo(key) == 0) {
				String recfilename = this.getRecordfilename(i);
				BPTreeDupPage recPage = getDupPage(recfilename);
				return recPage.getallRecords();
				// return this.getRecord(i);
			}
		return null;
	}

	/**
	 * delete the passed key from the B+ tree
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean delete(Comparable key, BPTreeInnerNode parent, int ptr) throws ClassNotFoundException, IOException {
		for (int i = 0; i < numberOfKeys; ++i)
			if (keys[i].compareTo(key) == 0) {
				this.deleteAt(i);
				if (i == 0 && ptr > 0) {
					// update key at parent
					parent.setKey(ptr - 1, this.getFirstKey());
				}
				// check that node has enough keys
				if (!this.isRoot() && numberOfKeys < this.minKeys()) {
					// 1.try to borrow
					if (borrow(parent, ptr))
						return true;
					// 2.merge
					merge(parent, ptr);
				}
				return true;
			}
		return false;
	}

	public boolean delete(Comparable key, BPTreeRefRecord value, BPTreeInnerNode parent, int ptr)
			throws ClassNotFoundException, IOException {
		for (int i = 0; i < numberOfKeys; ++i)
			if (keys[i].compareTo(key) == 0) {

				this.deleteAt(i, key, value);
				if (i == 0 && ptr > 0) {
					// update key at parent
					parent.setKey(ptr - 1, this.getFirstKey());
				}
				// check that node has enough keys
				if (!this.isRoot() && numberOfKeys < this.minKeys()) {
					// 1.try to borrow
					if (borrow(parent, ptr))
						return true;
					// 2.merge
					merge(parent, ptr);
				}
				return true;
			}
		return false;
	}

	/**
	 * delete a key at the specified index of the node
	 * 
	 * @param index the index of the key to be deleted
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void deleteAt(int index) throws ClassNotFoundException, IOException {
		if(this.search(keys[index])!=null){
			String recfilename = recordsFilename[index];// to remove from disk
			BPTreeDupPage recPage = getDupPage(recfilename);
			recPage.deleteAllPages();// moshkelaaaaaaaaaaaaaaaaaa
		}
		for (int i = index; i < numberOfKeys - 1; ++i) {
			keys[i] = keys[i + 1];
			recordsFilename[i] = recordsFilename[i + 1];
			// records[i] = records[i+1];
		}
		numberOfKeys--;
		refresh();
	}

	public void deleteAt(int index, Comparable key, BPTreeRefRecord value) throws ClassNotFoundException, IOException {
		String recfilename = recordsFilename[index];// to remove from disk
		BPTreeDupPage recPage = getDupPage(recfilename);
		recPage.deletefromPage(key, value);
		if (recPage.getRecords().size() == 0)
			if (recPage.getNextptr() == null) {

				for (int i = index; i < numberOfKeys - 1; ++i) {
					keys[i] = keys[i + 1];
					recordsFilename[i] = recordsFilename[i + 1];
					// records[i] = [i+1];
				}
				numberOfKeys--;
				refresh();
			}

			else {
				Files.deleteIfExists(Paths.get(recPage.filename));
				recordsFilename[index] = recPage.getNextptr().filename;
				refresh();
			}
	}

	/**
	 * tries to borrow a key from the left or right sibling
	 * 
	 * @param parent the parent of the current node
	 * @param ptr    the index of the parent pointer that points to this node
	 * @return true if borrow is done successfully and false otherwise
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean borrow(BPTreeInnerNode parent, int ptr) throws ClassNotFoundException, IOException {
		// check left sibling
		if (ptr > 0) {
			BPTreeLeafNode leftSibling = (BPTreeLeafNode) parent.getChild(ptr - 1);
			if (leftSibling.numberOfKeys > leftSibling.minKeys()) {
				String recfilename = leftSibling.getLastRecordfilname();
				BPTreeDupPage recPage = getDupPage(recfilename);
				ArrayList<BPTreeRefRecord> allRecords = recPage.getallRecords();
				for (int i = 0; i < allRecords.size(); i++) {

					this.insertAt(0, leftSibling.getLastKey(), allRecords.get(i));
				}
				// recPage.deleteAllPages();// moskellllllllllllllllllllllaaaaaaa
				leftSibling.deleteAt(leftSibling.numberOfKeys - 1);
				parent.setKey(ptr - 1, keys[0]);
				refresh();
				return true;
			}
		}

		// check right sibling
		if (ptr < parent.numberOfKeys) {
			BPTreeLeafNode rightSibling = (BPTreeLeafNode) parent.getChild(ptr + 1);
			if (rightSibling.numberOfKeys > rightSibling.minKeys()) {
				String recfilename = rightSibling.getFirstRecordfilename();
				BPTreeDupPage recPage = getDupPage(recfilename);
				ArrayList<BPTreeRefRecord> allRecords = recPage.getallRecords();
				for (int i = 0; i < allRecords.size(); i++) {

					this.insertAt(numberOfKeys, rightSibling.getFirstKey(), allRecords.get(i));
				}
				// recPage.deleteAllPages();//moshkelaaaaaaaaaaaaaa
				// this.insertAt(numberOfKeys, rightSibling.getFirstKey(),
				// rightSibling.getFirstRecord());
				rightSibling.deleteAt(0);
				parent.setKey(ptr, rightSibling.getFirstKey());
				refresh();
				return true;
			}
		}

		return false;
	}

	/**
	 * merges the current node with its left or right sibling
	 * 
	 * @param parent the parent of the current node
	 * @param ptr    the index of the parent pointer that points to this node
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void merge(BPTreeInnerNode parent, int ptr) throws ClassNotFoundException, IOException {
		if (ptr > 0) {
			// merge with left
			BPTreeLeafNode leftSibling = (BPTreeLeafNode) parent.getChild(ptr - 1);
			leftSibling.merge(this);
			parent.deleteAt(ptr - 1);
		} else {
			// merge with right
			BPTreeLeafNode rightSibling = (BPTreeLeafNode) parent.getChild(ptr + 1);
			this.merge(rightSibling);
			parent.deleteAt(ptr);
		}
		refresh();
	}

	/**
	 * merge the current node with the specified node. The foreign node will be
	 * deleted
	 * 
	 * @param foreignNode the node to be merged with the current node
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void merge(BPTreeLeafNode foreignNode) throws ClassNotFoundException, IOException {
		for (int i = 0; i < foreignNode.numberOfKeys; ++i) {
			String recfilename = foreignNode.getRecordfilename(i);
			BPTreeDupPage recPage = getDupPage(recfilename);
			ArrayList<BPTreeRefRecord> allRecords = recPage.getallRecords();
			for (int j = 0; j < allRecords.size(); j++) {
				this.insertAt(numberOfKeys, foreignNode.getKey(i), allRecords.get(j));
			}
			recPage.deleteAllPages();
		}

		this.setNext(foreignNode.getNext());
		refresh();
	}

	@Override
	public BPTreeLeafNode getFirstLeafNode() throws ClassNotFoundException, IOException {

		return this;

	}
	public BPTreeRefRecord getLastOne(ArrayList<BPTreeRefRecord> a) {
		BPTreeRefRecord greatest = a.get(0);
		for (int i = 0; i < a.size(); i++) {
			BPTreeRefRecord now = a.get(i);
			int pageno= now.getPage();
			int indexinpage=now.getIndexInPage();
			if(pageno>greatest.getPage()) {
				greatest=now;
			}
			else if(pageno==greatest.getPage()) {
				if(indexinpage>greatest.getIndexInPage())
					greatest=now;
			}
		}
		return greatest;	

	}

	public  BPTreeRefRecord searchd(Comparable key) throws ClassNotFoundException, IOException {
		boolean found=false;
		Comparable smallest =null;
		int indexofsmallest=0;
		boolean greater=false;
		System.out.println(this);
		for (int i = 0; i<numberOfKeys; i++) {
			if(this.getKey(i).compareTo(key)==0) {
				found=true;				
				return this.getLastOne(getDupPage( this.getRecordfilename(i)).getallRecords());
			}
			else if(this.getKey(i).compareTo(key)<0) {
				smallest=this.getKey(i);
				indexofsmallest=i;
				}
			else {
				greater=true;
				break;
			}
		}
		if(!greater) {
			if(this.getNext()!=null) {
				if(this.getNext().getFirstKey().compareTo(key)<0)
					return this.getNext().searchd(key);
			}
		}
	    if(smallest!=null)
			return this.getLastOne(getDupPage(this.getRecordfilename(indexofsmallest)).getallRecords());
		return null;

	}
	@Override
	public BPTreeNI searchn(Comparable key) throws ClassNotFoundException, IOException {

		for (int i = 0; i < numberOfKeys; ++i)
			if (this.getKey(i).compareTo(key) == 0)
				return new BPTreeNI(this, i);
		return new BPTreeNI(this, -1);

	}

	public ArrayList<BPTreeRefRecord> complete(Comparable key1, Comparable key2, boolean take1, boolean take2, int index)
			throws ClassNotFoundException, IOException {
		ArrayList<BPTreeRefRecord> x = new ArrayList<BPTreeRefRecord>();

		if (key2 == null) {
			for (int i = index == -1 ? 0 : index; i < this.numberOfKeys; i++) {
				if (key1 != null) {
					if (this.keys[i].compareTo(key1) > 0) {
						BPTreeDupPage recPage = getDupPage(recordsFilename[i]);
						ArrayList<BPTreeRefRecord> records = recPage.getallRecords();
						for (int k = 0; k < records.size(); k++)
							x.add(records.get(k));
					} else if (this.keys[i].compareTo(key1) == 0 && take1) {
						BPTreeDupPage recPage = getDupPage(recordsFilename[i]);
						ArrayList<BPTreeRefRecord> records = recPage.getallRecords();
						for (int k = 0; k < records.size(); k++)
							x.add(records.get(k));
					}

				} else {
					BPTreeDupPage recPage = getDupPage(recordsFilename[i]);
					ArrayList<BPTreeRefRecord> records = recPage.getallRecords();
					for (int k = 0; k < records.size(); k++)
						x.add(records.get(k));
				}

			}
			if (this.getNext() != null) {
				ArrayList<BPTreeRefRecord> y = this.getNext().complete(null, key2, take1, take2, -1);
				for (int i = 0; i < y.size(); i++)
					x.add(y.get(i));
			}
			return x;
		} else {
			int i;
			for (i = index == -1 ? 0 : index; i < this.numberOfKeys; i++) {
				if (keys[i].compareTo(key2) < 0) {
					if (key1 != null) {
						if (this.keys[i].compareTo(key1) > 0) {

							BPTreeDupPage recPage = getDupPage(recordsFilename[i]);
							ArrayList<BPTreeRefRecord> records = recPage.getallRecords();
							for (int k = 0; k < records.size(); k++)
								x.add(records.get(k));
						} else if (keys[i].compareTo(key1) == 0 && take1) {

							BPTreeDupPage recPage = getDupPage(recordsFilename[i]);
							ArrayList<BPTreeRefRecord> records = recPage.getallRecords();
							for (int k = 0; k < records.size(); k++)
								x.add(records.get(k));

						}
					} else {
						BPTreeDupPage recPage = getDupPage(recordsFilename[i]);
						ArrayList<BPTreeRefRecord> records = recPage.getallRecords();
						for (int k = 0; k < records.size(); k++)
							x.add(records.get(k));
					}
				} else if (keys[i].compareTo(key2) == 0 && take2) {
					BPTreeDupPage recPage = getDupPage(recordsFilename[i]);
					ArrayList<BPTreeRefRecord> records = recPage.getallRecords();
					for (int k = 0; k < records.size(); k++)
						x.add(records.get(k));
				} else
					break;
			}
			if (i == this.numberOfKeys) {
				if (this.getNext() != null) {
					ArrayList<BPTreeRefRecord> y = this.getNext().complete(null, key2, take1, take2, -1);
					for (int j = 0; j < y.size(); j++)
						x.add(y.get(j));
				}

			}
			return x;
		}
	}

	public ArrayList<BPTreeRefRecord> complete2(Comparable key) throws IOException, ClassNotFoundException{
		ArrayList<BPTreeRefRecord> x=new ArrayList<BPTreeRefRecord> ();

		for(int i=0;i<numberOfKeys;i++) {
			if(keys[i].compareTo(key)!=0) {
				BPTreeDupPage recPage = getDupPage(recordsFilename[i]);
				ArrayList<BPTreeRefRecord> records = recPage.getallRecords();
				for (int k = 0; k < records.size(); k++)
					x.add(records.get(k));	
			}

		}

		if(this.nextfilename!=null){
			FileInputStream file = new FileInputStream(this.nextfilename);
			ObjectInputStream in = new ObjectInputStream(file);
			BPTreeLeafNode Bp= (BPTreeLeafNode)in.readObject();
			in.close();
			file.close();

			ArrayList<BPTreeRefRecord> array=Bp.complete2(key);
			for(int i=0;i<array.size();i++) {
				x.add(array.get(i));
			}

		}
		return x;
	}
}
