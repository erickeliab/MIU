 ## Method: Using a Hash Set
Initialize a Hash Set: Create an empty hash set (e.g., HashSet in Java).

Iterate Through the Sequence: Traverse each element in the sequence
𝑆
S.

Check and Insert Elements:

For each element
𝑥
x in the sequence:
Check if
𝑥
x is in the Hash Set: If
𝑥
x is already present in the hash set, it means
𝑥
x is a duplicate, and you can immediately return true.
Insert
𝑥
x into the Hash Set: If
𝑥
x is not in the hash set, add
𝑥
x to the hash set.
Completion: If the loop completes without finding any duplicates, return false.

```java

public boolean containsDuplicate(int[] S) {
    Set<Integer> set = new HashSet<>();
    for (int x : S) {
        if (set.contains(x)) {
            return true; // Duplicate found
        }
        set.add(x);
    }
    return false; // No duplicates found
}
```

Therefore, the total running time of this method is:
𝑂
(
𝑛
)
O(n)