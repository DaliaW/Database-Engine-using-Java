package Annabelle;

import java.io.IOException;

public class BPTreePushUp {

	/**
	 * This class is used for push keys up to the inner nodes in case
	 * of splitting at a lower level
	 */
	BPTreeNode newNode;
	Comparable key;
	
	public BPTreePushUp(BPTreeNode newNode, Comparable key) throws ClassNotFoundException, IOException
	{
		this.newNode = newNode;
		this.key = key;
		this.newNode.refresh();
		
	}
}
