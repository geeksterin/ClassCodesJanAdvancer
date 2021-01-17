
[a1, a2, a3, ..........]
Problem statement -
Q queries
indices -> l, r
0 < l < r < length of array
0 < Q <= 10 ^ 5
0 < A <= 10 ^ 7

Output -> sum between indices l and r

a[l] + a[l + 1] + a[l + 2] + .... a[r]



original_array[] = 4 3 -1 5 6
prefix_sum_index =  0  1    2            3            4
prefix_sum_array[] = 4 (4+3) (4+3+(-1)) (4+3+(-1)+5) (4+3+(-1)+5+6)

Q -> 2 to 3
pref_sum[3] - pref_sum[2 - 1]
Q l and r -> prefix_sum_array[r] - prefix_sum_array[l - 1] -> O(1)



input Q -> 4
1 2 -> 2
1 5 -> 13
0 0 -> 4
0 n-1 ->

Complexity -> O(Q * N) -> 10 ^ 12 / 10 ^ 8 -> 10 ^ 4 seconds -> hours


Time complexity -> O(Q * 1) -> O(Q)
Space complexity -> O(N)



Time complexity -> O(max(Q, N))


-------------------------------------


Time complexity

Sigma of all the computations -
N * N -> input -> O(N * N)
N * N * N * N -> intermediate op => O(N ^ 4)
N * N -> printing the output -> O(N * N)

Computations will be => O(N^2) + N^4 + N^2 => O(N^4)


Summarise -> optimize the time complexities ->
1. Algorithm/logical flow
2. Improve the data structure chosen
3. Try to precompute and hold the data in separate data structure -> increase in space complexity

dp[n] = dp[n-1] + dp[n-2];




--------------------------------

Stack -> DS -> 1 2 3 4 -> LIFO
Stack top -> 4
push -> insert the element
pop -> delete the last inserted element
top/peek -> last inserted element
Example -> recursion stack

Queue -> DS -> 1 2 3 4 -> FIFO
push -> insert an element
pop -> delete the front element
front -> first element in the queue
Example -> Caching system, Railway ticketing system


Stack ->
insert -> 1 -> stack -> 1 -> peek -> 1
insert -> 2 -> stack -> 1 2 -> peek -> 2
insert -> 3 -> stack -> 1 2 3 -> peek ->3
pop -> stack -> 1 2
peek -> 2


Queue ->
insert -> 1 -> Queue -> 1  -> front -> 1
insert -> 2 -> Queue -> 1 2  -> front -> 1
insert -> 3 -> Queue -> 1 2 3  -> front ->1
pop -> Queue -> 2 3
front -> 2

