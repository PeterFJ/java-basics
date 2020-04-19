package site.fengjian.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * 文档：https://www.cnblogs.com/Ming8006/p/6297333.html#c1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    private List mockList;

    public MockitoTest() {
        // 加注解或者使用下面初始化方法
        //MockitoAnnotations.initMocks(this);
    }

    /**
     * 2.1 验证行为
     */
    @Test
    public void verify_behaviour(){
        //模拟创建一个List对象
        List<String> mock = mock(List.class);
        //使用mock的对象
        mock.add("1");
        mock.get(1);
        mock.get(2);
        mock.clear();
        //验证add(1)和clear()行为是否发生
        verify(mock).add(argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(Object argument) {
                assertNotNull(argument);
                return ((String) argument).equals("1");
            }
        }));
        verify(mock).clear();
        verify(mock, times(2)).get(anyInt());
    }

    /**
     * 2.2 模拟我们所期望的结果
     */
    @Test
    public void when_thenReturn(){
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(iterator.next()).thenReturn("hello").thenReturn("world").thenReturn("world1");
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        System.out.println(result);
        //验证结果
        assertEquals("hello world world1",result);
    }

    /**
     * 2.3 RETURNS_SMART_NULLS和RETURNS_DEEP_STUBS
     *
     * RETURNS_SMART_NULLS实现了Answer接口的对象，它是创建mock对象时的一个可选参数，mock(Class,Answer)。
     * 在创建mock对象时，有的方法我们没有进行stubbing，所以调用时会放回Null这样在进行操作是很可能抛出NullPointerException。
     * 如果通过RETURNS_SMART_NULLS参数创建的mock对象在没有调用stubbed方法时会返回SmartNull。例如：返回类型是String，
     * 会返回"";是int，会返回0；是List，会返回空的List。另外，在控制台窗口中可以看到SmartNull的友好提示。
     */
    @Test
    public void returnsSmartNullsTest() {
        List mock = mock(List.class, RETURNS_SMART_NULLS);
        System.out.println(mock.get(0));

        //使用RETURNS_SMART_NULLS参数创建的mock对象，
        // 不会抛出NullPointerException异常。
        // 另外控制台窗口会提示信息“SmartNull returned by unstubbed get() method on mock”
        System.out.println(mock.toArray().length);
    }

    /**
     * 2.4 模拟方法体抛出异常
     */
    @Test(expected = RuntimeException.class)
    public void doThrow_when(){
        List list = mock(List.class);
        System.out.println(list);
        doThrow(new RuntimeException()).when(list).add(1);
        list.add(1);
        System.out.println(list);
    }

    /**
     * 2.5 使用注解来快速模拟，必须初始化（构造器中）
     * 在上面的测试中我们在每个测试方法里都mock了一个List对象，为了避免重复的mock，是测试类更具有可读性，我们可以使用下面的注解方式来快速模拟对象：
     *  @Mock
     *  private List mockList;
     */
    @Test
    public void shorthand(){
        mockList.add(1);
        verify(mockList).add(1);
    }

    /**
     * 2.5 或者使用built-in runner：MockitoJUnitRunner
     * @RunWith(MockitoJUnitRunner.class)
     */

    /**
     * 2.6 参数匹配
     */
    @Test
    public void with_arguments(){
        Comparable comparable = mock(Comparable.class);
        //预设根据不同的参数返回不同的结果
        when(comparable.compareTo("Test")).thenReturn(1);
        when(comparable.compareTo("Omg")).thenReturn(2);
        assertEquals(1, comparable.compareTo("Test"));
        assertEquals(2, comparable.compareTo("Omg"));
        //对于没有预设的情况会返回默认值
        assertEquals(0, comparable.compareTo("Not stub"));
    }

    /**
     * 2.6 除了匹配制定参数外，还可以匹配自己想要的任意参数
     */
    @Test
    public void with_unspecified_arguments(){
        List list = mock(List.class);
        //匹配任意参数
        when(list.get(anyInt())).thenReturn(1);
        when(list.contains(argThat(new IsValid()))).thenReturn(true);
        assertEquals(1, list.get(1));
        assertEquals(1, list.get(999));
        assertTrue(list.contains(2));
        assertTrue(!list.contains(3));
    }

    private class IsValid extends ArgumentMatcher<List> {
        @Override
        public boolean matches(Object o) {
            return (int)o == 1 || (int)o == 2;
        }
    }

    private class IsNumber extends ArgumentMatcher<Integer> {
        @Override
        public boolean matches(Object o) {
            return (Integer)o == 1 || (Integer)o == 2;
        }
    }



}
