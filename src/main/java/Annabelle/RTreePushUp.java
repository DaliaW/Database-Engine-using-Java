package Annabelle;

import java.io.IOException;

public class RTreePushUp {

	/**
	 * This class is used for push keys up to the inner nodes in case
	 * of splitting at a lower level
	 */
	RTreeNode newNode;
	Comparable key;
	
	public RTreePushUp(RTreeNode newNode, Comparable key) throws ClassNotFoundException, IOException
	{
		this.newNode = newNode;
		this.key = key;
		this.newNode.refresh();
		
	}
}
