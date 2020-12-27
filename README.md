# geek_time
1.实现一个特殊的栈，在实现栈的基础功能的基础上，再实现返回栈中最小元素的操作，要求：
   * pop、push、getMin操作的实践复杂度都是O(1)
   * 实现的栈类型可以使用线程的栈结构
   
2.编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）

3.一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别是5、4、3、2、1，将这个栈转置后，从栈顶到栈底为1、2、3、4、5,也就是实现栈中元素的逆序
但是只能用递归函数来实现，不能用其他数据结构。

4.实现一种猫狗队列的结构，要求如下：
* 用户可以调用add方法将cat类或dog类的实例放入队列中
* 用户可以调用pollAll方法，将队列所有的实例按照队列的先后顺序依次弹出
* 用户可以调用pollDog 方法，将队列中dog类的实例按照队列的先后顺序依次弹出
* 用户可以调用pollCat 方法，将队列中cat类的实例按照队列的先后顺序依次弹出
* 用户可以调用isEmpty 方法，检查队列中是否还有dog或cat的实例
* 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例
* 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例

4.用一个栈实现另一个栈的排序
一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。
如何完成排序？

5.用栈求解汉诺塔问题，限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。求当塔有N层时，打印最优移动
过程和最优移动总步数。要求：
* 方法一：递归的方法
* 方法二：非递归的方法，用栈来模拟汉诺塔的三个塔

6.有一个整型数组arr和一个大小为w的窗口从数组的最左边滑倒最右边，窗口每次向右边滑一个位置。如果数组长度为n，窗口大小为w，则一共产生n-w+1个
窗口的最大值。实现一个函数：
* 输入：整型数组arr，窗口大小为w
* 输出：一个长度为n-w+1的数组res，res[i] 表示每一种窗口状态下的最大值。

7.定义二叉树节点如下:
```java
public class Node {
    public int value;
    public Node left;
    public Node right;
    
    public Node(int data) {
        this.value = data;
    }
}
```
一个数组的MaxTree定义如下。
* 数组必须没有重复元素
* MaxTree是一棵二叉树，数组的每一个值对应一个二叉树节点。
* 包括MaxTree数在内且在其中的每一个子数上，值最大的节点都是树的头。
给定一个没有重复元素的数组arr,写出生成这个数组的MaxTree的函数，要求如果数组长度N，则时间复杂度为O(N)、额外空间复杂度为O(N)。