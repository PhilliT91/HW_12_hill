import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CollectionTest {

@Test
    public void constructorTest(){
        Collection col = new Collection();
    Assert.assertEquals(Collection.class,col.getClass());
    }

@Test
public void constructorWithZeroCapacityTest(){

    final ByteArrayOutputStream output;
    PrintStream old;
    old = System.out;
    output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));



    Collection col=new Collection(0);
    String template = "must be at least 1 element!";
    Assert.assertEquals(template, output.toString());


    System.setOut(old);

}

    @Test
    public void sizeTest(){
    Collection col = new Collection(3);
col.add("111");
col.add("222");
col.add("333");
    Assert.assertEquals(3,col.size());

    }

    @Test
    public void sizeTest2()
    {
        Collection col =new Collection(1);
        col.add("111");
        Assert.assertEquals(1,col.size());

    }




@Test
    public void addStringTest(){
    Collection col = new Collection();
    Assert.assertTrue(col.add("111"));
}

    @Test
    public void addByOneStringTest(){
        Collection col = new Collection(1);
        col.addByOne("1111");
        Assert.assertTrue(col.addByOne("111"));

    }

@Test
    public void deleteByIndexTest(){
    Collection col=new Collection();
    col.add("11111");
    col.add("22222");
    col.add("33333");
    col.add("44444");
    col.delete(1);
    Assert.assertSame("33333",col.get(1));
    Assert.assertFalse(col.delete(9));

}

@Test
    public void containsStringTest(){
    Collection col = new Collection(5);
    String[] arr={"1111","2222","3333","4444"};
    col.addAll(arr);
    Assert.assertTrue(col.contains("1111"));
    Assert.assertFalse(col.contains("77777"));

}

@Test
    public void deleteByStringTest(){
    Collection col = new Collection();
    col.add("1111");
    col.add("2222");
    col.add("3333");
    col.add("3333");
    col.add("3333");
    Assert.assertFalse(col.delete("99999"));
    Assert.assertTrue(col.delete("2222"));
    Assert.assertSame("3333",col.get(1));
}


@Test
    public void getTest(){
    Collection col = new Collection();
    col.add("1111");
    col.add("2222");
    Assert.assertSame("",col.get(9));
    Assert.assertSame("2222",col.get(1));




}


@Test
    public void displayCorrectlyTest(){
    final ByteArrayOutputStream output;
    PrintStream old;
    old = System.out;
    output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

Collection col =new Collection();
col.add("1111");
col.display();
    String template = "1111, ";
    Assert.assertEquals(template, output.toString());


    System.setOut(old);


}

@Test
    public void compareTest(){
    Collection col1= new Collection();
    Collection col2= new Collection();
    Collection col3= new Collection();
Collection col4=new Collection();
Collection col5=new Collection();
col2=col1;

col1.add("1111");
col1.add("2222");
col1.add("3333");

col3.add("1111");
col3.add("2222");
col3.add("3333");

col4.add("5555");
col4.add("6666");
col4.add("7777");

col5.add("8888");
Assert.assertFalse(col3.compare(col5));
Assert.assertFalse(col3.compare(col4));
Assert.assertTrue(col1.compare(col2));
Assert.assertTrue(col1.compare(col3));
}


@Test
    public void clearTest(){
    Collection col = new Collection();
    col.add("1111");
    col.add("2222");
    col.add("3333");
    col.add("3333");
    col.add("3333");
    col.clear();

Assert.assertSame("",col.get(3));
Assert.assertNull(col.get(0));
}

@Test
    public void indexOfElementTest(){
    Collection col = new Collection();
    col.add("1111");
    col.add("2222");
    col.add("3333");
    col.add("3333");
    col.add("3333");
    int i=col.indexOf("2222");
    int b=col.indexOf("99999");
    Assert.assertEquals(1,i);
    Assert.assertEquals(-1,b);

}


@Test
    public void addAllByCollectionTest(){
    Collection col = new Collection();
    col.add("1111");
    col.add("2222");
    col.add("3333");

    Collection col2= new Collection();
    Boolean addAllres;
    addAllres=col2.addAll(col);
    Assert.assertTrue(addAllres);
Assert.assertSame("1111",col2.get(0));
Assert.assertSame("2222",col2.get(1));
Assert.assertSame("3333",col2.get(2));


}



@Test
    public void trimTest(){
    Collection col = new Collection();
    Boolean trimRes=col.trim();
    Assert.assertFalse(trimRes);
}
}
