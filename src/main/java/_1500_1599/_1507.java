package _1500_1599;

/**  
 * @ClassName: _1507  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年7月28日  
 *  
 */
public class _1507 {

    class Solution {
        public String reformatDate(String date) {
            String[]      temp = date.split(" ");

            StringBuilder sb   = new StringBuilder(10);

            sb.append(temp[2]).append('-');

            switch (temp[1]) {
                case "Jan":
                    sb.append("01-");
                    break;
                case "Feb":
                    sb.append("02-");
                    break;
                case "Mar":
                    sb.append("03-");
                    break;
                case "Apr":
                    sb.append("04-");
                    break;
                case "May":
                    sb.append("05-");
                    break;
                case "Jun":
                    sb.append("06-");
                    break;
                case "Jul":
                    sb.append("07-");
                    break;
                case "Aug":
                    sb.append("08-");
                    break;
                case "Sep":
                    sb.append("09-");
                    break;
                case "Oct":
                    sb.append("10-");
                    break;
                case "Nov":
                    sb.append("11-");
                    break;
                case "Dec":
                    sb.append("12-");
                    break;
            }

            char c = temp[0].charAt(1);
            if (c >= '0' && c <= '9') {
                sb.append(temp[0].substring(0, 2));
            } else {
                sb.append(0).append(temp[0].charAt(0));
            }

            return sb.toString();
        }
    }

}
