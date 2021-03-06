package test;

import org.junit.Assert;
import org.junit.Test;

import algorithm.container.LinkedList;

public class LinkedListTest extends ListTest {

	@Test
	public void generalTest() {
		// create and add
		LinkedList<String> list = new LinkedList<String>();
		list.add("This");
		list.add("is");
		list.add("a");
		list.add("test");
		Assert.assertEquals("This is a test", concatList(list));
		Assert.assertEquals("test a is This", concatList(list, true));
		
		// insert
		list.insert("juicy", 3);
		Assert.assertEquals("This is a juicy test", concatList(list));
		Assert.assertEquals("test juicy a is This", concatList(list, true));
		
		// remove
		list.remove(3);
		Assert.assertEquals("This is a test", concatList(list));
		Assert.assertEquals("test a is This", concatList(list, true));
		
		// contains
		String s = "!";
		list.insert(s, list.size());
		Assert.assertEquals(true, list.contains(s));
		Assert.assertEquals("This is a test !", concatList(list));
		Assert.assertEquals("! test a is This", concatList(list, true));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void outOfBoundsExceptionTest() {
		LinkedList<String> list = new LinkedList<String>();
	    list.insert("Nope", 1);
	}
}
