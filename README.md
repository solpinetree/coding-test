* [제한 조건 보는 법](#제한-조건-보는-법)
* [접근 방법](#접근-방법)
* [Array](#array)
* [Linked List](#linked-list)
* [Queue](#queue)
* [Stack](#stack)
* [Hash Table & Dictionary](#hash-table--dictionary)

&nbsp;
&nbsp;
&nbsp;
&nbsp;



## 제한 조건 보는 법

> 시간복잡도(`Big-O`) 에 데이터의 크기(`n`)을 넣어서 나온 값이 **10^8 이 넘으면** 시간 제한을 초과할 가능성이 있음

> 즉, 제한 조건으로 내가 선택할 수 있는 알고리즘이 뭔지 확인할 수 있다.
- [1 <= n <= 10^5], [1 <= n <= 10^4]

	-> nlogn, n, logn, 1 으로 풀으라는 뜻
- [1 <= n <= 10^3]

	-> n^2 로 풀어도 됨
	

&nbsp;
&nbsp;

## 접근 방법

1.  직관적으로 생각하기
	- 보통 완전 탐색으로 시작
	- 문제 상황을 단순화하여 생각하기
	- 문제 상황을 극한화하여 생각하기
2. 자료구조와 알고리즘 활용
	- `문제이해` 에서 파악한 내용을 토대로 어떤 자료구조를 사용하는 게 가장 적합한지 결정
	- 대놓고 특정 자료구조와 알고리즘을 묻는 문제도 많음
	- 자료구조에 따라 선택할 수 있는 알고리즘을 문제에 적용


&nbsp;
&nbsp;

## Array
- `continuous`
	- 아무리 긴 배열이라도 한 번의 연산으로 원하는 데이터에 바로 접근할 수 있음. **O(1)의 시간복잡도**를 가짐.
- 4 bytes each
<details>
<summary> 이용했던 문제들 </summary>

* [1472-design-browser-history](https://github.com/solpinetree/algorithm-py/blob/667efd53deba8b2131502e8062aaaf07037c21da/1472-design-browser-history/1472-design-browser-history.py)

</details>


&nbsp;
&nbsp;


## Linked List
- `discontinous`
	- **O(n)의 시간복잡도**
- 중간에 데이터를 추가/삭제할 때 용이함
- 8 bytes each [ key + value = node ]

<details>
<summary> 기본 코드 </summary>

```python
class Node(object): 
	def __init__(self, value): 
		self.value = value 
		self.next = None 
class LinkedList(object): 
	def __init__(self): 
		self.head = None 
		self.tail = None 
	def append(self, value): 
		new_node = Node(value) 
		if self.haed is None: 
			self.head = new_node 
			self.tail = new_node 
		else: 
			self.tail.next = new_node 
			self.tail = new_node 
	def get(self, idx): 
		current = self.head 
		for _ in range(idx): 
			current = current.next 
		return current.value 
	def insert_at(idx, value): 
		new_node = Node(value) 
		current = self.head 
		for _ in range(idx): 
			current = current.next 
		new_node.next = current.next 
		current.next = new_node
```
</details>
<details>
<summary> 이용했던 문제들 </summary>

* [1472-design-browser-history](https://github.com/solpinetree/algorithm-py/blob/3c558ed237ed75e6ee0e10a1f1c0578bfffde55f/1472-design-browser-history/1472-design-browser-history.py)

</details>


&nbsp;
&nbsp;



## Queue
- python의 `deque` 는 `Linked List` 로 구현되어 있기 때문에, `List`로 구현된 queue와 달리 **enqueue**, **dequeue** 의 시간복잡도 모두 O(1) 이다.
- `deque` = doubly ended queue
- **`BFS`** 에서 많이 쓰임
<details>
<summary> 기본 코드</summary>

```python
from collections import deque
queue = deque()
queue.append(1)
queue.popleft()
```
</details>

<details>
<summary> 이용했던 문제들 </summary>



</details>


&nbsp;
&nbsp;

## Stack
<details>
<summary> 기본 코드</summary>

```python
stack = []
# push O(1)
stack.append(1)
# pop O(1)
stack.pop()
```
</details>

<details>
<summary> 이용했던 문제들 </summary>

* [0020-valid-parentheses](0020-valid-parentheses/0020-valid-parentheses.py)



</details>

&nbsp;
&nbsp;

## Hash Table & Dictionary

* 저장, 삭제, 검색의 시간복잡도는 모두 O(1)
* 파이썬에서 hash table은 딕셔너리로 구현되어 있음

<details>
<summary> 이용했던 문제들 </summary>

* [0001-two-sum](0001-two-sum/0001-two-sum.py)
* [0128-longest-consecutive-sequence](0128-longest-consecutive-sequence/0128-longest-consecutive-sequence.py)


</details>

&nbsp;
&nbsp;


