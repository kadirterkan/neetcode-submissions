/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        int midd = (lo + hi) / 2;

        while (lo <= hi) {
            midd = lo + (hi - lo) / 2;
            int res = guess(midd);
            if (res < 0) {
                hi = midd - 1;
            } else if (res > 0) {
                lo = midd + 1;
            } else {
                return midd;
            }
        }
        return midd;
    }
}