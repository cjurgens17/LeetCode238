import static org.junit.Assert.*;

public class LC238Test {

    @org.junit.Test
    public void productExceptSelf() {
        int[] actual1 = LC238.productExceptSelf(new int[] {1,2,3,4});
        int[] actual2 = LC238.productExceptSelf(new int[] {-1,1,0,-3,3});

        assertArrayEquals(new int[] {24,12,8,6},actual1);
        assertArrayEquals(new int[] {0,0,9,0,0}, actual2);
    }

    @org.junit.Test
    public void optimalProductExceptSelf() {

        int[] actual1 = LC238.optimalProductExceptSelf(new int[] {1,2,3,4});
        int[] actual2 = LC238.optimalProductExceptSelf(new int[] {-1,1,0,-3,3});

        assertArrayEquals(new int[] {24, 12, 8, 6}, actual1);
        assertArrayEquals(new int[] {0, 0, 9, 0, 0},actual2);
    }
}