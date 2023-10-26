package redo.Util.ag.array2D;

/**  
 * @ClassName: CountAll1SubMatrix  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class CountAll1SubMatrix {
    // 写题解

    /*
     * P1504
     * 
     * 此问题是在只包含0和1的矩阵中找到所有只包含1的子矩阵的数量
     * 
     * 暴力是肯定不能暴力的，暴力的复杂度高达O(n^6)，对于任何一些稍微大一点的n都过不了
     * 
     * 基础的思想是统计行前缀，不过这个和一般的前缀和略有区别，
     * 对于010011101110这样的行，统计出来的前缀为010012301230，
     * 就是一个数向左边扩展，直到遇到0，计算该段的长度
     * 
     * 得到了行前缀之后我们能干什么呢？
     * 
     * 以如下的行前缀为例
     * 123
     * 123
     * 123
     * 
     * 这是一个全1的矩阵产生的行前缀（()表示当前考察的范围， |右边的唯一的数，表示当前遍历到的值）
     * 我们首先考量最左上角的矩阵
     * (|1) 其表示自身为1，因此sum+=1
     * 
     * 然后向右遍历
     * (1|2) 其表示其和其左边，最大能延长到2长度的矩阵，
     * 这个长度也表示包括2的所有不为0的子矩阵的数量，以本步骤为例，有12和2两个子矩阵
     * 因为有两个子矩阵，因此sum+=2
     * 
     * 然后继续向右遍历
     * (12|3) 和第二步同理，3表示包含3的3种不同的子矩阵，因此sum+=3
     * 
     * 然后我们遍历第二行
     *   1
     * (|1) 第二行需要考虑之前的行的值，这是因为不仅可以向左扩展，还可以向上扩展
     * 当前遍历到的值为1，因此sum+=1
     * 
     * 然后我们考虑上一行的值
     * (|1) 
     * (|1) 这个1又表示什么呢，其表示其左边最大能扩展的长度，由于避免重复，因此每次都
     * 必须包含的值为最右下角的值，那么需要包含右下角的最大的子矩阵是什么？
     * 就是每一行的大小的最小值乘以行数所表示的矩阵，对于现在的例子来说，
     * 最大的那个矩阵，因为其无法向左继续扩展，因此sum+=1
     * 
     * 然后向右遍历
     *  1 2
     * (1|2)这个2表示什么，就是其能向左边扩展的数量，因此sum+=2
     * 
     * 然后考虑上一行
     * (1|2*)
     * (1|2) 此处的2*需要和刚刚的那一行的2取最小值，因此最小值为2，
     * 这个2表示什么呢？
     * 1    11
     * 1 和  11 这两个矩阵，因此sum+=2
     * 
     * 后面就不再赘述，都是一样的了，因此以一个不一样的例子为例
     *  01 1
     * (12|3) 此处的矩阵为例，3表示可以向左扩展3次，因此sum+=3
     * 
     * 但是考虑上一行
     * (01|1)
     * (12|3)时，为什么要在1和3中取最小值呢？
     * 
     * 考虑原矩阵
     * 011
     * 111 包含右下角的1的所有子矩阵有哪些？如果只考虑第二行，那么有3种，1，11，111
     * 如果包括第一行和第二行有哪些？
     * 1   11           011 
     * 1 和11 但是不包括 111 因为这样就包括0了，因此取最小值是为了保证矩阵中不包含任何0
     * 
     * 因此计算过程如下代码
     * for(int i=0;i<m;++i){
     *    for(int j=0;j<n;++j){
     *        sum+=pre[i][j];
     *        min=pre[i][j];
     *        for(int k=i-1;k>=0;--k){
     *            min=Math.min(min,pre[k][j]);
     *            sum+=min;
     *        }
     *    }
     * }
     * 
     * 但是这并不是最好的，这个复杂度高达O(n^2*m)
     * 
     * 主要是以下的这个求最小值的过程比较浪费，我们可以使用单调栈来简化这个计算过程
     * for(int k=i-1;k>=0;--k){
     *     min=Math.min(min,pre[k][j]);
     *     sum+=min;
     * }
     * 以如下一个矩阵为例
     * 0010    0010
     * 1111 => 1234
     * 0111    0123
     * 1010    1010
     * 
     * 此时遍历顺序改变了，我们每次遍历一列，而不再是一行
     * 
     * 我们还需要定义单调栈的结构，(行长，列高)，每遍历新的一个值pre[i][j]时，压入(pre[i][j],1)
     * 当新压入的元素有更短(相等)的行长的时候，将栈中元素抛出，并令new.列高+=old.列高
     * 
     * 并且还有一个列上的每行有效总和sumCol，每当有新元素压入的时候，令sumCol+=new.行长
     * 每当有元素抛出的时候，令sumCol-=(old.行长-new.行长)*old.列高
    
     * 为了快速演示遍历过程，我们只考虑第三列的情况
     * 
     * 首先我们遍历到001，此处只有一个1，因此我们，将其压入栈中(1,1)
     * sumCol+=1,ans+=sumCol 
     * 
     * 然后我们遍历到123，此处为3，因此压入(3,1)，由于3>1，因此我们不弹出元素
     * sumCol+=3,ans+=sumCol
     * 
     * 此处的sumCol表示什么呢，就是能向左和上扩展的所有矩阵的数量
     *              1 
     * 4 = 111 11 1 1 四个矩阵
     * 
     * 然后我们遍历到012，此处变为2，因此压入(2,1)，由于2<3，因此弹出(3,1)
     * 进行列高更新，令(2,1)=>(2,2)，令sumCol-=(3-2)*1
     * 然后sumCol+=2,ans+=sumCol
     * 
     * 此处的sumCol表示什么呢，而且为什么在弹出元素的时候必须减少一定值?
     * 如果我们不更新sumCol，那么其为
     * 6 = 1 + 3 + 2
     *     1       
     *     1       111  11  1
     * 1 = 1 , 3 = 011  11  1 , 2 = 11  1
     * 
     * 我们明显的发现由于3>2时，由于2不够长，会导致不能向上兼容最大的那个矩阵
     * 因此我们需要减去这个值，这个值是由于左下角包含0而不能计算的矩阵
     * 
     * 通过单调栈压缩，我们能将这个遍历过程压缩到O(n*m)的时间复杂度，已经很好了
     * 
     * 
     * 
     */
}