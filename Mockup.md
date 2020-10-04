## 1.Draw the adjacency matrix and adjacency list from the given undirected graph
<img src="https://github.com/GGolfz/JustAnAlgorithm/blob/master/images/graph.png">
V = [1,2,3,4,5,6]

### Adjacency Matrix

|   | 1 | 2 | 3 | 4 | 5 | 6 |
|---|---|---|---|---|---|---|
| 1 | 0 | 1 | 0 | 0 | 1 | 0 |
| 2 | 1 | 0 | 1 | 0 | 1 | 0 |
| 3 | 0 | 1 | 0 | 1 | 0 | 0 |
| 4 | 0 | 0 | 1 | 0 | 1 | 1 |
| 5 | 1 | 1 | 0 | 1 | 0 | 0 |
| 6 | 0 | 0 | 0 | 1 | 0 | 0 |

### Adjacency List
| V |    E    |
|---|---------|
| 1 | > 2 > 5 |
| 2 | > 1 > 3 > 5 |
| 3 | > 2 > 4 |
| 4 | > 3 > 5 > 6 |
| 5 | > 1 > 2 > 4 |
| 6 | > 4 |
## 2.How many edges of the complete graph?
Ans: (n * (n-1))/2 <br/>
Since each node need to connected to all other node so first node will connect to (n-1) nodes, second node will connect to (n-2) nodes and continue do this until the last node that don't need to connect to other because all other node already connect to it so the edge will be (n-1) + (n-2) + (n-3) + ... + 0 which is (0+n-1) * (n)/2 = ((n) * (n-1))/2

## 3.What is a tree and a binary search tree?
Ans :  <br/>
Tree is acyclic graph that has the edge is vertex - 1 <br/>
Binary Search Tree is the tree that the value of parent more than any node of left sub tree and less than and equal any node of right sub tree.

## 4.Write the pseudo code of selection sort and what is the basic operation of this algorithm. Also identify the Big-O, Big-Theta, Big-Omega.

```
ALGORITHM SelectionSort(A[0..n-1])
// Input: Array of Integer
// Output: Sorted Array of Integer in ascending order
for i <- 0 to n - 2 do
    min <- i
    for j <- i+1 to n - 1 do
        if A[j] < A[min] 
           min <- j
    temp <- A[i]
    A[i] <- A[min]
    A[min] <- temp
return A
```

The basic operation is compare the element to find minimum value <br/>

f(n) = <img src="https://render.githubusercontent.com/render/math?math=\sum_{i=0}^{n-2} \sum_{j=i %2B 1}^{n-1} 1"> <br/>
Big-O = <img src="https://render.githubusercontent.com/render/math?math=O(n^2)"> <br/>
Big-Omega = <img src="https://render.githubusercontent.com/render/math?math=\Omega(n^2)"> <br/>
Big-Theta = <img src="https://render.githubusercontent.com/render/math?math=\Theta(n^2)"> <br/>

## 5.Show the process of using euclid’s algorithm to calculate gcd(46,18) and also tell the Big-O.

```
gcd(46, 18) = gcd(18, 46 % 18)
            = gcd(18, 10)
            = gcd(10, 18 % 10)
            = gcd(10, 8)
            = gcd(8, 10 % 8)
            = gcd(8, 2)
            = gcd(2, 0)
            = 2
```
Big-O :

```
log(max(a,b)) = log(n)
```



## 6.What are three operations of dictionaries? 

Ans : <br/>
1. Search item <br/>
2. Add new item <br/>
3. Remove item <br/>

## 7.What is the average case in terms of complexity analysis? 

Ans : <br/>
The average over inputs of size n that depend on the probability distribution of all possible inputs. Not the average of worst case and best case 

## 8.T(n) = (log n base 2)+1, How much longer will the algorithm run if the input size is 16 times bigger (N = 16n)
```
T(n) = (lg n) + 1
T(16n)  = (lg (16n)) + 1
        = (lg (n) + lg(16)) + 1
        = lg(n) + 4 + 1
        = lg(n) + 5
```
So when input size is 16 times bigger this algorithm T(n) will run more 4 round.

## 9.f(n) = 3n^2+log n+5 Prove that f(n) is a member of Big-Theta(n^2)

```
f(n) = 3n^2 + log(n) + 5
```
Find Big-O
```
3n^2 + log(n) + 5 <= 3n^2 + n^2 + 5n^2 ; n >= 1
3n^2 + log(n) + 5 <= 9n^2 ; n >= 1
```
Then <img src="https://render.githubusercontent.com/render/math?math=O(n^2)">

Find Big-Omega
```
3n^2 + log(n) + 5 >= n^2 ; n >= 1
```
Then <img src="https://render.githubusercontent.com/render/math?math=\Omega(n^2)">

Since Big-O equals Big-Omega (<img src="https://render.githubusercontent.com/render/math?math=O(n^2)=\Omega(n^2)">) Then Big-Theta = <img src="https://render.githubusercontent.com/render/math?math=\Theta(n^2)">

## 10.Find Big-O of the following code.For example, The main method will call solve({3,5,3,10,2},{4,3,2,7,1},10,4)

<img src="https://github.com/GGolfz/JustAnAlgorithm/blob/master/images/code.png">
```
T(n)	= T(n-1)+T(n-1)+1
			= 2T(n-1)+1
			= 2*(2T(n-2)+1)+1 = 2^2*T(n-2)+2+1
			= 2^2*(2T(n-3)+1)+2+1 = 2^3*T(n-3)+4+2+1
			...
			= 2^(n-1)*T(n-(n-1))+(2^0+2^1+2^2+...+2^n-2)
			= 2^(n-1)*T(1)+(((2^n-2)*2-1)/2-1)
			= 2^(n-1)*1+(2^(n-1)-1)
			= (2^n)-1
```

## 11.f(n) = log1+log2+log3+...+logn. Prove that f(n) is a member of O(nlogn).

```
f(n) 	= log1+log2+log3+...+logn
			= log(1*2*3*4*...*n)
			= log(n!)
log(n!) <= log(n^n)
f(n) <= log(n^n)
f(n) <= nlogn
so, f(n) is a member of O(nlogn)
```

## 12.Write the pseudo code of merge sort.

```
mergeSort(A[0...n],L,R){
	int mid = (L+R)/2;
	if(L >= R) return; //we can stop when there is only one element in array
	mergeSort(A,L,mid);
	mergeSort(A,mid+1,R);
	combine(A,L,mid,R);
}
combine(A,left,mid,right){
	L = [],R = [];
	int n1 = mid-left+1;
	//copy array to left array
	for(int k=0;k<n1;k++) L.push(A[i+left])
	int n2 = right-mid;
	//copy array ti right array
	for(int k=0;k<n2;k++) R.push(A[mid+i+1]);
	int i = 0,j = 0,k = l;
	while(i < n1 && j < n2){
		if(L[i] <= R[j]) arr[k++] = L[i++]
		else arr[k++] = R[j++]
	}
	while(i < n1) arr[k++] = L[i++]
	while(j < n2) arr[k++] = R[j++]
}
```



## 13.You are given the sorted array with size of 1000, if you want to determine that the value X is in this array or not by using binary search. What is the number of times you have to compare the value?

Ans : ` ⌈log (1001) base 2⌉ = 10`

## 14. T(n) = 3T(n-1)+2, n >0; T(1) = 4. Solve this recurrence
```
T(n)    = 3T(n-1) + 2
        = 3(3T(n-2) + 2) + 2
        = (3^2)T(n-2) + (3*2) + 2
        = (3^2)(3*T(n-3) + 2) + (3*2) + 2
        = (3^3)T(n-3) + (3^2 * 2) + (3^1 * 2) + (3^0 * 2)
        = 3^(n-1)T(n-(n-1)) + 2*(sum i=0 to i=n-2 3^i)
        = 3^(n-1)*4 + 2*(1+3+9+..+3^(n-2))
        = 3^(n-1)*4 + 2*((3^(n-2)-1)/2)
```
## 15. T(n) = 4T(n/2)+n^5. Find Big-Theta of T(n)

Ans :
From Master Theorem a = 4 b = 2 d = 5
4 < 2^5 => T(n) is <img src="https://render.githubusercontent.com/render/math?math=\Theta(n^d)"> => <img src="https://render.githubusercontent.com/render/math?math=\Theta(n^5)">

## 16.find Big-O of the following code.
```
int ans = 0;
for(int i=1;i<=n;i++){
	for(int j=1;j<=i*i;j++){
		ans+=j;
    }
}
```
<img src="https://render.githubusercontent.com/render/math?math=f(n) = \sum_{i=1}^{n} \sum_{j=1}^{i*i} 1"> <br/>
<img src="https://render.githubusercontent.com/render/math?math=f(n) = 1^2 %2B 2^2 %2B 3^2 %2B ... %2B n^2"> <br/>
<img src="https://render.githubusercontent.com/render/math?math=f(n) = (n*(n %2B 1)*(2n %2B 1))/6"> <br/>
<img src="https://render.githubusercontent.com/render/math?math=f(n) = O(n^3)"> <br/>

## 17.Is the following statement is true?

### 1.Convex set is a set of points that any two points P,Q of set belong to the convex set.
Ans : False, It must be set of line PQ
### 2.Convex hull is the smallest convex.
Ans : True

## 18.What scenario makes the quick sort to be the worst case
Ans : The Pivot is the smallest or largest number so the partition will not divide into two part and the big O will become n^2

## 19.What is convex and convex hull?
Ans : <br/>
Convex : A set of points (finite or infinite) in the plane is called convex if for any two points P and Q in the set, the entire line segment with the end points at P and Q belongs to the set. (Curving out)<br/>
Convex Hull : A set of n points in the plane which is the smallest convex polygon that contains all of point inside or on boundary.<br/>

## 20.Define the recurrence of the smallest number of times to move n dishes to complete the tower of hanoi problem
```
M(1)    = 1
M(n)    = M(n-1) + 1 + M(n-1)
        = 2M(n-1) + 1
        = 2(2M(n-2)+1) + 1
        = 4M(n-2) + 2 + 1
        = 4(2M(n-3)+1) + 2 + 1
        = 8M(n-3) + 4 + 2 + 1
        = 2^(n-1)M(n-(n-1)) + (sum i = 0 to n-2 2^i)
        = 2^(n-1)M(1) + (2^(n-1)- 1 )
        = 2^(n-1) + 2^(n-1) - 1
        = 2*(2^n-1) - 1
        = 2^n - 1
```
## 21.Explain why the number of points in the box with size of d*2d in the closest pair algorithm will not exceed 8.

When we divide d * 2d block into 8 (d/2 * d/2) blocks we will know that each block can have only 1 point because if it have more than one point the first assumption when we create d block where d is the smallest distance from min(d1,d2) will be wrong so each block must have only 1 point inside. Then d * 2d block of convex hull will have at most 8 points.
<img src="https://github.com/GGolfz/JustAnAlgorithm/blob/master/images/pigeon.jpeg">

## 22.Write the pseudo code to find the convex hull from the set of N points.

```java
import java.util.Scanner;

public class ConvexHull{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point p = new Point(x,y);
            points[i] = p;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int left=0, right = 0;
                Point p1 = points[i];
                Point p2 = points[j];
                for(int k=0;k<n;k++){
                    if(k == i || k == j) continue;
                    Point p3 = points[k];
                    float a = p2.y-p1.y;
                    float b = p1.x-p2.x;
                    float c = p1.x*p2.y-p2.x*p1.y;
                    if(p3.x*a+p3.y*b <= c){
                        left++;
                    }
                    if(p3.x*a+p3.y*b > c){
                        right++;
                    }
                }
                if(left*right == 0){
                    System.out.println("("+p1.x+","+p1.y+"), ("+p2.x+","+p2.y+")");
                }
            }
        }
    }
}
class Point{
    int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
/*
8
0 30
15 25
20 0
30 60
70 30
55 20
50 10
50 40
*/
```



## 23.Find 3156 * 2512 by using multiplication of large number algorithms

```
3156 * 2512 = (31*25) * 10^4 + [(31+56) * (25+12) - (31*25) - (56*12) ] * 10^2 + (56*12) 
            = (31*25) * 10^4 + [(87 * 37) - (31*25) - (56 * 12)] * 10^2 + (56*12)

Find 31*25  = (3*2) * 10^2 + [(3+1)*(2+5) - (3*2) - (1*5)] * 10 + (1*5)
            = (3*2) * 10^2 + [(4*7) - (3*2) - (1*5)] * 10 + (1*5)
3*2 = 6
1*5 = 5
4*7 = 28
     31*25  = 6 * 10^2 + [28-6-5] * 10 + 5
            = 6 * 10^2 + 17 * 10 + 5
            = 775

Find 56*12  = (5*1) * 10^2 + [(5+6)*(1+2) - (5*1) - (6*2)] * 10 + (6*2)
            = (5*1) * 10^2 + [(11*3) - (5*1) - (6*2)] * 10 + (6*2)
5*1 = 5
6*2 = 12
11*3 = (1*0) * 10^2 + [(1+1)*(0+3) - (1*0) - (1*3)] * 10 + (1*3)
     = (1*0) * 10^2 + [(2*3) - (1*0) - (1*3)] * 10 + (1*3)
1*0 = 0
1*3 = 3
2*3 = 6
11*3 = 0 * 10^2 + [6 - 0 - 3] * 10 + 3
     = 33

     56*12  = 5 * 10^2 + [33 - 5 - 12] * 10 + 12
            = 5 * 10^2 + 16 * 10 + 12
            = 672
Find 87*37  = (8*3) * 10^2 + [(8+7)*(3+7) - (8*3) - (7*7)] * 10 + (7*7)
            = (8*3) * 10^2 + [(15*10) - (8*3) - (7*7)] * 10 + (7*7)
8*3 = 24
7*7 = 49
15*10 = (1*1) * 10^2 + [(1+5)*(1+0) - (1*1) - (5*0)] * 10 + (5*0)
      = (1*1) * 10^2 + [(6*1) - (1*1) - (5*0)] * 10 + (5*0)
1*1 = 1
5*0 = 0
6*1 = 6
15*10 = 1 * 10^2 + [6 - 1 - 0] * 10 + 0
      = 1 * 10^2 + 5 * 10 + 0
      = 150
     87*37  = 24 * 10^2 + [150 - 24 - 49] * 10 + 49
            = 24 * 10^2 + 77 * 10 + 49
            = 3219
3156 * 2512 = (31*25) * 10^4 + [(31+56) * (25+12) - (31*25) - (56*12) ] * 10^2 + (56*12) 
            = 775 * 10^4 + [3219 - 775 - 672] * 10^2 + 672
            = 775 * 10^4 + 1772 * 10^2 + 672
            = 7927872
```

## 24. Find the convex hull by using the quick hull algorithm from the given point. (Draw the picture) 
<img src="https://github.com/GGolfz/JustAnAlgorithm/blob/master/images/convex-hull.jpeg">

## 25. You are going to steal the gems in the jewelry shop. There are 5 gems in this store and each store has the value and weight which is (3,4), (5,3), (3,2), (10,7), (2,1) (weight is in kilograms unit). But your bag can contain at most 10 kilograms. What gems will you steal that you will get the most value.

| Steal | Weight | Value | Possible |
|-------|--------|-------|----------|
|1|3|4|Y|
|2|5|3|Y|
|3|2|7|Y|
|4|10|7|Y|
|5|2|1|Y|
|1,2|8|7|Y|
|1,3|5|11|N|
|1,4|13|11|N|
|1,5|5|5|Y|
|2,3|7|10|Y|
|2,4|15|10|Y|
|2,5|7|4|Y|
|3,4|12|14|N|
|3,5|4|8|Y|
|4,5|12|8|Y|
|1,2,3|10|14|N|
|1,2,4|18|14|N|
|1,2,5|10|8|Y|
|1,3,4|15|18|N|
|1,3,5|7|12|N|
|1,4,5|15|12|N|
|2,3,4|17|17|N|
|2,3,5|9|11|N|
|2,4,5|17|11|N|
|3,4,5|14|15|N|
|1,2,3,4|20|21|N|
|1,2,3,5|11|15|N|
|1,2,4,5|20|15|N|
|1,3,4,5|17|19|N|
|2,3,4,5|19|18|N|
|1,2,3,4,5|22|22|N|

Maximum Value = 15 (Steal 2 and 4)

## 26.Find the shortest distance of traveling to every node and go back to the starting node but you cannot travel to the same node except the start and end node from the given undirected graph. 
<img src="https://github.com/GGolfz/JustAnAlgorithm/blob/master/images/tsp.png">
| Directions | Distance |
|------------|----------|
|1 > 2 > 3 > 4 > 1|14|
|1 > 3 > 4 > 2 > 1|11|
|1 > 4 > 2 > 3 > 1|7|
|1 > 4 > 3 > 2 > 1|14|
|1 > 2 > 4 > 3 > 1|11|
|1 > 3 > 2 > 4 > 1|7|
|2 > 1 > 3 > 4 > 2|11|
|2 > 3 > 1 > 4 > 2|7|
|2 > 3 > 4 > 1 > 2|14|
|2 > 4 > 3 > 1 > 2|11|
|2 > 4 > 1 > 3 > 2|7|
|2 > 1 > 4 > 3 > 2|14|
|3 > 1 > 2 > 4 > 3|11|
|3 > 2 > 1 > 4 > 2|14|
|3 > 2 > 4 > 1 > 3|7|
|3 > 4 > 2 > 1 > 3|11|
|3 > 4 > 1 > 2 > 2|14|
|3 > 1 > 4 > 2 > 3|7|
|4 > 1 > 2 > 3 > 4|14|
|4 > 2 > 1 > 3 > 4|11|
|4 > 1 > 3 > 2 > 4|7|
|4 > 3 > 2 > 1 > 4|14|
|4 > 3 > 1 > 2 > 4|11|
|4 > 2 > 3 > 1 > 4|7|

Shortest Distance = 7
