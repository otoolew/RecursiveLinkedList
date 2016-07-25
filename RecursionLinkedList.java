package lab4;

public class RecursionLinkedList {
	private Node firstNode;
	private int numberOfEntries;

	public RecursionLinkedList() {
		firstNode = null;
		numberOfEntries = 0;
	}

	public void add(int aData) {
		if (numberOfEntries == 0) {
			firstNode = new Node(aData);
		} else {
			firstNode = new Node(aData, firstNode);
		}

		numberOfEntries++;
	}

	/**
	 * boolean contains(int aData)
	 * 
	 * See whether this RecursionLinkedList contains aData
	 * 
	 * @param aData
	 *            a data to be located
	 * @return true if this RecursionLinkedList contains aData, or false
	 *         otherwise.
	 */
	public boolean contains(int aData) {
		Node currentNode = recurseSearch(firstNode, aData);
		if (currentNode == null) {
			return false;
		} else {
			return true;
		}

	}

	public Node recurseSearch(Node currentNode, int aData) {
		// boolean result = false;
		if (currentNode == null) {
			return null;
		} else if (aData == currentNode.data) {
			return currentNode;
		} else {
			currentNode = currentNode.next;
			return recurseSearch(currentNode, aData);
		}
	}

	/**
	 * int getFrequencyOf(int aData)
	 * 
	 * Counts the number of times a given data appears in this
	 * RecursionLinkedList.
	 * 
	 * @param aData
	 *            the data to be counted
	 * @return the number of times aData appears in this RecursionLinkedList
	 */
	public int getFrequencyOf(int aData) {
		return recurseFrequency(firstNode, aData, 0);
	}

	public int recurseFrequency(Node currentNode, int aData, int freq) {
		// int result = freq;
		if (currentNode == null) {
			return freq;
		}
		if (aData == currentNode.data) {
			freq++;
		}
		currentNode = currentNode.next;
		return recurseFrequency(currentNode, aData, freq);

	}

	/**
	 * String toString()
	 * 
	 * Return a string representation of this RecursionLinkedList. For example,
	 * if this RecursionLinkedList contains 1, 2, 3, 5, 2 and 3 from the first
	 * index to the last index, the returned string should be "[1,2,3,5,2,3]"
	 * 
	 * @return the string representation of this RecursionLinkedList.
	 */
	public String toString() {
		return recurseString(firstNode, "[");
	}

	public String recurseString(Node currentNode, String str) {
		String result = str;
		if (currentNode != null) {
			result = result + currentNode.data;
			currentNode = currentNode.next;

			if (currentNode != null) {
				result = result + ",";
				return recurseString(currentNode, result);
			}

			return result + "]";
		} else {
			return result;
		}
	}

	/**
	 * int getIndexOf(int aData)
	 * 
	 * Return the index of the first aData where the first index of the first
	 * item in this RecursionLinkedList is 0.
	 * 
	 * @param aData
	 *            the data to be located
	 * @return the index of the first aData.
	 */
	public int getIndexOf(int aData) {
		Node currentNode = firstNode;
		int count = -1;
		return recurseIndex(currentNode, count, aData);
	}

	public int recurseIndex(Node currentNode, int index, int aData) {
		// System.out.println("Index: " + index + " Current Data " +
		// currentNode.data);
		int newIndex = index;
		newIndex++;

		if (currentNode.data == aData) {
			// System.out.println("Found! : " + index);
			return newIndex;
		} else {
			currentNode = currentNode.next;
			// System.out.println("*Index: " + index);
			if (currentNode == null) {
				return -1;
			}
			return recurseIndex(currentNode, newIndex, aData);
		}

	}

	private class Node {
		private int data;
		private Node next;

		private Node(int aData, Node nextNode) {
			data = aData;
			next = nextNode;
		}

		private Node(int aData) {
			this(aData, null);
		}
	}
}