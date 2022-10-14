import org.junit.Test;


public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an","egg", "have", "i"};

        Sort.sort(input);
        org.junit.Assert.assertEquals(expected, input);

        if (!java.util.Arrays.equals(input,expected)) {
            System.out.println(("Error! There seems to be a problem with Sort.sort"));
        }
    }


    /** Test */
    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input,0);
        org.junit.Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;

        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input,a,b);
        org.junit.Assert.assertEquals(expected, input);
    }
//    public static void main(String[] args) {
//        testSort();
//
//    }
}

