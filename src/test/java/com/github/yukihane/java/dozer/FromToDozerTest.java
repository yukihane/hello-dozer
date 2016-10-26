package com.github.yukihane.java.dozer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.github.yukihane.java.dozer.from.FromChild;
import com.github.yukihane.java.dozer.from.FromParent;
import com.github.yukihane.java.dozer.to.ToChild;
import com.github.yukihane.java.dozer.to.ToParent;
import java.util.Arrays;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.junit.Test;

public class FromToDozerTest {

    /**
     * リスト内の要素が同一であった場合, 変換後も同一であることを確認.
     */
    @Test
    public void testMapList() {
        final DozerBeanMapper mapper = new DozerBeanMapper();

        final FromParent fromParent = new FromParent();
        final FromChild s1 = new FromChild("s1");
        final FromChild s3 = new FromChild("s3");
        final List <FromChild> children = Arrays.asList(s1, s1, s3);
        fromParent.setChildren(children);

        final ToParent res = mapper.map(fromParent, ToParent.class);

        assertEquals(3, res.getChildren().size());

        final ToChild d1 = res.getChildren().get(0);
        final ToChild d2 = res.getChildren().get(1);
        final ToChild d3 = res.getChildren().get(2);
        assertEquals("s1", d1.getName());
        assertEquals("s3", d3.getName());

        assertTrue("変換前が同一インスタンスの場合変換後も同一インスタンスになる", d1 == d2);
        assertTrue("異なるインスタンスは異なるインスタンスに", d1 != d3);

        final ToChild d4 = mapper.map(s3, ToChild.class);
        assertEquals("s3", d4.getName());
        assertTrue("異なるタイミングで変換すると, 同一srcインスタンス, 同一mapperインスタンスを使っても異なるインスタンスになる",
            d3 != d4);

        final ToParent res2 = mapper.map(fromParent, ToParent.class);
        assertTrue("再確認. 同一インスタンスでも異なるタイミングなら別インスタンスに変換", res != res2);
    }
}
