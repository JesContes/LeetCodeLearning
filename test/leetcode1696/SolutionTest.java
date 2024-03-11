package leetcode1696;

import com.company.leetcode1696.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/2/5
 */
public class SolutionTest {

    @Test
    public void maxResult() {
        int[] nums = new int[]{1,-1,-2,4,-7,3};
        int k = 2;
        Solution solution = new Solution();
        int result = solution.maxResult(nums, k);
        assertEquals(7, result);
    }
}